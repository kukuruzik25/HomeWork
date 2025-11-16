public class Student {

	public final String university_name = "KPFU";
	private static int totalStudents = 0;	

	private String studentId;
	private String firstName;
	private String lastName;
	private int age;
	private double averageGrade;
	private String faculty;

	public Student() {
		this("123456", "Про", "Пробный", 18, 0.0, "ИМОИиВ");
	}

	public Student(String firstName, String lastName, int age) {
		this("000000", firstName, lastName, age, 0.0, "ИСФНИМК");
	}

	public Student(String studentId, String firstName, String lastName, int age, double averageGrade, String faculty) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.averageGrade = averageGrade;
		this.faculty = faculty;
		totalStudents++;
	}

	public void setStudentId(String studentId) {
		if ((studentId != null) || (studentId.trim() != " ")) {
			this.studentId = studentId;
		} else {
			System.out.println("Введенный ID невалиден");
		}
		System.out.println();
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAge(int age) {
		if ((16 <= age) && (age <= 70)) {
			this.age = age;
		} else {
			System.out.println("Введенный возраст невалиден");
		}
		System.out.println();
	}
	public void setAverageGrade(double averageGrade) {
		if ((0.0 <= averageGrade) && (averageGrade <= 5.0)) {
			this.averageGrade = averageGrade;
		} else {
			System.out.println("Введенный балл невалиден");
		}
		System.out.println();
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	
	public String getStudentId() {
		return this.studentId;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public int getAge() {
		return this.age;
	}
	public double getAverageGrade() {
		return this.averageGrade;
	}
	public String getFaculty() {
		return this.faculty;
	}
	public static int getTotalStudents() {
		return totalStudents;
	}

	public void displayInfo() {
		System.out.println("=====Информация=====");
		System.out.println("ВУЗ: " + university_name);
		System.out.println("Имя: " + firstName);
		System.out.println("Фамилия: " + lastName);
		System.out.println("Возраст: " + age);
		System.out.println();
	}

	public void displayInfo(boolean detailed) {
		if (detailed) {
			System.out.println("=====Полная информация=====");
			System.out.println("ВУЗ: " + university_name);
			System.out.println("Номер студенческого билета: " + studentId);
			System.out.println("Имя: " + firstName);
			System.out.println("Фамилия: " + lastName);
			System.out.println("Возраст: " + age);
			System.out.println("Средний балл: " + averageGrade);
			System.out.println("Факультет: " + faculty);
			System.out.println();
		} else {
			this.displayInfo();
		}
	}

	public void updateGrade(double newGrade) {
		setAverageGrade(newGrade);
	}

	public void updateGrade(double newGrade, String subject) {
		this.updateGrade(newGrade);
		System.out.println("Средний балл по предмету " + subject + " изменен: новый балл ---> " + averageGrade);
		System.out.println();
	}
}