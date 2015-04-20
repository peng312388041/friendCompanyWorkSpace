//ʵ����Ʒsheet�Ľ����ʹ洢����
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

		// Դ�ļ�
		String sourceFile = "D:/source.xls";
		Workbook sourceWorkbook = UserExcel.createReadWorkbook(sourceFile);
		// Ŀ���ļ�
		String targetFile = "D:/target.xls";
		WritableWorkbook targetWorkbook = UserExcel
				.createWriteWorkbook(targetFile);

		// �������� С���� id
		Set<String> set = new HashSet<>();
		for (int i = 1; i < 4; i++) {
			Sheet sheet = sourceWorkbook.getSheet(i);
			for (Cell cell : sheet.getColumn(7)) {
				set.add(cell.getContents());
			}
		}

		// �������д�������sheet
		int sheetOrder = 0;
		for (String string : set) {
			targetWorkbook.createSheet(string, sheetOrder);
			sheetOrder++;
		}
		// Ϊ����С����id����sheet

		for (int i = 1; i < 4; i++) {
			Sheet sheet = sourceWorkbook.getSheet(i);
			for (int j = 0; j < sheet.getRows(); j++) {
				// j��ʾ����ǰ��j��
				Cell rows[] = sheet.getRow(j);
				String sheetName = rows[7].getContents();
				// ���Ҵ����������¼��sheet
				WritableSheet targetSheet = targetWorkbook.getSheet(sheetName);
				// ����ǰӛ䛲��뵽Ŀ��sheet��
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
