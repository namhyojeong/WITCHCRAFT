package com.puppy.witchcraft.game.model.mapper.store;

import java.util.List;
import java.util.Map;

import com.puppy.witchcraft.game.model.dto.ImageDTO;
import com.puppy.witchcraft.game.model.dto.ItemDTO;
import com.puppy.witchcraft.game.model.dto.MyItemInven;
import com.puppy.witchcraft.game.model.dto.PlayerDTO;

public interface SqlMapper {

	ImageDTO imageUrl(int imageNo);

	List<ItemDTO> storeList();

	PlayerDTO playerGoldChange(PlayerDTO playerNo, ItemDTO itemNo);

	int insertstoreitem(Map<String, Integer> inven);

	int playerGoldChange(Map<String, Integer> gold);

	List<MyItemInven> myItemInven(int playerNo);

	

}
