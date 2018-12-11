package com.stackroute.neo4jservice.service.nodeservice;

import com.stackroute.neo4jservice.domain.nodes.Language;

import java.util.List;

public interface LanguageService {
    public Language saveLanguage(Language language);
    public String deleteLanguage(String id);
    public List<Language> getAllLanguage();
}
