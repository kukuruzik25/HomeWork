public class Course {
	
	public static final int max_credits_in_year = 60;
	private static int totalCourses;

	private String courseCode;
	private String courseName;
	private int maxStudents;
	private int currentStudents;
	private boolean isActive;

	public Course() {
		this("09.03.04", "Программная инженерия", 10, 0, false);
	}
	public Course(String courseCode, String courseName, boolean isActive) {
		this(courseCode, courseName, 100, 0, isActive);
	}
	public Course(String courseCode, String courseName, int maxStudents, int currentStudents, boolean isActive) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.maxStudents = maxStudents;
		this.currentStudents = currentStudents;
		this.isActive = isActive;
		totalCourses++;
	}

	public void setCourseCod(String courseCode) {
		this.courseCode = courseCode;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}
	public void setCurrentStudents(int currentStudents) {
		if (currentStudents <= maxStudents) {
			this.currentStudents = currentStudents;
		} else {
			System.out.println("Кол-во зачисленных студентов не может превышать максимальное кол-во студентов");
		}
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getCourseCod() {
		return this.courseCode;
	}
	public String getCourseName() {
		return this.courseName;
	}
	public int getMaxStudents() {
		return this.maxStudents;
	}
	public int getCurrentStudents() {
		return this.currentStudents;
	}
	public boolean getIsActive() {
		return this.isActive;
	}
	public static int getTotalCourses() {
		return totalCourses;
	}
//1 з.е. = 36 академ.ч., 1 академ.ч. = 45 мин. 1 кредит = 36 академ.ч. Объем 1 уч.г = 60 кредитов 
	public static void calculateWorkload(int credits) {
		int workLoad_hours = (credits * 36 * 45) / 60;
		if (credits >= max_credits_in_year) {
			System.out.println("Студент успешно прошел 1 год обучения!");
		}
		System.out.println("Общая нагрузка составила: " + workLoad_hours + " ч.");
		System.out.println();
	}

	public void enrollStudent() {
		if (currentStudents + 1 <= maxStudents) {
			System.out.println("Студяра зачислен");
			currentStudents++;
		}
		System.out.println();
	}
	public void enrollStudent(String studentId) {
		if ((studentId.length() >= 1) && (currentStudents + 1 <= maxStudents)){
			System.out.println("Студяра с ID " + studentId + " --> зачислен");
			currentStudents ++;
		} else {
			System.out.println("Достигнуто максимальное количество студентов или неправильно введен ID");
		}
	}

	public void displayInfo() {
		System.out.println("=====Информация=====");
		System.out.println("Код курса: " + courseCode);
		System.out.println("Название курса: " + courseName);
		System.out.println("Кол-во зачисленных: " + currentStudents);
		System.out.println();
	}
	public void displayInfo(boolean showAvailability) {
		if (showAvailability) {
			System.out.println("=====Полная информация=====");
			System.out.println("Код курса: " + courseCode);
			System.out.println("Название курса: " + courseName);
			System.out.println("Максимальное кол-во студентов: " + maxStudents);
			System.out.println("Кол-во зачисленных: " + currentStudents);
			System.out.println("Активен: " + isActive);
			System.out.println();
		} else {
			this.displayInfo();
		}
		
	}
}