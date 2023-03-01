package com.puppy.witchcraft.game.controller;

import java.util.HashMap;
import java.util.Map;

import com.puppy.witchcraft.game.model.dto.PlayerDTO;
import com.puppy.witchcraft.game.model.service.PlayerService;


public class PlayerController {

	private PlayerService playerservice = new PlayerService();
	private PlayerDTO player;
	

	public void insertplayer(String id, String pwd, String nickname) {
		
		Map<String, String> player = new HashMap<>();
		player.put("id", id);
		player.put("pwd", pwd);
		player.put("nickname", nickname);
		int result = playerservice.insertplayer(player);
		//임시로 해둔거
		if(result > 0) {
			System.out.println("등록 성공");
		} else {
			System.out.println("등록 실패");
		}
		
	}



}
