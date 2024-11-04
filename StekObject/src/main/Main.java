package main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrStek stack = new ArrStek();

		stack.push("Hello");
		stack.push("Java");
		stack.push("OOP");
		
		System.out.println(stack);
		for(;stack.peek()!=null;) {
			System.out.println(stack.pop());
		}
	}

}
