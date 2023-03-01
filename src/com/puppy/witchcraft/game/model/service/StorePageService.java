package com.puppy.witchcraft.game.model.service;

import static com.puppy.witchcraft.common.Template.getSqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;

import org.apache.ibatis.session.SqlSession;

import com.puppy.witchcraft.game.model.dto.ImageDTO;
import com.puppy.witchcraft.game.model.dto.ItemDTO;
import com.puppy.witchcraft.game.model.dto.ItemInvenDTO;
import com.puppy.witchcraft.game.model.dto.MyItemInven;
import com.puppy.witchcraft.game.model.dto.PlayerDTO;
import com.puppy.witchcraft.game.model.mapper.store.SqlMapper;

public class StorePageService {

	private static SqlMapper mapper;

	public static List<ItemDTO> test() {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(SqlMapper.class);

		List<ItemDTO> itemList = mapper.storeList();

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

	public int insertstoreitem(ItemDTO item, PlayerDTO pp) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(SqlMapper.class);

		Map<String, Integer> inven = new HashMap<>();
		inven.put("itemNo", item.getItemNo());
		inven.put("playerNo", pp.getPlayerNo());

		int result = mapper.insertstoreitem(inven);

		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();

		return result;
	}

	public List<MyItemInven> myItemInven(int playerNo) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(SqlMapper.class);

		List<MyItemInven> itemList = new ArrayList<>();

		itemList = mapper.myItemInven(playerNo);

		sqlSession.close();

		return itemList;
	}

	public boolean deleteSellItem(Map<String, Integer> delete) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(SqlMapper.class);
		
		int result = mapper.deleteSellItem(delete);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0? true: false;
	}
	

	public boolean updatePlayerGold(Map<String, Integer> gold) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(SqlMapper.class);

		int result = mapper.updatePlayerGold(gold);

		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();

		return result > 0? true: false;
	}

	public ItemDTO selectItem(int itemNo) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(SqlMapper.class);

		ItemDTO item = mapper.selectItem(itemNo);
		
		return item;
	}

}
