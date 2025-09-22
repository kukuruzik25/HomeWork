import java.util.Scanner;
public class TASKn5 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		int n = sc.nextInt();
		int n1 = n / 2;
		if ((-n1 < x && x < n1) && (-n1 < y && y < n1)) {
			System.out.print("Точка (" + x + ", " + y + ") лежит в квадрате размера " + n + " x " + n);
		} else if (-n1 == x || n1 == x || -n1 == y || n1 == y)  {
			System.out.print("Точка (" + x + ", " + y + ") лежит на квадрате размера " + n + " x " + n);
		} else {
			System.out.print("Точка (" + x + ", " + y + ") не лежит в квадрате размера " + n + " x " + n);
		}
	}
}
