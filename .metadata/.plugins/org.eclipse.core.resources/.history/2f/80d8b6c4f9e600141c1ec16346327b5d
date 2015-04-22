package excel;

import java.util.ArrayList;
import java.util.List;

//每个类就是一个sheet
public class IndexSheet extends BaseSheet {
	List<IndexSheetData> datas = new ArrayList<>();

	public List<IndexSheetData> getDatas() {
		return datas;
	}

	public void setDatas(List<IndexSheetData> indexDatas) {
		this.datas = indexDatas;
	}

	public List<String> getAllCodes() {
		List<String> codesList = new ArrayList<String>();

		for (IndexSheetData data : datas) {
			codesList.add(data.getCode());

		}
		return codesList;
	}

}
