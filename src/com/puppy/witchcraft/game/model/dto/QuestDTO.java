package com.puppy.witchcraft.game.model.dto;

public class QuestDTO {
	
	private int chapNo;
	private int questNo;
	private int npcAge;
	private String npcGender;
	private String npcSick;		 //환자가 말하는 증상 및 필요한 포션
	private String npcName;

	public QuestDTO() {}

	public QuestDTO(int chapNo, int questNo, int npcAge, String npcGender, String npcSick, String npcName) {
		super();
		this.chapNo = chapNo;
		this.questNo = questNo;
		this.npcAge = npcAge;
		this.npcGender = npcGender;
		this.npcSick = npcSick;
		this.npcName = npcName;
	}

	public int getChapNo() {
		return chapNo;
	}

	public void setChapNo(int chapNo) {
		this.chapNo = chapNo;
	}

	public int getQuestNo() {
		return questNo;
	}

	public void setQuestNo(int questNo) {
		this.questNo = questNo;
	}

	public int getNpcAge() {
		return npcAge;
	}

	public void setNpcAge(int npcAge) {
		this.npcAge = npcAge;
	}

	public String getNpcGender() {
		return npcGender;
	}

	public void setNpcGender(String npcGender) {
		this.npcGender = npcGender;
	}

	public String getNpcSick() {
		return npcSick;
	}

	public void setNpcSick(String npcSick) {
		this.npcSick = npcSick;
	}

	public String getNpcName() {
		return npcName;
	}

	public void setNpcName(String npcName) {
		this.npcName = npcName;
	}

	@Override
	public String toString() {
		return "QuestDTO [chapNo=" + chapNo + ", questNo=" + questNo + ", npcAge=" + npcAge + ", npcGender=" + npcGender
				+ ", npcSick=" + npcSick + ", npcName=" + npcName + "]";
	}

}
