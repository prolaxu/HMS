import java.util.ArrayList;

/**
 * Created by Ankit on 5/27/2021.
 */
public class Room {

    private int roomId;
    private String features;
    private double price;
    private String location;
    private ArrayList<Amenity> amenities = new ArrayList<>();

    // Default constructor
    Room(){
        roomId = 0;
        features = "";
        price= 0.0;
        location = "";
    }
    Room(int roomId,String features,double price,String location){
        this.roomId = roomId;
        this.features = features;
        this.price = price;
        this.location = location;
    }
    // Manage room Amenity
    public void addAmenity(Amenity amenity){
        amenities.add(amenity);
    }
    public void removeAmenity(Amenity amenity){
        amenities.remove(amenity);
    }
    public ArrayList<Amenity> retriveAmenities() {
        return amenities;
    }

    // Getters and Setters
    public int getRoomId(){
        return roomId;
    }
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getFeatures() {
        return features;
    }
    public void setFeatures(String features) {
        this.features = features;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString(){
        String newline = System.getProperty("line.separator");
        return "Room ID: "+ roomId + newline+
                "Features: " +  features+ newline +
                "Price:" + price+newline +
                "Location: " + location +newline+
                "Amenities: " + amenities;
    }
}