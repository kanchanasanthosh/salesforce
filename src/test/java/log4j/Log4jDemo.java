package log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Log4jDemo {

	
	@Test
	public void log() {
		Logger logger = LogManager.getLogger(Log4jDemo.class.getName());
		logger.debug("debug displayed");
		logger.info("info displayed");
		logger.warn("warn displayed");
		logger.error("error displayed");
		logger.fatal("fatal displayed");
		
	}
	
	
}
