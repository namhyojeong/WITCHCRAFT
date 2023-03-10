package com.puppy.witchcraft.game.view.pages;

import static com.puppy.witchcraft.common.CommonConstants.changePanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.puppy.witchcraft.common.MainFrame;
import com.puppy.witchcraft.game.controller.PlayerController;
import com.puppy.witchcraft.game.controller.StorePageController;
import com.puppy.witchcraft.game.model.dto.ItemDTO;
import com.puppy.witchcraft.game.model.dto.MyItemInven;
import com.puppy.witchcraft.game.model.dto.PlayerDTO;
import com.puppy.witchcraft.game.view.StoreMenu;

public class StorePage extends JPanel {

	private JPanel storePage;
	private PlayerDTO player;

	public StorePage(MainFrame mf, PlayerDTO playerInfo) {

		PlayerController playerController = new PlayerController();
		StorePageController storePageController = new StorePageController();
		
		player = playerController.getPlayer(playerInfo);
		
		/* 현재 프레임 및 클래스 set */
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
		
		/* 인벤에 해당 플레이어의 인벤토리 데이터 담기 */
		List<MyItemInven> invenItemList = storePageController.myItemInven(player);
		for(int i = 0; i < 16; i++) {
			JButton blank = new JButton();
			blank.setName("blank"+i);
			blank.setLayout(null);
			blank.setSize(63, 63);
			blank.setBackground(Color.DARK_GRAY);
			blank.setBorder(null);
			invenPanel.add(blank);

			if(i < invenItemList.size()) {

				int itemNo = invenItemList.get(i).getItemNo();
				ItemDTO item = storePageController.selectItem(itemNo);
				
				blank.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						JOptionPane.showMessageDialog(null,"재료가 판매되었습니다.");

						storePageController.deleteSellItem(player, itemNo);

						/* 현재 보유 골드에서 판매한 가격 더하기 */
						int gold = player.getPlayerGold() + item.getItemSell();
						
						storePageController.updatePlayerGold(player, gold);

						changePanel(mf, storePage, new StorePage(mf, player));
					}
				});

				/*버튼에 해당 재료 이미지 설정*/
				String imageUrl = storePageController.imageUrl(invenItemList.get(i).getImageNo());
				blank.setIcon(new ImageIcon(imageUrl));
				blank.setHorizontalTextPosition(SwingConstants.CENTER);

				JLabel count = new JLabel(invenItemList.get(i).getItemCount()+"개");
				count.setBounds(43, 43, 20, 20);
				count.setForeground(Color.WHITE);
				blank.add(count);

			} else {
				blank.setVisible(false);
			}
		}
		
		/* 라벨에 골드 이미지 삽입 */
		JLabel gold = new JLabel(new ImageIcon("images/ui/icon_gold.png"));
		gold.setBounds(635, 450, 25, 25);
		
		/* 라벨에 플레이어 골드 생성 */
		JLabel playerGold = new JLabel(player.getPlayerGold()+"");
		playerGold.setBounds(660, 450, 110, 25);
		playerGold.setForeground(Color.WHITE);

		/* 라벨에 나가기 버튼 생성 후 나가기이미지 삽입 */
		JButton quitBtn = new JButton(new ImageIcon("images/ui/button_quit.png"));
		quitBtn.setBounds(0, 460, 170, 70);
		quitBtn.setContentAreaFilled(false);
		quitBtn.setBorder(null);

		/* 나가기 버튼 클릭 시 상점 첫 화면 패널로 변경*/
		quitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel(mf, storePage, new StoreMenu(mf, player));
			}
		});

		/* 라벨에 상점재료목록 이미지 삽입 */
		JLabel list = new JLabel(new ImageIcon("images/ui/store_list.png"));
		list.setBounds(40, 105, 300, 90);
		
		/* 상점 재료 담을 공간 패널로 생성 */
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(38, 100, 320, 300);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVisible(true);

		JPanel scrollPanel = new JPanel();
		scroll.setViewportView(scrollPanel);
		scrollPanel.setLayout(new GridLayout(0, 1, 0, 10));
		scrollPanel.setBackground(Color.DARK_GRAY);
		scrollPanel.setBorder(null);
		scrollPanel.setVisible(true);

		/*상점 재료 리스트에 올리기 */
		List<ItemDTO> itemList = storePageController.item();
		
		for(ItemDTO item : itemList) {
			
			JButton blank = new JButton();
			blank.setPreferredSize(new Dimension(300, 90));
			scrollPanel.add(blank);
			blank.setLayout(null);
			blank.setBackground(Color.DARK_GRAY);
			
			/* 아이템 이름 넣기 */
			JLabel itemName = new JLabel(item.getItemName()+"");
			itemName.setBounds(80, 10, 214, 17);
			blank.add(itemName);
			itemName.setForeground(Color.WHITE);

			/* 아이템 이미지 넣기 */
			JLabel imageUrl = new JLabel(new ImageIcon(storePageController.imageUrl(item.getImageNo())));
			imageUrl.setBounds(10, 13, 64, 64);
			blank.add(imageUrl);

			/* 아이템 설명 넣기 */
			JLabel itemInfo = new JLabel(item.getItemInfo());
			itemInfo.setBounds(80, 17, 210, 50);
			itemInfo.setForeground(Color.WHITE);
			blank.add(itemInfo);

			/* 골드 이미지 넣기 */
			JLabel goldImage = new JLabel(new ImageIcon("images/ui/icon_gold.png"));
			goldImage.setBounds(230, 55, 30, 30);
			blank.add(goldImage);

			/* 아이템 가격 넣기 */
			JLabel goldPrice = new JLabel(item.getItemBuy()+"G");
			goldPrice.setBounds(260, 65, 50, 10);
			goldPrice.setForeground(Color.WHITE);
			blank.add(goldPrice);
			
			blank.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					/* 현재 보유 골드에서 구매한 가격 빼기 */
					int gold = player.getPlayerGold() - item.getItemBuy();
					
					if(gold > 0) {

						JOptionPane.showMessageDialog(null,"재료가 구매되었습니다.");
						
						/* 인벤토리에 상점재료 추가*/
						storePageController.insertstoreitem(item, player);
						
						/* 플레이어 골드 수정 */
						storePageController.updatePlayerGold(player, gold);
						
						/* 패널 새로고침*/
						changePanel(mf, storePage, new StorePage(mf, player));
						scroll.repaint();
						scroll.validate();
						scroll.revalidate();
						
					} else {
						JOptionPane.showMessageDialog(null, "보유 골드가 부족합니다.");
					}
				}
			});
		}

		/* 컴포넌트들 넣을 패널 생성 */
		storeSell.add(invenPanel);
		this.setLayout(null);
		this.setBounds(0, 0, 800, 580);

		/* 패널에 컴포넌트들 삽입 */
		this.add(list);
		this.add(storePurchase);
		this.add(storeSell);
		this.add(gold);
		this.add(playerGold);
		this.add(quitBtn);
		
		this.add(scroll);
		this.add(background);

		/* 프레임에 패널 올리기 */
		mf.add(this);

		/* 배경이미지 레이어위치 맨뒤로 보내기 */
		mf.getLayeredPane().setLayer(background, 0);
	}

}
