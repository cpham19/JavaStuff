package test;

import test.AnimalAbs;
import test.MathSolver;

public class Human implements AnimalAbs, MathSolver {
	public Human() {
		
	}

	@Override
	public void solveProblem() {
		System.out.println("HUMAN THINKS AND SOLVES PROBLEM");
	}
	
	@Override
	public void eat() {
		System.out.println("HUMAN EATS");
	}
	
	@Override
	public void talk() {
		System.out.println("HUMAN TALKS!");
	}
	
	@Override
	public void walk() {
		System.out.println("HUMAN WALKS!");
	}
}
