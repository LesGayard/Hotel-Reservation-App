package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.*;

public class ReservationService {
    private static final ReservationService reservationService= new ReservationService();
    private Map<IRoom , Reservation> reservations;

    /*DESIGN PATTERN SINGLETON*/
    public static ReservationService getInstance(){
        return reservationService;
    }
    /*Constructors*/
   public ReservationService(){}

    public ReservationService(Map<IRoom,Reservation> reservations){
        this.reservations = new HashMap<IRoom, Reservation>();
    }

    /*Methods*/
    public void addRoom(IRoom room){
        Reservation oneReservation = null;
        System.out.println("The room : " + room + " is being added.");
        this.reservations.put(room,oneReservation);
        System.out.println("Number of rooms : " + this.reservations.size());

    }

    public Room getRoom(String roomId){
        Room roomAns = null;
        for(IRoom oneRoom : this.reservations.keySet()){
            if(oneRoom.getRoomNUmber().equals(roomId)){
                System.out.println("The room searched is : " + roomId);
                roomAns = new Room(oneRoom.getRoomNUmber(),oneRoom.getRoomPrice(),oneRoom.getRoomType());
            }
        }
        System.out.println(" The room searched is : " + roomAns);
        return roomAns;
    }

    public Reservation reserveARoom (Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation ans = new Reservation(customer, room, checkInDate, checkOutDate);
        this.reservations.put(room, ans);
        System.out.println("Number of reservations added : " + ans);
        return ans;
    }

    public Collection<IRoom> findRooms (Date checkInDate, Date checkOutDate){
        Collection<IRoom> roomFind = new ArrayList<>();
        System.out.println("Looking for rooms : checkin : " + checkInDate + " and checkout : " + checkOutDate);
        if(this.reservations.size() != 0){
       // for(Reservation reservation : this.reservations.values()){
            roomFind = new ArrayList<>(this.reservations.keySet());
               // if(reservation.getCheckInDate().equals(checkInDate) && reservation.getCheckOutDate().equals(checkOutDate)){
                   // roomFind.add(reservation.getRoom());
               // }
        }else{
                for(IRoom room : reservations.keySet()){
                    for (Reservation reservation: reservations.values()) {
                        if ((room.getRoomNUmber() == reservation.getRoom().getRoomNUmber() &&
                                ((!checkInDate.after(reservation.getCheckInDate()) &&
                                        !checkInDate.before(reservation.getCheckOutDate())) ||
                                        (!checkOutDate.after(reservation.getCheckInDate()) &&
                                                !checkInDate.before(reservation.getCheckOutDate())))) ||
                                (!reservation.getRoom().getRoomNUmber().contains(room.getRoomNUmber()))) {
                            roomFind.add(room);

                        }
                    }
                }
        }
        //}
        System.out.println("Number of rooms : " + roomFind.size() + " as : " + roomFind);
        return roomFind;
    }

    public Collection<Reservation> getCustomersReservation(Customer customer){
        Collection<Reservation> findReservation = new ArrayList<Reservation>();
        System.out.println("Looking for the customer " + customer);
        for(Reservation reservation : this.reservations.values()){
           if(reservation != null && reservation.getCustomer().equals(customer)){
               findReservation.add(reservation);
               System.out.println("We find : " + reservation);
           }
        }
        return findReservation;
    }


    public void printAllReservations(){
        System.out.println("All the reservations are : ");
        int count = 0;
        for(Reservation reservation : this.reservations.values()){
           if(reservation != null){
               count ++;
               System.out.println(reservation);

           }
        }
        System.out.println("Number of reservations : " + count );
    }

    public void printAllRooms(){
        int count = 0;
        System.out.println("All the rooms are : ");
        for(IRoom room : this.reservations.keySet()){
            count ++;
            System.out.println(room);
        }
        System.out.println("There are : " + count + " rooms.");
    }


}
