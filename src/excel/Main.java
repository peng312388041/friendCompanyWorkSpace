//实现商品sheet的建立和存储数据
package excel;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Main {

	public static void main(String[] args) throws BiffException, IOException,
			RowsExceededException, WriteException {

		// 源文件
		String sourceFile = "D:/source.xls";
		Workbook sourceWorkbook = UserExcel.createReadWorkbook(sourceFile);
		// 目标文件
		String targetFile = "D:/target.xls";
		WritableWorkbook targetWorkbook = UserExcel
				.createWriteWorkbook(targetFile);

		// 保存所有 小分类 id
		Set<String> set = new HashSet<>();
		for (int i = 1; i < 4; i++) {
			Sheet sheet = sourceWorkbook.getSheet(i);
			for (Cell cell : sheet.getColumn(7)) {
				set.add(cell.getContents());
			}
		}

		// 保存所有待创建的sheet
		int sheetOrder = 0;
		for (String string : set) {
			targetWorkbook.createSheet(string, sheetOrder);
			sheetOrder++;
		}
		// 为所有小分类id创建sheet

		for (int i = 1; i < 4; i++) {
			Sheet sheet = sourceWorkbook.getSheet(i);
			for (int j = 0; j < sheet.getRows(); j++) {
				// j表示处理当前第j行
				Cell rows[] = sheet.getRow(j);
				String sheetName = rows[7].getContents();
				// 查找待即将插入记录的sheet
				WritableSheet targetSheet = targetWorkbook.getSheet(sheetName);
				// 將當前記錄插入到目標sheet中
				int targetRow = targetSheet.getRows();
				for (int Column = 0; Column < rows.length; Column++) {
					WritableCell labelCell = new Label(Column, targetRow,
							rows[Column].getContents());
					targetSheet.addCell(labelCell);

				}
			}
		}

		targetWorkbook.write();
		targetWorkbook.close();


	}
}
