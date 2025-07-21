import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileManagement {
	Properties testDataProperties;
	FileInputStream inputStream;
	
	public FileManagement() {
		try {
			inputStream = new FileInputStream("data/testdata.properties");
			testDataProperties.load(inputStream);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getProperty(String strProperty) {
		return testDataProperties.getProperty(strProperty);
	}

}
