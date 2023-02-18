package com.puppy.witchcraft.game.model.dto;

import java.util.List;

public class PotionInven {

	private List<PotionDTO> potionInven;
	
	public PotionInven() {}
	
	public PotionInven(List<PotionDTO> potionInven) {
		super();
		this.potionInven = potionInven;
	}

	public List<PotionDTO> getPotionInven() {
		return potionInven;
	}

	public void setPotionInven(List<PotionDTO> potionInven) {
		this.potionInven = potionInven;
	}

	@Override
	public String toString() {
		return "PotionInven [potionInven=" + potionInven + "]";
	}
	
}
