package com.puppy.witchcraft.game.model.dto;

public class ItemDTO {
	
	private int itemNo;
	private String itemType;
	private String itemName;
	private String itemInfo;
	private int sellPrice;
	private int buyPrice;
	private String itemImageNo;	//이미지 테이블 참조
	
	public ItemDTO() {}

	public ItemDTO(int itemNo, String itemType, String itemName, String itemInfo, int sellPrice, int buyPrice,
			String itemImageNo) {
		super();
		this.itemNo = itemNo;
		this.itemType = itemType;
		this.itemName = itemName;
		this.itemInfo = itemInfo;
		this.sellPrice = sellPrice;
		this.buyPrice = buyPrice;
		this.itemImageNo = itemImageNo;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemInfo() {
		return itemInfo;
	}

	public void setItemInfo(String itemInfo) {
		this.itemInfo = itemInfo;
	}

	public int getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}

	public int getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(int buyPrice) {
		this.buyPrice = buyPrice;
	}

	public String getItemImageNo() {
		return itemImageNo;
	}

	public void setItemImageNo(String itemImageNo) {
		this.itemImageNo = itemImageNo;
	}

	@Override
	public String toString() {
		return "ItemDTO [itemNo=" + itemNo + ", itemType=" + itemType + ", itemName=" + itemName + ", itemInfo="
				+ itemInfo + ", sellPrice=" + sellPrice + ", buyPrice=" + buyPrice + ", itemImageNo=" + itemImageNo
				+ "]";
	}
	
}
