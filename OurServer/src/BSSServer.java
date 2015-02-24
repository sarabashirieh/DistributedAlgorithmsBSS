import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class BSSServer {

	public static void main (String[] args){

		try{
			
			Registry serverRegistry = LocateRegistry.createRegistry(2005);
			//initialize the global clock and process clocks
			VClock globalClock = new VClock();
			VClock p1Clock = new VClock();
			VClock p2Clock = new VClock();
			VClock p3Clock = new VClock();
			
			
			//System.out.println(globalClock.get(1)); 
			
			//System.out.println(globalClock.get(1));
			p1Clock.intializeClockWithNumberOfProcess(1);
			p2Clock.intializeClockWithNumberOfProcess(1);
			p3Clock.intializeClockWithNumberOfProcess(1);
			//we need our implementation
			BSSImplementation imp = new BSSImplementation();
			serverRegistry.rebind("Process1", imp);
			serverRegistry.rebind("Process2", imp);
			serverRegistry.rebind("Process3", imp);
			//We've got 3 processes
			int numberOfProcesses = 3;
			BSSInterface p1Interface = (BSSInterface) serverRegistry.lookup("Process1");
			BSSInterface p2Interface = (BSSInterface) serverRegistry.lookup("Process2");
			BSSInterface p3Interface = (BSSInterface) serverRegistry.lookup("Process3");
			//Process1 wants to broadcast.
			globalClock.intializeClockWithNumberOfProcess(3);
			//First Process1 needs to increase the general clock
			//globalClock.increase(1); //we use index1 because it is process1
			
			p1Clock.intializeLocalClock();
			p1Clock.increase(1);//process index is always 1 because this is a local clock;
			VClock vm = p1Clock; //put the local clock in the message, this will be the clock of message
			//create a Message and broadcast
			System.out.println("vm"+vm.get(1));
			
			Message fromp1top2 = new Message(1,2,vm,"Hello Process2 I'm Process1 :) ");
			Message fromp1top3 = new Message(1,3,vm,"Hello Process3 I'm Process1 :) ");
			
			//Broadcast the message with vm.
			
			System.out.println(p1Interface.sendMessage(2, 1, fromp1top2, vm));
			System.out.println(p1Interface.sendMessage(3, 1, fromp1top3, vm));
			
			
			 //Result of process1 saved to send to Process2
			 //int temp = p1Interface.add(1, 1);
			//I'm looking for Proccess2 and I'm going to send to him
			 
		//	 System.out.println("temp + temp = " + p2Interface.add(temp, temp));
			 
			
			 
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
