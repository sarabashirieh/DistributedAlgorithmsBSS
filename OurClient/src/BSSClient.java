import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

//call method in interface similar to server except here we calling the methods
public class BSSClient {
	
	public static void main (String[] args){
		try{
			//Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1",1099);
			Registry myRegistry = LocateRegistry.getRegistry(2004);
			//here we need to use interface
			BSSInterface myInterface = (BSSInterface) myRegistry.lookup("BSS");
			System.out.println("1+1 = " + myInterface.add(1, 1));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
