package com.puppy.witchcraft.game.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import com.puppy.witchcraft.game.model.dto.ImageDTO;
import com.puppy.witchcraft.game.model.dto.ItemDTO;
import com.puppy.witchcraft.game.model.dto.ItemInvenDTO;
import com.puppy.witchcraft.game.model.dto.PlayerDTO;
import com.puppy.witchcraft.game.model.dto.MyItemInven;
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

	//	public PlayerDTO buyItem(PlayerDTO playerNo, ItemDTO itemNo) {
	//
	//		PlayerDTO pp = new PlayerDTO();
	//		
	//		pp = storePageService.playerGoldChange(playerNo, itemNo);
	//		
	//		return pp;
	//	}

	public void insertstoreitem(ItemDTO item, PlayerDTO pp) {

		int result = storePageService.insertstoreitem(item, pp);

		if(result > 0) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}

	public List<MyItemInven> myItemInven(PlayerDTO pp) {

		int playerNo = pp.getPlayerNo();

		List<MyItemInven> itemList = new ArrayList<>();

		itemList = storePageService.myItemInven(playerNo);

		return itemList;
	}


	public void playerGoldChange(JLabel playerGold, PlayerDTO pp) {

		int result = storePageService.playerGoldChange(playerGold, pp);

		if(result > 0) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}

	public List<ItemInvenDTO> sellItem(ItemInvenDTO itemInvenDTO) {

		List<ItemInvenDTO> invenItemList = new ArrayList<>();

		invenItemList = storePageService.sellItem(itemInvenDTO);

		return invenItemList;	
	}

	public void deleteStoreItem(int invenNo) {

		int result = storePageService.deleteStoreItem(invenNo);

		if(result > 0) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}
}	

