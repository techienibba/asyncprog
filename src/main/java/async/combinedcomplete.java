package async;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

public class combinedcomplete {
	
	
//ExecutorService executors = Executors.newFixedThreadPool(2);
	
	
	
	
	

	public CompletableFuture<Employee> getemp()   
	{
		
		
		return CompletableFuture.supplyAsync(() ->{
			
			System.out.println("getempdetails thread"+Thread.currentThread().getName());
			
			try {
				return empdb.getemps().stream().filter(e -> e.getName().equalsIgnoreCase("Mohamed Akram")).findAny().orElse(null);
			} catch (StreamReadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DatabindException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	
				
			
					
				
								
		
		
		
	});}
	
	public CompletableFuture<Long> getempid(Employee emp) throws StreamReadException, DatabindException, InterruptedException, ExecutionException, IOException
	{
		//combinedcomplete cc = new combinedcomplete();
		
		//Employee emp =cc.getemp().get();
		
		 return CompletableFuture.supplyAsync(() ->{
		
			
	System.out.println("getempid thread"+Thread.currentThread().getName());
	return emp.getId();
		
		

		});
		
		
		
	}
	//then apply combines two completable futures and gives rise to Completable<Completable<String>>
	//Two dependent completablefuture types can be processed by thenCompose
	
	public static void main(String[] args) throws InterruptedException,ExecutionException, IOException, RuntimeException
	{combinedcomplete cc = new combinedcomplete();
	
	

		CompletableFuture<Long> yesid = cc.getemp().thenCompose(t -> {
			try {
				return cc.getempid(t);
			} catch (StreamReadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DatabindException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		});

	
	
	System.out.println(yesid.get());
	

	//System.out.println(id.get());


	
		
		
		
		
		
	}
	

}
