package test;

import test.Human;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human human = new Human();
		human.eat();
		human.talk();
		human.walk();
		human.solveProblem();
		
		String s = "HELLO    THERE";
		if (s.contains(" ")) {
			System.out.print("YES");
		}
	}

}
