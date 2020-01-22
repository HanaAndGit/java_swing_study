package java_swing_study.ch14.exam.ui.panel;

import javax.swing.JPanel;

import java_swing_study.ch14.exam.dto.Department;

public class DeptTblPanel extends AbstractTblPanel<Department> {

	/**
	 * Create the panel.
	 */
	public DeptTblPanel() {

	}

	@Override
	protected void setTblWidthAlign() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String[] getColNames() {
		return new String[] {"부서 번호", "부서 이름", "위치"};
	}

	@Override
	protected Object[] toArray(Department item) {
		
		return new Object[] {
				item.getDeptNo(),
				item.getDeptName(),
				item.getFloor()
		};
	}

	@Override
	public void updateRow(Department time, int updateIdx) {
		
		
	}

	@Override
	public Department getSelectedItem() {
		int idx = table.getSelectedRow();
		int deptNo = Integer.parseInt((String)model.getValueAt(idx, 0));
		String deptName = (String) model.getValueAt(idx, 1);
		int deptLo = Integer.parseInt((String)model.getValueAt(idx, 2));
		return new Department(deptNo, deptName, deptLo);
	}

}
