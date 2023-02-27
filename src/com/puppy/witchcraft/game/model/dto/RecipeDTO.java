package com.puppy.witchcraft.game.model.dto;

public class RecipeDTO {
	
	private int recipeNo;
	private int potionNo;
	private int itemCount;
	private int itemNo;
	
	public RecipeDTO() {}

	public RecipeDTO(int recipeNo, int potionNo, int itemCount, int itemNo) {
		super();
		this.recipeNo = recipeNo;
		this.potionNo = potionNo;
		this.itemCount = itemCount;
		this.itemNo = itemNo;
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

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	@Override
	public String toString() {
		return "RecipeDTO [recipeNo=" + recipeNo + ", potionNo=" + potionNo + ", itemCount=" + itemCount + ", itemNo="
				+ itemNo + "]";
	}

}
