package com.puppy.witchcraft.game.view.pages;

import static com.puppy.witchcraft.common.CommonConstants.changePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.puppy.witchcraft.common.MainFrame;
import com.puppy.witchcraft.game.view.ForestMenu;

public class Forestfirst extends JPanel{

	private MainFrame mf;
	private Forestfirst forestfirst;

	public Forestfirst(MainFrame mf) {

		/*현재 프레임 및 클래스 set*/
		this.mf = mf;
		this.forestfirst = this;

		/* 라벨에 배경이미지 삽입*/
		JLabel background = new JLabel(new ImageIcon("images/background/bg_forest01.png"));
		background.setBounds(0, -15, 800, 580);

		/* 라벨에 타이틀로고 삽입 */
		JLabel logo = new JLabel(new ImageIcon("images/ui/title_logo"));
		logo.setBounds(180, 90, 440, 160);

		/* 숲 1번재료 채집 */
		JButton getItemBtn = new JButton(new ImageIcon("images/select/forest/forest1-touch1.png"));
		getItemBtn.setBounds(190, 410, 115, 95);
		getItemBtn.setContentAreaFilled(false);

		//		getItemBtn.addActionListener(new ActionListener() {
		//			
		//			@Override
		//			public void actionPerformed(ActionEvent e) {
		//				Forest1Controller.getItem1();
		//			}
		//		});

		JButton getItemBtn1 = new JButton(new ImageIcon("images/select/forest/forest1-touch2.png"));
		getItemBtn1.setBounds(500, 275, 115, 95);
		getItemBtn1.setContentAreaFilled(false);

		JButton getItemBtn2 = new JButton(new ImageIcon("images/select/forest/forest1-touch3.png"));
		getItemBtn2.setBounds(540, 60, 115, 95);
		getItemBtn2.setContentAreaFilled(false);

		JButton invenBtn = new JButton(new ImageIcon("images/ui/ui_inventory.png"));
		invenBtn.setBounds(620, 460, 70, 70);
		invenBtn.setContentAreaFilled(false);

		JButton recipeBtn = new JButton(new ImageIcon("images/ui/ui_recipe.png"));
		recipeBtn.setBounds(710, 460, 70, 70);
		recipeBtn.setContentAreaFilled(false);


		JButton forestexit = new JButton(new ImageIcon("images/ui/button_quit.png"));
		forestexit.setBounds(0, 460, 170, 70);
		forestexit.setContentAreaFilled(false);
		forestexit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				changePanel(mf, forestfirst , new ForestMenu(mf));

			}
		});


		/* 나가기 버튼 클릭 시 숲 선택화면으로 이동*/
		forestexit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		/* 컴포넌트들 넣을 패널 생성 */
		this.setLayout(null);
		this.setBounds(0, 0, 800, 580);

		/* 패널에 컴포넌트들 삽입 */
		this.add(logo);

		this.add(getItemBtn);
		this.add(getItemBtn1);
		this.add(getItemBtn2);
		this.add(forestexit);
		this.add(invenBtn);
		this.add(recipeBtn);
		this.add(background);

		/* 프레임에 패널 올리기*/
		mf.add(this);

		/* 배경이미지 레이어위치 맨뒤로 보내기 */
		mf.getLayeredPane().setLayer(background, 0);
	}
}
