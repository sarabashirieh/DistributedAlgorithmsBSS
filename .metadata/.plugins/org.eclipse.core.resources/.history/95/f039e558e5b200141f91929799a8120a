import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class BSSServer {

	public static void main (String[] args){
		try{
			Registry serverRegistry = LocateRegistry.createRegistry(1099);
			//we need our implementation
			BSSImplementation imp = new BSSImplementation();
			serverRegistry.rebind("BSS", imp);
			System.out.println("Server is ready");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
