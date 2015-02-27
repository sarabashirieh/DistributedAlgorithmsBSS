import java.rmi.RemoteException;


public class Process implements BSSInterface {
	VClock p1Clock = new VClock();
	Buffer b1 = new Buffer();
	int id;
	
	
	
	@Override
	public int add(int arg0, int arg1) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void receiveMessage(Message arg0, VClock arg1)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String sendMessage(int arg0, int arg1, Message arg2, VClock arg3)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
