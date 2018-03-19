package spicinemas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spicinemas.api.db.LanguageRepository;
import spicinemas.api.model.Language;

import java.util.List;


@RestController
public class LanguageController {

    @Autowired
    LanguageRepository languageRepository;

    @RequestMapping(value = "/language",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Language> getLanguages() {
        return languageRepository.getAllLanguage();
    }
}
