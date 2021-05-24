import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Model model = new Model();
        Model mainData = new Model();

//        Employee employee1 = new Employee(1, "user01","123abc");
        Customer customer1 = new Customer("Smith", 6873434, "smith@smith.com", "kazernalaanstraat 101");
        Employee employee2 = new Employee("saif", "abc123");


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
        System.out.println("To add new Boat to the system press any key \n and then press A");
        if (scanner.nextLine().equalsIgnoreCase("L")){
                mainData = mapper.readValue(new File("c:\\Users\\zgoksu\\temp\\model.json"), Model.class);
                for (Boat boatIn : mainData.boats) {
                    System.out.println(boatIn);
                }
        }
        System.out.println("To add new Boat to the system press A");
        String boatAdd = scanner.nextLine();
        if (boatAdd.equalsIgnoreCase("A")) {
            int chargingTime = 0;
            int boatSeats = 0;
            double keyInput_boatPrice;
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
            if (keyInput_boatType.equalsIgnoreCase("ELECTRICALBOAT")){
               PRICE: if(keyInput_boatPrice >= 35){
                    keyInput_boatPrice = Double.parseDouble(scanner.next());
                } else {
                    System.out.println("The renting price should be minimum 35: ");
                    keyInput_boatPrice = scanner.nextInt();
                }
            } else if (keyInput_boatType.equalsIgnoreCase("ROWINGBOAT")){
                if(keyInput_boatPrice >= 27.5){
                    keyInput_boatPrice = Double.parseDouble(scanner.next());
                 }else{
                    System.out.println("The renting price should be minimum 27.5: ");
                    keyInput_boatPrice = scanner.nextInt();
                }
            if (keyInput_boatType.equalsIgnoreCase("KAJAK")) {
                    if (keyInput_boatPrice >= 23) {
                        keyInput_boatPrice = Double.parseDouble(scanner.next());
                    } else{
                        System.out.println("The renting price should be minimum 23: ");
                        keyInput_boatPrice = scanner.nextInt();                    }
            }
            if (keyInput_boatType.equalsIgnoreCase("SUPBOARD")) {
                    if (keyInput_boatPrice >= 17.5) {
                        keyInput_boatPrice = Double.parseDouble(scanner.next());
                } else{
                        System.out.println("The renting price should be minimum 17.5: ");
                        double newPrice = scanner.nextInt();
                        keyInput_boatPrice = newPrice;
                    }
            }
            }
            System.out.println("A new Boat is added successfully.");
            Boat boat1 = new Boat(keyInput_boatType, boatSeats, keyInput_boatPrice, chargingTime);

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
        }



//        Rental rental1 = new Rental(LocalDateTime.parse("2021-05-20T00:00:00"),
//                22,
//                boat1,
//                customer1,
//                LocalDateTime.parse("2021-05-20T13:15:00"),
//                LocalDateTime.parse("2021-05-20T14:15:00"),
//                true,
//                false);


//        try {
//            mainData = mapper.readValue(new File("c:\\Users\\zgoksu\\temp\\model.json"), Model.class);
//            mainData.rentals.add(rental1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        try {
//            // Java object to JSON file
//            mapper.writeValue(new File("c:\\Users\\zgoksu\\temp\\model.json"), mainData);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    private static String setDate(String date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(date);
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd MM yyyy");
        return date;
    }


//        try{
//            Model model1 = mapper.readValue(new File("c:\\Users\\zgoksu\\temp\\model.json"), Model.class);
//            for(Customer customer : model1.customers){
//                System.out.println(customer);
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }

//        try {
//            // Java object to JSON file
//            mapper.writeValue(new File("c:\\Users\\zgoksu\\temp\\model.json"), model);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//print employees
//        try{
//            Model model1 = mapper.readValue(new File("c:\\Users\\zgoksu\\temp\\model.json"), Model.class);
//            for(Employee employeesIn : model1.employees){
//                System.out.println(employeesIn);
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }


    //        // prints customers
//        try{
//            Model model1 = mapper.readValue(new File("c:\\Users\\zgoksu\\temp\\model.json"), Model.class);
//            for(Customer customerIn : model1.customers){
//                System.out.println(customerIn);
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }

private static void addBoat(){

}


    private static boolean authenticate (String userName, String password, Model model1){
        for (Employee employee : model1.employees) {
            if (employee.getUserName().equals(userName) && employee.getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
        //returnun false yada true donmesinin ne farki var?
    }
}




