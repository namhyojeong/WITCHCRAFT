package com.puppy.witchcraft.game.model.dto;

import java.util.List;

public class ItemInven {

	private List<ItemDTO> itemInven;
	
	public ItemInven() {}

	public ItemInven(List<ItemDTO> itemInven) {
		super();
		this.itemInven = itemInven;
	}

	public List<ItemDTO> getItemInven() {
		return itemInven;
	}

	public void setItemInven(List<ItemDTO> itemInven) {
		this.itemInven = itemInven;
	}

	@Override
	public String toString() {
		return "ItemInven [itemInven=" + itemInven + "]";
	}
	
}
