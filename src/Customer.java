/**
 * Created by Ankit on 5/27/2021.
 */
public class Customer {
    private String name;
    private double discount;
    private String status;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getDiscount() {
        return discount;
    }
    public void setDiscount() {
        status= status.toLowerCase();
        if(status.equals("active customer")){
            this.discount= 0.05;
        }else if(status.equals("vip customer")){
            this.discount = 0.1;
        }else if(status.equals("new customer")){
            this.discount = 0;
        }
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    Customer(){
        name = "";
        discount = 0.0;
        status = "";
    }
    Customer(String name,String status){
        this.name = name;
        this.status = status;
        setDiscount();
    }
    @Override
    public String toString(){
        String newline = System.getProperty("line.separator");
        return "Name: "+ name + newline+
                "Discount: " +  discount + newline +
                "Status: " + status;
    }
}