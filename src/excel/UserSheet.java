package excel;

import jxl.write.WritableSheet;

//ÿ�������һ��sheet
public class UserSheet {
	String  id;             //����sheet id
	WritableSheet sheet;    //����excelʵ��
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public WritableSheet getSheet() {
		return sheet;
	}
	public void setSheet(WritableSheet sheet) {
		this.sheet = sheet;
	}
}
