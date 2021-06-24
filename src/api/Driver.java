package api;

import model.Customer;
import model.FreeRoom;
import model.Room;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;

import java.util.Date;

public class Driver {
    public static void main (String[] args) throws Exception{

        /* TEST HOTEL RESOURCES METHODS*/

        Customer test1 = new Customer("Leslie", "Gayard", "lesgayard@gmail.com");
        Customer test2 = new Customer("Athena", "rose", "123@gmail.com");
        Customer test3 = new Customer ("ana", "ice", "456@gmail.com");
        Customer test4 = new Customer("Gil", "Wayne", "789@gmail.com");


       /* CustomerService serviceTest1 = new CustomerService();
        serviceTest1.addCustomer("lesgayard@gmail.com", "Leslie", "Gayard");
        serviceTest1.addCustomer("123@gmail.com", "Athena", "rose");
        serviceTest1.addCustomer("456@gmail.com", "ana", "ice");
        serviceTest1.addCustomer("789@gmail.com", "Gil", "Wayne");

        ReservationService serviceReservationTest = new ReservationService();*/



       // HotelResource hotel1 = new HotelResource(serviceReservationTest,serviceTest1);

        /****************TEST GET CUSTOMER METHOD*********************/
      //  Customer customerGetCustomer = new Customer();
       // customerGetCustomer = hotel1.getCustomer("lesgayard@gmail.com");


        /***************TEST CREATE A CUSTOMER METHOD*****************/
       // hotel1.createACustomer("bob@gmail.com", "bob", "dylan");
      //  hotel1.createACustomer("esther@gmail.com", "esther", "wali");
       // customerGetCustomer = hotel1.getCustomer("esther@gmail.com");

        /*****************TEST GET A ROOM METHOD**********************/
        Room room100 = new Room("100", 135.2, RoomType.SINGLE);
        Room room101 = new Room("101", 160.5, RoomType.DOUBLE);
        Room room102 = new Room("102", 135.2, RoomType.SINGLE);
        Room room200 = new FreeRoom("200", 0.0, RoomType.SINGLE);

       /* serviceReservationTest.addRoom(room100);
        serviceReservationTest.addRoom(room101);
        serviceReservationTest.addRoom(room102);
        serviceReservationTest.addRoom(room200);

        hotel1.getRoom("101");*/

        /******* BOOK A ROOM METHOD******************/
        Date testBookIN = new Date(2021,05,05);
        Date testBookOut = new Date(2021,05,07);
        Date testBookIN1 = new Date(2021,06,07);
        Date testBookOut1 = new Date(2021,06,10);
        Date testBookIn2  = new Date(2021,10,11);
        Date testBookOut2 = new Date(2021, 10,13);
      /*  hotel1.bookARoom("esther@gmail.com", room200,testBookIN,testBookOut );
        hotel1.bookARoom("esther@gmail.com", room100, testBookIN1, testBookOut1);
        hotel1.bookARoom("bob@gmail.com", room102,testBookIn2,testBookOut2);*/


        /****** GET CUSTOMERS RESERVATIONS ********/

       /* hotel1.getCustomersReservations("esther@gmail.com");
        hotel1.getCustomersReservations("bob@gmail.com");*/

        /*******  FIND A ROOM METHOD *******************/
        /*Date testBookInRoom = new Date(2022,06,07);
        Date tesBookOutRoom = new Date (2022, 06, 9);
        hotel1.findARoom( testBookInRoom  ,tesBookOutRoom);*/



    }


}
