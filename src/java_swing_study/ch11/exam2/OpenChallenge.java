package java_swing_study.ch11.exam2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class OpenChallenge extends JFrame {

	private JPanel contentPane;
	private JLabel lblImg;
	private JPanel pBtns;
	private ImageIcon img1;
	private ImageIcon img2;
	private JLabel lbl01;
	private JLabel lbl02;
	private ArrayList<ImageIcon> icons;
	private int index = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpenChallenge frame = new OpenChallenge();
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
	public OpenChallenge() {
		
		getBtns();
		getHeros();
		initialize();
	}

	private void getHeros() {
		icons = new ArrayList<>();
		String imgPath = System.getProperty("user.dir") + "\\images\\";
		icons.add(new ImageIcon(imgPath+"super.jpg"));
		icons.add(new ImageIcon(imgPath+"superman.jpg"));
		icons.add(new ImageIcon(imgPath+"bet.jpg"));
		icons.add(new ImageIcon(imgPath+"spider.jpg"));
	}

	private void getBtns() {
		String imgPath = System.getProperty("user.dir") + "\\images\\";
		img1 = new ImageIcon(imgPath+"left.png");
		img2 = new ImageIcon(imgPath+"right.png");
	}
	private void initialize() {
		setTitle("Open Challenge 11");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 318, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lblImg = new JLabel("");
		contentPane.add(lblImg, BorderLayout.CENTER);
		
		pBtns = new JPanel();
		contentPane.add(pBtns, BorderLayout.SOUTH);
		pBtns.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lbl01 = new JLabel(img1);
		lblImg.setIcon(icons.get(index));
		lbl01.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(index != 0) {
					index--;
					lblImg.setIcon(icons.get(index));
				}
			}
			
		});
		pBtns.add(lbl01);
		
		lbl02 = new JLabel(img2);
		lbl02.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(index < 3) {
					index++;
					lblImg.setIcon(icons.get(index));
				}
			}
			
		});
		pBtns.add(lbl02);
	}

	
	
}
