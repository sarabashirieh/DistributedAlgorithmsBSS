import java.util.HashMap;


public class VClock {
	//I chose for hashmap because It does not sort and we can use it's key,value property.
	private HashMap<Integer, Integer> vc;
	
	public VClock(){
		//id of process, time
		vc = new HashMap<Integer,Integer>();
	}
	synchronized public void increase(int processIndex){
		//value of the current process index
		int currentValue = vc.get(processIndex);
		vc.put(processIndex, currentValue+1);
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
	
}
