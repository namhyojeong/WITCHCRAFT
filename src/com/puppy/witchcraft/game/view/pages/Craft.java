package com.puppy.witchcraft.game.view.pages;

import java.util.List;

import javax.swing.JButton;

import com.puppy.witchcraft.game.model.dto.MyItemInven;

public class Craft {

	public int resetCraft(List<MyItemInven> clickItems, List<JButton> putList) {

		clickItems.clear();
		for (int i = 0; i < putList.size(); i++) {
			putList.get(i).setIcon(null);
			putList.get(i).setVisible(false);
			putList.get(i).revalidate();
		}

		return 0;
	}

}
