package java_swing_study.ch11.exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class DepartmentFrame extends JFrame {

	private JPanel contentPane;
	private JPanel pDept;
	private DeptPanel pDetpInfo;
	private JPanel pBtnsTable;
	private ArrayList<Department> arr;
	private JPanel pBtns;
	private DeptTblPanel pTable;
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
		
		pDept = new JPanel();
		contentPane.add(pDept);
		pDept.setLayout(new BorderLayout(0, 0));
		
		pDetpInfo = new DeptPanel();
		pDept.add(pDetpInfo, BorderLayout.NORTH);
		
		pBtnsTable = new JPanel();
		pDept.add(pBtnsTable, BorderLayout.CENTER);
		pBtnsTable.setLayout(new BorderLayout(0, 0));
		
		pBtns = new JPanel();
		pBtnsTable.add(pBtns, BorderLayout.NORTH);
		
		btn01 = new JButton("수정");
		pBtns.add(btn01);
		
		btn02 = new JButton("확인");
		pBtns.add(btn02);
		
		btn03 = new JButton("취소");
		pBtns.add(btn03);
		
		pTable = new DeptTblPanel();
		pBtnsTable.add(pTable, BorderLayout.CENTER);
		
		arr = new ArrayList<Department>(); 
		arr.add(new Department(1, "영업", 8));
		arr.add(new Department(2, "기획", 8)); 
		arr.add(new Department(3, "마케팅", 8));
		
		pTable.loadData(arr);
		
		pTable.table.setComponentPopupMenu(setPopupMenu());
		 
	}
	
	public JPopupMenu setPopupMenu() {
		JPopupMenu popup = new JPopupMenu();
		
		JMenuItem setItem = new JMenuItem("수정");
		setItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		popup.add(setItem);
		
		return popup;
		
	}
	

}
