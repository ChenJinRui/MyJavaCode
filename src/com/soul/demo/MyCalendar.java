package com.soul.demo;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MyCalendar {

	public static void main(String[] args) {

		doCalendar();

	}

	public static void doCalendar() {
		Locale.setDefault(Locale.CHINA);
		GregorianCalendar mCalendar = new GregorianCalendar();
//		mCalendar.set(2018, 3, 1);
		int month = mCalendar.get(Calendar.MONTH);
		// SUNDAY = 1 MONDAY = 2
		int weekday = mCalendar.get(Calendar.DAY_OF_WEEK);
		int today = mCalendar.get(Calendar.DAY_OF_MONTH);
		int year = mCalendar.get(Calendar.DAY_OF_YEAR);

		mCalendar.set(Calendar.DAY_OF_MONTH, 1);
		weekday = mCalendar.get(Calendar.DAY_OF_WEEK);
		// 星期几是第一天 eg:（一 二 三 四 五 六 日）、（日 一 二 三 四 五 六 ）
		int firstDayOfWeek = mCalendar.getFirstDayOfWeek();
		System.out.println("firstDayOfWeek" + firstDayOfWeek + "\tweekday"
				+ weekday);

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

		mCalendar.set(year, month, 1);
		weekday = mCalendar.get(Calendar.DAY_OF_WEEK);
		while (mCalendar.get(Calendar.MONTH) == month) {

			int day = mCalendar.get(Calendar.DAY_OF_MONTH);
			System.out.printf("%7d", day);
			if (day == today) {
				System.out.print("*");
			} else {
				System.out.print(" ");
			}
			if (weekday == firstDayOfWeek) {
				System.out.println();
			}
			mCalendar.add(Calendar.DAY_OF_MONTH, 1);
			weekday = mCalendar.get(Calendar.DAY_OF_WEEK);

		}
	}

}
