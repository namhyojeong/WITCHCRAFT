package com.puppy.witchcraft.game.view.pages;

import static com.puppy.witchcraft.common.CommonConstants.changePanel;
import static com.puppy.witchcraft.common.CommonConstants.setButtonColor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.puppy.witchcraft.common.CommonConstants;
import com.puppy.witchcraft.common.MainFrame;
import com.puppy.witchcraft.game.view.GameMenu;
import com.puppy.witchcraft.game.view.MainMap;

public class LoginPage extends JPanel {

	/* 전역변수에 컬러파레트 지정 */
	private Color MAINCOLOR = CommonConstants.MAINCOLOR;
	private Color GRAYCOLOR = CommonConstants.GRAYCOLOR;

	/* 폰트크기때문에 폰트 설정 */
	private Font font = new Font("Sans Serif", Font.BOLD, 18);

	/* 전역변수에 계속 쓰일 프레임 및 패널 지정*/
	private MainFrame mf;
	private JPanel loginPage;

	/* 생성자 */
	public LoginPage(MainFrame mf) {

		/*현재 프레임 및 클래스 set*/
		this.mf = mf;
		this.loginPage = this;

		/* 라벨에 배경이미지 삽입*/
		JLabel background = new JLabel(new ImageIcon("images/background/bg_start.png"));
		background.setBounds(0, -15, 800, 580);

		/* 라벨에 타이틀로고 삽입 */
		JLabel logo = new JLabel(new ImageIcon("images/ui/title_logo.png"));
		logo.setBounds(180, 25, 440, 160);

		/* 아이디 제목 텍스트 라벨 생성 */
		JLabel textId = new JLabel("아이디 : ");
		textId.setBounds(250, 265, 100, 40);
		textId.setForeground(Color.WHITE);
		textId.setFont(font);

		/* 비밀번호 제목 텍스트 라벨 생성 */
		JLabel textPwd = new JLabel("비밀번호 : ");
		textPwd.setBounds(250, 320, 100, 40);
		textPwd.setForeground(Color.WHITE);
		textPwd.setFont(font);

		/* 아이디 입력창 생성 */
		JTextField inputId = new JTextField("아이디를 입력하세요.");  //텍스트 크기
		inputId.setToolTipText(TOOL_TIP_TEXT_KEY);
		inputId.setBounds(350, 265, 200, 40);
		inputId.setBackground(Color.WHITE);

		/* 아이디 입력필드 클릭시 기존 설정된 텍스트 지워짐 */
		inputId.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				inputId.setText("");
			}
		});

		/* 비밀번호 입력창 생성 */
		JPasswordField inputPwd = new JPasswordField();
		inputPwd.setBounds(350, 320, 200, 40);
		inputPwd.setBackground(Color.WHITE);

		/* 로그인요청 버튼 생성 */
		JButton loginBtn = new JButton("Login");									
		loginBtn.setBounds(205, 440, 190, 55);
		setButtonColor(loginBtn, MAINCOLOR, Color.WHITE);

		/* 로그인 버튼 클릭 시 입력값 받고 (조건에 맞으면) GameMenu 패널로 변경*/
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				/* 입력한 아이디와 DB에 저장된 정보가 일치한지 확인 */
				String id = inputId.getText();

				/* 일치하면 MainMap으로 아이디와 함께 이동*/
				if(true) {
					changePanel(mf, loginPage, new MainMap(mf)); 	//추후 플레이어 아이디도 파라미터로 넘겨야함
				} else {
					System.out.println("로그인 실패");
				}
				
			}
		});

		/* 나가기 버튼 생성 */
		JButton quitBtn = new JButton("Quit");
		quitBtn.setBounds(405, 440, 190, 55);
		setButtonColor(quitBtn, GRAYCOLOR, Color.WHITE);

		/* 나가기 버튼 클릭 시 시스템 종료*/
		quitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel(mf, loginPage, new GameMenu(mf));
			}
		});

		/* 컴포넌트들 넣을 패널 생성 */
		this.setLayout(null);
		this.setBounds(0, 0, 800, 580);

		/* 패널에 컴포넌트들 삽입 */
		this.add(logo);

		this.add(textId);
		this.add(textPwd);

		this.add(inputId);
		this.add(inputPwd);

		this.add(loginBtn);
		this.add(quitBtn);

		this.add(background);

		/* 프레임에 패널 올리기*/
		mf.add(this);

		/* 배경이미지 레이어위치 맨뒤로 보내기 */
		mf.getLayeredPane().setLayer(background, 0);

	}

}
