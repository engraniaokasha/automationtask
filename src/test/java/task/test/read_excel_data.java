/*package task.test;
import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFEvaluationWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class read_excel_data {
	
	public String[][]readsheet() throws InvalidFormatException, IOException {
		
		File myfile =new File(".\\testdata\\data.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(myfile);
		XSSFSheet mysheet=wb.getSheet("sheet1");
		int num_of_rows=mysheet.getPhysicalNumberOfRows();
		int num_of_cols=mysheet.getRow(0).getLastCellNum();
		String[][]myarray=new String[num_of_rows-1][num_of_cols];
		for (int i=1 ;i<num_of_rows;i++) {
			for(int a =0;a<num_of_cols;a++) {
				
				XSSFRow row = mysheet.getRow(i);
						myarray[i-1][a]=row.getCell(a).getStringCellValue();
			}
			
		}
		return myarray;
	}

}*/

