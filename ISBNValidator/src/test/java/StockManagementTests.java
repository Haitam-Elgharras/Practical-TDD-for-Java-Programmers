import com.java.tdd.locator.Book;
import com.java.tdd.locator.ExternalISBNDataService;
import com.java.tdd.locator.StockManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StockManagementTests {

    private String isbn;
    private ExternalISBNDataService webService;
    private ExternalISBNDataService dataService;
    private StockManager stockManager;


    @BeforeEach
    public void setUp() {
        isbn = "0140177396";
        webService = mock(ExternalISBNDataService.class);
        dataService = mock(ExternalISBNDataService.class);
        stockManager = new StockManager();
    }

    @Test
    public void canGetACorrectLocatorCode() {

        when(dataService.lookup(isbn)).thenReturn(null);
        when(webService.lookup(isbn)).thenReturn(new Book(isbn, "Of Mice And Men", "J. Steinbeck"));

        stockManager.setWebService(webService);
        stockManager.setDatabaseService(dataService);

        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4", locatorCode);
    }

    @Test
    public void databaseIsUsedIfDataIsPresent() {

        when(dataService.lookup(isbn)).thenReturn(new Book(isbn, "Of Mice And Men", "J. Steinbeck"));
        when(webService.lookup(isbn)).thenReturn(new Book(isbn, "Of Mice And Men", "J. Steinbeck"));

        stockManager.setWebService(webService);
        stockManager.setDatabaseService(dataService);

        stockManager.getLocatorCode(isbn);

        verify(dataService, times(1)).lookup(isbn);
        verify(webService, never()).lookup(anyString());
    }

    @Test
    public void webServiceIsUsedIfDataIsNotPresentInDatabase() {

        when(dataService.lookup(isbn)).thenReturn(null);
        when(webService.lookup(isbn)).thenReturn(new Book(isbn, "Of Mice And Men", "J. Steinbeck"));

        stockManager.setWebService(webService);
        stockManager.setDatabaseService(dataService);

        stockManager.getLocatorCode(isbn);

        verify(dataService, times(1)).lookup(isbn);
        verify(webService, times(1)).lookup(isbn);
    }
}
