package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class MainApp {

	private static final String ALPHANUMERIC = "^\\d{2}$";

	public static void main(String[] args) {
		/*
		 * Date date = new Date();
		 * System.out.println(date);
		 * Date date2 = new Date(1992, 12, 22);
		 * System.out.println(date.before(date2));
		 */
		// MainApp.getTargetNextMonth();
		String TAB="\t";
		String line = "\t\t\t\t\t\t";
		
		String aaaa= "abcdeabcdeabcde";
		
		String[] arrayLine = line.split(TAB, -1);
		String[] arrayLine2 = aaaa.split("a");
		for(String a: arrayLine) {
			System.out.println(a);
		}


	}
	
	private static void numberFormat() {
		System.out.println(String.format("%07d",  1));
	}

	private static void isValid(String str) {

		Pattern ptn = Pattern.compile(ALPHANUMERIC);
		boolean result = ptn.matcher(str).find();

		System.out.println(result);
	}

	private static Date getLastDayOfMonth(int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, month);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		SimpleDateFormat dt = new SimpleDateFormat("yyyyy/mm/dd"); 
		System.out.println(dt.format(calendar.getTime()));
		return null;
	}

	public void separator() {
		System.out.println("1file.separator -> " + System.getProperty("file.separator"));
		System.out.println("2java.class.path -> " + System.getProperty("java.class.path"));
		System.out.println("3java.home -> " + System.getProperty("java.home"));
		System.out.println("4java.vendor -> " + System.getProperty("java.vendor"));
		System.out.println("5java.vendor.url -> " + System.getProperty("java.vendor.url"));
		System.out.println("6java.version -> " + System.getProperty("java.version"));
		System.out.println("7os.arch -> " + System.getProperty("os.arch"));
		System.out.println("8os.name -> " + System.getProperty("os.name"));
		System.out.println("9os.version -> " + System.getProperty("os.version"));
		System.out.println("10path.separator -> " + System.getProperty("path.separator"));
		System.out.println("11user.dir -> " + System.getProperty("user.dir"));
		System.out.println("12user.home -> " + System.getProperty("user.home"));
		System.out.println("13line.separator -> " + System.getProperty("line.separator"));
		System.out.println("14user.name -> " + System.getProperty("user.name"));
	}

	public static void dateTest() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");

		try {
			System.out.println(formatter.parse(formatter.format(date)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(formatter.format(date));

	}

	public static void getTargetNextMonth() {
		int year = 2014;
		int month = 11;

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);
		calendar.add(Calendar.MONTH, 1);

		System.out.println(calendar.get(Calendar.YEAR) + "" + calendar.get(Calendar.MONTH) + 1);

	}

	public static void getEndOfNextMonth(int year, int month) {

		month -= 1;

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);

		calendar.add(Calendar.MONTH, 2);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DATE, -1);

		SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd"); 
		System.out.println(calendar.getTime());
		System.out.println(dt.format(calendar.getTime()));
	}

}
