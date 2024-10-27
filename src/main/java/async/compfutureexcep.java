package async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class compfutureexcep {
	
	
	
	
	public CompletableFuture<String> mockcompone()
	{
		
		
		return CompletableFuture.supplyAsync(() -> {
			
			
			System.out.println("The String is" + Thread.currentThread().getName());
			return "Mocke Thread 1"+0/0;
			
		}).exceptionally(ex -> ex.getMessage());
		
	}
	
	
	public CompletableFuture<String> mockcompsecond()
	{
		
		
		return CompletableFuture.supplyAsync(() -> {
			
			
			System.out.println("The String is" + Thread.currentThread().getName());
			return "Mocke Thread 2"+0/0;
			
		}).exceptionally(ex -> ex.getMessage());
		
	}
	
	
	public CompletableFuture<String> mockcompthree()
	{
		
		
		return CompletableFuture.supplyAsync(() -> {
			
			
			System.out.println("The String is" + Thread.currentThread().getName());
			return "Mocke Thread 3"+0/0;
			
		});
		
	}
	
	
	public CompletableFuture<String> mockcompfour()
	{
		
		
		return CompletableFuture.supplyAsync(() -> {
			
			
			System.out.println("The String is" + Thread.currentThread().getName());
			return "Mock Thread 4" +0/0;
			
		});
		
	}
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		compfutureexcep cnw = new compfutureexcep();
		System.out.println(cnw.mockcompone().get());
		System.out.println(cnw.mockcompsecond().get());
		
		System.out.println(cnw.mockcompthree().thenCombine(cnw.mockcompfour(), (e1,e2)->e1+""+e2).handle((res,ex) -> ex.getMessage()).get());
		
	}
	
	

}
