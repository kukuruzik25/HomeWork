public class Main {
	public static void main(String[] args) {

		Student student1 = new Student();
		Student student2 = new Student("Leo","Leksusovich","11-504");
		Student student3 = new Student("Leo","Leksusovich",6,"11-000",25.0,false);

		String result = student1.displayInfo();
		System.out.println(result);
		String deactiv = student1.deactivateStudent();
		System.out.println(deactiv);
		System.out.println();

		String activ = student3.activateStudent();
		System.out.println(activ);
		String update = student3.updateGrade(100.0);
		System.out.println(update);
		String trans = student3.transferToNewGroup("11-504");
		System.out.println(trans);
		System.out.println();

		String rezult1 = student3.displayInfo();
		System.out.println(rezult1);
	}
}