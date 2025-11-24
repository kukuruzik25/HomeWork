public class MainStudentManager {
	public static void main(String[] args) {

		Student student_1 = new Student();
		Student ivan = new Student("000001", "Иван", "Золо", 21, 3.0, "ИТИС");
		Student milana = new Student("000002", "Милана", "Некрасова", 18, 4.0, "ИТИС");

		Course imoiv = new Course("46.03.01", "История", false);
		Course itis = new Course();

		StudentManager manager_1 = new StudentManager();

		manager_1.addStudentToCourse(student_1, imoiv);
		manager_1.addStudentToCourse(ivan, itis);
		manager_1.addStudentToCourse(milana, itis);

		manager_1.getStudentsByFaculty("ИТИС");
		manager_1.findStudentById("000001");
		manager_1.getStudentsByFaculty("ИМОИиВ");
		manager_1.calculateFacultyAverage("ИМОИиВ");
	}
}