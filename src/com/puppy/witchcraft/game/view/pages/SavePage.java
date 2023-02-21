package com.puppy.witchcraft.game.view.pages;

import static com.puppy.witchcraft.common.CommonConstants.changePanel;
import static com.puppy.witchcraft.common.CommonConstants.setButtonColor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.puppy.witchcraft.common.CommonConstants;
import com.puppy.witchcraft.common.MainFrame;
import com.puppy.witchcraft.game.view.MainMap;

public class SavePage extends JPanel{
	
	/* 전역변수에 컬러파레트 지정 */
	private Color MAINCOLOR = CommonConstants.MAINCOLOR;
	private Color NAVYCOLOR = CommonConstants.NAVYCOLOR;

	/* 버튼 내 텍스트크기때문에 폰트 설정 */
	private Font font = new Font("Inter", Font.BOLD, 18);

	/* 전역변수에 계속 쓰일 프레임 및 패널 지정*/
	private MainFrame mf;
	private JPanel savePage;

	/* 생성자 */
	public SavePage(MainFrame mf) {
		
		/*현재 프레임 및 클래스, 패널 set*/
		this.mf = mf;
		this.savePage = this;
		this.setLayout(null);
		this.setBounds(0, 0, 800, 580);
		this.setBackground(Color.BLACK);
		
		/* 좌측상단 세이브버튼 이미지로 생성 */
		JButton saveBtn = new JButton(new ImageIcon("images/ui/ui_save.png"));
		saveBtn.setBounds(20, 20, 50, 50);
		saveBtn.setContentAreaFilled(false);
		// 메인맵으로 이동 시켜야함
		
		/* 다시 메인맵으로 이동 */
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel(mf, savePage, new MainMap(mf));
			}
		});
		
		/* save 버튼 생성 */
		JButton savenowBtn = new JButton("Save");									
		savenowBtn.setBounds(305, 215, 190, 55);
		setButtonColor(savenowBtn, MAINCOLOR, Color.WHITE);
		
		savenowBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		/* save and quit 버튼 생성 */
		JButton saveAndQuitBtn = new JButton("Save and Quit");									
		saveAndQuitBtn.setBounds(305, 280, 190, 55);
		setButtonColor(saveAndQuitBtn, NAVYCOLOR, Color.WHITE);

		saveAndQuitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		/* 패널에 컴포넌트들 삽입 */
		this.add(saveBtn);
		this.add(savenowBtn);
		this.add(saveAndQuitBtn);
		
		/* 프레임에 패널 올리기*/
		mf.add(this);
	}
	
}
