
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class splitwise {
    private static Scanner sc = new Scanner(System.in);

    static void clear() {
        System.out.print("\033[H\033[2J");
    }

    static void appMain() {
        clear();
        System.out.print("\n1. User Login\n2. Register User\n3. Exit\nEnter your choice : ");
        int n = sc.nextInt();
        if (n == 1) {
            User.login();
        } else if (n == 2) {
            User.register();
        } else if (n == 3) {
            System.exit(0);
        } else {
            System.out.print("\nInvalid choice\nPress enter to continue");
            try {
                System.in.read();
                appMain();
            } catch (Exception e) {
            }
        }

    }

    public static void main(String[] args) {
        User.users.add(new User(User.user_id_generator, "arun", "arun@gmail.com", "123", 1000));
        User.user_id_generator++;
        User.users.add(new User(User.user_id_generator, "ritthik", "ritthik@gmail.com", "123", 1000));
        User.user_id_generator++;
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(0, 1, 2));
        User.groups.add(new Groups(User.grp_id_gen, "Foodie", "Group", l));
        User.grp_id_gen++;
        appMain();
    }
}

class Groups {
    public int grp_id;
    public String grp_name, typeOfGroup;
    public ArrayList<Integer> members;

    Groups(int grp_id, String grp_name, String tog, ArrayList<Integer> members) {
        this.grp_id = grp_id;
        this.grp_name = grp_name;
        this.typeOfGroup = tog;
        this.members = members;
    }
}

class Expense {
    // expence = [ { typeOfExpence, grp_id, eID, name_of_exp, totalExpence,
    // createdBy, Datetime, [u1,u2,u3] } ]
    public String type_of_exp, name_of_exp, DateTime;
    public int grp_id, exp_id, created_user_id, total_exp;
    public ArrayList<Integer> partners;

    Expense(String toe, String noe, String dt, int gid, int eid, int cuid, int total_exp,
            ArrayList<Integer> partners) {
        this.type_of_exp = toe;
        this.name_of_exp = noe;
        this.DateTime = dt;
        this.grp_id = gid;
        this.exp_id = eid;
        this.created_user_id = cuid;
        this.total_exp = total_exp;
        this.partners = partners;
    }
}

class Due {
    // due = [ { dId, uId, grp_id, eId, grp_name, name_of_exp, amount, status } ]
    public String due_name, GroupName, Status, DDateTime;
    public int DueId, UserId, GroupId, ExpId;
    public double ExpAmount;

    Due(String due_name, String GroupName, String Status, int DueId, int UserId, int GroupId, int ExpId,
            double ExpAmount, String DDateTime) {
        this.due_name = due_name;
        this.GroupName = GroupName;
        this.Status = Status;
        this.DueId = DueId;
        this.UserId = UserId;
        this.GroupId = GroupId;
        this.ExpId = ExpId;
        this.ExpAmount = ExpAmount;
        this.DDateTime = DDateTime;
    }
}

class User {

    private static Scanner sc = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<>(); // []
    static ArrayList<Groups> groups = new ArrayList<>();
    static ArrayList<Expense> expenses = new ArrayList<>();
    static ArrayList<Due> dues = new ArrayList<>();

    static int cur_user = 0;
    static int user_id_generator = 0;
    static int exp_id_generator = 0;
    static int grp_id_gen = 0;
    static int due_id_generator = 0;

    // users = [ { uId:0, Name:"Dharun", Email:"dha@gmail.com", Password: "123",
    // wallet: 1000 }, {uId:1, Name:"Arun", Email:"arun@gmail.com", Password: "123",
    // wallet: 1000 } ] [] users.get(1).Name
    // expence = [ { typeOfExpence, grp_id, eID, name_of_exp, totalExpence,
    // createdBy, Datetime, [u1,u2,u3] } ]
    // group = [ { grp_id: 0, grp_name: "foodie", members : [0,1,2,3] } ]
    // due = [ { dId, uId, grp_id, eId, grp_name, name_of_exp, amount, status, DateTime
    // } ]

    public String Name, Email, Password;
    public int Wallet, uId;

    User(int uId, String name, String email, String password, int wallet) {
        this.uId = uId;
        this.Name = name;
        this.Email = email;
        this.Password = password;
        this.Wallet = wallet;
    }

    static String getDateTime() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return myDateObj.format(myFormatObj);
    }

    static void clear() {
        System.out.print("\033[H\033[2J");
    }

    static void login() {
        clear();
        System.out.print("\nEnter your email : ");
        String email = sc.next();
        System.out.print("\nEnter your password : ");
        String password = sc.next();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).Email.equals(email) && users.get(i).Password.equals(password)) {
                cur_user = users.get(i).uId;
                userMain();
            }
        }
        System.out.print("\nInvalid Credentials\nPress enter to continue");
        try {
            System.in.read();
            splitwise.appMain();
        } catch (Exception e) {
        }
    }

    static void register() {
        clear();
        System.out.print("\nEnter your name : ");
        String name = sc.next();
        System.out.print("\nEnter your Email : ");
        String email = sc.next();
        System.out.print("\nEnter your password : ");
        String password = sc.next();
        users.add(new User(user_id_generator, name, email, password, 1000)); // registration of new user
        cur_user = user_id_generator;
        user_id_generator++;
        System.out.print("\nRegistration Success\nPress enter to continue");
        try {
            System.in.read();
            userMain();
        } catch (Exception e) {
        }
    }

    static void userMain() {
        clear();
        System.out.println("--------------- Welcome " + users.get(cur_user).Name + " ---------------");
        System.out.print(
                "\n1. Groups\n2. Non Groups\n3. Update Wallet\n4. Create Group\n5. Logout\nWallet Balence : "
                        + users.get(cur_user).Wallet + "\nEnter your choice : ");
        int n = sc.nextInt();
        if (n == 1) {
            groups();
        } else if (n == 2) {
            nonGroupMenu();
        } else if (n == 3) {
            updateWallet();
        } else if (n == 4) {
            createGroup();
        } else if (n == 5) {
            splitwise.appMain();
        } else {
            System.out.print("\nInvalid choice\nPress enter to continue");
            try {
                System.in.read();
                userMain();
            } catch (Exception e) {
            }
        }
    }

    static void nonGroupMenu() {
        clear();
        System.out.print(
                "\n1. Expenses\n2.Add Expenses\n3.View Dues\n4.Transaction History\n5.Back\nEnter your choice : ");
        int n = sc.nextInt();
        if (n == 1) {
            nonGrpExpenses();
        } else if (n == 2) {
            addNonGrpExpense();
        } else if (n == 3) {
            viewNonGrpDues();
        } else if (n == 4) {
            nonGrpTraHis();
        } else if (n == 5) {
            userMain();
        } else {
            System.out.print("\nInvalid choice\nPress enter to continue");
            try {
                System.in.read();
                nonGroupMenu();
            } catch (Exception e) {
            }
        }
    }

    static void nonGrpTraHis() {
        clear();
        System.out.printf("\n%-15s%-20s%-10s%-20s%-25s", "Name", "Expense", "Amount", "Expense By", "Date/Time");
        for (int i = 0; i < dues.size(); i++) {
            if (expenses.get(dues.get(i).ExpId).type_of_exp.equals("Non-Group")
                    && dues.get(i).Status.equals("Paid") && dues.get(i).UserId == cur_user) {
                System.out.printf("\n%-15s%-20s%-10s%-20s%-25s", users.get(dues.get(i).UserId).Name,
                        dues.get(i).due_name,
                        dues.get(i).ExpAmount, users.get(expenses.get(dues.get(i).ExpId).created_user_id).Name,
                        dues.get(i).DDateTime);
            }
        }
        System.out.println("\n\nPress enter to continue");
        try {
            System.in.read();
            nonGroupMenu();
        } catch (Exception e) {
        }
    }

    static void viewNonGrpDues() {
        clear();
        boolean flag = false;
        System.out.printf("\n%-10s%-20s%-10s%-20s", "Due Id", "Expense", "Amount", "Expense By");
        for (int i = 0; i < dues.size(); i++) {
            if (dues.get(i).UserId == cur_user && dues.get(i).Status.equals("Pending")
                    && expenses.get(dues.get(i).ExpId).type_of_exp.equals("Non-Group")) {
                flag = true;
                System.out.printf("\n%-10d%-20s%-10.2f%-20s", dues.get(i).DueId, dues.get(i).due_name,
                        dues.get(i).ExpAmount, users.get(expenses.get(dues.get(i).ExpId).created_user_id).Name);
            }
        }
        if (flag) {
            System.out.print("\nDo you want to pay your due? (y/n) : ");
            String option = sc.next();
            if (option.equals("y")) {
                System.out.print("\nEnter No. of payments : ");
                int n = sc.nextInt();
                for (int i = 0; i < n; i++){
                    System.out.print("\nEnter Due Id : ");
                    int dId = sc.nextInt();

                    if (users.get(cur_user).Wallet >= dues.get(dId).ExpAmount) {
                        users.get(expenses.get(dues.get(i).ExpId).created_user_id).Wallet += dues.get(dId).ExpAmount;
                        users.get(cur_user).Wallet -= dues.get(dId).ExpAmount;
                        dues.get(dId).Status = "Paid";
                        dues.get(dId).DDateTime = getDateTime();
                        System.out.print("\nPayment Done Successfully\nPress enter to continue");
                        try {
                            System.in.read();
                        } catch (Exception e) {
                        }

                    } else {
                        System.out.print("\nInsufficient funds in wallet\nPress enter to continue");
                        try {
                            System.in.read();
                            nonGroupMenu();
                        } catch (Exception e) {
                        }
                    }
                }
                System.out.print("\nPayments Done Successfully\nPress enter to continue");
                try {
                    System.in.read();
                    nonGroupMenu();
                } catch (Exception e) {
                }
            } else {
                System.out.print("\nPress enter to go back");
                try {
                    System.in.read();
                    nonGroupMenu();
                } catch (Exception e) {
                }
            }
        } else {
            System.out.print("\n--------No Dues!---------\nPress enter to go back");
            try {
                System.in.read();
                nonGroupMenu();
            } catch (Exception e) {
            }
        }
    }

    static void addNonGrpExpense() {
        clear();
        ArrayList<Integer> tempNg = new ArrayList<>();
        groups.add(new Groups(grp_id_gen, users.get(cur_user).Name.substring(0, 3) + "NG", "Non-Group", tempNg));
        int newGrpId = grp_id_gen;
        grp_id_gen++;
        System.out.printf("\n%-10s%-15s", "User ID", "Name");
        for (int i = 0; i < users.size(); i++) {
            System.out.printf("\n%-10d%-15s", users.get(i).uId, users.get(i).Name);
        }
        groups.get(newGrpId).members.add(cur_user);
        System.out.print("\nEnter No. of Friends to add : ");
        int noOfFriends = sc.nextInt();

        // adding friends to group
        for (int i = 0; i < noOfFriends; i++) {
            System.out.println("\nEnter Friend User ID : ");
            int userId = sc.nextInt();
            if (!groups.get(newGrpId).members.contains(userId)) {
                groups.get(newGrpId).members.add(userId);
                System.out.print("\nAdded " + users.get(userId).Name + "!");
            } else {
                System.out.print("\nFriend Already Added");
                i--;
            }
        }

        System.out.print("\nExpense Name : ");
        String expenseName = sc.next();
        System.out.print("\nTotal Expense : ");
        int expenseAmount = sc.nextInt();

        String DT = getDateTime();
        ArrayList<Integer> dummy = new ArrayList<Integer>();
        dummy.addAll(groups.get(newGrpId).members);
        // creating expense
        expenses.add(
                new Expense("Non-Group", expenseName, DT, newGrpId, exp_id_generator, cur_user, expenseAmount, dummy));
        // creating Dues

        System.out.println("1. Split the expense equally\n2. Split by Individual\nEnter your choice : ");
        int option = sc.nextInt();
        if (option == 1) {

            double IndividualExpenses = expenseAmount / groups.get(newGrpId).members.size();
            System.out.println(IndividualExpenses);
            for (int i = 0; i < groups.get(newGrpId).members.size(); i++) {
                if (groups.get(newGrpId).members.get(i) != cur_user) {
                    dues.add(new Due(expenseName, groups.get(newGrpId).grp_name, "Pending", due_id_generator,
                            groups.get(newGrpId).members.get(i), newGrpId,
                            exp_id_generator, IndividualExpenses, "00-00-0000 00:00:00"));
                } else {
                    dues.add(new Due(expenseName, groups.get(newGrpId).grp_name, "Paid", due_id_generator,
                            groups.get(newGrpId).members.get(i), newGrpId,
                            exp_id_generator, IndividualExpenses, getDateTime()));
                }
                due_id_generator++;
            }
            exp_id_generator++;
        } else if (option == 2) {
            int remExp = expenseAmount;
            for (int i = 0; i < groups.get(newGrpId).members.size(); i++) {
                System.out.print("\nEnter Amount for " + users.get(groups.get(newGrpId).members.get(i)).Name
                        + " (Remaining Shareable : " + remExp + " )" + " : ");
                int amt = sc.nextInt();
                if (remExp >= amt) {
                    remExp-=amt;
                    if (groups.get(newGrpId).members.get(i) != cur_user) {
                        dues.add(new Due(expenseName, groups.get(newGrpId).grp_name, "Pending", due_id_generator,
                                groups.get(newGrpId).members.get(i), newGrpId,
                                exp_id_generator, amt, "00-00-0000 00:00:00"));
                    } else {
                        dues.add(new Due(expenseName, groups.get(newGrpId).grp_name, "Paid", due_id_generator,
                                groups.get(newGrpId).members.get(i), newGrpId,
                                exp_id_generator, amt, getDateTime()));
                    }
                    due_id_generator++;
                } else {
                    System.out.println("Total shareable amount cannot execeed then the total expense amount\nPlease Try again");
                    i--;
                }
            }
            exp_id_generator++;
        } else {
            System.out.print("\nInvalid choice\nPress enter to continue");
            try {
                System.in.read();
                nonGroupMenu();
            } catch (Exception e) {
            }
        }

        System.out.println("\n\nExpense Creation Done Successfully!\nPress enter to continue");
        try {
            System.in.read();
            nonGroupMenu();
        } catch (Exception e) {
        }
    }

    static void nonGrpExpDetails(int eid) {
        clear();
        int dummy[] = new int[groups.get(expenses.get(eid).grp_id).members.size()];
        int x = 0;
        for (int i = 0; i < groups.get(expenses.get(eid).grp_id).members.size(); i++) {
            for (int j = 0; j < dues.size(); j++) {
                if (dues.get(j).ExpId == eid
                        && dues.get(j).UserId == groups.get(expenses.get(eid).grp_id).members.get(i)) {
                    dummy[x] = dues.get(j).DueId;
                    x++;
                }
            }
        }

        System.out.println("\nNon-Groups -> " + groups.get(expenses.get(eid).grp_id).grp_name + " -> "
                + expenses.get(eid).name_of_exp);
        System.out.println("----------------------------");
        System.out.println("Expense Added by : " + users.get(expenses.get(eid).created_user_id).Name);
        System.out.println("Total Expense Amount : " + expenses.get(eid).total_exp);
        System.out.print("\n" + expenses.get(eid).name_of_exp);
        for (int i = 0; i < groups.get(expenses.get(eid).grp_id).members.size(); i++) {
            System.out.printf("\n|\n------ " + users.get(groups.get(expenses.get(eid).grp_id).members.get(i)).Name
                    + " " + dues.get(dummy[i]).ExpAmount + " " + dues.get(dummy[i]).Status + " "
                    + dues.get(dummy[i]).DDateTime);
        }
        System.out.print("\nPress enter to continue");
        try {
            System.in.read();
            nonGroupMenu();
        } catch (Exception e) {
        }
    }

    static void nonGrpExpenses() {
        clear();
        boolean flag = false;
        System.out.println("------------ Expenses ------------");
        System.out.printf("\n%-18s%-20s", "Expense ID", "Expense Name\n");
        for (int i = 0; i < expenses.size(); i++) {
            if (expenses.get(i).partners.contains(cur_user) && expenses.get(i).type_of_exp.equals("Non-Group")) {
                flag = true;
                System.out.printf("\n%-18d%-20s\n", expenses.get(i).exp_id, expenses.get(i).name_of_exp);
            }
        }
        System.out.print("\n\nDo you want to view the expense? (y/n) : ");
        String option = sc.next();
        if (option.equals("y")) {
            if (flag) {
                System.out.println("------------------------");
                System.out.print("\nEnter Expense ID : ");
                int eid = sc.nextInt();
                nonGrpExpDetails(eid);
            } else {
                System.out.print("\n---------- No Expense Available ---------\nPress enter to continue");
                try {
                    System.in.read();
                    nonGroupMenu();
                } catch (Exception e) {
                }
            }
        } else {
            System.out.print("\nPress enter to continue");
            try {
                System.in.read();
                nonGroupMenu();
            } catch (Exception e) {
            }
        }
    }

    static void updateWallet() {
        clear();
        System.out.print("\nEnter Amount to Deposit : ");
        users.get(cur_user).Wallet += sc.nextInt();
        System.out.print("\nAmount added to wallet : " + users.get(cur_user).Wallet + "\nPress enter to continue");
        try {
            System.in.read();
            userMain();
        } catch (Exception e) {
        }
    }

    static void createGroup() {
        clear();
        System.out.print("\nEnter Group Name : ");
        String groupName = sc.next();

        // creating group
        ArrayList<Integer> dummy = new ArrayList<>();
        int newGrpId = grp_id_gen;
        groups.add(new Groups(grp_id_gen, groupName, "Group", dummy));
        grp_id_gen++;

        // printing available friends
        System.out.printf("\n%-10s%-15s", "User ID", "Name");
        for (int i = 0; i < users.size(); i++) {
            System.out.printf("\n%-10d%-15s", users.get(i).uId, users.get(i).Name);
        }
        groups.get(newGrpId).members.add(cur_user);

        System.out.print("\nEnter No. of Friends to add : ");
        int noOfFriends = sc.nextInt();

        // adding friends to group
        for (int i = 0; i < noOfFriends; i++) {
            System.out.println("\nEnter Friend User ID : ");
            int userId = sc.nextInt();
            if (!groups.get(newGrpId).members.contains(userId)) {
                groups.get(newGrpId).members.add(userId);
                System.out.print("\nAdded " + users.get(userId).Name + "!");
            } else {
                System.out.print("\nFriend Already in the Group");
                i--;
            }
        }

        System.out.println("\n\nGroup Creation Done Successfully!\nPress enter to continue");
        try {
            System.in.read();
            userMain();
        } catch (Exception e) {
        }
    }

    static void groups() {
        clear();
        boolean flag = false;
        System.out.println("------------ Groups ------------");
        System.out.printf("\n%-10s%-20s", "Group ID", "Group Name\n");
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).members.contains(cur_user) && groups.get(i).typeOfGroup.equals("Group")) {
                flag = true;
                System.out.printf("\n%-10d%-20s\n", groups.get(i).grp_id, groups.get(i).grp_name);
            }
        }
        System.out.print("\n\nWant Enter the group? (y/n) : ");
        String option = sc.next();
        if (option.equals("y")) {
            if (flag) {
                System.out.println("------------------------");
                System.out.print("\nEnter Group ID : ");
                int gid = sc.nextInt();
                groupMenu(gid);
            } else {
                System.out.print("\n----------No Groups---------\nPress enter to continue");
                try {
                    System.in.read();
                    userMain();
                } catch (Exception e) {
                }
            }
        } else {
            System.out.print("\nPress enter to continue");
            try {
                System.in.read();
                userMain();
            } catch (Exception e) {
            }
        }
    }

    static void groupMenu(int gid) {
        clear();
        System.out.print(
                "\nGroups -> " + groups.get(gid).grp_name
                        + "\n--------------------"
                        + "\n1. Expenses\n2. Add Expense\n3. Add Friends\n4. Remove Friends\n5. View Dues\n6. Transaction History\n7. Back\n\nEnter your choice : ");
        int n = sc.nextInt();
        if (n == 1) {
            expenses(gid);
        } else if (n == 2) {
            addExpense(gid);
        } else if (n == 3) {
            addFriend(gid);
        } else if (n == 4) {
            removeFriend(gid);
        } else if (n == 5) {
            viewDues(gid);
        } else if (n == 6) {
            transactionHistory(gid);
        } else if (n == 7) {
            userMain();
        } else {
            System.out.print("\nInvalid choice\nPress enter to continue");
            try {
                System.in.read();
                groupMenu(gid);
            } catch (Exception e) {
            }
        }

    }

    static void expenseDetails(int eid, int gid) {
        clear();
        int dummy[] = new int[groups.get(gid).members.size()];
        int x = 0;
        for (int i = 0; i < groups.get(gid).members.size(); i++) {
            for (int j = 0; j < dues.size(); j++) {
                if (dues.get(j).ExpId == eid && dues.get(j).UserId == groups.get(gid).members.get(i)) {
                    dummy[x] = dues.get(j).DueId;
                    x++;
                }
            }
        }

        System.out.println("\nGroups -> " + groups.get(gid).grp_name + " -> " + expenses.get(eid).name_of_exp);
        System.out.println("----------------------------");
        System.out.println("\nExpense Added by : " + users.get(expenses.get(eid).created_user_id).Name);
        System.out.println("Total Expense Amount : " + expenses.get(eid).total_exp);
        System.out.print("\n" + expenses.get(eid).name_of_exp);
        for (int i = 0; i < groups.get(gid).members.size(); i++) {
            System.out.printf("\n|\n------ " + users.get(groups.get(gid).members.get(i)).Name + " "
                    + dues.get(dummy[i]).ExpAmount + " " + dues.get(dummy[i]).Status + " " + dues.get(dummy[i]).DDateTime);
        }
        System.out.print("\nPress enter to continue");
        try {
            System.in.read();
            groupMenu(gid);
        } catch (Exception e) {
        }

    }

    static void expenses(int gid) {
        clear();
        boolean flag = false;
        System.out.println("------------ Expenses ------------");
        System.out.printf("\n%-18s%-20s", "Expense ID", "Expense Name\n");
        for (int i = 0; i < expenses.size(); i++) {
            if (expenses.get(i).grp_id == gid && expenses.get(i).type_of_exp == "Group") {
                flag = true;
                System.out.printf("\n%-18d%-20s\n", expenses.get(i).exp_id, expenses.get(i).name_of_exp);
            }
        }
        System.out.print("\n\nDo you want to view the expense? (y/n) : ");
        String option = sc.next();
        if (option.equals("y")) {
            if (flag) {
                System.out.println("------------------------");
                System.out.print("\nEnter Expense ID : ");
                int eid = sc.nextInt();
                expenseDetails(eid, gid);
            } else {
                System.out.print("\n---------- No Expense Available ---------\nPress enter to continue");
                try {
                    System.in.read();
                    groupMenu(gid);
                } catch (Exception e) {
                }
            }
        } else {
            System.out.print("\nPress enter to continue");
            try {
                System.in.read();
                groupMenu(gid);
            } catch (Exception e) {
            }
        }
    }

    static void transactionHistory(int gid) {
        clear();
        System.out.printf("\n%-15s%-20s%-10s%-20s%-25s", "Name", "Expense", "Amount", "Expense By", "Date/Time");
        for (int i = 0; i < dues.size(); i++) {
            if (dues.get(i).GroupId == gid
                    && dues.get(i).Status.equals("Paid")) {
                System.out.printf("\n%-15s%-20s%-10s%-20s%-25s", users.get(dues.get(i).UserId).Name,
                        dues.get(i).due_name,
                        dues.get(i).ExpAmount, users.get(expenses.get(dues.get(i).ExpId).created_user_id).Name,
                        dues.get(i).DDateTime);
            }
        }
        System.out.println("\n\nPress enter to continue");
        try {
            System.in.read();
            groupMenu(gid);
        } catch (Exception e) {
        }

    }

    static void addFriend(int gid) {
        clear();
        System.out.printf("\n%-10s%-15s", "User ID", "Name");
        for (int i = 0; i < users.size(); i++) {
            System.out.printf("\n%-10d%-15s", users.get(i).uId, users.get(i).Name);
        }
        System.out.print("\nEnter No. of Friends to add : ");
        int noOfFriends = sc.nextInt();

        for (int i = 0; i < noOfFriends; i++) {
            System.out.println("\nEnter Friend User ID : ");
            int userId = sc.nextInt();
            if (!groups.get(gid).members.contains(userId)) {
                groups.get(gid).members.add(userId);
                System.out.print("\nAdded " + users.get(userId).Name + "!");
            } else {
                System.out.print("\nFriend Already in the Group");
                i--;
            }
        }

        System.out.println("\nFriends Added Successfully!\nPress enter to continue");
        try {
            System.in.read();
            groupMenu(gid);
        } catch (Exception e) {
        }
    }

    static void removeFriend(int gid) {
        clear();
        System.out.printf("\n%-10s%-15s", "User ID", "Name");
        for (int i = 0; i < groups.get(gid).members.size(); i++) {
            System.out.printf("\n%-10d%-15s", groups.get(gid).members.get(i),
                    users.get(groups.get(gid).members.get(i)).Name);
        }
        System.out.print("\nEnter No. of Friends to Remove : ");
        int noOfFriends = sc.nextInt();
        for (int i = 0; i < noOfFriends; i++) {
            System.out.println("\nEnter Friend User ID : ");
            int userId = sc.nextInt();
            if (groups.get(gid).members.contains(userId)) {
                int indx = groups.get(gid).members.indexOf(userId);
                groups.get(gid).members.remove(indx);
                System.out.print("\nRemoved " + users.get(userId).Name + "!");
            } else {
                System.out.print("\nFriend Not in the Group");
                i--;
            }
        }
        System.out.println("\nFriends Removed Successfully!\nPress enter to continue");
        try {
            System.in.read();
            groupMenu(gid);
        } catch (Exception e) {
        }
    }

    static void viewDues(int gid) {
        clear();
        boolean flag = false;
        System.out.printf("\n%-10s%-20s%-10s%-20s", "Due Id", "Expense", "Amount", "Expense By");
        for (int i = 0; i < dues.size(); i++) {
            if (dues.get(i).UserId == cur_user && dues.get(i).GroupId == gid
                    && dues.get(i).Status.equals("Pending")) {
                flag = true;
                System.out.printf("\n%-10d%-20s%-10.2f%-20s", dues.get(i).DueId, dues.get(i).due_name,
                        dues.get(i).ExpAmount, users.get(expenses.get(dues.get(i).ExpId).created_user_id).Name);
            }
        }
        if (flag) {
            System.out.print("\nDo you want to pay your due? (y/n) : ");
            String option = sc.next();
            if (option.equals("y")) {
                System.out.print("\nEnter No. of payments : ");
                int n = sc.nextInt();
                for (int i = 0; i < n; i++) {
                    System.out.print("\nEnter Due Id : ");
                    int dId = sc.nextInt();

                    if (users.get(cur_user).Wallet >= dues.get(dId).ExpAmount) {
                        users.get(expenses.get(dues.get(i).ExpId).created_user_id).Wallet += dues.get(dId).ExpAmount;
                        users.get(cur_user).Wallet -= dues.get(dId).ExpAmount;
                        dues.get(dId).Status = "Paid";
                        dues.get(dId).DDateTime = getDateTime();
                        System.out.print("\nPayment Done Successfully\nPress enter to continue");
                        try {
                            System.in.read();
                        } catch (Exception e) {
                        }

                    } else {
                        System.out.print("\nInsufficient funds in wallet\nPress enter to continue");
                        try {
                            System.in.read();
                            groupMenu(gid);
                        } catch (Exception e) {
                        }
                    }
                }
                System.out.print("\nPayments Done Successfully\nPress enter to continue");
                try {
                    System.in.read();
                    groupMenu(gid);
                } catch (Exception e) {
                }
            } else {
                System.out.print("\nPress enter to go back");
                try {
                    System.in.read();
                    groupMenu(gid);
                } catch (Exception e) {
                }
            }
        } else {
            System.out.print("\n--------No Dues!---------\nPress enter to go back");
            try {
                System.in.read();
                groupMenu(gid);
            } catch (Exception e) {
            }
        }

    }

    static void addExpense(int gid) {
        clear();
        System.out.print("\nExpense Name : ");
        String expenseName = sc.next();
        System.out.print("\nTotal Expense : ");
        int expenseAmount = sc.nextInt();

        String DT = getDateTime();
        ArrayList<Integer> dummy = new ArrayList<Integer>();
        dummy.addAll(groups.get(gid).members);
        // creating expense
        expenses.add(new Expense("Group", expenseName, DT, gid, exp_id_generator, cur_user, expenseAmount, dummy));
        // creating Dues
        double IndividualExpenses = expenseAmount / groups.get(gid).members.size();
        System.out.println(IndividualExpenses);
        for (int i = 0; i < groups.get(gid).members.size(); i++) {
            if (groups.get(gid).members.get(i) != cur_user) {
                dues.add(new Due(expenseName, groups.get(gid).grp_name, "Pending", due_id_generator,
                        groups.get(gid).members.get(i), gid,
                        exp_id_generator, IndividualExpenses, "00-00-0000 00:00:00"));
            } else {
                dues.add(new Due(expenseName, groups.get(gid).grp_name, "Paid", due_id_generator,
                        groups.get(gid).members.get(i), gid,
                        exp_id_generator, IndividualExpenses, getDateTime()));
            }
            due_id_generator++;
        }
        exp_id_generator++;
        System.out.print("\nExpense Added Successfully\nPress enter to continue");
        try {
            System.in.read();
            groupMenu(gid);
        } catch (Exception e) {
        }
    }

}
