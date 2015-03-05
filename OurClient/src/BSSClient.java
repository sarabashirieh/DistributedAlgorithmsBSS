import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

//call method in interface similar to server except here we calling the methods
public class BSSClient {

	public static void main (String[] args){
		try{
			//Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1",1099);
			/*Registry myRegistry = LocateRegistry.getRegistry(2004);
			//here we need to use interface
			BSSInterface myInterface = (BSSInterface) myRegistry.lookup("Process1");
			//p ready for receiving.
			//BSSInterface stub= (BSSInterface) UnicastRemoteObject.exportObject((Remote) p, 0);
			System.out.println("client");
			//p.id = (int)Math.random();
			System.out.println("1+1 = " + myInterface.add(1, 1));*/
			//first get the name and Id's of the processes. 
			
			//BSSInterface myInterface = locateReg("Process1");
			//System.out.println("1+1 = " + myInterface.add(1, 1));
			broadcast(); 
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static BSSInterface locateReg(String processName){
		try{
			Registry myRegistry = LocateRegistry.getRegistry(2004);
			BSSInterface myInterface = (BSSInterface) myRegistry.lookup(processName);
			return myInterface;
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		
	}
	//simple test
	public static void broadcast() throws RemoteException{
		/*BSSInterface Process1 = locateReg("Process1");
		BSSInterface Process2 = locateReg("Process2");
		BSSInterface Process3 = locateReg("Process3");
		//System.out.println(Process3.add(2, 3));
		VClock vc = new VClock();
		Buffer b = new Buffer();
		vc.intializeLocalClock();
		Message msg = new Message(1, 3, vc, "BC msg");
		System.out.println(Process3.sendMessage(3, 1, msg, vc));*/
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
			}
			for(String key : hash.keySet()){
				
				BSSInterface Process = locateReg(key);
				VClock vc = new VClock();
				Buffer b = new Buffer();
				vc.intializeLocalClock();
				int temp = 1;
				for(int i = 0; i<hash.size(); i++){
					
				Message msg = new Message(hash.get(key), temp, vc, "BC msg");
				System.out.println(Process.sendMessage(hash.get(key), temp, msg, vc));
				//Process.sendMessage(hash.get(key), temp, msg, vc);
				temp++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
