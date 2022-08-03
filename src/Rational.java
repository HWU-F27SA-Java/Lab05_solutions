import java.util.Random;
import java.util.Scanner;

public class Rational {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("How many Fractions you want to work with? ");
		int number = input.nextInt();
		if (number < 2) {
			System.out.println("You need at least two Fractions");
			input.close();
			return;
		}
		if (number == 2) {
			input.nextLine();
			System.out.print("What is the operation you want to apply (+, -, *, /)? ");
			String s = input.nextLine();
			char operation = s.charAt(0);
			// create two random Fractions
			Fraction f1 = randomFraction(10, 10);// random
			Fraction f2 = randomFraction(10, 10);// random
			Fraction res = null;
			switch (operation) {
			case '+':// addition
			{
				res = f1.add(f2);

			}
				break;
			case '-':// subtraction
			{
				res = f1.sub(f2);

			}
				break;
			case '*':// multiplication
			{
				res = f1.mul(f2);
			}
				break;
			case '/':// division
			{
				res = f1.div(f2);

			}
				break;
			default:
				System.out.println("Invalid operator!");
			}
			display(f1, operation, f2, res);
			display(f1.simplify(), operation, f2.simplify(), (res==null?res:res.simplify()));
		} else {
			// sum multiple random Fractions
			Fraction res = new Fraction(); // initialize result to be (0/1)
			for (int i = 0; i < number; i++) {
				Fraction f = randomFraction(10, 10).simplify();
				res = res.add(f);
				System.out.print(f);
				if (i < number - 1) {
					System.out.print("+");
				}
			}
			System.out.print(" = " + res.simplify());
		}
		input.close();

	}

	public static Fraction randomFraction(int numMax, int denMax) {
		Random r = new Random();
		int p = r.nextInt(numMax);
		int q = 2 + r.nextInt(denMax);
		return new Fraction(p, q);
	}

	public static void display(Fraction f1, Character op, Fraction f2, Fraction res) {
		System.out.println(f1 + op.toString() + f2 + " = " + (res==null?"Infinity":res));
	}

}
