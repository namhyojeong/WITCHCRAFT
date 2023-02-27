package com.puppy.witchcraft.game.model.dto;

import java.util.List;

public class RecipeAndPotion {

	private int recipeNo;
	private int potionNo;
	private List<ItemDTO> itemList;
	
	public RecipeAndPotion() {}

	public RecipeAndPotion(int recipeNo, int potionNo, List<ItemDTO> itemList) {
		super();
		this.recipeNo = recipeNo;
		this.potionNo = potionNo;
		this.itemList = itemList;
	}

	public int getRecipeNo() {
		return recipeNo;
	}

	public void setRecipeNo(int recipeNo) {
		this.recipeNo = recipeNo;
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
		return "RecipeAndPotion [recipeNo=" + recipeNo + ", potionNo=" + potionNo +
				", itemList=" + itemList + "]";
	}

}
