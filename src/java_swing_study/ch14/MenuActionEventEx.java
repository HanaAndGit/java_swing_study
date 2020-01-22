package java_swing_study.ch14;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import java_swing_study.ch11.exam.Student;
import java_swing_study.ch11.exam.StudentPanel;

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
	private JToolBar toolBar;
	private JButton btnNew;
	private JButton btnImg;
	private JButton btnNewButton;
	private JSeparator separator_1;
	private JButton btnModal;

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
		
		toolBar = new JToolBar();
		toolBar.setName("Kitae Menu");
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		btnNew = new JButton("학생정보 입력");
		btnNew.addActionListener(this);
		btnNew.setToolTipText("학생정보 대화상자");
		toolBar.add(btnNew);
		
		btnImg = new JButton("Img");
		btnImg.setIcon(new ImageIcon(/*(MenuActionEventEx.class.getResource(*/imgDirPath + "open.jpg"));
		toolBar.add(btnImg);
		
		/*
		 * separator_1 = new JSeparator(); separator_1.setMaximumSize(new Dimension(2,
		 * 13)); separator_1.setOrientation(SwingConstants.VERTICAL);
		 */
		toolBar.addSeparator();
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(this);
		toolBar.add(btnNewButton);
		
		btnModal = new JButton("모달 대화상자");
		btnModal.addActionListener(this);
		toolBar.add(btnModal);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModal) {
			btnModalActionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			btnNewButtonActionPerformed(e);
		}
		if (e.getSource() == btnNew) {
			btnNewActionPerformed(e);
		}
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
	protected void btnNewActionPerformed(ActionEvent e) {
		// 1번 할일 : DialogEx main 복사 후 붙여넣기
		DialogEx dialog = new DialogEx();
		//부모지정
		dialog.setParent(this);
		dialog.setStudent(new Student(1,"김", 80, 90, 90));
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
	
	public void setStudentText(Student std) {
		lblImg.setText(std.toString());
	}
	
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		DialogEx dialog = new DialogEx();
		
		dialog.setStudent(new Student(1,"김", 80, 90, 90));
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		
		Student std = dialog.getStudent();
		lblImg.setText(std.toString());
	}
	protected void btnModalActionPerformed(ActionEvent e) {
		DialogEx dialog = new DialogEx();
		dialog.setModal(true);
		
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		//dialog 대화상자가 닫히면 아래 코드 수행됨
		Student std = dialog.getInput();
		lblImg.setText(std.toString());
	}
}
