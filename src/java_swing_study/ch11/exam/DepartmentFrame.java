package java_swing_study.ch11.exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class DepartmentFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private DeptPanel panel_1;
	private JPanel panel_2;
	private ArrayList<Department> arr;
	private JPanel panel_3;
	private DeptTblPanel panel_4;
	private JButton btn01;
	private JButton btn02;
	private JButton btn03;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentFrame frame = new DepartmentFrame();
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
	public DepartmentFrame() {

		
		
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new DeptPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		
		btn01 = new JButton("수정");
		panel_3.add(btn01);
		
		btn02 = new JButton("확인");
		panel_3.add(btn02);
		
		btn03 = new JButton("취소");
		panel_3.add(btn03);
		
		panel_4 = new DeptTblPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		
		arr = new ArrayList<Department>(); 
		arr.add(new Department(1, "영업", 8));
		arr.add(new Department(2, "기획", 8)); 
		arr.add(new Department(3, "마케팅", 8));
		
		panel_4.loadData(arr);
		 
	}

}
