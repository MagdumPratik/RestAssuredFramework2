package api.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pr;
	String path="C:\\Users\\admin\\Downloads\\eclipse-jee-photon-R-win32-x86_64\\eclipse\\RestApi\\RestAssuredAutomationFramework\\src\\test\\resources\\Routes.properties";
	
	public ReadConfig()
	{
		try {
			FileInputStream fi=new FileInputStream(path);
			pr=new Properties();
			pr.load(fi);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public String createLink()
	{
		String crlnk=pr.getProperty("post_url");
		return crlnk;
	}
	
	public String getDataLink()
	{
		String getData=pr.getProperty("get_url");
		return getData;
	}
	public String updateDataLink()
	{
		String updateData=pr.getProperty("update_url");
		return updateData;
	}
	public String deleteDataLink()
	{
		String deleteData=pr.getProperty("delete_url");
		return deleteData;
	}
}
