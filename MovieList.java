import java.io.*;

public class MovieList {
	public static void main(String[] args) throws IOException {
		//call the MovieBST and pass in 1000
		//make 3 new list
		MovieBST Tree = new MovieBST(1000);
		List MovieList1 = new List();
		List MovieList2 = new List();
		List MovieList3 = new List();
		
		//Call the sublist method
		MovieList1 = Tree.subList("Bug's Life", "Harry Potter");
		MovieList2 = Tree.subList("Back to the Future", "Hulk");
		MovieList3 = Tree.subList("Toy Story", "WALL-E");
			
		//output into three different output files
		MovieList1.print("output1.txt");
		MovieList2.print("output2.txt");
		MovieList3.print("output3.txt");
	}
}
