package Tester;

import MainBank.Bank;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Bank[] banks=new Bank[50];
        int index=0;
        int choice,id,id2,amt;
        String name,acc;
        double bal;
        int duration;
        boolean flag,flag1;
        Bank b,sb = null,db;

        do{
            System.out.println("1.Create bank account");
            System.out.println("2.Display account details");
            System.out.println("3.Assign Locker");
            System.out.println("4.Check balance");
            System.out.println("5.Transfer money");
            System.out.println("6.Exit");
            choice= sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter A/C holder name :");
                    name=sc.nextLine();
                    System.out.println("Enter type of A/C  (Savings/Current):");
                    acc=sc.nextLine();
                    System.out.println("Deposit initial balance:");
                    bal=sc.nextDouble();
                    b=new Bank(name,acc,bal);
                    banks[index++]=b;
                    break;
                case 2:
                    for (int i=0;i<index;i++){
                        System.out.println(banks[i]);
                    }
                    break;
                case 3:
                    flag=false;
                    System.out.println("Enter account no:");
                    id=sc.nextInt();
                    for (int i=0;i<index;i++){
                        if(banks[i].getId()==id){
                            System.out.println("Enter duration for the locker :");
                            duration=sc.nextInt();
                            banks[i].assignLocker(duration);
                            System.out.println("Locker assigned.");
                            flag=true;
                            break;
                        }
                    }
                    if (!flag){
                        System.out.println("Account not found!");
                    }

                    break;
                case 4:
                    flag=false;
                    System.out.println("Enter account no :");
                    id=sc.nextInt();
                    for (int i=0;i<index;i++){
                        if (banks[i].getId()==id){
                            flag=true;
                            System.out.println("Account holder: "+banks[i].getName()+"\n"+"Balance ---> "+banks[i].getBal());
                            break;
                        }
                    }
                    if (!flag){
                        System.out.println("Account not found!");
                    }
                    break;
                case 5:
                    flag=false;
                    flag1=false;
                    System.out.println("Enter your bank accno. :");
                    id=sc.nextInt();
                    System.out.println("Enter accno. you want to transfer amount :");
                    id2=sc.nextInt();
                    System.out.println("Enter the amount you want to transfer :");
                    amt=sc.nextInt();
                    for (int i=0;i<index;i++){
                        if (banks[i].getId()==id){
                            sb=banks[i];
                            flag=true;
                            break;
                        }
                    }
                    if(!flag){
                        System.out.println("Source Account not found !");
                        break;
                    }
                    for(int i=0;i<index;i++){
                        if(banks[i].getId()==id2){
                            db=banks[i];
                            flag1=true;
                            if (sb!=null) {
                                sb.transferMoney(db, amt);
                                System.out.println("Transferred money successfully.");
                            }
                        }
                    }
                    if(!flag1){
                        System.out.println("Destination Account not found !");
                        break;
                    }
                    break;
                case 6:
                    System.out.println("Qutting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }while (choice!=6);
    }
}
