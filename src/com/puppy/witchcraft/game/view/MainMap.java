package com.puppy.witchcraft.game.view;

import static com.puppy.witchcraft.common.CommonConstants.changePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.puppy.witchcraft.common.MainFrame;
import com.puppy.witchcraft.game.view.pages.SavePage;

public class MainMap extends JPanel {
	
	/* 전역변수에 계속 쓰일 프레임 및 패널 지정*/
	private MainFrame mf;
	private JPanel mainMap;

	/* 생성자 */
	public MainMap(MainFrame mf) {
		
		/*현재 프레임 및 클래스 set*/
		this.mf = mf;
		this.mainMap = this;
		
		/* 라벨에 배경이미지 삽입*/
		JLabel background = new JLabel(new ImageIcon("images/background/bg_mainMap.png"));
		background.setBounds(0, -15, 800, 580);
		
		/* 좌측상단 세이브버튼 이미지로 생성 */
		JButton saveBtn = new JButton(new ImageIcon("images/ui/ui_save.png"));
		saveBtn.setBounds(20, 20, 50, 50);
		saveBtn.setContentAreaFilled(false);
		
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel(mf, mainMap, new SavePage(mf));
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
		
		/* 포션가게(작업실)로 가는 버튼 이미지로 생성 */
		JButton potionBtn = new JButton(new ImageIcon("images/ui/button_potion.png"));
		potionBtn.setBounds(300, 100, 100, 55);
		potionBtn.setContentAreaFilled(false);
		
		/* 포션가게 버튼 클릭 시 포션가게 패널로 변경*/
		potionBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel(mf, mainMap, new WorkroomMenu(mf));
			}
		});
		
		/* 숲으로 가는 버튼 이미지로 생성 */
		JButton forestBtn = new JButton(new ImageIcon("images/ui/button_forest.png"));
		forestBtn.setBounds(600, 350, 100, 55);
		forestBtn.setContentAreaFilled(false);
		
		/* 숲 버튼 클릭 시 숲 패널로 변경*/
		forestBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel(mf, mainMap, new ForestMenu(mf));
			}
		});
		
		/* 상점으로 가는 버튼 이미지로 생성 */
		JButton storeBtn = new JButton(new ImageIcon("images/ui/button_store.png"));
		storeBtn.setBounds(140, 350, 100, 55);
		storeBtn.setContentAreaFilled(false);
		
		/* 상점 버튼 클릭 시 상점 패널로 변경*/
		storeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel(mf, mainMap, new StoreMenu(mf)); //임시로 포션제작페이지로 이동
			}
		});
		
		/* 컴포넌트들 넣을 패널 세팅 */
		this.setLayout(null);
		this.setBounds(0, 0, 800, 580);
		
		/* 패널에 컴포넌트들 삽입 */
		this.add(saveBtn);
		this.add(invenBtn);
		this.add(recipeBtn);
		
		this.add(potionBtn);
		this.add(forestBtn);
		this.add(storeBtn);
		
		this.add(background);
		
		/* 프레임에 패널 올리기*/
		mf.add(this);

		/* 배경이미지 레이어위치 맨뒤로 보내기 */
		mf.getLayeredPane().setLayer(background, 0);
	}

}
