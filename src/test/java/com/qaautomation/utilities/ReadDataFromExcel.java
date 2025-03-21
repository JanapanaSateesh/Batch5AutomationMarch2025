package com.qaautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public static String[][] getData(String filepath,String sheetname) throws IOException {
		// TODO Auto-generated method stub

		File file=new File(filepath);
		FileInputStream fi=new FileInputStream(file);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fi);
		XSSFSheet sheet=workbook.getSheet(sheetname);
		int rows=sheet.getPhysicalNumberOfRows();//3
		int cols=sheet.getRow(0).getLastCellNum();//4
		System.out.println(rows);
		System.out.println(cols);
		
		String[][] data=new String[rows-1][cols]; //2,4
		for(int i=0;i<rows-1;i++) //0
		{
			
			for(int j=0;j<cols;j++) //0
			{
				DataFormatter dt=new DataFormatter();
				data[i][j]= dt.formatCellValue(sheet.getRow(i+1).getCell(j));
				//System.out.println(data[i][j]);
			}
		}
		return data;
		
		
	}
}
