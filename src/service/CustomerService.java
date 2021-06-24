package service;

import model.Customer;

import java.util.*;

public class CustomerService {
    private static final CustomerService customerService = new CustomerService();
   // private  Customer customer;
    private Map<String,Customer> customers;

    /*DESIGN PATTERN SINGLETON*/
    public static CustomerService getInstance(){ return customerService; }

    /*Constructor*/
    public CustomerService(){}
    public CustomerService(Map<String,Customer>customers){
      // this.customer = customer;
       this.customers = new HashMap<String, Customer>();
    }

    /*Methods*/
    public void addCustomer(String email,String firstname,String lastname){
        /*Create a new Customer*/
        Customer customer = new Customer(firstname,lastname,email);
        /*add the new customer to the collection*/
        this.customers.put(email,customer);
        System.out.println("Numbers of customers added : " + customers.size());
    }

    public Customer getCustomer(String customerEmail) {
       Customer ans = this.customers.get(customerEmail);
        try{
            for(String email : customers.keySet()){
                if(email.contains(customerEmail)){
                    ans = customers.get(email);
                }else{
                    System.out.println("You can create a new profile with this email.");
                }
            }
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
            System.out.println("You can create a new profile, with this email");
        }
        System.out.println("Costumer found is : " + ans);
        return ans;
    }

    public Collection<Customer> getAllCustomers(){
        Collection<Customer> ans = new ArrayList<Customer>();
        for(Customer oneCustomer : customers.values()){
            System.out.println("All the customers are : " + customers.values());
            ans.add(oneCustomer);
        }
        //System.out.println("Test Arraylist size after the loop : " + ans.size());
        return ans;
    }

}
