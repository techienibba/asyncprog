package async;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class indepfcfs {
	
	
	String value;
	public CompletableFuture<String> gettime(int time)
	{
		
		return CompletableFuture.supplyAsync(() -> {
			
			System.out.println("The time of thread is" + Thread.currentThread().getName());
			try {
				Thread.sleep(Duration.ofSeconds(time));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(time>=1&&time<3)
			{
				value = "stock";
				
				return "The time is" + time + "and value is" + value;
			}
			
			else if(time>=3&&time<5)
			{
				
                value = "share";
				
				return "The time is" + time + "and value is" + value;
				
				
			}
			
			else
			{
				
				
                value = "weather";
				
				return "The time is" + time + "and value is" + value;
			}
			
			
			
		});
		
		
		
		
	
		
		
		
	}
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		indepfcfs ind = new indepfcfs();
		
		CompletableFuture<String> firstone = ind.gettime(5);
		CompletableFuture<String> secondone = ind.gettime(3);
		CompletableFuture<String> thirdone = ind.gettime(1);
		
		CompletableFuture<Object> alltasks = CompletableFuture.anyOf(firstone,secondone,thirdone);
		
		
		
		alltasks.thenAccept(value -> System.out.println(value)).join();
		
		
		
		
	}
	
	
	
	
	

}
