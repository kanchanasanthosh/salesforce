package sfUtility;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;

public class PropUtility {
	
	private FileInputStream stream=null ;
    private  Properties propertyFile=null;
	//private Properties propertyFile=new Properties();
	public  Properties loadFile() {
		
		propertyFile = new Properties();
		String PropertyFilePath =null;
		PropertyFilePath =SfConstants.SF_DATA_PROPERTIES;
		
		try {
			  stream = new FileInputStream(PropertyFilePath);
			propertyFile.load(stream);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return propertyFile;
		
	}
	
	public  String getPropertyValue(String key) throws IOException {
		
		String value  = propertyFile.getProperty(key);
	System.out.println("property from the file::"+ value);
	try{
		stream.close();
		
	}
	catch (IOException e) {
		e.printStackTrace();
	}
	
	return value;
}



	

}
