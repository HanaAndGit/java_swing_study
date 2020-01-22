package java_swing_study.ch14.exam.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;

import java_swing_study.ch14.exam.dto.Student;
import java_swing_study.ch14.exam.ui.panel.StudentPanel;
import java_swing_study.ch14.exam.ui.panel.StudentTblPanel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class StudentMainPanel extends JPanel implements ActionListener {
	private StudentPanel pStdInfo;
	private JPanel pBtnsTable;
	private JPanel pBtns;
	private StudentTblPanel pStdTable;
	private JButton btnAdd;
	private JButton btnCancel;
	private ArrayList<Student> stds = new ArrayList<Student>();
	/**
	 * Create the panel.
	 */
	public StudentMainPanel() {
		
		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		pStdInfo = new StudentPanel();
		add(pStdInfo, BorderLayout.NORTH);
		
		pBtnsTable = new JPanel();
		add(pBtnsTable, BorderLayout.CENTER);
		pBtnsTable.setLayout(new BorderLayout(0, 0));
		
		pBtns = new JPanel();
		pBtnsTable.add(pBtns, BorderLayout.NORTH);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);
		
		pStdTable = new StudentTblPanel();
		pBtnsTable.add(pStdTable, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
	}
	protected void btnAddActionPerformed(ActionEvent e) {
		
		Student std =  pStdInfo.getItem();//입력란에 입력된 학생 객체 가져오기
		stds.add(std); //ArrayList에 추가하기
		//System.out.println(std);
		pStdTable.loadData(stds); //로드 데이터
		//로드데이터까지 했는데 테이블에 총점, 평균만 안나왔음 -> 해결 : toArray에서 total,avg를 안불러옴
		pStdInfo.clearTf();
		
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
