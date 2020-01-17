package java_swing_study.ch11.exam2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ch11_02 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tf;
	private JPanel panel;
	private JComboBox <String> cmb;
	private ArrayList<String> names;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ch11_02 frame = new ch11_02();
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
	public ch11_02() {
		names = new ArrayList<>();
		initialize();
	}
	private void initialize() {
		setTitle("JTextField and JComboBox");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 371, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 60, 10, 60));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tf = new JTextField();
		contentPane.add(tf, BorderLayout.NORTH);
		tf.setColumns(10);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(20, 30, 20, 30));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		cmb = new JComboBox<>(new Vector<>(names));
		panel.add(cmb, BorderLayout.NORTH);
		

		tf.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tf) {
			tfActionPerformed(e);
		}
	}
	protected void tfActionPerformed(ActionEvent e) {
		String str = tf.getText();
		cmb.addItem(str);
		tf.setText("");
	}
}
