
import java.util.*;
                                          ADMIN[name/password] -> arun / password
                                          USER[name/password/id] -> Ritthik / 123 / Arun

//train_info => [ { id, name, route, stations }, ... ]
// Users => [ { name, id, password }, ... ]
// Tricket Details => [ {train1, route, Booked},{train2, route, Booked},{train3, route, Cancelled} ]

public class Railway {
    static Scanner sc;

    static void clear() {
        System.out.print("\033[H\033[2J");
    }

    static void railway_main() {
        clear();
        System.out.println("1.admin Login");
        System.out.println("2.User Login");
        System.out.println("3.Exit");
        int n = sc.nextInt();

        if (n == 1) {
            admin.login();
        } else if (n == 2) {
            User.user_main_1();
        } else if (n == 3) {
            System.exit(0);

        } else {
            System.out.println("Invalid option!..");
            System.out.println();
            System.out.println("Press enter to continue!..");
            try {
                System.in.read();
                railway_main();
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        for (int i = 0; i < admin.horizontal_length; i++) {
            admin.Train.add(new ArrayList<ArrayList<String>>(admin.vertical_length));
            for (int j = 0; j < admin.vertical_length; j++) {
                admin.Train.get(i).add(new ArrayList<String>(Arrays.asList("0", "0", "0")));
            }
        }
        admin.train_info.add(new TrainClass(String.valueOf(admin.train_id_gen), "ChennaiExpress", "Chennai-Bombay","Chennai Hydrabad Bombay"));
        admin.train_id_gen++;

        User.Users.add(new User("Arun", "Ritthik", "123"));

        railway_main();
    }
}

class TrainClass {
    public String train_id;
    public String train_name;
    public String train_route;
    public String train_station;

    TrainClass(String train_id, String train_name, String train_route, String train_station) {
        this.train_id = train_id;
        this.train_name = train_name;
        this.train_route = train_route;
        this.train_station = train_station;
    }

}

class admin {
    static boolean reached = false;
    static int train_id_gen = 1;

    static int horizontal_length = 1;
    static int vertical_length = 5;

    static ArrayList<ArrayList<ArrayList<String>>> Train = new ArrayList<>(horizontal_length);
    static List<TrainClass> train_info = new ArrayList<>();

    private static Scanner sc = new Scanner(System.in);
    static String admin_id = "arun";
    static String admin_pass = "ritthik";

    static void login() {
        Railway.clear();
        System.out.println("\t......................Welcome to admin Login......................");
        System.out.println("Enter your admin Id : ");
        String adminId = sc.next();
        sc.nextLine();
        System.out.println("Enter Password : ");
        String password = sc.next();
        sc.nextLine();

        if (adminId.equals(admin_id) && password.equals(admin_pass)) {
            admin_main();
        } else {
            System.out.println("Invalid Credentials");
            try {
                System.in.read();
                Railway.railway_main();
            } catch (Exception e) {
            }
        }
    }

    static void admin_main() {
        Railway.clear();
        System.out.println("1 -> Add Train\n2 -> Add seats \n3 -> View trains\n4 -> Exit");

        int AdminOption = sc.nextInt();

        if (AdminOption == 1) {
            addTrain();
        } else if (AdminOption == 2) {
            add_seats();
        } else if (AdminOption == 3) {
            reached = true;
            print_train();
        } else if (AdminOption == 4) {
            Railway.railway_main();
        } else {
            System.out.println("Invalid Option");
            try {
                System.in.read();
                admin_main();
            } catch (Exception e) {
            }
        }

    }

    static void addTrain() {
        Railway.clear();

        System.out.print("Enter Name : ");
        String Name = sc.next();

        System.out.print("Enter Route : ");
        String Route = sc.next();

        System.out.print("Enter Stations : ");
        sc.nextLine();
        String Stations = sc.nextLine();

        Train.add(new ArrayList<ArrayList<String>>()); //[[],[]]
        train_info.add(new TrainClass(String.valueOf(train_id_gen), Name, Route, Stations));
        train_id_gen++;

        System.out.println("Press 1 to continue!..");
        try {
            System.in.read();
            admin_main();
        } catch (Exception e) {
        }
    }

    static int getAvailability(int index) {
        int res = 0;
        for (int j = 0; j < Train.get(index).size(); j++) {
            for (int k = 0; k < Train.get(index).get(j).size(); k++) {
                if (Train.get(index).get(j).get(k).equals("0")) {
                    res++;
                }
            }
        }

        return res;
    }

    static void print_train() {
        Railway.clear();
        System.out.println("--------------------------------");
        for (int i = 0; i < Train.size(); i++) {
            for (int j = 0; j < Train.get(i).size(); j++) {
                for (int k = 0; k < Train.get(i).get(j).size(); k++) {
                    System.out.printf("%-5s", Train.get(i).get(j).get(k));
                }
                System.out.println();
            }

            System.out.println("Train Id : " + train_info.get(i).train_id + "\n" + "Train Name : " + train_info.get(i).train_name + "\n" + "Train Route : " + train_info.get(i).train_route + "\n" + "Train Stations : " + train_info.get(i).train_station);
            System.out.println(
                    "Availability of Seats : " + getAvailability(Integer.parseInt(train_info.get(i).train_id) - 1));
            System.out.println("..............");
        }
        System.out.println("Press enter to continue!..");

        try {
            System.in.read();
            if (reached) {
                admin_main();
            } else {
                User.user_main();
            }
        } catch (Exception e) {
        }
    }

    static void add_seats() {
        Railway.clear();

        System.out.println("Enter Train Id : ");
        String id = sc.next();
        boolean is_id_present = false;
        // train_info = [{1,...},{2,..},{3,...}]
        for (int i = 0; i < train_info.size(); i++) {
            if (train_info.get(i).train_id.equals(id)) {
                is_id_present = true;
            }
        }

        if (is_id_present) {

            System.out.println("Enter No of Seats : ");
            int No = sc.nextInt();

            int Id = Integer.parseInt(id) - 1;

            if (Train.get(Id).size() == 0) {
                for (int i = 0; i < No; i++) {
                    String[] temp1 = train_info.get(Id).train_station.split(" "); 
                    ArrayList<String> temp = new ArrayList<String>();
                    for (int j = 0; j < temp1.length; j++) {
                        temp.add("0"); // [0,0,0]
                    }
                    Train.get(Id).add(temp);
                }
            } else {
                Train.get(Id).clear();
                for (int i = 0; i < No; i++) {
                    String[] temp1 = train_info.get(Id).train_station.split(" ");
                    ArrayList<String> temp = new ArrayList<String>();
                    for (int j = 0; j < temp1.length; j++) {
                        temp.add("0");
                    }
                    Train.get(Id).add(temp);
                }
            }

            System.out.println();
            System.out.println("............................Seat Declaration Done Successfully............................");
            System.out.println();
            System.out.println("Press enter to continue!..");
            try {
                System.in.read();
                admin_main();
            } catch (Exception e) {
            }
        } else {
            System.out.println();
            System.out.println("Invalid Train ID!..");
            System.out.println();
            System.out.println("Press enter to continue!..");
            try {
                System.in.read();
                admin_main();
            } catch (Exception e) {
            }
        }

    }

}

class User {

    private static Scanner sc = new Scanner(System.in);

    static List<User> Users = new ArrayList<>();
    static List<Tickets> ticket_details = new ArrayList<>();
    static Formatter fmt = new Formatter();

    static int iser_id_gen = 1;
    static boolean flag_is_book = false;

    public String UserId;
    public String UserName;
    public String UserPassword;

    static String CurrentUser = null;

    User(String userId, String userName, String userPassword) {
        this.UserId = userId;
        this.UserName = userName;
        this.UserPassword = userPassword;
    }

    static void user_main_1() {
        Railway.clear();
        System.out.print("----- Welcome To User Panel -----\n" + "\n1. New User Registration" + "\n2. Existing User Login" + "\n3. Exit" + "\nEnter your Choice : ");
        int choice = sc.nextInt();
        if (choice == 1) {
            registerUser();
        } else if (choice == 2) {
            login();
        } else if (choice == 3) {
            Railway.railway_main();
        } else {
            System.out.println("Invalid Option!..");
            System.out.println();
            System.out.println("Press enter to continue!...");
            try {
                System.in.read();
                user_main_1();
            } catch (Exception e) {
            }
        }
    }

    static void login() {
        Railway.clear();
        System.out.println("Enter your username");
        String username = sc.next();

        System.out.println("Enter your password");
        String password = sc.next();

        for (int i = 0; i < Users.size(); i++) {
            if (Users.get(i).UserName.equals(username) && Users.get(i).UserPassword.equals(password)) {
                CurrentUser = Users.get(i).UserId;
                user_main();
            }
        }

        System.out.println("Invalid Credentials!...");
        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            Railway.railway_main();
        } catch (Exception e) {
        }

    }

    static void user_main() {
        Railway.clear();
        System.out.println("1 -> Trains And Availability \n2 -> Book Tickets\n3 -> View Bookings\n4 -> Cancel Bookings\n5 -> Exit");
        int n = sc.nextInt();
        if (n == 1) {
            admin.reached = false;
            admin.print_train();
        } else if (n == 2) {
            book_tickets();
        } else if (n == 3) {
            view_bookings();
        } else if (n == 4) {
            cancel_bookings();
        } else if (n == 5) {
            Railway.railway_main();
        } else {
            System.out.println("Invalid option!...");
            System.out.println();
            System.out.println("Press enter to continue!...");
            try {
                System.in.read();
                user_main();
            } catch (Exception e) {
            }
        }

    }

    static void registerUser() {
        Railway.clear();
        System.out.println("Enter your username :");
        sc.nextLine();
        String username = sc.nextLine();

        System.out.println("Enter your password : ");
        String password = sc.next();

        String user_id = username.substring(0, 2) + String.valueOf(iser_id_gen);
        iser_id_gen++;

        Users.add(new User(user_id, username, password));

        System.out.println();
        System.out.println("Press enter to continue!...");
        try {
            System.in.read();
            user_main();
        } catch (Exception e) {
        }
    }

    static void book_tickets() {
        Railway.clear();
        System.out.println();
        System.out.println("................................ Trains Availablity ................................");
        System.out.println();
        System.out.printf("%-8s%-20s%-20s%-20s\n", "S/no", "Train Name", "Train Route", "Train ID");
        for (int i = 0; i < admin.train_info.size(); i++) {
            System.out.printf("%-8s%-20s%-20s%-20s\n", i + 1, admin.train_info.get(i).train_name,admin.train_info.get(i).train_route, admin.train_info.get(i).train_id);
        }
        System.out.println();
        System.out.println("Enter No of Booking : ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            Railway.clear();
            System.out.println("Enter Train ID : ");
            String train_id_book = sc.next();

            boolean is_id_present = false;
            // train_info = [{1,...},{2,..},{3,...}]
            for (int j = 0; j < admin.train_info.size(); j++) {
                if (admin.train_info.get(j).train_id.equals(train_id_book)) {
                    is_id_present = true;
                }
            }

            if (is_id_present) {

                printTrain(Integer.parseInt(train_id_book) - 1);

                System.out.println("Enter Station Entry : ");
                int stationIn = sc.nextInt();
                System.out.println("Enter the station Exit :");
                int stationOut = sc.nextInt();

                int tId = Integer.parseInt(train_id_book) - 1;
                flag_is_book = true;
                int SeatNo = bookSeat(stationIn, stationOut, tId, User.CurrentUser);

                if (SeatNo != -1) {
                    System.out.println("Your Seat No : " + SeatNo);
                } 
                else {
                    ticket_details.add(new Tickets(-1, CurrentUser, admin.train_info.get(tId).train_name,
                            admin.train_info.get(tId).train_route, "Pending",
                            Integer.parseInt(admin.train_info.get(tId).train_id),
                            -1, stationIn, stationOut));
                    System.out.println("Sorry!..Currenly No Seats Available...you are added in the waiting list");
                }

                System.out.println();
                System.out.println("Press enter to continue!...");
                try {
                    System.in.read();
                } catch (Exception e) {
                }
            } else {
                System.out.println();
                System.out.println("Invalid Train ID!..");
                System.out.println();
                System.out.println("Press enter to continue!...");
                try {
                    System.in.read();
                    book_tickets();
                } catch (Exception e) {
                }
            }
        }

        System.out.println();
        System.out.println("Press enter to continue!...");
        try {
            System.in.read();
            user_main();
        } catch (Exception e) {
        }

    }

    static void view_bookings() {
        Railway.clear();

        System.out.printf("%-15s%-20s%-20s%-13s%-13s%-13s%-5s\n", "Ticket No.", "Train Name", "Train Route", "Seat No.",
                "Station In", "Station Out", "Status");
        for (int i = 0; i < ticket_details.size(); i++) {
            if (ticket_details.get(i).PassangerId.equals(User.CurrentUser)) {

                System.out.printf("%-15d%-20s%-20s%-13s%-13d%-13d%-5s\n", ticket_details.get(i).Ticket_num,
                        ticket_details.get(i).Ticket_train_name, ticket_details.get(i).Ticket_train_route,
                        ticket_details.get(i).tic_train_seat, ticket_details.get(i).Ticket_Start,
                        ticket_details.get(i).Ticket_End, ticket_details.get(i).tic_ticket_status);
            }
        }
        System.out.println();
        System.out.println("Press enter to continue!...");
        try {
            System.in.read();
            user_main();
        } catch (Exception e) {
        }
    }

    static void printTrain(int tId) {
        System.out.println("--------------------------------");
        for (int j = 0; j < admin.Train.get(tId).size(); j++) {
            for (int k = 0; k < admin.Train.get(tId).get(j).size(); k++) {
                System.out.printf("%-5s", admin.Train.get(tId).get(j).get(k));
            }
            System.out.println();
        }
        System.out.println("Train Id : " + admin.train_info.get(tId).train_id + "\n" + "Train Name : "+ admin.train_info.get(tId).train_name + "\n" + "Train Route : " + admin.train_info.get(tId).train_route + "\n" + "Train Stations : " + admin.train_info.get(tId).train_station);
        System.out.println(
                "Availability of Seats : "
                        + admin.getAvailability(Integer.parseInt(admin.train_info.get(tId).train_id) - 1));
        System.out.println("..............");
        System.out.println();
    }

    static int bookSeat(int in, int out, int tId, String setUser) {

        int res = -1;
        for (int i = 0; i < admin.Train.get(tId).size(); i++) {
            int tot = 0, size = 0;
            for (int k = in - 1; k < out; k++) { 
                size++;
                if (admin.Train.get(tId).get(i).get(k).equals("0")) {
                    tot++;
                }
            }
            if (tot == size) {

                for (int k = in - 1; k < out; k++) {
                    admin.Train.get(tId).get(i).set(k, setUser);
                }
                res = i;
                if (flag_is_book) {
                    ticket_details.add(new Tickets(Tickets.tic_num_generator, User.CurrentUser,
                            admin.train_info.get(tId).train_name, admin.train_info.get(tId).train_route, "Booked",
                            Integer.parseInt(admin.train_info.get(tId).train_id), i, in, out));
                    Tickets.tic_num_generator++;
                }
                return res;
            }
        }

        return res;
    }

    static void bookPending() {
        flag_is_book = false;

        for (int i = 0; i < ticket_details.size(); i++) {
            if (ticket_details.get(i).tic_ticket_status.equals("Pending")) {
                int res = bookSeat(ticket_details.get(i).Ticket_Start, ticket_details.get(i).Ticket_End,
                        ticket_details.get(i).tic_train_id - 1, ticket_details.get(i).PassangerId);
                if (res != -1) {
                    ticket_details.get(i).tic_ticket_status = "Booked";
                    ticket_details.get(i).Ticket_num = Tickets.tic_num_generator;
                    ticket_details.get(i).tic_train_seat = res;

                    Tickets.tic_num_generator++;
                }
            }
        }
    }

    static void cancel_bookings() {
        Railway.clear();
        System.out.println("Enter Ticket No : ");
        int ticker_no = sc.nextInt();
        boolean flag_is_ticket = false;
        // train_info = [{1,...},{2,..},{3,...}]
        for (int i = 0; i < ticket_details.size(); i++) {
            if (ticket_details.get(i).Ticket_num == ticker_no) {
                flag_is_ticket = true;
            }
        }

        if (flag_is_ticket) {

            for (int i = 0; i < ticket_details.size(); i++) {
                if (ticket_details.get(i).Ticket_num == ticker_no) {
                    removeSeat(ticket_details.get(i).tic_train_id - 1, ticket_details.get(i).tic_train_seat,ticket_details.get(i).Ticket_Start, ticket_details.get(i).Ticket_End);
                    ticket_details.remove(i);
                    bookPending();
                    break;
                }
            }

            System.out.println();
            System.out.println("Ticket No. " + ticker_no + " Called Successfully!");
        } else {
            System.out.println();
            System.out.println("Ticket No. " + ticker_no + " Not Found Please Enter Valid Ticket Number!");
        }
        System.out.println();
        System.out.println("Press enter to continue!...");
        try {
            System.in.read();
            user_main();
        } catch (Exception e) {
        }
    }

    static void removeSeat(int tId, int tSeat, int tStart, int tEnd) {
        for (int j = tStart - 1; j < tEnd; j++) {
            admin.Train.get(tId).get(tSeat).set(j, "0");
        }
    }

}

class Tickets {

    static int tic_num_generator = 1;

    public int Ticket_num;
    public String PassangerId;
    public String Ticket_train_name;
    public String Ticket_train_route;
    public String tic_ticket_status;
    public int tic_train_id;
    public int tic_train_seat;
    public int Ticket_Start;
    public int Ticket_End;

    Tickets(int Ticket_num, String PassangerId, String Ticket_train_name, String Ticket_train_route,
        String tic_ticket_status, int tic_train_id, int tic_train_seat, int Ticket_Start, int Ticket_End) {
        this.Ticket_num = Ticket_num;
        this.PassangerId = PassangerId;
        this.Ticket_train_name = Ticket_train_name;
        this.Ticket_train_route = Ticket_train_route;
        this.tic_ticket_status = tic_ticket_status;
        this.tic_train_id = tic_train_id;
        this.tic_train_seat = tic_train_seat;
        this.Ticket_Start = Ticket_Start;
        this.Ticket_End = Ticket_End;
    }
}
