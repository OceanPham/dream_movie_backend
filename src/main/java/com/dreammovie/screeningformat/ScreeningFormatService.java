package com.dreammovie.screeningformat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ScreeningFormatService {

    @Autowired
    private ScreeningFormatRepository screeningFormatRepository;

    public List<ScreeningFormat> getAllActiveScreeningFormats() {
        // Only return records that are not soft deleted (deletedAt is null)
        return screeningFormatRepository.findByDeletedAtIsNull();
    }

    public void softDeleteScreeningFormat(Long id) {
        ScreeningFormat screeningFormat = screeningFormatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("screeningFormat not found"));

        // Set deletedAt to the current time to mark it as deleted
        screeningFormat.setDeletedAt(LocalDateTime.now());
        screeningFormatRepository.save(screeningFormat);
    }

    public Optional<ScreeningFormat> getScreeningFormatById (Long id){
        return screeningFormatRepository.findById(id);
    }

    public ScreeningFormat addScreeningFormat(ScreeningFormat screeningFormat){
        return screeningFormatRepository.save(screeningFormat);
    }

    public ScreeningFormat updateScreeningFormat (Long id, ScreeningFormat updateScreeningFormat){
        Optional<ScreeningFormat> screeningFormatOptional = screeningFormatRepository.findById(id);
        if(screeningFormatOptional.isPresent()){
            ScreeningFormat existingScreeningFormat = screeningFormatOptional.get();
            existingScreeningFormat.setName(updateScreeningFormat.getName());
            existingScreeningFormat.setStatus(updateScreeningFormat.getStatus());
            existingScreeningFormat.setDescription(updateScreeningFormat.getDescription());

            return screeningFormatRepository.save(existingScreeningFormat);
        }
        return null;
    }


    public void deleteScreeningFormat (Long id){
        screeningFormatRepository.deleteById(id);
    }
}
