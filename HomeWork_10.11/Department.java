import java.util.regex.*;
public class Department {
	
	private final double university_budget = 50000000.0;
	public static int totalDepartments;

	private String departmentName;
	private String headOfDepartment;
	private String officeRoom;
	private String email;
	private String phoneNumber;
	private double budget;

	public Department() {
		this("По ненужным вопросам", "Берёзов Петр Николаевич", "101", "bereza52@mail.ru", "79337509375", 100000);
	}

	public Department(String departmentName, String headOfDepartment, String phoneNumber) {
		this(departmentName, headOfDepartment, "20а|20б", "hist33rus@yandex.ru", phoneNumber, 1000000);
	}

	public Department(String departmentName, String headOfDepartment, String officeRoom, String email, String phoneNumber, double budget) {
		this.departmentName = departmentName;
		this.headOfDepartment = headOfDepartment;
		this.officeRoom = officeRoom;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.budget = budget;
		totalDepartments++;
	}

	public static boolean validateEmail(String email) {
		return email.matches("(\\w){2,}@(\\w){2,}\\.(\\w){2,}");
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public void setHeadOfDepartment(String headOfDepartment) {
		this.headOfDepartment = headOfDepartment;
	}
	public void setOfficeRoom(String officeRoom) {
		this.officeRoom = officeRoom;
	}
	public void setEmail(String email) {
		if (validateEmail(email)) {
			this.email = email;
		} else {
			System.out.println("Введенный email невалиден!");
		}
	}
	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber.matches("[\\d]+")) {
			this.phoneNumber = phoneNumber;
		} else {
			System.out.println("Номер телефона должен содержать только цифры!");
		}
	}
	public void setBudget(double budget) {
		if (budget >= 0) {
			this.budget = budget;
		} else {
			System.out.println("Бюджет не может быть отрицательным!");
			this.budget = 0;
		}
	}

	public String getDepartmentName() {
		return this.departmentName;
	}
	public String getheadOfDepartment() {
		return this.headOfDepartment;
	}
	public String getOfficeRoom() {
		return this.officeRoom;
	}
	public String getEmail() {
		return this.email;
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public double getBudget() {
		return this.budget;
	}
	public static int getTotalDepartments() {
		return totalDepartments;
	}

	public void contact() {
		System.out.println("=====Контактные данные=====");
		System.out.println("Кафедра: " + departmentName);
		System.out.println("Заведующий кафедрой: " + headOfDepartment);
		System.out.println("Номер кабинета: " + officeRoom);
		System.out.println("Email: " + email);
		System.out.println("Номер телефона: " + phoneNumber);
		System.out.println("Бюджет: " + budget);
		System.out.println();
	}
	public void contact(String message) {
		System.out.println("=====Контактные данные для отправки сообщения=====");
		System.out.println("Заведующий кафедрой: " + headOfDepartment);
		System.out.println("Email: " + email);
		System.out.println("Номер телефона: " + phoneNumber);
		System.out.println("Введите сообщение: " + message);
		System.out.println();
	}
	public void allocateBudget(double amount) {
		this.budget += amount;
		System.out.println("Выделены бюджетные средства в размере " + amount + " руб.");
	}
	public void allocateBudget(double amount, String purpose) {
		this.budget += amount;
		System.out.println("Выделены бюджетные средства в размере " + amount + " руб. " + "на нужды ---> " + purpose);
	}
}	