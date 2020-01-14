package java_swing_study.ch11;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TextEx02 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pTop;
	private JLabel lblEnter;
	private JTextField tf;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextEx02 frame = new TextEx02();
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
	public TextEx02() {
		initialize();
	}
	private void initialize() {
		setTitle("텍스트 영역 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 308, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		
		pTop = new JPanel();
		contentPane.add(pTop);
		
		lblEnter = new JLabel("입력 후 <Enter>키를 입력하세요.");
		lblEnter.setFont(new Font("굴림", Font.BOLD, 12));
		pTop.add(lblEnter);
		
		tf = new JTextField();
		tf.addActionListener(this);
		contentPane.add(tf);
		tf.setColumns(15);
		
		ta = new JTextArea();
		ta.setRows(7);
		ta.setColumns(30);
		contentPane.add(ta);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tf) {
			tfActionPerformed(e);
		}
	}
	protected void tfActionPerformed(ActionEvent e) {
		JTextField t = (JTextField) e.getSource();
		ta.append(t.getText() + "\n");
		
		t.setText("");
	}
}
