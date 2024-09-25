package com.dreammovie.screeningtype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ScreeningTypeService {

    @Autowired
    private ScreeningTypeRepository screeningTypeRepository;

    public List<ScreeningType> getAllActiveScreeningTypes() {
        // Only return records that are not soft deleted (deletedAt is null)
        return screeningTypeRepository.findByDeletedAtIsNull();
    }

    public void softDeleteScreeningType(Long id) {
        ScreeningType screeningType = screeningTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("screeningType not found"));

        // Set deletedAt to the current time to mark it as deleted
        screeningType.setDeletedAt(LocalDateTime.now());
        screeningTypeRepository.save(screeningType);
    }

    public Optional<ScreeningType> getScreeningTypeById (Long id){
        return screeningTypeRepository.findById(id);
    }

    public ScreeningType addScreeningType(ScreeningType screeningType){
        return screeningTypeRepository.save(screeningType);
    }

    public ScreeningType updateScreeningType (Long id, ScreeningType updateScreeningType){
        Optional<ScreeningType> screeningTypeOptional = screeningTypeRepository.findById(id);
        if(screeningTypeOptional.isPresent()){
            ScreeningType existingScreeningType = screeningTypeOptional.get();
            existingScreeningType.setName(updateScreeningType.getName());
            existingScreeningType.setStatus(updateScreeningType.getStatus());
            existingScreeningType.setDescription(updateScreeningType.getDescription());

            return screeningTypeRepository.save(existingScreeningType);
        }
        return null;
    }


    public void deleteScreeningType (Long id){
        screeningTypeRepository.deleteById(id);
    }
}
