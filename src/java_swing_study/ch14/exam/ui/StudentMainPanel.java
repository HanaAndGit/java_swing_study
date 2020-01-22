package java_swing_study.ch14.exam.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java_swing_study.ch14.exam.ui.panel.StudentPanel;
import java_swing_study.ch14.exam.ui.panel.StudentTblPanel;

public class StudentMainPanel extends JPanel {
	private StudentPanel pStdInfo;
	private JPanel pBtnsTable;
	private JPanel pBtns;
	private StudentTblPanel pStdTable;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

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
		
		btnNewButton = new JButton("New button");
		pBtns.add(btnNewButton);
		
		btnNewButton_1 = new JButton("New button");
		pBtns.add(btnNewButton_1);
		
		pStdTable = new StudentTblPanel();
		pBtnsTable.add(pStdTable, BorderLayout.CENTER);
	}

}
