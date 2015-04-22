//此版本已经 实现建立sheet，并存入数据
package excel;

import java.io.IOException;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Main {

	public static void main(String[] args) throws BiffException, IOException,
			RowsExceededException, WriteException {

		long begin = System.currentTimeMillis();
		System.out.println();
		// 源book
		Workbook sourceWorkbook = UserExcel.getSourceWorkbook();
		// 目标book
		WritableWorkbook targetWorkbook = UserExcel.getTargetWorkbook();
		// 所有小分类id

		UserExcel.createSheets(targetWorkbook, sourceWorkbook);
		UserExcel.initSheets(targetWorkbook);
		targetWorkbook.write();
		targetWorkbook.close();
		long end = System.currentTimeMillis();
		System.out.println("共耗时"+(end - begin)/1000+1+"秒");
	}
}
