package com.puppy.witchcraft.game.model.service;

public class itemrand {

	public static int randomitem1() {
		
		int temp = ((int) (Math.random() * 3)+1);

		return temp;
	}




	public static int randomitem2() {

	int temp = ((int) (Math.random() * 4)+3);
	
	return temp;
}
	
	

	public static int randomitem3() {

	int temp = ((int) (Math.random() * 5)+4);
	
	return temp;
}
}
