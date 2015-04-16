package com.e6mall.action.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.struts2.ServletActionContext;

import com.e6mall.utils.FileSupport;
import com.e6mall.utils.UpFile;

public class FilesAction extends BaseUploadAction {
	private static final long serialVersionUID = 5335025035891496013L;
	
	private String pardir = "";//父路径
	private UpFile curfile = new UpFile();
	private ArrayList arrayList;//所有目录及文件列表
	
	private String CKEditor;
	private String CKEditorFuncNum;
	private String langCode;

	public String execute() throws Exception {
		String uploaddir = "upload";
		String ruploaddir = ServletActionContext.getServletContext().getRealPath(uploaddir);
		ruploaddir = ruploaddir.replace("\\", "/");
		String currentdir = "";
		if (pardir != null && !pardir.equals("") && !StringUtils.contains(pardir, ".")) {
			currentdir = ruploaddir + "/" + pardir;
		} else {
			currentdir = ruploaddir + "/";
		}
		
		File d = new File(currentdir);
		if (!d.exists() && !d.isDirectory()) {
			d.mkdir();//文件或者目录不存在
		} else {
			if (d.isDirectory()) {
				curfile.setName(d.getName());
				if (d.getParent().replace("\\", "/").contains(ruploaddir))
					curfile.setParentfile(d.getParent().replace("\\", "/").replace(ruploaddir, ""));
				else
					curfile.setParentfile("");
				curfile.setLastedit(DateFormatUtils.ISO_DATETIME_FORMAT.format(new Date(d.lastModified())).toString());
				arrayList = new FileSupport().GetAllFileByDir(d, ruploaddir);
			} else {
				fileDownload(response, ruploaddir + "/" + pardir, d.getName());
			}
		}
		return SUCCESS;
	}
	
	public String uploadFile() throws Exception {
		upload();
		return SUCCESS;
	}
	
	public String fileDownload(HttpServletResponse response, String filepath, String filename) throws Exception {
		response.reset();
		response.setContentType("application/x-download");// 设置为下载application/x-download
		String filenamedownload = filepath;
		String filenamedisplay = filename;
		filenamedisplay = URLEncoder.encode(filenamedisplay, "UTF-8");
		response.addHeader("Content-Disposition", "attachment;filename="
				+ filenamedisplay);

		OutputStream output = null; // 输出流写文件
		FileInputStream fis = null; // 文件输入流读文件
		try {
			output = response.getOutputStream();
			fis = new FileInputStream(filenamedownload);
			byte[] b = new byte[1024]; // 字节数组
			int i = 0;
			while ((i = fis.read(b)) > 0) {
				output.write(b, 0, i);
			}
			output.flush(); // 清空缓冲区
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 关闭流
			if (fis != null) {
				fis.close();
				fis = null;
			}
			if (output != null) {
				output.close();
				output = null;
			}
		}
		return null;
	}

	public String getPardir() {
		return pardir;
	}

	public void setPardir(String pardir) {
		this.pardir = pardir;
	}

	public UpFile getCurfile() {
		return curfile;
	}

	public void setCurfile(UpFile curfile) {
		this.curfile = curfile;
	}

	public ArrayList getArrayList() {
		return arrayList;
	}

	public void setArrayList(ArrayList arrayList) {
		this.arrayList = arrayList;
	}

	public String getCKEditor() {
		return CKEditor;
	}

	public void setCKEditor(String cKEditor) {
		CKEditor = cKEditor;
	}

	public String getCKEditorFuncNum() {
		return CKEditorFuncNum;
	}

	public void setCKEditorFuncNum(String cKEditorFuncNum) {
		CKEditorFuncNum = cKEditorFuncNum;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}
}
