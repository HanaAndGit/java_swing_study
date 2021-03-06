package java_swing_study.ch11.exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class StudentFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pContent;
	private StudentTblPanel pList;
	private StudentPanel pStudent;
	private JPanel pBtns;
	private JButton btnAdd;
	private JButton btnCancel;
	private ArrayList<Student> stds;

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

	public StudentFrame() {
		initialize();
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		pContent = new JPanel();
		contentPane.add(pContent);
		pContent.setLayout(new BorderLayout(0, 0));
		
		pStudent = new StudentPanel();
		pContent.add(pStudent, BorderLayout.CENTER);
		
		pBtns = new JPanel();
		contentPane.add(pBtns);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);
		
		pList = new StudentTblPanel();
		contentPane.add(pList);
		
		stds = new ArrayList<Student>();
		stds.add(new Student(1, "서현진", 80, 90, 70));
		stds.add(new Student(2, "이성경", 90, 90, 40));
		stds.add(new Student(3, "이유영", 50, 50, 60));
		
		pList.loadData(stds);
		pList.table.setComponentPopupMenu(setPopupMenu());
//		pList.setLayout(new BorderLayout(0, 0));
	}

	private JPopupMenu setPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem addItem = new JMenuItem("수정");
		addItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Student std = pList.getSelectedItem();
				//System.out.println(pList.getSelectedItem());
				pStudent.getTfStdNo().setText(std.getStdNo()+"");
				pStudent.getTfName().setText(std.getStdName());
				pStudent.getTfKor().setText(std.getKor()+"");
				pStudent.getTfEng().setText(std.getEng()+"");
				pStudent.getTfMath().setText(std.getMath()+"");
				
			}
		});
		
		popMenu.add(addItem);
		
		JMenuItem checkItem = new JMenuItem("선택한 학생 확인");
		checkItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "선택한 학생은 ");
				
			}
		});
		popMenu.add(checkItem);
		
		JMenuItem delItem = new JMenuItem("학생 삭제");
		delItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = pList.table.getSelectedRow();
				System.out.println(i);
				//pList.remove(pList.table.getSelectedRow());
				pList.model.removeRow(i);
				
			}
		});
		popMenu.add(delItem);
		
		return popMenu;
	}
	
	
	// 삭제 후 다시 선택하면 인덱스 번호가 변경되기 때문에 stds 에서 가져오면 안됨 
	/*
	 * public Student findStd() { int idx = pList.table.getSelectedRow(); Student
	 * std = stds.get(idx);
	 * 
	 * return std; }
	 */

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
	}
	
	protected void btnAddActionPerformed(ActionEvent e) {
		Student std = pStudent.getItem();
//		ta.append(std.toString() + "\n");
		pStudent.clearTf();
	}
	
	protected void btnCancelActionPerformed(ActionEvent e) {
		pStudent.clearTf();
	}
}

