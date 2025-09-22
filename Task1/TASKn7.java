import java.util.Scanner;
public class TASKn7 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		int minR = 0;
		for (int r = 1; r < 10; r++) {
			if ((x*x + y*y) <= r*r) {
				minR = r;
				break;
			} 		
		}
		if (minR == 0) {
			System.out.println("missed");
		} else {
			System.out.println(minR);
		}
	}
}