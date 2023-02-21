package com.puppy.witchcraft.game.view;

import static com.puppy.witchcraft.common.CommonConstants.changePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.puppy.witchcraft.common.MainFrame;
import com.puppy.witchcraft.game.view.pages.Forestfirst;
import com.puppy.witchcraft.game.view.pages.Forestsecond;
import com.puppy.witchcraft.game.view.pages.Forestthird;

public class ForestMenu extends JPanel{

	private MainFrame mf;
	private ForestMenu forestMenu;

	public ForestMenu(MainFrame mf) {

		/*현재 프레임 및 클래스 set*/
		this.mf = mf;
		this.forestMenu = this;

		/* 라벨에 배경이미지 삽입*/
		JLabel background = new JLabel(new ImageIcon("images/background/bg_forestMap.png"));
		background.setBounds(0, -15, 800, 580);

		/* 라벨에 타이틀로고 삽입 */
		JLabel logo = new JLabel(new ImageIcon("images/ui/title_logo"));
		logo.setBounds(180, 90, 440, 160);

		/* 로그인 버튼 생성 */
		JButton forestgoBtn1 = new JButton(new ImageIcon("images/select/forest01_go.png"));
		forestgoBtn1.setBounds(330, 125, 450, 100);
		forestgoBtn1.setContentAreaFilled(false);
		forestgoBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				changePanel(mf, forestMenu , new Forestfirst(mf));
			}
		});
		JButton forestgoBtn2 = new JButton(new ImageIcon("images/select/forest02_go.png"));
		forestgoBtn2.setBounds(330, 225, 450, 100);
		forestgoBtn2.setContentAreaFilled(false);
		forestgoBtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				changePanel(mf, forestMenu , new Forestsecond(mf));
			}
		});
		JButton forestgoBtn3 = new JButton(new ImageIcon("images/select/forest03_go.png"));
		forestgoBtn3.setBounds(330, 325, 450, 100);
		forestgoBtn3.setContentAreaFilled(false);
		forestgoBtn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				changePanel(mf, forestMenu , new Forestthird(mf));
			}
		});

		JButton forestexit = new JButton(new ImageIcon("images/ui/button_quit.png"));
		forestexit.setBounds(0, 460, 170, 70);
		forestexit.setContentAreaFilled(false);

		/* 나가기 버튼 클릭 시 시스템 종료*/
		forestexit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel(mf, forestMenu , new MainMap(mf));
			}
		});


		/* 컴포넌트들 넣을 패널 생성 */
		this.setLayout(null);
		this.setBounds(0, 0, 800, 580);

		/* 패널에 컴포넌트들 삽입 */
		this.add(logo);

		this.add(forestgoBtn1);
		this.add(forestgoBtn2);
		this.add(forestgoBtn3);
		this.add(forestexit);
		this.add(background);

		/* 프레임에 패널 올리기*/
		mf.add(this);

		/* 배경이미지 레이어위치 맨뒤로 보내기 */
		mf.getLayeredPane().setLayer(background, 0);
	}

	public Object getForestgoBtn1() {
		return null;
	}

	public Object getForestgoBtn2() {
		return null;
	}
}
