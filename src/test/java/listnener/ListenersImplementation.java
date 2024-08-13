package listnener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementation implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.err.println("OnTestStart");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.err.println("OnTestStart");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.err.println("OnTestSuccess");	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.err.println("OnTestSkipped");
	}

	@Override
	public void onStart(ITestContext context) {
		System.err.println("OnStart");	}

	@Override
	public void onFinish(ITestContext context) {
		System.err.println("OnFinish");
	}

	
	
}
