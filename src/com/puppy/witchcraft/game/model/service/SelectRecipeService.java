package com.puppy.witchcraft.game.model.service;

import static com.puppy.witchcraft.common.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.puppy.witchcraft.game.model.dto.ImageDTO;
import com.puppy.witchcraft.game.model.dto.PotionDTO;
import com.puppy.witchcraft.game.model.dto.RecipeAndPotion;
import com.puppy.witchcraft.game.model.dto.RecipeDTO;
import com.puppy.witchcraft.game.model.mapper.craft.SqlMapper;

public class SelectRecipeService {
	
	private static SqlMapper mapper;
	
	public List<RecipeAndPotion> selectAllRecipe() {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(SqlMapper.class);
		
		List<RecipeAndPotion> recipeAllList = mapper.selectAllRecipe();
		
		sqlSession.close();
		
		return recipeAllList;
	}
	

	public List<RecipeDTO> selectRecipe(int recipeNo) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(SqlMapper.class);
		
		List<RecipeDTO> recipeList = mapper.selectRecipe(recipeNo);
		
		sqlSession.close();
		
		return recipeList;
	}

	public PotionDTO selectPotion(int potionNo) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(SqlMapper.class);
		
		PotionDTO potion = mapper.selectPotion(potionNo);
		
		sqlSession.close();
		
		return potion;
	}
	
	public ImageDTO image(int imageNo) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(SqlMapper.class);
		
		ImageDTO image = mapper.selectImage(imageNo);
		
		sqlSession.close();
		
		return image;
	}

	
	
}
