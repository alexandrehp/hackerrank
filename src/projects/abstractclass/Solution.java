package projects.abstractclass;


import java.io.*;
import java.util.*;

abstract class Book{
    String title;
    abstract void setTitle(String s);
    String getTitle(){
        return title;
    }
}
class MyBook extends Book {
    @Override
    void setTitle(String s) {
        title = s;
    }
}
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        MyBook myBook = new MyBook();
        myBook.setTitle(title);
        System.out.println("The title is: " + myBook.getTitle());
        sc.close();


    }
}
