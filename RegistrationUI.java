package com.company.Betab;
import java.util.ArrayList;
import java.util.Scanner;
public class RegistrationUI {
    private static ArrayList<User> users= new ArrayList<>();
    public static void get(){
        Scanner f = new Scanner(System.in);
        System.out.println("Please enter your firstName to get all your registration information: ");
        String name = f.nextLine();
        MyJDBC jdbc = new MyJDBC();
        jdbc.getInfo(name);

    }
    public static void update(){
       MyJDBC jdbc = new MyJDBC();
       jdbc.updateInfo();
    }



    public static void delete(){
        Scanner f = new Scanner(System.in);
        System.out.println("Please enter your firstName to delete information: ");
        String name = f.nextLine();
        MyJDBC jdbc = new MyJDBC();
        jdbc.delete(name);


    }
    public static void helpScreen(){
        System.out.println("****************** WELCOME TO THE USER REGISTRATION PAGE ***************************");
        System.out.println("\t 0.Enter 0 to quit:");
        System.out.println("\t 1.Enter 1 to register a User:");
        System.out.println("\t 2.Enter 2 to get your Data: ");
        System.out.println("\t 3.Enter 3 to update your data: ");
        System.out.println("\t 4.Enter 4 to delete your data: ");
    }
    public static void register(){
        Scanner input= new Scanner(System.in);
        User user1 = new User();
        System.out.println("Please enter FirstName:");
        String firstName= input.nextLine();
        boolean flag=user1.createFirstname(firstName);
        while (flag == false){
            System.out.println("Enter first name again");
            firstName=input.nextLine();
            flag= user1.createFirstname(firstName);
            System.out.println(flag);
        }
        System.out.println("Please enter LastName:");
        String lastName= input.nextLine();
        boolean lnameFlag=user1.createLastName(lastName);
        while (lnameFlag == false){
            System.out.println("Enter last name again");
            lastName=input.nextLine();
            lnameFlag= user1.createLastName(lastName);
            System.out.println(lnameFlag);
        }
        System.out.println("Please enter PhoneNumber:");
        String phoneNumber= input.nextLine();
        boolean phoneFlag=user1.createPhoneNumber(phoneNumber);
        while (phoneFlag == false){
            System.out.println("Enter phoneNumber again");
            phoneNumber=input.nextLine();
            phoneFlag= user1.createPhoneNumber(phoneNumber);
            System.out.println(phoneFlag);
        }
        System.out.println(user1.getPhoneNumber());
        System.out.println("Please enter EmailAddress:");
        String email= input.nextLine();
        boolean emailFlag=user1.createEmail(email);
        while (emailFlag == false){
            System.out.println("Enter email again");
            email=input.nextLine();
            emailFlag= user1.createEmail(email);
        }
        System.out.println(user1.getEmailAddress());


        System.out.println("Please enter houseNumber:");
        int streetNumber= input.nextInt();
        boolean houseNumberflag=user1.createhouseNumber(streetNumber);
        while(houseNumberflag == false){
            System.out.println("Enter street number");
            streetNumber= input.nextInt();
            houseNumberflag= user1.createhouseNumber(streetNumber);
        }
        input.nextLine();

        System.out.println("Please enter street name: ");
        String streetName = input.nextLine();
        boolean streetNameFlag=user1.createstreetName(streetName);
        while(streetNameFlag == false){
            System.out.println("Enter street name: ");
            streetName= input.nextLine();
            streetNameFlag= user1.createstreetName(streetName);
        }

        boolean stateFlag = false;
        System.out.println("Please enter state name: ");
        String stateName=  input.nextLine();
        stateFlag=user1.createStatename(stateName);
        while(stateFlag == false){
            System.out.println("Enter state: ");
            stateName= input.nextLine();
            stateFlag= user1.createStatename(stateName);
        }
        boolean postalFlag = false;
        System.out.println("Please enter postal code: ");
        int postalCode = input.nextInt();
        input.nextLine();
        postalFlag = user1.createPostalCode(postalCode);
        while(postalFlag == false){
            System.out.println("Enter postal code: ");
            postalCode= input.nextInt();
            input.nextLine();
            postalFlag = user1.createPostalCode(postalCode);
        }
        users.add(user1);
        if(users.add(user1) == true){
            MyJDBC jb = new MyJDBC();
            jb.insert(user1, users.size()-1);

        }

    }
}
