package com.puppy.witchcraft.game.model.service;

import static com.puppy.witchcraft.common.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.puppy.witchcraft.game.model.dto.ImageDTO;
import com.puppy.witchcraft.game.model.dto.MyInven;
import com.puppy.witchcraft.game.model.mapper.craft.SqlMapper;

public class SelectItemInvenService {
	
	private static SqlMapper mapper;

	public List<MyInven> test(int playerNo) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(SqlMapper.class);
		
		List<MyInven> itemList = mapper.myItemInven(playerNo);
		
		sqlSession.close();
		
		return itemList;
	}

	public ImageDTO imageUrl(int imageNo) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(SqlMapper.class);
		
		ImageDTO image = mapper.imageUrl(imageNo);
		
		sqlSession.close();
		
		return image;
	}

}
