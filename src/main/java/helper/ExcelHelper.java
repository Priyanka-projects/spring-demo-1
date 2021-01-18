package helper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Employee;

public class ExcelHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	  static String[] HEADERs = { "name", "email", "phone","address","hireDate","bDate" };
	  static String SHEET = "Sheet1";
	  
	  
	  public static boolean hasExcelFormat(MultipartFile file) {

		    if (!TYPE.equals(file.getContentType())) {
		      return false;
		    }

		    return true;
		  }
	  
	  public static List<Employee> excelToList(InputStream is) {
		    try {
		      Workbook workbook = new XSSFWorkbook(is);

		      Sheet sheet = workbook.getSheet(SHEET);
		      Iterator<Row> rows = sheet.iterator();

		      List<Employee> employeeis = new ArrayList<Employee>();

		      int rowNumber = 0;
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }

		        Iterator<Cell> cellsInRow = currentRow.iterator();

		        Employee employee = new Employee();

		        int cellIdx = 0;
		        while (cellsInRow.hasNext()) {
		          Cell currentCell = cellsInRow.next();

		          switch (cellIdx) {
		          case 0:
		            employee.setName(currentCell.getStringCellValue());
		            break;

		          case 1:
		            employee.setEmail(currentCell.getStringCellValue());
		            break;

		          case 2:
		            employee.setPhone(currentCell.getStringCellValue());
		            break;

		          case 3:
		            employee.setAddress(currentCell.getStringCellValue());
		            break;
		            
		          case 4:
		        	  employee.setHireDate(currentCell.getDateCellValue());
		        	  break;
		          case 5:
		        	  employee.setbDate(currentCell.getDateCellValue());
		        	  break;

		          default:
		            break;
		          }

		          cellIdx++;
		        }

		        employeeis.add(employee);
		      }

		      workbook.close();

		      return employeeis;
		    } catch (IOException e) {
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }
		  }
		
}
