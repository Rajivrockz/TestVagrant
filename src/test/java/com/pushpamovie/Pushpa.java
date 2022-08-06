package com.pushpamovie;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;

/**
 * 
 * @author V.Rajivranjan
 * @Date 05.08.22
 * @Description: Class name Pushpa to launch browser
 *
 */

public class Pushpa extends BaseClass{
	LocalDate imdbdateFormat;
	LocalDate wikiDateFormat;
	String imdbcountryorgin;
	String wikiCountryOrgin;


	@BeforeClass
	private void beforeclass() {
		launchDriver();
		maximize();
	}
	/**
	 * @Decription laucImdb method 
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(priority=1)
	private void launchImdb() throws InterruptedException, ParseException {
		getUrl("https://www.imdb.com/title/tt9389998/");
		Imdb imdb = new Imdb();
		String imdbpushpadate = imdb.getReldate();
		imdbdateFormat = getDateFormat(imdbpushpadate);
		imdbcountryorgin = imdb.getcountryorgin();		
	}	
	/**
	 * @Description launchWiki method
	 * @throws ParseException
	 */
	@Test(priority=2)
	private void launchWiki() throws ParseException {
		getUrl("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");	
		Wiki wiki = new Wiki();
		String wikiRelDate = wiki.getWikiRelDate();
		wikiDateFormat = getWikiDateFormat(wikiRelDate);
		wikiCountryOrgin = wiki.getWikiCountryOrgin();
	}
	/**
	 * @Description validating imdb and wiki data 
	 * 
	 */
	@Test(priority=3)
	private void validation() {
		Assert.assertEquals(imdbcountryorgin, wikiCountryOrgin, "Verify the country orgin is Same");
		Assert.assertEquals(imdbdateFormat, wikiDateFormat, "Verify the Date is Same");	
	}
	

}
