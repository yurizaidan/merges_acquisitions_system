package model;

import java.util.Scanner;

public class Input {
    //This is a method for reading int type
    public static int readInt (){
        Scanner in = new Scanner(System.in);

        System.out.println("\nEnter input: ");
        System.out.println(":>");
        //Creates a loop while user tries to input values different from integers
        while(!in.hasNextInt()){
            in.next();
            System.out.println("Invalid entry! Only integer type allowed. Please try again: \n:>");
        }
        //Once the value meets the criteria, it is attributed to the variable input
        int input = in.nextInt();
        in.nextLine();
        return input;
    }

    //This is a method for reading String type
    public static String readString (){
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter input: ");
        System.out.println(":>");
        return in.nextLine();
    }

    //This is a method for reading double type
    public static double readDouble (){
        Scanner in = new Scanner(System.in);

        System.out.println("\nEnter input: ");
        System.out.println(":>");
        //Creates a loop while user tries to input values different from integers
        while(!in.hasNextDouble()){
            in.next();
            System.out.println("Invalid entry! Only double type allowed. Please try again: n:>");
        }
        //Once the value meets the criteria, it's attributed to the variable input
        double input = in.nextDouble();
        in.nextLine();
        return input;
    }
}
