import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		int arraylength = 142;
		ArrayList<HashMapSkeleton<String, Integer>> nameList = new ArrayList<HashMapSkeleton<String, Integer>>();
		ArrayList<Integer> totalFreq = new ArrayList<Integer>();
		Scanner file=null;
		for(int i = 0; i<142; i++) {
			try {
				int fileNum = 1880 +i;
				file = new Scanner(new File("yob"+fileNum+".txt"));
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
			nameList.add(new HashMapSkeleton<String, Integer>());
			int sum =0;
			while (file.hasNext()) {
				String namekey = file.next();
				
				String[] vals = namekey.split(",", 3);
				String name = vals[0];
				Integer frequency = Integer.parseInt(vals[2]);
				sum += (Integer.parseInt(vals[2]));
				if(nameList.get(i).get(name) == null){
					nameList.get(i).put(name, frequency);
				}
				else {
					Integer temp  = (Integer) nameList.get(i).get(name);
					nameList.get(i).put(name, temp+ frequency);
				}
			}
			totalFreq.add(sum);
		}
		Scanner myScan =new Scanner(System.in);
		System.out.println("ENter name");
		String name = myScan.nextLine();
		barGraph myGraph = new barGraph(nameList,name , totalFreq);
		System.out.println("enter year");
		String year = myScan.nextLine();
		System.out.print("how much names");
		String num = myScan.nextLine();
		myGraph.PopularNames(nameList, Integer.parseInt(year), Integer.parseInt(num));

	}


}
