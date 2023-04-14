package projects.exceptionhandling;

import java.util.Scanner;

/**
 *Output Format
 *
 * Each line of the output contains the result , if both  and  are positive. If either  or  is negative, the output contains "n and p should be non-negative". If both  and  are zero, the output contains "n and p should not be zero.". This is printed by the locked stub code in the editor.
 *
 * Sample Input 0
 *
 * 3 5
 * 2 4
 * 0 0
 * -1 -2
 * -1 3
 * Sample Output 0
 *
 * 243
 * 16
 * java.lang.Exception: n and p should not be zero.
 * java.lang.Exception: n or p should not be negative.
 * java.lang.Exception: n or p should not be negative.
 *
 */

class MyCalculator {
    long power(int n, int p) throws Exception {
        if (n < 0 || p < 0) {
            throw new Exception("n or p should not be negative.");
        } else if (n == 0 && p == 0) {
            throw new Exception("n and p should not be zero.");
        } else {
            return (long) Math.pow(n, p);
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int p = in.nextInt();
            MyCalculator my_calculator = new MyCalculator();
            try {
                System.out.println(my_calculator.power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
