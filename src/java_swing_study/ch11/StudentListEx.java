package java_swing_study.ch11;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java_swing_study.ch11.exam.Student;
import java_swing_study.ch11.exam.StudentPanel;

@SuppressWarnings("serial")
public class StudentListEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pList;
	private JPanel pResult;
	private JScrollPane scrollPane;
	@SuppressWarnings("rawtypes")
	private JList list;
	private ArrayList<Student> v;
	private StudentPanel pStd;
	private JPanel pBtns;
	private JButton btnAdd;
	private JButton btnSet;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentListEx frame = new StudentListEx();
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
	public StudentListEx() {
		v = new  ArrayList<Student>();
		v.add(new Student(1, "서현진", 80, 80, 90));
		v.add(new Student(2, "이성경", 90, 10, 20));
		v.add(new Student(3, "이유영", 80, 80, 20));
		
		initialize();
		list.setListData(new Vector<>(v));
	}
	private void initialize() {
		setTitle("학생관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		pList = new JPanel();
		contentPane.add(pList, BorderLayout.CENTER);
		pList.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		pList.add(scrollPane, BorderLayout.NORTH);
		
		pBtns = new JPanel();
		pList.add(pBtns, BorderLayout.SOUTH);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);
		
		btnSet = new JButton("취소");
		pBtns.add(btnSet);
		
		list = new JList<>(new Vector<>(v));
		pList.add(list, BorderLayout.CENTER);
		
		pResult = new JPanel();
		contentPane.add(pResult, BorderLayout.SOUTH);
		
		pStd = new StudentPanel();
		contentPane.add(pStd, BorderLayout.NORTH);
		
		list.setComponentPopupMenu(createPopupMenu());
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
				//Student std =
				int selIdx = list.getSelectedIndex();
				Student s = v.get(selIdx);
				System.out.println(s);
				
				pStd.getTfStdNo().setText(Integer.toString(s.getStdNo()));
				pStd.getTfName().setText(s.getStdName());
				pStd.getTfKor().setText(Integer.toString(s.getKor()));
				pStd.getTfMath().setText(Integer.toString(s.getMath()));
				pStd.getTfEng().setText(Integer.toString(s.getEng()));
				
				btnAdd.setText("수정");
				list.setListData(new Vector<>(v));
				
			}
			if(e.getActionCommand().equals("삭제")) {
				//System.out.println("삭제");
				
				//list에서 선택된 것이 있는지 판단
				//선택된 인덱스 또는 value를 가져온 후에 
				//arrayList에서 일치하는 것 삭제
				//JList에서 setListData 호출 
				
				int selIdx = list.getSelectedIndex();
				v.remove(selIdx);
				list.setListData(new Vector<>(v));
				
			}
				
			
		}
	}; 
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
	}
	protected void btnAddActionPerformed(ActionEvent e) {
		
		if(btnAdd.getText().equals("추가")) {
			Student std = pStd.getItem();
			v.add(std);
			list.setListData(new Vector<>(v));
			pStd.clearTf();
		}else {
			Student updateStd = pStd.getItem();
			v.set(v.indexOf(updateStd), updateStd);
			list.setListData(new Vector<>(v));
			btnAdd.setText("추가");
			pStd.clearTf();
		}
		
		
	}
}
