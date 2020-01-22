package java_swing_study.ch14.exam.ui.panel;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;

import java_swing_study.ch14.exam.dto.Student;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class StudentTblPanel extends AbstractTblPanel<Student> {
	private JTable table;
	/**
	 * Create the panel.
	 */
	public StudentTblPanel() {

	
	}
	
	
	
	public JTable getTable() {
		return table;
	}



	public void setTable(JTable table) {
		this.table = table;
	}



//	protected Object[][] getRows(ArrayList<Student> stds){
//		Object[][] rows = new Object[stds.size()][];
//		for(int i=0; i<rows.length; i++) {
//			rows[i] = toArray(stds.get(i));
//			//System.out.println(toArray(stds.get(i)));
//		}
//		return rows;
//	}
	
	@Override
	protected void setTblWidthAlign() {
		// TODO Auto-generated method stub
		
	}
	
	

	@Override
	protected String[] getColNames() {
		return new String[] { 
			"학생 번호", "학생 이름", "국어", "영어", "수학", "총점", "평균"
		};
	}

	@Override
	protected Object[] toArray(Student item) {
		return new Object[] {
				item.getStdNo(),
				item.getStdName(),
				item.getKor(),
				item.getEng(),
				item.getMath(),
				item.total(),
				item.avg()
		};
	}

	@Override
	public void updateRow(Student time, int updateIdx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student getSelectedItem() {
		int idx = table.getSelectedRow();
		int stdNo = (int) model.getValueAt(idx, 0);
		String stdName = (String) model.getValueAt(idx, 1);
		int kor = (int) model.getValueAt(idx, 2);
		int eng = (int) model.getValueAt(idx, 3);
		int math = (int) model.getValueAt(idx, 4);
		return null;
	}
	


}