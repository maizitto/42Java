import java.util.*;

public class Program{
    public static void main (String[] args) {
        int input;
        int operations = 1;
        boolean isPrime = true;
        Scanner inp = new Scanner(System.in);

        input = inp.nextInt();
        if (input <= 1){
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        if (input % 2 == 0)
        {
            if (input == 2)
                isPrime = true;
            else
                isPrime = false;
        }
        else {
                for (int x = 3; isPrime && x <= input / x; x += 2) {
                    if (input % x == 0)
                        isPrime = false;
                    ++operations;
                }
            }
            System.out.println(isPrime + " " + operations);
    }
}