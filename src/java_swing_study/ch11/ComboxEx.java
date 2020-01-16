package java_swing_study.ch11;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ComboxEx extends JFrame implements PropertyChangeListener, ActionListener {

	private JPanel contentPane;
	private JPanel pLeft;
	private JPanel pRight;
	private JComboBox<String> cmbFruit;
	private DefaultComboBoxModel<String> model;
	private JTextField tfFruits;
	private JLabel lblText;
	private JButton btnOk;

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
		pLeft.setLayout(new GridLayout(4, 1, 0, 0));

		cmbFruit = new JComboBox<>();
		
	
		cmbFruit.setMaximumRowCount(5);
		
	
		pLeft.add(cmbFruit);
		
		tfFruits = new JTextField();
		
	
		pLeft.add(tfFruits);
		tfFruits.setColumns(10);

		pRight = new JPanel();
		pRight.setBorder(
				new TitledBorder(null, "\uC608\uC81C 11-13", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRight);
		
		//cmbFruits에 제네릭 추가 후 콤보박스모델에서 setmodel(model)로 변경
		
		
		//cmbFruit.setModel(model);
		cmbFruit.setModel(getModel());
		cmbFruit.setSelectedIndex(0);
		
		lblText = new JLabel("");
		lblText.setHorizontalAlignment(SwingConstants.CENTER);
		pLeft.add(lblText);
		
		btnOk = new JButton("확인");
		btnOk.addActionListener(this);
		pLeft.add(btnOk);
		
		//리스너는 initialize 가장 마지막에 실행되도록 하기
		//리스너가 수행되면서 필요한 라벨이나 textfield가 코드 순서 상 생성되기 전에 리스너가 수행되면 nullpointer exception 
		cmbFruit.addActionListener(this);
		cmbFruit.addPropertyChangeListener(this);
		tfFruits.addActionListener(this);
		tfFruits.addPropertyChangeListener(this);
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
		if (evt.getSource() == cmbFruit) {
			cmbFruitPropertyChange(evt);
		}
		if (evt.getSource() == tfFruits) {
			textFieldPropertyChange(evt);
		}
	}
	protected void textFieldPropertyChange(PropertyChangeEvent evt) {
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			btnOkActionPerformed(e);
		}
		if (e.getSource() == cmbFruit) {
			cmbFruitActionPerformed(e);
		}
		if (e.getSource() == tfFruits) {
			tfFruitsActionPerformed(e);
		}
	}
	protected void tfFruitsActionPerformed(ActionEvent e) {
		model.addElement(tfFruits.getText());
		tfFruits.setText("");
	}
	protected void cmbFruitPropertyChange(PropertyChangeEvent evt) {
		
		
		
	}
	protected void cmbFruitActionPerformed(ActionEvent e) {
		JComboBox<String> cb = (JComboBox<String>) e.getSource();
		String str= (String) cb.getSelectedItem();
		//System.out.println(str);
		lblText.setText(str);
	}
	protected void btnOkActionPerformed(ActionEvent e) {
		//JComboBox<String> cb = (JComboBox<String>) e.getSource();
		//String str = (String) cb.getSelectedItem();
		JOptionPane.showMessageDialog(null, "선택한 과일은 " + (String)cmbFruit.getSelectedItem());
	}
}
