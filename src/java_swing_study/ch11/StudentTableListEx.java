package java_swing_study.ch11;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java_swing_study.ch11.exam.Student;
import java_swing_study.ch11.exam.StudentPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class StudentTableListEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pResult;
	private ArrayList<Student> v;
	private StudentPanel pStd;
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
		v = new  ArrayList<Student>();
		v.add(new Student(1, "서현진", 80, 80, 90));
		v.add(new Student(2, "이성경", 90, 10, 20));
		v.add(new Student(3, "이유영", 80, 80, 20));
		
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
		panel.add(button);
		
		button_1 = new JButton("취소");
		panel.add(button_1);
		
		pStd = new StudentPanel();
		contentPane.add(pStd, BorderLayout.NORTH);
		
		table = new JTable();
		
		
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		panel_1.add(scrollPane, BorderLayout.CENTER);
		loadData();
	}

	private void loadData() {
		table.setModel(new DefaultTableModel(getRows(), getColumnNames()));
	}

	private Object[][] getRows() {
		Object[][] rows = new Object[v.size()][];
		for(int i=0; i<rows.length; i++) {
			rows[i] = toArray(v.get(i));
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
		
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(myPopMenuListener);
		popMenu.add(updateItem);
		
		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(myPopMenuListener);
		popMenu.add(deleteItem);
		
		return popMenu;
		
	}
	
	ActionListener myPopMenuListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//actionCommand = 글자
			if(e.getActionCommand().equals("수정")) {
				//System.out.println("수정 ");
				/*
				 * //Student std = int selIdx = list.getSelectedIndex(); Student s =
				 * v.get(selIdx); System.out.println(s);
				 */
				
				/*
				 * pStd.getTfStdNo().setText(Integer.toString(s.getStdNo()));
				 * pStd.getTfName().setText(s.getStdName());
				 * pStd.getTfKor().setText(Integer.toString(s.getKor()));
				 * pStd.getTfMath().setText(Integer.toString(s.getMath()));
				 * pStd.getTfEng().setText(Integer.toString(s.getEng()));
				 */
				/*
				 * btnAdd.setText("수정"); list.setListData(new Vector<>(v));
				 */
				
			}
			if(e.getActionCommand().equals("삭제")) {
				//System.out.println("삭제");
				
				//list에서 선택된 것이 있는지 판단
				//선택된 인덱스 또는 value를 가져온 후에 
				//arrayList에서 일치하는 것 삭제
				//JList에서 setListData 호출 
				/*
				 * int selIdx = list.getSelectedIndex(); v.remove(selIdx); list.setListData(new
				 * Vector<>(v));
				 */
				
			}
				
			
		}
	}; 
	private JPanel panel;
	private JButton button;
	private JButton button_1;
	private JTable table;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	
	public void actionPerformed(ActionEvent e) {
	}
}
