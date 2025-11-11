public class MainBook {
	public static void main(String[] args) {
		Book my_book1 = new Book();
		Book my_book2 = new Book(true, 120);
		Book my_book3 = new Book("Чапитосик", "Фуфик Фуфикович", 2015, true, 500);

		my_book1.displayInfo();
		System.out.println();
		my_book2.displayInfo();
		System.out.println();
		my_book3.displayInfo();
		System.out.println();

		my_book3.borrowBook();
		my_book3.updateYear(2025);
		my_book3.returnBook();
	}
}		