import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;
import edu.du.dudraw.DUDraw;

public class barGraph {
	public barGraph(ArrayList<HashMapSkeleton<String,Integer>> nameList, String name, ArrayList<Integer> totalFreq) {
		DUDraw.setCanvasSize(500, 500);
		DUDraw.setXscale(0,141);

		double maxFreq = 0;
		int maxYear = 0;
		int firstYear = 0;
		for(int i =0; i<nameList.size(); i++) {
			Integer val =	nameList.get(i).get(name);
			if(val != null) {
				if(firstYear == 0) {
					firstYear = 1880+i;
				}
				double height = (double)val/ totalFreq.get(i);
				if(height > maxFreq) {
					maxFreq = height;
					maxYear = 1880+ i;
				}
			}
		}
		DUDraw.setYscale(0, maxFreq*10);
		for(int i =0; i<nameList.size(); i++) {
			Integer val =	nameList.get(i).get(name);
			if(val != null) {
			double height = (double)val/ totalFreq.get(i);
			DUDraw.filledRectangle(i, 0, 0.5, height *10);
			}
			DUDraw.filledRectangle(i, 0, 0.5, 0);
		}
		DUDraw.setPenColor(DUDraw.RED);

		DUDraw.text(75,maxFreq*9.5, "First year" + firstYear);
		DUDraw.text(75,maxFreq*9, "Max Frequency" + String.format("%.2f", maxFreq*100)+ "in "+ maxYear);
		DUDraw.show();
	}

	public void PopularNames(ArrayList<HashMapSkeleton<String,Integer>> nameList, int year, int number){
		int index = year - 1880;
		HashMapSkeleton<String, Integer>  specYear = nameList.get(index);
		Iterable<Entry<String, Integer>> mySet = specYear.entrySet();
		ArrayList<Entry<String, Integer>> sortableEntry = new ArrayList<Entry<String, Integer>>();
		for(Entry<String, Integer> e: mySet) {
			sortableEntry.add(e);
		}
		Collections.sort(sortableEntry,(a,b)-> b.getValue().compareTo(a.getValue()));
		for(int i=0; i< number; i++) {
			System.out.println(sortableEntry.get(i));
		}
		//		Iterable<Integer> sortablenums = specYear.values();
		//		ArrayList<Integer> printNums = new ArrayList<Integer>();
		//		for(Integer i: sortablenums) {
		//			printNums.add(i);
		//		}
		//		Iterable<String> sortableList = specYear.keySet();
		//		ArrayList<String> printNames = new ArrayList<String>();
		//		for(String s: sortableList) {
		//			printNames.add(s);
		//		}
		//		Collections.sort(printNums);
		//		Collections.reverse(printNums);
		//		Collections.sort(printNames);
		//		Collections.reverse(printNames);
		//		
		//		for(int i =0; i<10; i++) {
		//			System.out.print(printNames.get(i) + " " + printNums.get(i));
		//		}

	}
}
