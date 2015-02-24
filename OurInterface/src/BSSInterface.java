import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BSSInterface extends Remote{

	//dummy signature method to test the whole rmi
	//This is our process Interface
	
	public int add (int num1, int num2) throws RemoteException;
	
	//Send a message
	public String sendMessage (int recipient, int sender, Message msg, VClock vm) throws RemoteException;
	
	
	//Receive a message
	public void receiveMessage (Message msg) throws RemoteException;
}
