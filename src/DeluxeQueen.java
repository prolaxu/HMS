import java.util.ArrayList;

/**
 * Created by Ankit on 5/27/2021.
 */
public class DeluxeQueen extends Room{
    private String description;
    private boolean booked;

    // Default Constructor
    DeluxeQueen(){
        super(0,"",0.0,"Ground Floor");
        description = "";
        booked = false;
    }
    DeluxeQueen(int roomId,String description,double price, String location,boolean booked){
        super(roomId,"Queen bed",price,location);
        this.description = description;
        this.booked = booked;
    }

    // Getters and Setters
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getBooked() {
        return booked;
    }
    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    // Override setPrice method to give specific implementation
    @Override
    public void setPrice(double price){
        // 10% discount
        price -= 0.1*price;
        // Add price of all the amenities added to the room
        ArrayList<Amenity> amenities = retriveAmenities();
        for(Amenity amenity : amenities){
            price+= amenity.getPrice();
        }
        super.setPrice(price);
    }
    //Override toString method to display all the information
    @Override
    public String toString(){
        String newline = System.getProperty("line.separator");
        return HotelDriver.rtnDrawLine()+
                "Room ID: "+ getRoomId() + newline+
                "Features: " +  getFeatures()+ newline +
                "Description: " + description + newline +
                "Price:" + getPrice()+ newline +
                "Location: " + getLocation() + newline +
                "booked: " + booked+newline+
                "Amenities: " + retriveAmenities();
    }
}