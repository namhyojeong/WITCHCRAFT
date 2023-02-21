package com.puppy.witchcraft.game.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.puppy.witchcraft.common.CommonConstants;
import com.puppy.witchcraft.common.MainFrame;

public class WorkroomQuest extends JPanel {
	
	/* 전역변수에 계속 쓰일 프레임 및 패널 지정*/
	private MainFrame mf;
	private JPanel mainMap;

	/* 생성자 */
	public WorkroomQuest(MainFrame mf) {
		
		/*현재 프레임 및 클래스 set*/
		this.mf = mf;
		this.mainMap = this;
		
		/* 라벨에 배경이미지 삽입*/
		JLabel background = new JLabel(new ImageIcon("images/background/bg_potion.png"));
		background.setBounds(0, -15, 800, 580);

		/* 라벨에 고양이이미지 삽입*/
		JLabel catimage = new JLabel(new ImageIcon("images/background/bg_cat.png"));
		catimage.setBounds(150, 334, 169, 246);	
		
		/* 라벨에 퀘스트두루마리이미지 삽입*/
		JLabel questpaper = new JLabel(new ImageIcon("images/ui/quest_paper.png"));
		questpaper.setBounds(20, 95, 390, 190);	
		
		/* 라벨에 포션목록이미지 삽입*/
		JLabel inventorypotion = new JLabel(new ImageIcon("images/ui/inventory_potion.png"));
		inventorypotion.setBounds(430, 40, 340, 400);	
				
		/* 나가기 버튼 생성 */
		JButton quitBtn = new JButton(new ImageIcon("images/ui/button_quit.png"));
		quitBtn.setBounds(0, 450, 170, 70);
		quitBtn.setContentAreaFilled(false);
				
		
		
		/* 컴포넌트들 넣을 패널 세팅 */
		this.setLayout(null);
		this.setBounds(0, 0, 800, 580);
		
		/* 패널에 컴포넌트들 삽입 */
		this.add(catimage);
		this.add(questpaper);
		this.add(inventorypotion);
		this.add(quitBtn);
		this.add(background);
		
		/* 프레임에 패널 올리기*/
		mf.add(this);

		/* 배경이미지 레이어위치 맨뒤로 보내기 */
		mf.getLayeredPane().setLayer(background, 0);
	}

}
