package com.puppy.witchcraft.game.view.pages;

import static com.puppy.witchcraft.common.CommonConstants.changePanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.puppy.witchcraft.common.MainFrame;
import com.puppy.witchcraft.game.model.dto.ItemDTO;
import com.puppy.witchcraft.game.model.dto.PlayerDTO;
import com.puppy.witchcraft.game.view.MainMap;
import com.puppy.witchcraft.game.view.WorkroomMenu;

public class PotionCraftPage extends JPanel{

	/* 전역변수에 계속 쓰일 프레임 및 패널 지정*/
	private MainFrame mf;
	private JPanel potionCraftPage;

	public PotionCraftPage(MainFrame mf) {

		/*현재 프레임 및 클래스 set*/
		this.mf = mf;
		this.potionCraftPage = this;

		/* 라벨에 배경이미지 삽입*/
		JLabel background = new JLabel(new ImageIcon("images/background/bg_potion_crafting.png"));
		background.setBounds(0, -15, 800, 580);

		/* 나가기 버튼 이미지로 생성 */
		JButton quitBtn = new JButton(new ImageIcon("images/ui/button_quit.png"));
		quitBtn.setBounds(0, 460, 170, 70);
		quitBtn.setContentAreaFilled(false);

		/* 나가기 버튼 클릭 시 메인맵 패널로 변경*/
		quitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel(mf, potionCraftPage, new WorkroomMenu(mf));
			}
		});

		/* 인벤토리 버튼 이미지로 생성 */
		JButton invenBtn = new JButton(new ImageIcon("images/ui/ui_inventory.png"));
		invenBtn.setBounds(620, 460, 70, 70);
		invenBtn.setContentAreaFilled(false);

		/* 레시피도감 버튼 이미지로 생성 */
		JButton recipeBtn = new JButton(new ImageIcon("images/ui/ui_recipe.png"));
		recipeBtn.setBounds(710, 460, 70, 70);
		recipeBtn.setContentAreaFilled(false);

		//기본 ui 세팅

		/* 가마솥 버튼 이미지로 생성 */
		JButton touchCaldronBtn = new JButton(new ImageIcon("images/ui/caldron.png"));
		touchCaldronBtn.setBounds(115, 230, 220, 250);
		touchCaldronBtn.setContentAreaFilled(false);

		/* 선택된 재료전시대 이미지 생성 */
		JLabel putUp = new JLabel(new ImageIcon("images/ui/select_item.png"));
		putUp.setBounds(85, 125, 280, 70);

		/* 제작 설명 */
		JLabel info = new JLabel("재료를 다 넣은 후 숱을 눌러 제작해주세요!");
		info.setBounds(120, 105, 220, 12);
		info.setFont(new Font("Sans Serif", Font.PLAIN, 11));
		info.setForeground(Color.WHITE);

		/* 인벤토리 이미지 생성 */
		JLabel inven = new JLabel(new ImageIcon("images/ui/inventory_item.png"));
		inven.setBounds(435, 40, 340, 400);

		/* 인벤토리 정렬 버튼 이미지로 생성 */
		JButton alignBtn = new JButton(new ImageIcon("images/ui/button_align.png"));
		alignBtn.setBounds(290, 65, 26, 25);
		alignBtn.setContentAreaFilled(false);

		/* 인벤토리 칸 담을 공간 패널로 생성 */
		JPanel test = new JPanel();
		test.setBounds(29, 101, 287, 290);
		test.setBackground(new Color(255, 0, 0, 0));
		test.setLayout(null);

		/* 재료가 있는 만큼... 생성하도록 컨트롤러 요청*/

		JButton blank1 = new JButton("재료");
		blank1.setBounds(0, 0, 63, 63);

		PlayerDTO player = new PlayerDTO();
		player.setPlayerNo(1);

		//				blank1.addActionListener(new ActionListener() {
		//					
		//					@Override
		//					public void actionPerformed(ActionEvent e) {
		//						TestController testController = new TestController(); 
		//						ItemDTO item = testController.test();
		//						System.out.println(item.getItemNo());
		//					}
		//				});

		//		JButton blank2 = new JButton("재료");
		//		blank2.setBounds(74, 0, 63, 63);
		//		
		//		JButton blank3 = new JButton("재료");
		//		blank3.setBounds(148, 0, 63, 63);
		//		
		//		JButton blank4 = new JButton("재료");
		//		blank4.setBounds(222, 0, 63, 63);
		//		
		test.add(blank1);
		//		test.add(blank2);
		//		test.add(blank3);
		//		test.add(blank4);

		//		for(int j = 0; j < 4; j++) {
		//			for(int i = 0; i < 4; i++) {
		//				JButton blank = new JButton();
		//				blank.setBounds(i*74, j*70, 63, 63);
		//				blank.setBackground(Color.DARK_GRAY); // test
		//				blank.setLayout(null);
		//				
		//				JLabel count = new JLabel("0개");
		//				count.setBounds(35, 40, 20, 20);
		//				count.setForeground(Color.WHITE);
		//				
		//				blank.add(count);
		//				test.add(blank);
		//			}
		//		}

		/* 컴포넌트들 넣을 패널 세팅 */

		this.setLayout(null);
		this.setBounds(0, 0, 800, 580);

		/* 패널에 컴포넌트들 삽입 */
		inven.add(test);
		inven.add(alignBtn);
		this.add(inven);

		this.add(quitBtn);
		this.add(invenBtn);
		this.add(recipeBtn);

		this.add(info);
		this.add(putUp);
		this.add(touchCaldronBtn);

		this.add(background);

		/* 프레임에 패널 올리기*/
		mf.add(this);

		/* 배경이미지 레이어위치 맨뒤로 보내기 */
		mf.getLayeredPane().setLayer(background, 0);
	}

}
