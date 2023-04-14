package projects.trycatch;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *You will be given two integers  and  as input, you have to compute .
 * If  and  are not  bit signed integers or if  is zero, exception will occur and you have to report it.
 * Read sample Input/Output to know what to report in case of exceptions.
 */
public class Solution {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        try {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int result = x / y;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println(e);
        } catch (InputMismatchException e){
            System.out.println(e.getClass().getCanonicalName());
        }

    }

}
