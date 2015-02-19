import java.util.ArrayList;


public class Buffer {
	private static ArrayList<Message> buffer = new ArrayList<Message>();
	
	public Buffer(){
		buffer = new ArrayList<Message>();
	}
	public void add(Message msg){
		buffer.add(msg);
	}
	public void remove(Message msg){
		if(buffer.contains(msg)){
			buffer.remove(buffer.indexOf(msg));
		}
	}
	public Message get(int i){
		return buffer.get(i);
	}
	public int size(){
		return buffer.size();
	}
	public static void main (String args[]){
		System.out.println("hello"+buffer);
		
	}
}
