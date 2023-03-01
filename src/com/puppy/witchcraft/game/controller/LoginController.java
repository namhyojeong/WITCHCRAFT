package com.puppy.witchcraft.game.controller;

import java.util.HashMap;
import java.util.Map;

import com.puppy.witchcraft.game.model.dto.PlayerDTO;
import com.puppy.witchcraft.game.model.service.LoginService;

public class LoginController {

	public PlayerDTO getPlayer(String id, String pwd) {
		
		LoginService loginService = new LoginService();
		
		Map<String, String> login = new HashMap<>();
		login.put("playerId", id);
		login.put("playerPwd", pwd);
		
		PlayerDTO player = loginService.getPlayer(login);
		
		return player;
	}

}
