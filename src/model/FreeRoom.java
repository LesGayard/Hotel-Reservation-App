package model;

public class FreeRoom extends Room{
    public FreeRoom(String roomNumber, double price, RoomType enumeration){
        super(roomNumber,price,enumeration);
        price = 0.0;
    }
    /*OVERRIDE METHODS = Boolean Equals() + int HashCode() + String toString() */

    @Override
    public boolean isFree(){
        System.out.println("This room is available");
        return true;
    }

    @Override
    public String toString(){
        return "Free Room number : " + getRoomNUmber() + " costs per night : " + getRoomPrice() + " of type : " + getRoomType();
    }
}
