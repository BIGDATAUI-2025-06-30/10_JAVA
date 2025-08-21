package Ch07.사조;

import java.lang.reflect.Array;
import java.nio.file.FileSystemLoopException;
import java.util.ArrayList;

import java.util.List;

public class Sum implements Ch07.사조.Calculation{

	@Override
	public void Run(int n1, int n2) {
		System.out.println("사조 정재민 덧셈결과 : " + n1 + n2);
	}
	@Override
	public void Run(int n1, int n2, int n3, int n4, int n5) {
		System.out.println("사조 정재민 덧셈결과 : " + n1 + n2 + n3 + n4 + n5);
	}
	@Override
	public void Run(double d1, double d2, double d3, double d4) {
		System.out.println("사조 정재민 덧셈결과 : " + d1 + d2 + d3 + d4);
	}
	@Override
	public void Run(String... n) {
		String all=null;
		for(int i=0;i<n.length*2;i++) {
			if(i%2==0) {
				all.concat(n[i]);}
			else if(i%2==1){
				all.concat("+");
			}
		}
	}
}
