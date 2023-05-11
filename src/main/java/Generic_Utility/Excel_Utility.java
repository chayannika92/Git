package Generic_Utility;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility 
{
		
		public String getExcelData(String Sheet, int rowNum,int cellNum ) throws Throwable

		{
			FileInputStream fes = new FileInputStream("C:\\Users\\chaya\\Downloads\\TestData.xlsx");
			Workbook book = WorkbookFactory.create(fes);
			Sheet sh = book.getSheet(Sheet);
			Row row = sh.getRow(rowNum);
			Cell cel = row.getCell(cellNum);
			String Data = cel.getStringCellValue();
			
			return Data;
			
		}
		
		public String getExcelUsingDataFormatter(String Sheet, int rowNum,int cellNum ) throws Throwable
		{
			FileInputStream fes = new FileInputStream("C:\\Users\\chaya\\Downloads\\TestData.xlsx");
			Workbook book = WorkbookFactory.create(fes);
			DataFormatter format = new DataFormatter();
			String ExcelData = format.formatCellValue(book.getSheet(Sheet).getRow(rowNum).getCell(cellNum));
			return ExcelData;
		}
		
		
		public Object[][] readMultipleData(String SheetName) throws Throwable
		{
			FileInputStream fis1 = new FileInputStream("C:\\Users\\chaya\\OneDrive\\Documents\\ExcelSheet.xlsx");
			Workbook book = WorkbookFactory.create(fis1);
			Sheet sh = book.getSheet(SheetName);
			int lastRow = sh.getLastRowNum()+1;
			int lastCell = sh.getRow(0).getLastCellNum();
			
			
			Object[][] obj = new Object[lastRow][lastCell];
			for(int i = 0;i<lastRow;i++)
			{
				for(int j = 0;j<lastCell;j++)
				{
					obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
				}
			}
			return obj;
			
		}
	}


