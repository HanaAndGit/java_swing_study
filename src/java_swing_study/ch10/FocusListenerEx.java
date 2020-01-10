package java_swing_study.ch10;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FocusListenerEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfNo;
	private JTextField tfDept;
	private JTextField tfSubj;
	private JLabel lblRes;
	private JPasswordField pw1;
	private JPasswordField pw2;
	private JLabel lblConfirm;
	private JButton btnOK;
	private JButton btnCancel;
	private JButton btnSet;

	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 */
	public FocusListenerEx() {

		initialize();
	}
	private void initialize() {
		setTitle("그리드 레이아웃 샘플");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(549, 299);
		setLocation(100, 100);
		//setBounds(100, 100, 340, 300); // setSize + setLocation 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 20, 5));
		
		JButton btnName = new JButton("이름");
		//버튼의 포커스 삭제하기 -> 자동으로 이름 버튼 옆에 input 에 포커스 
		btnName.setFocusable(false);
		btnName.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(btnName);
		
		tfName = new JTextField();
		tfName.getDocument().addDocumentListener(new DocumentListener() {
			
			
			//text필드의 글자가 제거되거나, 추가되거나 변경되면 각각 호출
			@Override
			public void removeUpdate(DocumentEvent e) {
				//name의 길이가 들어와서 string 으로 바꿔줌
				//실시간으로 입력한 내용, 길이 출력
				msg();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				msg();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				msg();
				
			}
			
			public void msg() {
				lblRes.setText(String.format("removeUpdate() %s 길이 : %d",tfName.getText() ,tfName.getText().length()));
			}
		});
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JButton lblNo = new JButton("학번");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNo);
		
		tfNo = new JTextField();
		tfNo.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			//포커스를 받았을 때
			@Override
			public void focusGained(FocusEvent e) {
				if(tfName.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "이름을 입력하세요.");
				}
			}
		});
		tfNo.setColumns(10);
		contentPane.add(tfNo);
		
		JButton lblDept = new JButton("학과");
		lblDept.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblDept);
		
		tfDept = new JTextField();
		tfDept.setColumns(10);
		contentPane.add(tfDept);
		
		JButton lblSubj = new JButton("과목");
		lblSubj.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblSubj);
		
		tfSubj = new JTextField();
		//tfSubj.setFocusable(true);
		//tfSubj.requestFocus();
		tfSubj.setColumns(10);
		contentPane.add(tfSubj);
		
		tfName.setRequestFocusEnabled(true);
		
		lblRes = new JLabel("이름 글자 수");
		lblRes.setBackground(UIManager.getColor("Button.light"));
		lblRes.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblRes);
		
		//pw1 과 pw2 를 비교해서 같으면 t 다르면 f 
		//pw 는 getText() 로 가져올 수 없음 
		lblConfirm = new JLabel("");
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setFont(new Font("굴림", Font.BOLD, 15));
		lblConfirm.setForeground(new Color(139, 0, 0));
		contentPane.add(lblConfirm);
		
		pw1 = new JPasswordField();
		pw1.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				isEqualPw();
				
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				isEqualPw();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				isEqualPw();
				
			}

			private void isEqualPw() {
				String pass1 = new String(pw1.getPassword());
				String pass2 = new String(pw2.getPassword());
				
				if(pass1.equals(pass2)) {
					lblConfirm.setText("일치");
				}else {
					lblConfirm.setText("불일치");
				}
				
			}
		});
		contentPane.add(pw1);
		
		pw2 = new JPasswordField();
		pw2.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				isEqualPw();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				isEqualPw();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				isEqualPw();
				
			}

			private void isEqualPw() {
				//pw1.getPassword(); //char[] 배열로 패스워드 한 글자씩 가져옴
				//String 으로 바꿈 
				String pass1 = new String(pw1.getPassword());
				String pass2 = new String(pw2.getPassword());
				
				System.out.printf("pw1 : %s pw2 : %s %n", pass1, pass2);
				
				if(pass1.equals(pass2)) {
					lblConfirm.setText("일치");
				}else {
					lblConfirm.setText("일치하지 않음");
				}
				
			}
		});
		contentPane.add(pw2);
		
		btnOK = new JButton("확인");
		btnOK.addActionListener(this);
		contentPane.add(btnOK);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		contentPane.add(btnCancel);
		
		btnSet = new JButton("Set");
		btnSet.addActionListener(this);
		contentPane.add(btnSet);
	}
	
	
	
	public JTextField getTfSubj() {
		return tfName;
	}


	public static void main(String[] args) {
		FocusListenerEx frame = new FocusListenerEx();
		frame.setVisible(true);
		
		frame.getTfSubj().requestFocus();
		 
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSet) {
			btnSetActionPerformed(e);
		}
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnOK) {
			btnOKActionPerformed(e);
		}
	}
	
	protected void btnOKActionPerformed(ActionEvent e) {
		Students std = getStudent();
		JOptionPane.showMessageDialog(null, std);
		
	}

	public Students getStudent() {
		Students std = new Students(tfName.getText(), Integer.parseInt(tfNo.getText()), tfSubj.getText(), tfDept.getText());
		return std;
	}
	
	
	protected void btnCancelActionPerformed(ActionEvent e) {
		tfName.setText("");
		tfNo.setText("");
		tfSubj.setText("");
		tfDept.setText("");
	}
	protected void btnSetActionPerformed(ActionEvent e) {
		
	}
}
