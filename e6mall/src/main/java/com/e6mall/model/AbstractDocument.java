package com.e6mall.model;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.e6mall.utils.SubString;

/**
 * AbstractDocument entity provides the base persistence definition of the
 * Document entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractDocument implements java.io.Serializable {

	// Fields

	private String id;
	private Manager manager;
	private Attachment image;
	private Attachment vimage;//页面显示
	private Locale locale;
	private Doccate doccate;
	private String title;
	private String brief;
	private String subrief;//截取部分字符
	private String content;
	private String marker;
	private Integer vistor;
	private Integer csort;
	private Timestamp cdate;
	private Set chcontents = new HashSet(0);
	private Set attachments = new HashSet(0);
	
	private String subtitle;//截取部分字符
	private Attachment defaultImage;//默认图
	
	private String vdate;
	private String vtime;
	
	public String getVdate() {
		SimpleDateFormat sdf = (SimpleDateFormat)DateFormat.getDateInstance();
		sdf.applyPattern("yyyy-MM-dd");
		vdate = sdf.format(cdate);
		return vdate;
	}
	
	public String getVdate(String format) {
		SimpleDateFormat sdf = (SimpleDateFormat)DateFormat.getDateInstance();
		try {
			sdf.applyPattern(format);
			vdate = sdf.format(cdate);
		} catch (Exception e) {
			sdf.applyPattern("yyyy-MM-dd");
			vdate = sdf.format(cdate);
		}
		return vdate;
	}

	public void setVdate(String vdate) {
		this.vdate = vdate;
	}

	public String getVtime() {
		SimpleDateFormat sdf = (SimpleDateFormat)DateFormat.getTimeInstance();
		sdf.applyPattern("HH:mm:ss");
		vtime = sdf.format(cdate);
		return vtime;
	}
	
	public String getVtime(String format) {
		SimpleDateFormat sdf = (SimpleDateFormat)DateFormat.getTimeInstance();
		try {
			sdf.applyPattern(format);
			vtime = sdf.format(cdate);
		} catch (Exception e) {
			sdf.applyPattern("HH:mm:ss");
			vtime = sdf.format(cdate);
		}
		return vtime;
	}

	public void setVtime(String vtime) {
		this.vtime = vtime;
	}

	// Constructors

	/** default constructor */
	public AbstractDocument() {
	}

	/** minimal constructor */
	public AbstractDocument(String id, String title, String content,
			String marker, Integer vistor, Timestamp cdate) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.marker = marker;
		this.vistor = vistor;
		this.cdate = cdate;
	}

	/** full constructor */
	public AbstractDocument(String id, Manager manager, Attachment image,
			Locale locale, Doccate doccate, String title, String brief,
			String content, String marker, Integer vistor, Integer csort, Timestamp cdate,
			Set chcontents, Set attachments) {
		this.id = id;
		this.manager = manager;
		this.image = image;
		this.locale = locale;
		this.doccate = doccate;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.marker = marker;
		this.vistor = vistor;
		this.csort = csort;
		this.cdate = cdate;
		this.chcontents = chcontents;
		this.attachments = attachments;
	}

	// Property accessors

	public Attachment getDefaultImage() {
		return defaultImage;
	}

	public void setDefaultImage(Attachment defaultImage) {
		this.defaultImage = defaultImage;
	}

	public String getSubtitle() {
		return subtitle;
	}
	
	/**
	 * 截取部分简述内容,不区分中英文,如果数字非偶数,则少取一个字符位
	 * 
	 * @param n 截取长度(一个汉字长度按2算的)
	 * @param ext 后缀
	 * @return 返回的字符串
	 */
	public String getSubtitle(int n, String ext) {
		this.subtitle = SubString.substring(this.title, n, ext);
		return this.subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Manager getManager() {
		return this.manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Attachment getImage() {
		return this.image;
	}

	public void setImage(Attachment image) {
		this.image = image;
	}
	
	public Attachment getVimage() {
		if (null != image) {
			return image;
		} else {
			Attachment i = new Attachment();
			i.setPath("/images/sys");
			i.setName("nopic.jpg");
			return i;
		}
	}

	public void setVimage(Attachment vimage) {
		this.vimage = vimage;
	}

	public Locale getLocale() {
		return this.locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public Doccate getDoccate() {
		return this.doccate;
	}

	public void setDoccate(Doccate doccate) {
		this.doccate = doccate;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return this.brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getSubrief() {
		return this.subrief;
	}
	
	/**
	 * 截取部分简述内容,不区分中英文,如果数字非偶数,则少取一个字符位
	 * 
	 * @param n 截取长度(一个汉字长度按2算的)
	 * @param ext 后缀
	 * @return 返回的字符串
	 */
	public String getSubrief(int n, String ext) {
		this.subrief = SubString.substring(this.brief, n, ext);
		return this.subrief;
	}

	public void setSubrief(String subrief) {
		this.subrief = subrief;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMarker() {
		return this.marker;
	}

	public void setMarker(String marker) {
		this.marker = marker;
	}

	public Integer getVistor() {
		return this.vistor;
	}

	public void setVistor(Integer vistor) {
		this.vistor = vistor;
	}

	public Integer getCsort() {
		return csort;
	}

	public void setCsort(Integer csort) {
		this.csort = csort;
	}

	public Timestamp getCdate() {
		return this.cdate;
	}

	public void setCdate(Timestamp cdate) {
		this.cdate = cdate;
	}

	public Set getChcontents() {
		return this.chcontents;
	}

	public void setChcontents(Set chcontents) {
		this.chcontents = chcontents;
	}

	public Set getAttachments() {
		return attachments;
	}

	public void setAttachments(Set attachments) {
		this.attachments = attachments;
		//默认图片
		Iterator it = attachments.iterator();
		while(it.hasNext()) {
			Attachment attach = (Attachment)it.next();
			if (attach.getStatus().equals("default")) {
				this.defaultImage = attach;
				break;
			}
		}
	}
}