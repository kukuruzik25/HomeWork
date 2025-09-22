import java.util.Scanner;

public class DZN2_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n^n -> введите n: ");
		int n = sc.nextInt();
		int summa = 0;
		int degree = 1;
		for (int i = 1; i <= n; i++) {
			degree = degree * n;
			summa = summa + degree;
		}
		System.out.println("Сумма = " + summa);
	}
}