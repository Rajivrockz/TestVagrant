package com.pushpamovie;

import java.text.ParseException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;
/**
 * 
 * @author V.Rajivranjan
 * @Description class Imdb to extends BaseClass
 * @Date 05.08.22
 *
 */
public class Imdb extends BaseClass{
public Imdb() {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//a[text()='Release date']//following::li[1]")
private WebElement ReleaseDate;

@FindBy(xpath="//span[text()='Country of origin']//following::a[1]")
private WebElement coorgin;

public WebElement getReleaseDate() {
	return ReleaseDate;
}
public WebElement getCoorgin() {
	return coorgin;
}

/**
 * @Description getReldate() method
 * @return
 * @throws ParseException
 */
public String getReldate() throws ParseException{
String imdbdatetext = getReleaseDate().getText().substring(0, 15);

return imdbdatetext;
}

/**
 * @Description getcountryorgin method
 * @return
 */

public String getcountryorgin() {
	String orgin = getCoorgin().getText();
	return orgin;
}

}
