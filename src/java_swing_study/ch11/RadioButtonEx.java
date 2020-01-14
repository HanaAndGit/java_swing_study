package java_swing_study.ch11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class RadioButtonEx extends JFrame implements ItemListener, ActionListener {

	private JPanel contentPane;
	private JPanel pLeft;
	private JPanel pRight;
	private JPanel pRdbBtns;
	private JPanel pLblImg;
	private JRadioButton rdbtnApple;
	private JRadioButton rdbtnPear;
	private JRadioButton rdbtnCherry;
	private JLabel lblImg;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private HashMap<String, ImageIcon> icons;
	private JButton btnApple;
	private JButton btnPear;
	private JButton btnCherry;
	private JButton btnConfirm;
	private JRadioButton[] jrb = new JRadioButton[3]; 
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadioButtonEx frame = new RadioButtonEx();
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
	public RadioButtonEx() {
		//initialize에 리스너가 나오기 전에 icons가 추가 되어 있어야함 
		icons = new HashMap<String, ImageIcon>();
		String imgDirPath = System.getProperty("user.dir") + "\\images\\";
		icons.put("사과", new ImageIcon(imgDirPath + "apple.jpg"));
		icons.put("배", new ImageIcon(imgDirPath + "pear.jpg"));
		icons.put("체리", new ImageIcon(imgDirPath + "cherry.jpg"));
		initialize();
	}
	private void initialize() {
		setTitle("라디오 버튼 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "라디오 버튼 예제", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));
		
		pLeft = new JPanel();
		contentPane.add(pLeft);
		pLeft.setLayout(new BorderLayout(0, 0));
		
		pRdbBtns = new JPanel();
		pLeft.add(pRdbBtns, BorderLayout.NORTH);
		
		rdbtnApple = new JRadioButton("사과");
		buttonGroup.add(rdbtnApple);
		pRdbBtns.add(rdbtnApple);
		jrb[0] = rdbtnApple;
		
		rdbtnPear = new JRadioButton("배");
		buttonGroup.add(rdbtnPear);
		pRdbBtns.add(rdbtnPear);
		jrb[1] = rdbtnPear;
		
		rdbtnCherry = new JRadioButton("체리");
		buttonGroup.add(rdbtnCherry);
		pRdbBtns.add(rdbtnCherry);
		jrb[2] = rdbtnCherry;
		
		pLblImg = new JPanel();
		pLblImg.setBorder(new EmptyBorder(10, 10, 10, 10));
		pLeft.add(pLblImg, BorderLayout.CENTER);
		pLblImg.setLayout(new BorderLayout(0, 0));
		
		lblImg = new JLabel("");
		pLblImg.add(lblImg, BorderLayout.CENTER);
		
		pRight = new JPanel();
		contentPane.add(pRight);
		pRight.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnApple = new JButton("사과 선택");
		btnApple.addActionListener(this);
		pRight.add(btnApple);
		
		btnPear = new JButton("배 선택");
		btnPear.addActionListener(this);
		pRight.add(btnPear);
		
		btnCherry = new JButton("체리 선택");
		btnCherry.addActionListener(this);
		pRight.add(btnCherry);
		
		btnConfirm = new JButton("선택한 과일 확인");
		btnConfirm.addActionListener(this);
		pRight.add(btnConfirm);
		
		textField = new JTextField();
		textField.setEditable(false);
		pRight.add(textField);
		textField.setColumns(10);
		

		rdbtnApple.addItemListener(this);
		rdbtnPear.addItemListener(this);
		rdbtnCherry.addItemListener(this);
		rdbtnApple.setSelected(true);

	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == rdbtnCherry) {
			rdbtnCherryItemStateChanged(e);
		}
		if (e.getSource() == rdbtnPear) {
			rdbtnPearItemStateChanged(e);
		}
		if (e.getSource() == rdbtnApple) {
			rdbtnAppleItemStateChanged(e);
		}
	}
	protected void rdbtnAppleItemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			//JOptionPane.showMessageDialog(null, rdbtnApple.getText());
			lblImg.setIcon(icons.get(rdbtnApple.getText()));
		}
	}
	protected void rdbtnPearItemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			//JOptionPane.showMessageDialog(null, ((JRadioButton) e.getItem()).getText());
			lblImg.setIcon(icons.get(rdbtnPear.getText()));
		}
	}
	protected void rdbtnCherryItemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			//JOptionPane.showMessageDialog(null, ((JRadioButton) e.getItem()).getText());
			lblImg.setIcon(icons.get(rdbtnCherry.getText()));
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPear) {
			btnPearActionPerformed(e);
		}
		if (e.getSource() == btnConfirm) {
			btnConfirmActionPerformed(e);
		}
		if (e.getSource() == btnApple) {
			btnAppleActionPerformed(e);
		}
		if (e.getSource() == btnCherry) {
			btnCherryActionPerformed(e);
		}
	}
	
	protected void btnAppleActionPerformed(ActionEvent e) {
		//System.out.println("apple");
		rdbtnApple.setSelected(true);
		
	}
	protected void btnPearActionPerformed(ActionEvent e) {
		//System.out.println("pear");
		rdbtnPear.setSelected(true);
	}
	protected void btnCherryActionPerformed(ActionEvent e) {
		//System.out.println("cherry");
		rdbtnCherry.setSelected(true);
	}
	protected void btnConfirmActionPerformed(ActionEvent e) {
		//System.out.println("confirm");
		String chkfr = "";
		for(JRadioButton jbt : jrb) {
			if(jbt instanceof JRadioButton) {
				if(jbt.isSelected()) {
					chkfr = jbt.getText();
				}
			}
		}
		JOptionPane.showMessageDialog(null, "선택한 과일은 " + chkfr);
	}
	
}
