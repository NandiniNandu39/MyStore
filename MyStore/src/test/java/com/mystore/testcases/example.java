package com.mystore.testcases;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.mystore.dataprovider.Test_Data1;

public class example {
    @Test
    public void mainTest() throws IOException { // Renamed method to follow TestNG convention
        String filePath = "C:\\Users\\User\\Downloads\\MyStore_TestData.xlsx";
        String sheetName = "MyStore";
        String uniqueId = "TC002";

        // Create an instance of Test_Data1
        Test_Data1 testData = new Test_Data1();

        // Load the data with all parameters and get commonData
        Map<String, String> commonData = Test_Data1.loadData(filePath, sheetName, uniqueId);
        System.out.println("Loaded commonData: " + commonData);

        if (commonData != null) {
            // Optionally, retrieve specific values using key
            String key = "Enter_Account_Details";
            String value = Test_Data1.getValueByKey(commonData, "Enter_Account_Details");
            System.out.println("Value for key 'Enter_Account_Details': " + value);

            value = Test_Data1.getValueByKey(commonData, "Gender");
            System.out.println("Value for key 'Gender': " + value);
            
            // Write data back to the Excel file
            String newHeader = "New_Header";
            String newData = "New_Data";
            boolean vertical = false;
            Test_Data1.writeData(filePath, sheetName, uniqueId, newHeader, newData, vertical);
        } else {
            System.out.println("No common data found.");
        }
    }
}