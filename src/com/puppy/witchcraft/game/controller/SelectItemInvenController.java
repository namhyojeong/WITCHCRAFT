package com.puppy.witchcraft.game.controller;

import java.util.ArrayList;
import java.util.List;

import com.puppy.witchcraft.game.model.dto.ImageDTO;
import com.puppy.witchcraft.game.model.dto.MyInven;
import com.puppy.witchcraft.game.model.dto.PlayerDTO;
import com.puppy.witchcraft.game.model.service.SelectItemInvenService;

public class SelectItemInvenController {
	
	SelectItemInvenService selectItemInvenService = new SelectItemInvenService();

	public List<MyInven> inven(PlayerDTO pp) {

		int playerNo = pp.getPlayerNo();

		List<MyInven> itemList = new ArrayList<>();

		itemList = selectItemInvenService.test(playerNo);
		
		return itemList;
	}

	public String imageUrl(int imageNo) {
		

		ImageDTO image = selectItemInvenService.imageUrl(imageNo);
		
		String imageUrl = image.getImageSave();
		
		return imageUrl;
	}

}
