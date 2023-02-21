package com.puppy.witchcraft.run;

import com.puppy.witchcraft.common.MainFrame;
import com.puppy.witchcraft.game.view.pages.WorkroomMenu;
import com.puppy.witchcraft.game.view.pages.WorkroomQuest;

public class Application {

	public static void main(String[] args) {
		
		MainFrame mf = new MainFrame();
		new WorkroomQuest(mf);
		
	}

}
