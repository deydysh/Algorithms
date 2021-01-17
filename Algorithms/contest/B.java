package contest;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if (n%2 != 0) System.out.println((n-1)/2 + n % 2);
        else System.out.println(n/2);
    }
}
