package projects.larrysarray;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n;
        List<Integer> a;
        for (int i = 0; i < t; i++) {
            n = in.nextInt();
            a = new ArrayList<Integer>(n);
            for (int j = 0; j < n; j++) {
                a.add(in.nextInt());
            }
            for (int curElem = 1; curElem <= n - 2; curElem++) {
                int curIdx = a.indexOf(curElem);
                System.err.println(a);
                while (curIdx != curElem - 1) {
                    if (curIdx == a.size() - 1) {
                        int tmp = a.get(curIdx - 2);
                        a.set(curIdx - 2, a.get(curIdx - 1));
                        a.set(curIdx - 1, curElem);
                        a.set(curIdx, tmp);
                    } else {
                        int tmp = a.get(curIdx - 1);
                        a.set(curIdx - 1, curElem);
                        a.set(curIdx, a.get(curIdx + 1));
                        a.set(curIdx + 1, tmp);
                    }
                    curIdx--;
                }
            }
            System.err.println(a);
            boolean printed = false;
            for (int j = 1; j < a.size(); j++) {
                if (a.get(j) < a.get(j-1)) {
                    System.out.println("NO");
                    printed = true;
                }
            }
            if (!printed) System.out.println("YES");
        }        
    }
}