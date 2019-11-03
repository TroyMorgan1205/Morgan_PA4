import java.io.*;
import java.util.*;

//import Morgan_PA4_2.DuplicateCounter;

public class DuplicateRemover {

	private Set<String> uniqueWords;

	   public DuplicateRemover() {

	       uniqueWords = new HashSet<>();
	   }

	   public void remove(String dataFile) {

	       try
	       {
	           Scanner scnr = new Scanner(new File(dataFile));

	           while (scnr.hasNext()) 
	           {

	               uniqueWords.add(scnr.next());
	           }
	           scnr.close();
	       } 
	       catch (FileNotFoundException excpt) 
	       {
	           System.out.println(excpt);
	       }

	   }

	   public void write(String outputFile) {
	       try 
	       {
	           PrintWriter prnt = new PrintWriter(new File(outputFile));

	           for (String string : uniqueWords) 
	           {

	               prnt.println(string);
	           }
	           prnt.flush();
	           prnt.close();
	       } 
	       catch (FileNotFoundException exs) 
	       {
	           System.out.println(exs);
	       }
	   }
	   public class Application {

		public void main(String[] args) {      
			       DuplicateRemover duplicateRemover = new DuplicateRemover();
			      
			       duplicateRemover.remove("C:\\Users\\tbone\\Desktop\\test.txt");
			       duplicateRemover.write("unique_words.txt");
			      
			   }
	}
	}


