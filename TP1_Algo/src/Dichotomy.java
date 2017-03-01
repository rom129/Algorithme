import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Random;


public class Dichotomy { 
	
public static void main(String[] args){ 
		int nb = 10;
		final int MAX = 500;
		final int MIN = 0;

		ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
		while (nb <= 10000000){    
		int[] values = RandomData.generate1d(nb, MIN, MAX);
		
		int nbVals= values.length;
		int[] data= new int[nbVals];
		for(int i=0; i != data.length; ++i){
		data[i]= 2*i;
		}
		//long startTime = System.currentTimeMillis();
		long beginWallClockTime = System.nanoTime();
		long beginCpuTime = bean.getCurrentThreadCpuTime();
		lowerBound(data, (values[1]));
		long wallClockDuration = System.nanoTime() - beginWallClockTime;
		long cpuTimeDuration   = bean.getCurrentThreadCpuTime() - beginCpuTime;
		//long endTime = System.currentTimeMillis();
		//long time = endTime-startTime; 
		System.out.println(wallClockDuration);
		nb +=10000;
		}
	} 
	
	public static int indexOfOrdered(int[] data, int v){ 
		int res=lowerBound(data, v); 
		if((res==data.length) || (data[res] != v)){ 
			res= -1; 
		} 
		return res; 
	} 

	// index of first element >= v 
	public static int lowerBound(int[] data, int v){ 
		return lowerBound(data, v, 0, data.length); 
	} 

	public static int lowerBound(int[] data, int v, int begin, int end){
		if(begin == end){ return begin;} 
		int m= (begin + end)/2; 
		return data[m] < v ? lowerBound(data, v, m+1, end) : lowerBound(data, v, begin, m); 
	} 

	public static int lowerBoundTCO(int[] data, int v){ 
		int begin=0, end=data.length;
		while(begin != end){ 
			int m= (begin + end)/2; 
			if(data[m] < v){ 
				begin= m+1; 
			} 
			else{
				end= m; 
			} 
		} 
		return begin; 
	} 
}
