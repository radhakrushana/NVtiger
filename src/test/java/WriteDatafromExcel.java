import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDatafromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
       
		  FileInputStream fisx = new FileInputStream("src\\test\\resources\\Book6.xlsx");
			
		 Workbook wb = WorkbookFactory.create(fisx);
		 
		 Sheet sh = wb.getSheet("Sheet1");
		 //Sheet sh = wb.createSheet("Sheet2");
		 
		 Row rw = sh.createRow(8);
		 
		 Cell cl = rw.createCell(0);
		 
		 cl.setCellValue("Pune");
		 
		 FileOutputStream fos = new FileOutputStream("src\\test\\resources\\Book6.xlsx");
		 
		 wb.write(fos);
	}

}
