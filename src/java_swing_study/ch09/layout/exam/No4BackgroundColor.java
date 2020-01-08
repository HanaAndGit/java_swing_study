package java_swing_study.ch09.layout.exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;

public class No4BackgroundColor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					No4BackgroundColor frame = new No4BackgroundColor();
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
	public No4BackgroundColor() {
		setTitle("Ten Color Buttons Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 10, 0, 0));
		
		JButton btnRed = new JButton("0");
		btnRed.setForeground(Color.BLACK);
		btnRed.setBackground(Color.RED);
		contentPane.add(btnRed);
		
		JButton btnOrange = new JButton("1");
		btnOrange.setBackground(Color.ORANGE);
		contentPane.add(btnOrange);
		
		JButton btnYellow = new JButton("2");
		btnYellow.setBackground(Color.YELLOW);
		contentPane.add(btnYellow);
		
		JButton btnGreen = new JButton("3");
		btnGreen.setBackground(Color.GREEN);
		contentPane.add(btnGreen);
		
		JButton btnSkyblue = new JButton("4");
		btnSkyblue.setBackground(Color.CYAN);
		contentPane.add(btnSkyblue);
		
		JButton btnBlue = new JButton("5");
		btnBlue.setBackground(Color.BLUE);
		contentPane.add(btnBlue);
		
		JButton btnPurple = new JButton("6");
		btnPurple.setBackground(new Color(138, 43, 226));
		contentPane.add(btnPurple);
		
		JButton btnGray = new JButton("7");
		btnGray.setBackground(Color.GRAY);
		contentPane.add(btnGray);
		
		JButton btnPink = new JButton("8");
		btnPink.setBackground(Color.PINK);
		contentPane.add(btnPink);
		
		JButton btnLightGray = new JButton("9");
		btnLightGray.setBackground(Color.LIGHT_GRAY);
		contentPane.add(btnLightGray);
	}

}
