package pahana_shop;

import com.pahanabookshop.dao.ItemDao;
import com.pahanabookshop.dao.impl.ItemDaoImpl;
import com.pahanabookshop.model.Item;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ItemDaoTest {

    private static ItemDao itemDao;
    private static int testItemId;

    @BeforeAll
    public static void setup() {
        itemDao = new ItemDaoImpl();
    }

    @Test
    @Order(1)
    public void testAddItem() {
        Item item = new Item(0, "Test Book", 1500.00, 20);
        boolean result = itemDao.addItem(item);

        assertTrue(result, "Item should be added successfully");

        // Retrieve the last inserted item to get its ID
        List<Item> items = itemDao.getAllItems();
        assertFalse(items.isEmpty(), "Item list should not be empty");

        Item lastItem = items.get(items.size() - 1);
        testItemId = lastItem.getItemId();

        assertEquals("Test Book", lastItem.getName(), "Inserted item name should match");
    }

    @Test
    @Order(2)
    public void testGetAllItems() {
        List<Item> items = itemDao.getAllItems();

        assertNotNull(items, "Item list should not be null");
        assertTrue(items.size() > 0, "Item list should have at least one record");
    }

    @Test
    @Order(3)
    public void testUpdateItem() {
        Item item = itemDao.getItemById(testItemId);
        assertNotNull(item, "Item should exist before update");

        item.setName("Updated Book");
        item.setPrice(2000.00);
        item.setStock(15);

        boolean result = itemDao.updateItem(item);
        assertTrue(result, "Item should be updated successfully");

        Item updated = itemDao.getItemById(testItemId);
        assertEquals("Updated Book", updated.getName(), "Updated name should match");
        assertEquals(2000.00, updated.getPrice(), "Updated price should match");
        assertEquals(15, updated.getStock(), "Updated stock should match");
    }

    @Test
    @Order(4)
    public void testDeleteItem() {
        boolean result = itemDao.deleteItem(testItemId);
        assertTrue(result, "Item should be deleted successfully");

        Item deleted = itemDao.getItemById(testItemId);
        assertNull(deleted, "Item should no longer exist");
    }
}
