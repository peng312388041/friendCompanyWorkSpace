package com.e6mall.action.manager;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.e6mall.model.Brand;
import com.e6mall.model.Category;
import com.e6mall.model.Goods;

public class GoodsImportAction extends BaseAction {
	private static final long serialVersionUID = -135523820325289471L;

	private ArrayList list;
	private String c;
	private Category category;
	private File file;										//上传的文件组
	private String fileContentType;							//上传文件组的文件类型
	private String fileFileName;							//上传文件组的文件名称
	private String filepath;								//文件路径
	private int number = 0;		//导入数量
	private String result;		//结果

	public String execute() throws Exception {
		list = scategory.findAllTree();
		return SUCCESS;
	}
	
	public String doimport() throws Exception {
		category = scategory.findById(c);

		if (category != null) {
			HSSFWorkbook workbook = new HSSFWorkbook();
			try {
				workbook = new HSSFWorkbook(new FileInputStream(file.getPath()));
			} catch (Exception e) {
				System.out.println("导入文件时出现异常 : " + e);
			}
			HSSFSheet sheet = workbook.getSheetAt(0);
			HSSFRow row = sheet.getRow(0); // 行，下面的从第2行开始
			for (int k = 1; k <= sheet.getLastRowNum(); k++) {   //从第2行开始
				// String[] cellName = { "商品名称", "编号", "品牌", "简介", "详细介绍",  "单价", "市场价", "重量", "库存", "排序" };
				Goods goods = new Goods();
				goods.setId(getUuid());
				goods.setLocale(category.getLocale());
				try {
					row = sheet.getRow(k);
		
					HSSFCell cell = row.getCell(0); // 单元格		商品名称
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					goods.setName(cell.getStringCellValue());
					
					cell = row.getCell(1); // 单元格				编号
					try {
						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						goods.setSn(cell.getStringCellValue());
					} catch (Exception e) {
						goods.setSn(null);
					}
					
					cell = row.getCell(2); // 单元格				品牌
					try {
						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						Brand brand = sbrand.findByName(cell.getStringCellValue());
						goods.setBrand(brand);
					} catch (Exception e) {
						goods.setBrand(null);
					}
					
					cell = row.getCell(3); // 单元格				简介
					try {
						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						goods.setIntro(cell.getStringCellValue());
					} catch (Exception e) {
						goods.setIntro(null);
					}
		
					cell = row.getCell(4); // 单元格				详细介绍
					try {
						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						goods.setDetails(cell.getStringCellValue());
					} catch (Exception e) {
						goods.setDetails(null);
					}
		
					cell = row.getCell(5); // 单元格				单价
					try {
						cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
						goods.setPrice(cell.getNumericCellValue());
					} catch (Exception e) {
						goods.setPrice(null);
					}
		
					cell = row.getCell(6); // 单元格				市场价
					try {
						cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
						goods.setMprice(cell.getNumericCellValue());
					} catch (Exception e) {
						goods.setMprice(null);
					}
		
					cell = row.getCell(7); // 单元格				重量
					try {
						cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
						goods.setWeight(cell.getNumericCellValue());
					} catch (Exception e) {
						goods.setWeight(0.0);
					}
		
					cell = row.getCell(8); // 单元格				库存
					try {
						cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
						goods.setInventory((int)cell.getNumericCellValue());
					} catch (Exception e) {
						goods.setInventory(null);
					}
					
					cell = row.getCell(10); // 单元格				排序
					try {
						cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
						goods.setCsort((int)cell.getNumericCellValue());
					} catch (Exception e) {
						goods.setCsort(10);
					}
					
					goods.setFreeshipping("no");
					goods.setPromote("no");
					goods.setCtime(getTimestamp());
					goods.setStatus("normal");
					goods.setManager(getAsession());
					goods.setVistor(1);
					goods.setCategory(category);
					
					sgoods.save(goods);
					number++;
				} catch (java.lang.Exception e) {
					System.out.println("某些行导入时发生异常："+e.toString());
					result += "第 "+k+" 行导入失败。<br>";
				}
			}
		}
		
		return SUCCESS;
	}

	public ArrayList getList() {
		return list;
	}

	public void setList(ArrayList list) {
		this.list = list;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
