package com.puppy.witchcraft.game.model.dto;

public class PlayerDTO {
	
	private int playerNo;
	private String playerId;
	private String playerPwd;
	private String playerNickname;
	private int playerGold;
	
	public PlayerDTO() {}	
	
	public PlayerDTO(int playerNo, String playerId, String playerPwd, String playerNickname, int playerGold) {
		super();
		this.playerNo = playerNo;
		this.playerId = playerId;
		this.playerPwd = playerPwd;
		this.playerNickname = playerNickname;
		this.playerGold = playerGold;
	}

	public int getPlayerNo() {
		return playerNo;
	}

	public void setPlayerNo(int playerNo) {
		this.playerNo = playerNo;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getPlayerPwd() {
		return playerPwd;
	}

	public void setPlayerPwd(String playerPwd) {
		this.playerPwd = playerPwd;
	}

	public String getPlayerNickname() {
		return playerNickname;
	}

	public void setPlayerNickname(String playerNickname) {
		this.playerNickname = playerNickname;
	}

	public int getPlayerGold() {
		return playerGold;
	}

	public void setPlayerGold(int playerGold) {
		this.playerGold = playerGold;
	}

	@Override
	public String toString() {
		return "PlayerDTO [playerNo=" + playerNo + ", playerId=" + playerId + ", playerPwd=" + playerPwd
				+ ", playerNickname=" + playerNickname + ", playerGold=" + playerGold + "]";
	}
	
}
