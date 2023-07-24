import java.util.Scanner;
class BankAccount{
    double bal;
    double prevTrans;
    String custname;
    String bankId;
    BankAccount(String custname,String bankId){
        this.custname=custname;
        this.bankId=bankId;
    }
    void deposit(double amount){
        if(amount!=0){
            bal+=amount;
            prevTrans=amount;
        }
        else 
        {
            System.out.println("The deposit amount should be greater than 0");
        }
    }
    void withdraw(double amt){
        if(amt!=0 && bal>=amt){
            bal-=amt;
            prevTrans=-amt;
        }
        else if(bal<amt){
            System.out.println("Bank balance insufficient");
        }
    }
    void getPreviousTrans(){
        if(prevTrans>0){
            System.out.println("Deposited: "+prevTrans);
        }
        else if(prevTrans<0){
            System.out.println("Withdrawn: "+Math.abs(prevTrans));
        }
        else{
            System.out.println("No transaction occured");
        }
    }
    void menu(){
        char option;
        Scanner sc=new Scanner(System.in);
        System.out.println();
        
        System.out.println("        Welcome     "+custname);
        System.out.println("        Your ID:    "+bankId);
        System.out.println("\n");
        while(true){
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Amount");
        System.out.println("3. Withdraw Amount");
        System.out.println("4. Previous Transaction");
        System.out.println("5. Exit");
            System.out.println("********************************************");
            System.out.println("Choose an option");
            option=sc.next().charAt(0);
            System.out.println();
            switch (option){
                case '1':
                    System.out.println();
                    System.out.println("####################################################");
                    System.out.println("Balance ="+bal);
                    System.out.println("\n");
                    break;
                case '2':
                    System.out.println();
                    System.out.println("####################################################");
                    System.out.println("Enter a amount to deposit :");
                    double amt=sc.nextDouble();
                    deposit(amt);
                    System.out.println("\n");
                    break;
                case '3':
                    System.out.println();
                   System.out.println("####################################################");
                    System.out.println("Enter a amount to Withdraw :");
                    double amtW=sc.nextDouble();
                    withdraw(amtW);
                    System.out.println("\n");
                    break;
                case '4':
                System.out.println();
                   System.out.println("####################################################");
                    System.out.println("Previous Transaction:");
                    getPreviousTrans();
                    System.out.println("\n");
                    break;

                case '5':
                    System.out.println("Thank you for using this bank service");
                    System.out.println("..........................");
                    System.exit(0);
                    break;
                default:
                    System.out.println("####################################################");
                    System.out.println("Invalid option");
                    System.out.println("Enter a valid option");
                    System.exit(0);
                    break;
            }

        }
    }
}
public class bankapp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++                                                                    +++");
        System.out.println("+++                      Simple Bank Software                          +++");
        System.out.println("+++                                                                    +++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Enter Customer name:");
        String name=sc.nextLine();
        System.out.println("Enter Bank Id");
        String bankId=sc.nextLine();
        BankAccount obj1=new BankAccount(name,bankId);
        obj1.menu();
    }
}
