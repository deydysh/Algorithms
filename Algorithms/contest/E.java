package contest;

import java.util.Scanner;

public class E {
    final static int inf = 300001;
    static int n;
    static int a[];

    public static int next (int value, int coupons, int number) {
        if (number == n - 1) return value; //последнее значение в цепи
        if (number == 0 & a[number] > 100) coupons++;
        if (a[number+1] > 100) {
            if (coupons > 0)
                return value + Math.min(next(a[number + 1], coupons + 1, number + 1), next(0, coupons - 1, number + 1));
            else if (coupons == 0)
                return value + next(a[number + 1], 1, number + 1);
        }
        else { // a[i] <= 100
            if (coupons > 0)
                return value + Math.min(next(a[number + 1], coupons, number + 1), next(0, coupons - 1, number + 1));
            else if (coupons == 0)
                return value + next(a[number + 1], 0, number + 1);
        }
        return 300001;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scan.nextInt();
        int ans = next(a[0], 0, 0);
        System.out.println(ans);
    }
}
