package org.mnChoice.FirstMavenProject;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilities.BaseClass;
import utilities.CommonMethods;

public class LoginTest extends BaseClass {

	@Parameters({ "Browser", "version", "os_version" })
	@BeforeMethod
	public void launchBrowser(String Browser, String version, String os_version) {
		System.out.println("this browser is" + Browser);

		super.setup(Browser, version, os_version);

	}

	@Test
	public void verifyLogin() {
		CommonMethods cm = new CommonMethods(driver);

	}

	@AfterMethod
	public void afterTest() {
		// tearDown();
		driver.quit();
	}
}