package com.puppy.witchcraft.game.controller;

import java.util.ArrayList;
import java.util.List;

import com.puppy.witchcraft.game.model.dto.ImageDTO;
import com.puppy.witchcraft.game.model.dto.MyItemInven;
import com.puppy.witchcraft.game.model.dto.MyPotionInven;
import com.puppy.witchcraft.game.model.dto.PlayerDTO;
import com.puppy.witchcraft.game.model.service.SelectPotionInvenService;

public class SelectPotionInvenController {

	SelectPotionInvenService selectPotionInvenService = new SelectPotionInvenService();

	public List<MyPotionInven> myPotionInven(PlayerDTO pp) {

		int playerNo = pp.getPlayerNo();
		
		List<MyPotionInven> potionList = new ArrayList<>();

		potionList = selectPotionInvenService.myPotionInven(playerNo);

		return potionList;
	}

	public String potionImage(MyPotionInven potion) {

		ImageDTO image = selectPotionInvenService.imageSource(potion.getImageNo());

		String source = image.getImageSave();

		return source;
	}
}
