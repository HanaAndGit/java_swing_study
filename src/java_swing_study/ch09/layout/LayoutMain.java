package java_swing_study.ch09.layout;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java_swing_study.ch09.layout.exam.No2BorderLayout;
import java_swing_study.ch09.layout.exam.No4BackgroundColor;
import java_swing_study.ch09.layout.exam.No5GridLayout;
import java_swing_study.ch09.layout.exam.No7Calculator;
import java_swing_study.ch09.layout.exam.No8OpenChallenge;

import javax.swing.UIManager;
import java.awt.Color;

@SuppressWarnings("serial")
public class LayoutMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pLeft;
	private JButton btnFlow;
	private JButton btnBorder;
	private JButton btnGrid;
	private JButton btnAbsolute;
	private JButton btnOpenChallenge;
	private JPanel pRight;
	private JButton btnNo2;
	private JButton btnNo4;
	private JButton btnNo5;
	private JButton btnNo7;
	private JButton btnNo8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LayoutMain frame = new LayoutMain();
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
	public LayoutMain() {
		setTitle("배치 레이아웃 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC81C 9\uC7A5 GUI \uAE30\uCD08", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));
		
		pLeft = new JPanel();
		pLeft.setBorder(new TitledBorder(null, "\uB808\uC774\uC544\uC6C3 \uC608\uC81C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLeft);
		pLeft.setLayout(new GridLayout(0, 2, 10, 10));
		
		btnFlow = new JButton("FlowLayout");
		btnFlow.addActionListener(this);
		pLeft.add(btnFlow);
		
		btnBorder = new JButton("border layout");
		pLeft.add(btnBorder);
		
		btnGrid = new JButton("GridLayout");
		pLeft.add(btnGrid);
		
		btnAbsolute = new JButton("AbsoluteLayout");
		btnAbsolute.addActionListener(this);
		pLeft.add(btnAbsolute);
		
		btnOpenChallenge = new JButton("Open Challenge");
		pLeft.add(btnOpenChallenge);
		
		pRight = new JPanel();
		pRight.setBorder(new TitledBorder(null, "\uC2E4\uC2B5\uBB38\uC81C \uD480\uC774", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRight);
		pRight.setLayout(new GridLayout(0, 2, 10, 10));
		
		btnNo2 = new JButton("No2");
		btnNo2.addActionListener(this);
		pRight.add(btnNo2);
		
		btnNo4 = new JButton("No4");
		btnNo4.addActionListener(this);
		pRight.add(btnNo4);
		
		btnNo5 = new JButton("No5");
		btnNo5.addActionListener(this);
		pRight.add(btnNo5);
		
		btnNo7 = new JButton("No7");
		btnNo7.addActionListener(this);
		pRight.add(btnNo7);
		
		btnNo8 = new JButton("No8");
		btnNo8.addActionListener(this);
		btnNo8.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//어떤 버튼 (1: 왼쪽 버튼 , 2 : 휠 클릭 3: 오른쪽 버튼) + 몇 번 클릭 
				System.out.println(e.getButton() + " : " + e.getClickCount());
			}
			
		});
		pRight.add(btnNo8);
	}

	public void actionPerformed(ActionEvent e) {
		//JOptionPane.showMessageDialog(null, e.getSource());
		//System.out.println(e.getSource());
		
		//클릭한 버튼 이름 출력
		System.out.println(e.getActionCommand());
		if (e.getSource() == btnAbsolute) {
			btnAbsoluteActionPerformed(e);
		}
		if (e.getSource() == btnNo8) {
			btnNo8ActionPerformed(e);
		}
		if (e.getSource() == btnNo7) {
			btnNo7ActionPerformed(e);
		}
		if (e.getSource() == btnNo5) {
			btnNo5ActionPerformed(e);
		}
		if (e.getSource() == btnNo4) {
			btnNo4ActionPerformed(e);
		}
		if (e.getSource() == btnNo2) {
			btnNo2ActionPerformed(e);
		}
		if (e.getSource() == btnFlow) {
			btnFlowActionPerformed(e);
		}
	}
	protected void btnFlowActionPerformed(ActionEvent e) {
		FlowLayoutEx frame = new FlowLayoutEx();
		frame.setVisible(true);
	}
	protected void btnNo2ActionPerformed(ActionEvent e) {
		No2BorderLayout frame = new No2BorderLayout();
		frame.setVisible(true);
	}
	protected void btnNo4ActionPerformed(ActionEvent e) {
		No4BackgroundColor frame = new No4BackgroundColor();
		frame.setVisible(true);
	}
	protected void btnNo5ActionPerformed(ActionEvent e) {
		No5GridLayout frame = new No5GridLayout();
		frame.setVisible(true);
	}
	protected void btnNo7ActionPerformed(ActionEvent e) {
		No7Calculator frame = new No7Calculator();
		frame.setVisible(true);
	}
	protected void btnNo8ActionPerformed(ActionEvent e) {
		No8OpenChallenge frame = new No8OpenChallenge();
		frame.setVisible(true);
	}
	protected void btnAbsoluteActionPerformed(ActionEvent e) {
		AbsoluteLayoutEx frame = new AbsoluteLayoutEx();
		frame.setVisible(true);
	}
}
