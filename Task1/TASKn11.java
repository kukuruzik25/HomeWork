import java.util.Scanner;

public class TASKn11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int i = 0;
        int k = 1;
        while (b > 0) {
            i = i + (b % 10 * k);
            k = k * 2;
            b = b / 10;
        }
        System.out.println(i);
    }
}
