package com.abc;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogTest
{

	public static void main(String[] args)
	{
		PropertyConfigurator.configure("log4j.properties");
		Logger m_log = Logger.getLogger(LogTest.class);

		while (true)
		{
			m_log.debug("debug test...........");
			m_log.info("info message here 123");
			m_log.warn("warn message www");
			m_log.error("error message xxx");
			
			//System.exit(0);
		}
		// System.out.println("OK");
	}
}
