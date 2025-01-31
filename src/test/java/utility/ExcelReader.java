package utility;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    XSSFWorkbook wb;
    public ExcelReader(){

        File file = new File("./TestData/testinput.xlsx");

        try{
            FileInputStream fis = new FileInputStream(file);
            wb = new XSSFWorkbook(fis);

        }
        catch(IOException e){
            System.out.println("No File Present "+e.getMessage());
        }

    }

    public String getStringValue(String sheetName, int row, int column){
        return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }

    public int getIntegerValue(String sheetName, int row, int column){
        return (int)wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
    }

    public long getLongValue(String sheetName, int row, int column){
        return (long)wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
    }
}
