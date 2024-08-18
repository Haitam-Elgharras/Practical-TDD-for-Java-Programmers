package com.java.tdd;

public class ValidateISBN {

    private static final int LONG_ISBN = 13;
    private static final int SHORT_ISBN = 10;
    private static final int LONG_ISBN_MULTIPLIER = 10;
    public static final int SHORT_ISBN_MULTIPLIER = 11;

    public boolean checkISBN(String ISBN) {
        if (ISBN.length()== LONG_ISBN)
            return isAValid13DigitsISBN(ISBN);

        if (ISBN.length() != SHORT_ISBN)
            throw new NumberFormatException("An ISBN must be 10 digits long!");

        return isAValid10DigitsISBN(ISBN);
    }

    private static boolean isAValid10DigitsISBN(String ISBN) {
        int total=0;
        for (int i = 0; i < SHORT_ISBN; i++) {
            if(!Character.isDigit(ISBN.charAt(i)) && (i != 9 || ISBN.charAt(i) != 'X' ))
                throw new NumberFormatException("The ISBN must be a valid numeric value!");

            if (i == 9 && ISBN.charAt(i) == 'X') {
                total += SHORT_ISBN;
                break;
            }
            total += Character.getNumericValue(ISBN.charAt(i)) * (SHORT_ISBN - i);
        }
        return total % SHORT_ISBN_MULTIPLIER == 0;
    }

    private boolean isAValid13DigitsISBN(String ISBN) {
        int total = 0;

        for (int i = 0; i < LONG_ISBN; i++) {
            if (i % 2 == 0) total +=Character.getNumericValue(ISBN.charAt(i));
            else total +=Character.getNumericValue(ISBN.charAt(i))*3;
        }
        return total % LONG_ISBN_MULTIPLIER == 0;
    }

}
