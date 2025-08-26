package Ch05;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class C04GUI extends JFrame
{
	C04GUI(String title){
		//Frame Setting
		super(title);
		setBounds(100,100,500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Panel Setting
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		//Component Setting
		JButton btn1 = new JButton("BTN01");
		btn1.setBounds(10,10,100,30);
		
		//Panel에 Component 추가
		panel.add(btn1);
		
		//Frame에 Panel 추가
		add(panel);	 
		
		
		//Frame 표시 여부
		setVisible(true);
	}
}

public class C04SwingMain {

	public static void main(String[] args) {
		 new C04GUI("네번째 프레임 창입니다.-!");
	}

}
