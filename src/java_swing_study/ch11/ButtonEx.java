package java_swing_study.ch11;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ButtonEx extends JFrame {

	private JPanel contentPane;
	private JButton btn1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ButtonEx frame = new ButtonEx();
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
	public ButtonEx() {
		initialize();
	}
	private void initialize() {
		setTitle("이미지 버튼 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		String dirPath = System.getProperty("user.dir") + "\\images\\";
		
		btn1 = new JButton("call");
		btn1.setIcon(new ImageIcon(dirPath + "normalIcon.gif"));
		contentPane.add(btn1);
		
		btn1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				btn1.setIcon(new ImageIcon(dirPath + "pressedIcon.gif"));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btn1.setIcon(new ImageIcon(dirPath + "rolloverIcon.gif"));
			}
			
		});
	}

}
