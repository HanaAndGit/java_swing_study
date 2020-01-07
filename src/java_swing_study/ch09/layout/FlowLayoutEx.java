package java_swing_study.ch09.layout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class FlowLayoutEx extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { FlowLayoutEx frame = new
	 * FlowLayoutEx(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public FlowLayoutEx() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("FlowLayout Sample");
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
		
		JButton btnAdd = new JButton("add");
		contentPane.add(btnAdd);
		
		JButton btnsub = new JButton("sub");
		contentPane.add(btnsub);
		
		JButton btnmul = new JButton("mul");
		contentPane.add(btnmul);
		
		JButton btndiv = new JButton("div");
		contentPane.add(btndiv);
		
		JButton btncalculate = new JButton("calculate");
		contentPane.add(btncalculate);
	}

}
