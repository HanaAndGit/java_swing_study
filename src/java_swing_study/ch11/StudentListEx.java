package java_swing_study.ch11;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
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
	}
	
	
	public Student getStudent() {
		return new Student();
	}
	
	public void setStudent(Student student) {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
	}
	protected void btnAddActionPerformed(ActionEvent e) {
		Student std = pStd.getItem();
		v.add(std);
		list.setListData(new Vector<>(v));
		
	}
}
