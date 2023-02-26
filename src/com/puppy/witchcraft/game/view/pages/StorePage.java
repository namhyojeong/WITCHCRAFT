package com.puppy.witchcraft.game.view.pages;

import static com.puppy.witchcraft.common.CommonConstants.changePanel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.puppy.witchcraft.common.MainFrame;
import com.puppy.witchcraft.game.controller.StorePageController;
import com.puppy.witchcraft.game.model.dto.ItemDTO;
import com.puppy.witchcraft.game.model.dto.MyInven;
import com.puppy.witchcraft.game.model.dto.PlayerDTO;
import com.puppy.witchcraft.game.view.StoreMenu;

public class StorePage extends JPanel {

	private MainFrame mf;
	private JPanel storePage;
	private ItemDTO itemDTO;
	private PlayerDTO playerDTO;

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

		/* 라벨에 재료인벤토리 이미지 삽입 */
		JLabel storeSell = new JLabel(new ImageIcon("images/ui/inventory_item.png"));
		storeSell.setBounds(425, 30, 340, 400);

		/* 인벤토리 칸 담을 공간 패널로 생성 */
		JPanel invenPanel = new JPanel();
		invenPanel.setBounds(28, 100, 287, 275);
		invenPanel.setBackground(new Color(255, 0, 0, 0));
		invenPanel.setLayout(new GridLayout(4, 4, 9, 5));
		
		/* 라벨에 골드 이미지 삽입 */
		JLabel gold = new JLabel(new ImageIcon("images/ui/icon_gold.png"));
		gold.setBounds(635, 450, 25, 25);



		/* 라벨에 나가기 버튼 생성 후 나가기이미지 삽입 */
		JButton quitBtn = new JButton(new ImageIcon("images/ui/button_quit.png"));
		quitBtn.setBounds(0, 460, 170, 70);
		quitBtn.setContentAreaFilled(false);
		quitBtn.setBorder(null);

		/* 나가기 버튼 클릭 시 상점 첫 화면 패널로 변경*/
		quitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel(mf, storePage, new StoreMenu(mf));
				System.out.println("상점 첫 화면 페이지로 이동");
			}
		});


		/* 라벨에 상점재료목록 이미지 삽입 */
		JLabel list = new JLabel(new ImageIcon("images/ui/store_list.png"));
		list.setBounds(40, 105, 300, 90);

		/* 상점 재료 담을 공간 패널로 생성 */
		JPanel storePanel = new JPanel();
		storePanel.setBounds(38, 102, 302, 302);
		storePanel.setBackground(new Color(255, 0, 0, 0));
		storePanel.setLayout(new GridLayout(3, 1, 0, 10)); 	//가로 세로 여백
		
		
		/* 재료가 있는 만큼 상점 내에 조회하도록 컨트롤러 요청 */
		StorePageController storePageController = new StorePageController();

		/* 임시플레이어 설정 */
		PlayerDTO pp = new PlayerDTO();
		pp.setPlayerNo(1);
		
		pp.setPlayerGold(1000); 
		
		/* 라벨에 플레이어 골드 생성 */
		JLabel playerGold = new JLabel(pp.getPlayerGold()+"");
		playerGold.setBounds(660, 450, 110, 25);
		playerGold.setForeground(Color.WHITE);
		
		/*인벤에 해당 플레이어의 인벤토리 데이터 담기*/
		List<MyInven> ivenitemList = storePageController.inven(pp);

		for(int i = 0; i < 16; i++) {
			JButton blank = new JButton();
			blank.setName("blank"+i);
			blank.setLayout(null);
			blank.setSize(63, 63);
			blank.setBackground(Color.DARK_GRAY);
			blank.setBorder(null);
			invenPanel.add(blank);

			if(i < ivenitemList.size()) {
				
				blank.setText(ivenitemList.get(i).getItemNo()+"");
				blank.setName(ivenitemList.get(i).getItemNo()+"");
				blank.setForeground(Color.WHITE);
				
				blank.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null,"재료가 판매되었습니다.");
						System.out.println("재료번호 " + blank.getName() + "번 재료를 클릭함");
					}
				});
				
				
				/*버튼에 해당 재료 이미지 설정*/
				String imageUrl = storePageController.imageUrl(ivenitemList.get(i).getImageNo());
				blank.setIcon(new ImageIcon(imageUrl));
				blank.setHorizontalTextPosition(SwingConstants.CENTER);

				JLabel count = new JLabel(ivenitemList.get(i).getItemCount()+"개");
				count.setBounds(43, 43, 20, 20);
				count.setForeground(Color.WHITE);
				blank.add(count);
			} else {
				blank.setVisible(false);
			}
		}

		/*재료 리스트에 올리기 */
		List<ItemDTO> itemList = storePageController.item();

		for(int i = 0; i < 3; i++) {
			JButton blank = new JButton(); 
			blank.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,"재료가 구매되었습니다.");
//					storePageController.insertstoreitem(itemList.get(i), pp);
//					storePageController.playerGoldChange(playerGold, pp);
//					playerGold.setText(pp.getPlayerGold());
				}
			});

			/* 아이템 이름 넣기 */
			JLabel itemName = new JLabel(itemList.get(i).getItemName()+"");
			itemName.setBounds(80, 10, 214, 17);
			blank.add(itemName);
			itemName.setForeground(Color.WHITE);

			/* 아이템 이미지 넣기 */
			JLabel imageUrl = new JLabel(new ImageIcon(storePageController.imageUrl(itemList.get(i).getImageNo())));
			imageUrl.setBounds(10, 10, 64, 64);
			blank.add(imageUrl);

			/* 아이템 설명 넣기 */
			JLabel itemInfo = new JLabel(itemList.get(i).getItemInfo()+"");
			itemInfo.setBounds(80, 20, 214, 51);
			blank.add(itemInfo);
			itemInfo.setForeground(Color.WHITE);

			/* 골드 이미지 넣기 */
			JLabel goldImage = new JLabel(new ImageIcon("images/ui/icon_gold.png"));
			goldImage.setBounds(230, 55, 30, 30);
			blank.add(goldImage);

			/* 아이템 가격 넣기 */
			JLabel goldPrice = new JLabel(itemList.get(i).getItemBuy()+"G");
			goldPrice.setBounds(260, 65, 50, 10);
			blank.add(goldPrice);
			goldPrice.setForeground(Color.WHITE);


			blank.setName(itemList.get(i).getItemNo()+"");
			blank.setLayout(null);
			blank.setSize(302, 93);
			blank.setBackground(Color.DARK_GRAY);
			storePanel.add(blank);

		}

		
		/* 컴포넌트들 넣을 패널 생성 */
		storeSell.add(invenPanel);
		this.setLayout(null);
		this.setBounds(0, 0, 800, 580);

		/* 패널에 컴포넌트들 삽입 */
		this.add(storePanel);
		this.add(list);
		this.add(storePurchase);
		this.add(storeSell);
		this.add(gold);
		this.add(playerGold);
		this.add(quitBtn);
		this.add(background);


		/* 프레임에 패널 올리기 */
		mf.add(this);

		/* 배경이미지 레이어위치 맨뒤로 보내기 */
		mf.getLayeredPane().setLayer(background, 0);

	}
}