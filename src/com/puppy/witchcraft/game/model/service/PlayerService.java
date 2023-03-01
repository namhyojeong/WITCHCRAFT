package com.puppy.witchcraft.game.model.service;

import org.apache.ibatis.session.SqlSession;

import static com.puppy.witchcraft.common.Template.getSqlSession;

import java.util.Map;

import com.puppy.witchcraft.game.model.dto.PlayerDTO;
import com.puppy.witchcraft.game.model.mapper.player.SqlMapper;

public class PlayerService {

	private static SqlMapper mapper;

	public int insertplayer(Map<String, String> player) {
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(SqlMapper.class);

		int result = mapper.insertplayer(player);

		if(result > 0 ) {

			sqlSession.commit();

		}else {

			sqlSession.rollback();
		}
		sqlSession.close();
		return result;

	}
}