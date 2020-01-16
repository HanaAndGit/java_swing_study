package java_swing_study.ch11;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java_swing_study.ch11.exam.Student;

@SuppressWarnings("serial")
public class ComboxEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pLeft;
	private JPanel pRight;
	private JComboBox<String> cmbFruit;
	private DefaultComboBoxModel<String> model;
	private JTextField tfFruits;
	private JLabel lblText;
	private JButton btnOk;
	private JComboBox<Student>cmbStudent;
	private DefaultComboBoxModel<Student> modelStd;
	private JLabel lblStudent;
	private JButton btnConfirm;
	private JPanel panel;
	private JLabel lblNum;
	private JTextField tfNum;
	private JButton btnSearch;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboxEx frame = new ComboxEx();
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
	public ComboxEx() {
		initialize();
	}

	private void initialize() {
		setTitle("JCombobox 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		pLeft = new JPanel();
		pLeft.setBorder(
				new TitledBorder(null, "\uC608\uC81C11-12", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLeft);
		pLeft.setLayout(new GridLayout(4, 1, 0, 0));

		cmbFruit = new JComboBox<>();
		cmbFruit.setMaximumRowCount(5);
		cmbFruit.setModel(getModel());
		cmbFruit.setSelectedIndex(-1);
		pLeft.add(cmbFruit);
		
		tfFruits = new JTextField();
		
	
		pLeft.add(tfFruits);
		tfFruits.setColumns(10);

		pRight = new JPanel();
		pRight.setBorder(new TitledBorder(null, "\uC608\uC81C 11-13", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRight);
		pRight.setLayout(new GridLayout(4, 0, 0, 0));
		
		cmbStudent = new JComboBox<>();
		//nullpointer exception => setselectedIndex(-1)
		cmbStudent.setModel(getModelStd());
		cmbStudent.setSelectedIndex(-1);
		pRight.add(cmbStudent);
		
		lblStudent = new JLabel("학생정보");
		lblStudent.setHorizontalAlignment(SwingConstants.CENTER);
		pRight.add(lblStudent);
		
		btnConfirm = new JButton("확인");
		btnConfirm.addActionListener(this);
		pRight.add(btnConfirm);
		
		panel = new JPanel();
		pRight.add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		lblNum = new JLabel("번호");
		lblNum.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNum);
		
		tfNum = new JTextField();
		panel.add(tfNum);
		tfNum.setColumns(10);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		panel.add(btnSearch);
		
		//cmbFruits에 제네릭 추가 후 콤보박스모델에서 setmodel(model)로 변경
		//cmbFruit.setModel(model);
		
		lblText = new JLabel("");
		lblText.setHorizontalAlignment(SwingConstants.CENTER);
		pLeft.add(lblText);
		
		btnOk = new JButton("확인");
		btnOk.addActionListener(this);
		pLeft.add(btnOk);
		
		
		
		//리스너는 initialize 가장 마지막에 실행되도록 하기
		//리스너가 수행되면서 필요한 라벨이나 textfield가 코드 순서 상 생성되기 전에 리스너가 수행되면 nullpointer exception 
		cmbFruit.addActionListener(this);
		cmbStudent.addActionListener(this);
		tfFruits.addActionListener(this);
	}

	private ComboBoxModel getModelStd() {
		modelStd = new DefaultComboBoxModel<Student>();
		Student[] stdList = {new Student(1, "서현진", 80, 90, 90),
							 new Student(2, "이주영", 50, 20, 70),
							 new Student(3, "강소라", 40, 70, 50)};
		
		for(Student std : stdList) {
			modelStd.addElement(std);
		}
		return modelStd;
	}

	private ComboBoxModel<String> getModel() {
		
		model = new DefaultComboBoxModel<String>();
		
		String[] fs = new String[] { "apple", "banana", "kiwi","mango", "pear", "peach", "berry", "strawberry", "blackberry" };
		//List<String> fruits = new ArrayList<>(); //ArrayList의 부모는 List 
		for(String f : fs) {
			model.addElement(f);
		}
		return model;
	}

	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			btnSearchActionPerformed(e);
		}
		if (e.getSource() == btnConfirm) {
			btnConfirmActionPerformed(e);
		}
		if (e.getSource() == cmbStudent) {
			cmbStudentActionPerformed(e);
		}
		if (e.getSource() == btnOk) {
			btnOkActionPerformed(e);
		}
		if (e.getSource() == cmbFruit) {
			cmbFruitActionPerformed(e);
		}
		if (e.getSource() == tfFruits) {
			tfFruitsActionPerformed(e);
		}
	}
	protected void tfFruitsActionPerformed(ActionEvent e) {
		model.addElement(tfFruits.getText());
		tfFruits.setText("");
	}
	protected void cmbFruitPropertyChange(PropertyChangeEvent evt) {}
	
	
	protected void cmbFruitActionPerformed(ActionEvent e) {
		JComboBox<String> cb = (JComboBox<String>) e.getSource();
		String str= (String) cb.getSelectedItem();
		//System.out.println(str);
		lblText.setText(str);
	}
	protected void btnOkActionPerformed(ActionEvent e) {
		//JComboBox<String> cb = (JComboBox<String>) e.getSource();
		//String str = (String) cb.getSelectedItem();
		JOptionPane.showMessageDialog(null, "선택한 과일은 " + (String)cmbFruit.getSelectedItem());
	}
	protected void cmbStudentActionPerformed(ActionEvent e) {
		
		  JComboBox<Student> cbStd = (JComboBox<Student>) e.getSource();
		  Student std = (Student) cbStd.getSelectedItem(); //System.out.println(std);
		  lblStudent.setText(std+"");
		 
		 
	}
	protected void btnConfirmActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, cmbStudent.getSelectedItem());
	}
	protected void btnSearchActionPerformed(ActionEvent e) {
		int stdNum = Integer.parseInt(tfNum.getText());
		System.out.println(stdNum);
		Student selStd = modelStd.getElementAt(stdNum-1);
		System.out.println(selStd);
		cmbStudent.setSelectedItem(selStd);
		/*
		 * Student[] list = new Student[] {}; for(int i=0; i<3; i++) { list[i] =
		 * modelStd.getElementAt(i); System.out.println(list[i]); }
		 */
		
	}

	
}
