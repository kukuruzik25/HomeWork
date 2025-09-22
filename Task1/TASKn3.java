import java.util.Scanner;
public class TASKn3 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		double z = sc.nextDouble();
		if (x > y && x > z) {
			System.out.print("Максимальное число - " + x);
		} else if (y > x && y > z) {
			System.out.print("Максимальное число - " + y);
		} else {
			System.out.print("Максимальное число - " + z);
		}
	}
}