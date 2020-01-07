package java_swing_study.ch09;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ContentPaneExs extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public ContentPaneExs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300); //좌표 (x로 100, y로 100, x.100부터 폭이 450, 높이가 300
		contentPane = new JPanel(); //컨테이너  = JPanel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); //여백 padding(상,하,좌,우)
		contentPane.setLayout(new BorderLayout(0, 0));
		//borderLayout -> top, south, right, center, left) border 간의 갭이 0, 0
		setContentPane(contentPane);
		//JPanel을 JFrame에 넣기
	}

}
