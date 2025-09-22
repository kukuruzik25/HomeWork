import java.util.Scanner;
public class TASKn6 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		int n = sc.nextInt();
		if ((x*x + y*y) < n*n) {
			System.out.print("Точка (" + x + ", " + y + ") лежит в круге с радиусом " + n);
		} else if ((x*x + y*y) == n*n) {
			System.out.print("Точка (" + x + ", " + y + ") лежит на круге с радиусом " + n);
		} else {
			System.out.print("Точка (" + x + ", " + y + ") не лежит в круге с радиусом " + n);
		}
	}
}