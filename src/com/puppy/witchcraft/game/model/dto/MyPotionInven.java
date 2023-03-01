package com.puppy.witchcraft.game.model.dto;

public class MyPotionInven {

	private int potionNo;
	private int potionCount;
	private int imageNo;
	
	public MyPotionInven() {}

	public MyPotionInven(int potionNo, int potionCount, int imageNo) {
		super();
		this.potionNo = potionNo;
		this.potionCount = potionCount;
		this.imageNo = imageNo;
	}

	public int getPotionNo() {
		return potionNo;
	}

	public void setPotionNo(int potionNo) {
		this.potionNo = potionNo;
	}

	public int getPotionCount() {
		return potionCount;
	}

	public void setPotionCount(int potionCount) {
		this.potionCount = potionCount;
	}

	public int getImageNo() {
		return imageNo;
	}

	public void setImageNo(int imageNo) {
		this.imageNo = imageNo;
	}

	@Override
	public String toString() {
		return "MyPotionInven [potionNo=" + potionNo + ", potionCount=" + potionCount + ", imageNo=" + imageNo + "]";
	}
	
}
