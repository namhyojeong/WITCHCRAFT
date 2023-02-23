package com.puppy.witchcraft.game.model.mapper.craft;

import java.util.List;

import com.puppy.witchcraft.game.model.dto.ImageDTO;
import com.puppy.witchcraft.game.model.dto.MyInven;

public interface SqlMapper {
	
	List<MyInven> myItemInven(int playerNo);

	ImageDTO imageUrl(int imageNo);

}
