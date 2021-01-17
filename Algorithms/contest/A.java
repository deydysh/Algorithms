package contest;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int A, B, C, D;
        A = scan.nextInt();
        B = scan.nextInt();
        C = scan.nextInt();
        D = scan.nextInt();
        if (B >= D) System.out.println(A);
        else System.out.println(A + (D-B)*C);
    }
}
