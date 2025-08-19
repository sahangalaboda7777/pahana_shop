package pahana_shop;
import com.pahanabookshop.dao.CustomerDao;
import com.pahanabookshop.dao.impl.CustomerDaoImpl;
import com.pahanabookshop.model.Customer;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerDaoTest {

    private static CustomerDao customerDao;
    private static String testAccountNo;

    @BeforeAll
    public static void setup() {
        customerDao = new CustomerDaoImpl();
    }

    @Test
    @Order(1)
    public void testAddCustomer() {
        Customer customer = new Customer(null, "Test User", "123 Test Street", "0771234567");
        boolean result = customerDao.addCustomer(customer);

        assertTrue(result, "Customer should be added successfully");
        assertNotNull(customer.getAccountNo(), "Generated account number should not be null");

        // Save for later tests
        testAccountNo = customer.getAccountNo();
    }


    @Test
    @Order(2)
    public void testGetAllCustomers() {
        List<Customer> customers = customerDao.getAllCustomers();

        assertNotNull(customers, "Customer list should not be null");
        assertTrue(customers.size() > 0, "Customer list should contain at least one record");
    }

    @Test
    @Order(3)
    public void testUpdateCustomer() {
        Customer customer = customerDao.getCustomerByAccountNo(testAccountNo);
        assertNotNull(customer, "Customer should exist before update");

        customer.setName("Updated User");
        customer.setAddress("456 Updated Street");
        customer.setPhone("0712345678");

        boolean result = customerDao.updateCustomer(customer);
        assertTrue(result, "Customer should be updated");

        Customer updated = customerDao.getCustomerByAccountNo(testAccountNo);
        assertEquals("Updated User", updated.getName(), "Updated name should match");
        assertEquals("456 Updated Street", updated.getAddress(), "Updated address should match");
        assertEquals("0712345678", updated.getPhone(), "Updated phone should match");
    }

    @Test
    @Order(4)
    public void testDeleteCustomer() {
        boolean result = customerDao.deleteCustomer(testAccountNo);
        assertTrue(result, "Customer should be deleted");

        Customer deleted = customerDao.getCustomerByAccountNo(testAccountNo);
        assertNull(deleted, "Customer should no longer exist");
    }
}
