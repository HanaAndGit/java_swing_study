package java_swing_study.ch14.exam.ui.panel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import java_swing_study.ch14.exam.dto.Department;

@SuppressWarnings("serial")
public class DeptPanel extends AbsItemPanel<Department> {
	private JLabel lbl01;
	private JTextField tfNo;
	private JLabel lbl02;
	private JTextField tfName;
	private JLabel lbl03;
	private JTextField tfLo;

	/**
	 * Create the panel.
	 */
	public DeptPanel() {

		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(null, "\uBD80\uC11C\uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 0, 0));
		
		lbl01 = new JLabel("부서 번호");
		lbl01.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbl01);
		
		tfNo = new JTextField();
		add(tfNo);
		tfNo.setColumns(10);
		
		lbl02 = new JLabel("부서 이름");
		lbl02.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbl02);
		
		tfName = new JTextField();
		add(tfName);
		tfName.setColumns(10);
		
		lbl03 = new JLabel("부서 위치");
		lbl03.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbl03);
		
		tfLo = new JTextField();
		add(tfLo);
		tfLo.setColumns(10);
	}
	@Override
	public void clearTf() {
		tfNo.setText("");
		tfName.setText("");
		tfLo.setText("");
		
	}
	@Override
	public void setItem(Department item) {
		tfNo.setText(item.getDeptNo()+"");
		tfName.setText(item.getDeptName());
		tfLo.setText(item.getFloor()+"");
		
		
	}
	@Override
	public Department getItem() {
		Department dpt = new Department(Integer.parseInt(tfNo.getText()),tfName.getText(),Integer.parseInt(tfLo.getText()));
		return dpt;
	}

}
