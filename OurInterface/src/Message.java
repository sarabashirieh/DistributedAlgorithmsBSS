//The message needs to have a senderId, receiverId, VectorClock and text. 
public class Message {
	
	public int senderId;
	public int receiverId;
	public VClock time;
	public String text;
	//create a message
	public Message (int senderId, int receiverId, VClock time, String text){
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.time = time;
		this.text = text;
	}
	public String showMessage(){
		String message = "Content of the message:"+text+"Vclock:"+time+"senderId:"+senderId+"receiverId:"+receiverId;
		return message;
	}
}
