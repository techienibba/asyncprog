package async;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class empdb {
	static List<Employee> lists;
	
	
	public static List<Employee> getemps() throws StreamReadException, DatabindException, IOException
	{
		ObjectMapper omp = new ObjectMapper();
		

		try {
			lists = omp.readValue(new File(System.getProperty("user.dir") +"\\src\\main\\resources\\emp.json"), new TypeReference<List<Employee>>() {});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return lists;
	}

}
