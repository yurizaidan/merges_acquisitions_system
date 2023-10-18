package model;
import java.util.Scanner;

public class Input {
    public static int readInt (){
        Scanner in = new Scanner(System.in);

        System.out.println("\nEnter input: ");
        System.out.println(":>");

        while(!in.hasNextInt()){
                in.next();
                 System.out.println("Invalid entry! Only integer type allowed. Please try again: \n:>");

        }
        int input=in.nextInt();
        in.nextLine();
        return input;
        }

	public static String readString (){
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter input: ");
        System.out.println(":>");
        return in.nextLine();
    }

    
    public static double readDouble (){
        Scanner in = new Scanner(System.in);

        System.out.println("\nEnter input: ");
        System.out.println(":>");
       
        while(!in.hasNextDouble()){
            in.next();
            System.out.println("Invalid entry! Only double type allowed. Please try again: n:>");
        }
        
        double input = in.nextDouble();
        in.nextLine();
        return input;
    }
}
