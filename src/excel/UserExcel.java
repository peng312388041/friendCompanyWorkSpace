package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class UserExcel {
	public static Workbook createReadWorkbook(String fileName) {
		InputStream inputStream = null;
		Workbook workbook = null;

		try {
			inputStream = new FileInputStream(new File(fileName));
			workbook = Workbook.getWorkbook(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workbook;
	}

	public static WritableWorkbook createWriteWorkbook(String fileName) {
		OutputStream outputStream = null;
		WritableWorkbook workbook = null;
		try {
			outputStream = new FileOutputStream(new File(fileName));
			workbook = Workbook.createWorkbook(outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		workbook.setProtected(true);
		return workbook;
	}

}
