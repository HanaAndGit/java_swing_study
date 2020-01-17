package java_swing_study.ch11.exam2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ch11_07 extends JFrame implements ChangeListener {

	private JPanel contentPane;
	private JSlider slider;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ch11_07 frame = new ch11_07();
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
	public ch11_07() {
		initialize();
	}
	private void initialize() {
		setTitle("JSlider Practice Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		slider = new JSlider();
		slider.setMinorTickSpacing(5);
		slider.setMajorTickSpacing(20);
		slider.setMinimum(1);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		contentPane.add(slider, BorderLayout.NORTH);
		
		lblNewLabel = new JLabel("I LOVE JAVA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);

		slider.addChangeListener(this);
	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == slider) {
			sliderStateChanged(e);
		}
	}
	protected void sliderStateChanged(ChangeEvent e) {
		int value = slider.getValue();
		lblNewLabel.setFont(new Font("Gulim", Font.BOLD, value));
	}
}
