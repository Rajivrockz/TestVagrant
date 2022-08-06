package com.pushpamovie;

import java.text.ParseException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;
/**
 * 
 * @author V.Rajivranjan
 * @Description class Wiki to extends BaseClass
 * @Date 05.08.22
 *
 */
public class Wiki extends BaseClass{
public Wiki() {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//div[text()='Release date']//following::li[1]")
private WebElement releaseDate;
@FindBy(xpath="//th[text()='Country']//following::td[1]")
private WebElement country;

public WebElement getReleaseDate() {
	return releaseDate;
}
public WebElement getCountry() {
	return country;
}

/**
 * @Description getWikiRelDate method
 * @return
 * @throws ParseException
 */
public String getWikiRelDate() throws ParseException{
	String wikiDateText = getReleaseDate().getText();
	return wikiDateText;
}

/**
 * @Description getWikiCountryOrgin
 * @return
 */
public String getWikiCountryOrgin() {
	String orgin = getCountry().getText();
	return orgin;
}

}
