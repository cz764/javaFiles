
public class raiseIntToPower {

	public static void main(String[] args) {
		System.out.println(raiseIntToPower(2,5));

	}

	public static int raiseIntToPower(int n, int k){
		int result = 1;
		
		for (int i = 1; i <= k; i++)
			result *= n;
		
		return result;
	}
}
