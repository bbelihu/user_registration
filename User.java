package com.company.Betab;

import java.util.Scanner;

public class User {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private int houseNumber;
    private String streetName;
    private String stateName;
    private int postalCode;
    private MyJDBC jdbc = new MyJDBC();

    public boolean createFirstname(String firstName){
        boolean flag=true;
        char [] arr = firstName.toCharArray();
        for(int i=0; i< arr.length; ++i){
            if(Character.isDigit(arr[i])){
                System.out.println("FirstName can't have a digit:");
               return false;
            }
            if(!Character.isLetterOrDigit(arr[i])){
                System.out.println("FirstName can't have alphanumeric: ");
                return false;
            }
        }

        //Cant have empty String or have more than 24 characters.
        if(firstName.isEmpty()){
            System.out.println("FirstName can't be empty: ");
            return false;
        }else if(firstName.length()>24){
            System.out.println("Firstname can't be longer than 24 characters:");
            return false;
        }else{
            this.firstName = firstName;
            return true;
        }
    }

    public boolean createLastName(String lastName){
        boolean flag=true;
        char [] arr = lastName.toCharArray();
        for(int i=0; i< arr.length; ++i){
            if(Character.isDigit(arr[i])){
                System.out.println("lastName can't have a digit:");
                return false;
            }
            if(!Character.isLetterOrDigit(arr[i])){
                System.out.println("LastName can't have alphanumeric: ");
                return false;
            }
        }

        //Cant have empty String or have more than 24 characters.
        if(lastName.isEmpty()){
            System.out.println("LastName can't be empty: ");
            return false;
        }else if(lastName.length()>24){
            System.out.println("Lastname can't be longer than 24 characters:");
            return false;
        }
        else{
            this.lastName = lastName;
            return true;
        }
    }

    public boolean createPhoneNumber(String phoneNumber){
        char [] arr = phoneNumber.toCharArray();
        for(int i=0; i< arr.length; ++i){
            if(Character.isLetter(arr[i])){
                System.out.println("phone is not a digit:");
                return false;
            }
            if(!Character.isLetterOrDigit(arr[i])){
                System.out.println("phone can't have alphanumeric: ");
                return false;
            }
        }

        if(phoneNumber.isEmpty()){
            System.out.println("Phone number can't be empty");
            return false;
        }else if(phoneNumber.length()>10|| phoneNumber.length()<10){
            System.out.println("Phone number can't be longer or shorter than 10 characters.");
            return false;
        }else{
            this.phoneNumber = phoneNumber;
            return true;
        }
    }

    public boolean createEmail(String emailAddress){

        boolean comFlag = emailAddress.contains(".com");
        boolean eduFlag = emailAddress.contains(".edu");
        boolean govFlag = emailAddress.contains(".gov");
        boolean orgFlag = emailAddress.contains(".org");


        if(emailAddress.isEmpty()){
            System.out.println("Email address can't be empty!");
            return false;
        }
        else if(!emailAddress.contains("@")) {
            System.out.println("Email address needs to contain an @ sign:");
            return false;
        }else if(comFlag&&eduFlag&&orgFlag&&govFlag){
            System.out.println("Invalid ending");
            return false;
        }
         else{
            this.emailAddress = emailAddress;
            return true;
        }
    }
    public boolean createhouseNumber(int houseNumber){
        if(houseNumber>=1){
            this.houseNumber = houseNumber;
            return true;
        }else{
            return false;
        }

    }
    public boolean createstreetName(String streetName){
        if(streetName.isEmpty()){
            return false;
        }
        this.streetName = streetName;
        return true;
    }
    public boolean createStatename(String stateName){
        switch(stateName.toLowerCase()){
            case "alabama": this.stateName = stateName; break;
            case "alaska": this.stateName = stateName; break;
            case "arizona": this.stateName = stateName; break;
            case"arkansas": this.stateName = stateName; break;
            case "california": this.stateName = stateName; break;
            case "colorado": this.stateName = stateName; break;
            case "connecticut": this.stateName = stateName; break;
            case "delware": this.stateName = stateName; break;
            case "florida": this.stateName = stateName; break;
            case "georgia": this.stateName = stateName; break;
            case "hawaii": this.stateName = stateName; break;
            case "idaho": this.stateName = stateName; break;
            case "illinois": this.stateName = stateName; break;
            case "indiana": this.stateName = stateName; break;
            case "iowa": this.stateName = stateName; break;
            case "kansas": this.stateName = stateName; break;
            case "kentucky": this.stateName = stateName; break;
            case "louisiana": this.stateName = stateName; break;
            case "maine": this.stateName = stateName; break;
            case "maryland": this.stateName = stateName; break;
            case "massachusetts": this.stateName = stateName; break;
            case "michigan": this.stateName = stateName; break;
            case "minnesota": this.stateName = stateName; break;
            case "mississippi": this.stateName = stateName; break;
            case "missouri": this.stateName = stateName; break;
            case "montana": this.stateName = stateName; break;
            case "nebraska": this.stateName = stateName; break;
            case "nevada": this.stateName = stateName; break;
            case "new hampshire": this.stateName = stateName; break;
            case "new jersey": this.stateName = stateName; break;
            case "new mexico": this.stateName = stateName; break;
            case "new york": this.stateName = stateName; break;
            case "north carolina": this.stateName = stateName; break;
            case "north dakota": this.stateName = stateName; break;
            case "ohio": this.stateName = stateName; break;
            case "oklahoma": this.stateName = stateName; break;
            case "oregon": this.stateName = stateName; break;
            case "pennsylvania": this.stateName = stateName; break;
            case "rhode island": this.stateName = stateName; break;
            case "south carolina": this.stateName = stateName; break;
            case "south dakota": this.stateName = stateName; break;
            case "tennessee": this.stateName = stateName; break;
            case "texas": this.stateName = stateName; break;
            case "utah": this.stateName = stateName;break;
            case "vermont": this.stateName = stateName; break;
            case "virginia":this.stateName = stateName; break;
            case "washington": this.stateName = stateName; break;
            case "west virginia": this.stateName = stateName; break;
            case "wisconsin": this.stateName = stateName; break;
            case "wyoming": this.stateName = stateName; break;
            default:
                System.out.println("State doesn't exist");
                return false;
        }
        if(!this.stateName.isEmpty()){
            return true;
        }
        else
            return false;
    }

    public boolean createPostalCode(int postalCode){
        int length= Integer.toString(postalCode).length();
        if(length!=5){
            System.out.println("Postal code must be five digits");
            return false;
        }
        this.postalCode = postalCode;
        return true;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        if(phoneNumber.isEmpty()){
            return "No phone number registered!";
        }
        String new_string="+1-";
        for(int i=0;i<10;i++){
            new_string+= this.phoneNumber.charAt(i);
            if(i==2 || i==5){
                new_string+="-";
            }
        }
        return new_string;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStateName() {
        return stateName;
    }
    public int getPostalCode() {
        return postalCode;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName=lastName;
    }

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setHouseNumber(int streetNumber) {
        this.houseNumber = streetNumber;
    }

    public void setStreetName(String streetName) {

        this.streetName = streetName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }



}
