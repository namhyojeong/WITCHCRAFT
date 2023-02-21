package com.puppy.witchcraft.game.model.dto;

public class ItemInvenDTO {

	private int invenNo;
	private int playerNo;
	private int itemNo;
	
	public ItemInvenDTO() {}

	public ItemInvenDTO(int invenNo, int playerNo, int itemNo) {
		super();
		this.invenNo = invenNo;
		this.playerNo = playerNo;
		this.itemNo = itemNo;
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

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	@Override
	public String toString() {
		return "ItemInvenDTO [invenNo=" + invenNo + ", playerNo=" + playerNo + ", itemNo=" + itemNo + "]";
	}
	
}
