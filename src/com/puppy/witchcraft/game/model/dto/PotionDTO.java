package com.puppy.witchcraft.game.model.dto;

public class PotionDTO {
	
	private int potionNo;
	private int potionSell; 
	private String potionName;
	private String potionInfo;
	private int imageNo; //이미지 테이블 참조
	
	public PotionDTO() {}

	public PotionDTO(int potionNo, int potionSell, String potionName, String potionInfo, int imageNo) {
		super();
		this.potionNo = potionNo;
		this.potionSell = potionSell;
		this.potionName = potionName;
		this.potionInfo = potionInfo;
		this.imageNo = imageNo;
	}

	public int getPotionNo() {
		return potionNo;
	}

	public void setPotionNo(int potionNo) {
		this.potionNo = potionNo;
	}

	public int getPotionSell() {
		return potionSell;
	}

	public void setPotionSell(int potionSell) {
		this.potionSell = potionSell;
	}

	public String getPotionName() {
		return potionName;
	}

	public void setPotionName(String potionName) {
		this.potionName = potionName;
	}

	public String getPotionInfo() {
		return potionInfo;
	}

	public void setPotionInfo(String potionInfo) {
		this.potionInfo = potionInfo;
	}

	public int getImageNo() {
		return imageNo;
	}

	public void setImageNo(int imageNo) {
		this.imageNo = imageNo;
	}

	@Override
	public String toString() {
		return "PotionDTO [potionNo=" + potionNo + ", potionSell=" + potionSell + ", potionName=" + potionName
				+ ", potionInfo=" + potionInfo + ", imageNo=" + imageNo + "]";
	}
	
}
