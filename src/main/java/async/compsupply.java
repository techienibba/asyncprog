package async;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

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
	
	public static Void getempsapply(File jsonfile) throws InterruptedException, ExecutionException, StreamReadException, DatabindException, IOException
	{
		ObjectMapper omp = new ObjectMapper();
		List<Employee> lists =omp.readValue(jsonfile, new TypeReference<List<Employee>>() {});
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		CompletableFuture<Void> empfutur=CompletableFuture.supplyAsync(()->{System.out.println("The Thread for list is" + Thread.currentThread().getName());
				return lists.stream().collect(Collectors.toList());},executor).thenApplyAsync((employees) -> {
					System.out.println("Stream New joiner thread" + Thread.currentThread().getName());
					return employees.stream().filter((emp) -> emp.getNewjoinee().equalsIgnoreCase("yes")).collect(Collectors.toList());},executor).thenApplyAsync((employees) ->{
						
						System.out.println("The Getlearning thread is" + Thread.currentThread().getName());
						return employees.stream().filter((emp) -> "true".equalsIgnoreCase(emp.getLearningpending())).collect(Collectors.toList());
						
					},executor).thenApplyAsync((employees) ->{
						
						System.out.println("The Thread to get name is" + Thread.currentThread().getName());
						return employees.stream().map((emp) -> emp.getName()).collect(Collectors.toList());
						
						
					},executor).thenAcceptAsync((emails)->{
						
						System.out.println("The Thread to send email is" + Thread.currentThread().getName());
						emails.stream().forEach(compsupply::sendemail);
						
					},executor);
			
			
			
			
			
	
		
		
		return empfutur.get();
		
	}
	
	public static void sendemail(String email)
	{
		System.out.println("Email sent to " + email);
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException, StreamReadException, DatabindException, IOException
	{
		
		
		compsupply.getempsapply(new File(System.getProperty("user.dir") +"\\src\\main\\resources\\emp.json"));
	}
	
	
	
	
	
	
	
	
	
	

}
