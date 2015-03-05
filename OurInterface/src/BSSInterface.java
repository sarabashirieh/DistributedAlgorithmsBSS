import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

public interface BSSInterface extends Remote{

	//dummy signature method to test the whole rmi
	//This is our process Interface
	public  int myId = 0;
	public  VClock vc = new VClock();
	public  Buffer buffer = new Buffer();
	public BSSClient client = new BSSClient();
	public HashMap<String, Integer> telefoonbook = new HashMap<String, Integer>();
	
	public int add (int num1, int num2) throws RemoteException;
	
	//Send a message
	public String sendMessage (int recipient, int sender, Message msg, VClock vm) throws RemoteException;
	
	
	//Receive a message
	public String receiveMessage (Message msg, VClock vm) throws RemoteException;
}
