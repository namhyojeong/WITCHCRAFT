package com.puppy.witchcraft.game.view.pages;

import static com.puppy.witchcraft.common.CommonConstants.changePanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.puppy.witchcraft.common.Craft;
import com.puppy.witchcraft.common.MainFrame;
import com.puppy.witchcraft.game.controller.PotionMakerController;
import com.puppy.witchcraft.game.controller.SelectItemInvenController;
import com.puppy.witchcraft.game.controller.SelectRecipeController;
import com.puppy.witchcraft.game.model.dto.MyItemInven;
import com.puppy.witchcraft.game.model.dto.PlayerDTO;
import com.puppy.witchcraft.game.model.dto.PotionDTO;
import com.puppy.witchcraft.game.model.dto.RecipeAndPotion;
import com.puppy.witchcraft.game.model.dto.RecipeDTO;
import com.puppy.witchcraft.game.view.WorkroomMenu;

public class PotionCraftPage extends JPanel{

	/* 전역변수에 계속 쓰일 프레임 및 패널 지정*/
	private JPanel potionCraftPage;
	private List<MyItemInven> clickItemList = new ArrayList<>();
	private List<JButton> putList = new ArrayList<>();
	private List<JLabel> count = new ArrayList<>();
	private List<MyItemInven> itemList = new ArrayList<>();
	private int putIndex = 0;

	Craft craft = new Craft();

	public PotionCraftPage(MainFrame mf, PlayerDTO player) {

		SelectItemInvenController selectItemInvenController = new SelectItemInvenController();
		SelectRecipeController selectRecipeController = new SelectRecipeController();
		PotionMakerController pmController = new PotionMakerController();

		/*현재 프레임 및 클래스 set*/
		this.potionCraftPage = this;

		/* 컴포넌트들 넣을 패널 세팅 */
		this.setLayout(null);
		this.setBounds(0, 0, 800, 580);

		/* 라벨에 배경이미지 삽입*/
		JLabel background = new JLabel(new ImageIcon("images/background/bg_potion_crafting.png"));
		background.setBounds(0, -15, 800, 580);

		/* 나가기 버튼 이미지로 생성 */
		JButton quitBtn = new JButton(new ImageIcon("images/ui/button_quit.png"));
		quitBtn.setBounds(0, 460, 170, 70);
		quitBtn.setContentAreaFilled(false);
		quitBtn.setBorder(null);

		/* 나가기 버튼 클릭 시 메인맵 패널로 변경*/
		quitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel(mf, potionCraftPage, new WorkroomMenu(mf, player));
			}
		});

		/* 레시피도감 버튼 이미지로 생성 */
		JButton recipeBtn = new JButton(new ImageIcon("images/ui/ui_recipe.png"));
		recipeBtn.setBounds(710, 460, 70, 70);
		recipeBtn.setContentAreaFilled(false);
		recipeBtn.setBorder(null);
		recipeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new RecipeDialog(mf);
			}
		});

		//기본 ui 세팅 끝

		/* 제작 설명 */
		JLabel info = new JLabel("재료를 다 넣은 후 숱을 눌러 제작해주세요!");
		info.setBounds(120, 105, 220, 12);
		info.setFont(new Font("Sans Serif", Font.PLAIN, 11));
		info.setForeground(Color.WHITE);

		/* 가마솥 위에 글자 추가 */
		JLabel touch = new JLabel("T O U C H");
		touch.setFont(new Font("Sans Serif", Font.BOLD, 25));
		touch.setForeground(Color.WHITE);
		touch.setBounds(55, 130, 120, 50);

		/* 선택된 재료전시대 이미지 생성 */
		JLabel putUp = new JLabel(new ImageIcon("images/ui/select_item.png"));
		putUp.setBounds(85, 125, 280, 70);
		putUp.setLayout(null);

		/* 클릭된 아이템 보일 공간 패널로 생성 */
		JPanel putPanel = new JPanel();
		putPanel.setBounds(75, 130, 300, 60);
		putPanel.setBackground(new Color(255, 0, 0, 0));
		putPanel.setLayout(new GridLayout(1, 5, 0, 0));

		for(int i = 0; i < 5; i++) {
			putList.add(new JButton());
			putList.get(i).setLayout(null);
			putList.get(i).setSize(60, 60);
			putList.get(i).setBorder(null);
			putList.get(i).setVisible(false);

			count.add(new JLabel("1"));
			count.get(i).setBounds(50, 45, 10, 15);
			count.get(i).setFont(new Font("Sans Serif", Font.BOLD, 18));
			putList.get(i).add(count.get(i));

			putPanel.add(putList.get(i));
		}

		//모든 레시피
		List<RecipeAndPotion> recipeAllList = selectRecipeController.selectAllRecipe();

		/* 가마솥 버튼 이미지로 생성 */
		JButton touchCaldronBtn = new JButton(new ImageIcon("images/ui/caldron.png"));
		touchCaldronBtn.setBounds(115, 230, 220, 250);
		touchCaldronBtn.setContentAreaFilled(false);
		touchCaldronBtn.setLayout(null);
		touchCaldronBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				boolean result = false;
				PotionDTO potion = new PotionDTO();
				// 포션 인벤토리에 포션 추가
				boolean isPotionGet = false;

				/* 아이템 리스트로 변환 */
				List<Integer> clickRecipeItemList = new ArrayList<>();

				for (MyItemInven item : clickItemList) {
					clickRecipeItemList.add(item.getItemNo());
				}

				/* 레시피 휘뚜루 쫘아악 체크 */
				for (int k = 0; k < recipeAllList.size(); k++) {

					//한 레시피에 대한 아이템 리스트
					List<Integer> recipeItemNoList = new ArrayList<>();

					/* 현재 레시피... */
					List<RecipeDTO> recipe = selectRecipeController.selectRecipe(k + 1);

					for (int j = 0; j < recipe.size(); j++) {

						recipeItemNoList.add(recipe.get(j).getItemNo());
					}

					if(clickRecipeItemList.containsAll(recipeItemNoList) && recipeItemNoList.containsAll(clickRecipeItemList)) {
						
						System.out.println("===============================================");
						System.out.println("===============================================");
						System.out.println(recipeItemNoList);
						System.out.println(clickRecipeItemList);
						System.out.println("===============================================");
						System.out.println("===============================================");
						
						potion = pmController.selectPotion(recipe.get(k).getPotionNo());
						isPotionGet = pmController.insertPotionInven(player, potion.getPotionNo());
						result = true;
						break;
					}
				}

				if(result && isPotionGet) {

					JOptionPane.showMessageDialog(null, potion.getPotionName() + "이 제작되었습니다!");

					// 재료 인벤토리에 재료 삭제
					for(int itemNo : clickRecipeItemList) {
						pmController.deleteUseItem(player, itemNo);
					}
					// 패널 새로 고침
					changePanel(mf, potionCraftPage, new PotionCraftPage(mf, player));
					new PotionInvenDialog(mf, player);

				} else {
					JOptionPane.showMessageDialog(null, "제작 가능한 포션이 없습니다.");
				}

				clickRecipeItemList.clear();
				revalidate();
				repaint();
				putIndex = craft.resetCraft(clickItemList, putList);

			}
		});

		/* 인벤토리 이미지 생성 */
		JLabel invenBg = new JLabel(new ImageIcon("images/ui/inventory_item.png"));
		invenBg.setBounds(435, 40, 340, 400);

		/* 인벤토리 정렬 버튼 이미지로 생성 */
		JButton alignBtn = new JButton(new ImageIcon("images/ui/button_align.png"));
		alignBtn.setBounds(290, 65, 26, 25);
		alignBtn.setContentAreaFilled(false);
		alignBtn.setBorder(null);

		/* 인벤토리 칸 담을 공간 패널로 생성 */
		JPanel invenPanel = new JPanel();
		invenPanel.setBounds(28, 100, 287, 275);
		invenPanel.setBackground(new Color(255, 0, 0, 0));
		invenPanel.setLayout(new GridLayout(4, 4, 9, 5));

		/* 플레이어 인벤토리 조회 컨트롤러 */
		itemList = selectItemInvenController.myItemInven(player);

		/* 인벤토리 칸 생성 및 클릭 시 요청 */
		List<JButton> blank = new ArrayList<>();

		for(int i = 0; i < 16; i++) {
			blank.add(new JButton());
			blank.get(i).setLayout(null);
			blank.get(i).setSize(63, 63);
			blank.get(i).setBackground(Color.DARK_GRAY);
			blank.get(i).setBorder(null);
			invenPanel.add(blank.get(i));

			if(i < itemList.size()) {

				int index = i;

				blank.get(i).addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						revalidate();
						repaint();

						int clickCount = Collections.frequency(clickItemList, itemList.get(index)) + 1;

						boolean hasItem = clickItemList.contains(itemList.get(index));

						if(putIndex < 5 && hasItem == false) {	//처음 넣을 때

							/* 제작대에 클릭한 아이템 올리기 */
							clickItemList.add(itemList.get(index));

							/* 제작대에 클릭한 아이템이 보이도록 컨트롤러 요청 */
							putList.get(putIndex).setVisible(true);
							putList.get(putIndex).setIcon(new ImageIcon(selectItemInvenController.itemImage(itemList.get(index))));
							putList.get(putIndex).setHorizontalTextPosition(SwingConstants.CENTER);

							/* 제작대 위 아이템 개수 변경 */
							count.get(putIndex).setText(clickCount + "");

							putIndex++;

						} else if(hasItem == true && clickCount <= itemList.get(index).getItemCount()) {

							/* 제작대에 클릭한 아이템 올리기 */
							clickItemList.add(itemList.get(index));

							/* 제작대 개수 변경 */
							count.get(putIndex - 1).setText(clickCount + "");

						} else {
							JOptionPane.showMessageDialog(null, "더이상 넣을 수 있는 재료가 없습니다!");
						}
					}

				});

				/*버튼에 해당 재료 이미지 설정*/
				String imageUrl = selectItemInvenController.itemImage(itemList.get(i));
				blank.get(i).setIcon(new ImageIcon(imageUrl));
				blank.get(i).setHorizontalTextPosition(SwingConstants.CENTER);

				JLabel count = new JLabel(itemList.get(i).getItemCount()+"개");
				count.setBounds(43, 43, 20, 20);
				count.setForeground(Color.WHITE);
				blank.get(i).add(count);

			} else {
				blank.get(i).setVisible(false);
			}
		}

		/* 컴포넌트 세팅 */
		touchCaldronBtn.add(touch);

		invenBg.add(invenPanel);
		invenBg.add(alignBtn);

		/* 패널에 컴포넌트들 삽입 */
		this.add(invenBg);
		this.add(quitBtn);
		this.add(recipeBtn);
		this.add(info);
		this.add(putPanel);
		this.add(putUp);
		this.add(touchCaldronBtn);

		this.add(background);

		/* 프레임에 패널 올리기*/
		mf.add(this);

		/* 배경이미지 레이어위치 맨뒤로 보내기 */
		mf.getLayeredPane().setLayer(background, 0);
	}

}
