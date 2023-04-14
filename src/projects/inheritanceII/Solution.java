package projects.inheritanceII;


public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Adder a = new Adder();
        System.out.println("My superclass is: " + a.getClass().getSuperclass().getName());
        System.out.println(a.Add(30, 12) + " " + a.Add(10, 3) + " " + a.Add(10, 10));
    }
}

class Arithmetic {
    int Add(int x, int y) {
        return x + y;
    }
}

class Adder extends Arithmetic {
}