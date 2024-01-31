package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * this class provide Implementation to ITestlisteners interface of TestNG
 * @author ASUS
 *
 */
public class ListenersImplementation implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		//start of @test, test script is started- Test Method
	String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-----Test Execution Started----");
		
		// provide the @Test for extent report
	       test = report.createTest(methodName);
	}
		
	

	public void onTestSuccess(ITestResult result) {
                //@Test is passed
                String methodName = result.getMethod().getMethodName();
                System.out.println(methodName+"------Test Pass-------");
                
                // log the status as pass in Extent Report
                test.log(Status.PASS,methodName+"------Test Pass-------" );// we will print this methodname as this test is pass  coz uppar vala print statement wont show in report
	}

	public void onTestFailure(ITestResult result) {
		// @Test is failed
		String methodName = result.getMethod().getMethodName();
        System.out.println(methodName+"------Test Fail-------");
        
        // print the exception in console
        System.out.println(result.getThrowable());
        
        // log the status as fail in Extent Report
        test.log(Status.FAIL,methodName+"------Test Fail-------" );
        test.log(Status.INFO,result.getThrowable());// ADD THE EXCEPTION IN REPORT, Status as info coz its an information
        
        
        // capture the screen shot
        SeleniumUtility s = new SeleniumUtility();
        JavaUtility j = new JavaUtility();
        
        //creating a screen shot name with time and date
        String screenShotName = methodName+"-"+j.getSystemDate();
        
        try {
		String path = s.captureScreenShot(BaseClass.sDriver, screenShotName); // string path baad me add kiya while extent report 
		
		// attach the screenshot to extent report
			test.addScreenCaptureFromPath(path); 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	
	}

	public void onTestSkipped(ITestResult result) {
		//@Test is skipped
		String methodName = result.getMethod().getMethodName();
        System.out.println(methodName+"------Test Skip-------");
        
        // to print the exception in the console like the resone why the test script has not been executed
        System.out.println(result.getThrowable());
        
        // log the status as skip in extent report
        test.log(Status.SKIP, methodName+"------Test Skip-------");
        test.log(Status.INFO,result.getThrowable() );
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		
	System.out.println("----Suite Execution Started----");
	// Basic configuration of Extent report
	ExtentSparkReporter rep = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDate()+".html");
	rep.config().setDocumentTitle("Execution Report");;//  method to provide configuration and has setter, display in page titile
	rep.config().setTheme(Theme.DARK);
	rep.config().setReportName("Vtiger Execution Report");// display in report
	
	//Attach the configuration to actual extendReports class
	report = new ExtentReports();
	report.attachReporter(rep);
	
	//Set any System information
	report.setSystemInfo("Base Plateform","Windows");
	report.setSystemInfo("Base Browser","Chrome");
	report.setSystemInfo("Base Environment","Testing");
	report.setSystemInfo("Reporter Name","Neha");

}

	public void onFinish(ITestContext context) {
		
     System.out.println("----Suite Execution Finished----");
     
     //Generate the report
     report.flush();
     
	}
	
	

}
