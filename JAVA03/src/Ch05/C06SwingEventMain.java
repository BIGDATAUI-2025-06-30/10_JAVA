package Ch05;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class GUI extends JFrame implements ActionListener{
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	public GUI(String title) {
		//Frame기본설정
		super(title);
		setBounds(100,100,400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Pannel 설정
		JPanel panel  = new JPanel();
		panel.setLayout(null);
		
		//
		btn1 = new JButton("파일로저장");
		btn1.setBounds(270,10,110,30);
		btn2 = new JButton("1:1요청");
		btn2.setBounds(270,50,110,30);
		btn3 = new JButton("대화기록보기");
		btn3.setBounds(270,90,110,30);
		btn4 = new JButton("입력");
		btn4.setBounds(270,300,110,30);
		
		// Event 처리
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);	
		
		//
		JTextArea area = new JTextArea();
		JScrollPane scroll = new JScrollPane(area);
		scroll.setBounds(10,10,250,280);
		//
		JTextField txt1 = new JTextField();
		txt1.setBounds(10,300,250,30);
		
		//Panel에 Component추가
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(scroll);
		panel.add(txt1);
		
		//Frame에 Panel추가
		add(panel);
		
		//Frame표시여부
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println(btn1);
//		System.out.println("BTN 클릭!! " + e.getSource());
		if(e.getSource()==btn1) {
			System.out.println("파일로 저장 버튼 클릭!");
		}else if(e.getSource()==btn2) {
			System.out.println("1:1 요청 버튼 클릭");
		}else if(e.getSource()==btn3) {
			System.out.println("대화기록보기 버튼 클릭");
		}else if(e.getSource()==btn4) {
			System.out.println("입력 버튼 클릭");
		}
		
		
	}
	
}

public class C06SwingEventMain {

	
	public static void main(String[] args) {
		new GUI("Chatting");
	}
}
