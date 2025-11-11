public class MainUniversitet {
	public static void main(String[] args) {
		Universitet student_1 = new Universitet();
		Universitet student_2 = new Universitet("Фуфик", "Фуфикович", 18);
		Universitet student_3 = new Universitet("284691", "Лео", "Лексусович", 18, 0.0, "ИТИС");

		student_1.displayInfo();
		student_2.displayInfo();
		student_3.displayInfo();

		student_1.setStudentId("114143");
		student_3.displayInfo(true);
        student_2.updateGrade(5.0, "информатика");
        student_2.displayInfo(true);

        System.out.println("Общее кол-во студентов: " + Universitet.getTotalStudents());
	}
}