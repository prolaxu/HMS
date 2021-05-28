/**
 * Created by Ankit on 5/27/2021.
 */
public class Amenity {
    private int id;
    private String name;
    private String description;
    private double price;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }



    Amenity(){
        id = 0;
        name = "";
        description = "";
        price = 0.0;
    }
    Amenity(int id, String name, String description,double price){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    @Override
    public String toString(){
        String newline = System.getProperty("line.separator");
        return newline+ "ID: "+ id + " | " +
                "Name: " +  name + " | " +
                "Description: " + description + " | "+
                "Price:" + price;
    }

}