package com.puppy.witchcraft.game.controller;

import java.util.List;

import com.puppy.witchcraft.game.model.dto.ItemDTO;
import com.puppy.witchcraft.game.model.dto.PlayerDTO;
import com.puppy.witchcraft.game.model.service.Forest1Service;
import com.puppy.witchcraft.game.model.service.itemrand;

public class Forest1Controller {

	private  Forest1Service forest1Service = new Forest1Service();

	public ItemDTO selectforestitem() {

		ItemDTO item = forest1Service.test(itemrand.randomitem1());
		ItemDTO item1 = forest1Service.test(itemrand.randomitem2());
		ItemDTO item2 = forest1Service.test(itemrand.randomitem3());
		
		
		return item;
		
	}

	public void insertforestitem(ItemDTO item, PlayerDTO pp) {
		
		int result = forest1Service.insertforestitem(item, pp);
		
		if(result > 0) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}

}


