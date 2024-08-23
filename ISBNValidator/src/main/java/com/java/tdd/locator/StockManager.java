package com.java.tdd.locator;

public class StockManager {
    private ExternalISBNDataService databaseService;
    private ExternalISBNDataService webService;

    public StockManager(ExternalISBNDataService databaseService, ExternalISBNDataService webService) {
        this.webService = webService;
        this.databaseService = databaseService;
    }

    public String getLocatorCode(String isbn) {
        Book book = databaseService.lookup(isbn);
        if (book == null) book = webService.lookup(isbn);
        StringBuilder locator = new StringBuilder();
        locator.append(isbn.substring(isbn.length() - 4));
        locator.append(book.getAuthor().charAt(0));
        locator.append(book.getTitle().split(" ").length);
        return locator.toString();
    }
}
