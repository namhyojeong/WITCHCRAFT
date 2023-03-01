package com.puppy.witchcraft.game.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.puppy.witchcraft.game.model.dto.PlayerDTO;
import com.puppy.witchcraft.game.model.dto.PotionDTO;
import com.puppy.witchcraft.game.model.dto.RecipeDTO;
import com.puppy.witchcraft.game.model.service.PotionMakerService;

public class PotionMakerController {

	PotionMakerService potionMakerService = new PotionMakerService();
	
	public boolean insertPotionInven(PlayerDTO player, int potionNo) {
		
		int playerNo = player.getPlayerNo();

		Map<String, Integer> insert = new HashMap<>();
		insert.put("playerNo", playerNo);
		insert.put("potionNo", potionNo);
		
		boolean result = potionMakerService.insertPotionInven(insert);
		
		if(result) {
			System.out.println("컨트롤러 : 포션 제작 후 포션인벤토리에 등록하기 성공");
		} else {
			System.out.println("컨트롤러 : 포션 제작 후 포션인벤토리에 등록하기 실패");
		}
		
		return result;
	}

	public void deleteUseItem(PlayerDTO player, int itemNo) {
		
		int playerNo = player.getPlayerNo();

		Map<String, Integer> remove = new HashMap<>();
		remove.put("playerNo", playerNo);
		remove.put("itemNo", itemNo);
		
		boolean result = potionMakerService.deleteUseItem(remove);
		
		if(result) {
			System.out.println("컨트롤러 : 포션 제작 후 재료인벤토리에 재료삭제하기 성공");
		} else {
			System.out.println("컨트롤러 : 포션 제작 후 재료인벤토리에 재료삭제하기 실패");
		}
		
	}

	public PotionDTO selectPotion(int potionNo) {
		
		PotionDTO potion = potionMakerService.selectPotion(potionNo);
		
		return potion;
	}


}
