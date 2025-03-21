package com.qaautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigData {

	public Properties pro;

	public ReadConfigData() throws IOException 
	{
		File file=new File("./Configuration/config.properties");
		FileInputStream fi=new FileInputStream(file);
		pro=new Properties();
		pro.load(fi);
	}
	
	public String getBrowserName() {
		String browsername= pro.getProperty("browser");
		return browsername;
	}
	
	public String getUrl() {
		String url=pro.getProperty("url");
		return url;
	}
}
