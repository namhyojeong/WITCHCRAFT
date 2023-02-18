package com.puppy.witchcraft.game.model.dto;

public class PotionDTO {
	
	private int potionNo;
	private String potionName;
	private String potionInfo;
	private String potionImageNo; //이미지 테이블 참조
	
	public PotionDTO() {}

	public PotionDTO(int potionNo, String potionName, String potionInfo, String potionImageNo) {
		super();
		this.potionNo = potionNo;
		this.potionName = potionName;
		this.potionInfo = potionInfo;
		this.potionImageNo = potionImageNo;
	}

	public int getPotionNo() {
		return potionNo;
	}

	public void setPotionNo(int potionNo) {
		this.potionNo = potionNo;
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

	public String getPotionImageNo() {
		return potionImageNo;
	}

	public void setPotionImageNo(String potionImageNo) {
		this.potionImageNo = potionImageNo;
	}

	@Override
	public String toString() {
		return "PotionDTO [potionNo=" + potionNo + ", potionName=" + potionName + ", potionInfo=" + potionInfo
				+ ", potionImageNo=" + potionImageNo + "]";
	}
	
}
