package com.puppy.witchcraft.game.model.dto;

public class ItemDTO {
	
	private int itemNo;
	private String itemType;
	private String itemName;
	private String itemInfo;
	private int itemSell;
	private int itemBuy;
	private String imageNo;	//이미지 테이블 참조
	
	public ItemDTO() {}

	public ItemDTO(int itemNo, String itemType, String itemName, String itemInfo, int itemSell, int itemBuy,
			String imageNo) {
		super();
		this.itemNo = itemNo;
		this.itemType = itemType;
		this.itemName = itemName;
		this.itemInfo = itemInfo;
		this.itemSell = itemSell;
		this.itemBuy = itemBuy;
		this.imageNo = imageNo;
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

	public int getItemSell() {
		return itemSell;
	}

	public void setItemSell(int itemSell) {
		this.itemSell = itemSell;
	}

	public int getItemBuy() {
		return itemBuy;
	}

	public void setItemBuy(int itemBuy) {
		this.itemBuy = itemBuy;
	}

	public String getImageNo() {
		return imageNo;
	}

	public void setImageNo(String imageNo) {
		this.imageNo = imageNo;
	}

	@Override
	public String toString() {
		return "ItemDTO [itemNo=" + itemNo + ", itemType=" + itemType + ", itemName=" + itemName + ", itemInfo="
				+ itemInfo + ", itemSell=" + itemSell + ", itemBuy=" + itemBuy + ", imageNo=" + imageNo + "]";
	}
	
}
