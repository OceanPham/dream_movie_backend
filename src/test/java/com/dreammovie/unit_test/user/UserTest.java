package com.dreammovie.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllActiveUsers() {
        // Arrange: mock the repository to return a list of active users (i.e., users with `deletedAt` as null)
        User user1 = new User();
        user1.setId(1L);
        user1.setFull_name("User 1");
        user1.setDeletedAt(null);  // This user is active

        User user2 = new User();
        user2.setId(2L);
        user2.setFull_name("User 2");
        user2.setDeletedAt(null);  // This user is active

        List<User> activeUsers = Arrays.asList(user1, user2);

        // When `userRepository.findByDeletedAtIsNull()` is called, we want it to return the activeUsers list
        when(userRepository.findByDeletedAtIsNull()).thenReturn(activeUsers);

        // Act: call the method we want to test
        List<User> result = userService.getAllActiveUsers();

        // Assert: verify the result and interaction with the repository
        assertEquals(2, result.size());
        assertEquals("User 1", result.get(0).getFull_name());
        assertEquals("User 2", result.get(1).getFull_name());

        // Verify that the repository's findByDeletedAtIsNull method was called exactly once
        verify(userRepository, times(1)).findByDeletedAtIsNull();
    }
}
