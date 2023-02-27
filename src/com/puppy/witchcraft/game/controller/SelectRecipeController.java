package com.puppy.witchcraft.game.controller;

import java.util.List;

import com.puppy.witchcraft.game.model.dto.ImageDTO;
import com.puppy.witchcraft.game.model.dto.ItemDTO;
import com.puppy.witchcraft.game.model.dto.PotionDTO;
import com.puppy.witchcraft.game.model.dto.RecipeAndPotion;
import com.puppy.witchcraft.game.model.dto.RecipeDTO;
import com.puppy.witchcraft.game.model.service.SelectRecipeService;

public class SelectRecipeController {
	
	SelectRecipeService selectRecipeService = new SelectRecipeService();

	public List<RecipeAndPotion> selectAllRecipe() {
		
		List<RecipeAndPotion> recipeAllList = selectRecipeService.selectAllRecipe();
		
		return recipeAllList;
	}
	

	public List<RecipeDTO> selectRecipe(int recipeNo) {
		
		List<RecipeDTO> recipeAllList = selectRecipeService.selectRecipe(recipeNo);
		
		return recipeAllList;
	}
	
	public PotionDTO selectPotion(int potionNo) {
		
		PotionDTO potion = selectRecipeService.selectPotion(potionNo);
		
		return potion;
	}

	
	/* 레시피의 포션 이미지 */
	public String potionImage(PotionDTO potion) {
		
		int potionImageNo = potion.getImageNo();
		
		ImageDTO image = selectRecipeService.image(potionImageNo);
		
		String source = image.getImageSave();
		
		return source;
	}
	
	/* 레시피 내의 재료 이미지 */
	public String itemImage(ItemDTO item) {
		
		int itemImageNo = item.getImageNo();
		
		ImageDTO image = selectRecipeService.image(itemImageNo);
		
		String source = image.getImageSave();
		
		return source;
	}


}
