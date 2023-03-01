package com.puppy.witchcraft.game.model.service;

import static com.puppy.witchcraft.common.Template.getSqlSession;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.puppy.witchcraft.game.model.dto.ImageDTO;
import com.puppy.witchcraft.game.model.dto.MyPotionInven;
import com.puppy.witchcraft.game.model.mapper.player.SqlMapper;

public class SelectPotionInvenService {

	private static SqlMapper mapper;

	public List<MyPotionInven> myPotionInven(int playerNo) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(SqlMapper.class);

		List<MyPotionInven> potionList = new ArrayList<>();

		potionList = mapper.myPotionInven(playerNo);

		sqlSession.close();

		return potionList;
	}

	public ImageDTO imageSource(int imageNo) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(SqlMapper.class);

		ImageDTO image = mapper.selectImage(imageNo);

		sqlSession.close();

		return image;
	}

}
