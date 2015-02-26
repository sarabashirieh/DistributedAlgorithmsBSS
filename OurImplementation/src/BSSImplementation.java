import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


@SuppressWarnings("serial")
public class BSSImplementation extends UnicastRemoteObject implements BSSInterface{
	public  int myId;
	public  VClock vc = new VClock();
	public  Buffer buffer;

	protected BSSImplementation(int myId, VClock vc, Buffer buffer) throws RemoteException {
		//super();
		// TODO Auto-generated constructor stub
		this.myId = myId;
		this.vc = vc;
		this.buffer = buffer;
	
	}

	@Override
	public int add(int arg0, int arg1) throws RemoteException {
		// TODO Auto-generated method stub
		return arg0+arg1;
	}
	
	public String sendMessage(int recipient, int sender, Message msg, VClock vm) throws RemoteException{
		
		return "Messeage: "+ msg.showMessage();
	}
	
	//Receive a message
	public void receiveMessage (Message msg, VClock vm) throws RemoteException{
		
			//condition for D_j(m) of lecture notes
			vm.increase(1);
			//increase of localvc should be greater equal than vectorclock from the message
			System.out.println("vc.get(1)"+vm.get(1));
			System.out.println("msg.time.get(msg.senderId)"+ msg.time.get(1));
			Boolean condition = ( vm.get(1) >= msg.time.get(msg.senderId));
			if (condition){
				System.out.println(deliverTheMsg(msg));
				//now check the buffer for more msg which satisfy the condition
				for(int i=0;i<buffer.size();i++ ){
					Message thisMsg = buffer.get(i);
					vc.increase(thisMsg.senderId);
					//if increase of the local vc is greater equal than the vector clock of the sender
					if( vc.get(thisMsg.receiverId) >= thisMsg.time.get(thisMsg.senderId) ){
						deliverTheMsg(thisMsg);
						buffer.remove(thisMsg);
					}
				}
			}
			else{
				buffer.add(msg);
				System.out.println("Message added to buffer");
			}
		
	}
	
	public String deliverTheMsg(Message msg){
		return "This message is delivered"+msg.showMessage();
	}

	


}
