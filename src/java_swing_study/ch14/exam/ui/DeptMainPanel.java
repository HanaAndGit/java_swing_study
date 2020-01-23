package java_swing_study.ch14.exam.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import java_swing_study.ch14.exam.dto.Department;
import java_swing_study.ch14.exam.ui.panel.DeptPanel;
import java_swing_study.ch14.exam.ui.panel.DeptTblPanel;

@SuppressWarnings("serial")
public class DeptMainPanel extends JPanel implements ActionListener {
	private DeptPanel pDept;
	private JPanel panel_1;
	private JPanel panel_2;
	private DeptTblPanel panel_3;
	private JButton btnAdd;
	private JButton btnCancel;
	private ArrayList<Department> depts = new ArrayList<Department>();

	/**
	 * Create the panel.
	 */
	public DeptMainPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		pDept = new DeptPanel();
		add(pDept, BorderLayout.NORTH);
		
		panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		panel_2.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panel_2.add(btnCancel);
		
		panel_3 = new DeptTblPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			btnSetActionPerformed(e);
		}
	}
	protected void btnSetActionPerformed(ActionEvent e) {
		Department newDept = pDept.getItem();
		depts.add(newDept);
		panel_3.loadData(depts);
		pDept.clearTf();
		
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
