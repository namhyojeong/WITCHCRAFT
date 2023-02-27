package com.puppy.witchcraft.game.view.pages;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.puppy.witchcraft.common.MainFrame;
import com.puppy.witchcraft.game.controller.SelectItemInvenController;
import com.puppy.witchcraft.game.model.dto.MyItemInven;
import com.puppy.witchcraft.game.model.dto.PlayerDTO;

public class ItemInvenDialog extends JDialog{

	private MainFrame mf;
	private PlayerDTO player = new PlayerDTO();
	private List<MyItemInven> itemList = new ArrayList<>();

	public ItemInvenDialog(MainFrame mf) {

		SelectItemInvenController selectItemInvenController = new SelectItemInvenController();

		//현재 프레임 set
		this.mf = mf;
		
		//테스트
		player.setPlayerNo(1);

		//현재 다이얼로그 set
		setTitle("ITEM INVENTORY");
		setLayout(null);
		setBounds(0, 0, 355, 440);

		/* 인벤토리 이미지 생성 */
		JLabel invenBg = new JLabel(new ImageIcon("images/ui/inventory_item.png"));
		invenBg.setBounds(0, 0, 340, 400);

		/* 인벤토리 정렬 버튼 이미지로 생성 */
		JButton alignBtn = new JButton(new ImageIcon("images/ui/button_align.png"));
		alignBtn.setBounds(290, 65, 26, 25);
		alignBtn.setContentAreaFilled(false);
		alignBtn.setBorder(null);

		/* 인벤토리 칸 담을 공간 패널로 생성 */
		JPanel invenPanel = new JPanel();
		invenPanel.setBounds(28, 100, 287, 275);
		invenPanel.setBackground(new Color(255, 0, 0, 0));
		invenPanel.setLayout(new GridLayout(4, 4, 9, 5));

		/* 플레이어 인벤토리 조회 컨트롤러 */
		itemList = selectItemInvenController.myItemInven(player);

		/* 인벤토리 칸 생성 및 클릭 시 요청 */
		List<JButton> blank = new ArrayList<>();

		for(int i = 0; i < 16; i++) {
			blank.add(new JButton());
			blank.get(i).setLayout(null);
			blank.get(i).setSize(63, 63);
			blank.get(i).setBackground(Color.DARK_GRAY);
			blank.get(i).setBorder(null);
			invenPanel.add(blank.get(i));

			if(i < itemList.size()) {

				int index = i;

				/*버튼에 해당 재료 이미지 설정*/
				String imageUrl = selectItemInvenController.itemImage(itemList.get(i));
				blank.get(i).setIcon(new ImageIcon(imageUrl));
				blank.get(i).setHorizontalTextPosition(SwingConstants.CENTER);

				JLabel count = new JLabel(itemList.get(i).getItemCount()+"개");
				count.setBounds(43, 43, 20, 20);
				count.setForeground(Color.WHITE);
				blank.get(i).add(count);

			} else {
				
				blank.get(i).setVisible(false);
			}
		}
		
		invenBg.add(invenPanel);
		invenBg.add(alignBtn);

		/* 패널에 컴포넌트들 삽입 */
		add(invenBg);
		
		setLocation(mf.getLocation().x - 400, mf.getLocation().y);
		setResizable(false);
		setVisible(true);
	}


}
