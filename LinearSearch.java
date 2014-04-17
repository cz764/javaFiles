// LinearSearch.java: Search for a number in a list
import javax.swing.JOptionPane;

public class LinearSearch 
{
	/** Main method */
	public static void main(String[] args) 
	{
//		int[] list = new int[10];

		Integer[] list = new Integer[10];
		
		// Declare and initialized output string
		String output = "";

		// Create the list randomly and display it
		output += "The list is\n";
		for (int i =0; i < list.length; i++) 
		{
			list[i] = (int)(Math.random() * 100);
			output += list[i] + "    ";
		}

		// Display the list
		JOptionPane.showMessageDialog(null, output, 
			"Example 5.10 (list)", JOptionPane.INFORMATION_MESSAGE);
		
		// Prompt the user to enter a key
		String keyString = JOptionPane.showInputDialog(null, 
			"Enter a key:", 
			"Example 5.10 Input", JOptionPane.QUESTION_MESSAGE);

		// Convert string into integer
		int key = Integer.parseInt(keyString);

		// Empty the output string
		output = "";
		
		// Search for key
		int index = linearSearch(key, list);
		if (index != -1)
			output = "The key is found in index " + index;
		else
			output = "The key " + key + " is not found in the list";
		
		// Display the result
		JOptionPane.showMessageDialog(null, output, 
			"Example 5.10 Output", JOptionPane.INFORMATION_MESSAGE);
		
		System.exit(0);		
	}

	/** The method for finding a key in the list */
//	public static int linearSearch(int key, int[] list) 
//	{
//		for (int i = 0; i < list.length; i++)
//			if (key == list[i])
//				return i;
//		return -1;
//	}
//}
	
	public static int linearSearch(Object key, Object[] list) 
	{
		for (int i = 0; i < list.length; i++)
			if (key.equals(list[i]))
				return i;
		return -1;
	}
}
