package async;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

public class Combineindepfuture {
	
	
	
	public CompletableFuture<Map<String,Long>> getempmapcomp() throws StreamReadException, DatabindException, IOException
	{
		
		return CompletableFuture.supplyAsync(() ->{
			
			
			System.out.println("Map Generator"+Thread.currentThread().getName());

				try {
					return empdb.getemps().stream().collect(Collectors.groupingBy(Employee::getNewjoinee,Collectors.counting()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
		
			
			
		});
		
		
	}
	
	
	public CompletableFuture<List<String>> getemails()
	{
		
		
		return CompletableFuture.supplyAsync(()->{
			
			
			System.out.println("The Thread is"+ Thread.currentThread().getName());
			try {
				return empdb.getemps().stream().map(Employee::getEmail).collect(Collectors.toList());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
			
		});
	}
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException, StreamReadException, DatabindException, IOException
	{
		Combineindepfuture cc = new Combineindepfuture();
		
		System.out.println(cc.getempmapcomp().thenCombine(cc.getemails(), (empmap,emails)->empmap+""+emails).get());
		
		
	}
	
	

}
