/* Task from Lesson 11
 ** 
 */

package ua.lviv.trainapplogos.task1;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import ua.lviv.trainapplogos.task1.ver2.Car;

public class Application {
	public static void main(String[] args) {
		ArrayList<Integer> arrInt = new ArrayList<Integer>();
		Random r = new Random();
		
		for (int i = 0; i < 10; i++) {
			arrInt.add(r.nextInt(100));
		}
	
		System.out.println("[*** Task1: ***]");
		System.out.println("> Unsorted ArrayList:");
		System.out.println("  " + arrInt);
		
		System.out.println("> ArrayList sorted in ascending order:");
	
		Collections.sort(arrInt);
		System.out.println("  " + arrInt);
		
		System.out.println("> ArrayList sorted in descending order:");
		Collections.sort(arrInt, Collections.reverseOrder()); //using Comparator: Collections.reverseOrder() 
		
		System.out.println("  " + arrInt);

		//#2: Task2
		System.out.println("\n[*** Task2: ***]");
		
		int arrbound1 = r.nextInt(50);
		int arrbound2 = r.nextInt(50);
		//ArrayList <Car> [] arrcars = new ArrayList[arrbound1];
		
		ArrayList<ArrayList> arrcars = new ArrayList<ArrayList>();
		
		//Fill ArrayList of ArrayList by random values (in some range)
		for (int i = 0; i < arrbound1; i++) {
			ArrayList<Car> car = new ArrayList<Car>();
			arrcars.add(car);
			
			for (int j = 0; j < arrbound2; j++) {
				car.add(new Car(getRandomValueOfRange(70, 350), getRandomValueOfRange(1930, 2020)));
			}
		}
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n----------------------------[Menu]----------------------------");
			System.out.println("> Choose action:");
			System.out.println("  [1]: Output all elements");
			System.out.println("  [2]: Autofull array with identical object Car");
			System.out.println("--------------------------------------------------------------");
			
			String menuitem = sc.next();
			
			if (menuitem.equals("1")) {
				System.out.println("> Output ArrayList [" + arrbound1 + "][" + arrbound2 + "]:");
				System.out.println(arrcars);
			} else if (menuitem.equals("2")) {
				// Fill first element of ArrayList of ArrayList (first ArrayList's ArrayList)
				Collections.fill(arrcars.get(0), new Car(230, 2020));
				Collections.fill(arrcars, arrcars.get(0));
				System.out.println(arrcars);
		
			} else {
				System.out.println("Press 1 or 2 to choose menu item");
			}
		}
	}
	
	public static int getRandomValueOfRange (int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("min value must be smaller than max value");
		}
		
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}
}
