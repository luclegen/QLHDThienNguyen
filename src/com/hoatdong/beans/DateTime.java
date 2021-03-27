package com.hoatdong.beans;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateTime
 *
 * Version 1.0
 *
 * Date: 15-06-2018
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          	DESCRIPTION
 * -----------------------------------------------------------------------
 * 15-06-2018           Huynh Tan Luc   	Create
 */
public class DateTime {
	
	private int year;
	private int month;
	private int day;
	
	private int hour;
	private int minute;
	private int second;
	
	/**
	 * The DateTime constructor
	 */
	public DateTime() {}
	
	/**
	 * The DateTime constructor
	 * @param dateTimeStr
	 * @throws ParseException 
	 */
	@SuppressWarnings("deprecation")
	public DateTime(String dateTimeStr) throws ParseException {
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date d = ft.parse(dateTimeStr);
		
		year = d.getYear() + 1900;
		month = d.getMonth() + 1;
		day = d.getDate();
		
		hour = d.getHours();
		minute = d.getMinutes();
		second = 0;
	}

	/**
	 * The DateTime constructor
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 * @param second
	 */
	public DateTime(int year, int month, int day, int hour, int minute, int second) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	/**
	 * The setDateTime method use to setting date and time for object 
	 * @param dateTimeStr
	 * @throws ParseException
	 */
	@SuppressWarnings("deprecation")
	public void setDateTime(String dateTimeStr) throws ParseException {
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		Date d = ft.parse(dateTimeStr);
		
		year = d.getYear() + 1900;
		month = d.getMonth() + 1;
		day = d.getDate();
		
		hour = d.getHours();
		minute = d.getMinutes();
		second = d.getSeconds();
	}

	/**
	 * The getYear getter method of year field
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * The setYear setter method of year field
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * The getMonth getter method of month field
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * The setMonth setter method of month field
	 * @param month
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * The getDay getter method of day field
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * The setDay setter method of day field
	 * @param day
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * The getHour getter method of hour field
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * The setHour setter method of hour field
	 * @param hour
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}

	/**
	 * The getMinute getter method of minute field
	 * @return the minute
	 */
	public int getMinute() {
		return minute;
	}

	/**
	 * The setMinute setter method of minute field
	 * @param minute
	 */
	public void setMinute(int minute) {
		this.minute = minute;
	}

	/**
	 * The getSecond getter method of second field
	 * @return the second
	 */
	public int getSecond() {
		return second;
	}

	/**
	 * The setSecond setter method of second field
	 * @param second
	 */
	public void setSecond(int second) {
		this.second = second;
	}
	
	/**
	 * The getDateTime method return to DateTime
	 * @return
	 */
	public String getDateTime() {
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		@SuppressWarnings("deprecation")
		Date date = new Date(year - 1900, month - 1, day, hour, minute, second);
		String dateFormated = df.format(date);
		return dateFormated;
	}
	
	public String getDateTimeRequest() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		@SuppressWarnings("deprecation")
		Date date = new Date(year - 1900, month - 1, day, hour, minute, second);
		String dateFormated = df.format(date);
		return dateFormated;
	}
	
	/**
	 * The toString overriding method of DateTime class
	 */
	@Override
	public String toString() {
		return year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
	}
	
}
