package com.company.Betab;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MyJDBC {
    public static void insert(User user, int id) {

        // TODO Auto-generated method stub
        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://regestrationdatabase.calp569vakzj.us-east-1.rds.amazonaws.com/user_info";
        final String USER = "admin";
        final String PASS = "Abiwongel103470";

        Connection conn = null;

        try {

            // Using the preparedstatement:
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to the database........");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Inserting into table in the given database......");
            String sql = "INSERT INTO users (id, firstName, lastName, phoneNumber, email, houseNumber, streetName, stateName, postalCode) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,id);
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getPhoneNumber());
            statement.setString(5, user.getEmailAddress());
            statement.setInt(6,user.getHouseNumber());
            statement.setString(7, user.getStreetName());
            statement.setString(8, user.getStateName());
            statement.setInt(9,user.getPostalCode());
            statement.executeUpdate();
            System.out.println("User added to the database...........");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void delete(String name) {
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://regestrationdatabase.calp569vakzj.us-east-1.rds.amazonaws.com/user_info";
        final String USER = "admin";
        final String PASS = "Abiwongel103470";

        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String deleteSQL = "DELETE FROM users WHERE firstName = ?";
            PreparedStatement statement = conn.prepareStatement(deleteSQL);
            statement.setString(1,name);
            statement.executeUpdate();
            System.out.println("User deleted from the database ..........");


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }




    public static void getInfo(String name){
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://regestrationdatabase.calp569vakzj.us-east-1.rds.amazonaws.com/user_info";
        final String USER = "admin";
        final String PASS = "Abiwongel103470";
        String firstName="";
        String lastName="";
        String phoneNumber="";
        String email="";
        int houseNumber=0;
        String streetName="";
        String stateName="";
        int postalCode=0;
        int id=0;
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "SELECT * FROM users WHERE firstName = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
             ResultSet result = statement.executeQuery();
            while(result.next()){
                  id = result.getInt(1);
                 firstName = result.getString(2);
                 lastName = result.getString(3);
                 phoneNumber = result.getString(4);
                 email = result .getString(5);
                 houseNumber = result .getInt(6);
                 streetName = result .getString(7);
                 stateName = result .getString(8);
                 postalCode= result .getInt(9);
            }

            if(firstName.isEmpty()|| result== null){
                System.out.println("Sorry User doesn't exist!!!!");
            }else{
                System.out.printf("User %d: \n\t FirstName:%s \n\t LastName:%s \n\t PhoneNumber:%s \n\t Email:%s \n\t HouseNumber:%d \n\t StreetName:%s \n\t StateName:%s\n\t PostalCode:%d\n",
                        id,firstName,lastName,phoneNumber,email,houseNumber,streetName,stateName,postalCode);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }




    public static void updateInfo(){
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://regestrationdatabase.calp569vakzj.us-east-1.rds.amazonaws.com/user_info";
        final String USER = "admin";
        final String PASS = "Abiwongel103470";
        Connection conn = null;
        System.out.println("Enter the firstName of the user you want to update:");
        Scanner f= new Scanner(System.in);
        String first= f.nextLine();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql= "Update users SET firstName=?, lastName=?, phoneNumber=?, email=?, houseNumber=?, streetName=?, stateName=?, postalCode=? WHERE firstName=?";
            PreparedStatement statement= conn.prepareStatement(sql);
            System.out.println("*****Enter New First Name:********");
            String new_First= f.nextLine();
            System.out.println("*****Enter New last Name:********");
            String new_last= f.nextLine();
            System.out.println("*****Enter New phone Number:********");
            String new_phoneNumber= f.nextLine();
            String new_string="+1-";
            for(int i=0;i<new_phoneNumber.length();i++){
                new_string+= new_phoneNumber.charAt(i);
                if(i==2 || i==5){
                    new_string+="-";
                }
            }
            System.out.println("*****Enter New emailAddress:********");
            String new_email= f.nextLine();
            System.out.println("*****Enter New streetNumber:********");
            int streetNu= f.nextInt();
            f.nextLine();
            System.out.println("*****Enter New street Name:********");
            String streetN= f.nextLine();
            System.out.println("*****Enter New state Name:********");
            String state= f.nextLine();
            System.out.println("*****Enter New postalCode:********");
            int post= f.nextInt();

            statement.setString(1,new_First);
            statement.setString(2,new_last);
            statement.setString(3,new_string);
            statement.setString(4,new_email);
            statement.setInt(5,streetNu);
            statement.setString(6,streetN);
            statement.setString(7,state);
            statement.setInt(8,post);
            statement.setString(9,first);
            int rowsUpdate= statement.executeUpdate();
            if(rowsUpdate>0){
                System.out.println("User was updated");
            }
            else{
                System.out.println("User was not updated");
            }




        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }






    }
}
