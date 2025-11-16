public class MainStudent {
	public static void main(String[] args) {
		Student student_1 = new Student();
		Student student_2 = new Student("Фуфик", "Фуфикович", 18);
		Student student_3 = new Student("284691", "Лео", "Лексусович", 18, 0.0, "ИТИС");

		student_1.displayInfo();
		student_2.displayInfo();
		student_3.displayInfo();

		student_1.setStudentId("114143");
		student_3.displayInfo(true);
        student_2.updateGrade(6.0, "информатика");
        student_2.displayInfo(true);

        System.out.println("Общее кол-во студентов: " + Student.getTotalStudents());
	}
}