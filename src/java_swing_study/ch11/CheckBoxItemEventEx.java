package java_swing_study.ch11;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckBoxItemEventEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblCost;
	private JLabel lblText;
	private JPanel panel_2;
	private JCheckBox ch1;
	private JCheckBox ch2;
	private JCheckBox ch3;
	
	private JCheckBox [] fruits = new JCheckBox[3];
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBoxItemEventEx frame = new CheckBoxItemEventEx();
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
	public CheckBoxItemEventEx() {
		initialize();
	}
	private void initialize() {
		setTitle("체크박스 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\uC608\uC81C 11-4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		lblCost = new JLabel("사과 100원, 배 500원, 체리 20000원");
		lblCost.setHorizontalAlignment(SwingConstants.CENTER);
		lblCost.setFont(new Font("굴림", Font.BOLD, 12));
		panel.add(lblCost, BorderLayout.NORTH);
		
		lblText = new JLabel("현재 0원 입니다.");
		lblText.setFont(new Font("굴림", Font.BOLD, 12));
		lblText.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblText, BorderLayout.SOUTH);
		
		panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));
		
		MyItemListener listener = new MyItemListener();
		
		ch1 = new JCheckBox("사과");
		ch1.addItemListener(listener);
		panel_2.add(ch1);
		fruits[0] = ch1;
		
		ch2 = new JCheckBox("배");
		ch2.addItemListener(listener);
		panel_2.add(ch2);
		fruits[1] = ch2;
		
		ch3 = new JCheckBox("체리");
		ch3.addItemListener(listener);
		panel_2.add(ch3);
		fruits[2] = ch3;
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "selected&deselected", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn1 = new JButton("사과 선택");
		btn1.addActionListener(this);
		panel_1.add(btn1);
		
		btn2 = new JButton("배 선택");
		btn2.addActionListener(this);
		panel_1.add(btn2);
		
		btn3 = new JButton("체리 선택");
		btn3.addActionListener(this);
		panel_1.add(btn3);
		
		btn4 = new JButton("모든 과일 선택");
		btn4.addActionListener(this);
		panel_1.add(btn4);
		
		btn5 = new JButton("선택한 과일 확인");
		btn5.addActionListener(this);
		panel_1.add(btn5);
	}
	
	public class MyItemListener implements ItemListener{
		private int sum = 0;
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange()==ItemEvent.SELECTED) { //선택 
				if(e.getItem()==fruits[0]){
					sum+=100;
				}else if(e.getItem()==fruits[1]){
					sum+=500;
				}else {
					sum += 20000;
				}
			}else { //해제
				if(e.getItem()==fruits[0]) {
					sum -= 100;
				}else if(e.getItem()==fruits[1]) {
					sum -= 500;
				}else {
					sum -= 20000;
				}
			}
			lblText.setText("현재 " + sum + " 원 입니다."  );
				
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn5) {
			btn5ActionPerformed(e);
		}
		if (e.getSource() == btn4) {
			btn4ActionPerformed(e);
		}
		if (e.getSource() == btn3) {
			btn3ActionPerformed(e);
		}
		if (e.getSource() == btn2) {
			btn2ActionPerformed(e);
		}
		if (e.getSource() == btn1) {
			btn1ActionPerformed(e);
		}
		// TODO Auto-generated method stub
		
	}

	
	protected void btn1ActionPerformed(ActionEvent e) {
		if(btn1.getText().equals("사과 선택")) {
			fruits[0].setSelected(true);
			btn1.setText("사과 취소");
		}else {
			fruits[0].setSelected(false);
			btn1.setText("사과 선택");
		}
	
		
	}
	protected void btn2ActionPerformed(ActionEvent e) {
		if(btn2.getText().equals("배 선택")) {
			fruits[1].setSelected(true);
			btn2.setText("배 취소");
		}else {
			fruits[1].setSelected(false);
			btn2.setText("배 선택");
		}
	}
	
	protected void btn3ActionPerformed(ActionEvent e) {
		if(btn3.getText().equals("체리 선택")) {
			fruits[2].setSelected(true);
			btn3.setText("체리 취소");
		}else {
			fruits[2].setSelected(false);
			btn3.setText("체리 선택");
		}
		
		
	}
	protected void btn4ActionPerformed(ActionEvent e) {
		if(btn4.getText().equals("모든 과일 선택")) {
			for(int i=0; i<3; i++) {
				fruits[i].setSelected(true);
			}
			btn4.setText("모든 과일 취소");
		}else {
			for(int i=0; i<3; i++) {
				fruits[i].setSelected(false);
			}
			btn4.setText("모든 과일 선택");
		}
	}
	protected void btn5ActionPerformed(ActionEvent e) {
		String str = "";
		for(int i=0; i<3; i++) {
			if(fruits[i].isSelected()) {
				str += fruits[i].getText() + ", ";
			}
		}
		JOptionPane.showMessageDialog(null, "선택한 과일은 " + str);
	}
}
