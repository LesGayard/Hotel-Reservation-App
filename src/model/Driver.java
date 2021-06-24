package model;

public class Driver {
    public static void main (String[] args){
        Customer customer = new Customer("first", "second","j@domain.com");
        System.out.println(customer);
        Customer customer1 = new Customer("Bob", "leponge","email");
        System.out.println(customer1);

        Room room100 = new Room("100",132.5,RoomType.SINGLE);
        System.out.println(room100);
    }
}
