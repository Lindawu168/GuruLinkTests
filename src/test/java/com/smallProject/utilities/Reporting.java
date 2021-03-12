package com.smallProject.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	 public ExtentReports extent;
     public ExtentSparkReporter spark;
     public ExtentTest logger;
     private String classPath = System.getProperty("user.dir");
     
    
     public void onStart(ITestContext testContext) {
    	 //Create a report name by time stamp
    	 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    	 String repName = "Test-Report-" + timeStamp + ".html";
    	 
    	 spark = new ExtentSparkReporter(classPath + "/test-output/" + repName);
    	 try {
			spark.loadXMLConfig(classPath+ "/extent-configure.xml");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
    	 extent = new ExtentReports();
    	 extent.attachReporter(spark);
    	 extent.setSystemInfo("Host name", "Localhost");
    	 extent.setSystemInfo("Environment" , "QA");
    	 extent.setSystemInfo("user", "Linda");
    	 
    	 spark.config().setDocumentTitle("Small Project");
    	 spark.config().setReportName("Functional Test Report");
    	 spark.config().setTheme(Theme.DARK);
    	 
     }
     public void onTestSuccess(ITestResult tr) {
    	 logger = extent.createTest(tr.getName());
    	 logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); 	 
     }
     
     public void onTestFailure(ITestResult tr) {
    	 logger = extent.createTest(tr.getName());
    	 logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
    	 
    	 String screenshotPath = classPath +"/screenshots/" + tr.getName() + ".png";
    	 File fl = new File(screenshotPath);
    	 if(fl.exists()) {
    		 logger.fail("Screenshot is blew: " + logger.addScreenCaptureFromPath(screenshotPath));
    	 }
    	 
     }
     
     
     public void onTestSKipped(ITestResult tr) {
    	 logger = extent.createTest(tr.getName());
    	 logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
    	 
     }
     
     public void onFinish(ITestContext testContext) {
    	 extent.flush();
     }
}
