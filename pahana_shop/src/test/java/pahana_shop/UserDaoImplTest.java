package pahana_shop;


import com.pahanabookshop.model.User;
import com.pahanabookshop.dao.impl.UserDaoImpl;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoImplTest {

    private UserDaoImpl userDao;

    @BeforeEach
    void setUp() {
        userDao = new UserDaoImpl();
    }

    @Test
    void testAddUser() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password123");
        user.setRole("staff");

        boolean result = userDao.addUser(user);
        assertTrue(result, "User should be added successfully");
    }


    @Test
    void testDeleteUser() {
        // Add user first
        User user = new User();
        user.setUsername("deleteuser");
        user.setPassword("pass");
        user.setRole("staff");
        userDao.addUser(user);

        // Assuming we know the ID (replace with actual fetch in real test)
        int userId = 15; 

        boolean result = userDao.deleteUser(userId);
        assertTrue(result, "User should be deleted successfully");
    }
}
