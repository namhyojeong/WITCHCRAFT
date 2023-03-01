package com.puppy.witchcraft.game.model.mapper.player;

import java.util.List;
import java.util.Map;

import com.puppy.witchcraft.game.model.dto.ImageDTO;
import com.puppy.witchcraft.game.model.dto.MyItemInven;
import com.puppy.witchcraft.game.model.dto.MyPotionInven;
import com.puppy.witchcraft.game.model.dto.PlayerDTO;

public interface SqlMapper {

	int insertplayer(Map<String, String> player);

	PlayerDTO selectPlayer(Map<String, String> login);
	
	List<MyItemInven> myItemInven(int playerNo);

	List<MyPotionInven> myPotionInven(int playerNo);

	ImageDTO selectImage(int imageNo);

}
