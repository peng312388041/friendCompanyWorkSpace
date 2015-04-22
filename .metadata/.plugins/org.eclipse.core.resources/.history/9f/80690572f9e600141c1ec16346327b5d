package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class UserExcel {
	// 源文件
	private static Workbook sourceWorkbook = null;
	// 目标文件
	private static WritableWorkbook targetWorkbook = null;

	private static IndexSheet bigSheet;
	private static List<IndexSheet> middleSheetList;
	private static List<IndexSheet> littleSheetList;
	private static List<GoodsSheet> goodsSheetList;

	// 可考虑改为泛型
	public static IndexSheet findIndexSheetById(
			List<IndexSheet> indexsheetList, String id) {
		IndexSheet sheet = null;
		for (IndexSheet i : indexsheetList)
			if (id.equals(i.getSheetId())) {
				sheet = i;
			}
		return sheet;
	}

	public static GoodsSheet findGoosSheetById(List<GoodsSheet> goodsSheetList,
			String id) {
		GoodsSheet sheet = null;
		for (GoodsSheet i : goodsSheetList)
			if (id.equals(i.getSheetId())) {
				sheet = i;
			}
		return sheet;
	}

	public static Workbook getSourceWorkbook() {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File("D:/source2.xls"));
			sourceWorkbook = Workbook.getWorkbook(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sourceWorkbook;
	}

	public static WritableWorkbook getTargetWorkbook() {
		OutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(new File("D:/target.xls"));
			targetWorkbook = Workbook.createWorkbook(outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		targetWorkbook.setProtected(true);
		return targetWorkbook;
	}

	public static List<String> getSetLittle(Workbook sourceWorkbook) {
		Set<String> setLittle = new HashSet<>();
		for (int i = 1; i < 4; i++) {
			Sheet sheet = sourceWorkbook.getSheet(i);
			for (Cell cell : sheet.getColumn(7)) {
				setLittle.add(cell.getContents());
			}
		}

		String string[] = setLittle.toArray(new String[] {});
		Arrays.sort(string);
		List<String> listLittle = new ArrayList<String>(Arrays.asList(string));
		listLittle.remove(listLittle.size() - 1);
		return listLittle;
	}

	public static List<String> getSetMiddle(Workbook sourceWorkbook) {
		Set<String> setMiddle = new HashSet<>();
		for (int i = 1; i < 4; i++) {
			Sheet sheet = sourceWorkbook.getSheet(i);
			for (Cell cell : sheet.getColumn(5)) {
				setMiddle.add(cell.getContents());
			}
		}

		String string[] = setMiddle.toArray(new String[] {});
		Arrays.sort(string);
		List<String> listMiddle = new ArrayList<String>(Arrays.asList(string));
		listMiddle.remove(listMiddle.size() - 1);
		return listMiddle;
	}

	public static List<String> getSetBig(Workbook sourceWorkbook) {
		Set<String> setBig = new HashSet<>();
		for (int i = 1; i < 4; i++) {
			Sheet sheet = sourceWorkbook.getSheet(i);
			for (Cell cell : sheet.getColumn(3)) {
				setBig.add(cell.getContents());
			}
		}

		String string[] = setBig.toArray(new String[] {});
		Arrays.sort(string);
		List<String> listBig = new ArrayList<String>(Arrays.asList(string));
		listBig.remove(listBig.size() - 1);
		return listBig;
	}

	public static void createSheets(WritableWorkbook targetWorkbook,
			Workbook sourceWorkbook) throws IOException, WriteException {
		int sheetOrder = 0;

		// 创建大分类表
		bigSheet = new IndexSheet();
		bigSheet.setSheetEntity(targetWorkbook.createSheet("00", sheetOrder++));
		bigSheet.setSheetId("00");
		// 创建所有中分类表
		middleSheetList = new ArrayList<>();

		for (String string : getSetBig(sourceWorkbook)) {
			IndexSheet middleSheet = new IndexSheet();
			middleSheet.setSheetEntity(targetWorkbook.createSheet(string,
					sheetOrder++));
			middleSheet.setSheetId(string);
			middleSheetList.add(middleSheet);
		}

		// 创建所有小分类表
		littleSheetList = new ArrayList<>();
		for (String string : getSetMiddle(sourceWorkbook)) {
			IndexSheet littleSheet = new IndexSheet();
			littleSheet.setSheetEntity(targetWorkbook.createSheet(string,
					sheetOrder++));
			littleSheet.setSheetId(string);
			littleSheetList.add(littleSheet);
		}

		// 创建所有商品类表
		goodsSheetList = new ArrayList<>();
		for (String string : getSetLittle(sourceWorkbook)) {
			GoodsSheet goodsSheet = new GoodsSheet();
			goodsSheet.setSheetEntity(targetWorkbook.createSheet(string,
					sheetOrder++));
			goodsSheet.setSheetId(string);
			goodsSheetList.add(goodsSheet);
		}
	}

	public static void fillIndexSheet(IndexSheet sheet)
			throws RowsExceededException, WriteException, IOException

	{
		WritableSheet targetSheet = targetWorkbook.getSheet(sheet.getSheetId());
		for (int i = 0; i < sheet.getDatas().size(); i++) {
			IndexSheetData data = sheet.getDatas().get(i);
			WritableCell cellNumber = new Label(0, i + 3, i + 1 + "");
			WritableCell cellCode = new Label(1, i + 3, data.getCode());
			WritableCell cellName = new Label(2, i + 3, data.getName());
			targetSheet.addCell(cellCode);
			targetSheet.addCell(cellNumber);
			targetSheet.addCell(cellName);
		}
	}

	public static void fillGoodsSheet(GoodsSheet sheet)
			throws RowsExceededException, WriteException, IOException

	{
		WritableSheet targetSheet = targetWorkbook.getSheet(sheet.getSheetId());
		for (int i = 0; i < sheet.getGoodsdatas().size(); i++) {
			GoodsSheetData data = sheet.getGoodsdatas().get(i);
			WritableCell cellA = new Label(0, i + 3, data.getA());
			WritableCell cellB = new Label(1, i + 3, data.getB());
			WritableCell cellC = new Label(2, i + 3, data.getC());
			WritableCell cellD = new Label(3, i + 3, data.getD());
			WritableCell cellE = new Label(4, i + 3, data.getE());
			WritableCell cellF = new Label(5, i + 3, data.getF());
			WritableCell cellG = new Label(6, i + 3, data.getG());
			WritableCell cellH = new Label(7, i + 3, data.getH());
			WritableCell cellI = new Label(8, i + 3, data.getI());
			WritableCell cellJ = new Label(9, i + 3, data.getJ());
			WritableCell cellK = new Label(10, i + 3, data.getK());
			WritableCell cellL = new Label(11, i + 3, data.getL());
			WritableCell cellM = new Label(12, i + 3, data.getM());
			WritableCell cellN = new Label(13, i + 3, data.getN());
			WritableCell cellO = new Label(14, i + 3, data.getO());
			WritableCell cellP = new Label(15, i + 3, data.getP());
			WritableCell cellQ = new Label(16, i + 3, data.getQ());
			targetSheet.addCell(cellA);
			targetSheet.addCell(cellB);
			targetSheet.addCell(cellC);
			targetSheet.addCell(cellD);
			targetSheet.addCell(cellE);
			targetSheet.addCell(cellF);
			targetSheet.addCell(cellG);
			targetSheet.addCell(cellH);
			targetSheet.addCell(cellI);
			targetSheet.addCell(cellJ);
			targetSheet.addCell(cellK);
			targetSheet.addCell(cellL);
			targetSheet.addCell(cellM);
			targetSheet.addCell(cellN);
			targetSheet.addCell(cellO);
			targetSheet.addCell(cellP);
			targetSheet.addCell(cellQ);

		}
	}

	public static void initSheets(WritableWorkbook targetWorkbook)
			throws IOException, WriteException {
		// 对所有sheet进行遍历
		for (int i = 1; i < 4; i++) {
			Sheet sourceSheet = sourceWorkbook.getSheet(i);
			// 对每一行进行遍历
			for (int j = 1; j < sourceSheet.getRows(); j++) {
				Cell row[] = sourceSheet.getRow(j);
				String bigId = row[3].getContents();
				String middleId = row[5].getContents();
				String littleId = row[7].getContents();

				// 对大分类表进行初始化
				if (bigSheet.getAllCodes().indexOf(bigId) == -1) {
					List<IndexSheetData> datas = bigSheet.getDatas();
					String bigCode = row[3].getContents();
					String bigName = row[4].getContents();
					IndexSheetData data = new IndexSheetData();
					data.setName(bigName);
					data.setCode(bigCode);
					datas.add(data);
					bigSheet.setDatas(datas);
				}

				// 对中分类表进行初始化
				IndexSheet middleSheet = findIndexSheetById(middleSheetList,
						bigId);
				if (middleSheet.getAllCodes().indexOf(middleId) == -1) {
					List<IndexSheetData> datas = middleSheet.getDatas();

					String bigCode = row[5].getContents();
					String bigName = row[6].getContents();

					IndexSheetData data = new IndexSheetData();
					data.setName(bigName);
					data.setCode(bigCode);
					datas.add(data);
					middleSheet.setDatas(datas);
				}

				// 对小分类表进行初始化
				IndexSheet littleSheet = findIndexSheetById(littleSheetList,
						middleId);
				if (littleSheet.getAllCodes().indexOf(littleId) == -1) {
					List<IndexSheetData> datas = littleSheet.getDatas();

					String bigCode = row[7].getContents();
					String bigName = row[8].getContents();

					IndexSheetData data = new IndexSheetData();
					data.setName(bigName);
					data.setCode(bigCode);
					datas.add(data);
					littleSheet.setDatas(datas);
				}

				// 对商品表进行初始化
				GoodsSheet goodsSheet = findGoosSheetById(goodsSheetList,
						littleId);

				List<GoodsSheetData> datas = goodsSheet.getGoodsdatas();

				GoodsSheetData data = new GoodsSheetData();

				data.setA(row[0].getContents());
				data.setB(row[1].getContents());
				data.setC(row[2].getContents());
				data.setD(row[3].getContents());
				data.setE(row[4].getContents());
				data.setF(row[5].getContents());
				data.setG(row[6].getContents());
				data.setH(row[7].getContents());
				data.setI(row[8].getContents());
				data.setJ(row[9].getContents());
				data.setK(row[10].getContents());
				data.setL(row[11].getContents());
				data.setM(row[12].getContents());
				data.setN(row[13].getContents());
				data.setO(row[14].getContents());
				data.setP(row[15].getContents());
				data.setQ(row[16].getContents());

				datas.add(data);
				goodsSheet.setGoodsdatas(datas);

			}
		}
		Collections.sort(bigSheet.getDatas(), new DataComparator());

		fillIndexSheet(bigSheet);
		for (IndexSheet sheet : middleSheetList) {
			Collections.sort(sheet.getDatas(), new DataComparator());
			fillIndexSheet(sheet);
		}
		for (IndexSheet sheet : littleSheetList) {
			Collections.sort(sheet.getDatas(), new DataComparator());
			fillIndexSheet(sheet);
		}

		for (GoodsSheet sheet : goodsSheetList) {
			fillGoodsSheet(sheet);
		}
	}
}
