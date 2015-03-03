import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

//Initialize the name and identifier for processes.

public class Initialize {
	public static void main (String args[]){
//		HashMap<String, Integer> hash = new HashMap<String, Integer>();
//		hash = phonebook();
//		if(hash.size()!=0){
//			for (String key : hash.keySet()){
//				System.out.println(key + " : "+ hash.get(key));
//			}
//		}
//		else{
//			System.out.println("Something is wrong with the readfile");
//		}
	}
	public HashMap<String, Integer> phonebook(){
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		
		try {
			File file = new File("Phonebook.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();

			Enumeration<Object> enuKeys = properties.keys();
			System.out.println("Phonebook");
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				int value = Integer.valueOf(properties.getProperty(key)); 
				hash.put(key, value);
				//System.out.println(hash.get(key));
				//System.out.println(key + " : " + value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(hash.size()!= 0){
			return hash;
		}
		return null;
		
	}
	
}
