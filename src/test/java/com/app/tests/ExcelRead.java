package com.app.tests;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelRead {

	public static void main(String[] args) throws Exception {

		String filePath = "/Users/imac/Desktop/Employees.xlsx";

		FileInputStream inStream = new FileInputStream(filePath);

		Workbook workbook = WorkbookFactory.create(inStream);

		Sheet worksheet = workbook.getSheetAt(0);

		Row row = worksheet.getRow(0);
		
		Cell cell = row.getCell(0);

		System.out.println(cell.toString());

		// find out how many rows in Excel sheet
		int rowsCount = worksheet.getPhysicalNumberOfRows();         // or anoyher way - int rowsCount = worksheet.getLastRowNum();

		System.out.println(" number of rows: " + rowsCount);

		for (int rowNum = 1; rowNum < rowsCount; rowNum++) {
			
			row = worksheet.getRow(rowNum);
			cell = row.getCell(0);
			System.out.println(rowNum + " - " + cell);

		}

		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			
			Row eachRow = worksheet.getRow(i);
			
			if (eachRow.getCell(0).toString().equals("Emma")) {
				
				// print job id from same row
				System.out.println(eachRow.getCell(2).toString());
				break;
			}
		}

		
		workbook.close();
		inStream.close();
		
		

		

	}
	
	
}
