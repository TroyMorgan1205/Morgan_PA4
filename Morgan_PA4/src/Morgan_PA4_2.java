import java.io.*;
import java.util.*;

public class Morgan_PA4_2 {

	public class DuplicateCounter 
	{
		  
		private Integer wordCounter;
		private Map<String, Integer> map;
		  
		public DuplicateCounter()
		{
			this.wordCounter = 0;
			this.map = new HashMap<>();
		}
		  
		public void count(String dataFile)
		{
		
			try
			{
				Scanner fRead = new Scanner(new File(dataFile));
				while(fRead.hasNextLine())
				{
					String line = fRead.nextLine().trim();
					String[] data = line.split("[\\W]+");
					for(String word : data)
					{
						this.wordCounter = map.get(word);
						this.wordCounter = (this.wordCounter == null) ? 1 : ++this.wordCounter;
						map.put(word, this.wordCounter);
					}
				}
				fRead.close();
			}
			catch(FileNotFoundException excpt)
			{
				System.out.println("File " + dataFile + " cant be found");
				return;
			}
			}
		  
		public void write(String outputFile)
		{
			FileWriter fwrite;
			PrintWriter pwrite;
			try 
			{
				fwrite = new FileWriter(new File(outputFile));
				pwrite = new PrintWriter(fwrite);
				for(Map.Entry<String, Integer> entry : map.entrySet())
				{
					pwrite.write(entry.getKey() + " happens " + entry.getValue() + " many times" + System.lineSeparator());
				}
				System.out.println("Map is written to the file: " + outputFile);
				pwrite.flush();
				fwrite.close();
				pwrite.close();
		} 
			catch (IOException excpt) 
			{
				System.out.println("Error, cant write to " + outputFile + ": " + excpt.getMessage());
				return;
			}
		}
	}
	public class Application 
	{
		  
		private static final String Input = "problem2.txt";
		private static final String Output = "unique_word_counts.txt";
		  
		public void main(String[] args) 
		{
			// TODO Auto-generated method stub
			DuplicateCounter duplicateCounter = new DuplicateCounter();
			duplicateCounter.count(Input);
			duplicateCounter.write(Output);

		}

	}
}
