import java.util.Scanner;
public class TASKn2 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		float x = sc.nextFloat();
		float y = sc.nextFloat();
		if (x > y) {
			System.out.print(x + " - максимальное");	
		} else if (x < y) {
			System.out.print(y + " - максимальное");
		} else {
			System.out.print("Числа равны");
		}
	}
}