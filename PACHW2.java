
import java.util.Scanner;


public class PACHW2 {
	    char op;
	    double ans=0;
	    
	    private void play()
	    {
	    	Scanner sc = new Scanner(System.in);
			System.out.println("Calculator Operating...");
			double a = sc.nextDouble();
			System.out.println("1st input "+ a );
			op = sc.next().charAt(0);
			System.out.println("op "+ op);
			if(op=='x')
			{
				return;
			}
			else if(op=='c')
			{
				a=0;
				System.out.println("ans: "+a);
			}
			double b = sc.nextDouble();
			System.out.println("2nd input "+ b );
			ans = Double.valueOf(PACHW2.Cal(a, b, op));
			while(true)
			{
			op = sc.next().charAt(0);
			System.out.println("op "+ op);
			if(op=='x')
			{
				System.out.println("Exit Calulator");
				return;
			}
			else if(op=='c')
			{
				ans=0;
				System.out.println("ans: "+ans);
				op = sc.next().charAt(0);
				System.out.println("op "+ op);
			}
			double c = sc.nextDouble();
			System.out.println("more input: "+ c);
			String tempAns = PACHW2.Cal(ans, c, op);
//			if(tempAns.equals("Exit Calulator"))
//			{
//				return;
//			}
			ans = Double.valueOf(tempAns);			
			}
	    }
	    
	
	private static String Cal(double answer, double moreInput, char operateor)
	{
		switch (operateor) {
		case '+':
			answer += moreInput;
			System.out.println("ans: " + answer);
			return answer+"";
		case '-':
			answer -= moreInput;
			System.out.println("ans: " + answer);
			return answer+"";
		case '*':
			answer *= moreInput;
			System.out.println("ans: " + answer);
			return answer+"";
		case '/':
			if(moreInput==0)
			{
				System.out.println("Error: Division by zero");
				return answer+"";
			}
			answer /= moreInput;
			System.out.println("ans: " + answer);
			return answer+"";
//		case 'c':
//			answer = 0;
//			System.out.println("ans: " + answer);
//			return answer+"";
//		case 'x':
//			System.out.println("Exit Calulator");
//			return "Exit Calulator";
		default:
			System.out.println("Error: Unknown operator " + operateor);
			return answer+"";
		}		
	}
	
	
    public static void main(String[] args) {
		new PACHW2().play();
	}
	

}
