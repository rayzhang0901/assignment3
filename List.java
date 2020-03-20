import java.io.*;
import java.io.PrintWriter;

class List {
	public Node first;
	public Node last;
	
	List() { first = null; last = null; }
	
	public void print(String s) throws IOException {
		File myFile = new File(s);
		PrintWriter output = new PrintWriter(myFile);
		Node current = first;
		while(current != null) {
			output.printf("%-5s%-50s%s", current.getYear(), current.getTitle(), 
							"\n");
			current = current.next;
		}
		output.flush();
		output.close();
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		Node curr = first;
		int i = 0;
		while(curr != null) {
			curr = curr.next;
			i++;
		}
		return i;
	}

	public void insertLast(Movie m) {
		Node newNode = new Node(m);
		if(isEmpty()) {
			first = newNode;
		}
		else
			last.next = newNode;
		last = newNode;
	}

	public Node checkMovie() {
		return first;
	}
}

class Node {
	Movie data;
	Node next;
	Node() { data = null; }
	Node(Movie m) { data = m; next = null; }
	public String getTitle() { return data.title; }
	public String getYear() { return data.releaseYear; }
}
