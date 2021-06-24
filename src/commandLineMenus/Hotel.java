package commandLineMenus;

import api.AdminResource;
import api.HotelResource;
import model.*;
import service.CustomerService;
import service.ReservationService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

public class Hotel {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

       System.out.println("-------------------------------------------------------------------------------------------");
       System.out.println("---------------------Welcome to the Hotel -------------------------------------------------");
       /*INVOKE THE MAINMENU CLASS*/

        Map<String,Customer> customers = MainMenu.getCustomers();
        Map<IRoom, Reservation> reservations = MainMenu.getReservations();
        CustomerService customerService = new CustomerService(customers);
        ReservationService reservationService = new ReservationService(reservations);
        HotelResource hotelResource = MainMenu.getHotelResource();
        AdminResource adminResource = MainMenu.getAdminResource();


        MainMenu main = new MainMenu(customers, reservations, customerService, reservationService, hotelResource, adminResource);
        main.displayMainMenu(scanner);
    }
}
