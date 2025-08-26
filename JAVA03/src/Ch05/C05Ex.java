//package Ch05;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//
//class GUI extends JFrame{
//	
//	public GUI(String title) {
//		//Frame기본설정
//		super(title);
//		setBounds(100,100,400,400);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		//Pannel 설정
//		JPanel panel  = new JPanel();
//		panel.setLayout(null);
//		
//		//
//		JButton btn1 = new JButton("파일로저장");
//		btn1.setBounds(270,10,110,30);
//		JButton btn2 = new JButton("1:1요청");
//		btn2.setBounds(270,50,110,30);
//		JButton btn3 = new JButton("대화기록보기");
//		btn3.setBounds(270,90,110,30);
//		JButton btn4 = new JButton("입력");
//		btn4.setBounds(270,300,110,30);
//		//
//		JTextArea area = new JTextArea();
//		JScrollPane scroll = new JScrollPane(area);
//		scroll.setBounds(10,10,250,280);
//		//
//		JTextField txt1 = new JTextField();
//		txt1.setBounds(10,300,250,30);
//		
//		//Panel에 Component추가
//		panel.add(btn1);
//		panel.add(btn2);
//		panel.add(btn3);
//		panel.add(btn4);
//		panel.add(scroll);
//		panel.add(txt1);
//		
//		//Frame에 Panel추가
//		add(panel);
//		
//		//Frame표시여부
//		setVisible(true);
//	}
//	
//}
//
//public class C05Ex {
//
//	
//	public static void main(String[] args) {
//		new GUI("Chatting");
//	}
//}
