package java_swing_study.ch10;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;

public class EventListenerEx extends JFrame {

	private JPanel contentPane;
	private JButton btn01;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventListenerEx frame = new EventListenerEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EventListenerEx() {
		initialize();
	}
	private void initialize() {
		setTitle("이벤트 리스너 작성 방법");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 136);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		btn01 = new JButton("독립클래스");
		//btn01 을 클릭하면 MyActionListener 클래스에서 이벤트 처리
		//발생은 JButton btn01에서 발생
		btn01.addActionListener(new MyActionListener());
		contentPane.add(btn01);
		
		
		//독립 클래스를 써서 같은 ActionListener 클래스 (MyActionListener()) 를 수행하면 
		//다른 버튼이라도 같은 기능 수행 (버튼이 여러 개이고 수행 하는 기능이 겹칠 때 사용 가능)
		JButton btn02 = new JButton("독립클래스2");
		btn02.addActionListener(new MyActionListener());
		contentPane.add(btn02);
	}

}
