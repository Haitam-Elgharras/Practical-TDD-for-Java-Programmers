import com.java.tdd.locator.Book;
import com.java.tdd.locator.ExternalISBNDataService;
import com.java.tdd.locator.StockManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StockManagementTests {

    @Test
    public void canGetACorrectLocatorCode() {
        String isbn = "0140177396";

        ExternalISBNDataService dataService = mock(ExternalISBNDataService.class);
        when(dataService.lookup(isbn)).thenReturn(null);

        ExternalISBNDataService webService = mock(ExternalISBNDataService.class);
        when(webService.lookup(isbn)).thenReturn(new Book(isbn, "Of Mice And Men", "J. Steinbeck"));


        StockManager stockManager = new StockManager();
        stockManager.setWebService(webService);
        stockManager.setDatabaseService(dataService);

        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4", locatorCode);
    }

    @Test
    public void databaseIsUsedIfDataIsPresent() {
        String isbn = "0140177396";

        ExternalISBNDataService dataService = mock(ExternalISBNDataService.class);
        when(dataService.lookup(isbn)).thenReturn(new Book(isbn, "Of Mice And Men", "J. Steinbeck"));

        ExternalISBNDataService webService = mock(ExternalISBNDataService.class);
        when(webService.lookup(isbn)).thenReturn(new Book(isbn, "Of Mice And Men", "J. Steinbeck"));

        StockManager stockManager = new StockManager();
        stockManager.setWebService(webService);
        stockManager.setDatabaseService(dataService);

        stockManager.getLocatorCode(isbn);

        verify(dataService, times(1)).lookup(isbn);
        verify(webService, never()).lookup(anyString());
    }

    @Test
    public void webServiceIsUsedIfDataIsNotPresentInDatabase() {
        String isbn = "0140177396";

        ExternalISBNDataService dataService = mock(ExternalISBNDataService.class);
        when(dataService.lookup(isbn)).thenReturn(null);

        ExternalISBNDataService webService = mock(ExternalISBNDataService.class);
        when(webService.lookup(isbn)).thenReturn(new Book(isbn, "Of Mice And Men", "J. Steinbeck"));

        StockManager stockManager = new StockManager();
        stockManager.setWebService(webService);
        stockManager.setDatabaseService(dataService);

        stockManager.getLocatorCode(isbn);

        verify(dataService, times(1)).lookup(isbn);
        verify(webService, times(1)).lookup(isbn);
    }
}
