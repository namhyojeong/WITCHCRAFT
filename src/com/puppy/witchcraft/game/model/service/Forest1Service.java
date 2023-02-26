package com.puppy.witchcraft.game.model.service;

import static com.puppy.witchcraft.common.Template.getSqlSession;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.puppy.witchcraft.game.model.dto.ItemDTO;
import com.puppy.witchcraft.game.model.dto.PlayerDTO;
import com.puppy.witchcraft.game.model.mapper.forest.SqlMapper;

public class Forest1Service {

	private static SqlMapper mapper;


	public ItemDTO test(int randomitem) {
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(SqlMapper.class);
		ItemDTO item = mapper.rnditem(randomitem);
		sqlSession.close();

		return item;
	}


	public int insertforestitem(ItemDTO item, PlayerDTO pp) {
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(SqlMapper.class);
		
		Map<String, Integer> inven = new HashMap<>();
		inven.put("itemNo", item.getItemNo());
		inven.put("playerNo", pp.getPlayerNo());
		
		int result = mapper.insertforestitem(inven);

		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();

		return result;
	}



}

