package eu.ase.fi_lambda;

@FunctionalInterface
interface MathOperation {
	int operation(int a,int b);
}

@FunctionalInterface
interface GreetingService {
	void sayMessage(String message);
}

class MathOperationImpl {
	public int operate(int a, int b, MathOperation mathOp) {
		return mathOp.operation(a, b);
	}
}

public class Java8TestFiLambda {	
	public static void main(String[] args) {
		MathOperationImpl test = new MathOperationImpl();
		
		MathOperation addition = (int a, int b) -> a + b;
		MathOperation substraction = (a, b) -> a - b;
		MathOperation multiplication = (int a, int b) -> {
			return a * b;
		};
		MathOperation division = (a, b) -> a / b;
		
		int res = test.operate(10, 5, addition);
		System.out.println("10 + 5 = " + res);	
		System.out.println("10 - 5 = " + test.operate(10, 5, substraction));
		System.out.println("10 * 5 = " + test.operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + test.operate(10, 5, division));
		
		System.out.println();
		
		GreetingService gs1 = (String message) -> System.out.println("Hello " + message);
		GreetingService gs2 = message -> System.out.println("Bonjour " + message);
		GreetingService gs3 = (message) -> {
			System.out.println("Salut " + message);
			return; //merge si fara
		};
		gs1.sayMessage("John");
		gs2.sayMessage("Jean Yves-Saint-Laurent");
		gs3.sayMessage("Jenel");
		
	}

}
