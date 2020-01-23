package java_swing_study.ch14;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTabbedPane;
import java_swing_study.ch14.exam.ui.panel.StudentPanel;

public class OptionPaneEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pTap;
	private JPanel pCenter;
	private JPanel pPopup;
	private JPanel pColorDlg;
	private JPanel pfileDlg;
	private JButton btnPopupInput;
	private JButton btnPopupConfirm;
	private JButton btnPopupMsg;
	private JLabel lblPopup;
	private JButton btnFileOpen;
	private JButton btnFileSave;
	private JLabel lblImg;
	private JFileChooser chooser;
	private JButton btnColor;
	private JLabel lblColor;
	private Color selectedColor;
	private JTabbedPane tabbedPane;
	private JLabel lbltab1;
	private StudentPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionPaneEx frame = new OptionPaneEx();
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
	public OptionPaneEx() {
		chooser = new JFileChooser(System.getProperty("user.dir")); //어느 경로로부터 열릴 것인지 지정
		selectedColor = JColorChooser.showDialog(null, "Color", Color.YELLOW);
		initialize();
	}
	private void initialize() {
		setTitle("팝업 다이얼로그 파일 다이얼로그");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pTap = new JPanel();
		contentPane.add(pTap, BorderLayout.NORTH);
		pTap.setLayout(new GridLayout(0, 3, 0, 0));
		
		pPopup = new JPanel();
		pPopup.setBorder(new TitledBorder(null, "\uD31D\uC5C5 \uB2E4\uC774\uC5BC\uB85C\uADF8", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pTap.add(pPopup);
		pPopup.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnPopupInput = new JButton("입력 다이얼로그");
		pPopup.add(btnPopupInput);
		
		btnPopupConfirm = new JButton("확인 다이얼로그");
		pPopup.add(btnPopupConfirm);
		
		btnPopupMsg = new JButton("메세지 다이얼로그");

		pPopup.add(btnPopupMsg);
		
		lblPopup = new JLabel("");
		pPopup.add(lblPopup);
		
		pfileDlg = new JPanel();
		pfileDlg.setBorder(new TitledBorder(null, "\uD30C\uC77C\uC5F4\uAE30/\uC800\uC7A5 \uB2E4\uC774\uC5BC\uB85C\uADF8", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pTap.add(pfileDlg);
		pfileDlg.setLayout(new BoxLayout(pfileDlg, BoxLayout.Y_AXIS));
		
		btnFileOpen = new JButton("열기");
		btnFileOpen.addActionListener(this);
		pfileDlg.add(btnFileOpen);
		
		btnFileSave = new JButton("저장");
		btnFileSave.addActionListener(this);
		pfileDlg.add(btnFileSave);
		
		lblImg = new JLabel("");
		pfileDlg.add(lblImg);
		
		pColorDlg = new JPanel();
		pColorDlg.setBorder(new TitledBorder(null, "\uCEEC\uB7EC \uB2E4\uC774\uC5BC\uB85C\uADF8", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pTap.add(pColorDlg);
		pColorDlg.setLayout(new BorderLayout(0, 0));
		
		btnColor = new JButton("색상 선택");
		btnColor.addActionListener(this);
		pColorDlg.add(btnColor, BorderLayout.NORTH);
		
		lblColor = new JLabel("Hello World");
		lblColor.setFont(new Font("Arial", Font.BOLD, 15));
		lblColor.setHorizontalAlignment(SwingConstants.CENTER);
		pColorDlg.add(lblColor, BorderLayout.CENTER);
		
		pCenter = new JPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		pCenter.add(tabbedPane);
		
		lbltab1 = new JLabel(new ImageIcon(System.getProperty("user.dir")+ "\\images\\"+ "superman.jpg"));
		tabbedPane.addTab("tab1", null, lbltab1, null);
		
		panel = new StudentPanel();
		tabbedPane.addTab("New tab", null, panel, null);

		btnPopupInput.addActionListener(this);
		btnPopupConfirm.addActionListener(this);
		btnPopupMsg.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnColor) {
			btnColorActionPerformed(e);
		}
		if (e.getSource() == btnFileOpen) {
			btnFileOpenActionPerformed(e);
		}
		if (e.getSource() == btnFileSave) {
			btnFileSaveActionPerformed(e);
		}
		if (e.getSource() == btnPopupMsg) {
			btnPopupMsgActionPerformed(e);
		}
		if (e.getSource() == btnPopupConfirm) {
			btnPopupConfirmActionPerformed(e);
		}
		if (e.getSource() == btnPopupInput) {
			btnPopupInputActionPerformed(e);
		}
	}
	protected void btnPopupInputActionPerformed(ActionEvent e) {
		String[] selectedValues = {"국어", "영어", "수학"};
		String res = (String) JOptionPane.showInputDialog(this, "과목을 선택하세요.", "과목 선택", JOptionPane.QUESTION_MESSAGE, null, selectedValues, selectedValues[0]);
		//null 도 됨/ 보여지는 부분, 메세지 / title 제목 /마크 / 아이콘 선택 (없으면 null) 
		if(res==null) {//x, 취소 누르면 null (선택값 없음)
			lblPopup.setText("선택없음");
			//System.out.println("선택없음");
			return;
		}

		lblPopup.setText(res);
		//System.out.println(res);
	}	
	protected void btnPopupConfirmActionPerformed(ActionEvent e) {
		int res = JOptionPane.showConfirmDialog(this, "잠온다", "졸음체크", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
		System.out.println(res);
		if(res == JOptionPane.YES_OPTION) {
			lblPopup.setText("예");
			//System.out.println("확인");
		}
		if(res == JOptionPane.NO_OPTION) {
			lblPopup.setText("아니오");
			//System.out.println("아니오");
		}
		if(res == JOptionPane.CANCEL_OPTION) {
			lblPopup.setText("취소");
			//System.out.println("취소");
		}
		if(res == JOptionPane.CLOSED_OPTION) {
			System.out.println("닫기");
		}
		
	}
	protected void btnPopupMsgActionPerformed(ActionEvent e) {
		ImageIcon icon = new ImageIcon(System.getProperty("user.dir")+"\\images\\" + "icon1.png");
		JOptionPane.showMessageDialog(null, "열심히", "자바 프로젝트", JOptionPane.ERROR_MESSAGE, icon);
	}
	protected void btnFileSaveActionPerformed(ActionEvent e) {
		int res = chooser.showSaveDialog(this);
		if(res != JFileChooser.APPROVE_OPTION) {//열기 버튼을 눌렀다면
			JOptionPane.showMessageDialog(this, "파일을 선택하지 않았습니다.", "경고" ,JOptionPane.WARNING_MESSAGE);
			return;
		}
		String filePath = chooser.getSelectedFile().getPath();//파일 하나만 선택했을 때
		//저장 누르면 이 filePath 경로가 받아져옴 -> 여기에 파일 입출력 writer를 써서 해당 경로에다 write 하면 저장됨
		//System.out.println(filePath);
		
	}
	protected void btnFileOpenActionPerformed(ActionEvent e) {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG", "jpg", "gif", "png"); //extension 확장자
		chooser.setFileFilter(filter);
		int res = chooser.showOpenDialog(this); //this or null
		if(res != JFileChooser.APPROVE_OPTION) {//열기 버튼을 눌렀다면
			JOptionPane.showMessageDialog(this, "파일을 선택하지 않았습니다.", "경고" ,JOptionPane.WARNING_MESSAGE);
			return;
		}
		String filePath = chooser.getSelectedFile().getPath();//파일 하나만 선택했을 때
		lblImg.setIcon(new ImageIcon(filePath));
		
	}
	protected void btnColorActionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("Color")) {
			Color selectedColor = JColorChooser.showDialog(null, "Color", Color.YELLOW);
		}
			if(selectedColor != null) {
				lblColor.setForeground(selectedColor);
			}
		}
	}

