 
                                                         ADMIN [name/password] -> arun/ritthik  (For authentication)

import java.util.*;
import javax.print.DocFlavor.STRING;
import javax.swing.text.AbstractDocument.BranchElement;


public class amazon {
    static Scanner sc=new Scanner(System.in);

    static void clear() {
        System.out.print("\033[H\033[2J");
    }

    static List<String> mer_temp_name=new ArrayList<>();
    static List<String> mer_temp_id=new ArrayList<>();
    static List<String> mer_temp_password=new ArrayList<>();

    // ........................................................//

    static List<String> mer_per_name=new ArrayList<>();
    static List<String> mer_per_id=new ArrayList<>();
    static List<String> mer_per_password=new ArrayList<>();

    // ........................................................//

    static List<Integer> pro_id=new ArrayList<>();
    static List<String> pro_name=new ArrayList<>();
    static List<Integer> pro_price=new ArrayList<>();
    static List<Integer> pro_quantity=new ArrayList<>();
    static List<Integer> pro_discount=new ArrayList<>();
    static List<Integer> pro_saled=new ArrayList<>();
    static List<String> pro_mer_id=new ArrayList<>();
    static List<Integer> pro_cat=new ArrayList<>();
    static List<String> pro_cat_name=new ArrayList<>();
    static int product_id=1001;

    // ........................................................//

    static List<String> user_name=new ArrayList<>();
    static List<String> user_password=new ArrayList<>();
    static List<Integer> user_balance=new ArrayList<>();
    static List<Integer> user_cart=new ArrayList<>();
    static List<String> user_cart_name=new ArrayList<>();
    static List<Integer> user_cart_price=new ArrayList<>();
    static List<String> user_order_name=new ArrayList<>();
    static List<Integer> user_order=new ArrayList<>();
    static List<Integer> user_order_price=new ArrayList<>();

    static List<String> list=new ArrayList<>();

    // ........................................................//

    static String admin_name="arun";
    static String admin_password="ritthik";

    public static void add(){
        mer_per_name.add("arun");
        mer_per_id.add("1234");
        mer_per_password.add("ritthik");

        pro_id.add(1111);
        pro_name.add("iphone");
        pro_price.add(1000);
        pro_quantity.add(10);
        pro_discount.add(10);
        pro_saled.add(0);
        pro_mer_id.add("ar01");
        pro_cat.add(1);
        pro_cat_name.add("phone");

        user_name.add("arun");
        user_password.add("ritthik");
        user_balance.add(10000);
    }

    public static void admin(){
        clear();
        System.out.println("Enter your name : ");
        String ad_name=sc.next();
        sc.nextLine();
        System.out.println("Enter your password :");
        String ad_password=sc.next();
        sc.nextLine();
        clear();
        while(true){
            if(ad_name.equals(admin_name) && ad_password.equals(admin_password)){
                System.out.println("\tWelocme Arun");
                System.out.println("\t\t1. Merchant Approval List :\n\t\t2. Add Merchant :\n\t\t3. Remove Merchant :\n\t\t4. List the Merchant :\n\t\t5. List all Products :\n\t\t6. Exit");
                System.out.println("Enter a number : ");
                int admin_choose=sc.nextInt();
                if(admin_choose==1){
                    merchant_approval(); //line no : 99
                }
                else if(admin_choose==2){
                    add_merchant();  //line no : 112
                }
                else if(admin_choose==3){
                    remove_merchant(); //line no : 168
                }
                else if(admin_choose==4){
                    list_of_merchants(); //line no : 190
                }
                else if(admin_choose==5){
                    list_all_products(); //line no : 201
                }
                else if(admin_choose==6){
                    break;
                }
                else{
                    System.out.println(".....................Invalid input is given.....................");
                }
            }
            else{
                break;
            }
        }
    }

    public static void merchant_approval(){
        System.out.println("\tWelcome Arun");
        for(int i=0;i<mer_temp_name.size();i++){
            mer_per_name.add(mer_temp_name.get(i));
            mer_per_id.add(mer_temp_id.get(i));
            mer_per_password.add(mer_temp_password.get(i));
        }
        mer_temp_name.clear();
        mer_temp_id.clear();
        mer_temp_password.clear();
        System.out.println("The Merchant is approved successfully");
    }

    public static void add_merchant(){
        clear();
        System.out.println("Want to add a new Merchant! : ");
      a1:while(true){
            System.out.println("Enter Merchant Name : ");
            String add_name=sc.next();
            sc.nextLine();
            int add_count_name=0;
            for(int i=0;i<mer_per_name.size();i++){
                if(add_name.equals(mer_per_name.get(i))){
                    System.out.println("The Merchant name is already in use try different name");
                    add_count_name=1;
                    break;
                }
            }
            if(add_count_name==0){
                mer_per_name.add(add_name);
                break a1;
            }
        }
       a2:while (true) {
           System.out.println("Enter Merchant id :");
           String add_id=sc.next();
           sc.nextLine();
           int add_count_id=0;
           for(int i=0;i<mer_per_id.size();i++){
               if(add_id.equals(mer_per_id.get(i))){
                   System.out.println("The Merchant id is already in use try different id");
                    add_count_id=1;
                    break;
               }
           }
           if(add_count_id==0){
               mer_per_id.add(add_id);
               break a2;
            }
        } 
       a3:while (true) {
           System.out.println("Enter Merchant password : ");
           String check_password=sc.next();
           sc.nextLine();
           int count_password=0;
           for(int i=0;i<mer_per_password.size();i++){
               if(check_password.equals(mer_per_password.get(i))){
                    System.out.println("The Merchant password is already in use, try different password");
                    count_password=1;
                    break;
               }
           }
           if(count_password==0){
               mer_per_password.add(check_password);
               break a3;
            }
        }
        clear();
        System.out.println("..........Account successfully added..........");
    }

    public static void remove_merchant(){
        clear();
     a1:while(true){
            System.out.println("Enter Merchant id : ");
            String remove_mer_id=sc.next();
            int remove_count_id=0;
            for(int i=0;i<mer_per_id.size();i++){
                if(remove_mer_id.equals(mer_per_id.get(i))){
                    mer_per_id.remove(i);
                    mer_per_name.remove(i);
                    mer_per_id.remove(i);
                    remove_count_id=1;
                    System.out.println("Merchant removed");
                    break a1;
                }
            }
            if(remove_count_id==0){
                System.out.println("Merchant not found :-(");
                break a1;
            }
        }
    }

    public static void list_of_merchants(){
        clear();
        System.out.println("The List of Merchants are : ");
        System.out.printf("%-15s%-15s\n","Merchant Name","Merchant ID");
        for(int i=0;i<mer_per_name.size();i++){
            System.out.println("Merchant number : "+(i+1)+"\n");
            System.out.printf("%-15s%-15s\n",mer_per_name.get(i),mer_per_id.get(i));
        }
    }

    public static void list_all_products(){
        clear();
        System.out.printf("%-15s%-15s%-18s%-17s%-17s%-17s%-15s\n","Merchant Id","Product Id","Product Category","Product Name","Product quantity","Product price","Product saled");
        for(int i=0;i<pro_id.size();i++){
            System.out.printf("%-15s%-15s%-18s%-17s%-17d%-17d%-15d\n",pro_mer_id.get(i), pro_id.get(i), pro_cat.get(i), pro_cat_name.get(i), pro_quantity.get(i), pro_price.get(i), pro_saled.get(i));
            System.out.println(".................................................");
            System.out.println();
        }
    }

    public static void new_merchant(){
        clear();
        System.out.println("Add a new merchant");
      a1:while(true){
            System.out.println("Enter your name : ");
            String mer_check_name=sc.next();
            sc.nextLine();
            int mer_count_name=0;
            for(int i=0;i<mer_per_name.size();i++){
                for(int j=0;j<mer_temp_name.size();j++){
                    if(mer_check_name.equals(mer_per_name.get(i)) && mer_check_name.equals( mer_temp_name.get(i))){
                        System.out.println("The name is alread given, plase try different name");
                        mer_count_name=1;
                        break;
                    }
                }
            }
            if(mer_count_name==0){
                mer_temp_name.add(mer_check_name);
                break a1;
            }
        }
       a2:while(true){
           System.out.println("Enter your id : ");
           String mer_check_id=sc.next();
           sc.nextLine();
           int mer_count_id=0;
           for(int i=0;i<mer_per_id.size();i++){
               for(int j=0;j<mer_temp_id.size();j++){
                    if(mer_check_id.equals(mer_per_id.get(i)) && mer_check_id.equals(mer_temp_id.get(i))){
                        System.out.println("The Id is already given, please try different Id");
                        mer_count_id=1;
                        break;
                    }
                }
            }
            if(mer_count_id==0){
               mer_temp_id.add(mer_check_id);
               break a2;
            }
        }
        a3:while(true){
            System.out.println("Enter your password : ");
            String mer_check_pass=sc.next();
            sc.nextLine();
            int mer_count_pass=0;
            for(int i=0;i<mer_per_password.size();i++){
                for(int j=0;j<mer_temp_password.size();j++){
                    if(mer_check_pass.equals(mer_temp_password.get(i)) && mer_check_pass.equals(mer_per_password.get(i))){
                        System.out.println("The password is already given, please try different password");
                        mer_count_pass=1;
                        break;
                    }
                }
            }
            if(mer_count_pass==0){
                mer_temp_password.add(mer_check_pass);
                break a3;
            }
        }
    }

    public static void add_product(int i){
        clear();
        int product_category;
        while(true){
            System.out.println("choose product category :\n1 -> Phone \n2 -> Laptop \n3 -> Clothes \n4 -> Kitchen Appliances");
            product_category=sc.nextInt();
            if(product_category==1){
                pro_cat_name.add("Phone");
                break;
            }
            else if(product_category==2){
                pro_cat_name.add("Laptop");
                break;
            }
            else if(product_category==3){
                pro_cat_name.add("Clothes");
                break;
            }
            else if(product_category==4){
                pro_cat_name.add("Kitchen Appliances");
                break;
            }
            else{
                System.out.println("Invalid Input");
            }
        }
        System.out.println();
        System.out.println("Enter product name : ");
        String produt_name=sc.next();
        sc.nextLine();
        System.out.println();
        System.out.println("Enter product price : ");
        int product_price=sc.nextInt();
        System.out.println();
        System.out.println("Enter product quantity : ");
        int product_quantity=sc.nextInt();
        System.out.println();
        System.out.println("Enter product Discount : ");
        int product_discount=sc.nextInt();
        System.out.println();
        pro_name.add(produt_name);
        pro_price.add(product_price);
        pro_discount.add(product_discount);
        pro_quantity.add(product_quantity);
        pro_id.add(product_id);
        product_id++;
        pro_mer_id.add(mer_per_id.get(i));
        pro_saled.add(0);
        pro_cat.add(product_category);

    }

    public static void list_product(int i){
        clear();
        String list=mer_per_id.get(i);
        System.out.printf("%-15s%-15s%-18s%-17s%-17s%-17s%-15s%-17s\n","Merchant Id","Product Id","Product Category","Product Name","Product quantity","Product price","Product saled","product saled");
        for(int j=0;j<pro_id.size();j++){
            if(list.equals(pro_mer_id.get(j))){
                System.out.printf("%-15s%-15s%-18s%-17s%-17d%-17d%-15d%-17d\n",pro_mer_id.get(j), pro_id.get(j), pro_cat_name.get(j), pro_name.get(j), pro_price.get(j), pro_quantity.get(j), pro_discount.get(j), pro_saled.get(j));
                System.out.println("................................................");
                System.out.println();
            }
        }
    }

    public static void edit_product(int i){
        clear();
        String list=mer_per_id.get(i);
        System.out.println("Enter product id : ");
        int id=sc.nextInt();
        int count=0;
        System.out.println("Edit products :");
        for(int j=0;j<pro_id.size();j++){
            if(list.equals(pro_mer_id.get(i)) && pro_id.get(j)==id){
                System.out.println("Merchant Name : "+mer_per_name.get(j));
                System.out.println("product id : "+pro_id.get(j));
                System.out.println("product category : "+pro_cat_name.get(j));
                System.out.println("product Name : "+pro_name.get(j));
                System.out.println("Enter new name : ");
                String new_name=sc.next();
                sc.nextLine();
                pro_name.set(j,new_name);
                System.out.println("Product price : "+pro_price.get(j));
                System.out.println("Enter new price : ");
                int new_price=sc.nextInt();
                pro_price.set(j,new_price);
                System.out.println("Product Quantity : "+pro_quantity.get(j));
                System.out.println("Enter new quantity : ");
                int new_quantity=sc.nextInt();
                pro_quantity.set(j,new_quantity);
                System.out.println("product discount : "+pro_discount.get(j));
                System.out.println("Enter new Discount : ");
                int new_discount=sc.nextInt();
                pro_discount.add(j,new_discount);
                System.out.println("product saled : "+pro_saled.get(j));
                System.out.println(".....................................");
                count=1;
                System.out.println();
            }
        }
        if(count==0){
            System.out.println("Invalid product id");
        }
    }

    public static void remove_product(int i){
        clear();
        String list=mer_per_id.get(i);
        System.out.println("want to remove a product!");
        System.out.println("Enter product id : ");
        int productid=sc.nextInt();
        int id=0;
        for(int j=0;j<pro_id.size();j++){
            if(list.equals(mer_per_id.get(i)) && product_id==pro_id.get(i)){
                pro_cat_name.remove(j);
                pro_name.remove(j);
                pro_id.remove(j);
                pro_discount.remove(j);
                pro_price.remove(j);
                pro_quantity.remove(j);
                pro_saled.remove(j);
                pro_cat.remove(j);
                pro_mer_id.remove(j);
                System.out.println("Product removed successfully");
                id=1;
            }
        }
        if(id==0){
            System.out.println("product id not found!...");
        }
    }

    public static void view_most_saled_products(int i){
        clear();
        String list=mer_per_id.get(i);
        int count=0;
        System.out.println("Most sold product");
        for(int j=0;j<pro_id.size();j++){
            if(list.equals(pro_mer_id.get(j))){
                if(count<pro_saled.get(j)){
                    count=pro_saled.get(i);
                }
            }
        }
        for(int j=0;j<pro_id.size();j++){
            if(list.equals(pro_mer_id.get(j)) && pro_saled.get(j)==count){
                System.out.println("Merchant name    :"+mer_per_name.get(j));
                System.out.println("Product id       :"+pro_id.get(j));
                System.out.println("Product category :"+pro_cat_name.get(j));
                System.out.println("Product price    :"+pro_price.get(j));
                System.out.println("Product Quantity :"+pro_quantity.get(j));
                System.out.println("Product discount :"+pro_discount.get(j));
                System.out.println("Product sold     :"+pro_saled.get(j));
            }
        }
    }

    public static void view_sales_report(int i){
        clear();
        String list=mer_per_id.get(i);
        System.out.println("Sales Report");
        for(int j=0;j<pro_id.size();j++){
            if(list.equals(pro_mer_id.get(j))){
                System.out.println("Product ID       :"+pro_id.get(j));
                System.out.println("Product Catagory :"+pro_cat_name.get(j));
                System.out.println("Product Name     :"+pro_name.get(j));
                System.out.println("Product Saled    :"+pro_saled.get(j));
                System.out.println(".............................................");
                System.out.println();
            }
        }
    }

    public static void existing_merchant(){
        clear();
        System.out.println("Enter Merchant Id : ");
        String exist_mer_id=sc.next();
        sc.nextLine();
        System.out.println("Enter Merchant password : ");
        String exist_mer_password=sc.next();
        sc.nextLine();
        a:while(true){
            for(int i=0;i<mer_per_name.size();i++){
                if(exist_mer_id.equals(mer_per_id.get(i)) && exist_mer_password.equals(mer_per_password.get(i))){
                    System.out.println("Welcome "+mer_per_name.get(i));
                    System.out.println("1 -> Add product \n2 -> list my products \n3 -> Edit product \n4 -> Remove product \n5 -> view most sold product \n6 -> view sales report \n7 -> Exit");
                    int exist_mer_choose=sc.nextInt();
                    if(exist_mer_choose==1){
                        add_product(i); //line no : 283
                    }
                    else if(exist_mer_choose==2){
                        list_product(i); //line no : 335
                    }
                    else if(exist_mer_choose==3){
                        edit_product(i); //line no : 354
                    }
                    else if(exist_mer_choose==4){
                        remove_product(i); //line no : 394
                    }
                    else if(exist_mer_choose==5){
                        view_most_saled_products(i); //line no : 424
                    }
                    else if(exist_mer_choose==6){
                        view_sales_report(i);
                    }
                    else if(exist_mer_choose==7){
                        break a;
                    }
                }
            }
        }
    } 

    public static void Merchant(){
        clear();
        System.out.println("................Welcome to the Merchant portal................");
        while(true){
            System.out.println("\n\t\t1.New Merchant\n\t\t2.Existing Merchant\n\t\t3.Exit");
            System.out.println("Enter a number to do the above operations :");
            int merchant_choose=sc.nextInt();
            if(merchant_choose==1){
                new_merchant(); //line no : 226
                System.out.println("The system is waiting for approval");
            }
            else if(merchant_choose==2){
                existing_merchant(); //line no : 287
            }
            else if(merchant_choose==3){
                break;
            }
        }
    }

    public static void shopping(int n){
        clear();
        while(true){
            System.out.println("Welcome user!");
            System.out.println("1 -> Phone\n2 -> Laptop\n3 -> furniture\n4 -> Groceries\n5 -> Exit");
            System.out.println("Enter your choice :");
            int shop_choose=sc.nextInt();
            if(shop_choose==1){
                product(0,n);
            }
            else if(shop_choose==2){
                product(1,n);
            }
            else if(shop_choose==3){
                product(2,n);
            }
            else if(shop_choose==4){
                product(3,n);
            }
            else if(shop_choose==5){
                break;
            }
            else{
                System.out.println("Invalid Input!..");
            }
        }
    }

    public static void product(int n, int p){
        clear();
        while(true){
            System.out.println("List of products : ");
            System.out.println("Product category : "+list.get(n));
            for(int j=0;j<pro_name.size();j++){
                if (pro_cat.get(j)==(n+1)&& pro_quantity.get(j)>0){
                    System.out.println("Product ID       :"+pro_id.get(j));
                    System.out.println("Product Name     :"+pro_name.get(j));
                    System.out.println("Product Price    :"+pro_price.get(j));
                    System.out.println("Product Quantity :"+pro_quantity.get(j));
                    System.out.println("Product Discount :"+pro_discount.get(j));
                    System.out.println("----------------------------------------");
                    System.out.println();
                }
            }
            
            System.out.println("1 -> Add to cart\n2 -> Buy\n3 -> Back\n4 -> Enter choices");
            int catagory1=sc.nextInt();
            if(catagory1==1){
                System.out.println("Enter Product ID :");
                int productid=sc.nextInt();
                int check1=0;
                for(int j=0;j<pro_id.size();j++){
                if(productid==pro_id.get(j)){
                    user_cart.add(productid);
                    user_cart_name.add(user_name.get(p));
                    System.out.println("Added to cart");
                    System.out.println(user_name.get(p));
                    check1=1;

                }
                }
                if(check1==0){
                    System.out.println("Invalid id...");
                }
                
            }else if(catagory1==2){
                System.out.println("Enter Product ID :");
                int productid=sc.nextInt();
                int check=0;
                for(int j=0;j<pro_id.size();j++){
                if(productid==pro_id.get(j)){
                    check=1;
                    int product_price=(pro_price.get(j))/pro_discount.get(j);
                    int pr=pro_price.get(j)-product_price;

                    if(pr<=user_balance.get(p)){
                        System.out.println("Final Price :"+pr);
                        user_balance.set(p,user_balance.get(p)-pr);
                        System.out.println("Product Ordred it will delivered in 10 days...");
                        user_order_name.add(user_name.get(p));
                        System.out.println(user_order_name);
                        user_order.add(pro_id.get(j));
                        user_order_price.add(pr);
                        pro_saled.set(j,(pro_saled.get(j)+1));
                        pro_quantity.set(j,(pro_quantity.get(j)-1));
                    }

                }}if(check==0){
                    System.out.println("Invalid Product Id....");
                }
            }else if (catagory1==3){
                break ;
            }
        }
    }

    public static void add_to_cart(int n){
        clear();
        while(true){
        int check=0;
        System.out.println("\tWelcome to cart");
         for(int i =0;i<user_cart.size();i++){
             if(user_name.get(n).equals(user_cart_name.get(i))){
                for(int j=0;j<pro_id.size();j++){
                    if(user_cart.get(i).equals(pro_id.get(j)) && pro_quantity.get(j)>0){
                        System.out.println((i+1)+"). ");
                        System.out.println("Product ID       :"+pro_id.get(j));
                        System.out.println("Product Catagory :"+pro_cat_name.get(j));
                        System.out.println("Product Name     :"+pro_name.get(j));
                        System.out.println("Product Price    :"+pro_price.get(j));
                        check=j;
                    }
                }
            }
         }
         System.out.println("1. Buy\n2. Back\nEnter choise :");
         int buy=sc.nextInt();
         if(buy==1){
         System.out.println("Enter Product ID :");
                int productid=sc.nextInt();
                for(int j=0;j<pro_id.size();j++){
                if(productid==pro_id.get(j)){

                    int product_price=(pro_price.get(j))/pro_discount.get(j);
                    int pr=pro_price.get(j)-product_price;

                    if(pr<=user_balance.get(n)){
                        System.out.println("Final Price :"+pr);
                        user_balance.set(n,user_balance.get(n)-pr);
                        System.out.println("Product Ordred it will delivered in 10 days...");
                        user_order_name.add(user_name.get(n));
                        System.out.println(user_order_name);
                        user_order.add(pro_id.get(j));
                        user_order_price.add(pr);
                        user_cart.remove(pro_id.get(j));
                        user_cart_name.remove(user_name.get(n));
                        pro_saled.set(j,(pro_saled.get(j)+1));
                        pro_quantity.set(j,(pro_quantity.get(j)-1));
                    }else{
                        System.out.println("Insufficient Balance...");
                    }
                }
            }
        }
        else if(buy==2)
        {
            break;
        }
        else{
            System.out.println("Invalid input..");
            }
        }
    }

    public static void wallet(int n){
        clear();
        while(true){
            System.out.println("\tWallet");
            System.out.println("Your current balance:"+user_balance.get(n));
            System.out.println("1.Add money\n2.Back\nEnter choice:");
            int wallet=sc.nextInt();
            if(wallet==1){
                System.out.println("Enter Amount:");
                int amount =sc.nextInt();
                user_balance.set(n,(user_balance.get(n)+amount));
                System.out.println("Amount Added");
                System.out.println();
                System.out.println("Your current balance:"+user_balance.get(n));
                System.out.println();
            }else if(wallet==2){
                break;
            }else{
               System.out.println("Invalid input...");
            }
        }
    }

    public static void order_history(int n){
        clear();
        int check=0;
        while(true){
        System.out.println("\tYour Order");
         for(int i =0;i<user_order.size();i++){
             if(user_name.get(n).equals(user_order_name.get(i))){
                for(int j=0;j<pro_id.size();j++){
                    if(user_order.get(i).equals(pro_id.get(j))){
                        System.out.println((i+1)+"). ");
                        System.out.println("Product ID       :"+pro_id.get(j));
                        System.out.println("Product Catagory :"+pro_cat_name.get(j));
                        System.out.println("Product Name     :"+pro_name.get(j));
                        System.out.println("Product Price    :"+user_order_price.get(i));
                        System.out.println();
                        check=1;
                    }
                }
                if(check==0){
                    System.out.println("Invalid id");
                }
            }
        }
        break;
        }
    }

    public static void password_change(int i){
        clear();
        System.out.println("\tWelcome "+user_name.get(i));
        System.out.println("Enter new Pin:");
        String newpin=sc.next();
        sc.nextLine();
        System.out.println("Confirm new Pin:");
        String repin=sc.next();
        sc.nextLine();
        if(newpin.equals(repin)){
            user_password.set(i,newpin);
            System.out.println("Pin changed Succesfully...");
        }else{
            System.out.println("Pin mismatch...");
        }
    }

    public static void existing_user(){
        clear();
        System.out.println("Enter a username :");
        String usrname=sc.next();
        sc.nextLine();
        System.out.println("Enter your password :");
        String usrpassword=sc.next();
        sc.nextLine();
        int count=0;
        clear();
        a:while(true){
            for(int i=0;i<user_name.size();++i){
                if(usrname.equals(user_name.get(i)) && usrpassword.equals(user_password.get(i))){
                    count=1;
                    while(true){
                        System.out.println("welcome "+user_name.get(i));
                        System.out.println("1 -> Shopping\n2 -> Add to cart\n3 -> Wallet\n4 -> Order history\n5 -> password change\n6 -> Exit");
                        System.out.println("Enter a number to do the above operations!..");
                        int user_choose=sc.nextInt();
                        if(user_choose==1){
                            shopping(i); //line no : 517
                        }
                        else if(user_choose==2){
                            add_to_cart(i); //line no : 614
                        }
                        else if(user_choose==3){
                            wallet(i); //line no : 673
                        }
                        else if(user_choose==4){
                            order_history(i); //line no : 695
                        }
                        else if(user_choose==5){
                            password_change(i); //line no :721
                        }
                        else if(user_choose==6){
                            break a;
                        }
                    }
                }
            }
            if(count==0){
                System.out.println("Invalid username or password!..");
                break a;
            }
        }
    }

    public static void new_user(){
        clear();
        System.out.println("Add a new Merchant!..");
        a1:while(true){
            System.out.println("Enter a username : ");
            String check_name=sc.next();
            sc.nextLine();
            int count=0;
            for(int i=0;i<user_name.size();i++){
                if(check_name.equals(user_name.get(i))){
                    System.out.println("The name is already used, please try different name");
                    count=1;
                    break;
                }
            }
            if(count==0){
                user_name.add(check_name);
                break a1;
            }
        }
        a1:while(true){
            clear();
            System.out.println("Enter your password : ");
            String check_pass=sc.next();
            sc.nextLine();
            int count=0;
            for(int i=0;i<user_password.size();i++){
                if(check_pass.equals(user_password.get(i))){
                    System.out.println("The password is already used, please try different name");
                    break;
                }
            }
            if(count==0){
                user_password.add(check_pass);
                break a1;
            }
        }
        System.out.println("Enter your user Balance : ");
        int usr_bal=sc.nextInt();
        user_balance.add(usr_bal);
        System.out.println("Account Added successfully");
        System.out.println(user_name+" "+user_password+" "+user_balance);
    }

    public static void user(){
        clear();
        while(true){
            System.out.println("Welcome User");
            System.out.println("1 -> Existing User\n2 -> New User\n3 -> Exit");
            System.out.println("Enter a number to do the above operations!..");
            int user_choose=sc.nextInt();
            if(user_choose==1){
                existing_user();
            }
            else if(user_choose==2){
                new_user();
            }
            else if(user_choose==3){
                break;
            }
            else{
                System.out.println("Invalid Input!..");
            }
        }
    }

    public static void main(String args[]){
        add();
        clear();
        while(true){
            System.out.println(".............WELCOME TO Amazon.............");
            System.out.println("1. Admin\n2. Merchant\n3. User\n4. Exit");
            System.out.println("Enter a number to do the above operations : ");
            int choose_num=sc.nextInt();
            if(choose_num==1){
                admin(); //line no : 64
            }
            else if(choose_num==2){
                Merchant(); //line no : 323
            }
            else if(choose_num==3){
                user(); //line no : 517
            }
            else if(choose_num==4){
                break;
            }
        } 
    }
}
