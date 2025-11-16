public class MainDepartment {
	public static void main(String[] args) {
		Department department_1 = new Department();
		Department department_2 = new Department("Отечественная история и архивоведение", "Литвин Александр Алтерович", "2065236");
		Department department_3 = new Department("Программная инженерия", "Голицына Ирина Николаевна", "1401", "itis@kpfu.ru", "78432065233", 10000000);

		department_2.contact();
		department_3.contact("Поставьте 100 баллов по матану пожалуйста");
		department_1.allocateBudget(1000000.0);
		department_3.allocateBudget(5000000.0, "закупка макбуков");

		System.out.println("Общее кол-во кафедр: " + Department.getTotalDepartments());
	}
}