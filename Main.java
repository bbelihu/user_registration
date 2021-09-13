package com.company.Betab;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RegistrationUI userInt = new RegistrationUI();
        Scanner in = new Scanner(System.in);
        userInt.helpScreen();
        int help= in.nextInt();
        in.nextLine();
        while(help!=0){

            switch(help){
                case 1: userInt.register();break;
                case 2: userInt.get();break;
                case 3: userInt.update();break;
                case 4: userInt.delete();break;
            }
            userInt.helpScreen();
            help =in.nextInt();
            in.nextLine();

        }
        if(help == 0){
            System.out.println("User quit the program.....");
        }
    }
}