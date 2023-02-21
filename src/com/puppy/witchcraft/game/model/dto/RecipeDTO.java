package com.puppy.witchcraft.game.model.dto;

public class RecipeDTO {
	
	private int recipeNo;
	private int itemNo;
	private int itemCount;
	private int potionNo;
	
	public RecipeDTO() {}

	public RecipeDTO(int recipeNo, int itemNo, int itemCount, int potionNo) {
		super();
		this.recipeNo = recipeNo;
		this.itemNo = itemNo;
		this.itemCount = itemCount;
		this.potionNo = potionNo;
	}

	public int getRecipeNo() {
		return recipeNo;
	}

	public void setRecipeNo(int recipeNo) {
		this.recipeNo = recipeNo;
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
		return "RecipeDTO [recipeNo=" + recipeNo + ", itemNo=" + itemNo + ", itemCount=" + itemCount + ", potionNo="
				+ potionNo + "]";
	}
	
	
}
