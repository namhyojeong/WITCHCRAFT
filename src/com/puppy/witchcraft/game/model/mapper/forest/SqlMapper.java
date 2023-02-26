package com.puppy.witchcraft.game.model.mapper.forest;

import java.util.List;
import java.util.Map;

import com.puppy.witchcraft.game.model.dto.ItemDTO;

public interface SqlMapper {

	ItemDTO rnditem(int randomitem);

	int insertforestitem(Map<String, Integer> inven);


	

}
