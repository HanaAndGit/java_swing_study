package java_swing_study.ch11.exam2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;

public class ch11_01 extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btn;
	private JCheckBox ch01;
	private JCheckBox ch02;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ch11_01 frame = new ch11_01();
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
	public ch11_01() {
		initialize();
	}
	private void initialize() {
		setTitle("CheckBox Practice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 303, 198);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 0, 0, 0));
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 0, 0, 0));
		contentPane.add(panel);
		
		ch01 = new JCheckBox("버튼 비활성화");
		ch01.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					btn.setEnabled(false);
				}else {
					btn.setEnabled(true);
				}
				
				
			}
		});
		panel.add(ch01);
		
		ch02 = new JCheckBox("버튼 감추기");
		ch02.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					btn.setVisible(false);
				}else {
					btn.setVisible(true);
				}
				
			}
		});
		panel.add(ch02);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(10, 0, 0, 0));
		contentPane.add(panel_1);
		
		btn = new JButton("test button");
		panel_1.add(btn);
	}

}
