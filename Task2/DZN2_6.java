import java.util.Scanner;

public class DZN2_6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("k! * x^k -> введите k: ");
		int k = sc.nextInt();
		System.out.print("Введите x: ");
		double x = sc.nextDouble();
		int factorial = 1;
		double summa = 0;
		double degree = 1;
		for (int i = 1; i <= k; i++) {
			factorial = factorial * i;
			degree = degree * x;
			summa = factorial * degree;
		}
		System.out.print(k + "! * " + x + "^" + k + " = ");
		System.out.printf("%.2f", summa);
	}
}