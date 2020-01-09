package java_swing_study.ch10;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class EventListenerEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn02;
	private JButton btn03;
	private JButton btn04;
	private JButton btn06;
	private JButton btn07;
	private JPanel panel;
	private JButton btn08;
	private JButton btn09;
	private JButton btn10;

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
		setBounds(100, 100, 450, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		btn02 = new JButton("독립클래스");
		//btn01 을 클릭하면 MyActionListener 클래스에서 이벤트 처리
		//발생은 JButton btn01에서 발생
		btn02.addActionListener(new MyActionListener());
		btn02.addActionListener(new MyAction02Listener());
		contentPane.add(btn02);
		
		
		//독립 클래스를 써서 같은 ActionListener 클래스 (MyActionListener()) 를 수행하면 
		//다른 버튼이라도 같은 기능 수행 (버튼이 여러 개이고 수행 하는 기능이 겹칠 때 사용 가능)
		JButton btn02 = new JButton("독립클래스2");
		btn02.addActionListener(new MyActionListener());
		contentPane.add(btn02);
		
		btn03 = new JButton("내부클래스");
		btn03.addActionListener(new MyAction03Listener());
		contentPane.add(btn03);
		
		btn04 = new JButton("익명클래스");
		btn04.addActionListener(new ActionListener() {
			//한 번만 사용가능 (버튼 04번에만 사용할 수 있음) / 다른 버튼에는 x 
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, e.getActionCommand());
			}
		});
		contentPane.add(btn04);
		
		//버튼5
		JButton btn05 = new JButton("내부클래스2");
		//btn05.addActionListener(new MyAction03Listener());
		btn05.addActionListener(new ActionListener() {
			//버튼 5에서 사용하려면 new MyAction03Listener()만으로는 안되고 override부터 다시 작성해야함 
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, e.getActionCommand());
			}
		});
		contentPane.add(btn05);
		
		
		btn06 = new JButton("부모클래스");
		btn06.addActionListener(this);
		//this = EventListenerEx 자신
		//actionPerformed에서 이벤트가 발생하면 this에서 수행, 이벤트처리
		contentPane.add(btn06);
		
		btn07 = new JButton("부모클래스2");
		btn07.addActionListener(this);
		contentPane.add(btn07);
		
		panel = new JPanel();
		contentPane.add(panel);
		
		btn08 = new JButton("익명윈도우빌더");
		btn08.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "윈도우 빌더 - 익명");
			}
		});
		contentPane.add(btn08);
		
		btn09 = new JButton("내부클래스(윈도우빌더)");
		btn09.addActionListener(new Btn09ActionListener());
		contentPane.add(btn09);
		
		btn10 = new JButton("부모클래스(윈도우빌더)");
		btn10.addActionListener(this);
		contentPane.add(btn10);
	}
	
	class MyAction03Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "내부 클래스 이벤트 리스너");
			
		}
		
	}
	private class Btn09ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "잠온다");
		}
	}

	//부모클래스에 ActionListener 구현하면 override
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn10) {
			//btn10에서 이벤트가 발생하면 10 메서드에서 수행
			btn10ActionPerformed(e);
		}
		if(e.getSource()==btn06) {
			JOptionPane.showMessageDialog(null, "btn06 " +  e.getActionCommand());	
		}
		
		if(e.getSource()==btn07) {
			actionPerformedBtn07(e);
		}
		
	}

	private void actionPerformedBtn07(ActionEvent e) {
		//출력할 메세지
		JOptionPane.showMessageDialog(null, "btn07 " +  e.getActionCommand());	
		
	}
	

	protected void btn10ActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "정말 잠온다");
	}
}
