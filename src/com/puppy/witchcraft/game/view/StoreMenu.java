package com.puppy.witchcraft.game.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.puppy.witchcraft.common.MainFrame;
import com.puppy.witchcraft.game.view.pages.StorePage;
import static com.puppy.witchcraft.common.CommonConstants.changePanel;

public class StoreMenu extends JPanel {

	private MainFrame mf;
	private JPanel storeMenu;
	
	public StoreMenu(MainFrame mf) {
		
		/* 현재 프레임 및 클래스 set */
		this.mf = mf;
		this.storeMenu = this;
		
		/* 라벨에 배경이미지 삽입 */
		JLabel background = new JLabel(new ImageIcon("images/background/bg_store.png"));
		background.setBounds(0, -15, 800, 580);
		
		/* 상점이용하기 버튼 생성 후 상점이용하기 이미지 삽입 */
		JButton storeUseBtn = new JButton(new ImageIcon("images/select/store_use.png"));
		storeUseBtn.setBounds(330, 175, 450, 100);
		storeUseBtn.setContentAreaFilled(false);
		
		/* 상점이용하기 버튼 클릭 시 상점 화면 패널로 변경 */
		storeUseBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel(mf, storeMenu, new StorePage(mf));
				System.out.println("상점 이용하기 페이지로 이동");
			}
		});
		/* 나가기 버튼 생성 후 상점 나가기 이미지 삽입 */
		JButton quitBtn = new JButton(new ImageIcon("images/select/map_quit.png"));
		quitBtn.setBounds(330, 275, 450, 100);
		quitBtn.setContentAreaFilled(false);
		
		
		/* 나가기 버튼 클릭 시 메인맵 패널로 변경*/
		quitBtn.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel(mf, storeMenu, new MainMap(mf));
				System.out.println("메인맵 페이지로 이동");
			}
		});
		
		/* 컴포넌트들 넣을 패널 생성 */
		this.setLayout(null);
		this.setBounds(0, 0, 800, 580);
		
		/* 패널에 컴포넌트들 삽입 */
		this.add(storeUseBtn);
		
		this.add(quitBtn);
		
		this.add(background);
		
		/* 프레임에 패널 올리기 */
		mf.add(this);
		
		/* 배경이미지 레이어위치 맨뒤로 보내기 */
		mf.getLayeredPane().setLayer(background, 0);
		
		
	}
}
