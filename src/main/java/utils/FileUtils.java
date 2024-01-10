package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import constants.FileConstants;

public class FileUtils {
	
	public static String readLoginTestData(String key) throws IOException {
		FileInputStream f = new FileInputStream(FileConstants.LOGIN_TESTDATA_FILE_PATH);
		Properties p  = new Properties();
		p.load(f);
		return p.getProperty(key);
		
		
		
	}
	
	public static String readUserMenuTestData(String key) throws IOException {
		FileInputStream f = new FileInputStream(FileConstants.USERMENU_TESTDATA_FILE_PATH);
		Properties p  = new Properties();
		p.load(f);
		return p.getProperty(key);
		
		
		
	}
	
	
}
