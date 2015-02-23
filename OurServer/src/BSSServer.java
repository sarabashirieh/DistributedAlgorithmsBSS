import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class BSSServer {

	public static void main (String[] args){

		try{
			
			Registry serverRegistry = LocateRegistry.createRegistry(2005);
			//we need our implementation
			BSSImplementation imp = new BSSImplementation();
			serverRegistry.rebind("Process1", imp);
			serverRegistry.rebind("Process2", imp);
			serverRegistry.rebind("Process3", imp);
			//I'm looking for Proccess1 and I'm going to send to him
			BSSInterface p1Interface = (BSSInterface) serverRegistry.lookup("Process1");
			System.out.println("1+1 " + p1Interface.add(1, 1));
			 
			 //Result of process1 saved to send to Process2
			 int temp = p1Interface.add(1, 1);
			//I'm looking for Proccess2 and I'm going to send to him
			 BSSInterface p2Interface = (BSSInterface) serverRegistry.lookup("Process2");
			 System.out.println("temp + temp = " + p2Interface.add(temp, temp));
			 BSSInterface p3Interface = (BSSInterface) serverRegistry.lookup("Process3");
			 
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
