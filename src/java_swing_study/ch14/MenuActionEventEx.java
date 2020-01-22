package java_swing_study.ch14;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java_swing_study.ch11.exam.StudentPanel;

import javax.swing.JSeparator;

public class MenuActionEventEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu nmScreen;
	private JMenuItem nmLoad;
	private JMenuItem nmHide;
	private JMenuItem nmReshow;
	private JMenuItem nmExit;
	private JLabel lblImg;
	private String imgDirPath = System.getProperty("user.dir") + "\\images\\";
	private JMenuItem nmStudent;
	private JSeparator separator;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuActionEventEx frame = new MenuActionEventEx();
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
	public MenuActionEventEx() {
		initialize();
	}
	private void initialize() {
		setTitle("메뉴달기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 477);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		nmScreen = new JMenu("Screen");
		menuBar.add(nmScreen);
		
		nmLoad = new JMenuItem("Load");
		nmScreen.add(nmLoad);
		
		nmHide = new JMenuItem("Hide");
		nmScreen.add(nmHide);
		
		nmReshow = new JMenuItem("Reshow");
		nmScreen.add(nmReshow);
		
		nmStudent = new JMenuItem("학생");
		nmStudent.addActionListener(this);
		nmScreen.add(nmStudent);
		
		separator = new JSeparator();
		nmScreen.add(separator);
		
		nmExit = new JMenuItem("Exit");
		nmScreen.add(nmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lblImg = new JLabel("");
		contentPane.add(lblImg, BorderLayout.CENTER);
		
		

		nmLoad.addActionListener(this);
		nmHide.addActionListener(this);
		nmReshow.addActionListener(this);
		nmExit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nmStudent) {
			nmStudentActionPerformed(e);
		}
		if (e.getSource() == nmReshow) {
			nmReshowActionPerformed(e);
		}
		if (e.getSource() == nmHide) {
			nmHideActionPerformed(e);
		}
		if (e.getSource() == nmExit) {
			nmExitActionPerformed(e);
		}
		if (e.getSource() == nmLoad) {
			nmLoadActionPerformed(e);
		}
	}
	protected void nmLoadActionPerformed(ActionEvent e) {
		//JOptionPane.showMessageDialog(null, e.getActionCommand());
		if(lblImg.getIcon() != null) {
			return;
		}
		lblImg.setIcon(new ImageIcon(imgDirPath+"bet.jpg"));
		
		
	}
	protected void nmExitActionPerformed(ActionEvent e) {
		//0 -> 정상종료
		System.exit(0);
	}
	protected void nmHideActionPerformed(ActionEvent e) {
		//JOptionPane.showMessageDialog(null, e.getActionCommand());
		if(lblImg.isVisible()) {
			lblImg.setVisible(false);
		}
	}
	protected void nmReshowActionPerformed(ActionEvent e) {
		//JOptionPane.showMessageDialog(null, e.getActionCommand());
		if(!lblImg.isVisible()) {
			lblImg.setVisible(true);
		}
	}
	
	
	protected void nmStudentActionPerformed(ActionEvent e) {
		StudentPanel sp = new StudentPanel();
		contentPane.add(sp, BorderLayout.SOUTH);
		//============ 다시 그리기 ===========
		revalidate();
		repaint();
	}
}
