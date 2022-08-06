package com.baseclass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author V.Rajivranjan
 * @Description class BaseClass
 * @Date 05.08.22
 *
 */
public class BaseClass {
	/**
	 * @Description to static 
	 */
	public static WebDriver driver;
	/**
	 * @Description launchDriver method
	 */
	public void launchDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	/**
	 * @Description maximize method
	 */
	public void maximize() {
		driver.manage().window().maximize();
	}
	public  void getUrl(String url) {
		driver.get(url);
	}
	
	/**
	 * @Description getDateFormat method
	 * @param pushpadate
	 * @return
	 */
	public LocalDate getDateFormat(String pushpadate) {
		LocalDate date = LocalDate.parse(pushpadate, DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH));
		return date;
	}
	/**
	 * @Description getWikiDateFormat
	 * @param wikiDateText
	 * @return
	 */
	public LocalDate getWikiDateFormat(String wikiDateText) {
		LocalDate date = LocalDate.parse(wikiDateText, DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ENGLISH));
		return date;
	}
}
