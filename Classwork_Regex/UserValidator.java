import java.util.Scanner;
public class  UserValidator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in, "CP866");
		String name = sc.nextLine();
		validName(name);
	}
	public static void validName(String name) {
		boolean isValid = name.matches("([А-Я]{1})([а-я]{1,})");
		System.out.println(isValid);
	}
}