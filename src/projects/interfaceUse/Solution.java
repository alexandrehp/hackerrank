package projects.interfaceUse;

import java.util.Scanner;

interface AdvancedArithmetic{
     int divisor_sum(int n);
}

class MyCalculator implements AdvancedArithmetic{
    @Override
    public int divisor_sum(int n){
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    };

}

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n > 1000){
            return;
        }

        MyCalculator myCalculator = new MyCalculator();

        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );

        int test = myCalculator.divisor_sum(n);
        System.out.println(test);
        sc.close();

    }
}
