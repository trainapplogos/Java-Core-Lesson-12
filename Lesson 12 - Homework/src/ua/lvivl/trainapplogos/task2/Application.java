/* Task from Lesson 08
 ** 
 */

package ua.lvivl.trainapplogos.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String month_str;	
		
		while (true) {
			System.out.println("\n> Enter month: ");
				
			month_str = sc.next().toUpperCase();
					
			ArrayList<Months> months = new ArrayList<Months>();
			Collections.addAll(months, Months.values());
			
			ArrayList<Seasons> seasons = new ArrayList<Seasons>();
			Collections.addAll(seasons, Seasons.values());
				
			Months month = monthExists(month_str);
			
			if (month != null) {
				//#1
				System.out.println("> #1: The month " + month_str + " is exists"); 
				
				//#2
				System.out.println("> #2: All months with the same season:");
				ArrayList<Months> samemonths = getMonthsBySeason(months, month.getSeason().name()); 
				
				//#3
				System.out.println("> #3: All months with the same amount of days:");
				ArrayList<Months> samedays = getMonthsByDays(months, month.getDays());
				
				//#4
				System.out.println("> #4: All months with less amount of days:");
				ArrayList<Months> lessdays = getMonthsWithLessDays(months, month.getDays());
				
				//#5
				System.out.println("> #5: All months with more amount of days:");
				ArrayList<Months> moredays = getMonthsWithMoreDays(months, month.getDays());
				
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
				ArrayList<Months> odddays = getMonthsWithOddDays(months);
				
				//#9
				System.out.println("> #9: All months with even amount of days:");
				ArrayList<Months> evendays = getMonthsWithEvenDays(months);
				
				//#10
				
				if (month.getDays() % 2 == 0) {
					System.out.println("> #10: The month " + month_str + " has odd amount of days");
				} else {
					System.out.println("> #10: The month " + month_str + " hasn't odd amount of days");
				}
				
				System.out.println("______________________________________________________________\n");
			
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
	
	
	//#2
	public static ArrayList<Months> getMonthsBySeason(ArrayList<Months> months, String season) {
		ArrayList <Months> months_res = new ArrayList<>();
		
		for (Months month : months) {
			if (month.getSeason().name() == season) {
				months_res.add(month);
				System.out.println("   -" + month.name());
			}
		}
		return months_res;
	}
	
	//#3
	public static ArrayList<Months> getMonthsByDays(ArrayList<Months> months, int days) {
		ArrayList <Months> months_res = new ArrayList<>();
		
		for (Months month : months) {
			if (month.getDays() == days) {
				months_res.add(month);
				System.out.println("   -" + month.name());
			}
		}
		return months_res;
	}
	
	//#4
	public static ArrayList<Months> getMonthsWithLessDays(ArrayList<Months> months, int days) {
		ArrayList <Months> months_res = new ArrayList<>();
		
		for (Months month : months) {
			if (month.getDays() < days) {
				months_res.add(month);
				System.out.println("   -" + month.name());
			}
		}
		return months_res;
	}
	
	//#5
	public static ArrayList<Months> getMonthsWithMoreDays(ArrayList<Months> months, int days) {
		ArrayList <Months> months_res = new ArrayList<>();
		
		for (Months month : months) {
			if (month.getDays() > days) {
				months_res.add(month);
				System.out.println("   -" + month.name());
			}
		}
		return months_res;
	}
	
	//#6
	public static ArrayList<Months> getMonthsWithOddDays(ArrayList<Months> months) {
		ArrayList <Months> months_res = new ArrayList<>();
		
		for (Months month : months) {
			if (month.getDays() % 2 == 0) {
				months_res.add(month);
				System.out.println("   -" + month.name());
			}
		}
		return months_res;
	}
	
	//#7
	public static ArrayList<Months> getMonthsWithEvenDays(ArrayList<Months> months) {
		ArrayList <Months> months_res = new ArrayList<>();
		
		for (Months month : months) {
			if (month.getDays() % 2 != 0) {
				months_res.add(month);
				System.out.println("   -" + month.name());
			}
		}
		return months_res;
	}
	
}
