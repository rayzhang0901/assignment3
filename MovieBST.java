import java.util.Scanner;
import java.io.*;

public class MovieBST {

	private Movie root;	
	public List sortList() {
		List subList = new List();
		makeSortList(root, subList);	
		return subList;
	}

	public void makeSortList(Movie root, List sub)
	{
		if(root != null) {
			makeSortList(root.left, sub);
			sub.insertLast(root);
			makeSortList(root.right, sub);
		}	
	}
	
	public void sort() {
		sortPrint(root);
	}
	
	public void sortPrint(Movie root) {
		if(root != null) {
			sortPrint(root.left);
			System.out.println(root.title);
			sortPrint(root.right);
		}
	}
	
	public void insert(String title, String year) {
		root = insertImplem(root, title, year);
	}
	
	public Movie insertImplem(Movie root, String title, String year) {
		if(root == null) {
			root = new Movie(title, year);
			return root;
		}
		
		if(root.title.compareTo(title) > 0)
			root.left = insertImplem(root.left, title, year);
		else if(root.title.compareTo(title) < 0)
			root.right = insertImplem(root.right, title, year);
		return root;
	}
	
	public List subList(String begin, String end) {
		List subList = new List();
		subListBuild(root, begin, end, subList);
		return subList;
	}
	
	public void subListBuild(Movie root, String begin, String end, List sub) {
		if(root != null) {
			subListBuild(root.left, begin, end, sub);
			if(root.title.compareToIgnoreCase(end) <= 0 && 
					root.title.compareToIgnoreCase(begin) >= 0)
						sub.insertLast(root);
			subListBuild(root.right, begin, end, sub);
		}
	}

	MovieBST() {
		root = null;
	}

	MovieBST(int numLines) throws IOException {
		int row = 1000, col = 2, counter = 0;
		String[][] arr = new String[row][col];
		for(int i = 0; i < 1000; i++)
			for(int j = 0; j < 2; j++)
				arr[i][j] = " ";
		
		File myFile = new File("movies.csv");
		Scanner sc = new Scanner(myFile,"UTF-8");
		String temp = "";
		temp = sc.nextLine();
		while(counter < 1000) {
			temp = sc.nextLine();
			int x = temp.indexOf(',');
			int z = temp.lastIndexOf(')');
			int y = temp.lastIndexOf('(', z - 1);
			if(temp.charAt(x + 1) == '"')
				arr[counter][0] = temp.substring(x + 2, y);
			else
				arr[counter][0] = temp.substring(x + 1, y);
			arr[counter][1] = temp.substring(y + 1, z);
			counter++;
		}
		sc.close();
		
		for(int i = 0; i < numLines; i++) {
			insert(arr[i][0], arr[i][1]);
		}
		
	}
}

class Movie {
	String title;
	String releaseYear;
	Movie(String s, String y) { title = s; releaseYear = y;
								left = right = null; }
	Movie() { title = ""; releaseYear = ""; left = right = null; }
	Movie left;
	Movie right;
}
