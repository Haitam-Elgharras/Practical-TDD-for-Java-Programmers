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
    private ExternalISBNDataService databaseService;
    private StockManager stockManager;

    @BeforeEach
    public void setUp() {
        isbn = "0140177396";
        webService = mock(ExternalISBNDataService.class);
        databaseService = mock(ExternalISBNDataService.class);
        stockManager = new StockManager(databaseService, webService);
    }


    @Test
    public void canGetACorrectLocatorCode() {
        /*
        The line when(dataService.lookup(isbn)).thenReturn(null);
        was removed from the canGetACorrectLocatorCode test method because it was unnecessary
        for the test to pass. The UnnecessaryStubbingException occurs when there are stubbings
        that are not used during the test execution. In this case, the stubbing for dataService.
        lookup(isbn) was not needed for the canGetACorrectLocatorCode test method.
         */
        when(webService.lookup(isbn)).thenReturn(new Book(isbn, "Of Mice And Men", "J. Steinbeck"));

        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4", locatorCode);
    }

    @Test
    public void databaseIsUsedIfDataIsPresent() {

        when(databaseService.lookup(isbn)).thenReturn(new Book(isbn, "Of Mice And Men", "J. Steinbeck"));

        stockManager.getLocatorCode(isbn);

        verify(databaseService, times(1)).lookup(isbn);
        verify(webService, never()).lookup(anyString());
    }

    @Test
    public void webServiceIsUsedIfDataIsNotPresentInDatabase() {

        when(webService.lookup(isbn)).thenReturn(new Book(isbn, "Of Mice And Men", "J. Steinbeck"));

        stockManager.getLocatorCode(isbn);

        verify(databaseService, times(1)).lookup(isbn);
        verify(webService, times(1)).lookup(isbn);
    }
}
