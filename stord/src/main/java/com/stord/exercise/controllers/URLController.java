package com.stord.exercise.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import com.stord.exercise.request.LongURLRequest;
import com.stord.exercise.request.ShortURLRequest;
import com.stord.exercise.response.LongURLResponse;
import com.stord.exercise.response.ShortURLResponse;
import com.stord.exercise.service.UrlService;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.stord.exercise.enums.Errors;

@RestController
@RequestMapping("/api/url")
public class URLController implements IController{

	private final UrlService urlService;

	Logger logger = Logger.getLogger(URLController.class.getName());

	public URLController(UrlService urlService) {
		this.urlService = urlService;
	}

	@ApiOperation(value = "Convert new url", notes = "Converts long url to short url")
	@PostMapping("/short")
	public ShortURLResponse convertToShortUrl(@RequestBody ShortURLRequest request) {
		ShortURLResponse response = new ShortURLResponse();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
		logger.log(Level.FINE, ">>>>>>>>>>>>>>>>>>>>>>>>>");
		logger.log(Level.FINE, request.getLongUrl());
		logger.log(Level.FINE, ">>>>>>>>>>>>>>>>>>>>>>>>>");
		try {
			String url = urlService.convertToShortUrl(request.getLongUrl());
			response.setShortUrl(url);
		} catch (Exception e) {
			setError(response, Errors.SERVICE_LAYER_ERROR);
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return response;
	}

	@ApiOperation(value = "return long URL", notes = "Finds original url from short url")
	@GetMapping(value = "/long")
	public LongURLResponse convertToLongUrl(@RequestParam(value = "shortUrl") String shortUrl) {
		LongURLResponse response = new LongURLResponse();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(shortUrl);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
		logger.log(Level.FINE, ">>>>>>>>>>>>>>>>>>>>>>>>>");
		logger.log(Level.FINE, shortUrl);
		logger.log(Level.FINE, ">>>>>>>>>>>>>>>>>>>>>>>>>");
		try {
			String url = urlService.convertToLongUrl(shortUrl);
			response.setLongUrl(url);
		} catch (Exception e) {
			setError(response, Errors.SERVICE_LAYER_ERROR);
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return response;
	}
}
