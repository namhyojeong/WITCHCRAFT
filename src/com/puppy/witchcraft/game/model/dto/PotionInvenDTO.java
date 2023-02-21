package com.puppy.witchcraft.game.model.dto;

public class PotionInvenDTO {
	
	private int invenNo;
	private int playerNo;
	private int potionNo;
	
	public PotionInvenDTO() {}

	public PotionInvenDTO(int invenNo, int playerNo, int potionNo) {
		super();
		this.invenNo = invenNo;
		this.playerNo = playerNo;
		this.potionNo = potionNo;
	}

	public int getInvenNo() {
		return invenNo;
	}

	public void setInvenNo(int invenNo) {
		this.invenNo = invenNo;
	}

	public int getPlayerNo() {
		return playerNo;
	}

	public void setPlayerNo(int playerNo) {
		this.playerNo = playerNo;
	}

	public int getPotionNo() {
		return potionNo;
	}

	public void setPotionNo(int potionNo) {
		this.potionNo = potionNo;
	}

	@Override
	public String toString() {
		return "PotionInven [invenNo=" + invenNo + ", playerNo=" + playerNo + ", potionNo=" + potionNo + "]";
	}
	
}
