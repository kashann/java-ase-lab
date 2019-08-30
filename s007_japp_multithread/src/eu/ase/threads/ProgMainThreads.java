package eu.ase.threads;

class ThreadNonSync extends Thread{
	private static int a = 0;
	private static int b = 0;
	
	private static Object myLock = new Object();
	
	public ThreadNonSync(String tName){
		super(tName);
	}
	
	private void myMethod(){
		System.out.println("T = " + this.getName() + 
				", a = " + this.a  + ", b = " + this.b);
		
		a++;
		try{
			sleep( (int) (Math.random() * 1000) );
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
		b++;
	}
	
	@Override
	public void run(){
		synchronized(myLock){
			for(int i = 0; i < 3; i++){
				this.myMethod();
			}
		}
	}
}

class ThreadSync extends Thread{
	
}


public class ProgMainThreads {	
	public static void main(String[] args) {
		ThreadNonSync tn1 = new ThreadNonSync("TN1");
		ThreadNonSync tn2 = new ThreadNonSync("TN2");
		
		tn1.start();
		tn2.start();
		
		
	}

}
