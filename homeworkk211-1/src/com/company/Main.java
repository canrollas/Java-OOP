package com.company;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        CsvReader Reader3 = new CsvReader("src/com/company/L3_Books.csv");
        System.out.println(Arrays.deepToString(Reader3.getArray()));
    }
}
