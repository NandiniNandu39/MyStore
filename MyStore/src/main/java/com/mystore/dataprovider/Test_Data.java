package com.mystore.dataprovider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;

public class Test_Data extends BaseClass {

   @Test
   public static Object singleRowMapData(String filePath, String sheetName, String uniqueId, String key) throws IOException {
       Map<String, String> mapCreation = new LinkedHashMap<>();
       FileInputStream file = new FileInputStream(filePath);
       Workbook workbook = new XSSFWorkbook(file);
       Sheet sheet = workbook.getSheet(sheetName);

       CellAddress address = findCellAddress(sheet, uniqueId);
       if (address == null) {
           throw new IllegalArgumentException("Unique ID not found in the sheet");
       }

       int rowNumber = address.getRow();
       int columnNumber = sheet.getRow(rowNumber).getPhysicalNumberOfCells();
       for (int i = 0; i < columnNumber; i++) {
           String header = getCellValueAsString(sheet.getRow(rowNumber - 1).getCell(i));
           String value = getCellValueAsString(sheet.getRow(rowNumber).getCell(i));
           mapCreation.put(header, value);
       }

       workbook.close();
       file.close();

       return mapCreation.get(key);
   }

   private static CellAddress findCellAddress(Sheet sheet, String uniqueValue) {
       for (Row row : sheet) {
           for (Cell cell : row) {
               if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().equals(uniqueValue)) {
                   return cell.getAddress();
               }
           }
       }
       return null;
   }

   private static String getCellValueAsString(Cell cell) {
       if (cell == null) {
           return "";
       }

       switch (cell.getCellType()) {
           case STRING:
               return cell.getStringCellValue();
           case NUMERIC:
               if (DateUtil.isCellDateFormatted(cell)) {
                   return cell.getDateCellValue().toString();
               } else {
                   return String.valueOf(cell.getNumericCellValue());
               }
           case BOOLEAN:
               return String.valueOf(cell.getBooleanCellValue());
           case FORMULA:
               return cell.getCellFormula();
           case BLANK:
               return "";
           default:
               return "Unknown Cell Type";
       }
   }
}
