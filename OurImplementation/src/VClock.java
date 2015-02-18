import java.util.HashMap;


public class VClock {
	//I chose for hashmap because It does not sort and we can use it's key,value property.
	private static HashMap<Integer, Integer> vc = new HashMap<Integer,Integer>() ;
	
	public VClock(){
		//id of process, time
	vc = new HashMap<Integer,Integer>();	
	}
	
	synchronized public void startClock(){
		//start clock synchronized
		vc = new HashMap<Integer,Integer>();
		vc.put(0, 0);
		System.out.println("A new vector clock is initialized.");
	}
	synchronized public void increase(int processIndex){
		//value of the current process index
		int currentValue = vc.get(processIndex);
		vc.put(processIndex, currentValue+1);
	}
	synchronized public void decrease(int processIndex){
		//we need this because sometimes the send message won't work so we need to decrease the clock
		int currentValue = vc.get(processIndex);
		vc.put(processIndex, currentValue-1);
	}
	synchronized public int get(int processIndex){
		if(vc.get(processIndex)!= null){
			return vc.get(processIndex);
		}
		//does not exists. 
		else return -1;
	}
	synchronized public void set(){
		
	}
	public static void main(String args[]){
		VClock c  = new VClock(); 
		c.startClock();
		System.out.println("hii"+c.get(0));
	}
	
}
