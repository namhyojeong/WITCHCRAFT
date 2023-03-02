package com.puppy.witchcraft.game.view.pages;

import static com.puppy.witchcraft.common.CommonConstants.changePanel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.puppy.witchcraft.common.MainFrame;
import com.puppy.witchcraft.game.controller.SelectPotionInvenController;
import com.puppy.witchcraft.game.model.dto.MyPotionInven;
import com.puppy.witchcraft.game.model.dto.PlayerDTO;
import com.puppy.witchcraft.game.view.WorkroomMenu;

public class WorkroomQuest extends JPanel {
	
	/* 전역변수에 계속 쓰일 프레임 및 패널 지정*/
	private WorkroomQuest wrQuest;
	private List<MyPotionInven> potionList = new ArrayList<>();
	
	/* 생성자 */
	public WorkroomQuest(MainFrame mf, PlayerDTO player) {
		
		/*현재 프레임 및 클래스 set*/
		this.wrQuest = this;
		
		SelectPotionInvenController selectPotionInvenController = new SelectPotionInvenController();
		
		/* 라벨에 배경이미지 삽입*/
		JLabel background = new JLabel(new ImageIcon("images/background/bg_potion.png"));
		background.setBounds(0, -15, 800, 580);

		/* 라벨에 고양이이미지 삽입*/
		JLabel catimage = new JLabel(new ImageIcon("images/background/bg_cat.png"));
		catimage.setBounds(150, 334, 169, 246);	
		
		/* 라벨에 퀘스트두루마리이미지 삽입*/
		JLabel questpaper = new JLabel(new ImageIcon("images/ui/quest_paper.png"));
		questpaper.setBounds(20, 95, 390, 190);
		
		
		/* 나가기 버튼 생성 */
		JButton quitBtn = new JButton(new ImageIcon("images/ui/button_quit.png"));
		quitBtn.setBounds(0, 450, 170, 70);
		quitBtn.setContentAreaFilled(false);
		quitBtn.setBorderPainted(false);
		
		/* 나가기 버튼 클릭 시 숲 선택화면으로 이동*/
		quitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel(mf, wrQuest, new WorkroomMenu(mf, player));
			}
		});
		
		/* 라벨에 포션목록이미지 삽입*/
		JLabel invenBg = new JLabel(new ImageIcon("images/ui/inventory_potion.png"));
		invenBg.setBounds(430, 40, 340, 400);
		
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
		potionList = selectPotionInvenController.myPotionInven(player);

		/* 인벤토리 칸 생성 및 클릭 시 요청 */
		List<JButton> blank = new ArrayList<>();

		for(int i = 0; i < 16; i++) {
			blank.add(new JButton());
			blank.get(i).setLayout(null);
			blank.get(i).setSize(63, 63);
			blank.get(i).setBackground(Color.DARK_GRAY);
			blank.get(i).setBorder(null);
			invenPanel.add(blank.get(i));

			if(i < potionList.size()) {

				int index = i;

				/*버튼에 해당 재료 이미지 설정*/
				String imageUrl = selectPotionInvenController.potionImage(potionList.get(i));
				blank.get(i).setIcon(new ImageIcon(imageUrl));
				blank.get(i).setHorizontalTextPosition(SwingConstants.CENTER);

				JLabel count = new JLabel(potionList.get(i).getPotionCount()+"개");
				count.setBounds(43, 43, 20, 20);
				count.setForeground(Color.WHITE);
				blank.get(i).add(count);

			} else {
				
				blank.get(i).setVisible(false);
			}
		}
		
		invenBg.add(invenPanel);
		invenBg.add(alignBtn);
		
		/* 컴포넌트들 넣을 패널 세팅 */
		this.setLayout(null);
		this.setBounds(0, 0, 800, 580);
		
		/* 패널에 컴포넌트들 삽입 */
		this.add(catimage);
		this.add(questpaper);
		this.add(invenBg);
		this.add(quitBtn);
		this.add(background);
		
		/* 프레임에 패널 올리기*/
		mf.add(this);

		/* 배경이미지 레이어위치 맨뒤로 보내기 */
		mf.getLayeredPane().setLayer(background, 0);
	}

}
