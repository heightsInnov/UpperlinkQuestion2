/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upperlinkquestion2;

/**
 *
 * @author aojinadu
 */
import java.util.Arrays;
import java.util.HashSet;

public class UpperlinkQuestion2 {

	/**
	 * @param args the command line arguments
	 */
	// TODO code application logic here
	public static int smallestInt(int[] a, int k) {

		int missing = 0;
		int[] values = Arrays.copyOf(a, k);
		Arrays.sort(values);
		int counter = 0;
		for (int i = k; i < a.length; i++) {
			if (a[i] < values[counter]) { // Found small value
				// Insert sorted
				for (int j = k - 1; j >= 0; j--) {
					if (j == 0 || a[i] > values[j - 1]) { // Insert pos
						// Move greater ones up.
						for (int m = k - 1; m > j; m--) {
							values[m] = values[m - 1];
						}
						values[j] = a[i]; // Store
						break; // Done
					}
				}
			}
		}
		return missing;
	}

	public static int returnSmall(int[] a, int k) {
		int small = 0;
		HashSet<Integer> hashSet = new HashSet<Integer>();
		int smallInt = 1;

		for (int i = 0; i < a.length; i++) {
			hashSet.add(a[i]);
		}

		while (hashSet.contains(smallInt)) {
			smallInt++;
		}

		return smallInt;
	}
	
	public static void main(String[] args) {
		UpperlinkQuestion2 q2 = new UpperlinkQuestion2();
		
		//q2.returnSmall(a, 0);
	}
}