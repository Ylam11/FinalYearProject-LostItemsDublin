package com.example.dit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	@ManyToOne
    private User itemOwner;
    private String itemName;
    private String itemDescription;
    private String itemQrCode;
    private String itemStatus;
    private String itemRegisteredAt;
   
	public Item() {

	}
	
	public Item(User itemOwner, String itemName, String itemDescription, String itemQrCode, String itemStatus, String itemRegisteredAt) {
		this.itemOwner = itemOwner;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemQrCode = itemQrCode;
		this.itemStatus = itemStatus;
		this.itemRegisteredAt = itemRegisteredAt;	
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public User getItemOwner() {
		return itemOwner;
	}

	public void setItemOwner(User itemOwner) {
		this.itemOwner = itemOwner;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getItemQrCode() {
		return itemQrCode;
	}

	public void setItemQrCode(String itemQrCode) {
		this.itemQrCode = itemQrCode;
	}

	public String getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	public String getItemRegisteredAt() {
		return itemRegisteredAt;
	}

	public void setItemRegisteredAt(String itemRegisteredAt) {
		this.itemRegisteredAt = itemRegisteredAt;
	}
	
	
	

	
}
