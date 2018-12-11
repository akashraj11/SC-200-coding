package com.stackroute.neo4jservice.service.nodeservice;

import com.stackroute.neo4jservice.domain.nodes.Language;
import com.stackroute.neo4jservice.repository.noderepository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageImpl implements LanguageService {
    LanguageRepository languageRepository;

    @Autowired
    public LanguageImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    @Override
    public Language saveLanguage(Language language) {
        Language savedLanguage = languageRepository.save(language);
        return savedLanguage;
    }

    @Override
    public String deleteLanguage(String id) {
            languageRepository.deleteById(id);
            System.out.println("..................................Coming here");
            return ("Successfully deleted");
    }


    @Override
    public List<Language> getAllLanguage() {
        return (List<Language>) languageRepository.findAll();
    }
    //return (List<Concept>)conceptRepository.findAll()
}
