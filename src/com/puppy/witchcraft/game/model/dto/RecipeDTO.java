package com.puppy.witchcraft.game.model.dto;

import java.util.List;

public class RecipeDTO {
	
	private int recipeNo;
	private String recipeName;
	private int itemNo;
	private List<ItemDTO> items;
	private String recipeImageNo;	//이미지 테이블의 포션 번호로 참조
	
	public RecipeDTO() {}

	public RecipeDTO(int recipeNo, String recipeName, int itemNo, List<ItemDTO> items, String recipeImageNo) {
		super();
		this.recipeNo = recipeNo;
		this.recipeName = recipeName;
		this.itemNo = itemNo;
		this.items = items;
		this.recipeImageNo = recipeImageNo;
	}

	public int getRecipeNo() {
		return recipeNo;
	}

	public void setRecipeNo(int recipeNo) {
		this.recipeNo = recipeNo;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public List<ItemDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}

	public String getRecipeImageNo() {
		return recipeImageNo;
	}

	public void setRecipeImageNo(String recipeImageNo) {
		this.recipeImageNo = recipeImageNo;
	}

	@Override
	public String toString() {
		return "RecipeDTO [recipeNo=" + recipeNo + ", recipeName=" + recipeName + ", itemNo=" + itemNo + ", items="
				+ items + ", recipeImageNo=" + recipeImageNo + "]";
	}

}
