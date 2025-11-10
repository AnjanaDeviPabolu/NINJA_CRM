package ninjaCRM;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingDatafrom_PropertiesFile {

	public static void main(String[] args) throws IOException {
		
		//FileInputStream miss=new FileInputStream("C:\\Users\\pabol\\eclipse-workspace\\AdvancedSelenium\\src\\test\\resources\\NinjaData.properties");
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Ninjadata.properties");
		
		Properties prop=new Properties();
		
		prop.load(fis);

		String BROWSER = prop.getProperty("Browser");
		
		String URL = prop.getProperty("URl");
		
		String USERNAME = prop.getProperty("username");
		
		String PASSWORD = prop.getProperty("password");
		
		System.out.println(BROWSER);
		
		System.out.println(URL);
		
		System.out.println(USERNAME);
		
		System.out.println(PASSWORD);
	}

}
