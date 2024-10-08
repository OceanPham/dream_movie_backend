package com.dreammovie.unit_test.chaircategory;

import com.dreammovie.chaircategory.ChairCategory;
import com.dreammovie.chaircategory.ChairCategoryController;
import com.dreammovie.chaircategory.ChairCategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ChairCategoryControllerTest {

    @Mock
    private ChairCategoryService chairCategoryService;

    @InjectMocks
    private ChairCategoryController chairCategoryController;

    private ChairCategory chairCategory;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Khởi tạo các mock

        // Tạo dữ liệu giả để test
        chairCategory = new ChairCategory(1L, "Chair A", "Description A", BigDecimal.valueOf(100), 10);
    }

    @Test
    void testGetAllChairCategory() {
        when(chairCategoryService.getAllActiveChairCategories()).thenReturn(Arrays.asList(chairCategory));

        var result = chairCategoryController.getAllChairCategory();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(chairCategoryService, times(1)).getAllActiveChairCategories();
    }

    @Test
    void testGetChairCategoryById_Found() {
        when(chairCategoryService.getChairCategoryById(1L)).thenReturn(Optional.of(chairCategory));

        ResponseEntity<ChairCategory> response = chairCategoryController.getChairCategoryById(1L);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(chairCategory, response.getBody());
    }

    @Test
    void testGetChairCategoryById_NotFound() {
        when(chairCategoryService.getChairCategoryById(2L)).thenReturn(Optional.empty());

        ResponseEntity<ChairCategory> response = chairCategoryController.getChairCategoryById(2L);

        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());
        assertNull(response.getBody());
    }

    @Test
    void testAddChairCategory() {
        when(chairCategoryService.addChairCategory(any(ChairCategory.class))).thenReturn(chairCategory);

        ChairCategory result = chairCategoryController.addChairCategory(chairCategory);

        assertNotNull(result);
        assertEquals("Chair A", result.getName());
        verify(chairCategoryService, times(1)).addChairCategory(any(ChairCategory.class));
    }

    @Test
    void testUpdateChairCategory() {
        when(chairCategoryService.updateChairCategory(anyLong(), any(ChairCategory.class))).thenReturn(chairCategory);

        ResponseEntity<ChairCategory> result = chairCategoryController.updateChairCategory(1L, chairCategory);

        assertEquals(200, result.getStatusCodeValue());
        assertNotNull(result.getBody());
        assertEquals("Chair A", result.getBody().getName());
    }

    @Test
    void testDeleteChairCategory() {
        doNothing().when(chairCategoryService).softDeleteChairCategory(anyLong());

        ResponseEntity<Void> result = chairCategoryController.deleteChairCategory(1L);

        assertEquals(200, result.getStatusCodeValue());
        verify(chairCategoryService, times(1)).softDeleteChairCategory(anyLong());
    }

    @Test
    void testAddChairCategoryInController() {
        // Tạo đối tượng JSON mô phỏng request body
        ChairCategory newCategory = new ChairCategory();
        newCategory.setName("Ghế VIP");
        newCategory.setDescription("Loại ghế cao cấp");
        newCategory.setPrice(new BigDecimal("200000"));
        newCategory.setSeatCount(50);

        // Giả lập hành vi của service
        when(chairCategoryService.addChairCategory(any(ChairCategory.class))).thenReturn(newCategory);

        // Thực hiện gọi controller và nhận kết quả trả về trực tiếp là một đối tượng ChairCategory
        ChairCategory result = chairCategoryController.addChairCategory(newCategory);

        // Kiểm tra kết quả trả về từ controller
        assertNotNull(result);  // Kiểm tra không null
        assertEquals("Ghế VIP", result.getName());  // Kiểm tra giá trị trả về
    }

}
