
public class InvestmentProblem {

	public static void main(String[] args) {

		int balance = 10000;
		int startBalance = 10000;
		int count = 0;
		
		
		while(balance < 2*startBalance) {
			balance+=(int) (balance * 0.10);
			//System.out.println(balance);
			count++;
		}
		
		System.out.println("Wir brauchen " + count + " Jahre.");

	}

}
