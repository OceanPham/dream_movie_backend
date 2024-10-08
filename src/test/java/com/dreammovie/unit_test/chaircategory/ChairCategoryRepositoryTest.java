package com.dreammovie.unit_test.chaircategory;

import com.dreammovie.chaircategory.ChairCategory;
import com.dreammovie.chaircategory.ChairCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class ChairCategoryRepositoryTest {

    @Autowired
    private ChairCategoryRepository chairCategoryRepository;

    private ChairCategory chairCategory;

    @BeforeEach
    void setUp() {
        chairCategoryRepository.deleteAll(); // Xóa sạch dữ liệu cũ

        // Khởi tạo và lưu dữ liệu kiểm thử
        ChairCategory chairCategory = new ChairCategory();
        chairCategory.setName("VIP Chair");
        chairCategory.setDescription("Comfortable chair with VIP features");
        chairCategory.setPrice(new BigDecimal("199.99"));
        chairCategory.setSeatCount(2);
        chairCategoryRepository.save(chairCategory);
    }


    @Test
    void testFindByDeletedAtIsNull() {
        List<ChairCategory> categories = chairCategoryRepository.findByDeletedAtIsNull();
        assertFalse(categories.isEmpty());
        assertEquals(1, categories.size());
    }

    @Test
    public void testFindById() {
        ChairCategory chairCategory = new ChairCategory();
        chairCategory.setName("VIP Chair");
        chairCategory.setDescription("Comfortable chair with VIP features");
        chairCategory.setPrice(new BigDecimal("199.99"));
        chairCategory.setSeatCount(2);
        chairCategory = chairCategoryRepository.save(chairCategory); // Lưu và lấy lại đối tượng với ID được sinh ra

        Optional<ChairCategory> foundCategory = chairCategoryRepository.findById(chairCategory.getId());
        assertTrue(foundCategory.isPresent(), "Chair Category should be found by ID");
    }


    @Test
    void testAddChairCategoryToRepository() {
        // Tạo một đối tượng ChairCategory mới
        ChairCategory newCategory = new ChairCategory();
        newCategory.setName("Ghế VIP");
        newCategory.setDescription("Loại ghế cao cấp");
        newCategory.setPrice(new BigDecimal("200000"));
        newCategory.setSeatCount(50);

        // Gọi phương thức save từ repository để lưu đối tượng
        ChairCategory savedCategory = chairCategoryRepository.save(newCategory);

        // Kiểm tra kết quả
        assertNotNull(savedCategory.getId());  // Kiểm tra xem ID đã được tạo
        assertEquals("Ghế VIP", savedCategory.getName());  // Kiểm tra tên đúng
    }


}
