import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;


@SuppressWarnings("serial")
public class BSSImplementation extends UnicastRemoteObject implements BSSInterface{
	public  int myId;
	public  VClock vc = new VClock();
	public  Buffer buffer;
	//public contact`list
	//private BSSClient;
	public BSSClient client = new BSSClient();
	public HashMap<String, Integer> telefoonbook = new HashMap<String, Integer>();

	protected BSSImplementation(int myId, VClock vc, Buffer buffer, BSSClient client, HashMap<String, Integer> telefoonbook ) throws RemoteException {
		//super();
		// TODO Auto-generated constructor stub
		this.myId = myId;
		this.vc = vc;
		this.buffer = buffer;
		this.client = client;
		this.telefoonbook = telefoonbook;
	
	}

	@Override
	public int add(int arg0, int arg1) throws RemoteException {
		// TODO Auto-generated method stub
		return arg0+arg1;
	}
	
	public String sendMessage(int recipient, int sender, Message msg, VClock vm) throws RemoteException{
		
		System.out.println(receiveMessage(msg,vm));
		System.out.println("send message");
		return ("Messeage: "+ msg.showMessage());
		// sendmsg(recipient, msg);
		
	}
	
	//Receive a message
	//listening
	public String receiveMessage (Message msg, VClock vm) throws RemoteException{
		
		    // delay
		
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
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
			return "hello!";
	}
	
	public String deliverTheMsg(Message msg){
		return "This message is delivered"+msg.showMessage();
	}

	


}
