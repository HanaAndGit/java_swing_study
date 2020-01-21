package java_swing_study.ch11;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java_swing_study.ch11.exam.Student;
import java_swing_study.ch11.exam.StudentPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class StudentTableListEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pResult;
	private ArrayList<Student> stds;
	private StudentPanel pStd;
	private JPopupMenu popMenu;
	private JPanel panel;
	private JButton button;
	private JButton button_1;
	private JTable table;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JButton btnModi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentTableListEx frame = new StudentTableListEx();
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
	public StudentTableListEx() {
		stds = new  ArrayList<Student>();
		stds.add(new Student(1, "서현진", 80, 80, 90));
		stds.add(new Student(2, "이성경", 90, 10, 20));
		stds.add(new Student(3, "이유영", 80, 80, 20));
		
		initialize();
	}
	private void initialize() {
		setTitle("학생관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		pResult = new JPanel();
		contentPane.add(pResult, BorderLayout.SOUTH);
		
		panel = new JPanel();
		pResult.add(panel);
		
		button = new JButton("추가");
		button.addActionListener(this);
		panel.add(button);
		
		btnModi = new JButton("수정");
		btnModi.addActionListener(this);
		panel.add(btnModi);
		
		button_1 = new JButton("리셋");
		button_1.addActionListener(this);
		panel.add(button_1);
		
		pStd = new StudentPanel();
		contentPane.add(pStd, BorderLayout.NORTH);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table.setComponentPopupMenu(createPopupMenu());
		loadData();
	}

	private void loadData() {
		table.setModel(new DefaultTableModel(getRows(), getColumnNames()));
	}

	private Object[][] getRows() {
		Object[][] rows = new Object[stds.size()][];
		for(int i=0; i<rows.length; i++) {
			rows[i] = toArray(stds.get(i));
		}
		return rows;
	}

	private Object[] toArray(Student std) {
		
		return new Object[] {std.getStdNo(), std.getStdName(), std.getKor(), std.getEng(), std.getMath()};
	}

	private String[] getColumnNames() {
		return new String[] {
				"학생 번호", "학생 명", "국어", "영어", "수학", "총점", "평균"
		};
	}
	
	
	public Student getStudent() {
		return new Student();
	}
	
	public void setStudent(Student student) {
		
	}
	
	//마우스 우클릭 했을 때 팝업 메뉴 
	private JPopupMenu createPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem addItem = new JMenuItem("추가");
		addItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Student newStd = new Student(10, "황하나", 90, 90, 90);
				stds.add(newStd);
				loadData();
			}
		});
		
		popMenu.add(addItem);
		
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int idx = table.getSelectedRow();
				//System.out.println(idx);
				Student selectedStd = stds.get(idx);
				//System.out.println(selectedStd);
				pStd.setItem(selectedStd);
				/*
				 * pStd.getTfStdNo().setText(selectedStd.getStdNo()+"");
				 * pStd.getTfName().setText(selectedStd.getStdName());
				 * pStd.getTfKor().setText(selectedStd.getKor()+"");
				 * pStd.getTfEng().setText(selectedStd.getEng()+"");
				 * pStd.getTfMath().setText(selectedStd.getMath()+"");
				 */
				
			}
		});
		popMenu.add(updateItem);
		
		JMenuItem getSelectedItem = new JMenuItem("선택한 학생 확인");
		getSelectedItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int idx = table.getSelectedRow();
				//System.out.println(idx);
				Student selectedStd = stds.get(idx);
				JOptionPane.showMessageDialog(null, "선택한 학생은 : " + selectedStd.getStdNo() + "번 " + selectedStd.getStdName());
				
			}
		});
		popMenu.add(getSelectedItem);
		
		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int idx = table.getSelectedRow();
				//System.out.println(idx);
				stds.remove(idx);
				loadData();
				
			}
			
		});
		popMenu.add(deleteItem);
		
		return popMenu;
		
	}
	
	
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button_1) {
			button_1ActionPerformed(e);
		}
		if (e.getSource() == btnModi) {
			btnModiActionPerformed(e);
		}
		if (e.getSource() == button) {
			buttonActionPerformed(e);
		}

	}
	
	//추가 버튼
	protected void buttonActionPerformed(ActionEvent e) {
		int stdNo = Integer.parseInt(pStd.getTfStdNo().getText());
		String stdName = pStd.getTfName().getText();
		int kor =  Integer.parseInt(pStd.getTfKor().getText());
		int eng = Integer.parseInt(pStd.getTfEng().getText());
		int math = Integer.parseInt(pStd.getTfMath().getText());
		
		Student std = new Student(stdNo, stdName, kor, eng, math);
		
		int idx = table.getSelectedRow();
		stds.add(std);
		loadData();
	}
	//수정 버튼
	protected void btnModiActionPerformed(ActionEvent e) {
		int stdNo = Integer.parseInt(pStd.getTfStdNo().getText());
		String stdName = pStd.getTfName().getText();
		int kor =  Integer.parseInt(pStd.getTfKor().getText());
		int eng = Integer.parseInt(pStd.getTfEng().getText());
		int math = Integer.parseInt(pStd.getTfMath().getText());
		
		Student std = new Student(stdNo, stdName, kor, eng, math);
		
		int idx = table.getSelectedRow();
		//System.out.println(idx);
		stds.remove(idx);
		stds.add(idx,std);
		loadData();
	}
	//리셋
	protected void button_1ActionPerformed(ActionEvent e) {
		pStd.getTfStdNo().setText("");
		pStd.getTfName().setText("");
		pStd.getTfKor().setText("");
		pStd.getTfMath().setText("");
		pStd.getTfEng().setText("");
	}
}
