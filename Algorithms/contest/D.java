package contest;

import java.util.Locale;
import java.util.Scanner;


public class D {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US"));
        Scanner scan = new Scanner(System.in);

        float x = scan.nextFloat();
        float y = scan.nextFloat();

        float x1 = scan.nextFloat();
        float y1 = scan.nextFloat();
        float x2 = scan.nextFloat();
        float y2 = scan.nextFloat();
        float x3 = scan.nextFloat();
        float y3 = scan.nextFloat();
        float x4 = scan.nextFloat();
        float y4 = scan.nextFloat();

        String str = String.format("%.5f", (x1*x / (x + x1 - x2)) + "%.5f",(y1*y / (y + y1 - y3)));
        System.out.println(str);
    }
}
