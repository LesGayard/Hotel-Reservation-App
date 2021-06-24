package model;

import java.util.Objects;

public class Room implements IRoom{
    private final String roomNumber;
    private final double price;
    private final RoomType enumeration;

    /*Constructors*/
    public Room(String roomNumber, double price, RoomType enumeration){
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
    }
/*Getters + Setters*/
    public String getRoomNUmber(){
        return this.roomNumber;
    }
    public double getRoomPrice(){
        return this.price;
    }
    public RoomType getRoomType(){
        return this.enumeration;
    }
    public boolean isFree(){
        System.out.println("This room is not available");
        return false;
    }

    public void setRoomNumber(String roomNumber) {
        roomNumber = roomNumber;
    }
    public void setPrice(double price) { price = price; }

    /*OVERRIDE METHODS = Boolean Equals() + int HashCode() + String toString() */
    @Override
    public boolean equals (Object o){
        if( o == this) return true;
        if(!(o instanceof Room)){ return false;}
        Room room = (Room) o;
        return price == room.price && Objects.equals(roomNumber, room.roomNumber) && Objects.equals(enumeration,room.enumeration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber,price,enumeration);
    }

    @Override
    public String toString(){
        return "Room number : " + this.roomNumber + " Costs per night : " + this.price  + " Euros" + " Type of room : " + enumeration;
    }

}
