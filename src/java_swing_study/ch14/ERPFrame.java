package java_swing_study.ch14;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java_swing_study.ch14.exam.ui.StudentMainPanel;
import java_swing_study.ch14.exam.ui.DeptMainPanel;

public class ERPFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnItem;
	private JMenuItem mnStudent;
	private JMenuItem mnDept;
	private StudentMainPanel panel = new StudentMainPanel();;
	private DeptMainPanel panel_1 = new DeptMainPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ERPFrame frame = new ERPFrame();
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
	public ERPFrame() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnItem = new JMenu("관리");
		menuBar.add(mnItem);
		
		mnStudent = new JMenuItem("학생관리");
		mnStudent.addActionListener(this);
		mnItem.add(mnStudent);
		
		mnDept = new JMenuItem("부서관리");
		mnDept.addActionListener(this);
		mnItem.add(mnDept);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mnDept) {
			mnDeptActionPerformed(e);
		}
		if (e.getSource() == mnStudent) {
			mnStudentActionPerformed(e);
		}
	}
	protected void mnStudentActionPerformed(ActionEvent e) {
		//contentPane.remove(panel_1);
		
		contentPane.add(panel, BorderLayout.CENTER);
		revalidate();
		repaint();
		
	}
	protected void mnDeptActionPerformed(ActionEvent e) {
		//contentPane.remove(panel);
		contentPane.add(panel_1, BorderLayout.CENTER);
		revalidate();
		repaint();
	}
}
