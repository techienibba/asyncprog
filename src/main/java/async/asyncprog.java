package async;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Used for async non blocking programs that execute individual threads as tasks concurrently and notify the main thread once the tasks are complete
//Manuall execution of Code
//Chaining of multiple tasks as threads
//Combining multiple futures,executors,for-joins as one combined task
//Exception handling Mechanism

public class asyncprog {
	
	
	
	public static List<String> getvalues() throws InterruptedException, ExecutionException
	{
		List<String> names = Arrays.asList("My","Name","is","Akram");
		ExecutorService executor = Executors.newCachedThreadPool();
		CompletableFuture<List<String>> compfuture = CompletableFuture.supplyAsync(() -> {
			
			System.out.println("Executed by" + ""+ Thread.currentThread().getName());
			
			return names;
			
			
			
			
			
			
		}, executor);
		
		return compfuture.get();
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		List<String> allvalues = asyncprog.getvalues();
		allvalues.stream().forEach(System.out::println);
		
		
	}
	
	
	
	
	
	
	
	
	

}
