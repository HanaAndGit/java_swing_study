package java_swing_study.ch10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		//EventListenerEx 에서 btn01을 클릭하면 발생하는 ActionEvent 를 매개변수로 받아와서 e.getSource(클릭한 버튼의 정보)를 JButton 으로 타입캐스트 한다음 
		//해당 이벤트를 처리할 조건문 / 실행문 작성
		JButton btn = (JButton) e.getSource();
		if(btn.getText().equals("액션")) {
			btn.setText("Action");
		}else {
			btn.setText("액션");
		}

	}

}
