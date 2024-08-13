package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class SampleTest {

	@Test
	public void demo()
	{
		//It is like Println Statement
		Reporter.log("Hello World!", true);
	}
	
}
