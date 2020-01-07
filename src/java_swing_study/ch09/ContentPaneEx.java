package java_swing_study.ch09;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ContentPaneEx extends JFrame {

	
	
	public ContentPaneEx() {
		setTitle("ContentPane과 JFrame"); //제목
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x 버튼 누르면 종료
		
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.ORANGE); //contentPane -> title 외에 창 전체
		contentPane.setLayout(new FlowLayout()); //flowlayout -> 좌에서 우로 (입력된 순서대로) 배치  (ok, cancel, ignore)
		
		contentPane.add(new JButton("OK"));
		contentPane.add(new JButton("Cancel"));
		contentPane.add(new JButton("Ignore"));
		
		setSize(300, 150);  //width, height 
		setVisible(true); //true -> 보이기 
	}
	


	

	public static void main(String[] args) {
		
		new ContentPaneEx(); //생성과 동시에 생성자에서 수정
	}

}
