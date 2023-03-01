package com.puppy.witchcraft.game.model.mapper.craft;

import java.util.List;
import java.util.Map;

import com.puppy.witchcraft.game.model.dto.ImageDTO;
import com.puppy.witchcraft.game.model.dto.ItemDTO;
import com.puppy.witchcraft.game.model.dto.MyItemInven;
import com.puppy.witchcraft.game.model.dto.PotionDTO;
import com.puppy.witchcraft.game.model.dto.RecipeAndPotion;
import com.puppy.witchcraft.game.model.dto.RecipeDTO;
import com.puppy.witchcraft.game.model.dto.RecipeItem;

public interface SqlMapper {
	
	List<MyItemInven> myItemInven(int playerNo);

	List<RecipeAndPotion> selectAllRecipe();

	List<RecipeDTO> selectRecipe(int recipeNo);

	PotionDTO selectPotion(int potionNo);

	ImageDTO selectImage(int imageNo);

	List<RecipeItem> selectRecipeItems(int potionNo);

	int deleteUseItem(Map<String, Integer> remove);

	int insertPotionInven(Map<String, Integer> insert);



}
