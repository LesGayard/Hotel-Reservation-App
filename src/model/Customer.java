package model;

import java.util.Objects;
import java.util.regex.Pattern;

public class Customer {
    private final String firstname;
    private final String lastname;
    private final String email;

    /*Constructors*/

    public Customer(String firstname, String lastname, String email){
        this.firstname = firstname;
        this.lastname = lastname;
       /* String emailRegex = "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);

        if(pattern.matcher(email).matches()==true) {*/
        this.email = email;
       /* }else {
            System.out.println("Please enter a Valid email");
        }*/
    }
    /*getters + setters*/
    public String getFirstname() {
        return this.firstname;
    }
    public String getLastname() {
        return this.lastname;
    }
    public String getEmail() {
        return this.email;
    }
    public void setFirstname(String firstname) {
        firstname = firstname;
    }
    public void setLastname(String lastname) {
        lastname = lastname;
    }
    public void setEmail(String email) {
        email = email;
    }

    /*OVERRIDE METHODS = Boolean Equals() + int HashCode() + String toString() */
    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(!(o instanceof Customer)){ return false;}
        Customer customer = (Customer) o;
        return Objects.equals(firstname, customer.firstname) && Objects.equals(lastname,customer.lastname) && Objects.equals(email,customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, email);
    }

    @Override
    public String toString() {
        return  "Firstname : " + this.firstname + " Lastname : " + this.lastname + " Email : " + this.email;
    }
}
