package java_swing_study.ch14;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java_swing_study.ch11.exam.Student;
import java_swing_study.ch11.exam.StudentPanel;

public class DialogEx extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private StudentPanel pStd;
	private MenuActionEventEx parent;
	private JButton cancelButton;
	/**
	 * Launch the application.
	 */
	/*
	 *1번 할일 :  내용 복사 후 MEnuActionEventEx 에 붙여넣기 public static void main(String[] args) { try
	 * {
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } }
	 */

	/**
	 * Create the dialog.
	 */
	
	
	/*public DialogEx(MenuActionEventEx menuActionEventEx) {
			
		}*/
	public DialogEx() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			pStd = new StudentPanel();
			contentPanel.add(pStd, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	

	public MenuActionEventEx getParent() {
		return parent;
	}


	//부모 지정
	public void setParent(MenuActionEventEx parent) {
		this.parent = parent;
	}



	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelButton) {
			cancelButtonActionPerformed(e);
		}
		if (e.getSource() == okButton) {
			okButtonActionPerformed(e);
		}
	}
	protected void okButtonActionPerformed(ActionEvent e) {
		//ok 클릭하면 MenuActionEventEx 에 학생 정보 뜨게 하기
		Student std = pStd.getItem();
		//System.out.println(std);
		parent.setStudentText(std);
		pStd.clearTf();
		//자기 자신은 보이지 않게 하기
		dispose();
	}
	
	public void setStudent(Student std) {
		pStd.setItem(std);
	}
	
	
	  public Student getStudent() { return pStd.getItem(); }
	 
	
	
	protected void cancelButtonActionPerformed(ActionEvent e) {
		/*
		 * Student std = pStd.getItem(); System.out.println(std);
		 */
		setVisible(false);
	}



	public Student getInput() {
		Student std = pStd.getItem();
		//System.out.println(std);
		return std;
	}
}
