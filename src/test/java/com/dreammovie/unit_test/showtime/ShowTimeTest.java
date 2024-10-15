package com.dreammovie.unit_test.showtime;

import com.dreammovie.cinema.Cinema;
import com.dreammovie.films.Film;
import com.dreammovie.language.Language;
import com.dreammovie.room.Room;
import com.dreammovie.screeningformat.ScreeningFormat;
import com.dreammovie.screeningtype.ScreeningType;
import com.dreammovie.showtime.ShowTime;
import com.dreammovie.showtime.ShowTimeRepository;
import com.dreammovie.showtime.ShowTimeService;
import com.dreammovie.voucher.Voucher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShowTimeTest {

    @Mock
    private ShowTimeRepository showTimeRepository;

    @InjectMocks
    private ShowTimeService showTimeService;

    private ShowTime showTime;

    @BeforeEach
    void setUp() {
        // Initialize mock objects for dependencies
        MockitoAnnotations.openMocks(this);

        // Mock associated entities with necessary constructor parameters
        Film film = new Film(1L, "Example Film Title", "Example Description", 120, "Director Name", LocalDate.of(2023, 1, 1));
        Cinema cinema = new Cinema(1L, "Example Cinema", "123 Cinema Street", "Example City", "0123456789", "example@cinema.com");
        Room room = new Room(1L, "Room 1", 100, cinema); // Assuming a room belongs to a cinema
        ScreeningFormat screeningFormat = new ScreeningFormat(1L, "IMAX", "High-quality visual format");

        // Additional associated entities
        Language language = new Language(1L, "English", "EN");
        ScreeningType screeningType = new ScreeningType(1L, "3D", "3D format");
        Voucher voucher = null; // Optionally mock voucher if necessary

        // Create a ShowTime instance with the above mock data
        showTime = new ShowTime(
                1L,                             // ShowTime ID
                film,                           // Associated Film
                LocalDateTime.now(),            // Current Date and Time for ShowTime
                cinema,                         // Associated Cinema
                room,                           // Room in Cinema
                screeningFormat,                // Screening Format (e.g., IMAX)
                language,                       // Language of the ShowTime
                screeningType,                  // Screening Type (e.g., 3D)
                "Active",                       // ShowTime Status
                voucher                         // Optional Voucher (can be null)
        );
    }

//    @Test
//    void testAddShowTime() {
//        when(showTimeRepository.save(any(ShowTime.class))).thenReturn(showTime);
//
//        ShowTime result = showTimeService.addShowTime(showTime);
//
//        assertNotNull(result);
//        assertEquals("Chair A", result.getName());
//        verify(showTimeRepository, times(1)).save(any(ShowTime.class));
//    }


    @Test
    void testAddShowTimeInService() {
        // Mock các đối tượng liên quan
        Film film = new Film(1L, "Test Film", "Test Description", 120, "Test Director", LocalDate.of(2023, 1, 1));
        Cinema cinema = new Cinema(1L, "Test Cinema", "123 Test Street", "Test City", "0123456789", "test@cinema.com");
        Room room = new Room(1L, "Room 1", 100, cinema);
        ScreeningFormat screeningFormat = new ScreeningFormat(1L, "IMAX", "High-quality visual format");
        Language language = new Language(1L, "English", "EN");
        ScreeningType screeningType = new ScreeningType(1L, "3D", "3D format");
        Voucher voucher = null; // Không áp dụng voucher

        // Tạo một ShowTime mới
        ShowTime newShowTime = new ShowTime();
        newShowTime.setFilm(film);
        newShowTime.setStart_time(LocalDateTime.now());
        newShowTime.setCinema(cinema);
        newShowTime.setRoom(room);
        newShowTime.setScreeningFormat(screeningFormat);
        newShowTime.setLanguage(language);
        newShowTime.setScreeningType(screeningType);
        newShowTime.setStatus("Active");
        newShowTime.setVoucher(voucher);

        // Giả lập hành vi của repository
        when(showTimeRepository.save(any(ShowTime.class))).thenReturn(newShowTime);

        // Gọi phương thức addShowTime trong service
        ShowTime savedShowTime = showTimeService.addShowTime(newShowTime);

        // Kiểm tra kết quả
        assertNotNull(savedShowTime);
        assertEquals("Active", savedShowTime.getStatus());
        assertEquals(film, savedShowTime.getFilm());
        assertEquals(cinema, savedShowTime.getCinema());
        assertEquals(room, savedShowTime.getRoom());
        assertEquals(screeningFormat, savedShowTime.getScreeningFormat());
        assertEquals(language, savedShowTime.getLanguage());
        assertEquals(screeningType, savedShowTime.getScreeningType());

        // Xác minh rằng phương thức save của repository được gọi đúng 1 lần
        verify(showTimeRepository, times(1)).save(any(ShowTime.class));
    }

}
