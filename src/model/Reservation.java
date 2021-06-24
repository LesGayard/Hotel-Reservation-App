package model;

import java.util.Date;
import java.util.Objects;

public class Reservation {
    private final Customer customer;
    private final IRoom room;
    private final Date checkInDate;
    private final Date checkOutDate;
    /*Constructors*/

    public Reservation(Customer customer,IRoom room, Date checkInDate, Date checkOutDate){
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        checkInDate = new Date();
        this.checkOutDate = checkOutDate;
        checkOutDate = new Date();
    }
    /*Getters + Setters*/
    public Customer getCustomer() {
        return this.customer;
    }
    public IRoom getRoom() {
        return this.room;
    }
    public Date getCheckInDate() {
        return this.checkInDate;
    }
    public Date getCheckOutDate() {
        return this.checkOutDate;
    }

    public void setCustomer(Customer customer) {
        customer = customer;
    }
    public void setRoom(IRoom room) {
        room = room;
    }
    public void setCheckInDate(Date checkInDate) {
        checkInDate = checkInDate;
    }
    public void setCheckOutDate(Date checkOutDate) {
        checkOutDate = checkOutDate;
    }

    /*OVERRIDE METHODS = Boolean Equals() + int HashCode() + String toString() */
    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(!(o instanceof Reservation)){ return false;}
        Reservation reservation = (Reservation) o;
        return Objects.equals(customer,reservation.customer) && Objects.equals(room,reservation.room) && Objects.equals(checkInDate,reservation.checkInDate) && Objects.equals(checkOutDate,reservation.checkOutDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer,room,checkInDate,checkOutDate);
    }

    @Override
    public String toString() {
        return "Reservation{" + "customer=" + customer + ", room=" + room + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + '}';
    }
}
