package java_swing_study.ch11;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ContainerListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ContainerEvent;

public class JComponentEx extends JFrame implements ActionListener, ContainerListener {

	private JPanel contentPane;
	private JPanel pLeft;
	private JPanel pRight;
	private JButton b2;
	private JButton b1;
	private JButton b3;
	private JButton b4;
	private JButton b5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JComponentEx frame = new JComponentEx();
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
	public JComponentEx() {
		initialize();
	}
	private void initialize() {
		setTitle("Jch11 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 0));
		
		pLeft = new JPanel();
		pLeft.setBorder(new TitledBorder(null, "11-1 \uC608\uC81C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLeft);
		
		b1 = new JButton("Magenta/Yellow Button");
		b1.addActionListener(this);
		pLeft.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		b1.setFont(new Font("Arial", Font.PLAIN, 20));
		b1.setForeground(Color.MAGENTA);
		b1.setBackground(Color.YELLOW);
		pLeft.add(b1);
		
		b2 = new JButton("Disabled Button");
		pLeft.add(b2);
		
		b3 = new JButton("getX(), getY()");
		b3.addActionListener(this);
		pLeft.add(b3);
		
		b4 = new JButton("Right Panel Add Btn");
		b4.addActionListener(this);
		pLeft.add(b4);
		
		b5 = new JButton("Right Panel Remove Btn");
		b5.addActionListener(this);
		pLeft.add(b5);
		
		pRight = new JPanel();
		pRight.addContainerListener(this);
		pRight.setBorder(new TitledBorder(null, "JComponent \uBA54\uC11C\uB4DC", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRight);
		pRight.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b5) {
			b5ActionPerformed(e);
		}
		if (e.getSource() == b4) {
			b4ActionPerformed(e);
		}
		if (e.getSource() == b3) {
			b3ActionPerformed(e);
		}
		if (e.getSource() == b1) {
			b1ActionPerformed(e);
		}
	}
	protected void b1ActionPerformed(ActionEvent e) {
		if(b2.isEnabled()) {
			b2.setEnabled(false);
		}else {
			b2.setEnabled(true);
		}
	}
	protected void b3ActionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		JComponentEx frame = (JComponentEx) b.getTopLevelAncestor();
		frame.setTitle(b.getX() + ", " + b.getY());
	}
	protected void b4ActionPerformed(ActionEvent e) {
		JButton b6 = new JButton("button");
		b6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Test");
				frame.addWindowListener(new WindowListener() {

					@Override
					public void windowOpened(WindowEvent e) {
						System.out.printf("%s()%n" , "windowOpened");
						
					}

					@Override
					public void windowClosing(WindowEvent e) {
						System.out.printf("%s()%n" , "windowClosing");
						
					}

					@Override
					public void windowClosed(WindowEvent e) {
						System.out.printf("%s()%n" , "windowClosed");
						
					}

					@Override
					public void windowIconified(WindowEvent e) {
						System.out.printf("%s()%n" , "windowIconified");
						
					}

					@Override
					public void windowDeiconified(WindowEvent e) {
						System.out.printf("%s()%n" , "windowDeiconified");
						
					}

					@Override
					public void windowActivated(WindowEvent e) {
						System.out.printf("%s()%n" , "windowActivated");
						
					}

					@Override
					public void windowDeactivated(WindowEvent e) {
						System.out.printf("%s()%n" , "windowDeactivated");
						
					}
					
				});
				frame.setBounds(500, 500, 450, 300);
				frame.setVisible(true);
				
			}
			
		});
		pRight.add(b6);
		revalidate(); //버튼 추가 후에 재배치 
	}
	protected void b5ActionPerformed(ActionEvent e) {
		for(Component c : pRight.getComponents()) {
			if(c instanceof JButton) {
				pRight.remove(c);
				revalidate();
				repaint();
			}
		}
		
	}
	public void componentAdded(ContainerEvent e) {
		if (e.getSource() == pRight) {
			pRightComponentAdded(e);
		}
	}
	public void componentRemoved(ContainerEvent e) {
		JOptionPane.showMessageDialog(null, "버튼을 삭제했습니다.");
	}
	protected void pRightComponentAdded(ContainerEvent e) {
		JOptionPane.showMessageDialog(null, "버튼을 추가했습니다.");
	}
}
