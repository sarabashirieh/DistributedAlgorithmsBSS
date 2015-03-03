//The message needs to have a senderId, receiverId, VectorClock and text. 
public class Message implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int senderId;
	public int receiverId;
	public VClock time;
	public String text;
	//create a message
	public Message (int senderId, int receiverId, VClock time, String msg){
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.time = time;
		this.text = msg;
	}
	public String showMessage(){
		String message = "Content of the message: "+text+", vm: "+time.showClock()+", senderId: "+senderId+" ,receiverId:"+receiverId;
		return message;
	}
}
