package umwandlerroem;

import java.util.Scanner;

public class Umwandler12 {

	public static void main(String[] args) {
		
		String roem [][] = {{"","I","II","III","IV","V","VI","VII","VIII","IX"}, 
							{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
							{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
							{"","M","MM","MMM","MMMM"}};
				
		System.out.println("Zahl eingeben:");
		Scanner eing = new Scanner(System.in);
		int azahl = eing.nextInt();
		int durch = 1000;
		int stellenwert = 0;
		int zehnerpotenz = 3;
		String ergebnis = "";
		
		while (azahl>4999) {
			System.out.println("Die Zahl muss kleiner 4000 sein\nZahl erneut eingeben");
			azahl = eing.nextInt();
		}
			for (int i=0;i<4;i++) {
				stellenwert = azahl/durch;
			
				while (azahl>=durch) {
					azahl-=durch;			// azahl auf nächsten stellenwert kürzen
				}
				if (azahl<durch) {
					durch/=10;				// durch auf die nächst kleinere Zehnerpotenz kürzen
				}
				
				ergebnis+=roem[zehnerpotenz--][stellenwert];
				
			}
			System.out.print(ergebnis);
			eing.close();		
	}

}