package com.puppy.witchcraft.game.model.mapper.craft;

import java.util.List;

import com.puppy.witchcraft.game.model.dto.ImageDTO;
import com.puppy.witchcraft.game.model.dto.MyItemInven;
import com.puppy.witchcraft.game.model.dto.PotionDTO;
import com.puppy.witchcraft.game.model.dto.RecipeAndPotion;
import com.puppy.witchcraft.game.model.dto.RecipeDTO;

public interface SqlMapper {
	
	List<MyItemInven> myItemInven(int playerNo);

	List<RecipeAndPotion> selectAllRecipe();

	List<RecipeDTO> selectRecipe(int recipeNo);

	PotionDTO selectPotion(int potionNo);

	ImageDTO selectImage(int imageNo);


}
