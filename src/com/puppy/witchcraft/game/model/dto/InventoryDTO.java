package com.puppy.witchcraft.game.model.dto;

public class InventoryDTO {
	
	private int invenNo;
	private int playerNo;
	private String invenType;
	private int itemNo;
	private int potionNo;
	
	public InventoryDTO() {}

	public InventoryDTO(int invenNo, int playerNo, String invenType, int itemNo, int potionNo) {
		super();
		this.invenNo = invenNo;
		this.playerNo = playerNo;
		this.invenType = invenType;
		this.itemNo = itemNo;
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

	public String getInvenType() {
		return invenType;
	}

	public void setInvenType(String invenType) {
		this.invenType = invenType;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getPotionNo() {
		return potionNo;
	}

	public void setPotionNo(int potionNo) {
		this.potionNo = potionNo;
	}

	@Override
	public String toString() {
		return "InventoryDTO [invenNo=" + invenNo + ", playerNo=" + playerNo + ", invenType=" + invenType + ", itemNo="
				+ itemNo + ", potionNo=" + potionNo + "]";
	}
	
	
}
