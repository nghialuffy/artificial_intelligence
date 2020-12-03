package timkiem;

public class State {
	int h;
	int g;
	State cha;
	Operator me;
	int d[][];
	public State(int[][] c) {
		this.d = new int[4][4];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				this.d[i][j] = c[i][j];
			}
		}
	}
	
	
	public State() {
		this.d = new int[4][4];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				d[i][j] = (i*4 + j + 1) % 16;
			}
		}
	}
	
	public void print() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.print(String.format("%2d ", d[i][j]));
			}
			System.out.println("");
		}
		System.out.println("======");
	}
	String getKey() {
		String s = "";
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				s += String.format("%02d", d[i][j]);
			}
		}
//		System.out.println(s);
		return s;
	}
}
