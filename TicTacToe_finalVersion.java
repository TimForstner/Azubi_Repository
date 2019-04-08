package ticTacToe;

import java.util.Scanner;

public class TicTacToe_finalVersion {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner spieler1 = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);

		String [][]spielfeld = {{ "00", "01", "02"},
								{ "10", "11", "12"},
								{ "20", "21", "22"}};
		int j;
		int y;
		int q;
		String player = "";
		String gewinner = "G";
		byte voll = 0;
		System.out.println("Welcher Spieler soll beginnen?\n1 für \"X\", 2 für \"Y\"");
		String vorwahl = scanner.nextLine();
		int auswahl = 0;
		boolean running = true;
		boolean going = true;
		
//		---------------------------------------         Game is starting  -->
		
		while (running) {
			
			if (vorwahl.matches(".*[^1-2]+.*")) {
				System.out.println("1 oder 2?");
				vorwahl = scanner.nextLine();
			}
			else {
				auswahl = Integer.parseInt(vorwahl);
				System.out.println("Keine Buchstaben oder Sonderzeichen!");
				while (auswahl <= 1 || auswahl >= 2) {
					if (auswahl == 1) {
						System.out.println("Spieler 1 fängt an");
						running=false;
						break;
					} else if (auswahl == 2) {
						System.out.println("Spieler 2 fängt an");
						running=false;
						break;
					} else {
						System.out.println("Bitte korrekte Zahl eingeben");

						auswahl = scanner.nextInt();
					}
				}
			}
		}
		

		
		for (int i = 0; i != 3; ++i) {
			for (j = 0; j != 3; ++j)

				System.out.print(spielfeld[i][j] + "\t");
			if (j == 3)
				System.out.println("");
		}
		
		while (going) {
			System.out.println("Bitte Wert eingeben");
			String spieler = spieler1.nextLine();
			if (spieler.length()==2) {
				
				if (spieler.matches(".*[^0-9]+.*")){
					System.out.println("Keine Buchstaben oder Sonderzeichen!");
				}
				else {
					Integer ungueltig = Integer.parseInt(spieler);
					String [] wert1 = spieler.split("");
					q = Integer.parseInt(wert1[0]);
					y = Integer.parseInt(wert1[1]);
					if ((q>2 || q<0) || (y>2 || y<0) || ungueltig>22) {
						System.err.println("Feld liegt nicht im Wertebereich!");
					}
					else if (spieler.equals(spielfeld[q][y])) {			// prüfen ob Feld schon belegt ist
																		
						if (auswahl == 1){
							player = "X";
							auswahl=2;
						}
						else if (auswahl == 2) {
							auswahl=1;
							player = "Y";
						}
						spielfeld[q][y] = player;
						voll++;
						if (voll==9) {
							going=false;
						}
					}
					else System.err.println("Dieses Feld ist belegt!");	
				}
			}
			else System.err.println("Keine gültige Eingabe");
			
							
			for (int i = 0; i != 3; ++i) {
				for (j = 0; j != 3; ++j)

					System.out.print(spielfeld[i][j] + " \t");
				if (j == 3)
					System.out.println("");

				if ((spielfeld[i][0] == spielfeld[i][1]) && (spielfeld[i][1] == spielfeld[i][2])) {
					gewinner = spielfeld[i][1];
					going = false;
				}

				if ((spielfeld[0][i] == spielfeld[1][i]) && (spielfeld[1][i] == spielfeld[2][i])) {
					gewinner = spielfeld[1][i];
					going = false;
				}
				if ((spielfeld[0][0] == spielfeld[1][1]) && (spielfeld[2][2] == spielfeld[1][1])) {
					gewinner = spielfeld[1][1];
					going = false;
				}
				if ((spielfeld[0][2] == spielfeld[1][1]) && (spielfeld[1][1] == spielfeld[2][0])) {
					gewinner = spielfeld[1][1];
					going = false;
				}
			}
		}

		if (gewinner != "G") {
			System.out.println("");
			System.out.println(gewinner + " gewinnt das Spiel!");
		}
		else if (voll == 9) {
			System.out.println("Unentschieden");
		}
	}
}
