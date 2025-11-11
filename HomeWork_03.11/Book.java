public class Book {

	private String title;
	private String author;
	private int year;
	private boolean isAvailable;
	private int pageCount;

	public Book() {
		this("Величайшие математические задачи", "Иэн Стюарт", 2017, true, 460);
	}
 
	public Book(boolean isAvailable, int pageCount) {
		this("Величайшие математические задачи","Иэн Стюарт", 2017, isAvailable, pageCount);
	}

	public Book(String title, String author, int year, boolean isAvailable, int pageCount) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.isAvailable = isAvailable;
		this.pageCount = pageCount;
	}

	public void displayInfo() {
		System.out.println("Title: " + title + "\n" + "Author: " + author + "\n" + "Year: " + year + "\n" + "Available: " + isAvailable + "\n" + "Page: " + pageCount);
	}

	public void borrowBook() {
		this.isAvailable = false;
		System.out.println("Книга выдана. Наличие: " + isAvailable);
	}

	public void returnBook() {
		this.isAvailable = true;
		System.out.println("Книга возвращена. Наличие: " + isAvailable);
	}

	public void updateYear(int newYear) {
		int oldYear = year;
		this.year = newYear;
		System.out.println("Год издания изменен с " + oldYear + " на " + year);
	}
}