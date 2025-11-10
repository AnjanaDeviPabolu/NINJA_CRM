package ninjaCRM;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertions {
	
	
	//hard Assertions
	//@Test
//	public void hardAssert() {
//		System.out.println("Start");
//		Assert.assertNotEquals("hdfc", "hfdc");
//		System.out.println("End");
//	}
	
	//hard Assertions
//	@Test
//	public void hardAssert() {
//		System.out.println("Start");
//		Assert.assertTrue("hdfc".equals("hfdc"));
//		System.out.println("End");	
//	}
	
	
	//hard Assertions
	@Test
	public void hardnullassert() {
	String A="anjana";
	System.out.println("start");
	Assert.assertNotNull(A);
	System.out.println("Stop");
	}
	
	
	//Soft Assertions
//	@Test
//	public void SoftAssert() {
//		System.out.println("Start");
//		org.testng.asserts.SoftAssert soft = new org.testng.asserts.SoftAssert();
//		soft.assertEquals("hdfc", "hfdc");
//		System.out.println("End");
//		soft.assertAll();
//	}
	
//	@Test
//	public void SoftAssert() {
//		System.out.println("Start");
//		org.testng.asserts.SoftAssert soft = new org.testng.asserts.SoftAssert();
//		soft.assertTrue("hdfc".equals("hfdc"),"It should Fail");
//		System.out.println("End");
//		soft.assertAll();
//	}
	
	@Test
	public void SoftNullAssert() {
		String B="anjana";
		System.out.println("Start");
		org.testng.asserts.SoftAssert soft = new org.testng.asserts.SoftAssert();
		soft.assertNotNull(B);
		System.out.println("End");
		soft.assertAll();
	}



}
