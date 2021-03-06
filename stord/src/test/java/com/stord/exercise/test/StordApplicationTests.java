package com.stord.exercise.test;

import static org.junit.Assert.assertEquals;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.stord.exercise.service.UrlService;

@SpringBootTest
class StordApplicationTests {

	@Resource
	private UrlService urlService;

	Logger logger = Logger.getLogger(StordApplicationTests.class.getName());

	@Test
	public void convertToShortUrlTest() {

		String longURL = "https://www.google.com/search?q=react&rlz=1C1CHBD_enEG853EG853&oq=react&aqs=chrome.0.69i59j0i433j0l3j69i60l3.2581j0j7&sourceid=chrome&ie=UTF-8";
		String shortURL = urlService.convertToShortUrl(longURL);
		assertEquals(longURL, urlService.convertToLongUrl(shortURL));
	}
	
	@Test
	void contextLoads() {
	}
}
