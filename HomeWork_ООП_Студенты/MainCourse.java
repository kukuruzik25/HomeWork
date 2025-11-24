public class  MainCourse {
	public static void main(String[] args) {
	Course my_course1 = new Course();
	Course my_course2 = new Course("46.03.01", "История", false);
	Course my_course3 = new Course("12.34.56", "На допке но не сломлены", 1000, 900, true);

	my_course1.displayInfo();
	my_course2.displayInfo(true);
	my_course3.displayInfo(false);

	my_course1.calculateWorkload(54);
	my_course2.enrollStudent("23140");
	my_course3.enrollStudent();

	System.out.println("Общее кол-во курсов: " +  Course.getTotalCourses());	
	}

	
}