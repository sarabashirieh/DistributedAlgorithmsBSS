import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


@SuppressWarnings("serial")
public class BSSImplementation extends UnicastRemoteObject implements BSSInterface{

	

	protected BSSImplementation() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int add(int arg0, int arg1) throws RemoteException {
		// TODO Auto-generated method stub
		return arg0+arg1;
	}
	
	//Send a message
	public void sendMessage (int recipient, String msg) throws RemoteException{
		
	}
	
	//Receive a message
	public void receiveMessage (Message msg) throws RemoteException{
		
	}

}
