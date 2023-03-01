package com.puppy.witchcraft.game.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;

import com.puppy.witchcraft.game.model.dto.ImageDTO;
import com.puppy.witchcraft.game.model.dto.ItemDTO;
import com.puppy.witchcraft.game.model.dto.ItemInvenDTO;
import com.puppy.witchcraft.game.model.dto.MyItemInven;
import com.puppy.witchcraft.game.model.dto.PlayerDTO;
import com.puppy.witchcraft.game.model.service.StorePageService;

public class StorePageController {

	private StorePageService storePageService = new StorePageService();

	public List<ItemDTO> item() {

		List<ItemDTO> itemList = new ArrayList<>();

		itemList = storePageService.test();

		return itemList;

	}

	public String imageUrl(int imageNo) {

		ImageDTO image = storePageService.imageUrl(imageNo);

		String imageUrl = image.getImageSave();

		return imageUrl;
	}

	public void insertstoreitem(ItemDTO item, PlayerDTO player) {

		int result = storePageService.insertstoreitem(item, player);

		if(result > 0) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}

	public List<MyItemInven> myItemInven(PlayerDTO player) {

		int playerNo = player.getPlayerNo();

		List<MyItemInven> itemList = new ArrayList<>();

		itemList = storePageService.myItemInven(playerNo);

		return itemList;
	}

	public void deleteSellItem(PlayerDTO player, int itemNo) {
		
		Map<String, Integer> delete = new HashMap<>();
		delete.put("playerNo", player.getPlayerNo());
		delete.put("itemNo", itemNo);
		
		boolean result = storePageService.deleteSellItem(delete);
		
		if(result) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}
	
	public void updatePlayerGold(PlayerDTO player, int playerGold) {
		
		Map<String, Integer> gold = new HashMap<>();
		gold.put("playerNo", player.getPlayerNo());
		gold.put("playerGold", playerGold);

		boolean result = storePageService.updatePlayerGold(gold);

		if(result) {
			System.out.println("골드 변경 성공");
		} else {
			System.out.println("골드 변경 실패");
		}
	}

	public ItemDTO selectItem(int itemNo) {
		
		ItemDTO item = storePageService.selectItem(itemNo);
		
		return item;
	}
	
}	

