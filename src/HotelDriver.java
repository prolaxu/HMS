import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ankit on 5/27/2021.
 */
public class HotelDriver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String ch, name, choiceForReRun;
        int status = 0;
        int amenitySelection;
        int roomNumber;
        Room selectedRoom;
        boolean entireLoop = true;
        double sum = 0;

        ArrayList<Room> listOfRooms = new ArrayList<>();

        // Define all the rooms
        DeluxeQueen deluxeQueen1 = new DeluxeQueen(1, "Deluxe Queen Room 1", 300, "Extreme left corner of Second Floor", false);
        DeluxeQueen deluxeQueen2 = new DeluxeQueen(2, "Deluxe Queen Room 2", 300, "Extreme right corner of Second Floor", false);

        Deluxe2Queen deluxe2Queen1 = new Deluxe2Queen(3, "Deluxe 2 Queen Room 1", 400, "Right corner of Second Floor", false);
        Deluxe2Queen deluxe2Queen2 = new Deluxe2Queen(4, "Deluxe 2 Queen Room 2", 400, "Left corner of Second Floor", false);

        DeluxeSpa deluxeSpa1 = new DeluxeSpa(5, "Deluxe Spa Room 1", 300, "Left corner of Third Floor", false);
        DeluxeSpa deluxeSpa2 = new DeluxeSpa(6, "Deluxe Spa Room 2", 300, "right corner of Third Floor", false);

        FamilySuite familySuite1 = new FamilySuite(7, "Family Suite Room 1", 400, "right corner of Fourth Floor", false);
        FamilySuite familySuite2 = new FamilySuite(8, "Family Suite Room 2", 400, "left corner of Fourth Floor", false);

        TwoBedroomFamilySuite twoBedroomFamilySuite1 = new TwoBedroomFamilySuite(9, "Two Bedroom Family Suite Room 1", 700, "left corner of Fifth Floor", false);
        TwoBedroomFamilySuite twoBedroomFamilySuite2 = new TwoBedroomFamilySuite(10, "Two Bedroom Family Suite Room 2", 700, "left corner of Fifth Floor", false);

        // Define all the Amenities
        Amenity freeWifi = new Amenity(1, "Free Wi-fi", "You get free wifi", 10);
        Amenity tv = new Amenity(2, "Tv with Netflix", "You get Tv with Netflix", 10);
        Amenity laundry = new Amenity(3, "Laundry containing washer and dryer", "You get Laundry", 20);
        Amenity ac = new Amenity(4, "Air Conditioner", "You get Air Conditioner", 50);
        Amenity heater = new Amenity(5, "Heater", "You get Heater", 20);
        Amenity coffee = new Amenity(6, "Coffee machine", "You get Coffee machine", 15);
        Amenity breakfast = new Amenity(7, "Breakfast", "You get Breakfast", 15);
        Amenity lunch = new Amenity(8, "Lunch", "You get Lunch", 20);
        Amenity dinner = new Amenity(9, "Dinner", "You get Dinner", 20);
        Amenity barbequeArea = new Amenity(10, "Undercover barbeque area", "You get Undercover barbeque area", 30);
        Amenity electricBlanket = new Amenity(11, "Electric Blankets", "You get Electric Blankets", 30);
        Amenity toaster = new Amenity(12, "Toaster", "You get Toasters", 5);
        Amenity microwave = new Amenity(13, "Microwave", "You get Microwave", 10);

        // Welcome Screen
        drawLine();
        System.out.println("WELCOME TO HOTEL MANAGEMENT SYSTEM");
        drawLine();
        System.out.println("\nDeveloped by (name,id)");
        System.out.println("OODP101 Object Oriented Design and Programming Assessment Task 4");
        long millis = System.currentTimeMillis();
        java.util.Date date = new java.util.Date(millis);
        System.out.println(date);
        drawLine();

        System.out.println("Do you want to place an Order(yes/no)");

        // Input Customer Details
        ch = input.next();
        if (ch.toLowerCase().equals("yes")) {
            System.out.println("Enter the Customer's Name :");
            name = input.next();
            while (status<=0 || status >=4) {
            System.out.println("Choose the Customer's status :\n 1.Active Customers.\n 2.Vip Customers.\n 3.New Customers. \n");
                status = input.nextInt();
            }
            // Create a customer
            Customer customer = new Customer(name,getStatus(status));
            // Loop if the user want to book more than one room
            while(entireLoop) {
                 amenitySelection =-1;
                 selectedRoom =null;
                 // Loop if the selected room is not available
                 while(selectedRoom==null) {
                     roomNumber = 0;
                     // check the user input
                     while (roomNumber <= 0 || roomNumber >= 6) {
                         System.out.println("The room types are: ");
                         System.out.println("1. Deluxe Queen");
                         System.out.println("2. Deluxe 2 Queen");
                         System.out.println("3. Deluxe Spa");
                         System.out.println("4. Family Suite");
                         System.out.println("5. Two Bedroom Family Suite");

                         roomNumber = input.nextInt();
                     }
                     // check if the user selected room is available
                     switch (roomNumber) {
                         case 1:
                             selectedRoom = getDeluxeQueenRoom(deluxeQueen1, deluxeQueen2);
                             break;
                         case 2:
                             selectedRoom = getDeluxe2QueenRoom(deluxe2Queen1, deluxe2Queen2);
                             break;
                         case 3:
                             selectedRoom = getDeluxeSpaRoom(deluxeSpa1, deluxeSpa2);
                             break;
                         case 4:
                             selectedRoom = getFamilySuite(familySuite1, familySuite2);
                             break;
                         case 5:
                             selectedRoom = getTwoBedroomFamilySuite(twoBedroomFamilySuite1, twoBedroomFamilySuite2);
                             break;
                     }
                     if(selectedRoom == null){
                         System.out.println("Room Not Available");
                     }
                 }

                System.out.println("The Amenities are: ");
                System.out.println("1. Free Wifi");
                System.out.println("2. Tv with Netflix");
                System.out.println("3. Laundry containing washer and dryer");
                System.out.println("4. Air Conditioner");
                System.out.println("5. Heater");
                System.out.println("6. Coffee Machine");
                System.out.println("7. Breakfast");
                System.out.println("8. Lunch");
                System.out.println("9. Dinner");
                System.out.println("10. Undercover Barbeque Area");
                System.out.println("11. Electric Blankets");
                System.out.println("12. Toaster");
                System.out.println("13. Microwave");

                // Loop till the user wants to add more Amenity
                while (amenitySelection != 0) {
                    System.out.println("Select the Amenity you want?(If you don't want any type 0)");
                    amenitySelection = input.nextInt();
                    // Add user selected Amenity to the selected rooms amenity list
                    switch (amenitySelection) {
                        case 1:
                            selectedRoom.addAmenity(freeWifi);
                            break;
                        case 2:
                            selectedRoom.addAmenity(tv);
                            break;
                        case 3:
                            selectedRoom.addAmenity(laundry);
                            break;
                        case 4:
                            selectedRoom.addAmenity(ac);
                            break;
                        case 5:
                            selectedRoom.addAmenity(heater);
                            break;
                        case 6:
                            selectedRoom.addAmenity(coffee);
                            break;
                        case 7:
                            selectedRoom.addAmenity(breakfast);
                            break;
                        case 8:
                            selectedRoom.addAmenity(lunch);
                            break;
                        case 9:
                            selectedRoom.addAmenity(dinner);
                            break;
                        case 10:
                            selectedRoom.addAmenity(barbequeArea);
                            break;
                        case 11:
                            selectedRoom.addAmenity(electricBlanket);
                            break;
                        case 12:
                            selectedRoom.addAmenity(toaster);
                            break;
                        case 13:
                            selectedRoom.addAmenity(microwave);
                            break;
                    }
                }
                selectedRoom.setPrice(selectedRoom.getPrice());
                System.out.println("Do you want to book more room?(yes/no)");
                choiceForReRun = input.next();
                //  Check if the user wants to book more rooms
                if(choiceForReRun.toLowerCase().equals("no")){
                    entireLoop=false;
                }
                listOfRooms.add(selectedRoom);
            }
            // Calculate the total price of all the rooms
            for(Room room : listOfRooms){
                sum+= room.getPrice();
                System.out.println(room.toString());
            }
            drawLine();
            sum-=customer.getDiscount()*sum;
            System.out.println("Name: " + customer.getName());
            System.out.println("Status: " + customer.getStatus());
            System.out.println("TOTAL PRICE: " + sum);
            drawLine();

        }
    }

    // Get status of user according to the user input
    private static String getStatus(int statusId){
        return statusId==1?"Active Customer": statusId==2?"Vip Customer": statusId==3? "New Customer":"Invalid";
    }
    // Draw a line
    private static void drawLine() {

            for(int i=0;i<=33;i++){
                System.out.print("*");
            }
            System.out.print("\n");
    }
    // Return a String of *
    public static String rtnDrawLine() {
        String line = "";
        for(int i=0;i<=33;i++){
            line +="*";
        }
        return line + "\n";
    }

    // check if the rooms are already selected
    private static DeluxeQueen getDeluxeQueenRoom(DeluxeQueen room1, DeluxeQueen room2){
        DeluxeQueen selectedRoom;
        if(!room1.getBooked()){
            selectedRoom = room1;
            room1.setBooked(true);
        }else if(!room2.getBooked()){
            selectedRoom = room2;
            room2.setBooked(true);
        }else{
            selectedRoom = null;
        }
        return selectedRoom;
    }
    private static Deluxe2Queen getDeluxe2QueenRoom(Deluxe2Queen room1, Deluxe2Queen room2){
        Deluxe2Queen selectedRoom;
        if(!room1.getBooked()){
            selectedRoom = room1;
            room1.setBooked(true);
        }else if(!room2.getBooked()){
            selectedRoom = room2;
            room2.setBooked(true);
        }else{
            selectedRoom = null;
        }
        return selectedRoom;
    }
    private static DeluxeSpa getDeluxeSpaRoom(DeluxeSpa room1, DeluxeSpa room2){
        DeluxeSpa selectedRoom;
        if(!room1.getBooked()){
            selectedRoom = room1;
            room1.setBooked(true);
        }else if(!room2.getBooked()){
            selectedRoom = room2;
            room2.setBooked(true);
        }else{
            selectedRoom = null;
        }
        return selectedRoom;
    }
    private static FamilySuite getFamilySuite(FamilySuite room1, FamilySuite room2){
        FamilySuite selectedRoom;
        if(!room1.getBooked()){
            selectedRoom = room1;
            room1.setBooked(true);
        }else if(!room2.getBooked()){
            selectedRoom = room2;
            room2.setBooked(true);
        }else{
            selectedRoom = null;
        }
        return selectedRoom;
    }
    private static TwoBedroomFamilySuite getTwoBedroomFamilySuite(TwoBedroomFamilySuite room1, TwoBedroomFamilySuite room2){
        TwoBedroomFamilySuite selectedRoom;
        if(!room1.getBooked()){
            selectedRoom = room1;
            room1.setBooked(true);
        }else if(!room2.getBooked()){
            selectedRoom = room2;
            room2.setBooked(true);
        }else{
            selectedRoom = null;
        }
        return selectedRoom;
    }
}