package com.stord.exercise.service;

import org.springframework.stereotype.Service;
import com.stord.exercise.entity.Url;
import com.stord.exercise.repository.UrlRepository;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UrlService {

    private final UrlRepository urlRepository;
    private final BaseConversion conversion;
    
    Logger logger = Logger.getLogger(UrlService.class.getName()); 

    public UrlService(UrlRepository urlRepository, BaseConversion baseConversion) {
        this.urlRepository = urlRepository;
        this.conversion = baseConversion;
    }

    public String convertToShortUrl(String longUrl) {
    	Url url = new Url();
        url.setLongUrl(longUrl);
        Url entity = urlRepository.save(url);
        String shortURL = conversion.encode(entity.getId());
        entity.setShortUrl(shortURL);
        urlRepository.saveAndFlush(entity);
        return shortURL;
    }

    public String convertToLongUrl(String shortUrl) {
        long id = conversion.decode(shortUrl);
        Url entity = urlRepository.findById(id).get();
    	logger.log(Level.FINE, "entity>>>>>>>>>>>>>>>>>>>>>>>>>");
    	logger.log(Level.FINE, entity.getLongUrl());
    	logger.log(Level.FINE, "entity>>>>>>>>>>>>>>>>>>>>>>>>>");

        return entity.getLongUrl();
    }
}
