package java_swing_study.ch14.exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java_swing_study.ch14.exam.ui.StudentMainPanel;

public class ERPFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem nmStudent;
	private JMenuItem nmDept;
	private StudentMainPanel pManage;

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
		setTitle("관리 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 358);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("관리");
		menuBar.add(mnNewMenu);
		
		nmStudent = new JMenuItem("학생 관리");
		nmStudent.addActionListener(this);
		mnNewMenu.add(nmStudent);
		
		nmDept = new JMenuItem("부서 관리");
		mnNewMenu.add(nmDept);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nmStudent) {
			nmStudentActionPerformed(e);
		}
	}
	protected void nmStudentActionPerformed(ActionEvent e) {
		pManage = new StudentMainPanel();
		contentPane.add(pManage, BorderLayout.CENTER);
		revalidate();
		repaint();
	}
}
