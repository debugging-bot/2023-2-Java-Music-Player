package 최종과제2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class Lyrics extends JFrame{
	Music sf;
	
	public Lyrics(Music sf) {
		
		this.sf = sf;
		JPanel nPanel = new JPanel();
		setContentPane(nPanel);
		nPanel.setBackground(Color.BLACK);
		
		
		JLabel lbl = new JLabel("<html>I'm a baddie, ba-ba-baddie, baddie<br>Pretty little risky baddie<br>뭐든 될 대로 되라지<br>Catch me if you can<br>Baddie, ba-ba-baddie, baddie<br>나는 없어 거기 이미<br>어차피 못 찾을 테니<br>Catch me if you can<br><br>Nothing like the regulars<br>내 DNA엔 blue blood runs<br>더 솔직하게 말해줘<br>착한 척은 지겨워<br>우리 앞에선 룰이 의미 없었어 굳이<br>유행이 돌고 돌아도 난 그 틀에 없어 이미<br>I wanna break, I wanna kick 뛰어 놀래 시끄럽게<br>다채로운 매력, 수많은 변칙 위에 더 빛을 발하지<br><br>답답한 건 벗어 던져<br>고개 숙일 필요 없어<br>(Ba-ba-ba-ba-ba-ba)<br><br>I'm a baddie, ba-ba-baddie, baddie<br>Pretty little risky baddie<br>뭐든 될 대로 되라지<br>Catch me if you can<br>Baddie, ba-ba-baddie, baddie<br>나는 없어 거기 이미<br>어차피 못 찾을 테니<br>Catch me if you can<br><br>Na-na-na, na, na-na-na, na<br>Na-na-na, na, na-na<br>Na-na-na, na, na-na-na, na<br>Na-na-na, na, na-na<br><br>And the fit pop like bubblegum<br>내 판단을 믿어 난 (믿어 난)<br>할 말도 많아 참<br>모자이크 없이 spit it out<br>난 즐겨 이 troublesome<br>그 누구도 can't bite me<br>원한다면 come try me<br>언제든 you're invited<br><br>난 thriller 속 villain<br>생각할 시간에 저지르는 게 my motto<br><br>I'm a baddie, ba-ba-baddie, baddie<br>Prеtty little risky baddie<br>뭐든 될 대로 되라지<br>Catch me if you can<br>Baddiе, ba-ba-baddie, baddie<br>앞다퉈 내 길을 막지<br>가뿐히 날아오를 테니<br>Catch me if you can<br>I'm a baddie, ba-ba-baddie, baddie<br>어딜 그리 바삐 가니<br>뭐든 될 대로 되라지<br>Catch me if you can<br>Baddie, ba-ba-baddie, baddie<br>나는 없어 거기 이미<br>어차피 못 찾을 테니<br>Catch me if you can (bad)<br><br>Ba-ba-ba-ba-ba-ba-baddie<br><br>Na-na-na, na, na-na-na, na<br>Na-na-na, na, na-na<br>Na-na-na, na, na-na-na, na<br>Na-na-na, na, na-na<br><br>I'm a baddie, ba-ba-baddie, baddie (na-na-na, na)<br>어딜 그리 바삐 가니 (na-na-na, na)<br>뭐든 될 대로 되라지<br>Catch me if you can (na-na-na, na, na-na)<br>Baddie, ba-ba-baddie, baddie (na-na-na, na)<br>나는 없어 거기 이미 (na-na-na, na)<br>어차피 못 찾을 테니<br>Catch me if you can (na-na-na, na, na-na)<br></html>");
		lbl.setForeground(Color.WHITE); // 글자색 설정
	    lbl.setOpaque(true); // 투명도 해제
	    lbl.setBackground(Color.BLACK); // 배경색 설정
	     
	    // 스크롤을 추가합니다.
	    JScrollPane scrollPane = new JScrollPane(lbl);
	    scrollPane.setPreferredSize(new Dimension(380, 500));
	    scrollPane.setBorder(new LineBorder(Color.BLACK));
	    
	    scrollPane.getVerticalScrollBar().setBackground(Color.BLACK);
        //scrollPane.getHorizontalScrollBar().setBackground(Color.BLACK);

	    nPanel.add(scrollPane);
	     	
		
		JButton btn = new JButton("🡸");
		Font font = new Font("Impact 보통", Font.BOLD, 20);
		btn.setBorder(new LineBorder(Color.BLACK));
		btn.setFont(font);
		btn.setForeground(Color.WHITE);
		btn.setBackground(Color.BLACK);
		nPanel.add(btn);
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sf.setVisible(true);
				dispose();
			}
		});
		
		this.setSize(401, 580);
		this.setTitle("가사");
		this.setLocation(400, 150);
		
	}
}
