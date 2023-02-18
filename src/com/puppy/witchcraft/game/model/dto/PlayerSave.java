package com.puppy.witchcraft.game.model.dto;

public class PlayerSave {
	
	private int playerNo;
	private int QuestNo;
	private int chapNo;
	
	public PlayerSave() {}

	public PlayerSave(int playerNo, int questNo, int chapNo) {
		super();
		this.playerNo = playerNo;
		QuestNo = questNo;
		this.chapNo = chapNo;
	}

	public int getPlayerNo() {
		return playerNo;
	}

	public void setPlayerNo(int playerNo) {
		this.playerNo = playerNo;
	}

	public int getQuestNo() {
		return QuestNo;
	}

	public void setQuestNo(int questNo) {
		QuestNo = questNo;
	}

	public int getChapNo() {
		return chapNo;
	}

	public void setChapNo(int chapNo) {
		this.chapNo = chapNo;
	}

	@Override
	public String toString() {
		return "PlayerSave [playerNo=" + playerNo + ", QuestNo=" + QuestNo + ", chapNo=" + chapNo + "]";
	}
	
}
