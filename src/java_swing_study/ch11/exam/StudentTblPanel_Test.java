package java_swing_study.ch11.exam;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class StudentTblPanel_Test extends JPanel {
	private JScrollPane scrollPane;
	/*private*/ protected JTable table;
	/*private*/ protected NotEditableModel model;

	public StudentTblPanel_Test() {
			
		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(table);
		//외부에서 호출 하도록 할 예정
		ArrayList<Student> v = new ArrayList<Student>();
		v = new  ArrayList<Student>();
		v.add(new Student(1, "서현진", 80, 80, 90));
		v.add(new Student(2, "이성경", 90, 10, 20));
		v.add(new Student(3, "이유영", 80, 80, 20));
		
		loadData(v);
	}
	
	
	private void setPopupMenu(JPopupMenu popupMenu) {
		scrollPane.setComponentPopupMenu(popupMenu);
		table.setComponentPopupMenu(popupMenu);
	}
	
	
	private void loadData(ArrayList<Student> stds) {
		model = new NotEditableModel(getRows(stds),	getColNames());
		table.setModel(model);
		
		setTblWidthAlign();
		
		
	}
	
	
	
	private void setTblWidthAlign() {
		//각 컬럼의 폭과 셀의 수평 정렬
		tableSetWidth(50, 150, 450, 50, 70, 70);
		tableCellAlign(SwingConstants.CENTER, 0, 1,2,4);
		tableCellAlign(SwingConstants.RIGHT, 5,6);
		tableCellAlign(SwingConstants.LEFT, 3);
	}
	private void tableCellAlign(int align, int...idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		
		
		TableColumnModel  cModel = table.getColumnModel();
		for(int i=0; i<idx.length; i++) {
			cModel.getColumn(idx[i]).setCellRenderer(dtcr);
			
		}
		/*
		 * cModel.getColumn(1).setCellRenderer(dtcr);
		 * cModel.getColumn(2).setCellRenderer(dtcr);
		 * cModel.getColumn(3).setCellRenderer(dtcr);
		 * cModel.getColumn(4).setCellRenderer(dtcr);
		 */
		
	}
	//☆★ 가변인수 (int...width) -> tableSetWidth 값을 배열로 받아옴
	private void tableSetWidth(int...width) {

		TableColumnModel cModel  = table.getColumnModel();
		for(int i=0; i<width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
			//System.out.println(width[i]);
		}
		/*
		 * dcModel.getColumn(0).setPreferredWidth(150);
		 * dcModel.getColumn(0).setPreferredWidth(50);
		 * dcModel.getColumn(0).setPreferredWidth(50);
		 * dcModel.getColumn(0).setPreferredWidth(50);
		 * dcModel.getColumn(0).setPreferredWidth(70);
		 * dcModel.getColumn(0).setPreferredWidth(70);
		 */
		
	}
	private String[] getColNames() {
		return new String[] {
				"번호", "학생 명", "국어", "영어", "수학", "총점", "평균"
		};
	}
	private Object[][] getRows(ArrayList<Student> stds) {
		Object[][] rows = new Object[stds.size()][];
		for(int i=0; i<rows.length; i++) {
			rows[i] = toArray(stds.get(i));
		}
		return rows;
	}
	
	private Object[] toArray(Student std) {
		
		return new Object[] {
				String.format("%03d", std.getStdNo()), 
				std.getStdName(), 
				std.getKor(), 
				std.getEng(), 
				std.getMath(), 
				std.total(), 
				String.format("%.2f", std.avg())};
	}
	
	
	public void removeRow() /* throws Exception*/ {
		int selectedIdx = getSelectedRowIdx();
		model.removeRow(selectedIdx);
	}
	public void updateRow(Student std, int updateIdx) {
		model.setValueAt(std.getStdNo(), updateIdx, 0); //학생 번호
		model.setValueAt(std.getStdName(), updateIdx, 1);
		model.setValueAt(std.getKor(), updateIdx, 2);
		model.setValueAt(std.getEng(), updateIdx, 3);
		model.setValueAt(std.getMath(), updateIdx, 4);
		model.setValueAt(std.total(), updateIdx, 5);
		model.setValueAt(std.avg(), updateIdx, 6);
	}
	
	protected void addItem(Student std) {
		model.addRow(toArray(std));
		
	}
	private int getSelectedRowIdx() /*throws Exception*/ {
		int selectedIdx = table.getSelectedRow();
		System.out.println("선택 된 row : " + selectedIdx);
		if(selectedIdx == -1) {
			

			//throw new Exception("해당 학생을 선택하세요.");
			
			//runtimeException은 try, catch 문 필수 x
			throw new RuntimeException("해당 학생을 선택하세요.");
			/*
			 * JOptionPane.showMessageDialog(null, "해당 학생을 선택하세요."); return;
			 */
		}
		return selectedIdx;
	}
	
	public Student getSelectedItem() {
		int selectedIdx = table.getSelectedRow();
		//int stdNo = (int) model.getValueAt(selectedIdx, 0);
		int stdNo = Integer.parseInt((String) model.getValueAt(selectedIdx, 0));
		String stdName = (String) model.getValueAt(selectedIdx, 1);
		int kor = (int) model.getValueAt(selectedIdx, 2);
		int math = (int) model.getValueAt(selectedIdx, 3);
		int eng =(int) model.getValueAt(selectedIdx, 4);
		
		
		
		return new Student(stdNo, stdName, kor,math, eng);
	}
	
	
	
	//수정 금지 하기 위한 모델 선언
	private class NotEditableModel extends DefaultTableModel{

		public NotEditableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			//모든 컬럼 return false -> 수정 불가능
			return false;
		}
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(10, 10, 450, 500);
		
		StudentTblPanel_Test tbl = new StudentTblPanel_Test();
		frame.add(tbl);
		frame.setVisible(true);
	
		//마우스 우클릭 팝업 메뉴
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem addItem = new JMenuItem("추가");
		addItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Student newStudent = new Student(10, "장현서", 80 , 90 , 70);
				tbl.addItem(newStudent);
				
			}
		});
		popMenu.add(addItem);
		
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Student upStd = new Student(2, "이상원", 100, 100, 100);
				
				tbl.updateRow(upStd, 1);// 이성경 학생을 이상원 으로 변경
				
				
			}
		});
		popMenu.add(updateItem);
		
		JMenuItem getSelectedItem = new JMenuItem("선택한 학생 확인");
		getSelectedItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Student selectedStd = tbl.getSelectedItem();
				JOptionPane.showMessageDialog(null, "선택한 학생은  " + selectedStd );
				
			}
			
		});
		popMenu.add(getSelectedItem);
		
		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tbl.removeRow();
				}catch(RuntimeException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		popMenu.add(deleteItem);
		
		
		
		
		tbl.setPopupMenu(popMenu);
		
	}
	

}
