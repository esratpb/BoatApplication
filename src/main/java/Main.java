import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Model model = new Model();
        Model mainData = new Model();
        Boat boat2 = new Boat(10,"KAJAK", 2, 30);

//        Employee employee1 = new Employee(1, "user01","123abc");
        Customer customer1 = new Customer("Smith", 6873434, "smith@smith.com", "kazernalaanstraat 101");
        Employee employee2 = new Employee("saif", "abc123");
        Rental rental1 = new Rental(LocalDateTime.of(2021,05,27, 10,00),boat2,customer1,
                LocalTime.of(10,00), LocalTime.of(12,00),2,70,true,true);

//Rental rental1 = new Rental(setDate("2021-05-27 10:10:10"),boat2,customer1,2,70,true,true);



        ObjectMapper mapper = new ObjectMapper();

        try {

            Model model1 = mapper.readValue(new File("c:\\Users\\zgoksu\\temp\\model.json"), Model.class);
//            System.out.println(model1.rentals.get(0));
            Scanner scanner = new Scanner(System.in);
            boolean isAuthenticated = false;
            System.out.println("Welcome to Boat Reservation Application");
            while (!isAuthenticated) {
                System.out.print("Please Enter your username: ");
                String userName = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                if (authenticate(userName, password, model1)) {
                    isAuthenticated = true;
                } else {
                    System.out.println("Incorrect username or password. Please enter your credentials again.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("To see the list of boats press L");
        System.out.println("To add new Boat to the system press A");
        String input =scanner.nextLine();
        if (input.equalsIgnoreCase("L")){
                mainData = mapper.readValue(new File("c:\\Users\\zgoksu\\temp\\model.json"), Model.class);
                for (Boat boatIn : mainData.boats) {
                    System.out.println(boatIn);
                }
                System.out.println("To add new Boat to the system press A");
                System.out.println("To delete a boat from the system press D");
                System.out.println("To update a boat info press U");
                input = scanner.nextLine();
        }

        if (input.equalsIgnoreCase("A")) {
            int chargingTime = 0;
            int boatSeats = 0;
            double keyInput_boatPrice;
            System.out.println("Please enter boat Id");
            int keyInput_boatId = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Please enter boat type: ");
            String keyInput_boatType = scanner.nextLine();
            if(keyInput_boatType.equalsIgnoreCase("ELECTRICALBOAT")){
                boatSeats = 4;
                chargingTime = 1;
            } else if(keyInput_boatType.equalsIgnoreCase("KAJAK")){
                boatSeats = 2;
                chargingTime = 0;
            } else if (keyInput_boatType.equalsIgnoreCase("ROWINGBOAT")){
                boatSeats = 4;
                chargingTime = 0;
            } else {
                boatSeats = 1;
                chargingTime = 0;
            }
            System.out.println("Please enter boat rent price per hour: ");
            keyInput_boatPrice = scanner.nextInt();
            scanner.nextLine();
            if (keyInput_boatType.equalsIgnoreCase("ELECTRICALBOAT")){
                if(keyInput_boatPrice < 35){
                    while (keyInput_boatPrice < 35){
                        System.out.println("The renting price should be minimum 35: ");
                        keyInput_boatPrice = scanner.nextInt();
                        scanner.nextLine();
                    }
                }
            } else if (keyInput_boatType.equalsIgnoreCase("ROWINGBOAT")) {
                if (keyInput_boatPrice < 27.5) {
                    while (keyInput_boatPrice < 27.5) {
                        System.out.println("The renting price should be minimum 27.5: ");
                        keyInput_boatPrice = scanner.nextInt();
                        scanner.nextLine();
                    }
                }
            } else if (keyInput_boatType.equalsIgnoreCase("KAJAK")) {
                    if(keyInput_boatPrice < 23){
                        while (keyInput_boatPrice < 23){
                            System.out.println("The renting price should be minimum 23: ");
                            keyInput_boatPrice = scanner.nextInt();
                            scanner.nextLine();
                        }
                    }
            }
            else if (keyInput_boatType.equalsIgnoreCase("SUPBOARD")) {
                    if(keyInput_boatPrice < 17.5){
                        while (keyInput_boatPrice < 17.5){
                            System.out.println("The renting price should be minimum 17.5: ");
                            keyInput_boatPrice = scanner.nextInt();
                            scanner.nextLine();
                        }
                    }
            }
            Boat boat1 = new Boat(keyInput_boatId,keyInput_boatType, boatSeats, keyInput_boatPrice, chargingTime);
            System.out.println("A new Boat is added successfully.");


            try {
                mainData = mapper.readValue(new File("c:\\Users\\zgoksu\\temp\\model.json"), Model.class);
                mainData.boats.add(boat1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                // Java object to JSON file
                mapper.writeValue(new File("c:\\Users\\zgoksu\\temp\\model.json"), mainData);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (input.equalsIgnoreCase("D")){
            // code to delete a boat
            System.out.println("Please enter the Id of the boat you want to delete:");
            int boatId = scanner.nextInt();

            for (Boat boatIn : mainData.boats){
                if(boatId == boatIn.getBoatId()){
                    mainData.boats.remove(boatIn);
                    System.out.println("The boat with id:" + boatId + " has been deleted");
                    break;
                }

            }
            // Java object to JSON file
            mapper.writeValue(new File("c:\\Users\\zgoksu\\temp\\model.json"), mainData);


        } else if(input.equalsIgnoreCase("U")){
            System.out.println("Please enter the Id of the boat you want to update:");
            int boatId = scanner.nextInt();
            for (Boat boatIn : mainData.boats){
                if(boatId == boatIn.getBoatId()){
                    double newPrice =scanner.nextInt();
                    boatIn.setMinimumPrice(newPrice);
                    System.out.println("The boat with id: " + boatId + " has been updated");
                    break;
                }
            }
            // Java object to JSON file
            mapper.writeValue(new File("c:\\Users\\zgoksu\\temp\\model.json"), mainData);

        }

            }



//
//        try {
//            mainData = mapper.readValue(new File("c:\\Users\\zgoksu\\temp\\model.json"), Model.class);
//            mainData.rentals.add(rental1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            // Java object to JSON file
//            mapper.writeValue(new File("c:\\Users\\zgoksu\\temp\\model.json"), mainData);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



//    private static String setDate(String date) {
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//        String strDate = dateFormat.format(date);
//        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd MM yyyy");
//        return date;
//    }


    private static boolean authenticate (String userName, String password, Model model1){
        boolean isAuthenticated = false;
        for (Employee employee : model1.employees) {
            if (employee.getUserName().equals(userName) && employee.getPassword().equals(password)) {
                isAuthenticated = true;
            }
        }
        return isAuthenticated;

    }
}




