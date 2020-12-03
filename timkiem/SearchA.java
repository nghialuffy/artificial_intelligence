package timkiem;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

public class SearchA {
	public static void main(String[] args) {
		State Start, Goal;
		State O = null;
//		List<State> Open = new ArrayList<>();
		// Cap phat vung nho.
		PriorityQueue<State> Open = new PriorityQueue<>(100000000, new Comparator<State>() {
			@Override
			public int compare(State o1, State o2) {
				return (o1.g+o1.h) - (o2.g+o2.h);
			}
		});
//		List<State> Closed = new ArrayList<>();
		Map<String, State> Closed = new HashMap<>();
		Start = new State();
		Goal = new State();
		
		Start.g = 0;
		Start.h = Distance(Start, Goal);
		Goal.print();
		
		Random rand = new Random();
		for (int i = 0; i < 1000; i++) {
			Operator op = new Operator(rand.nextInt(4));
			State n = op.Move(Start);
			if(n!=null) Start = n;
		}
		
		Start.print();
		
//		1
		Open.add(Start);
		Closed.put(Start.getKey(), Start);
//		2-6
		int count = 0;
		while(Open.size()!=0) {
//			3
			count++;
			O = Open.remove();
			Closed.put(O.getKey(),O);
			
			//O.print();
//			4
			if(BangNhau(O,Goal)) break;
//			5
			for(int i = 0; i < 4; i++) {
				Operator op = new Operator(i);
				State Child = op.Move(O);
				if(Child == null) continue;
				
				if(Thuoc(Closed, Child)) continue;
				Child.cha = O;
				Child.me = op;
				//				
				Child.g = O.g + 1;
				Child.h = Distance(Child, Goal);
				//
				Open.add(Child);
				
				
				Closed.put(Child.getKey(), Child);
			}
			
		}
		System.out.println(count);
		if(BangNhau(O, Goal)) {
			System.out.println("Tim kiem thanh cong");
			PrintToTien(O);
		}
		else 
			System.out.println("Tim kiem that bai");
		
	}

	private static int Distance(State x, State goal) {
		int dis = 0;
		for(int i=0; i<4; i++) {
			for(int j = 0; j< 4; j++) {
				if(x.d[i][j]!=0) {
					int i1 = (x.d[i][j] - 1)/4;
					int j1 = (x.d[i][j] - 1)%4;
					dis += Math.abs(i-i1) + Math.abs(j-j1);
				}
			}
		}
		return dis;
	}

	private static void PrintToTien(State o) {
		
		if (o.cha != null) {
			PrintToTien(o.cha);
			System.out.println(o.me.i);
		}
		o.print();
	}

	private static boolean Thuoc(Map<String, State> open, State child) {
		
		return open.get(child.getKey()) != null;
//		if(open.contains(child))
//			return true;
//		else
//			return false;
	}

	private static boolean BangNhau(State o, State goal) {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if (o.d[i][j] != goal.d[i][j])
					return false;
			}
		}
		return true;
	}
}
