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
import com.puppy.witchcraft.game.model.dto.MyItemInven;
import com.puppy.witchcraft.game.model.dto.PlayerDTO;
import com.puppy.witchcraft.game.model.mapper.store.SqlMapper;

public class StorePageService {

	private static SqlMapper mapper;

	//	public StorePageService(StorePageMapper storePageMapper) {
	//		this.mapper = storePageMapper;
	//	}

	//	public List<Map<String, Object>> selectItemList() {
	// 
	//		SqlSession sqlSession = getSqlSession();
	//		mapper = sqlSession.getMapper(StorePageMapper.class);
	//		List<Map<String, Object>> itemList = mapper.selectItemList(sqlSession);
	//		
	//		sqlSession.close();
	//		
	//		return itemList;
	//	}

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



	public int playerGoldChange(JLabel playerGold, PlayerDTO pp) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(SqlMapper.class);
		
		Map<String, Integer> gold = new HashMap<>();
		gold.put("playerNo", pp.getPlayerNo());
		gold.put("playerGold", pp.getPlayerGold());

		int result = mapper.playerGoldChange(gold);

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
}

//	public PlayerDTO playerGoldChange(PlayerDTO playerNo, ItemDTO itemNo) {
//		
//		SqlSession sqlSession = getSqlSession();
//		mapper = sqlSession.getMapper(SqlMapper.class);
//		
//		PlayerDTO pp = mapper.playerGoldChange(playerNo, itemNo);
//		
//		sqlSession.close();
//		
//		return pp;
//	}




