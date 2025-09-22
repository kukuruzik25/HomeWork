import java.util.Scanner;
public class TASKn4 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		if (x == y) {
			System.out.print("Числа равны");
		} else {
			System.out.print("Числа не равны");
		}
	}
}