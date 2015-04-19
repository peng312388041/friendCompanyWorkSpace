package excel;

import jxl.write.WritableSheet;

//每个类就是一个sheet
public class UserSheet {
	String  id;             //保存sheet id
	WritableSheet sheet;    //保存excel实体
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
