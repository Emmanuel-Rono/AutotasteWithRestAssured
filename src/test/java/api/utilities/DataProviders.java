package api.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "Data")
	public Object[][] getAllData() throws IOException {
	    String path = System.getProperty("user.dir") + "\\testData\\tesData01.xlsx";
	    XLUtility xlutil = new XLUtility(path);

	    int totalRows = xlutil.getRowCount("Sheet1");
	    int totalCols = xlutil.getCellCount("Sheet1", 1);

	    List<Object[]> dataList = new ArrayList<>();

	    for (int i = 1; i <= totalRows; i++) { 
	        String firstCell = xlutil.getCellData("Sheet1", i, 0);
	        
	        if (firstCell == null || firstCell.trim().isEmpty()) {
	            System.out.println("Skipping empty row: " + i);
	            continue; // Skip empty rows
	        }

	        Object[] rowData = new Object[totalCols];

	        // ✅ Convert userID (Column 0) to Integer safely
	        try {
	            rowData[0] = firstCell.trim(); // Keep as String (convert later in the test method)
	        } catch (NumberFormatException e) {
	            System.out.println("Error converting userID to integer at row: " + i);
	            continue; // Skip the row if conversion fails
	        }

	        // ✅ Store the remaining columns as Strings
	        for (int j = 1; j < totalCols; j++) {
	            rowData[j] = xlutil.getCellData("Sheet1", i, j);
	        }

	        dataList.add(rowData);
	    }

	    return dataList.toArray(new Object[0][]); // Convert List<Object[]> to Object[][]
	}

}
	        

	      
	
