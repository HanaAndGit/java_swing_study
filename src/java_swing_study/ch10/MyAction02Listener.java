package java_swing_study.ch10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MyAction02Listener implements ActionListener {
	//EventListenerEx
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = null;
		//가져온 이벤트 정보가 JButton 과 같다면
		if(e.getSource() instanceof JButton) {
			btn = (JButton) e.getSource();
		}
		
		//버튼에 있는 텍스트를 가져와서 메세지로 띄우기
		JOptionPane.showMessageDialog(null, btn.getText());

	}

}
