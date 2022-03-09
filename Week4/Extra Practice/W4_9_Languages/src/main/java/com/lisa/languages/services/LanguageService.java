package com.lisa.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lisa.languages.models.Language;
import com.lisa.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	 // returns all the languages
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    // creates a language
    public Language createLanguage(Language b) {
        return languageRepository.save(b);
    }
    // retrieves a language
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    
    // updates the language
    public Language updateLanguage(Language updatedLanguage) {
    	return languageRepository.save(updatedLanguage);
    }
    
    public void deleteLanguage(Long id) {
    	Optional<Language> deleteLanguageAction = languageRepository.findById(id);
    	if(deleteLanguageAction.isPresent()) {
    		languageRepository.deleteById(id);
    	} 
    	else {
    		System.out.println("Failed to delete");
    	}
    }
}
