import java.util.regex.*;

public class Probn {
	public static void main(String[] args) {
		String str = "1241843680e vh";
		System.out.println(str.matches("\\d+"));
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(str);
		if (m.find()) {
			System.out.println(m.group());
		}
		
	}
}
