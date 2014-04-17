import javax.swing.JOptionPane;

public class BinarySearch {
	/** Main method */
	public static void main(String[] args) {
		int[] list = new int[10];

		// Declare and initialized output string
		String output = "The list is\n";
		
		// Create a sorted list
		for (int i = 0; i < list.length; i++) {
			list[i] = 2 * i + 1;
			output += list[i] + "	";
		}

		// Display the list
		JOptionPane.showMessageDialog(null, output, 
			"Example 5.11 (list)", JOptionPane.INFORMATION_MESSAGE);

		// Prompt the user to enter a key
		String keyString = JOptionPane.showInputDialog(null, 
			"Enter a key:", 
			"Example 5.11 Input", JOptionPane.QUESTION_MESSAGE);

		// Convert string into integer
		int key = Integer.parseInt(keyString);

		// Empty the output string
		output = "";

		// Search for key
		int index = binarySearch(key, list);
		if (index != -1)
			output += "The key is found in index " + index;
		else
			output += "The key is not found in the list";

		// Display the result
		JOptionPane.showMessageDialog(null, output, 
			"Example 5.11 Output", JOptionPane.INFORMATION_MESSAGE);
		
		System.exit(0);		
	}

	/** Use binary search to find the key in the list */
	public static int binarySearch(int key, int[] list) {
		int low = 0;
		int high = list.length - 1;
		return binarySearch(key, list, low, high);
	}

	/** Use binary search to find the key in the list between
			list[low] list[high] */
	public static int binarySearch(int key, int[] list, 
		int low, int high) {
		if (low > high)	// The list has been exhausted without a match
			return -1;

		int mid = (low + high) / 2;
		if (key < list[mid])
			return binarySearch(key, list, low, mid-1);
		else if (key == list[mid])
			return mid;
		else 
			return binarySearch(key, list, mid+1, high);
	}
}
