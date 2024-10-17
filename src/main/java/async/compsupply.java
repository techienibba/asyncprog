package async;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class compsupply {
	
	
	
	
	
	public static Void getemps(File jsonfile) throws InterruptedException, ExecutionException
	{
		ObjectMapper omp = new ObjectMapper();
		ExecutorService executor = Executors.newFixedThreadPool(1);
		
		CompletableFuture<Void> empfuture = CompletableFuture.runAsync(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
					List<Employee> lists =omp.readValue(jsonfile, new TypeReference<List<Employee>>() {});
					lists.stream().forEach(System.out::println);
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
			
				System.out.println("The thread is" + Thread.currentThread().getName());
				
				
			}
			
			
			
			
			
			
			
			
		},executor);
		
		
		return empfuture.get();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		
		
		compsupply.getemps(new File(System.getProperty("user.dir") +"\\src\\main\\java\\async\\emp.json"));
	}
	
	
	
	
	
	
	
	
	
	

}
