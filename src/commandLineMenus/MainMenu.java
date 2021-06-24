package commandLineMenus;

import api.AdminResource;
import api.HotelResource;
import model.*;
import service.CustomerService;
import service.ReservationService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMenu {
    private static Map<String,Customer> customers;
    private static Map<IRoom , Reservation> reservations;
    private  static CustomerService customerService;
    private static ReservationService reservationService;
    private static HotelResource hotelResource;
    private  static AdminResource adminResource;



    /*CONSTRUCTOR*/
    public MainMenu(){}
    public MainMenu(Map<String,Customer>customers, Map<IRoom,Reservation>reservations, CustomerService customerService, ReservationService reservationService, HotelResource hotelResource, AdminResource adminResource){
        this.customers = new HashMap<String,Customer>();
        this.reservations = new HashMap<IRoom,Reservation>();
        this.customerService = new CustomerService(this.customers);
        this.reservationService = new ReservationService(this.reservations);
        this.hotelResource = new HotelResource(this.reservationService,this.customerService);
        this.adminResource = new AdminResource(this.reservationService,this.customerService);
    }

    /*Getters + Setters*/

    public static HotelResource getHotelResource() {
        return hotelResource;
    }

    public static AdminResource getAdminResource() {
        return adminResource;
    }

    public static Map<String, Customer> getCustomers() {
        return customers;
    }

    public   static Map<IRoom, Reservation> getReservations() {
        return reservations;
    }

    public static CustomerService getCustomerService() { return customerService; }


    public static ReservationService getReservationService() { return reservationService; }

    public void setHotelResource(HotelResource hotelResource) { this.hotelResource = hotelResource; }

    public void setAdminResource(AdminResource adminResource) { this.adminResource = adminResource; }


    public void setCustomerService(CustomerService customerService) { this.customerService = customerService; }

    public void setReservationService(ReservationService reservationService) { this.reservationService = reservationService; }

    /*FUNCTIONAL METHODS*/
    /*GET ALL CUSTOMERS*/
    public static Collection<Customer> allCustomers(){
        return customerService.getAllCustomers();
    }

    /*CREATE AN ACCOUNT*/
    public static void createAccount(){
        System.out.println("Let's create an account.");
        /*The method need three parameters
         * 1 - email
         * 2 - firstname
         * 3 - lastname
         * */

        /*1 - ask the email */
        System.out.println("Please enter an email.");
        Scanner emailCreateAccountScanner = new Scanner(System.in);

        /*Check the right format for the email address*/
        String emailCreateAccountRegex = "^(.+)@(.+).(.+)$";
        Pattern emailCreateAccountPattern = Pattern.compile(emailCreateAccountRegex);


        String emailCreateAccount = emailCreateAccountScanner.nextLine();
        System.out.println("you type an email as : " + emailCreateAccount);

        Boolean testEmailAccount = false;
        testEmailAccount = emailCreateAccountPattern.matches(emailCreateAccountRegex,emailCreateAccount);

        String emailSeeReservation = null;
        Boolean testEmail = false;

        while(testEmailAccount == false){
            System.out.println("Please enter a right email for reservation.");
            emailSeeReservation = emailCreateAccountScanner.nextLine();

            testEmail = emailCreateAccountPattern.matches(emailCreateAccountRegex,emailCreateAccount);

            System.out.println("You enter : " + emailCreateAccount);
        }

        /*Ask the first name*/
        System.out.println("Then we need your firstname.");
        Scanner firstnameAccount = new Scanner(System.in);
        String firstnameCreateAccount = firstnameAccount.nextLine();
        System.out.println("Your firstname is : " + firstnameCreateAccount);

        /*Ask the lastname*/
        System.out.println("finally, we need your lastname.");
        Scanner lastnameAccount = new Scanner(System.in);
        String lastnameCreateAccount = lastnameAccount.nextLine();
        System.out.println("Your lastname is : " + lastnameCreateAccount);

        /*Invoke the method from Hotel Resource*/
        //this.hotelResource.createACustomer(emailCreateAccount,firstnameCreateAccount,lastnameCreateAccount);
        // METHOD FROM THE SERVICE CUSTOMER
        //public void addCustomer(String email,String firstname,String lastname)
        customerService.addCustomer(emailCreateAccount,firstnameCreateAccount,lastnameCreateAccount);
        /*TEST METHOD HERE FOR THE ADMIN*/
        //Collection<Customer> allCustomers = customerService.getAllCustomers();
        Collection<Customer> all =  allCustomers();
        /*free resources*/


    }

    /*EMAIL REGEX METHOD*/
    public static String emailRegex(){
        Scanner emailScanner = new Scanner(System.in);

        /*Check the right format for the email address*/
        String emailRegex = "^(.+)@(.+).(.+)$";
        Pattern emailPattern = Pattern.compile(emailRegex);

        String email = emailScanner.nextLine();
        System.out.println("you type an email as : " + email);

        Boolean testEmail = false;
        testEmail = emailPattern.matches(emailRegex,email);


        while(testEmail == false){
            System.out.println("Please enter a right email for reservation.");
            email = emailScanner.nextLine();

            testEmail = emailPattern.matches(emailRegex,email);

            System.out.println("You enter : " + email);

        }

        return email;
    }

    /*DATE REGEX METHOD*/
    public static Date dateCheckInRegex(){
        /*DATE FORMAT VERIFICATION*/
        String checkDateRegex = "^\\d{1,12}/\\d{1,31}/202\\d{1,9}$";
        Pattern checkDatePattern = Pattern.compile(checkDateRegex);


        /*Ask the inputs to the user*/
        System.out.println("Please enter your date for the check-in.");
        System.out.println("Write the check-in date in the format : MM/dd/YYYY");

        Scanner checkInDateScanner = new Scanner(System.in);
        String checkInDate = checkInDateScanner.nextLine();
        System.out.println("Your enter : " + checkInDate);

        boolean testCheckIn = false;

        testCheckIn = checkDatePattern.matches(checkDateRegex, checkInDate);
        /*MUST CREATE A LOOP FOR ASK THE RIGHT INPUTS TO THE USER*/
        while(testCheckIn == false){

            System.out.println("Please try again.");
            checkInDate = checkInDateScanner.nextLine();
            testCheckIn = checkDatePattern.matches(checkDateRegex, checkInDate);
            System.out.println("You enter as check in  : " + checkInDate);
        }
        /*String to date conversions */
        Date checkIn = null;
        try{
            checkIn = new Date();
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            checkIn = dateFormat.parse(checkInDate);

        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }

        return checkIn;
    }

    public static Date dateCheckOutRegex(){
        /*DATE FORMAT VERIFICATION*/
        String checkDateRegex = "^\\d{1,12}/\\d{1,31}/202\\d{1,9}$";
        Pattern checkDatePattern = Pattern.compile(checkDateRegex);

        System.out.println("Please en enter your checkout date.");
        Scanner checkOuDateScanner =  new Scanner(System.in);
        String checkOutDate = checkOuDateScanner.nextLine();

        System.out.println("As a check out date you enter : " + checkOutDate);

        boolean testCheckOut = false;
        testCheckOut = checkDatePattern.matches(checkDateRegex,checkOutDate);

        while(testCheckOut == false) {
            System.out.println("Please try again.");
            checkOutDate = checkOuDateScanner.nextLine();
            testCheckOut = checkDatePattern.matches(checkDateRegex,checkOutDate);
            System.out.println("You enter : " + checkOutDate);
        }
        Date checkOut = null;

        try{
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            checkOut = new Date();
            checkOut = dateFormat.parse(checkOutDate);
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        return checkOut;
    }

    /* Create a method for displaying the main menu*/
    public void displayMainMenu (Scanner scanner) {
        // public static void main(String[] args){

        boolean run = true;
        Scanner scannerMainMenu = new Scanner(System.in);

        while(run){

            /* *******************************MAIN MENU DISPLAYED* *******************************/
            System.out.println(" 1. Find and reserve a room.");
            System.out.println(" 2. See my reservations.");
            System.out.println(" 3. Create an account.");
            System.out.println(" 4. Admin");
            System.out.println(" 5. Exit");

            int answer = scannerMainMenu.nextInt();

            /*****Answer == 1  --> FIND AND RESERVE A ROOM  SECTION == two choices *****/
            switch (answer){

                /*case 1 = find and reserve a room section*/
                case 1:

                    System.out.println("-----------Choose the options to find and reserve a room---------------------");
                    System.out.println("1. Find a room.");
                    System.out.println("2. Reserve a room");

                    Scanner findAndReservation = new Scanner(System.in);
                    /* The answers for the FIND AND RESERVE A ROOM SECTION*/
                    int findAndReserveRoom = findAndReservation.nextInt();

                    /*******FIND A ROOM*****/
                    if(findAndReserveRoom == 1) {
                        System.out.println("Let's find a room");

                        /*check in date*/
                        Date checkIn = MainMenu.dateCheckInRegex();

                        /*Check out date*/
                        Date checkOut = MainMenu.dateCheckOutRegex();
                        try{
                            /*USE THE TWO VARIABLES FOR CALL THE HOTEL RESOURCE METHOD*/
                            hotelResource.findARoom(checkIn,checkOut);
                        }catch(Exception e){
                            System.out.println(e.getLocalizedMessage());
                            System.out.println("There is no rooms for these dates created yet.");
                        }
                    }
                    /*RESERVE A ROOM*/
                    /*Need several arguments = email + room + dates*/
                    else if(findAndReserveRoom == 2){
                        System.out.println("Let's reserve a room");
                        System.out.println("To start, we need your email address");

                        /*ask the email address
                         * Call the functional method.*/
                        String emailForReservation = MainMenu.emailRegex();

                        /*CHECK IF THE CUSTOMER EXISTS
                         * public Customer getCustomer (String email)
                         * */
                        Customer searchCustomer = hotelResource.getCustomer(emailForReservation);
                        /*IF NOT EXIST MUST CREATE AN ACCOUNT BEFORE RESERVATION !!*/
                        if(searchCustomer == null){
                            /*CREATE AN ACCOUNT*/
                            MainMenu.createAccount();
                        }else{
                            System.out.println("Thank you : " + searchCustomer);
                        }

                        /*ask the checkin and checkout dates*/

                        Date reservationCheckIn = MainMenu.dateCheckInRegex();
                        Date reservationCheckOut = MainMenu.dateCheckOutRegex();

                        /*Call the right method in Hotel Resource*/
                        /*MUST FIND A ROOM BEFORE BOOK A ROOM*/

                        try{
                          adminResource.displayAllRooms();

                        }catch(Exception e){
                            System.out.println(e.getLocalizedMessage());
                        }

                        /*create a scanner for the room input
                         * stocked in a variable that will be used in the method
                         * */
                        System.out.println("You can choose the room that you want to book.");
                        Scanner roomInputReservation = new Scanner(System.in);
                        int roomInputNumber = roomInputReservation.nextInt();


                        System.out.println("Please enter the right price for the night.");
                        Scanner roomInputPriceReservation = new Scanner(System.in);
                        double roomInputPrice = roomInputPriceReservation.nextDouble();


                        /*ROOM TYPE*/
                        String regexType = "^SINGLE|DOUBLE$";
                        Pattern checkTypePattern = Pattern.compile(regexType);

                        System.out.println("Finally enter the type of the room : SINGLE OR DOUBLE.");
                        Scanner roomInputTypeReservation = new Scanner(System.in);
                        String roomInputType = roomInputTypeReservation.nextLine();

                        boolean testType = false;
                        testType = checkTypePattern.matches(regexType,roomInputType);

                        while(testType == false) {
                            try {
                                System.out.println("Please try again : choose SINGLE or DOUBLE");

                                roomInputType = roomInputTypeReservation.nextLine();
                                testType = checkTypePattern.matches(regexType, roomInputType);
                                System.out.println("You choose the type : " + roomInputType);
                            } catch (Exception e) {
                                System.out.println(e.getLocalizedMessage());
                                System.out.println("Please Try again");
                            }

                        }
                        System.out.println("Thank you, we proceed, the reservation.");
                        String roomNumBer = Integer.toString(roomInputNumber);
                        /*ROOMTYE ENUM CONVERSION
                         * RoomType enumeration*/
                        RoomType roomType = RoomType.valueOf(roomInputType);

                        /*ROOM CREATION FOR BOOKING*/
                        IRoom roomReservation = new Room(roomNumBer, roomInputPrice, roomType);


                        /*A VOIR PLUS TARD A LA CREATION DE ROOMS !!!! POUR FIND ROOMS AUSSI !!!!!!!*/
                        try {
                            hotelResource.bookARoom(emailForReservation, roomReservation, reservationCheckIn, reservationCheckOut);
                        } catch (Exception e) {
                            System.out.println(e.getLocalizedMessage());
                            System.out.println("Sorry, there is no reservation possible yet");
                        }
                    }
                    break;
                /* 2 - SEE MY RESERVATIONS*/
                case 2 :
                    System.out.println("See my reservations ");

                    System.out.println("We need your email address");

                    /*ask the email address*/
                    String emailSeeReservation = MainMenu.emailRegex();

                    /*CALL THE RIGHT FUNCTION IN HOTEL RESOURCE*/
                    Customer customer = customerService.getCustomer(emailSeeReservation);
                    Collection<Reservation> test = reservationService.getCustomersReservation(customer);
                    break;
                /*3 - CREATE AN ACCOUNT */
                case 3 :

                    MainMenu.createAccount();

                    break;

                /* 4 - ADMIN*/
                case 4 :
                    boolean adminOpen = true;

                    System.out.println("-----------------------Welcome to the Admin section.-------------------------------");
                    AdminMenu adminMenu = new AdminMenu();
                    Scanner sectionAdmin = new Scanner(System.in);
                    adminMenu.displayAdmin(sectionAdmin);

                    break;
                case 5 :
                    System.out.println("GoodBye !!");
                    run = false;
            }
        }
    }

}
