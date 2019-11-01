package HoraDoSistema;
import java.util.Locale;

public class IdiomaDoSistema {
	public static void main(String[] args) {
		Locale currentLocale = Locale.getDefault();
		currentLocale.getDisplayLanguage();
		System.out.println(currentLocale.getDisplayLanguage());
	}
}
