package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	private static ExtentReports extentReports;
	private static ExtentTest test;

	private ExtentManager() {

	}

	public static ExtentReports getExtentReports() {
		if (extentReports == null) {
			ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("Singleton-Extent.html");
			extentReports = new ExtentReports();
			extentReports.attachReporter(extentSparkReporter);

		}
		return extentReports;
	}

	public static ExtentTest getTest(ExtentTest test) {
		return test;
	}

	public static void setTest(ExtentTest test) {
		ExtentManager.test = test;

	}

	public static void flush() {
		extentReports.flush();
	}

}
