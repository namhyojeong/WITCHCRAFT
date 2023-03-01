package com.puppy.witchcraft.game.model.dto;

public class RecipeItem {
	
	private int itemNo;
	private int itemCount;
	private int potionNo;
	
	public RecipeItem() {}

	public RecipeItem(int itemNo, int itemCount, int potionNo) {
		super();
		this.itemNo = itemNo;
		this.itemCount = itemCount;
		this.potionNo = potionNo;
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

	public int getPotionNo() {
		return potionNo;
	}

	public void setPotionNo(int potionNo) {
		this.potionNo = potionNo;
	}

	@Override
	public String toString() {
		return "RecipeItem [itemNo=" + itemNo + ", itemCount=" + itemCount + ", potionNo=" + potionNo + "]";
	}

}
