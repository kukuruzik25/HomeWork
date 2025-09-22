import java.util.Scanner;

public class DZN2_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Введите кол-во столбцов: ");
		int n = sc.nextInt();
		System.out.print("Введите кол-во строк: ");
		int m = sc.nextInt();
		while (m > 0) {
			System.out.print("1 ");
			m = m - 1;
			for (int i = n - 1; i > 0; i--) {
				System.out.print("1 ");
			}
			System.out.println();
		}			
	}
}
