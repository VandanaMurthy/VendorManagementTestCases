package org.accion.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vendors_list")
public class Vendor {
	@Id
	@Column(name="vendor_id")
	private int id;
	
	@Column(name="vendor_name")
	private String name;
	
	@Column(name="vendor_category")
	private String category;
	
	@Column(name="vendor_address")
	private String address;

	@Column(name="start_date")
	private String sdate;
	
	@Column(name="end_date")
	private String edate;
	
	@Column(name="bill_rate")
	private double brate;
	
	@Column(name="status")
	private String status;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public double getBrate() {
		return brate;
	}

	public void setBrate(double brate) {
		this.brate = brate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Vendor(int id, String name, String category,String address,String sdate,String edate,double brate,String status) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.address=address;
		this.sdate=sdate;
		this.edate=edate;
		this.brate=brate;
		this.status=status;
		
	}
	public Vendor(){
		
	}
	

}
