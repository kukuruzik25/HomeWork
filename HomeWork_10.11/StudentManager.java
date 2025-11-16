public class StudentManager {

	private Student[] students;
	private Course[] courses;

	private int countStudents;
	private int countCourses;

	public StudentManager() {
		this.students = new Student[10];
		this.courses = new Course[5];
		this.countStudents = 0;
		this.countCourses = 0;
	}

	public void addStudentToCourse(Student student, Course course) {
		students[countStudents] = student;
		countStudents++;
		courses[countCourses] = course;
		countCourses++;
		course.enrollStudent(student.getStudentId());
		System.out.println("Студент " + student.getFirstName() + " " + student.getLastName() + " успешно зачислен на курс " + course.getCourseName());
		System.out.println();
	}

	public void findStudentById(String studentId) {
		for (int i = 0; i < countStudents; i++) {
			String this_Id = students[i].getStudentId();
			if (this_Id.equals(studentId)) {
				students[i].displayInfo(true);
				return;
			} 
		}	
		System.out.println("Студент не найден");	
	}

	public void getStudentsByFaculty(String faculty) {
		System.out.println("Студенты факультета " + faculty + ":");
		for (int i = 0; i < countStudents; i++) {
			String this_faculty = students[i].getFaculty();
			if (this_faculty.equals(faculty)) {
				students[i].displayInfo(false);
			}
		}
		System.out.println();
	}

	public void calculateFacultyAverage(String faculty) {
		int count = 0;
		double sum_average = 0;
		for (int i = 0; i < countStudents; i++) {
			String this_faculty = students[i].getFaculty();
			if (this_faculty.equals(faculty)) {
				count++;
				sum_average += students[i].getAverageGrade();
			}
		}
		if (count > 0) {
			double average_faculty = sum_average / count;
			System.out.println("Средний балл факультета " + faculty + " ---> " + average_faculty);
		} else {
			System.out.println("На факультете ---> " + faculty + " ---> нет студентов:(");
		}
		System.out.println();
	}
}