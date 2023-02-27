package com.puppy.witchcraft.game.view.pages;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import com.puppy.witchcraft.common.MainFrame;
import com.puppy.witchcraft.game.controller.SelectRecipeController;
import com.puppy.witchcraft.game.model.dto.ItemDTO;
import com.puppy.witchcraft.game.model.dto.PotionDTO;
import com.puppy.witchcraft.game.model.dto.RecipeAndPotion;
import com.puppy.witchcraft.game.model.dto.RecipeDTO;

public class RecipeDialog extends JDialog{

	private MainFrame mf;

	public RecipeDialog(MainFrame mf) {

		SelectRecipeController selectRecipeController = new SelectRecipeController();

		this.mf = mf;

		setTitle("RECIPE");
		setLayout(null);
		setBounds(0, 0, 505, 500);

		JLabel background = new JLabel(new ImageIcon("images/ui/recipe_box.png"));
		background.setBounds(-5, -5, 500, 470);
		background.setHorizontalTextPosition(SwingConstants.CENTER);

		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(15, 85, 460, 350);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		JPanel scrollPanel = new JPanel();
		scroll.setViewportView(scrollPanel);
		scrollPanel.setLayout(new GridLayout(0, 1, 0, 5));
		scrollPanel.setBackground(Color.BLACK);
		scrollPanel.setBorder(null);

		/* 모든 레시피 담기 */
		List<RecipeAndPotion> recipeAllList = selectRecipeController.selectAllRecipe();

		/* 레시피당 패널 만들기 */
		for(int i=0; i < recipeAllList.size(); i++) {
			JPanel rowPanel = new JPanel();
			rowPanel.setPreferredSize(new Dimension(450,150));
			scrollPanel.add(rowPanel);
			rowPanel.setLayout(null);
			rowPanel.setBackground(Color.BLACK);

			/* 레시피와 연결된 포션 */
			int potionNo = recipeAllList.get(i).getPotionNo();
			PotionDTO potion = selectRecipeController.selectPotion(potionNo);

			/* 포션의 이미지 번호를 전달해서 포션 이미지소스 가져오기 */
			String potionSource = selectRecipeController.potionImage(potion);
			Image potionimg = new ImageIcon(potionSource).getImage();
			Image imgResize = potionimg.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);

			JLabel potionImgLabel = new JLabel(new ImageIcon(imgResize));
			potionImgLabel.setBounds(10, 15, 120, 120);

			/* 레시피 이름*/
			JLabel name = new JLabel(potion.getPotionName() + " 레시피");
			name.setBounds(140, 10, 300, 20);
			name.setFont(new Font("Sans Serif", Font.BOLD, 18));
			name.setForeground(Color.WHITE);

			/*레시피 포션 설명*/
			JTextArea info = new JTextArea(potion.getPotionInfo());
			info.setBounds(140, 35, 300, 50);
			info.setFont(new Font("Sans Serif", Font.ITALIC, 15));
			info.setForeground(Color.WHITE);
			info.setBackground(Color.BLACK);
			info.setLineWrap(true);
			info.setEditable(false);

			/* 필요재료 담을 패널 생성 */
			JPanel itemPanel = new JPanel();
			itemPanel.setBounds(140, 85, 300, 50);
			itemPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
			itemPanel.setBackground(Color.BLACK);

			/* 현재 레시피... */
			int recipeNo = i + 1;
			List<RecipeDTO> recipe = selectRecipeController.selectRecipe(recipeNo);

			/* 현재 레시피에서 필요아이템 리스트 */
			List<ItemDTO> recipeItemList = recipeAllList.get(i).getItemList();

			int index = 0;
			for(ItemDTO recipeItem : recipeItemList) {

				System.out.println(recipeItem);

				String itemSource = selectRecipeController.itemImage(recipeItem);
				Image itemimg = new ImageIcon(itemSource).getImage();
				Image itemImgResize = itemimg.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
				JLabel itemLabel = new JLabel(new ImageIcon(itemImgResize));
				itemLabel.setSize(50, 50);

				if(index < recipe.size()) {
					JLabel count = new JLabel("0");
					count.setText(recipe.get(index).getItemCount() + "");
					count.setBounds(20, 10, 30, 30);
					count.setFont(new Font("Sans Serif", Font.BOLD, 20));
					count.setForeground(Color.WHITE);

					index++;

					itemLabel.add(count);
				}

				itemPanel.add(itemLabel);
			}

			rowPanel.add(itemPanel);
			rowPanel.add(potionImgLabel);
			rowPanel.add(name);
			rowPanel.add(info);
		}

		add(scroll);
		add(background);

		setLocation(mf.getLocation().x + 800, mf.getLocation().y);
		setResizable(false);
		setVisible(true);
	}

}
