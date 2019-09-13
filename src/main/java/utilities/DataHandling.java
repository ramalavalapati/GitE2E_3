package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataHandling {
	
	static Properties configProp = new Properties();
	InputStream input = null;
	
	public DataHandling() {
		
		try {
			input = new FileInputStream("Initilization.properties");
			configProp.load(input);
			} catch (IOException ex) {
				ex.printStackTrace();
			}finally {
				if(input !=null) {
					try {
						input.close();
						} catch (IOException ex) {
							ex.printStackTrace();
						}
				}
			}
		}
	
	public String getProperty(String data) {
		return configProp.getProperty(data);
	}

}
