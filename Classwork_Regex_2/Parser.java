import java.util.regex.*;

public class Parser {
	public static void main(String args[]) {
		passage();
		analiz_text();
		html();
		csv();
		hash(); 
    }
    public static void passage() {
    	String text = "Она сказала: \"Привет!\", а он ответил: \"Как дела?\", потом: \"Отлично!\"";
		System.out.println("Цитата: ");
    	String shablon = "\".*\"";
    	Pattern shablon_passage = Pattern.compile(shablon);
    	Matcher m = shablon_passage.matcher(text);
    	while (m.find()) {
    		System.out.println(m.group());
    	}
    	System.out.println();
    }
    public static void analiz_text() {
    	String logs = """
                [ERROR] 2024-01-15: Connection failed
                [INFO] 2024-01-15: User logged in
                [DEBUG] 2024-01-15: Processing request
                [ERROR] 2024-01-15: Database timeout
                """;
        String shablon = "\\[ERROR\\]\\s(\\d{4}-\\d{2}-\\d{2}):\\s(.+)";
    	Pattern shablon_analiz_text = Pattern.compile(shablon);
    	Matcher m = shablon_analiz_text.matcher(logs);
    	System.out.println("[ERROR]: ");
    	while (m.find()) {
    		System.out.println(m.group(1) + " " + m.group(2));
    	}	
    	System.out.println();
    }
    public static void html() {
    	String html = """
			<div class="product">
				<h3>Телефон</h3>
				<p>Цена: 20000 руб</p>
			</div>
			<div class="product">
				<h3>Ноутбук</h3>
				<p>Цена: 50000 руб</p>
			</div>
		""";
		System.out.println("Товары: ");
	    String shablon = "<h3>.*?</h3>";
	    Pattern shablon_html = Pattern.compile(shablon);
	    Matcher m = shablon_html.matcher(html);
	    while (m.find()) {
	    	System.out.println(m.group());
	    }	
	    System.out.println();	
    }
    public static void csv() {
    	String csv = "Вика,18,Альметьевск;Анна,24,Казань;Аскар,6,Бугульма";
	    System.out.println("Данные: ");
	    String shablon = "[^;]+";
	    Pattern shablon_csv = Pattern.compile(shablon);
	    Matcher m = shablon_csv.matcher(csv);
	    while (m.find()) {
	    	System.out.println(m.group() + " ");
	    }
	    System.out.println();
    }
    public static void hash() {
    	String hash = "Сегодня был в #парке и #кино #отдых #выходные";
    	System.out.println("Хэштеги: ");
    	String shablon = "#[^\s#].*?\s";
    	Pattern shablon_hash = Pattern.compile(shablon);
    	Matcher m = shablon_hash.matcher(hash);
    	while (m.find()) {
    		System.out.println(m.group());
    	}
    }
}	 