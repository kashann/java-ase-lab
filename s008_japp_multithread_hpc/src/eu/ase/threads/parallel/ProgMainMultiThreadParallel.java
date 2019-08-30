package eu.ase.threads.parallel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ProgMainMultiThreadParallel {
	private static final int NTHREADS = 2; //or 4 or 8

	public static void main(String[] args) {
		
		int vectDim = 40_000_000;
		int[] v = new int[vectDim];
		Long sum = new Long(0);
		
		for(int i = 0; i < vectDim; i++){
			v[i] = 1 + i;
		}
		
		// ############
		int startIdx = 0, stopIdx = 0;
		long startTime = 0, stopTime = 0;
		Long[] vectSum = new Long[NTHREADS];
		
		// 1. Seq Array Sum
		sum = new Long(0);
		startTime = System.currentTimeMillis();
		for(int i = 0; i < vectDim; i++){
			sum += v[i];
		}
		stopTime = System.currentTimeMillis();
		System.out.println("1. Seq Array Time = "
				+ (stopTime - startTime)
				+ " , sum = " + sum);
		
		// 2. Multi-Threading Std. Array Sum
		sum = new Long(0);
		startTime = System.currentTimeMillis();
		
		Thread[] vectThreads = new Thread[NTHREADS];
		MyRunnable[] vectRThreads = new MyRunnable[NTHREADS];
		for(int it = 0; it < NTHREADS; it++){
			startIdx = it * (vectDim / NTHREADS);
			stopIdx = (it + 1) * (vectDim / NTHREADS) - 1;
			//vectSum[it] = new Long(0);
			vectRThreads[it] = new MyRunnable(v, startIdx, stopIdx);
			vectThreads[it] = new Thread(vectRThreads[it]);
		}
		
		for(int it = 0; it < NTHREADS; it++){
			vectThreads[it].start();
		}
		
		for(int it = 0; it < NTHREADS; it++){
			try{
				vectThreads[it].join();
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}
		
		for(int it = 0; it < NTHREADS; it++){
			sum += vectRThreads[it].getSum();
		}
		
		stopTime = System.currentTimeMillis();
		System.out.println("2. Std. Multi-Thread Array Time = "
				+ (stopTime - startTime)
				+ " , sum = " + sum);
		
		// 3. Multi-Threading Executor-Service Array Sum
		sum = new Long(0);
		startTime = System.currentTimeMillis();
		ExecutorService execThreadPool = Executors.newFixedThreadPool(NTHREADS);
		MyRunnable[] workerTask = new MyRunnable[NTHREADS];
		
		for(int it = 0; it < NTHREADS; it++){
			startIdx = it * (vectDim / NTHREADS);
			stopIdx = (it + 1) * (vectDim / NTHREADS) - 1;
			//vectSum[it] = new Long(0);
			workerTask[it] = new MyRunnable(v, startIdx, stopIdx);
			execThreadPool.execute(workerTask[it]);
		}
		
		execThreadPool.shutdown();
		try{
			execThreadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		
		for(int it = 0; it < NTHREADS; it++){
			sum += vectRThreads[it].getSum();
		}
		
		stopTime = System.currentTimeMillis();
		System.out.println("3. Exec.-Serv. Multi-Thread Array Time = "
				+ (stopTime - startTime)
				+ " , sum = " + sum);
	}

}
