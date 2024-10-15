package com.dreammovie.unit_test.chaircategory;

import com.dreammovie.chaircategory.ChairCategory;
import com.dreammovie.chaircategory.ChairCategoryRepository;
import com.dreammovie.chaircategory.ChairCategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ChairCategoryServiceTest {

    @Mock
    private ChairCategoryRepository chairCategoryRepository;

    @InjectMocks
    private ChairCategoryService chairCategoryService;

    private ChairCategory chairCategory;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Khởi tạo các mock

        // Tạo dữ liệu giả để test
        chairCategory = new ChairCategory(1L, "Chair A", "Description A", BigDecimal.valueOf(100), 10);
    }

    @Test
    void testGetChairCategoryById() {
        when(chairCategoryRepository.findById(anyLong())).thenReturn(Optional.of(chairCategory));

        Optional<ChairCategory> result = chairCategoryService.getChairCategoryById(1L);

        assertTrue(result.isPresent());
        assertEquals("Chair A", result.get().getName());
        verify(chairCategoryRepository, times(1)).findById(anyLong());
    }

    @Test
    void testAddChairCategory() {
        when(chairCategoryRepository.save(any(ChairCategory.class))).thenReturn(chairCategory);

        ChairCategory result = chairCategoryService.addChairCategory(chairCategory);

        assertNotNull(result);
        assertEquals("Chair A", result.getName());
        verify(chairCategoryRepository, times(1)).save(any(ChairCategory.class));
    }

    @Test
    void testUpdateChairCategory() {
        when(chairCategoryRepository.findById(anyLong())).thenReturn(Optional.of(chairCategory));
        when(chairCategoryRepository.save(any(ChairCategory.class))).thenReturn(chairCategory);

        ChairCategory updatedCategory = new ChairCategory(1L, "Updated Chair", "Updated Description", BigDecimal.valueOf(200), 15);
        ChairCategory result = chairCategoryService.updateChairCategory(1L, updatedCategory);

        assertNotNull(result);
        assertEquals("Updated Chair", result.getName());
        verify(chairCategoryRepository, times(1)).save(any(ChairCategory.class));
    }

    @Test
    void testSoftDeleteChairCategory() {
        // Giả lập việc tìm thấy đối tượng ChairCategory với ID tương ứng
        when(chairCategoryRepository.findById(anyLong())).thenReturn(Optional.of(chairCategory));
        when(chairCategoryRepository.save(any(ChairCategory.class))).thenReturn(chairCategory);

        // Gọi phương thức softDeleteChairCategory
        chairCategoryService.softDeleteChairCategory(1L);
        // Kiểm tra repository đã gọi đúng phương thức save để cập nhật trạng thái soft delete
        verify(chairCategoryRepository, times(1)).save(any(ChairCategory.class));
    }

    @Test
    void testAddChairCategoryInService() {
        // Tạo đối tượng mới để test
        ChairCategory newCategory = new ChairCategory();
        newCategory.setName("Ghế VIP");
        newCategory.setDescription("Loại ghế cao cấp");
        newCategory.setPrice(new BigDecimal("200000"));
        newCategory.setSeatCount(50);
        // Giả lập hành vi của repository
        when(chairCategoryRepository.save(any(ChairCategory.class))).thenReturn(newCategory);

        // Gọi phương thức trong service để thêm loại ghế
        ChairCategory savedCategory = chairCategoryService.addChairCategory(newCategory);

        // Kiểm tra kết quả
        assertNotNull(savedCategory);
        assertEquals("Ghế VIP", savedCategory.getName());
        verify(chairCategoryRepository, times(1)).save(any(ChairCategory.class));
    }

}
