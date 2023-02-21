package com.puppy.witchcraft.common;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.puppy.witchcraft.game.view.GameMenu;

public class MainFrame extends JFrame {
	
	public MainFrame() {
		
		this.setTitle("Witch Craft");		//타이틀
		this.setSize(800,580); 				//창크기 지정
		this.setLayout(null);				//레이아웃을 내맘대로 설정
		this.setResizable(false);			//창 크기 변경 금지
		this.setLocationRelativeTo(null);	//창 가운데에 나오도록
		
		/* 초기 게임 시작화면 생성하면서 현재 설정된 프레임값과 함께 넘어감 */
		new GameMenu(this);
		
		/* 프레임창 아이콘 설정 */
		try {
			this.setIconImage(ImageIO.read(new File("images/ui/icon_frame.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.setVisible(true);									//창이 보이도록
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//JFrame이 정상적으로 종료되게
		
	}

}
