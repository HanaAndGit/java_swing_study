package java_swing_study.ch11;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class ListEx extends JFrame implements ListSelectionListener, ActionListener {

	private JPanel contentPane;
	private ArrayList<String> listFruits;
	private JPanel p1;
	private JList<String> strlist;
	private JPanel pBtns1;
	private JButton btnOk;
	private JButton btnSet;
	private ImageIcon [] images = { new ImageIcon("images/icon1.png"), 
							 	 	new ImageIcon("images/icon2.png"),
							 	 	new ImageIcon("images/icon3.png"),
							 	 	new ImageIcon("images/icon4.png")};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListEx frame = new ListEx();
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
	public ListEx() {
		
		
		
		
		loadListData();
		initialize();
	}

	private void loadListData() {
		listFruits = new ArrayList<String>();
		listFruits.add("apple");
		listFruits.add("banana");
		listFruits.add("kiwi");
		listFruits.add("mango");
		listFruits.add("pear");
		listFruits.add("peach");
		listFruits.add("berry");
		
	}
	private void initialize() {
		setTitle("JList & JComboBox");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 4, 10, 10));
		
		p1 = new JPanel();
		contentPane.add(p1);
		p1.setLayout(new BorderLayout(0, 0));
		
		strlist = new JList(new Vector<String>(listFruits));
		strlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		strlist.addListSelectionListener(this);
		p1.add(strlist, BorderLayout.CENTER);
		
		pBtns1 = new JPanel();
		p1.add(pBtns1, BorderLayout.NORTH);
		pBtns1.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnOk = new JButton("확인");
		btnOk.addActionListener(this);
		pBtns1.add(btnOk);
		
		btnSet = new JButton("선택하기");
		btnSet.addActionListener(this);
		pBtns1.add(btnSet);
		
		p2 = new JPanel();
		contentPane.add(p2);
		p2.setLayout(new BorderLayout(0, 0));
		
		p2_1 = new JPanel();
		p2.add(p2_1, BorderLayout.NORTH);
		p2_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnOk2 = new JButton("확인");
		btnOk2.addActionListener(this);
		p2_1.add(btnOk2);
		
		btnSet2 = new JButton("선택하기");
		p2_1.add(btnSet2);
		
		p2_2 = new JPanel();
		p2.add(p2_2, BorderLayout.CENTER);
		p2_2.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		p2_2.add(scrollPane, BorderLayout.NORTH);
		
		imgList = new JList(images);
		imgList.addListSelectionListener(this);
		p2_2.add(imgList, BorderLayout.CENTER);
	}

	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == imgList) {
			imgListValueChanged(e);
		}
		if (e.getSource() == strlist) {
			strlistValueChanged(e);
		}
	}
	int idx;
	private JPanel p2;
	private JPanel p2_1;
	private JButton btnOk2;
	private JButton btnSet2;
	private JPanel p2_2;
	private JScrollPane scrollPane;
	private JList imgList;
	protected void strlistValueChanged(ListSelectionEvent e) {
		System.out.println("aaaaa"+e.getLastIndex());
		idx = e.getLastIndex();
	}
	
	
	protected void imgListValueChanged(ListSelectionEvent e) {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk2) {
			btnOk2ActionPerformed(e);
		}
		if (e.getSource() == btnSet) {
			btnSetActionPerformed(e);
		}
		if (e.getSource() == btnOk) {
			btnOkActionPerformed(e);
		}
	}
	protected void btnOkActionPerformed(ActionEvent e) {
		int[] selIndexs = strlist.getSelectedIndices();
		for(int idx : selIndexs) {
			System.out.println(idx);
		}
		JOptionPane.showMessageDialog(null, "선택한 과일은 " + listFruits.get(idx));
	}
	protected void btnSetActionPerformed(ActionEvent e) {
		strlist.setSelectedIndex(listFruits.indexOf("peach"));
	}
	protected void btnOk2ActionPerformed(ActionEvent e) {
		//ImageIcon icon = ListImg.get(imgList.getSelectedIndex());
		//String fullName = icon.getDescription();
		//JOptionPane.showMessageDialog(null, fullName.substring(fullName.indexOf("\\")+1));
		ImageIcon icon = (ImageIcon) imgList.getSelectedValue();
		String fullName = icon.getDescription();
		JOptionPane.showMessageDialog(null, fullName.substring(fullName.lastIndexOf("\\")+1));
	}
	
}
