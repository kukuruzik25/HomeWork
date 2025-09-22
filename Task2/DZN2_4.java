import java.util.Scanner;

public class DZN2_4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("2^n -> введите n: ");
		int n = sc.nextInt();
		int summa = 0;
		int degree = 1;
		for (int i = 1; i <= n; i++) {
			degree = degree * 2;
			summa = summa + degree;
		}
		System.out.println("Cумма = " + summa);
	}
}