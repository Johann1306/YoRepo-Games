package tests.date;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class TestFormaterDate2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date aujourdhui = new Date();

		DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);

		DateFormat mediumDateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);

		DateFormat longDateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);

		DateFormat fullDateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT, Locale.FRANCE);

		System.out.println(shortDateFormat.format(aujourdhui));
		System.out.println(mediumDateFormat.format(aujourdhui));
		System.out.println(longDateFormat.format(aujourdhui));
		System.out.println(fullDateFormat.format(aujourdhui));
	}

}