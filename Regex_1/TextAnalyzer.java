import java.util.regex.*;

public class TextAnalyzer {
	public static void findEmails(String text) {
		System.out.println("Email-адреса: ");
		String shablon = "[\\w._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
		Pattern shablon_email = Pattern.compile(shablon);
		Matcher matcher = shablon_email.matcher(text);
		int count = 0;
		String[] words = text.split("\\s+");
        int count = 0;
        
		if (count == 0) {
            System.out.println("Не найдено");
        }
	}	
	public static void findDates(String text) {
		System.out.println("Даты: ");
		String shablon = "(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[0-2])\\.((19|20)[0-9]{2})";
		Pattern shablon_data = Pattern.compile(shablon);
		Matcher matcher = shablon_data.matcher(text);
		int count = 0;
		String[] words = text.split("\\s+");
        int count = 0;
        
        
		if (count == 0) {
            System.out.println("Не найдено");
        }
	}
	public static void findCapitalizedWords(String text) {
		System.out.println("Слова с заглавной буквы: ");
		String shablon = "[ ,.?!\"']*([А-ЯA-Z][а-яa-z\\-]*)";
		Pattern shablon_words = Pattern.compile(shablon);
		Matcher matcher = shablon_words.matcher(text);
		int count = 0; 
		String[] words = text.split("\\s+");
        int count = 0;
        boolean firstWord = true;        
        
		if (count == 0) {
            System.out.println("Не найдено");
        }
	}
	public static void countDigits(String text) {
		System.out.print("Общее количество цифр: ");
		int count = 0;
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (c >= '0' && c <= '9') {
				count++;
			}
		}
		if (count == 0) {
            System.out.println("Не найдено");
        }
		System.out.println(count);
	}
	public static void main(String[] args) {
		String text = """
			Компания "Рога и копыта" основана 15.03.2005.
			Контакты: director@roga.ru, support@roga-kopita.com.
			Бюджет проекта: 1500000 рублей. Штаб-квартира в Москве.
		""";
		System.out.println();
		findEmails(text);
		findDates(text);
		findCapitalizedWords(text);
		countDigits(text);
	}
}