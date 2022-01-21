#ATM Application
                                                        ADMIN[name/password] - arun/ritthik ->  (For Authentication)
                                                        USER[name/password] - arun/ritthik  ->  (For Authentication)
                                                        

import java.time.LocalDateTime;
import java.util.*;
class atm{
    public static int various_notes_count[]={0,0,0,0};
    public static int various_notes[] = {2000,500,200,100};
    public static int atm_balance=0;
    public static String user_password="ritthik";
    public static String user_name="arun";
    public static int user_balance=10000;
    public static int current_balance=0;
    public static int current_state=0;
    public static ArrayList<Integer> mini_statement=new ArrayList<>();
    public static Scanner sc=new Scanner(System.in);

    public static void delay(int delay){
        try{
            Thread.sleep(delay);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }

    public static  void clearScreen(){
        System.out.println("\033[H\033[23");
        System.out.flush();
    }

    public static void admin_deposit_money(){
        System.out.println("Enter amount : ");
        System.out.println("2000 : ");
        various_notes_count[0]+=sc.nextInt();
        System.out.println("500 :");
        various_notes_count[1]+=sc.nextInt();
        System.out.println("200 : ");
        various_notes_count[2]+=sc.nextInt();
        System.out.println("100 : ");
        various_notes_count[3]+=sc.nextInt();
        atm_balance+=((various_notes_count[0]*2000) + (various_notes_count[1]*500) + (various_notes_count[2]*200) + (various_notes_count[3]*100));
        System.out.println("\t................Your Amount is Successfully Added................");
    }

    public static void admin_check_balance(){
        System.out.println("2000 notes : "+various_notes_count[0]);
        System.out.println("500 notes : "+various_notes_count[1]);
        System.out.println("200 notes : "+various_notes_count[2]);
        System.out.println("100 notes : "+various_notes_count[3]);
        System.out.println("ATM Machine's total balance : "+ atm_balance);
        System.out.println("\t................Amount Displayed Successfully................");
    }

    public static void user_deposit_amount(){
        System.out.println("Enter amount : ");
        System.out.println("2000 : ");
        int amnt_2000=sc.nextInt();
        user_balance+=amnt_2000*2000;
        various_notes_count[0]+=amnt_2000;
        System.out.println("500 :");
        int amnt_500=sc.nextInt();
        user_balance+=amnt_500*500;
        various_notes_count[1]+=amnt_500;
        System.out.println("200 : ");
        int amnt_200=sc.nextInt();
        user_balance+=amnt_200*200;
        various_notes_count[2]+=amnt_200*200;
        System.out.println("100 : ");
        int amnt_100=sc.nextInt();
        user_balance+=amnt_100*100;
        various_notes_count[3]+=amnt_100*100;
        System.out.println("\t................Your Amount is Successfully Added................");
    }

    public static void user_check_balance(){
        System.out.println("Your Account Balance is : "+user_balance);
        current_balance=user_balance;
        System.out.println("\t................Thank You................");
    }

    public static void user_pin_change(){
            System.out.println("Enter New Pin : ");
            String new_pin=sc.next();
            sc.nextLine();
            System.out.println("Confirm Password : ");
            String confirm_pin=sc.next();
            sc.nextLine();
            if(new_pin.equals(confirm_pin)){
                user_password=new_pin;
                System.out.println("................Your password reset was done successfully................");
        }
    }

    public static void user_withdrawl(){
        System.out.println("Enter the amount to be withdrawn : ");
        int need_amt=sc.nextInt();
        int temp=need_amt;
        int current_notes1[]=new int[4];
        for(int i=0;i<4;i++){
            current_notes1[i]=various_notes[i];
        }
        if(current_state<=10){
            if(need_amt<=atm_balance){
                if(need_amt<=user_balance){
                    if(need_amt%10==0 && need_amt%100==0){
                        while(need_amt>=2000 && current_notes1[0]>0){
                            need_amt -=2000;
                            current_notes1[0]--;
                            current_balance-=2000;
                            
                        }
                        while(need_amt>=500 && current_notes1[1]>0){
                           need_amt -=500;
                           current_notes1[1]--;
                           current_balance-=500;
                       }
                       while(need_amt>=200 && current_notes1[2]>0){
                           need_amt -=200;
                           current_notes1[2]--;
                           current_balance-=200;
                       }
                       while(need_amt>=100 && current_notes1[3]>0){
                           need_amt -=100;
                           current_notes1[3]--;
                           current_balance-=100;
                       }
                       System.out.println("Your withdraw is done successfully");
                       mini_statement.add(temp);
                       System.out.println("Your current Balance is :"+(current_balance));
                       user_balance=current_balance;
                   }
                   else{
                        System.out.println("Sorry for the inconvinience "+":-(");
                    }
                }
                else{
                    System.out.println("Your Balance is insufficient "+":-(");
                }
            }
            else{
                System.out.println("Insufficient Balance in ATM "+":-(");
                System.out.println("Enter a number from 1 to 5 for the following operations");
            }
            current_state++;
        }
        else{
            System.out.println("................You have reached the maximum limit................");
        }
    }
    public static void main(String args[]){
        
        System.out.println("\t................Welcome ATM................");
        System.out.println("1.Admin : \n2.User : \n3.Exit : ");

        while(true){
            int callnumber=sc.nextInt();
            if(callnumber==1){
                
                System.out.println("Enter Username : ");

                String username=sc.next();
                sc.nextLine();
                System.out.println("Enter password : ");

                String userpassword=sc.next();
                sc.nextLine();

                if(username.equals(user_name) && userpassword.equals(user_password)){
                    System.out.println("\t................Welcome Admin................");
                    while(true){
                        System.out.println("1.Deposit Money : \n2.Check Balance :\n3.Exit : ");
                        int given_admin_number=sc.nextInt();
                        if(given_admin_number==1){
                            System.out.println("\tWelcome "+ user_name);
                            admin_deposit_money();
                        }
                        else if(given_admin_number==2){
                            System.out.println("\tWelcome "+ user_name);
                            admin_check_balance();
                        }
                        else if(given_admin_number==3){
                            System.out.println("Press 1 -> [admin] (or) 2 -> [user] (or) 3 -> [exit] to continue");
                            break;
                        }
                    }
                }
                else{
                    System.out.println("Invalid password");
                    System.out.println("\tpress 1 to continue!...");
                }
            }
            else if(callnumber==2){
                System.out.println("Enter Username : ");
            
                String username=sc.next();
                sc.nextLine();
                System.out.println("Enter Password : ");
            
                String userpassword=sc.next();
                sc.nextLine();

                if(username.equals("arun") && userpassword.equals("ritthik")){
                    System.out.println("\t................Welcome User................");
                    while(true){
                        System.out.println("1.Deposit_amount \n2.check_balance \n3.pin_change \n4.withdrawl_amount \n5.Mini_statement \n6.Exit");
                        int given_user_number = sc.nextInt();
                        if(given_user_number==1){
                            System.out.println("\tWelcome "+ user_name);
                            user_deposit_amount();
                        }
                        else if(given_user_number==2){
                            System.out.println("\tWelcome "+ user_name);
                            user_check_balance();
                        }
                        else if(given_user_number==3){
                            System.out.println("\tWelcome "+ user_name);
                            user_pin_change();
                        }
                        else if(given_user_number==4){
                            System.out.println("\tWelcome "+ user_name);
                            user_withdrawl();
                        }
                        else if(given_user_number==5){
                            for(int i=0;i<mini_statement.size();i++){
                                System.out.println("Your transaction is -> "+mini_statement.get(i));
                            }
                        }
                        else if(given_user_number==6){
                            System.out.println("\tPress 1 -> [Admin] (or) 2 -> [User] (or) 3 -> [Exit] to continue");
                            break;
                        }
                    }
                }
            }
            else if(callnumber==3){
                break;
            }
        }
    }
}
