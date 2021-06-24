package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;
import service.CustomerService;
import service.ReservationService;

import java.util.*;

public class HotelResource {
    public static  HotelResource hotelResource;
    private static ReservationService reservationService;
    private static CustomerService customerService;

    /*Constructors*/
    public HotelResource(ReservationService reservationService, CustomerService customerService){
        this.reservationService = reservationService;
        this.customerService = customerService;
    }

    /*Methods*/
    public Customer getCustomer (String email){
        System.out.println("Looking for the customer with the email : " + email);
        return this.customerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstname, String lastname){
        this.customerService.addCustomer(email, firstname,lastname);
        System.out.println("Customer created as : " + customerService);
    }

    public IRoom getRoom(String roomNumber){
        return this.reservationService.getRoom(roomNumber);
    }

   public Reservation bookARoom (String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){


        /*Find the customer with the email*/
       Customer customerToFind = this.customerService.getCustomer(customerEmail);
       System.out.println("We find your customer profile : " + customerToFind);

        /* Add to the reservation with ReservationService method*/
        Reservation bookReservation = this.reservationService.reserveARoom(customerToFind,room,checkInDate,checkOutDate);
        System.out.println("The reservation has been bone : " + bookReservation);
        return bookReservation;
    }

    public Collection<Reservation> getCustomersReservations(String customerEmail){
        Customer foundCustomer = this.customerService.getCustomer(customerEmail);
        System.out.println("Your account is found as : " + foundCustomer);

        Collection<Reservation> findReservation =this.reservationService.getCustomersReservation(foundCustomer);
        return findReservation;
    }

    public Collection<IRoom> findARoom (Date checkIn, Date checkOut){
        return this.reservationService.findRooms(checkIn,checkOut);
    }
}
