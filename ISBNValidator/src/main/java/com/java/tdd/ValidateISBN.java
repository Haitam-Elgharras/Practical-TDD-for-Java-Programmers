package com.java.tdd;

public class ValidateISBN {
    public boolean checkISBN(String ISBN) {
        int total = 0;

        if (ISBN.length()==13) {
            for (int i =0; i < 13; i++) {
                if (i % 2 == 0) total+=Character.getNumericValue(ISBN.charAt(i));
                else total+=Character.getNumericValue(ISBN.charAt(i))*3;
            }
            return total % 10 == 0;
        }

        if (ISBN.length() != 10)
            throw new NumberFormatException("An ISBN must be 10 digits long!");

        for (int i = 0; i < 10; i++) {
            if(!Character.isDigit(ISBN.charAt(i)) && (i != 9 || ISBN.charAt(i) != 'X' ))
                throw new NumberFormatException("The ISBN must be a valid numeric value!");

            if (i == 9 && ISBN.charAt(i) == 'X') {
                total += 10;
                break;
            }

            total += Character.getNumericValue(ISBN.charAt(i)) * (10 - i);
        }
        return total % 11 == 0;
    }

}
