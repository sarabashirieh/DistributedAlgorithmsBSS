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
			Buffer b1 = new Buffer();
			Buffer b2 = new Buffer();
			Buffer b3 = new Buffer();
			//System.out.println(globalClock.get(1)); 
			
			//System.out.println(globalClock.get(1));
			p1Clock.intializeClockWithNumberOfProcess(1);
			p2Clock.intializeClockWithNumberOfProcess(1);
			System.out.println("p2Clock"+p2Clock.get(1));
			p3Clock.intializeClockWithNumberOfProcess(1);
			
			//Generate processes with unique id, local clock and a buffer.
			
			BSSImplementation imp1 = new BSSImplementation(1,p1Clock,b1);
			BSSImplementation imp2 = new BSSImplementation(2,p2Clock,b2);
			BSSImplementation imp3 = new BSSImplementation(3,p3Clock,b3);
			serverRegistry.rebind("Process1", imp1);
			serverRegistry.rebind("Process2", imp2);
			serverRegistry.rebind("Process3", imp3);
			//We've got 3 processes
			BSSInterface p1Interface = (BSSInterface) serverRegistry.lookup("Process1");
			BSSInterface p2Interface = (BSSInterface) serverRegistry.lookup("Process2");
			BSSInterface p3Interface = (BSSInterface) serverRegistry.lookup("Process3");
			
			//give the processes an id;
			//p1Interface.myId = 1;
			//Process1 wants to broadcast.
			globalClock.intializeClockWithNumberOfProcess(3);
			//First Process1 needs to increase the general clock
			//globalClock.increase(1); //we use index1 because it is process1
			p1Clock.intializeLocalClock();
			p1Clock.increase(1);//process index is always 1 because this is a local clock;
			System.out.println("p2Clock"+p2Clock.get(1));

			VClock vm = p1Clock; //put the local clock in the message, this will be the clock of message
			//create a Message and broadcast
			System.out.println("vm"+vm.get(1));
			
			Message fromp1top2 = new Message(imp1.myId,imp2.myId,vm,"Hello Process2 I'm Process1 :) ");
			Message fromp1top3 = new Message(imp1.myId,imp3.myId,vm,"Hello Process3 I'm Process1 :) ");
			
			//Broadcast the message with vm.
			
			System.out.println(p1Interface.sendMessage(2, p1Interface.myId, fromp1top2, vm));
			System.out.println(p1Interface.sendMessage(3, p1Interface.myId, fromp1top3, vm));
			System.out.println("again"+vm.get(1));
		
			p2Interface.receiveMessage(fromp1top2, p2Clock);
			
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
