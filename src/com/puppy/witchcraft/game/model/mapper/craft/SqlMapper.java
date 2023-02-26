package com.puppy.witchcraft.game.model.mapper.craft;

import java.util.List;

import com.puppy.witchcraft.game.model.dto.ImageDTO;
import com.puppy.witchcraft.game.model.dto.MyItemInven;
import com.puppy.witchcraft.game.model.dto.RecipeDTO;

public interface SqlMapper {
	
	List<MyItemInven> myItemInven(int playerNo);

	ImageDTO selectItemImage(int imageNo);

}
