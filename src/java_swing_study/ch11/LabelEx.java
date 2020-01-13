package java_swing_study.ch11;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class LabelEx extends JFrame {

	private JPanel contentPane;
	private JLabel lblImageLabel;
	private JLabel lblTextLabel;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabelEx frame = new LabelEx();
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
	public LabelEx() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lblImageLabel = new JLabel("New label");
		lblImageLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("mouseClicked()");
			}
			
		});
		String dirPath = System.getProperty("user.dir") + "\\images\\";
		System.out.println(dirPath);
		lblImageLabel.setIcon(new ImageIcon(dirPath + "beauty.jpg"));
		contentPane.add(lblImageLabel, BorderLayout.CENTER);
		
		lblTextLabel = new JLabel("사랑합니다.");
		lblTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTextLabel, BorderLayout.NORTH);
		
		lblNewLabel = new JLabel("보고싶으면 전화하세요.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("D:\\workspace\\workspace_java\\java_swing_study\\images\\normalIcon.gif"));
		contentPane.add(lblNewLabel, BorderLayout.SOUTH);
	}

}
