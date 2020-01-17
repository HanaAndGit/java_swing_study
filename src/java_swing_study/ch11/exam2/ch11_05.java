package java_swing_study.ch11.exam2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ch11_05 extends JFrame implements ChangeListener {

	private JPanel contentPane;
	private JSlider slider;
	private JLabel lbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ch11_05 frame = new ch11_05();
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
	public ch11_05() {
		initialize();
	}
	private void initialize() {
		setTitle("JSlider Practice Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(50, 50, 50, 50));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 0, 0, 0));
		
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMinorTickSpacing(10);
		slider.setMinimum(100);
		slider.setMajorTickSpacing(20);
		slider.setMaximum(200);
		contentPane.add(slider);
		
		lbl = new JLabel("");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbl);

		slider.addChangeListener(this);
	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == slider) {
			sliderStateChanged(e);
		}
	}
	protected void sliderStateChanged(ChangeEvent e) {
		int value = slider.getValue();
		lbl.setText(value+"");
	}
}
