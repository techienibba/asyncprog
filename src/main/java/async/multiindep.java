package async;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class multiindep {
	
	
	public CompletableFuture<String> getweather()
	{
		
		
		return CompletableFuture.supplyAsync(() ->{
			
			
			
			System.out.println("weatherthread" + Thread.currentThread().getName());
			try {
				Thread.sleep(Duration.ofSeconds(3));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "The Weather is hot today";
		});
		
	}
		public CompletableFuture<String> getshare()
		{
			
			
			return CompletableFuture.supplyAsync(() ->{
				
				
				
				System.out.println("ShareThread" + Thread.currentThread().getName());
				try {
					Thread.sleep(Duration.ofSeconds(3));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "The Share Price is High today";
			});}
			
			
			public CompletableFuture<String> getstock()
			{
				
				
				return CompletableFuture.supplyAsync(() ->{
					
					
					
					System.out.println("StockThread" + Thread.currentThread().getName());
					try {
						Thread.sleep(Duration.ofSeconds(3));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return "The Stock-price is High today";
				});
				
		
			}	
				public static void main(String[] args) throws InterruptedException, ExecutionException
				{
					multiindep multi = new multiindep();
					String weather=multi.getweather().join();
					String share=              multi.getshare().join();
					String stock=              multi.getstock().join();
					
					CompletableFuture<Void> alltasks = CompletableFuture.allOf(multi.getweather(),multi.getshare(),multi.getstock());
					
					alltasks.thenRun(()->{
						
						
						System.out.println(weather);
						System.out.println(share);
						System.out.println(stock);
						
					}).join();
					
				}
				
				
				
	}
	
	
	
	
	
	
	
	
	
	


