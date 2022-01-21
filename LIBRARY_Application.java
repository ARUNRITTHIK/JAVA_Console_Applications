                                                   ADMIN [name/password]-> aa/ss  (For authentication) 

import java.util.*;
import java.text.*;
import java.time.LocalDate;
import java.time.Period;
public class library {

    // static String current_date;

    static void clear() {
        System.out.print("\033[H\033[2J");
    }

    static Date date = new Date();
    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    static String current_date = String.valueOf(format.format(date));

    static Scanner sc=new Scanner(System.in); 

    static String current_user_name="";

    static int i=0;

    static int curr_fine=0;

    static String temp_ret_date="";

    static int curr_book_cost=0;
    
    static ArrayList<library> admin=new ArrayList<>();

    String email;
    String password;

    library(String email,String password){
        this.email=email;
        this.password=password;
    }
    // ..................................................//
    static ArrayList<add_book> admin_add_book=new ArrayList<>();
    // ..................................................//
    static ArrayList<borrower> admin_add_borrower=new ArrayList<>();
    // ...................................................//
    static ArrayList<borrow> user_borrow_book=new ArrayList<>();
    // ...................................................//
    static ArrayList<cart> user_cart=new ArrayList<>();
    // .....................................................//
    static ArrayList<user_fine_details> user_fin_det=new ArrayList<>();
    // ...............................................................//
    static ArrayList<admin_past_borrowed> admin_view_rec=new ArrayList<>();

    public static void Add_Admin(){
        clear();
        a:while(true){
            System.out.println("Want to add Admin!..");
            System.out.println("Enter your Email ID : ");
            String add_name=sc.next();
            sc.nextLine();
            System.out.println("Enter your password : ");
            String add_pass=sc.next();
            sc.nextLine();
            int count=0;
            for(int i=0;i<admin.size();i++){
                if(add_name.equals(admin.get(i).email) && add_pass.equals(admin.get(i).password)){
                    System.out.println("The Email (or) Password is used already, please try different Email (or) password");
                    count=1;
                    break;
                }
            }
            if(count==0){
                admin.add(new library(add_name,add_pass));
                System.out.println("Admin added successfully");
                break a;
            }
        }
    }

    public static void Add_Book(){
        clear();
        while(true){
            System.out.println("Enter the book name : ");
            String bname=sc.next();
            sc.nextLine();
            System.out.println("Enter the book quantity : ");
            int bquantity=sc.nextInt();
            System.out.println("Enter the ISBN number : ");
            int ISBN_num=sc.nextInt();
            System.out.println("Enter the Borrowed count : ");
            int br_count=sc.nextInt();
            System.out.println("Enteer the Book cost : ");
            int b_cost=sc.nextInt();
            int count=0;
            if(admin_add_book.size()==0){
                admin_add_book.add(new add_book(bname, bquantity, ISBN_num, br_count, b_cost));
                System.out.println("Book was added successfully!..");
                break ;
            }
            else{
                for(int i=0;i<admin_add_book.size();i++){
                    if(bname.equals(admin_add_book.get(i).book_name) && ISBN_num==admin_add_book.get(i).ISBN_number){
                        System.out.println("The Book was already added in our Library!..");
                        count=1;
                        break;
                    }
                }
                if(count==0){
                    admin_add_book.add(new add_book(bname, bquantity, ISBN_num, br_count,b_cost));
                    break ;
                }
                else{
                    break;
                }
            }
        }    
    }

    public static void modify_book(){
        clear();
        a:while(true){
            System.out.println("Enter the ISBN number of your book: ");
            int mod_book_isbnum =sc.nextInt();
            System.out.println("Enter the new name of the book: ");
            String mod_book_name=sc.next();
            sc.nextLine();
            System.out.println("Enter the new count of the book: ");
            int mod_book_count=sc.nextInt();
            for(int i=0;i<admin_add_book.size();i++){
                if(mod_book_isbnum==admin_add_book.get(i).ISBN_number){
                    admin_add_book.get(i).book_name=mod_book_name;
                    admin_add_book.get(i).book_quantity=mod_book_count;
                    System.out.println("The Book was modified successfully!..");
                    break a;
                }
                else{
                    System.out.println("Invalid Input");
                    break a;
                }
            }
        }
    }

    public static void remove_book(){
        clear();
        System.out.println("Enter the book's ISBN number to remove the book : ");
        int give_number=sc.nextInt();
        int count=0;
        for(int i=0;i<admin_add_book.size();i++){
            if(give_number==admin_add_book.get(i).ISBN_number){
                admin_add_book.remove(i);
                break ;
            }
            else{
                System.out.println("\t.....Invalid Input......");
            }
        }
        System.out.println();
        System.out.println("press 1 to continue!..");
        try{
            System.in.read();
            Book_Menu();
        }catch(Exception e){

        }
    }

    public static void view_book(){
        clear();
        System.out.println("Enter [1]-> name wise order : / [2]-> quantity wise order :");
        int choose_num=sc.nextInt();
        if(choose_num==1){
            Collections.sort(admin_add_book,add_book.booknameComparator);
            System.out.printf("%-10s%-13s%-6s%-10s\n", "Name", "Quantity", "ISBN","Borrowed count");
            if(admin_add_book.size()>0){
                for(int i=0;i<admin_add_book.size();i++){
                    System.out.printf("%-10s%-13d%-6d%-10d\n", admin_add_book.get(i).book_name, admin_add_book.get(i).book_quantity, admin_add_book.get(i).ISBN_number,admin_add_book.get(i).borrowed_count);
                }
            }
            else{
                System.out.println("There are no books in our collections!..");
            }
        }
        else if(choose_num==2){
            Collections.sort(admin_add_book,add_book.booknameComparator);
            System.out.printf("%-10s%-13s%-6s\n","Name", "Quantity", "ISBN");
            if(admin_add_book.size()>0){
                for(int i=0;i<admin_add_book.size();i++){
                        System.out.printf("%-10s%-13s%-6d\n",admin_add_book.get(i).book_name, admin_add_book.get(i).book_quantity, admin_add_book.get(i).ISBN_number);
                    }
            }
            else{
                    System.out.println("There are no books in our collections!..");
                }
            }
            System.out.println();
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
                Book_Menu();
            } catch (Exception e) {
        }
    }

    public static void admin_search_book(){
        clear();
        System.out.println("Enter the book's name to be searched :");
        String choice_name=sc.next();
        sc.nextLine();
        System.out.println("Enter the book's ISBN number : ");
        int choice_ISBN=sc.nextInt();
        for(int i=0;i<admin_add_book.size();i++){
            if(choice_name.equals(admin_add_book.get(i).book_name) && choice_ISBN==admin_add_book.get(i).ISBN_number){
                System.out.println("The book name is -> "+choice_name);
                System.out.println("The book count is -> "+choice_ISBN);
            }
        }
        System.out.println();
        System.out.println("Press 1 to continue!..");
        try{
            System.in.read();
            Book_Menu();

        }catch(Exception e){

        }
    }

    public static void less_quantity(){
        clear();
        System.out.println("The least quantity books are : ");
        System.out.println();
        System.out.printf("%-10s%-13s%-6s\n","Name", "Quantity", "ISBN","Borrowed book Count");
        for(int i=0;i<admin_add_book.size();i++){
            if((admin_add_book.get(i).book_quantity)<=5){
                System.out.printf("%-10s%-13d%-6d\n",admin_add_book.get(i).book_name,admin_add_book.get(i).book_count,admin_add_book.get(i).ISBN_number,admin_add_book.get(i).borrowed_count);
            }
        }
        System.out.println();
        System.out.println("Press 1 to continue!..");
        try{
            System.in.read();
            book_reports();
        }catch(Exception e){

        }
    }

    public static void not_borrowed(){
        clear();
        System.out.println("The books that are not borrowed are : ");
        System.out.printf("%-10s%-13s%-6s%-6s\n","Name", "Quantity", "ISBN","Borrowed book Count");
        for(int i=0;i<admin_add_book.size();i++){
            if(admin_add_book.get(i).borrowed_count==0){
                System.out.printf("%-10s%-13d%-6d%-6d\n",admin_add_book.get(i).book_name,admin_add_book.get(i).book_count,admin_add_book.get(i).ISBN_number,admin_add_book.get(i).borrowed_count);
            }
        }
        System.out.println();
        System.out.println("Press 1 to continue!...");
        try{
            System.in.read();
            book_reports();
        }catch(Exception e){

        }
    }

    public static void most_borrowed(){
        clear();
        System.out.println("The books that are borrowed frequently!..");
        System.out.printf("%-10s%-13s%-6s%-6s\n","Name", "Quantity", "ISBN","Borrowed book Count");
        System.out.println();
        for(int i=0;i<admin_add_book.size();i++){
            if(admin_add_book.get(i).borrowed_count>=5){
                System.out.printf("%-10s%-13d%-6d%-6d\n",admin_add_book.get(i).book_name,admin_add_book.get(i).book_count,admin_add_book.get(i).ISBN_number,admin_add_book.get(i).borrowed_count);
            }
        }
        System.out.println();
        System.out.println("press 1 to continue!..");
        try{
            System.in.read();
            book_reports();
        }catch(Exception e){

        }
    }

    public static void book_reports(){
        clear();
        a8:while(true){
            System.out.println("1 -> less quantity\n2 -> not borrowed\n3 -> most borrowed\n4 -> Exit");
            System.out.println("Enter a number to do the above operations!...");
            int choice=sc.nextInt();
            if(choice==1){
                less_quantity(); //line no : 193
            }
            else if(choice==2){  
                not_borrowed(); //line no : 212
            }
            else if(choice==3){
                most_borrowed(); //line no : 230
            }
            else if(choice==4){
                break a8;     
            }
        }
    }

    public static void book_borrow_details(){
        clear();
        System.out.printf("%-20s%-10s%-20s%-15s\n","Borrower name","Book Name","Borrowed date","return date");
        for(int i=0;i<admin_view_rec.size();i++){
        System.out.printf("%-20s%-10s%-20s%-15s\n",admin_view_rec.get(i).user_name,admin_view_rec.get(i).book_name,admin_view_rec.get(i).borr_date,admin_view_rec.get(i).ret_date);
        }
    }

    public static void Book_Menu(){
        clear();
        a1:while(true){
            System.out.println("1 -> Add Book\n2 -> Modify Book\n3 -> remove Book\n4 -> View Book\n5 -> Search Book\n6 -> Book borrowed details by ISBN\n7 -> Book Reports\n8 -> Go Back");
            System.out.println("Enter your choice : ");
            int choice=sc.nextInt();
            if(choice==1){
                Add_Book(); //line no : 45
            }
            else if(choice==2){
                modify_book(); //line no : 81
            }
            else if(choice==3){
                remove_book(); //line no : 105
            }
            else if(choice==4){
                view_book(); //line no : 128
            }
            else if(choice==5){
                admin_search_book(); //line no : 164
            }
            else if(choice==6){
                book_borrow_details();
            }
            else if(choice==7){
                book_reports(); //line no : 249
            }
            else if(choice==8){
                break a1;
            }
        }
    }

    public static void Add_borrower(){
        clear();
        System.out.println("Enter Borrower name : ");
        String name=sc.next();
        sc.nextLine();
        System.out.println("Enter Borrower password : ");
        String password=sc.next();
        sc.nextLine();
        System.out.println("Enter Borrower wallet : ");
        int wallet=sc.nextInt();
        System.out.println("Enter your fine amount : ");
        int u_fine=sc.nextInt();
        clear();
        if(admin_add_borrower.size()==0){
            admin_add_borrower.add(new borrower(name,password,1500,true,u_fine));
            System.out.println(".......................The borrower was added successfully!.......................");
        }
        else{
            for(int i=0;i<admin_add_borrower.size();i++){
                if(name.equals(admin_add_borrower.get(i).borrower_name) && password.equals(admin_add_borrower.get(i).borrower_passowrd)){
                    System.out.println("This name and password is already used by someone else!..");
                }
                else{
                    admin_add_borrower.add(new borrower(name, password, wallet, true, u_fine));
                    System.out.println("The borrower was added successfully!...");
                    break;
                }
            }
        }
    }

    public static void fine_for_book_loss(){
        clear();
        System.out.printf("%-20s%-10s%-20s%-15s\n","Name","Book Name","Fine amount","Reason");
        String reason="Fine for book loss";
        for(int i=0;i<admin_add_borrower.size();i++){
            int fine=admin_add_book.get(i).book_cost/2;
            System.out.printf("%-20s%-10s%-20d%-15s\n",admin_add_borrower.get(i).borrower_name,admin_add_book.get(i).book_name,fine,reason);
        }
    }

    public static void fine_for_card_loss(){
        clear();
        System.out.println("Enter your name : ");
        String name=sc.next();
        sc.nextLine();
        int price=50;
        String reason="Fine for Loss of MS card";
        System.out.printf("%-20s%-10s%-20s%-15s\n","Name","MS card","Fine amount","Reason");
        for(int i=0;i<admin_add_borrower.size();i++){
            System.out.printf("%-20s%-10s%-20d%-15s\n",name,price,reason);
        }
    }

    public static void Borrower_Menu(){
        clear();
        while(true){
            System.out.println("\t.................Welcome to the borrower Menu!.................");
            System.out.println("1 -> Set fine for loss of book\n2 -> Set fine for loss of card\n3 -> Exit");
            System.out.println("Enter your choice!..");
            int choice=sc.nextInt();
            if(choice==1){
                fine_for_book_loss(); 
            }
            else if(choice==2){
                fine_for_card_loss();
            }
            else if(choice==3){
                break;
            }
        }
    }

    public static void Admin(){
        clear();
        admin.add(new library("aa","ss"));
        System.out.println("\t....................Welcome to Admin portal....................");
        System.out.println("Enter your Email ID :");
        String admin_name=sc.next();
        sc.nextLine();
        System.out.println("Enter your Admin password :");
        String admin_pass=sc.next();
        sc.nextLine();
        clear();
        a7:while(true){
            for(int j=0;j<admin.size();j++){
                if(admin_name.equals(admin.get(j).email) && admin_pass.equals(admin.get(j).password)){
                    System.out.println("\tWelcome Admin");
                    System.out.println("1 -> Add Admin\n2 -> Add user\n3 -> Book Menu\n4 -> Borrower Menu\n5 -> Exit");
                    System.out.println("Enter your choice!..");
                    int choose=sc.nextInt();
                    if(choose==1){
                        Add_Admin();//line no : 20
                    }
                    else if(choose==2){
                        Add_borrower(); //line no :309
                    }
                    else if(choose==3){
                        Book_Menu();//line no : 276
                    }
                    else if(choose==4){
                        Borrower_Menu(); //line no : 321 
                    }
                    else if(choose==5){
                        break a7;  
                    }
                }
            }
        }
    }

    public static void  view_books(){
        clear();
        System.out.println("The books are sorted in name wise order!..");
        System.out.println();
        System.out.printf("%-10s%-13s\n", "Book Name", "ISBN Number");
        for(int i=0;i<admin_add_book.size();i++){
            System.out.printf("%-10s%-13d\n",admin_add_book.get(i).book_name,admin_add_book.get(i).ISBN_number);
        }
        System.out.println();
        System.out.println("Press 1 to continue");
        try{
            System.in.read();
            Books();
        }catch(Exception e){

        }
    }

    public static void search_book(){
        clear();
        a5:while(true){
            System.out.println("Enter the book's name to be searched :");
            String choice_name=sc.next();
            sc.nextLine();
            System.out.println("Enter the book's ISBN number : ");
            int choice_ISBN=sc.nextInt();
            System.out.printf("%-10s%-13s\n", "Book Name", "ISBN Number");
            for(int i=0;i<admin_add_book.size();i++){
                if(choice_name.equals(admin_add_book.get(i).book_name) && choice_ISBN==admin_add_book.get(i).ISBN_number){
                    System.out.printf("%-10s%-13s\n", choice_name, choice_ISBN);
                    System.out.println("\t..................Your search is successfull..................");
                    break a5;
                }
                else{
                    System.out.println("your search is not matched with our collections!...");
                    break a5;
                }
            }
        }
    }

    public static void borrow_book(){
        clear();
        System.out.println("Enter book name : ");
        String bname=sc.next();
        sc.nextLine();
        System.out.println("Enter book's ISBN number : ");
        int isbn_num=sc.nextInt();
        System.out.println("Enter when you will return the book!..");
        String date=sc.next();
        sc.nextLine();

        for(int i=0;i<admin_add_book.size();i++){
            if(bname.equals(admin_add_book.get(i).book_name)  && isbn_num==admin_add_book.get(i).ISBN_number){
                user_cart.add(new cart(bname,isbn_num));
                System.out.println("your borrow was done successfully!..");
                current_user_name=admin_add_borrower.get(i).borrower_name;
                curr_book_cost=admin_add_book.get(i).book_cost;
                user_borrow_book.add(new borrow(bname, current_user_name, isbn_num, current_date, date, "0000.00.00"));
                int bo_count=admin_add_book.get(i).book_quantity;
                bo_count-=1;
                admin_add_book.get(i).book_quantity=bo_count;
                int br_count=admin_add_book.get(i).borrowed_count;
                br_count+=1;
                admin_add_book.get(i).borrowed_count=br_count;
                admin_view_rec.add(new admin_past_borrowed(current_user_name,bname,curr_book_cost,current_date,date));
            }
            // else if(!bname.equals(admin_add_book.get(i).book_name)){
            //     System.out.println("The book is currently not available!..");
            //     break;
            // }
        }
    }

    public static void borrow_details(){
        clear();
        for(int i=0;i<admin_add_borrower.size();i++){
            if(current_user_name.equals(admin_add_borrower.get(i).borrower_name)){
                System.out.printf("%-20s%-10s%-20s%-15s\n","Borrower name","Book Name","Borrowed date","return date");
                System.out.printf("%-20s%-10s%-20s%-15s\n",admin_add_borrower.get(i).borrower_name,admin_add_book.get(i).book_name,user_borrow_book.get(i).borrow_date,user_borrow_book.get(i).return_date);
                temp_ret_date=user_borrow_book.get(i).return_date;
                break;
            }
            else{
                System.out.println("You have bought no books in our library!..");
                break;
            }
        }
    }

    public static void return_book(){
        clear();
        System.out.println("Enter the book name that you want to return : ");
        String name=sc.next();
        sc.nextLine();
        System.out.println("Enter your book's ISBN number : ");
        int num=sc.nextInt();
        System.out.println("Current date is : "+current_date);
        for(int i=0;i<admin_add_book.size();i++){
            if(name.equals(admin_add_book.get(i).book_name) && num==admin_add_book.get(i).ISBN_number){
                System.out.println("Your return was done successfully!..");
                admin_add_book.get(i).book_quantity+=1;
                user_fine_per_day(i);
                break;
            }
        }
    }

    public static void extend_return_date(){
        clear();
        System.out.println("Enter the Borrower name : ");
        String name=sc.next();
        sc.nextLine();
        System.out.println("Enter the Book's ISBN number : ");
        int num=sc.nextInt();
        System.out.println("Enter the new date to be extended : ");
        String date=sc.next();
        sc.nextLine();
        for(int i=0;i<user_borrow_book.size();i++){
            if(name.equals(user_borrow_book.get(i).br_name) && num==admin_add_book.get(i).ISBN_number){
                user_borrow_book.get(i).return_date=date;
                break;
            }
        }
    }

    public static void Books(){
        clear();
        a4:while(true){
            System.out.println("1 -> view all books\n2 -> search book\n3 -> borrow book\n4 -> past borrowed books\n5 -> return books\n6 -> extend return date\n7 -> Exit");
            System.out.println("Enter a number : ");
            int choice=sc.nextInt();
            if(choice==1){
                view_books();
            }
            else if(choice==2){
                search_book();
            }
            else if(choice==3){
                borrow_book();
            }
            else if(choice==4){
                borrow_details();
            }
            else if(choice==5){
                return_book();
            }
            else if(choice==6){
                extend_return_date();
            }
            else if(choice==7){
                break a4;  
            }
        }
    }

    public static void user_fine_book_loss(){
        clear();
        System.out.println("Enter your name : ");
        String name=sc.next();
        sc.nextLine();
        System.out.println("Enter your Book's ISBN number : ");
        int num=sc.nextInt();
        for(int i=0;i<admin_add_borrower.size();i++){
            if(name.equals(admin_add_borrower.get(i).borrower_name) && num==admin_add_book.get(i).ISBN_number){
                int fine=admin_add_book.get(i).book_cost/2;
                System.out.println("your Book's cost is : "+admin_add_book.get(i).book_cost);
                System.out.println();
                System.out.println("Your Fine amount is : "+curr_fine);
                admin_add_borrower.get(i).borrower_wallet-=curr_fine;
            }
        }
    }

    public static void user_fine_for_loss_mscard(){
        clear();
        System.out.println("Enter your name: ");
        String name=sc.next();
        sc.nextLine();
        System.out.println();
        for(int i=0;i<admin_add_borrower.size();i++){
            if(name.equals(admin_add_borrower.get(i).borrower_name)){
                curr_fine=50;
                System.out.println("your Book's cost is : "+admin_add_book.get(i).book_cost);
                System.out.println();
                System.out.println("Your Fine amount is : "+curr_fine);
                admin_add_borrower.get(i).borrower_wallet-=curr_fine;
                System.out.println("your fine was collected successfully!..");
            }
        }
    }

    public static void user_fine_per_day(int i){
        String date_1=current_date;
        String date_2=user_borrow_book.get(i).borrow_date;
        int tot_days=0;
        while(!date_1.equals(date_2)){
            date_2=DateChanger(date_2, 1);
            tot_days+=1;
        }
        if(tot_days<=15){
            System.out.println("your return is done within the given time, Thank you!..");
        }
        else{
            int fine=0;
            tot_days-=15;
            double a=1;
            double two=2;
            int c=0;

            while(tot_days!=0){
                double j=a;
                while(c<10){
                    if(tot_days!=0){
                        fine+=(int)(Math.pow(two,j));
                        c+=1;
                        tot_days-=1;
                    }
                    else{
                        break;
                    }
                }
                a+=1;
                c=0;
            }
            System.out.println("You have not returned the book within the given name, Your fine amount is : "+fine);
            System.out.println();
            System.out.println("press [1] -> pay by wallet / [2] -> pay by amount");
            int choice=sc.nextInt();
            if(choice==1){
                if(admin_add_borrower.get(i).borrower_wallet>fine){
                    System.out.println("Fine collected from your wallet!..");
                    admin_add_borrower.get(i).borrower_wallet-=fine;
                }
                else{
                    System.out.println("Your wallet balance is insufficient!..");
                    System.out.println("Please pay wit your fine!..");
                    System.out.println("press 1 to continue");
                    try{
                        System.in.read();
                        fine_details();
                    }catch(Exception e){

                    }
                }
            }
        }
    }

    public static void fine_details(){
        clear();
        System.out.println("1 -> fine for book_loss\n2 -> fine for loss of ms_card\n3 -> fine for late return(cost per day)\n4 -> Exit");
        System.out.println("Enter a number : ");
        int query=sc.nextInt();
        if(query==1){
            user_fine_book_loss();
        }
        else if(query==2){
            user_fine_for_loss_mscard();
        }
        else if(query==3){
            user_fine_per_day(i);
        }
        else{
            try{
            System.out.println();
            System.in.read();
            user();
            }catch(Exception e){

            }
        }
    }

    public static void cart(){
        clear();
        System.out.println("Welcome to your cart!..");
        System.out.printf("%-20s%-10s\n","Book Name","Book's ISBN number");
        for(int i=0;i<user_cart.size();i++){
            System.out.printf("%-20s%-10d\n",user_cart.get(i).b_name,user_cart.get(i).b_ISBN_num);
        }
    }

    public static void user(){
        clear();
        a6:while(true){
            System.out.println("\t..................Welcome user..................");
            System.out.println("Enter your user name : ");
            String name=sc.next();
            sc.nextLine();
            System.out.println("Enter your password : ");
            String pass=sc.next();
            sc.nextLine();
            for(int i=0;i<admin_add_borrower.size();i++){
                if(name.equals(admin_add_borrower.get(i).borrower_name) && pass.equals(admin_add_borrower.get(i).borrower_passowrd)){
                    current_user_name=name;
                    System.out.println("\tWelcome "+name);
                    System.out.println("1 -> Books\n2 -> Fine details\n3 -> Cart\n4 -> Exit");
                    System.out.println("Enter a number : ");
                    int choose=sc.nextInt();
                    if(choose==1){
                        Books();
                    }
                    else if(choose==2){
                        fine_details();
                    }
                    else if(choose==3){
                        cart();
                    }
                    else if(choose==4){
                        break a6;
                    }
                }
            }
        }
    }

    public static String DateChanger(String date,int days) {
        return LocalDate
                .parse(date)
                .plusDays(days)
                .toString();
    }

    public static void change_date(){
        clear();
        System.out.println("Enter the number of days to be added : ");
        int days=sc.nextInt();
        current_date=DateChanger(current_date,days);
        System.out.println(current_date);
    }

    public static void main(String args[]){
        clear();
        while(true){
            System.out.println("\tWelcome to Library Management System!...");
            System.out.println("1 -> Admin\n2 -> User\n3 -> change date\n4 -> Exit");
            int choice=sc.nextInt();
            if(choice==1){
                Admin(); //line no : 365
            }
            else if(choice==2){
                user();
            }
            else if(choice==3){
                change_date();
            }
            else if(choice==4){
                break;
            }
        }
    }
}

// ................................line no : 15....................................//
class add_book{
    String book_name;
    int book_quantity;
    int ISBN_number;
    int book_count;
    int borrowed_count;
    int book_cost;

    add_book(String book_name,int book_quantity,int ISBN_number,int borrowed_count,int book_cost){
        this.book_name=book_name;
        this.book_quantity=book_quantity;
        this.ISBN_number=ISBN_number;
        this.borrowed_count=borrowed_count;
        this.book_cost=book_cost;
    }

    public String getbookname(){
        return this.book_name;
    }

    public int getbookcount(){
        return this.book_quantity;
    }

    public static Comparator<add_book> booknameComparator=new Comparator<add_book>() {
        public int compare(add_book s1,add_book s2){
            String bookname1=s1.getbookname().toUpperCase();
            String bookname2=s2.getbookname().toUpperCase();

            return bookname1.compareTo(bookname2);
        }
    };

    public static Comparator<add_book> bookcountComparator=new Comparator<add_book>(){
        public int compare(add_book s1,add_book s2){
            int bookcount1=s1.getbookcount();
            int bookcount2=s2.getbookcount();

            return bookcount2-bookcount1;
        }
    };
}

// ...........................................................................................//

class borrower{
    String borrower_name;
    String borrower_passowrd;
    int borrower_wallet;
    boolean borrower_ms_card;
    int user_fine;

    borrower(String borrower_name,String borrower_passowrd,int borrower_wallet,boolean borrower_ms_card,int user_fine){
        this.borrower_name=borrower_name;
        this.borrower_passowrd=borrower_passowrd;
        this.borrower_wallet=borrower_wallet;
        this.borrower_ms_card=borrower_ms_card;
        this.user_fine=user_fine;
    }
}

// ...........................................................................................//

class borrow{
    String books_name;
    String br_name;
    int books_ISBN_num;
    String borrow_date;
    String return_date;
    String user_return_date;

    borrow(String books_name,String br_name,int books_ISBN_num,String borrow_date,String return_date,String user_return_date){
        this.books_name=books_name;
        this.br_name=br_name;
        this.books_ISBN_num=books_ISBN_num;
        this.borrow_date=borrow_date;
        this.return_date=return_date;
        this.user_return_date=user_return_date;
    }
}

// ..............................................................................................//

class cart{
    String b_name;
    int b_ISBN_num;
    int b_cost;
    int bk_quantity;

    cart(String b_name,int b_ISBN_num){
        this.b_name=b_name;
        this.b_ISBN_num=b_ISBN_num;
    }
}

// .............................................................................................//

class user_fine_details{
    String bor_name;
    String bk_name;
    int fine;
    String what_fine;

    user_fine_details(String bor_name,String bk_name,int fine,String what_fine){
        this.bor_name=bor_name;
        this.bk_name=bk_name;
        this.fine=fine;
        this.what_fine=what_fine;
    }
}

// ................................................................................................//

class admin_past_borrowed{
    String user_name;
    String book_name;
    int book_cost;
    String borr_date;
    String ret_date;

    admin_past_borrowed(String user_name,String book_name,int book_cost,String borr_date,String ret_date){
        this.user_name=user_name;
        this.book_name=book_name;
        this.book_cost=book_cost;
        this.borr_date=borr_date;
        this.ret_date=ret_date;
    }
}
