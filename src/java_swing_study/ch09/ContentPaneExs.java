package java_swing_study.ch09;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContentPaneExs extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnOk;
	private JButton btnCancel;
	private JButton btnNewButton;



	/**
	 * Create the frame.
	 */
	public ContentPaneExs() {
		//JPanel을 JFrame에 넣기
		initialize(); //설정에서 추가했던 부분 (window builder 세팅.hwp)
	}
	private void initialize() {
		setTitle("Contentpane 과 JFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300); //좌표 (x로 100, y로 100, x.100부터 폭이 450, 높이가 300
		contentPane = new JPanel(); //컨테이너  = JPanel
		contentPane.setBackground(Color.ORANGE);//Design에서 Components -> contentPane -> background 요소 -> ORANGE
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//borderLayout -> top, south, right, center, left) border 간의 갭이 0, 0
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(this);
		contentPane.add(btnOk);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);
		contentPane.add(btnCancel);
		
		btnNewButton = new JButton("Ignore");
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
	}



	public void actionPerformed(ActionEvent e) {
		//JOptionPane.showMessageDialog(null,e.getActionCommand());
		if (e.getSource() == btnNewButton) {
			btnNewButtonActionPerformed(e);
		}
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnOk) {
			btnOkActionPerformed(e);
		}
	}
	protected void btnOkActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null,e.getActionCommand());
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, e.getActionCommand());
	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, e.getActionCommand());
	}
}
