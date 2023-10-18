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
        return input
        }
}
