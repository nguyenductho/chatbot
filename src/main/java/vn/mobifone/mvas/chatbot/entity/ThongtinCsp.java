package vn.mobifone.mvas.chatbot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="ThongtinCsp")
@XmlRootElement
public class ThongtinCsp {
	@Id
	private long id;
	
	private String servicename;
	private String shortcode;
	private String partner;
	private String salecontact;
	private String technician;
	private String incharge;
	private String mobisale;
	private String fullname;

	public ThongtinCsp() {

	}

	public ThongtinCsp(long id, String servicename, String shortcode, String partner, String salecontact,
			String technician, String incharge, String mobisale, String fullname) {
		this.id = id;
		this.servicename = servicename;
		this.shortcode = shortcode;
		this.partner = partner;
		this.salecontact = salecontact;
		this.technician = technician;
		this.incharge = incharge;
		this.mobisale = mobisale;
		this.fullname = fullname;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public String getShortcode() {
		return shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getSalecontact() {
		return salecontact;
	}

	public void setSalecontact(String salecontact) {
		this.salecontact = salecontact;
	}

	public String getTechnician() {
		return technician;
	}

	public void setTechnician(String technician) {
		this.technician = technician;
	}

	public String getIncharge() {
		return incharge;
	}

	public void setIncharge(String incharge) {
		this.incharge = incharge;
	}

	public String getMobisale() {
		return mobisale;
	}

	public void setMobisale(String mobisale) {
		this.mobisale = mobisale;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
}
