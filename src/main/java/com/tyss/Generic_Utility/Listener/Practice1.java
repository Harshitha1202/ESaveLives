package com.tyss.Generic_Utility.Listener;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.Generic_Utility.JavaUtility;
import com.tyss.Generic_Utility.WebDriverUtility;
import com.tyss.Generic_Utility.ExternalFileUtility.SystemDateUtility;

public class Practice1 extends ListenerBaseClass{
	@Test
	public void rmgServer()
	{
		System.out.println("from test1");
		driver.get("http://rmgtestingserver/domain");
		
	}

}
