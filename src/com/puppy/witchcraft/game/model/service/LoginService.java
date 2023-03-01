package com.puppy.witchcraft.game.model.service;

import static com.puppy.witchcraft.common.Template.getSqlSession;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.puppy.witchcraft.game.model.dto.PlayerDTO;
import com.puppy.witchcraft.game.model.mapper.player.SqlMapper;

public class LoginService {

	private SqlMapper mapper;
	
	public PlayerDTO getPlayer(Map<String, String> login) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(SqlMapper.class);

		PlayerDTO player = mapper.selectPlayer(login);

		sqlSession.close();
		
		return player;
	}

}
