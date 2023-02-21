package com.puppy.witchcraft.game.view;

import static com.puppy.witchcraft.common.CommonConstants.changePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.puppy.witchcraft.common.MainFrame;
import com.puppy.witchcraft.game.view.pages.PotionCraftPage;
import com.puppy.witchcraft.game.view.pages.WorkroomQuest;

public class WorkroomMenu extends JPanel {
	
	/* 전역변수에 계속 쓰일 프레임 및 패널 지정*/
	private MainFrame mf;
	private WorkroomMenu wrMenu;
	

	/* 생성자 */
	public WorkroomMenu(MainFrame mf) {
		
		/*현재 프레임 및 클래스 set*/
		this.mf = mf;
		this.wrMenu = this;
		
		/* 라벨에 배경이미지 삽입*/
		JLabel background = new JLabel(new ImageIcon("images/background/bg_potion.png"));
		background.setBounds(0, -15, 800, 580);
			
		/* 손님 맞이하기 버튼 생성 */
		JButton greetingsBtn = new JButton(new ImageIcon("images/select/potion_quest.png"));
		greetingsBtn.setBounds(300, 120, 450, 100);
		greetingsBtn.setContentAreaFilled(false);
		
		greetingsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel(mf, wrMenu, new WorkroomQuest(mf));
			}
		});
		
		/* 포션 제작하기 버튼 생성 */
		JButton potioncraftBtn = new JButton(new ImageIcon("images/select/potion_crafting.png"));
		potioncraftBtn.setBounds(300, 225, 450, 100);
		potioncraftBtn.setContentAreaFilled(false);
		
		potioncraftBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel(mf, wrMenu, new PotionCraftPage(mf));
			}
		});
		
		/* 나가기 버튼 생성 */
		JButton quitBtn = new JButton(new ImageIcon("images/select/map_quit.png"));
		quitBtn.setBounds(300, 330, 450, 100);
		quitBtn.setContentAreaFilled(false);
		
		quitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel(mf, wrMenu, new MainMap(mf));
			}
		});
		
		/* 컴포넌트들 넣을 패널 세팅 */
		this.setLayout(null);
		this.setBounds(0, 0, 800, 580);
		
		/* 패널에 컴포넌트들 삽입 */
		this.add(greetingsBtn);
		this.add(potioncraftBtn);
		this.add(quitBtn);
		
		this.add(background);
		
		/* 프레임에 패널 올리기*/
		mf.add(this);

		/* 배경이미지 레이어위치 맨뒤로 보내기 */
		mf.getLayeredPane().setLayer(background, 0);
	}

}
