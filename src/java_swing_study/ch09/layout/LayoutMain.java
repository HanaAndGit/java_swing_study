package java_swing_study.ch09.layout;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class LayoutMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnFlowLayout;
	private JButton btnBorderLayout;
	private JButton btnGridLayout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LayoutMain frame = new LayoutMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LayoutMain() {
		setTitle("배치 레이아웃 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 128);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, /*"\uB808\uC774\uC544\uC6C3 \uC608\uC81C"*/"레이아웃 예제", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnFlowLayout = new JButton("FlowLayout");
		btnFlowLayout.addActionListener(this);
		contentPane.add(btnFlowLayout);
		
		btnBorderLayout = new JButton("border layout");
		btnBorderLayout.addActionListener(this);
		contentPane.add(btnBorderLayout);
		
		btnGridLayout = new JButton("GridLayout");
		btnGridLayout.addActionListener(this);
		contentPane.add(btnGridLayout);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGridLayout) {
			btnGridLayoutActionPerformed(e);
		}
		if (e.getSource() == btnBorderLayout) {
			btnBorderLayoutActionPerformed(e);
		}
		if (e.getSource() == btnFlowLayout) {
			btnFlowLayoutActionPerformed(e);
		}
	}
	protected void btnFlowLayoutActionPerformed(ActionEvent e) {
		
		FlowLayoutEx frame = new FlowLayoutEx();
		frame.setVisible(true);
		
	}
	protected void btnBorderLayoutActionPerformed(ActionEvent e) {
		BorderLayoutEx frame = new BorderLayoutEx();
		frame.setVisible(true);
	}
	protected void btnGridLayoutActionPerformed(ActionEvent e) {
		GridLayoutEx frame = new GridLayoutEx();
		frame.setVisible(true);
	}
}
