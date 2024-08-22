package com.java.tdd.locator;

public class ExternalISBNDataServiceImpl implements ExternalISBNDataService{
    public Book lookup(String isbn) {
        return new Book(isbn, "Of Mice And Men", "J. Steinbeck");
    }
}
