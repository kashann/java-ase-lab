package eu.ase.threads.parallel;

public class MyRunnable implements Runnable {
	
	private int[] vi; //vector input
	private int startIdx;
	private int stopIdx;
	private Long sum;
	
	public MyRunnable(int[] v, int start, int stop){
		this.vi = v;
		this.startIdx = start;
		this.stopIdx = stop;
		//this.sum = new Long(0);
	}
	
	@Override
	public void run(){
		long s = 0;
		for(int idx = this.startIdx; idx <= this.stopIdx; idx++){
			s += this.vi[idx];
		}
		this.sum = new Long(s);
	}
	
	public Long getSum(){
		return this.sum;
	}	
}
