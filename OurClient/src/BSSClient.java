import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

//call method in interface similar to server except here we calling the methods
public class BSSClient {
	public static Process p;
	public static void main (String[] args){
		try{
			//Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1",1099);
			Registry myRegistry = LocateRegistry.getRegistry(2004);
			//here we need to use interface
			BSSInterface myInterface = (BSSInterface) myRegistry.lookup("BSS");
			//p ready for receiving.
			BSSInterface stub= (BSSInterface) UnicastRemoteObject.exportObject((Remote) p, 0);
			
			p.id = (int)Math.random();
			System.out.println("1+1 = " + myInterface.add(1, 1));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
