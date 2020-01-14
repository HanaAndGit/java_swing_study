package java_swing_study.ch11.exam;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class StudentPanel extends AbsItemPanel<Student> {
	private JLabel lblStdNo;
	private JTextField tfStdNo;
	private JLabel lblStdName;
	private JTextField tfName;
	private JLabel lblKor;
	private JTextField tfKor;
	private JLabel lblMath;
	private JTextField tfMath;
	private JLabel lblEng;
	private JTextField tfEng;
	
	public JLabel getLblStdNo() {
		return lblStdNo;
	}
	public JTextField getTfStdNo() {
		return tfStdNo;
	}
	public JLabel getLblStdName() {
		return lblStdName;
	}
	public JTextField getTfName() {
		return tfName;
	}
	public JLabel getLblKor() {
		return lblKor;
	}
	public JTextField getTfKor() {
		return tfKor;
	}
	public JLabel getLblMath() {
		return lblMath;
	}
	public JTextField getTfMath() {
		return tfMath;
	}
	public JLabel getLblEng() {
		return lblEng;
	}
	public JTextField getTfEng() {
		return tfEng;
	}
	/**
	 * Create the panel.
	 */
	public StudentPanel() {

		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(null, "\uD559\uC0DD \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 10, 10));
		
		lblStdNo = new JLabel("학생번호");
		lblStdNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblStdNo);
		
		tfStdNo = new JTextField();
		add(tfStdNo);
		tfStdNo.setColumns(10);
		
		lblStdName = new JLabel("학생이름");
		lblStdName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblStdName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		add(tfName);
		
		lblKor = new JLabel("국어");
		lblKor.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblKor);
		
		tfKor = new JTextField();
		tfKor.setColumns(10);
		add(tfKor);
		
		lblMath = new JLabel("수학");
		lblMath.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblMath);
		
		tfMath = new JTextField();
		tfMath.setColumns(10);
		add(tfMath);
		
		lblEng = new JLabel("영어");
		lblEng.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblEng);
		
		tfEng = new JTextField();
		tfEng.setColumns(10);
		add(tfEng);
	}
	@Override
	public void clearTf() {
		tfName.setText("");
		tfStdNo.setText("");
		tfKor.setText("");
		tfMath.setText("");
		tfEng.setText("");
	}
	@Override
	public void setItem(Student item) {
		
		tfName.setText(item.getStdName());
		tfStdNo.setText(item.getStdNo()+"");
		tfKor.setText(item.getKor()+"");
		tfMath.setText(item.getKor()+"");
		tfEng.setText(item.getEng()+"");
		
	}
	@Override
	public Student getItem() {
		Student std01 = new Student(Integer.parseInt(tfStdNo.getText()), tfName.getText(), Integer.parseInt(tfKor.getText()), Integer.parseInt(tfMath.getText()), Integer.parseInt(tfEng.getText()));
		return std01;
	}
	
	

}
