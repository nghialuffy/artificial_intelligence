package timkiem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Search {
	public static void main(String[] args) {
		State Start, Goal;
		State O = null;
		List<State> Open = new ArrayList<>();
		List<State> Closed = new ArrayList<>();
		
		Start = new State();
		Goal = new State();
		
		Random rand = new Random();
		for (int i = 0; i < 1000; i++) {
			Operator op = new Operator(rand.nextInt(4));
			State n = op.Move(Start);
			if(n!=null) Start = n;
		}
		Goal.print();
		Start.print();
		
//		1
		Open.add(Start);
		
//		2-6
		while(Open.size()!=0) {
//			3
			O = Open.remove(0);
			Closed.add(O);
			
			//O.print();
//			4
			if(BangNhau(O,Goal)) break;
//			5
			for(int i = 0; i < 4; i++) {
				Operator op = new Operator(i);
				State Child = op.Move(O);
				if(Child == null) continue;
				if(Thuoc(Open, Child)) continue;
				if(Thuoc(Closed, Child)) continue;
				Child.cha = O;
				Child.me = op;
				Open.add(Child);
			}
			
		}
		if(BangNhau(O, Goal)) {
			System.out.println("Tim kiem thanh cong");
			PrintToTien(O);
		}
		else 
			System.out.println("Tim kiem that bai");
		
	}

	private static void PrintToTien(State o) {
		if (o.cha != null) {
			PrintToTien(o.cha);
			System.out.println(o.me.i);
		}
		o.print();
	}

	private static boolean Thuoc(List<State> open, State child) {
//		for (State s : open) {
//			if(BangNhau(s, child))
//				return true;
//		}
//		return false;
		if(open.contains(child))
			return true;
		else
			return false;
	}

	private static boolean BangNhau(State o, State goal) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if (o.d[i][j] != goal.d[i][j])
					return false;
			}
		}
		return true;
	}
}
