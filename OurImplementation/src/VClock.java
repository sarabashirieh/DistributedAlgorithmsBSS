import java.util.HashMap;


public class VClock {
	//I chose for hashmap because It does not sort and we can use it's key,value property.
	public static HashMap<Integer, Integer> vc = new HashMap<Integer,Integer>() ;
	
	public VClock(){
		//id of process, time
	vc = new HashMap<Integer,Integer>();	
	}
	
	 public void startClock(){
		//start clock synchronized
		vc = new HashMap<Integer,Integer>();
		vc.put(0, 0);
		System.out.println("A new vector clock is initialized.");
	}
	
	public void intializeClockWithNumberOfProcess(int processes){
		//start clock synchronized
		vc = new HashMap<Integer,Integer>();
		for(int i = 0; i<=processes; i++){
			vc.put(i,1);
		}
		//System.out.println(vc.get(1));
		//return vc.get(1);
	}

	public void intializeLocalClock(){
		//start clock synchronized
		vc = new HashMap<Integer,Integer>();
		vc.put(1, 1);
		//System.out.println(vc.get(1));
		//return vc.get(1);
	}
	 public void increase(int processIndex){
		//value of the current process index which is senderId or receiverId
		System.out.println(vc.get(1));
		int currentValue = vc.get(processIndex);
		System.out.println(currentValue);
		System.out.println("value above");
		
		vc.put(processIndex, currentValue+1);
		System.out.println(vc.get(processIndex));
	}
	 public void decrease(int processIndex){
		//we need this because sometimes the send message won't work so we need to decrease the clock
		int currentValue = vc.get(processIndex);
		vc.put(processIndex, currentValue-1);
	}
	public int get(int processIndex){
		if(vc.get(processIndex)!= null){
			return vc.get(processIndex);
		}
		//does not exists. 
		else return -1;
	}
	 public void set(){
		
	}
	public String showClock(){
		if(vc != null && vc.get(1)!= 0){
			
			

			return " The clock value: "+vc.get(1);
		}
		return "something is wrong with the clock content!";
	}

	public static void main(String args[]){
		VClock c  = new VClock(); 
		c.intializeClockWithNumberOfProcess(1);
		c.increase(1);
		System.out.println(c.showClock());
	}
	
}
