package java_swing_study.ch11;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ComboxEx extends JFrame implements PropertyChangeListener, ActionListener {

	private JPanel contentPane;
	private JPanel pLeft;
	private JPanel pRight;
	private JComboBox<String> cmbFruit;
	private JComboBox cmbName;
	private DefaultComboBoxModel<String> model;
	private JTextField tfFruits;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboxEx frame = new ComboxEx();
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
	public ComboxEx() {
		initialize();
	}

	private void initialize() {
		setTitle("JCombobox 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		pLeft = new JPanel();
		pLeft.setBorder(
				new TitledBorder(null, "\uC608\uC81C11-12", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLeft);
		pLeft.setLayout(new GridLayout(3, 3, 0, 0));

		cmbFruit = new JComboBox<>();
		cmbFruit.setMaximumRowCount(5);
	
		pLeft.add(cmbFruit);
		
		tfFruits = new JTextField();
		tfFruits.addActionListener(this);
		tfFruits.addPropertyChangeListener(this);
		pLeft.add(tfFruits);
		tfFruits.setColumns(10);

		cmbName = new JComboBox();
		pLeft.add(cmbName);

		pRight = new JPanel();
		pRight.setBorder(
				new TitledBorder(null, "\uC608\uC81C 11-13", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRight);
		
		//cmbFruits에 제네릭 추가 후 콤보박스모델에서 setmodel(model)로 변경
		
		
		//cmbFruit.setModel(model);
		cmbFruit.setModel(getModel());
		cmbFruit.setSelectedIndex(-1);
	}

	private ComboBoxModel<String> getModel() {
		
		model = new DefaultComboBoxModel<String>();
		
		String[] fs = new String[] { "apple", "banana", "kiwi","mango", "pear", "peach", "berry", "strawberry", "blackberry" };
		//List<String> fruits = new ArrayList<>(); //ArrayList의 부모는 List 
		for(String f : fs) {
			model.addElement(f);
		}
		return model;
	}

	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getSource() == tfFruits) {
			textFieldPropertyChange(evt);
		}
	}
	protected void textFieldPropertyChange(PropertyChangeEvent evt) {
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tfFruits) {
			tfFruitsActionPerformed(e);
		}
	}
	protected void tfFruitsActionPerformed(ActionEvent e) {
		model.addElement(tfFruits.getText());
		tfFruits.setText("");
	}
}
