package java_swing_study.ch10;

public class Students {
	private String name;
	private int sno;
	private String subj;
	private String dept;
	
	
	
	
	public Students() {
		// TODO Auto-generated constructor stub
	}





	public Students(String name, int no, String subj, String dept) {
		this.name = name;
		this.sno = no;
		this.subj = subj;
		this.dept = dept;
	}
	
	
	


	public String getName() {
		return name;
	}





	public int getSno() {
		return sno;
	}





	public String getSubj() {
		return subj;
	}





	public String getDept() {
		return dept;
	}





	@Override
	public String toString() {
		return String.format("Students [이름=%s, 학번=%s, 과목=%s, 학과=%s]", name, sno, subj, dept);
	}
	
	
	
}
