package ua.lvivl.trainapplogos.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String month_str;	
		
		while (true) {
			System.out.println("\n> Enter month: ");
			month_str = sc.next().toUpperCase();

			List<Seasons> seasons = new ArrayList<Seasons>();
			Collections.addAll(seasons, Seasons.values());
			
			Months month = monthExists(month_str);
			
			if (month != null) {
				//#1
				System.out.println("> #1: The month " + month_str + " is exists"); 
				
				//#2
				System.out.println("> #2: All months with the same season:");
				ArrayList<Months> samemonths = returnMonths(2, month.getSeason().name());
				
				//#3
				System.out.println("> #3: All months with the same amount of days:");
				ArrayList<Months> samedays = returnMonths(3, month.getDays());
				
				//#4
				System.out.println("> #4: All months with less amount of days:");
				ArrayList<Months> lessdays =  returnMonths(4, month.getDays());
						
				//#5
				System.out.println("> #5: All months with more amount of days:");
				ArrayList<Months> moredays = returnMonths(5, month.getDays());
						
				//#6
				int nextSeasonInd = month.getSeason().ordinal() + 1;
				if (nextSeasonInd == 4)	nextSeasonInd = 0;
					
				System.out.println("> #6: The next season is " + seasons.get(nextSeasonInd).name());
				
				//#7
				int previousSeasonInd = month.getSeason().ordinal() - 1;
				if (previousSeasonInd == -1) previousSeasonInd = 3;
					
				System.out.println("> #7: The previous season is " + seasons.get(previousSeasonInd).name());
				
				//#8
				System.out.println("> #8: All months with odd amount of days:");
				ArrayList<Months> odddays = returnMonths(8, month.getDays());
						
				//#9
				System.out.println("> #9: All months with even amount of days:");
				ArrayList<Months> evendays = returnMonths(9, month.getDays());
						
				//#10
				
				if (month.getDays() % 2 == 0) {
					System.out.println("> #10: The month " + month_str + " has odd amount of days");
				} else {
					System.out.println("> #10: The month " + month_str + " hasn't odd amount of days");
				}
				
				System.out.println("___________________________________________________________________\n");
			
			} else {
				System.out.println("> #1: Month doesn't exist");
			}
			
		}
	}
	
	//#1
	public static Months monthExists(String month_str) {
		List<Months> months = new ArrayList<Months>();
		Collections.addAll(months, Months.values());
		
		for (Months month : months) {
			if (month.name().equalsIgnoreCase(month_str)) {
				return month;
			} 
		}
		return null;
	}
	
	public static ArrayList<Months> returnMonths (int func, Object param) {
		ArrayList <Months> months_res = new ArrayList<>();
		
		List<Months> months = new ArrayList<Months>();
		Collections.addAll(months, Months.values());
		
		boolean flag = false;
		
		for (Months month : months) {
			//func is equal number of task
			switch  (func) {
			case 2:
				if (month.getSeason().name() == (String)param) flag = true;
				break;
			case 3:
				if (month.getDays() == (int)param) flag = true;
				break;
			case 4:
				if (month.getDays() < (int)param) flag = true;
				break;
			case 5:
				if (month.getDays() > (int)param) flag = true;
				break;
			case 8:
				if (month.getDays() % 2 == 0) flag = true;
				break;
			case 9:
				if (month.getDays() % 2 != 0) flag = true;
				break;
			}
			
			/*Forming resulting list and output it*/
			if (flag) {
				months_res.add(month);
				flag = false;
				System.out.println("   -" + month.name());
			}
		}
		return months_res;
	}
	
}