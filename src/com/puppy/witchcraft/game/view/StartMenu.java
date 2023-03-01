package com.puppy.witchcraft.game.view;

import static com.puppy.witchcraft.common.CommonConstants.changePanel;
import static com.puppy.witchcraft.common.CommonConstants.setButtonColor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.puppy.witchcraft.common.CommonConstants;
import com.puppy.witchcraft.common.MainFrame;
import com.puppy.witchcraft.game.model.dto.PlayerDTO;

public class StartMenu extends JPanel {

	/* 전역변수에 컬러파레트 지정 */
	private Color MAINCOLOR = CommonConstants.MAINCOLOR;
	private Color GRAYCOLOR = CommonConstants.GRAYCOLOR;

	/* 전역변수에 계속 쓰일 프레임 및 패널 지정 */
	private JPanel startMenu;

	/* 생성자 */
	public StartMenu(MainFrame mf, PlayerDTO player) {

		/*현재 프레임 및 클래스 set*/
		this.startMenu = this;

		/* 라벨에 배경이미지 삽입*/
		JLabel background = new JLabel(new ImageIcon("images/background/bg_start.png"));
		background.setBounds(0, -15, 800, 580);

		/* 라벨에 타이틀로고 삽입 */
		JLabel logo = new JLabel(new ImageIcon("images/ui/title_logo.png"));
		logo.setBounds(140, 120, 523, 190);

		/* 게임시작 버튼 생성 */
		JButton startBtn = new JButton("Start");									
		startBtn.setBounds(305, 358, 190, 55);
		setButtonColor(startBtn, MAINCOLOR, Color.WHITE);

		/* 게임시작 버튼 클릭 시 맵화면 패널로 변경*/
		startBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel(mf, startMenu, new MainMap(mf, player));
			}
		});

		/* 나가기 버튼 생성 */
		JButton quitBtn = new JButton("Quit");
		quitBtn.setBounds(305, 423, 190, 55);
		setButtonColor(quitBtn, GRAYCOLOR, Color.WHITE);

		/* 나가기 버튼 클릭 시 시스템 종료*/
		quitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel(mf, startMenu, new GameMenu(mf));
			}
		});

		/* 컴포넌트들 넣을 패널 생성 */
		this.setLayout(null);
		this.setBounds(0, 0, 800, 580);

		/* 패널에 컴포넌트들 삽입 */
		this.add(logo);
		
		this.add(startBtn);
		this.add(quitBtn);
		
		this.add(background);

		/* 프레임에 패널 올리기*/
		mf.add(this);

		/* 배경이미지 레이어위치 맨뒤로 보내기 */
		mf.getLayeredPane().setLayer(background, 0);
	}


}
