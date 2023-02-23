package com.puppy.witchcraft.game.model.dto;

public class MyInven {
	
	private int itemNo;
	private int itemCount;
	private int imageNo;
	
	public MyInven() {}

	public MyInven(int itemNo, int itemCount, int imageNo) {
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
		return "TestInven [itemNo=" + itemNo + ", itemCount=" + itemCount + ", imageNo=" + imageNo + "]";
	}


	
}
