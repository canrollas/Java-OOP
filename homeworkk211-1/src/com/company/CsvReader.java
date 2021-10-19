package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CsvReader {
    // Creating the constructor method of the CSV
    private String[][] Library1 = new String[20][7];
    private String[][] Library2 = new String[10][7];
    private String[][] Library3 = new String[13][7];
    private String[][] L1Issues = new String[30][5];
    private String[][] L2Issues = new String[30][5];
    private String[][] L3Issues = new String[17][5];
    private String[][] Members = new String[5][3];
    private String returnerString = "";

    /*

     * In this class basically constructor reads the 3 of the csv if there is necessary .

     */

    public CsvReader(String pathToCsv) {
        switch (pathToCsv) {
            case "src/com/company/L1_Books.csv":
                this.addToArray(Library1, pathToCsv);
                returnerString = "Library1";
                break;
            case "src/com/company/L2_Books.csv":
                this.addToArray(Library2, pathToCsv);
                returnerString = "Library2";
                break;
            case "src/com/company/L3_Books.csv":
                this.addToArray(Library3, pathToCsv);
                returnerString = "Library3";
                break;
            case "src/com/company/L1_Issues.csv":
                this.addToArray(L1Issues, pathToCsv);
                returnerString = "L1_Issues";
                break;
            case "src/com/company/L2_Issues.csv":
                this.addToArray(L2Issues, pathToCsv);
                returnerString = "L2_Issues";
                break;
            case "src/com/company/L3_Issues.csv":
                this.addToArray(L3Issues, pathToCsv);
                returnerString = "L3_Issues";
                break;
            case "src/com/company/Members.csv":
                this.addToArray(Members, pathToCsv);
                returnerString = "Members";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + pathToCsv);
        }


    }

    private void addToArray(String[][] StringArray, String pathToCsv) {
        try {
            // File object init.
            File myObj = new File(pathToCsv);
            // Scanner object init
            Scanner myReader = new Scanner(myObj);
            // Looping over the lines with boolean condition if reader object has next line to iterate.
            int counter = 0;
            while (myReader.hasNextLine()) {
                // String object for console out stream
                String data = myReader.nextLine();
                String[] emptyStringArray = data.split(",");
                StringArray[counter] = emptyStringArray;
                // assign array in to spesific counter position
                counter++;
            }
            myReader.close();
            // Closing the reader and assign values of other variables as null for garbage collector can cleans it.

        } catch (IOException e) {
            System.out.println("Error occured (IO Exception)");
            e.printStackTrace();
        }
    }

    public String[][] getArray() {
        if (returnerString.equals("Library3")){
            return Library3;
        }
        else if (returnerString.equals("Library2")){
            return Library2;
        }
        else if (returnerString.equals("Library1")){
            return Library1;
        }
        else if (returnerString.equals("L1Issues")){
            return L1Issues;
        }
        else if (returnerString.equals("L2Issues")){
            return L2Issues;
        }
        else if (returnerString.equals("L3Issues")){
            return L3Issues;
        }
        else if (returnerString.equals("Members")){
            return Members;
        }
        return new String[0][0];
    }



}
