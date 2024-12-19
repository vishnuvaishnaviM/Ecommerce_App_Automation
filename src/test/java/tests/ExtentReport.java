package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
    protected static ExtentReports extent;
    private static ExtentSparkReporter spark;
    
    @BeforeSuite
    public void setup() {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("target/spark/spark.html");

        extent.attachReporter(spark);
        System.out.println("Extent report setup completed.");
    }

    @AfterSuite
    public void teardown() {
        System.out.println("Executing @AfterSuite teardown...");
        extent.flush();
        System.out.println("flushed successfully");
    }
}
