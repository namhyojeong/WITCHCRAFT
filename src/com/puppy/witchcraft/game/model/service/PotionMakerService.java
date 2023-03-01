package com.puppy.witchcraft.game.model.service;

import static com.puppy.witchcraft.common.Template.getSqlSession;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.puppy.witchcraft.game.model.dto.PotionDTO;
import com.puppy.witchcraft.game.model.mapper.craft.SqlMapper;

public class PotionMakerService {
	
	private SqlMapper mapper;

	public boolean insertPotionInven(Map<String, Integer> insert) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(SqlMapper.class);
		
		int result = mapper.insertPotionInven(insert);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result>0? true: false;
	}


	public boolean deleteUseItem(Map<String, Integer> remove) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(SqlMapper.class);
		
		int result = mapper.deleteUseItem(remove);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result>0? true: false;
	}

	public PotionDTO selectPotion(int potionNo) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(SqlMapper.class);
		
		PotionDTO potion = mapper.selectPotion(potionNo);
		
		sqlSession.close();
		
		return potion;
	}



}
