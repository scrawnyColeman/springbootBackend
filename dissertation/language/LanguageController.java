package uk.ac.qub.njoy.dissertation.language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/njoy")
public class LanguageController {

    @Autowired
    LanguageRepository languageRepo;

    /**
     * Get all languages
     */
    @GetMapping("/languages")
    public List<Language> getAllLanguages(){
      return languageRepo.findAll();
    };
}


