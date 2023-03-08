package com.tyss.Generic_Utility.Listener;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Practice2 extends ListenerBaseClass{
	@Test
	public void hmsServer()
	{
		System.out.println("from test2");
		driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");
		Assert.fail();
	}

}
