package java_swing_study.ch09.layout;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class BorderLayoutEx extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public BorderLayoutEx() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(30, 20));
		setContentPane(contentPane);
		
		JButton btnadd = new JButton("Add");
		contentPane.add(btnadd, BorderLayout.NORTH);
		
		JButton btndiv = new JButton("Div");
		contentPane.add(btndiv, BorderLayout.WEST);
		
		JButton btnsub = new JButton("sub");
		contentPane.add(btnsub, BorderLayout.SOUTH);
		
		JButton btnCalculate = new JButton("Calculate");
		contentPane.add(btnCalculate, BorderLayout.CENTER);
		
		JButton btnmul = new JButton("Mul");
		contentPane.add(btnmul, BorderLayout.EAST);
	}

}
