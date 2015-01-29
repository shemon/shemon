package com.shemon.atmboothsfinder;

public class Info {
	int id;
	
	String name, add, bankName, deposit, contactName, contactNo, latitude, longitude;

	public Info(int id, String name, String add, String bankName,
			String deposit, String contactName, String contactNo,
			String latitude, String longitude) {
		super();
		this.id = id;
		this.name = name;
		this.add = add;
		this.bankName = bankName;
		this.deposit = deposit;
		this.contactName = contactName;
		this.contactNo = contactNo;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Info(String name, String add, String bankName, String deposit,
			String contactName, String contactNo, String latitude,
			String longitude) {
		super();
		this.name = name;
		this.add = add;
		this.bankName = bankName;
		this.deposit = deposit;
		this.contactName = contactName;
		this.contactNo = contactNo;
		this.latitude = latitude;
		this.longitude = longitude;
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

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
}
