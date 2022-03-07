/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author ruang
 */
public class excelExport {

    private static final List<String> COLUMNS = new ArrayList<String>();
    private static final List<String> CELLDATA = new ArrayList<String>();
    private static final List<Integer> CELLCOLUMNS = new ArrayList<Integer>();
    private static final Scanner SC = new Scanner(System.in);
    private static String filename;
    private static String sheetname;
    private static String columnname;
    private static String celldata;

    public static void main(String[] args) {
        executeExport();
    }

    private static void executeExport() {

        try {
            getFilename();
            getSheetname();
            addColumns();
            addCells();
            System.out.println("celldata: " + CELLDATA);
            generateExport();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void getFilename() {
        System.out.println("Enter the name for the excel file");
        filename = SC.nextLine();

        if (filename.isEmpty()) {
            getFilename();
        }
    }

    private static void getSheetname() {
        System.out.println("Enter the name for the excel sheet");
        sheetname = SC.nextLine();

        if (sheetname.isEmpty()) {
            getSheetname();
        }
    }

    private static void addColumns() {

        try {
            System.out.println("Add a column? Y/N");
            String yn = SC.nextLine();

            if (yn.equalsIgnoreCase("y") || yn.equalsIgnoreCase("yes")) {
                getColumnname();
                COLUMNS.add(columnname);
                addColumns();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void getColumnname() {
        System.out.println("Enter the column name");
        columnname = SC.nextLine();

        if (columnname.isEmpty()) {
            getColumnname();
        }
    }

    private static void addCells() {

        try {
            System.out.println("Add cell data? Y/N");
            String yn = SC.nextLine();

            if (yn.equalsIgnoreCase("y") || yn.equalsIgnoreCase("yes")) {
                getCelldata();
                CELLDATA.add(celldata);
                addCells();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void getCelldata() {
        System.out.println("Enter the cell data");
        celldata = SC.nextLine();

        if (celldata.isEmpty()) {
            getCelldata();
        }

        getCellColumn();
    }

    private static void getCellColumn() {
        System.out.println("Enter the column of the cell data");
        String column = SC.nextLine();

        if (column.isEmpty()) {
            getCellColumn();
        }

        int rec = 0;
        for (int i = 0; i < COLUMNS.size(); i++) {
            if (column.equals(COLUMNS.get(i))) {
                CELLCOLUMNS.add(i);
                rec++;
            }
        }

        if (rec == 0) {
            System.out.println("Column not found...");
            getCellColumn();
        }
    }

    private static void generateExport() {
        System.out.println("Creating excel workbook...");

        try {
            Workbook wb = new HSSFWorkbook();
            Sheet sheet = wb.createSheet(sheetname);
            Row headerRow = sheet.createRow(0);

            System.out.println("Setting headers...");
            for (int i = 0; i < COLUMNS.size(); i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(COLUMNS.get(i));
            }

            Row row;
            int rowNumber = 1;
            for (int i = 0; i < CELLDATA.size(); i++) {
                row = sheet.createRow(rowNumber++);
                //logic problem
                for (String s : CELLDATA) {
                    System.out.println(">>>>s: " + s);
                    System.out.println("CELLCOLUMNS.get(i)).setCellValue(s): " + CELLCOLUMNS.get(i) + s);
                    row.createCell(CELLCOLUMNS.get(i)).setCellValue(s);
                    i++;
                }
            }

            String indexDrive = System.getProperty("user.dir");
            String fileName = filename + ".xls";
            FileOutputStream fsOut = new FileOutputStream(indexDrive + "\\Excel Exports\\" + fileName);

            wb.write(fsOut);
            fsOut.close();

            File file = new File(indexDrive + "\\Excel Exports\\" + fileName);
            System.out.println("File = " + file);
            InputStream streamIn = new FileInputStream(file);
            int contentLength = (int) file.length();
            ByteArrayOutputStream tempOutput;

            if (contentLength != -1) {
                tempOutput = new ByteArrayOutputStream(contentLength);
            } else {
                tempOutput = new ByteArrayOutputStream(20480);
            }

            byte[] buffer = new byte[512];
            System.out.println("File downloading");

            while (true) {
                int readFile = streamIn.read(buffer);
                if (readFile == -1) {
                    break;
                }

                tempOutput.write(buffer, 0, readFile);
            }
            streamIn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
