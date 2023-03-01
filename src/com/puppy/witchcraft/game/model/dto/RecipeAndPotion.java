package com.puppy.witchcraft.game.model.dto;

import java.util.List;

public class RecipeAndPotion {

	private int potionNo;
	private List<ItemDTO> itemList;
	
	public RecipeAndPotion() {}

	public RecipeAndPotion(int potionNo, List<ItemDTO> itemList) {
		this.potionNo = potionNo;
		this.itemList = itemList;
	}

	public int getPotionNo() {
		return potionNo;
	}

	public void setPotionNo(int potionNo) {
		this.potionNo = potionNo;
	}

	public List<ItemDTO> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemDTO> itemList) {
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "RecipeAndPotion [potionNo=" + potionNo + ", itemList=" + itemList + "]";
	}


}
