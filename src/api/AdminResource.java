package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class AdminResource {
    public static AdminResource adminResource;
    private static ReservationService reservationService;
    private static CustomerService customerService;
    private Map<IRoom , Reservation> reservations;
    /*Constructor*/

    public AdminResource(ReservationService reservationService, CustomerService customerService){
        this.reservationService = reservationService;
        this.customerService = customerService;
    }

    /*Methods*/
    public Customer getCustomer (String email){
       return this.customerService.getCustomer(email);
    }

    public void addRoom(List<IRoom> rooms){
        for(IRoom room : rooms){
            this.reservationService.addRoom(room);
        }
    }

    public Collection<IRoom> getAllRooms(){
        Collection<IRoom> searchRooms = new ArrayList<>();
        if(this.reservations != null){
            for(IRoom room : this.reservations.keySet()){
                System.out.println("room to select : " + room);
                searchRooms.add(room);
            }

        }
        return searchRooms;
    }

    public Collection<Customer> getAllCustomers(){
        /*Get the method from CustomersService class*/
        Collection<Customer> allCustomers = null;
        allCustomers = this.customerService.getAllCustomers();
        return allCustomers;
    }

    public void displayAllReservations(){
        /* Get the method from ReservationService class*/
       this.reservationService.printAllReservations();
    }

    public void displayAllRooms(){
        this.reservationService.printAllRooms();
    }
}
