package com.puppy.witchcraft.game.model.mapper.player;

import java.util.Map;

import com.puppy.witchcraft.game.model.dto.PlayerDTO;

public interface SqlMapper {

	PlayerDTO player(int insertplayer);

	int insertplayer(Map<String, String> player);

}
