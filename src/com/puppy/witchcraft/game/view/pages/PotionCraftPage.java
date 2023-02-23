package com.puppy.witchcraft.game.view.pages;

import static com.puppy.witchcraft.common.CommonConstants.changePanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.puppy.witchcraft.common.MainFrame;
import com.puppy.witchcraft.game.controller.SelectItemInvenController;
import com.puppy.witchcraft.game.model.dto.ItemDTO;
import com.puppy.witchcraft.game.model.dto.MyInven;
import com.puppy.witchcraft.game.model.dto.PlayerDTO;
import com.puppy.witchcraft.game.view.WorkroomMenu;

public class PotionCraftPage extends JPanel{

	/* 전역변수에 계속 쓰일 프레임 및 패널 지정*/
	private MainFrame mf;
	private JPanel potionCraftPage;
	private ItemDTO itemDTO;

	public PotionCraftPage(MainFrame mf) {

		/*현재 프레임 및 클래스 set*/
		this.mf = mf;
		this.potionCraftPage = this;

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
				changePanel(mf, potionCraftPage, new WorkroomMenu(mf));
			}
		});

		/* 인벤토리 버튼 이미지로 생성 */
		JButton invenBtn = new JButton(new ImageIcon("images/ui/ui_inventory.png"));
		invenBtn.setBounds(620, 460, 70, 70);
		invenBtn.setContentAreaFilled(false);
		invenBtn.setBorder(null);

		/* 레시피도감 버튼 이미지로 생성 */
		JButton recipeBtn = new JButton(new ImageIcon("images/ui/ui_recipe.png"));
		recipeBtn.setBounds(710, 460, 70, 70);
		recipeBtn.setContentAreaFilled(false);
		recipeBtn.setBorder(null);

		//기본 ui 세팅 끝

		/* 가마솥 버튼 이미지로 생성 */
		JButton touchCaldronBtn = new JButton(new ImageIcon("images/ui/caldron.png"));
		touchCaldronBtn.setBounds(115, 230, 220, 250);
		touchCaldronBtn.setContentAreaFilled(false);
		touchCaldronBtn.setLayout(null);
		touchCaldronBtn.setBorder(null);
		touchCaldronBtn.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				touchCaldronBtn.setBorder(null);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				touchCaldronBtn.setBorder(new LineBorder(Color.GREEN, 3));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		/* 가마솥 위에 글자 추가 */
		JLabel touch = new JLabel("T O U C H");
		touch.setFont(new Font("Sans Serif", Font.BOLD, 25));
		touch.setForeground(Color.WHITE);
		touch.setBounds(55, 130, 120, 50);
		
		touchCaldronBtn.add(touch);

		/* 선택된 재료전시대 이미지 생성 */
		JLabel putUp = new JLabel(new ImageIcon("images/ui/select_item.png"));
		putUp.setBounds(85, 125, 280, 70);

		/* 제작 설명 */
		JLabel info = new JLabel("재료를 다 넣은 후 숱을 눌러 제작해주세요!");
		info.setBounds(120, 105, 220, 12);
		info.setFont(new Font("Sans Serif", Font.PLAIN, 11));
		info.setForeground(Color.WHITE);

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

		/* 재료가 있는 만큼 인벤토리 내에 조회하도록 컨트롤러 요청 */
		SelectItemInvenController selectItemInvenController = new SelectItemInvenController();
		
		/* 임시플레이어 설정 */
		PlayerDTO pp = new PlayerDTO();
		pp.setPlayerNo(1);
		
		/*인벤에 해당 플레이어의 인벤토리 데이터 담기*/
		List<MyInven> itemList = selectItemInvenController.inven(pp);

		for(int i = 0; i < 16; i++) {
			JButton blank = new JButton();
			blank.setName("blank"+i);
			blank.setLayout(null);
			blank.setSize(63, 63);
			blank.setBackground(Color.DARK_GRAY);
			blank.setBorder(null);
			invenPanel.add(blank);

			if(i < itemList.size()) {
				
				blank.setText(itemList.get(i).getItemNo()+"");
				blank.setName(itemList.get(i).getItemNo()+"");
				blank.setForeground(Color.WHITE);
				
				blank.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("재료번호 " + blank.getName() + "번 재료를 클릭함");
					}
				});
				
				/*버튼에 해당 재료 이미지 설정*/
				String imageUrl = selectItemInvenController.imageUrl(itemList.get(i).getImageNo());
				blank.setIcon(new ImageIcon(imageUrl));
				blank.setHorizontalTextPosition(SwingConstants.CENTER);

				JLabel count = new JLabel(itemList.get(i).getItemCount()+"개");
				count.setBounds(43, 43, 20, 20);
				count.setForeground(Color.WHITE);
				blank.add(count);
			} else {
				blank.setVisible(false);
			}
		}

		/* 컴포넌트들 넣을 패널 세팅 */
		this.setLayout(null);
		this.setBounds(0, 0, 800, 580);

		/* 컴포넌트 세팅 */
		invenBg.add(invenPanel);
		invenBg.add(alignBtn);

		/* 패널에 컴포넌트들 삽입 */
		this.add(invenBg);
		this.add(quitBtn);
		this.add(invenBtn);
		this.add(recipeBtn);
		this.add(info);
		this.add(putUp);
		this.add(touchCaldronBtn);

		this.add(background);
		
		/* 프레임에 패널 올리기*/
		mf.add(this);

		/* 배경이미지 레이어위치 맨뒤로 보내기 */
		mf.getLayeredPane().setLayer(background, 0);
	}

}
