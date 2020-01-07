package java_swing_study.ch09.layout;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GridLayoutEx extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfNo;
	private JTextField tfDept;
	private JTextField tfSubj;

	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 */
	public GridLayoutEx() {
		setTitle("그리드 레이아웃 샘플");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 340, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 20, 5));
		
		JButton btnName = new JButton("이름");
		btnName.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(btnName);
		
		tfName = new JTextField();
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JButton lblNo = new JButton("학번");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNo);
		
		tfNo = new JTextField();
		tfNo.setColumns(10);
		contentPane.add(tfNo);
		
		JButton lblDept = new JButton("학과");
		lblDept.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblDept);
		
		tfDept = new JTextField();
		tfDept.setColumns(10);
		contentPane.add(tfDept);
		
		JButton lblSubj = new JButton("과목");
		lblSubj.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblSubj);
		
		tfSubj = new JTextField();
		tfSubj.setColumns(10);
		contentPane.add(tfSubj);
	}

}
