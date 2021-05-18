import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Model mainData = new Model();
        Boat boat1 = new Boat( "Kajak01","Kajak", 2,23.0);
        Employee employee1 = new Employee("user01","123abc");
        Customer customer1 = new Customer("Smith",6873434,"kazernalaanstraat 101");

        ObjectMapper mapper = new ObjectMapper();


//        try {
//            mainData = mapper.readValue(new File("c:\\Users\\zgoksu\\temp\\model.json"), Model.class);
//            mainData.customers.add(customer1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



//        try {
//            // Java object to JSON file
//            mapper.writeValue( new File("c:\\Users\\zgoksu\\temp\\model.json"), mainData);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


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

        //print the boats
        try{
            Model model1 = mapper.readValue(new File("c:\\Users\\zgoksu\\temp\\model.json"), Model.class);
            for(Boat boatIn : model1.boats){
                System.out.println(boatIn);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        // prints customers
        try{
            Model model1 = mapper.readValue(new File("c:\\Users\\zgoksu\\temp\\model.json"), Model.class);
            for(Customer customerIn : model1.customers){
                System.out.println(customerIn);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
