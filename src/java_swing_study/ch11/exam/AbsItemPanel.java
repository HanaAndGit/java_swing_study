package java_swing_study.ch11.exam;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class AbsItemPanel<T> extends JPanel {
	//JPanel 자리에는 JPanel만 들어갈 수 있기 때문에 Interface는 들어갈 수 없다. 
	
	public abstract void clearTf();
	
	public abstract void setItem(T item);
	
	public abstract T getItem();
	
	
	
	
	
	
	
	
	
	
	
	
	

}
