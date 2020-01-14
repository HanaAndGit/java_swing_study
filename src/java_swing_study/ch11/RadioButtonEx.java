package java_swing_study.ch11;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class RadioButtonEx extends JFrame implements ItemListener {

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
		rdbtnApple.addItemListener(this);
		buttonGroup.add(rdbtnApple);
		pRdbBtns.add(rdbtnApple);
		
		rdbtnPear = new JRadioButton("배");
		rdbtnPear.addItemListener(this);
		buttonGroup.add(rdbtnPear);
		pRdbBtns.add(rdbtnPear);
		
		rdbtnCherry = new JRadioButton("체리");
		rdbtnCherry.addItemListener(this);
		buttonGroup.add(rdbtnCherry);
		pRdbBtns.add(rdbtnCherry);
		
		pLblImg = new JPanel();
		pLblImg.setBorder(new EmptyBorder(10, 10, 10, 10));
		pLeft.add(pLblImg, BorderLayout.CENTER);
		pLblImg.setLayout(new BorderLayout(0, 0));
		
		lblImg = new JLabel("");
		pLblImg.add(lblImg, BorderLayout.CENTER);
		
		pRight = new JPanel();
		contentPane.add(pRight);
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
			JOptionPane.showMessageDialog(null, ((JRadioButton) e.getItem()).getText());
		}
	}
	protected void rdbtnPearItemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			JOptionPane.showMessageDialog(null, ((JRadioButton) e.getItem()).getText());
		}
	}
	protected void rdbtnCherryItemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			JOptionPane.showMessageDialog(null, ((JRadioButton) e.getItem()).getText());
		}
	}
}
