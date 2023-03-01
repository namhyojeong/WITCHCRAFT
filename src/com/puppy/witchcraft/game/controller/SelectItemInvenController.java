package com.puppy.witchcraft.game.controller;

import java.util.ArrayList;
import java.util.List;

import com.puppy.witchcraft.game.model.dto.ImageDTO;
import com.puppy.witchcraft.game.model.dto.MyItemInven;
import com.puppy.witchcraft.game.model.dto.PlayerDTO;
import com.puppy.witchcraft.game.model.service.SelectItemInvenService;

public class SelectItemInvenController {

	SelectItemInvenService selectItemInvenService = new SelectItemInvenService();

	public List<MyItemInven> myItemInven(PlayerDTO pp) {

		int playerNo = pp.getPlayerNo();
		
		List<MyItemInven> itemList = new ArrayList<>();

		itemList = selectItemInvenService.myItemInven(playerNo);

		return itemList;
	}

	public String itemImage(MyItemInven item) {

		ImageDTO image = selectItemInvenService.imageSource(item.getImageNo());

		String source = image.getImageSave();

		return source;
	}

}
