package com.puppy.witchcraft.game.model.dto;

public class MyItemInven {
	
	private int itemNo;
	private int itemCount;
	private int imageNo;
	
	public MyItemInven() {}

	public MyItemInven(int itemNo, int itemCount, int imageNo) {
		super();
		this.itemNo = itemNo;
		this.itemCount = itemCount;
		this.imageNo = imageNo;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public int getImageNo() {
		return imageNo;
	}

	public void setImageNo(int imageNo) {
		this.imageNo = imageNo;
	}

	@Override
	public String toString() {
		return "MyInven [itemNo=" + itemNo + ", itemCount=" + itemCount + ", imageNo=" + imageNo + "]";
	}

}
