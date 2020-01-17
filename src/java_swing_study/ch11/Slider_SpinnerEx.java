package java_swing_study.ch11;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class Slider_SpinnerEx extends JFrame implements ChangeListener, ActionListener {

	private JPanel contentPane;
	private JPanel pSlider1;
	private JPanel pSlider2;
	private JPanel pSpinner1;
	private JPanel pSpinner2;
	private JSlider slider1;
	private JLabel lblValue1;
	private JSlider sliderRed;
	private JSlider slider_1Green;
	private JSlider slider_2Blue;
	private JSlider[] sl = new JSlider[3];
	private JLabel lblColorch;
	private JPanel panel;
	private JLabel lblColor1;
	private JTextField tfRed;
	private JLabel lblColor2;
	private JTextField tfGreen;
	private JLabel lblColor3;
	private JTextField tfBlue;
	private JButton btnOk;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JSpinner spList;
	private JLabel lblList;
	private JSpinner spNumber;
	private JLabel lblNumber;
	private JSpinner spDate;
	private JLabel lblDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Slider_SpinnerEx frame = new Slider_SpinnerEx();
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
	public Slider_SpinnerEx() {
	
		initialize();
	}
	private void initialize() {
		setTitle("JSlider와 JSpinner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));
		
		pSlider1 = new JPanel();
		pSlider1.setBorder(new TitledBorder(null, "\uC608\uC81C 11-14", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pSlider1);
		pSlider1.setLayout(new GridLayout(0, 1, 0, 0));
		
		slider1 = new JSlider();
		slider1.setPaintTicks(true);
		slider1.setPaintLabels(true);
		slider1.setMinorTickSpacing(10);
		slider1.setMajorTickSpacing(50);
		slider1.setMaximum(200);
		pSlider1.add(slider1);
		
		lblValue1 = new JLabel("0");
		lblValue1.setFont(new Font("굴림", Font.BOLD, 12));
		lblValue1.setHorizontalAlignment(SwingConstants.CENTER);
		lblValue1.setForeground(new Color(0, 128, 128));
		pSlider1.add(lblValue1);
		
		pSlider2 = new JPanel();
		pSlider2.setBorder(new TitledBorder(null, "\uC608\uC81C 11-15", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pSlider2);
		pSlider2.setLayout(new GridLayout(5, 1, 0, 0));
		
		panel = new JPanel();
		pSlider2.add(panel);
		panel.setLayout(new GridLayout(0, 7, 0, 0));
		
		lblColor1 = new JLabel("R");
		lblColor1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblColor1);
		
		tfRed = new JTextField();
		panel.add(tfRed);
		tfRed.setColumns(10);
		
		lblColor2 = new JLabel("G");
		lblColor2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblColor2);
		
		tfGreen = new JTextField();
		panel.add(tfGreen);
		tfGreen.setColumns(10);
		
		lblColor3 = new JLabel("B");
		lblColor3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblColor3);
		
		tfBlue = new JTextField();
		panel.add(tfBlue);
		tfBlue.setColumns(10);
		
		btnOk = new JButton("확인");
		btnOk.addActionListener(this);
		panel.add(btnOk);
		
		sliderRed = new JSlider();
		sliderRed.setFont(new Font("굴림", Font.BOLD, 12));
		sliderRed.setForeground(new Color(139, 0, 0));
		sliderRed.setMinorTickSpacing(10);
		sliderRed.setMajorTickSpacing(50);
		sliderRed.setPaintTicks(true);
		sliderRed.setPaintLabels(true);
		sliderRed.setMaximum(255);
		pSlider2.add(sliderRed);
		
		slider_1Green = new JSlider();
		slider_1Green.setFont(new Font("굴림", Font.BOLD, 12));
		slider_1Green.setForeground(new Color(60, 179, 113));
		slider_1Green.setPaintLabels(true);
		slider_1Green.setPaintTicks(true);
		slider_1Green.setMinorTickSpacing(10);
		slider_1Green.setMajorTickSpacing(50);
		slider_1Green.setMaximum(255);
		pSlider2.add(slider_1Green);
		
		slider_2Blue = new JSlider();
		slider_2Blue.setForeground(new Color(0, 139, 139));
		slider_2Blue.setFont(new Font("굴림", Font.BOLD, 12));
		slider_2Blue.setPaintTicks(true);
		slider_2Blue.setPaintLabels(true);
		slider_2Blue.setMinorTickSpacing(10);
		slider_2Blue.setMajorTickSpacing(50);
		slider_2Blue.setMaximum(255);
		pSlider2.add(slider_2Blue);
		
		lblColorch = new JLabel("New label");
		lblColorch.setFont(new Font("굴림", Font.BOLD, 12));
		lblColorch.setHorizontalAlignment(SwingConstants.CENTER);
		lblColorch.setBackground(new Color(154, 205, 50));
		lblColorch.setOpaque(true);
		pSlider2.add(lblColorch);
		
		pSpinner1 = new JPanel();
		pSpinner1.setBorder(new TitledBorder(null, "JSpinner \uC608\uC81C1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pSpinner1);
		pSpinner1.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(10, 10, 10, 10));
		pSpinner1.add(panel_1);
		
		spList = new JSpinner();
		spList.addChangeListener(this);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		spList.setModel(new SpinnerListModel(new String[] {"\uC18C\uC124", "\uC7A1\uC9C0", "\uC804\uACF5\uC11C\uC801", "\uCDE8\uBBF8"}));
		panel_1.add(spList);
		
		lblList = new JLabel("");
		lblList.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblList);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(10, 10, 10, 10));
		pSpinner1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		spNumber = new JSpinner();
		spNumber.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spNumber.addChangeListener(this);
		panel_2.add(spNumber);
		
		lblNumber = new JLabel("0");
		lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNumber);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(10, 10, 10, 10));
		pSpinner1.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		spDate = new JSpinner();
		spDate.addChangeListener(this);
		spDate.setModel(new SpinnerDateModel(new Date(1579186800000L), new Date(1579186800000L), new Date(1609340400000L), Calendar.MONTH));
		panel_3.add(spDate);
		
		lblDate = new JLabel("New label");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblDate);
		
		pSpinner2 = new JPanel();
		pSpinner2.setBorder(new TitledBorder(null, "JSpinner \uC608\uC81C2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pSpinner2);
		

		slider1.addChangeListener(this);
		slider1.setValue(100);

		sliderRed.addChangeListener(this);
		sliderRed.setValue(100);

		slider_2Blue.addChangeListener(this);
		slider_2Blue.setValue(100);

		slider_1Green.addChangeListener(this);
		slider_1Green.setValue(100);
	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == spDate) {
			spDateStateChanged(e);
		}
		if (e.getSource() == spNumber) {
			spNumberStateChanged(e);
		}
		if (e.getSource() == spList) {
			spListStateChanged(e);
		}
		if (e.getSource() == sliderRed) {
			sliderRedStateChanged(e);
		}
		if (e.getSource() == slider_2Blue) {
			slider_2BlueStateChanged(e);
		}
		if (e.getSource() == slider_1Green) {
			slider_1GreenStateChanged(e);
		}
		if (e.getSource() == slider1) {
			slider1StateChanged(e);
		}
	}
	protected void slider1StateChanged(ChangeEvent e) {
		lblValue1.setText(slider1.getValue()+"");
		System.out.println("값 : " + slider1.getValue());
		
	}
	protected void slider_1GreenStateChanged(ChangeEvent e) {
		int cl = slider_1Green.getValue();
		lblColorch.setBackground(new Color(0, cl, 0));
		tfGreen.setText(Integer.toString(cl));
	}
	protected void slider_2BlueStateChanged(ChangeEvent e) {
		int cl = slider_2Blue.getValue();
		lblColorch.setBackground(new Color(0, 0, cl));
		tfBlue.setText(Integer.toString(cl));
	}
	protected void sliderRedStateChanged(ChangeEvent e) {
		//System.out.println(sliderRed.getValue());
		int cl = sliderRed.getValue();
		lblColorch.setBackground(new Color(cl, 0, 0));
		tfRed.setText(Integer.toString(cl));
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			btnOkActionPerformed(e);
		}
	}
	protected void btnOkActionPerformed(ActionEvent e) {
		int r = Integer.parseInt(tfRed.getText());
		int g = Integer.parseInt(tfGreen.getText());
		int b = Integer.parseInt(tfBlue.getText());
		
		sliderRed.setValue(r); 
		slider_1Green.setValue(g);
		slider_2Blue.setValue(b);
		
	}
	protected void spListStateChanged(ChangeEvent e) {
		lblList.setText(spList.getValue().toString());
	}
	protected void spNumberStateChanged(ChangeEvent e) {
		
			lblNumber.setText(spNumber.getValue().toString());
	}
	protected void spDateStateChanged(ChangeEvent e) {
		lblDate.setText(spDate.getValue().toString());
	}
}
