import java.util.Scanner;

public class DZN2_5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n! -> введите n: ");
		int n = sc.nextInt();
		int summa = 0;
		int factorial = 1;
		for (int i = 1; i <= n; i++) {
			factorial = factorial * i;
			summa = summa + factorial;
		}
		System.out.println("Сумма = " + summa);
	}
}