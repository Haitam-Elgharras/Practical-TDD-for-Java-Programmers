package com.java.tdd.isbnValidator;

public class ValidateISBN {

    private static final int LONG_ISBN = 13;
    private static final int SHORT_ISBN = 10;
    private static final int LONG_ISBN_MULTIPLIER = 10;
    private static final int SHORT_ISBN_MULTIPLIER = 11;

    public boolean checkISBN(String ISBN) {
        if (ISBN.length()== LONG_ISBN)
            return isAValidLongISBN(ISBN);

        if (ISBN.length()== SHORT_ISBN)
            return isAValidShortISBN(ISBN);

        throw new NumberFormatException("An ISBN must be 10 or 13 digits long!");
    }

    private static boolean isAValidShortISBN(String ISBN) {
        int total = 0;
        for (int i = 0; i < SHORT_ISBN; i++) {
            char currentChar = ISBN.charAt(i);

            if (!Character.isDigit(currentChar) && (i != 9 || currentChar != 'X')) {
                System.out.println(i);
                throw new NumberFormatException("The ISBN must be a valid numeric value!");
            }

            if (i == 9 && currentChar == 'X')
                total += SHORT_ISBN;
            else
                total += Character.getNumericValue(currentChar) * (SHORT_ISBN - i);
        }
        return total % SHORT_ISBN_MULTIPLIER == 0;
    }

    private boolean isAValidLongISBN(String ISBN) {
        int total = 0;

        for (int i = 0; i < LONG_ISBN; i++) {
            if (!Character.isDigit(ISBN.charAt(i)))
                throw new NumberFormatException("The ISBN must be a valid numeric value!");

            if (i % 2 == 0) total +=Character.getNumericValue(ISBN.charAt(i));
            else total +=Character.getNumericValue(ISBN.charAt(i))*3;
        }
        return total % LONG_ISBN_MULTIPLIER == 0;
    }

}
