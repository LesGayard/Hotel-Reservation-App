package commandLineMenus;

import api.AdminResource;
import api.HotelResource;
import model.*;
import service.CustomerService;
import service.ReservationService;

import java.util.*;
import java.util.regex.Pattern;

import static commandLineMenus.MainMenu.allCustomers;


public class AdminMenu {
    /*NEED A COLLECTION heritage??*/
    private MainMenu mainMenu;
    /*CONSTRUCTOR*/
    public AdminMenu(){}
    public AdminMenu(MainMenu mainMenu){
      this.mainMenu = mainMenu;
    }
    /*GETTER + SETTER*/
    public MainMenu getMainMenu(){return this.mainMenu;}

    public void setMainMenu(MainMenu mainMenu) { this.mainMenu = mainMenu;}


    // public static void main (String[] args){
    public void displayAdmin(Scanner scanner){
        Scanner scannerAdmin = new Scanner(System.in);
        boolean runAdmin = true;
       // while(runAdmin){
            /**********************ADMIN SECTIONS DISPLAYED*************************/
            System.out.println("1 - See all customers");
            System.out.println("2 - See all rooms");
            System.out.println("3 - See all reservations");
            System.out.println("4 - Add a room");
            System.out.println("5 - Back to Main Menu");

            int answerAdmin = scannerAdmin.nextInt();
            switch (answerAdmin){
                /*SEE ALL CUSTOMERS SECTION*/
                case 1 :
                    System.out.println("1 - See all customers");
                     MainMenu.allCustomers();
                    break;
                case 2 :
                    System.out.println(" 2 - See all rooms");
                    try{
                        MainMenu.getReservationService().printAllRooms();
                    }catch(Exception e){
                        System.out.println("There is no room ready yet.");
                        System.out.println(e.getLocalizedMessage());
                    }
                    break;
                case 3 :
                    System.out.println("3 - See all reservations");
                    try{
                        MainMenu.getAdminResource().displayAllReservations();
                    }catch(Exception e){
                        System.out.println("There is no reservations available.");
                        System.out.println(e.getLocalizedMessage());
                    }
                    break;
                case 4 :
                    System.out.println("Let's add a room");
                /*Invoke the method from Reservation Service class : public void addRoom(IRoom room)
                * Must ask the room parameter for invoking this method
                * 1 - ask the room parameters :  private String roomNumber;
                                                 private double price;
                                                 private RoomType enumeration;
                  2 - use these parameters for the object room
                  3 - call the function by the API
                * */
                    /*String roomNumber*/
                    System.out.println("Enter the room number.");
                    int roomNumber = 0;
                    Scanner roomAdd = null;
                    String  roomAddNumber = null;
                    while(roomNumber == 0){
                        try{
                            roomAdd = new Scanner(System.in);
                            roomNumber = roomAdd.nextInt();
                            /*conversion int to string*/
                            roomAddNumber = Integer.toString(roomNumber);
                            System.out.println("You enter the room number : " + roomAddNumber);
                        }catch (Exception e){
                            e.getLocalizedMessage();
                            System.out.println("Please try again");
                        }
                    }
                    /*double price*/
                    System.out.println("Enter the price of the room.");
                    Scanner price = null;
                    Double roomPrice = 0.0;

                    while(roomPrice == 0){
                        try{
                            price = new Scanner(System.in);
                            roomPrice = price.nextDouble();
                            System.out.println("You enter the price of the room as : " + roomPrice);
                        }catch (Exception e){
                            System.out.println(e.getLocalizedMessage());
                            System.out.println("Please try again");
                        }
                    }
                    /*Roomtype enumeration*/
                    String regexType = "^SINGLE|DOUBLE$";
                    Pattern checkTypePattern = Pattern.compile(regexType);

                    System.out.println("Please select a type of room : SINGLE or DOUBLE");

                    Scanner roomType = new Scanner(System.in);
                    String roomTypeSelect = roomType.nextLine();
                    System.out.println("You enter : " + roomTypeSelect);

                    boolean testType = false;
                    testType = checkTypePattern.matches(regexType,roomTypeSelect);
                    /* A REVOIR !! FONCTIONNE MAIS BANCAL !!*/
                    while(testType == false){
                        try{
                            testType = checkTypePattern.matches(regexType,roomTypeSelect);
                            System.out.println("Please try again : choose SINGLE or DOUBLE");
                            System.out.println("method TYPE : " + testType);

                            roomTypeSelect = roomType.nextLine();
                            System.out.println("You choose the type : " + roomTypeSelect);
                        }catch(Exception e){
                            System.out.println(e.getLocalizedMessage());
                            System.out.println("Please Try again");
                        }
                    }
                    /*Conversion of string to enumeration
                     *
                     * */
                    /*RoomType.valueOf(roomTypeSelect);
                    /*public void addRoom(IRoom room)*/
                    IRoom roomToAdd = new Room(roomAddNumber,roomPrice,RoomType.valueOf(roomTypeSelect));
                    MainMenu.getReservationService().addRoom(roomToAdd);
                    break;

                case 5 :
                    System.out.println("Back to Main Menu");
                    MainMenu mainMenu = new MainMenu();
                    Scanner scannerMain = new Scanner(System.in);
                    mainMenu.displayMainMenu(scannerMain);
                    break;

                default :
                    System.out.println("Please choose a right section");
            }
    }


}

//}
