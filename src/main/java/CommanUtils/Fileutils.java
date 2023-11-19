/**
 * 
 */
package CommanUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 */
public class Fileutils {

	/**
	 * @param args
	 * @return 
	 * @throws IOException 
	 */
	
		// TODO Auto-generated method stub
        public String getDataFromPropertyFile(String key) throws IOException {
        	FileInputStream fis = new FileInputStream("src\\test\\resources\\vtigero2.properties..txt");
        	Properties p = new Properties();
    		p.load(fis);
    		String value = p.getProperty(key);
    		return value; 
    		
        }
	

}
