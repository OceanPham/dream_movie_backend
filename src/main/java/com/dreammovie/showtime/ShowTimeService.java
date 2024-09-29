package com.dreammovie.showtime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ShowTimeService {
    @Autowired
    private ShowTimeRepository showTimeRepository;

    public List<ShowTime> getAllActiveShowTimes(){
        return showTimeRepository.findByDeletedAtIsNull();
    }

    public void softDeleteShowTime(Long id){
        ShowTime showTime = showTimeRepository.findById(id).orElseThrow(()->new RuntimeException("Show time not found"));
        showTime.setDeletedAt(LocalDateTime.now());
        showTimeRepository.save(showTime);
    }

    public Optional<ShowTime> getShowTimeById(Long id){
        return showTimeRepository.findById(id);
    }

    public ShowTime addShowTime(ShowTime showTime){
        return showTimeRepository.save(showTime);
    }

    public ShowTime updateShowTime (Long id, ShowTime updateShowTime){
        Optional<ShowTime> showTimeOptional = showTimeRepository.findById(id);
        if (showTimeOptional.isPresent()){
            ShowTime existingShowTime = showTimeOptional.get();
            existingShowTime.setCinema(updateShowTime.getCinema());
            existingShowTime.setStart_time(updateShowTime.getStart_time());
            existingShowTime.setFilm(updateShowTime.getFilm());
            existingShowTime.setRoom(updateShowTime.getRoom());
            existingShowTime.setScreeningFormat(updateShowTime.getScreeningFormat());
            existingShowTime.setLanguage(updateShowTime.getLanguage());
            existingShowTime.setScreeningType(updateShowTime.getScreeningType());
            existingShowTime.setStatus(updateShowTime.getStatus());
            existingShowTime.setVoucher(updateShowTime.getVoucher());

            return showTimeRepository.save(existingShowTime);
        }

        return null;
    }

    public void deleteShowTime (Long id){
        showTimeRepository.deleteById(id);
    }

}
