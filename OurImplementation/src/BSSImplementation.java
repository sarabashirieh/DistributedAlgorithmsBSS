import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


@SuppressWarnings("serial")
public class BSSImplementation extends UnicastRemoteObject implements BSSInterface{
	public int myId;
	public VClock vc = new VClock();

	protected BSSImplementation() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int add(int arg0, int arg1) throws RemoteException {
		// TODO Auto-generated method stub
		return arg0+arg1;
	}
	
	//Send a message(create a msg and send it)
	public void sendMessage (int recipient, String text) throws RemoteException{
		synchronized(vc){
			vc.increase(myId);
			Message msg = new Message(myId, recipient, vc, text);
			
		}
	}
	
	//Receive a message
	public void receiveMessage (Message msg) throws RemoteException{
		
	}

}
