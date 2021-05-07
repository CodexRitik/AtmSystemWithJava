import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.IntStream;

class PersonalDetail{
    String name,address,dob;
    int pincode,otp;
    long mobileNo,atmnumber,acnumber,balance;
    double depositMoney=0.0,debitedMoney=0.0;

    void displayDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Date : "+dtf.format(now));
    }
    void displayTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Time : "+dtf.format(now));
    }

    void personalData(){
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("                      *-Account Information-*                    ");
        displayDate();
        displayTime();
        System.out.println("Name : "+name+"       "+"D.O.B : "+dob);
        System.out.println("Account No. : "+acnumber);
        System.out.println("Balance : "+balance);
        System.out.println("ATM Card No. : "+atmnumber);
        System.out.println("Address : "+address+"       "+"Pin Code : "+pincode);
        System.out.println("Mobile No. : "+mobileNo);
        System.out.println("-------------------------------------------------------------------------------");

    }
    void currentBal(){
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("                   "+"*->Current Balance<-*"+"                   ");
        displayDate();
        displayTime();
        System.out.println("ATM No. : "+atmnumber);
        System.out.println("Current Balance : "+balance);
        System.out.println("-------------------------------------------------------------------------------");
    }
    void atmDisplay(){
        String[] arr = name.split("\\s");
        System.out.println("-------------------------------------------------------------------------------");
        displayDate();
        displayTime();
        System.out.println("               " + "*- Welcome "+arr[0]+"-*                     " );
        System.out.println("Account No. : "+acnumber);
        System.out.println("ATM Card No. : "+atmnumber);
        System.out.println("---------------------->>Your Card is Inserted!<<-------------------------------");
    }
    void creditSlip(){
        String[] arr = name.split("\\s");
        System.out.println("-------------------------------------------------------------------------------");
        displayDate();
        displayTime();
        System.out.println("                         " + "*- Dear "+arr[0]+"-*                            " );
        System.out.println("Account No. : "+acnumber);
        System.out.println("ATM Card No. : "+atmnumber);
        System.out.println("Initial Balance : "+balance);
        System.out.println("Current Balance :"+(balance+(long)depositMoney));
        System.out.println("--------------------------*-> Thanks For Using! <-*-----------------------------");
        balance+=(long)depositMoney;
    }
    void debitSlip(){
        String[] arr = name.split("\\s");
        System.out.println("-------------------------------------------------------------------------------");
        displayDate();
        displayTime();
        System.out.println("                      " + "*- Dear "+arr[0]+"-*                               " );
        System.out.println("Account No. : "+acnumber);
        System.out.println("ATM Card No. : "+atmnumber);
        System.out.println("Initial Balance : "+balance);
        System.out.println("Current Balance :"+(balance-(long)debitedMoney));
        System.out.println("--------------------------*-> Thanks For Using! <-*----------------------------");
        balance-=(long)debitedMoney;
    }

}
class Generator{
    int pass = otpGenerate();
    int otpGenerate(){
        int n =5,o=1,b=10;//otp creation using Stream
        Random val = new Random();
        IntStream otp = val.ints(n,o,b);
        int[] OTP = otp.toArray();
        String str = "";
        for (int r:OTP) {
            str+=String.valueOf(r);
        }
        return Integer.parseInt(str);
    }
    void otpDisplay(){
        System.out.println("Your One Time Password : "+pass);
    }
    long accountNumber(){
        int n1 =5,o1=1,b1=10;//otp creation using Stream
        Random val = new Random();
        IntStream otp = val.ints(n1,o1,b1);
        int[] OTP = otp.toArray();
        String str = "";
        for (int r:OTP) {
            str+=String.valueOf(r);
        }
        str=str+"00000";
        return Long.parseLong(str);
    }
    void accountDisplay(){
        System.out.println(accountNumber());
    }
}
class AtmCard{
    long atmcard = atmNumber();
    long atmNumber(){
        int n=12,o=1,b=10;
        Random val = new Random();
        IntStream atm = val.ints(n,o,b);
        int[] atmno = atm.toArray();
        String str = "";
        for (int v:atmno) {
            str+=String.valueOf(v);
        }
        return Long.parseLong(str);
    }
    void atmDisplay(){
        System.out.println(atmcard);
    }
}
public class AtmSystem {
    static void displayMsg(){
        System.out.println("Please Enter The Key!");
        System.out.println("1 -> Account Information");
        System.out.println("2 -> Current Balance");
        System.out.println("3 -> Deposit Money");
        System.out.println("4 -> Withdraw Money");
        System.out.println("5 -> Exit");
    }
    public static void main(String[] args) throws ParseException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        PersonalDetail data = new PersonalDetail();
        Generator val = new Generator();
        AtmCard atm = new AtmCard();
        System.out.println("         *- Welcome In Our ATM System -*        ");
        System.out.println("Please Enter Your Some Details:");
        System.out.println("Enter Your Name :");
        data.name = scan.nextLine();
        System.out.println("Enter Your Address:");
        data.address = scan.nextLine();
        System.out.println("Enter Your DOB in dd/MM/yyyy Format");
        String dates = scan.nextLine();
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dates);
        data.dob=date.toString();
        System.out.println("Enter Your Pin Code:");
        data.pincode = scan.nextInt();
        System.out.println("Enter Your Mobile No:");
        data.mobileNo = scan.nextLong();
        data.acnumber = val.accountNumber();
        data.atmnumber = atm.atmNumber();
        System.out.println("-----------------------------Thanks For Submission!---------------------------------");
        System.out.println("Please Wait!");
        Thread.sleep(15000);
        data.atmDisplay();
        System.out.println("Please Wait For Password!");
        Thread.sleep(12000);
        data.otp = val.pass;
        val.otpDisplay();
        int i =1;
        while(i>0) {
            System.out.println("For Start->Press '1' For Exit->Press '0'");
            int sel = scan.nextInt();
            switch (sel) {
                case 1:
                    System.out.print("Please Confirm Your Password : ");
                    int pass = scan.nextInt();
                    if (pass == data.otp) {
                        System.out.println("Password Matched!");
                        int j = 1;
                        while(j>0) {
                            System.out.println("For Menu Press 1 or For Exit Press 0");
                            int res = scan.nextInt();
                            switch (res) {
                                case 1:
                                    displayMsg();
                                    int sel1 = scan.nextInt();
                                    switch (sel1) {
                                        case 1:
                                            data.personalData();
                                            break;
                                        case 2:
                                            data.currentBal();
                                            break;
                                        case 3:
                                            System.out.print("Enter The Amount You Want To Deposit:");
                                            double money = scan.nextDouble();
                                            data.depositMoney = money;
                                            System.out.println("Money Deposited! Collect Your Slip!");
                                            data.creditSlip();
                                            break;
                                        case 4:
                                            System.out.print("Enter The Amount For Withdraw : ");
                                            long money1 = scan.nextLong();
                                            if(money1<=data.balance){
                                                data.debitedMoney=money1;
                                                System.out.println("Please Collect Your Cash and Slip!");
                                                data.debitSlip();
                                            }
                                            else{
                                                long res1 = money1- data.balance;
                                                System.out.println("Sorry, Your Account Balance is Low : "+res1+" Rupees!");
                                            }
                                        case 5:
                                            break;
                                    }
                                    break;
                                case 0:
                                    j = j - 1;
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Wrong Password! Try Again!");
                    }
                case 0:
                    System.out.println("                      "+"->>ATM Card Ejected<<-"+"                                 ");
                    System.out.println("--------------------------------Thanks For Using!----------------------------------");
                    i=i-1;
                    break;
            }
        }
    }
}
