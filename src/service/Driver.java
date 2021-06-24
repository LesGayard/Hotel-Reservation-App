package service;

import model.*;

import java.text.SimpleDateFormat;
import java.util.*;

public class Driver {
    public static void main (String[] args){
        Map<IRoom,Reservation> reservations = new HashMap<IRoom,Reservation>();
        Map<String,Customer> customers = new HashMap<String,Customer>();
        ReservationService reservation = new ReservationService(reservations);
        //System.out.println(reservation.getRoom("100"));

        /*Customer creation test*/
        CustomerService customer1 = new CustomerService(customers);
        customer1.addCustomer("lesgayard@gmail.com","leslie","arnold");
        customer1.addCustomer("alo@fkdl.com","Bobo", "gard");

        Customer test1 = new Customer("leslie", "arnold", "lesgayard@gmail.com");
         test1 =  customer1.getCustomer("lesgayard@gmail.com");
         customer1.getAllCustomers();
         Customer test2 = new Customer("Lila", "Rose", "abcd@gom.com");

         /*Test Reservation Service class*/
        ReservationService service = new ReservationService(reservations);
        Room room100 = new Room("100",132.5, RoomType.SINGLE);
        System.out.println(room100);
        service.addRoom(room100);
        Room room101 = new Room("101", 150.6,RoomType.DOUBLE);
        System.out.println(room101);
        service.addRoom(room101);
        Room room102 = new Room("102", 132.5, RoomType.SINGLE);
        service.addRoom(room102);
        Room room103 = new Room("103", 150.6, RoomType.DOUBLE);
        service.addRoom(room103);
        service.getRoom("100");

        /*Reserve a room test*/
        Date checkIN = new Date(2021,05,05);
        Date checkOut = new Date(2021,05,07);
        Date testCheckin1 = new Date(2021, 10, 11);
        Date testCheckout1 = new Date(2021, 10, 13);
        service.reserveARoom(test1,room102,checkIN,checkOut);
        service.reserveARoom(test2,room103, testCheckin1,testCheckout1);


        /*Test add a free room*/
        FreeRoom room200 = new FreeRoom("200", 0.0, RoomType.SINGLE);
        service.addRoom(room200);
        FreeRoom room201 = new FreeRoom("201", 0.0,RoomType.DOUBLE);
        service.addRoom(room201);

        /*Test find all rooms free or not from the dates*/
        Date testCheckIn = new Date(2021,12,20);
        Date tesCheckOut = new Date(2021,12,25);
        service.findRooms(checkIN   ,checkOut );
       // service.findRooms(testCheckin1,testCheckout1);

        /*Test getCustomerReservation*/
       service.getCustomersReservation(test1);
       service.getCustomersReservation(test2);

        /*Test printAllReservations*/
        service.printAllReservations();

        /*Test prinAllRooms*/
        service.printAllRooms();


    }
}
