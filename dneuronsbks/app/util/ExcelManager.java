package util;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager {
	
	
	public XSSFWorkbook createExcel(String sheetname, Map<String, Map<String, Map<String, String>>> data){
		//create workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		//Create a blank sheet
        XSSFSheet sheet = workbook.createSheet(sheetname);
        int rownum = 1;
        for(Entry<String, Map<String, Map<String, String>>> group : data.entrySet()){
        	System.out.println(group.getKey()+"-----");
        	
        	for(Entry<String,Map<String,String>> subgroup : group.getValue().entrySet()){
        		
        		for(Entry<String,String> accounttype : subgroup.getValue().entrySet()){
        			int cellnum = 0;
        			
        			if(rownum == 1 ){
        				Row row = sheet.createRow(0);
        				row.createCell(cellnum++).setCellValue("No");
        				row.createCell(cellnum++).setCellValue("Group");
        				row.createCell(cellnum++).setCellValue("Sub-Group");
        				row.createCell(cellnum++).setCellValue("Account Type");
        				row.createCell(cellnum++).setCellValue("Amount");
        				Row row1 = sheet.createRow(rownum);
        				cellnum = 0;
        				row1.createCell(cellnum++).setCellValue(rownum);
        				row1.createCell(cellnum++).setCellValue(group.getKey());
        				row1.createCell(cellnum++).setCellValue(subgroup.getKey());
        				row1.createCell(cellnum++).setCellValue(accounttype.getKey());
        				row1.createCell(cellnum++).setCellValue(accounttype.getValue());
        				
        			}else{
        				Row row1 = sheet.createRow(rownum);
        				row1.createCell(cellnum++).setCellValue(rownum);
        				row1.createCell(cellnum++).setCellValue(group.getKey());
        				row1.createCell(cellnum++).setCellValue(subgroup.getKey());
        				row1.createCell(cellnum++).setCellValue(accounttype.getKey());
        				row1.createCell(cellnum++).setCellValue(accounttype.getValue());
        			}
        			rownum++;
        		}
        		
        		
        	}
        	
        }
        
        return workbook;
	}

}
