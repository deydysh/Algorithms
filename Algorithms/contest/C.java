package contest;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int t = scan.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) a[i] = scan.nextInt();
        int who = scan.nextInt();
        int sum = 0;
        if (a[who-1] > t) sum = Math.min(a[who - 1] + a[n-1] - 2*a[0],2*a[n-1] - a[who-1] - a[0]);
        else sum = a[n-1] - a[0];
        System.out.println(sum);
    }
}
