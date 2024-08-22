import com.java.tdd.locator.Book;
import com.java.tdd.locator.ExternalISBNDataService;
import com.java.tdd.locator.ExternalISBNDataServiceImpl;
import com.java.tdd.locator.StockManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockManagementTests {

    @Test
    public void canGetACorrectLocatorCode() {
        ExternalISBNDataService dataService = new ExternalISBNDataService() {
            @Override
            public Book lookup(String isbn) {
                return null;
            }
        };
        ExternalISBNDataServiceImpl webService = new ExternalISBNDataServiceImpl();

        String isbn = "0140177396";
        StockManager stockManager = new StockManager();
        stockManager.setWebService(webService);
        stockManager.setDatabaseService(dataService);

        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4", locatorCode);
    }
}
