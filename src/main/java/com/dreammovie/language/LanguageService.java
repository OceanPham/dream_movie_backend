package com.dreammovie.language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    public List<Language> getAllActiveLanguages() {
        // Only return records that are not soft deleted (deletedAt is null)
        return languageRepository.findByDeletedAtIsNull();
    }

    public void softDeleteLanguage(Long id) {
        Language language = languageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("language not found"));

        // Set deletedAt to the current time to mark it as deleted
        language.setDeletedAt(LocalDateTime.now());
        languageRepository.save(language);
    }

    public Optional<Language> getLanguageById (Long id){
        return languageRepository.findById(id);
    }

    public Language addLanguage(Language language){
        return languageRepository.save(language);
    }

    public Language updateLanguage (Long id, Language updateLanguage){
        Optional<Language> languageOptional = languageRepository.findById(id);
        if(languageOptional.isPresent()){
            Language existingLanguage = languageOptional.get();
            existingLanguage.setName(updateLanguage.getName());
            existingLanguage.setStatus(updateLanguage.getStatus());
            existingLanguage.setDescription(updateLanguage.getDescription());

            return languageRepository.save(existingLanguage);
        }
        return null;
    }


    public void deleteLanguage (Long id){
        languageRepository.deleteById(id);
    }
}
