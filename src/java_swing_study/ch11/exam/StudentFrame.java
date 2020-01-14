package java_swing_study.ch11.exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class StudentFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private StudentPanel pStd;
	private JPanel pBtnText;
	private JPanel panel_2;
	private JButton btnAdd;
	private JButton btnReset;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFrame frame = new StudentFrame();
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
	public StudentFrame() {
		initialize();
	}
	private void initialize() {
		setTitle("텍스트 영역 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		pStd = new StudentPanel();
		contentPane.add(pStd, BorderLayout.NORTH);
		
		pBtnText = new JPanel();
		contentPane.add(pBtnText, BorderLayout.CENTER);
		pBtnText.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		pBtnText.add(panel_2, BorderLayout.NORTH);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		panel_2.add(btnAdd);
		
		btnReset = new JButton("취소");
		panel_2.add(btnReset);
		
		ta = new JTextArea();
		pBtnText.add(ta, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
	}
	
	//추가버튼
	protected void btnAddActionPerformed(ActionEvent e) {
		Student std = pStd.getItem();
		ta.append(std.toString() + "\n");
		pStd.clearTf();
	}
}
