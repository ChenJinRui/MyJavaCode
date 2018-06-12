package com.soul.demo;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MyCalendar {
	
	/*
	 * 静态的初始块
	 * 首先运行初始化块，然后才运行构造器的主体部分
	 * 即使没有main方法也可以执行
	 * （当用java MyCalendar调用这个类时，这个类就被加载，静态初始化块将会打印“Hello, World”。
	 * 在此之后，会得到一个“main is not defined（没有定义）”的错误信息。不过，可以在静态
	 * 初始化块的尾部调用System.exit(0)避免这一缺陷。）
	 */
	static {
		System.out.println("wahhh");
	}

	public static void main(String[] args) {

		doCalendar(2018, 4);

	}

	public static void doCalendar(int iYear, int iMonth) {
		System.out.println(new Date().getTime());
		System.out.printf("%d年%d月\n", iYear, iMonth + 1);
		Locale.setDefault(Locale.CHINA);
		GregorianCalendar mCalendar = new GregorianCalendar();
		int thisMonth = mCalendar.get(Calendar.MONTH);
		int today = mCalendar.get(Calendar.DAY_OF_MONTH);
		int year = mCalendar.get(Calendar.DAY_OF_YEAR);

		mCalendar.set(iYear, iMonth, 1);
		int month = mCalendar.get(Calendar.MONTH);
		// SUNDAY = 1 MONDAY = 2
		int weekday = mCalendar.get(Calendar.DAY_OF_WEEK);

		
		mCalendar.set(Calendar.DAY_OF_MONTH, 1);
		weekday = mCalendar.get(Calendar.DAY_OF_WEEK);
		// 星期几是第一天 eg:（一 二 三 四 五 六 日）、（日 一 二 三 四 五 六 ）
		int firstDayOfWeek = mCalendar.getFirstDayOfWeek();

		int indent = 0;// 获取日历第一天要偏移的位置
		while (weekday != firstDayOfWeek) {
			indent++;
			// add 负值 n 当前设置的时间往过去 n 天 正值 往未来移 n天
			mCalendar.add(Calendar.DAY_OF_MONTH, -1);
			weekday = mCalendar.get(Calendar.DAY_OF_WEEK);
		}
		// 中文的Weekday名称简称和全名一样
		String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
		// String [] weekdayNames = {"","日","一","二","三","四","五","六"};
		// System.out.println(Arrays.toString(weekdayNames));
		do {
			System.out.printf("%8s", weekdayNames[weekday]);
			mCalendar.add(Calendar.DAY_OF_MONTH, 1);
			weekday = mCalendar.get(Calendar.DAY_OF_WEEK);
		} while (weekday != firstDayOfWeek);
		System.out.println();
		while (indent != 0) {
			indent--;
			System.out.printf("%8s", "");

		}

		mCalendar.set(Calendar.DAY_OF_MONTH, 1);
		weekday = mCalendar.get(Calendar.DAY_OF_WEEK);

		boolean isThis = (thisMonth == iMonth) && (year == iYear);
		while (mCalendar.get(Calendar.MONTH) == month) {

			int day = mCalendar.get(Calendar.DAY_OF_MONTH);
			System.out.printf("%7d", day);
			if (isThis && day == today) {
				System.out.print("*");
			} else {
				System.out.print(" ");
			}
			mCalendar.add(Calendar.DAY_OF_MONTH, 1);
			weekday = mCalendar.get(Calendar.DAY_OF_WEEK);
			if (weekday == firstDayOfWeek) {
				System.out.println();
			}
		}
	}

}
