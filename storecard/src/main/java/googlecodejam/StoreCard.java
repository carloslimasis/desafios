package googlecodejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class StoreCard {

	public static void main(String[] args) throws Exception {
		final FileReader reader = new FileReader(new File("src/main/resources/example.in"));
		final BufferedReader br = new BufferedReader(reader);
		
		int credit = 0;
		int counter = 0;
		int products = 0;
		
		String[] prices = null;
		
		String line = br.readLine();
		
		int numberCase = 1;
		
		while(line != null){
			if(credit == 0 && counter != 0){
				credit = Integer.parseInt(line);
			}else if(products == 0 && counter != 0){
				products = Integer.parseInt(line);
			}else if(prices == null && counter != 0){
				prices = line.split(" ");
				boolean casoResolvido = false;
				Integer[] precosToInt = new Integer[prices.length];
				for (int i = 0; i < prices.length; i++) {
					precosToInt[i] = Integer.parseInt(prices[i]);
				}
				
				for (int i = 0; i < precosToInt.length; i++) {
					if(casoResolvido){
						break;
					}
					Integer precoI = precosToInt[i];
					for (int j = 0; j < precosToInt.length; j++) {
						Integer precoJ = precosToInt[j];
						
						if((i != j) && (precoI + precoJ == credit)){
							System.out.println("Case #" + numberCase + ": " + (i+1) + " " + (j+1));
							numberCase++;
							casoResolvido = true;
							credit = 0;
							products = 0;
							prices = null;
							break;
						}
					}
				}
			}
			
			line = br.readLine();
			counter++;
		}
		
		br.close();
	}

}
