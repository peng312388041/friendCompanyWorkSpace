package com.e6mall.utils;

import java.io.File;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.apache.commons.lang.time.DateFormatUtils;

public class FileSupport {
	@SuppressWarnings("unchecked")
	public ArrayList GetAllFileByDir(File d, String defaultdir) {
		final ArrayList<UpFile> arrayList = new ArrayList<UpFile>();
		File[] list = d.listFiles();
		for (int i = 0; i < list.length; i++) {
			UpFile dofile = new UpFile();
			dofile.setName(list[i].getName());
			dofile.setDir(list[i].isDirectory());
			dofile.setFile(list[i].isFile());
			dofile.setHidden(list[i].isHidden());

			// 计算文件大小
			String length = "";
			BigDecimal flength = new BigDecimal(Double.toString(list[i].length())); // 文件大小
			BigDecimal b1 = new BigDecimal(Double.toString(1024)); // KB
			BigDecimal b2 = new BigDecimal(Double.toString(1048576)); // MB
			BigDecimal b3 = new BigDecimal(Double.toString(1073741824)); // GB

			double f1 = flength.divide(b1, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
			double f2 = flength.divide(b2, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
			double f3 = flength.divide(b3, 2, BigDecimal.ROUND_HALF_UP).doubleValue();

			if (f2 < 1) {
				length = f1 + " KB";
			} else if (f3 < 1) {
				length = f2 + " MB";
			} else {
				length = f3 + " GB";
			}

			dofile.setLength(length);
			dofile.setLastedit(DateFormatUtils.ISO_DATETIME_FORMAT.format(new Date(list[i].lastModified())).toString());
			
			if (list[i].isFile())
				dofile.setFiletype("1");
			if (list[i].isDirectory())
				dofile.setFiletype("2");
			
			dofile.setParentfile(list[i].getParent().replace("\\", "/").replace(defaultdir, ""));		//换掉反斜线为正斜线，再将父目录中的默认路径部分去掉
			dofile.setPath(d.getAbsolutePath().replace("\\", "/").replace(defaultdir, ""));

			arrayList.add(dofile);
		}
		// 按文件/文件夹类型排序
		Comparator OrderType = new Comparator() {
			public int compare(Object o1, Object o2) {
				UpFile b1 = (UpFile) o1;
				UpFile b2 = (UpFile) o2;
				return (b2.getFiletype().hashCode() - b1.getFiletype()
						.hashCode());
			}
		};
		Collections.sort(arrayList, OrderType);
		
		return arrayList;
	}
	
	public UpFile GetDofileByDir(String dir) {
		UpFile dofile = new UpFile();
		
		return dofile;
	}
	
	public boolean DofileRename(String newfilename) {
		
		return true;
	}
	
	public static boolean deleteFolder(File delFolder) {
        //目录是否已删除 
        boolean hasDeleted = true; 
        //得到该文件夹下的所有文件夹和文件数组 
        File[] allFiles = delFolder.listFiles(); 
        
        for (int i = 0; i < allFiles.length; i++) { 
              //为true时操作 
              if (hasDeleted) { 
         if (allFiles[i].isDirectory()) { 
                      //如果为文件夹,则递归调用删除文件夹的方法 
             hasDeleted = deleteFolder(allFiles[i]); 
         } else if (allFiles[i].isFile()) { 
             try {//删除文件 
                  if (!allFiles[i].delete()) { 
                               //删除失败,返回false 
                  hasDeleted = false; 
                  } 
              } catch (Exception e) { 
                             //异常,返回false 
                    hasDeleted = false; 
              } 
         } 
              } else { 
                   //为false,跳出循环 
          break; 
              } 
         } 
         if (hasDeleted) { 
                //该文件夹已为空文件夹,删除它 
                delFolder.delete(); 
         } 
         return hasDeleted; 
    }
}
