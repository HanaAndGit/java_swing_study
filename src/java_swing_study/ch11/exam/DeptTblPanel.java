package java_swing_study.ch11.exam;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class DeptTblPanel extends AbstractTblPanel<Department> {

	/**
	 * Create the panel.
	 */
	public DeptTblPanel() {

		
		initialize();
	}
	private void initialize() {
	}
	
	@Override
	protected void setTblWidthAlign() {
		//tableSetWidth(50, 150, 450, 50, 70, 70);
		/*
		 * tableCellAlign(SwingConstants.CENTER, 0, 1,2,4);
		 * tableCellAlign(SwingConstants.RIGHT, 5,6);
		 * tableCellAlign(SwingConstants.LEFT, 3);
		 */
		
	}

	@Override
	protected String[] getColNames() {
		return new String[] {
				"부서 번호", "부서 이름", "부서 위치"
		};
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
	public void updateRow(Department item, int updateIdx) {
		model.setValueAt(item.getDeptNo(), updateIdx, 0);
		model.setValueAt(item.getDeptName(), updateIdx, 1);
		model.setValueAt(item.getFloor(), updateIdx, 2);
		
	}

	@Override
	public Department getSelectedItem() {
		int selectedIdx = getSelectedRowIdx();
		int deptNo = Integer.parseInt((String) model.getValueAt(selectedIdx, 0));
		String deptName = (String) model.getValueAt(selectedIdx, 1);
		int deptLo = Integer.parseInt((String)model.getValueAt(selectedIdx, 2));
		
		return new Department(deptNo, deptName, deptLo);
	}

}

