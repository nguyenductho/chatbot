package vn.mobifone.mvas.chatbot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "briefinfo")
@XmlRootElement
public class BriefInfo {
	@Id
	private long id;

	private String name;
	private String briefinfo;

	public BriefInfo() {

	}

	public BriefInfo(long id, String name, String briefinfo) {
		super();
		this.id = id;
		this.name = name;
		this.briefinfo = briefinfo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBriefinfo() {
		return briefinfo;
	}

	public void setBriefinfo(String briefinfo) {
		this.briefinfo = briefinfo;
	}

}
