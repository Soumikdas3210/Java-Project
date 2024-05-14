package entity;
public class Customer extends User {
    public Customer(){
        super();
    }

    public Customer(String username, String email, String password){
        super(username, email, password);
    }
}
