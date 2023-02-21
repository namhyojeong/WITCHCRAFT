package com.puppy.witchcraft.game.view.pages;

import static com.puppy.witchcraft.common.CommonConstants.changePanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.puppy.witchcraft.common.MainFrame;
import com.puppy.witchcraft.game.view.StoreMenu;

public class StorePage extends JPanel {
	
	private MainFrame mf;
	private JPanel storePage;
	
	public StorePage(MainFrame mf) {
		
		/* 현재 프레임 및 클래스 set */
		this.mf = mf;
		this.storePage = this;
		
		/* 라벨에 배경이미지 삽입 */
		JLabel background = new JLabel(new ImageIcon("images/background/bg_store.png"));
		background.setBounds(0, -15, 800, 580);
		
		/* 라벨에 상점재료리스트 이미지 삽입 */
		JLabel storePurchase = new JLabel(new ImageIcon("images/ui/storeitem_list.png"));
		storePurchase.setBounds(20, 30, 340, 400);
//		JScrollPane scrollpane = new JScrollPane(storePurchase, 340, 400); //뷰,수직, 수평.  (수식이 길기 때문에 가독성을 위해서)
//
//		storePurchase.setPreferredSize(new Dimension(2000,2000));
//	    JScrollPane js = new JScrollPane(storePurchase);
//	    
//	    js.setPreferredSize(new Dimension(200,200));
	    
//	    JOptionPane.showMessageDialog(null, js);
		
		/* 라벨에 재료인벤토리 이미지 삽입 */
		JLabel storeSell = new JLabel(new ImageIcon("images/ui/inventory_item.png"));
		storeSell.setBounds(425, 30, 340, 400);
		
		/* 라벨에 골드 이미지 삽입 */
		JLabel gold = new JLabel(new ImageIcon("images/ui/icon_gold.png"));
		gold.setBounds(635, 450, 25, 25);
		
		/* 라벨에 골드 텍스트필드 생성 */
		JLabel textId = new JLabel("     0G");
		textId.setBounds(660, 450, 110, 25);
		textId.setForeground(Color.WHITE);
		
		
		/* 라벨에 나가기 버튼 생성 후 나가기이미지 삽입 */
		JButton quitBtn = new JButton(new ImageIcon("images/ui/button_quit.png"));
		quitBtn.setBounds(0, 460, 170, 70);
		quitBtn.setContentAreaFilled(false);
		
		/* 나가기 버튼 클릭 시 상점 첫 화면 패널로 변경*/
		quitBtn.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel(mf, storePage, new StoreMenu(mf));
				System.out.println("상점 첫 화면 페이지로 이동");
			}
		});
		
		/* 라벨에 재료 클릭 버튼 생성 후 상점재료목록 이미지 삽입 */
		JButton listBtn = new JButton(new ImageIcon("images/ui/store_list.png"));
		listBtn.setBounds(40, 105, 300, 90);
		listBtn.setContentAreaFilled(false);
		
		JButton listBtn1 = new JButton(new ImageIcon("images/ui/store_list.png"));
		listBtn1.setBounds(40, 210, 300, 90);
		listBtn1.setContentAreaFilled(false);
	
		JButton listBtn2 = new JButton(new ImageIcon("images/ui/store_list.png"));
		listBtn2.setBounds(40, 315, 300, 90);
		listBtn2.setContentAreaFilled(false);
		
		/* 컴포넌트들 넣을 패널 생성 */
		this.setLayout(null);
		this.setBounds(0, 0, 800, 580);
		
		/* 패널에 컴포넌트들 삽입 */
		this.add(listBtn2);
		this.add(listBtn1);
		this.add(listBtn);
		this.add(storePurchase);
		this.add(storeSell);
		this.add(gold);
		this.add(textId);
		this.add(quitBtn);
		this.add(background);
		
		/* 프레임에 패널 올리기 */
		mf.add(this);
		
		/* 배경이미지 레이어위치 맨뒤로 보내기 */
		mf.getLayeredPane().setLayer(background, 0);

	}

}
