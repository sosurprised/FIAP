package beans;

import java.util.Random;
import java.util.Scanner;

public class Jogo {
	int[] game = new int[9]; 
	int numberFreeSpaces = 8;
	
		
	public boolean checkFreeSpaces() {
		if(this.numberFreeSpaces<=0) 
			return false;
		return true;
	}

	public void showCurrentTable() { 
		String horizontalLine = " -----------";
		String verticalLine = "";
		int aux = 0; 
		for(int i = 0; i<3; i++) {
			verticalLine = "";
			System.out.println(horizontalLine);
			aux+=3;
			for(int j = i*3; j<aux; j++) {
				if (this.game[j]==1) 
					verticalLine += ("| "+ "+ "); 
				else if (this.game[j]==2)
					verticalLine += ("| "+ "@ "); 
				else 
					verticalLine += ("| "+ "  "); 
			}
			verticalLine+= "|";
			System.out.println(verticalLine);		
		}
		System.out.println(horizontalLine);
	}
	
	public void makeMoveUser(int move) {
		this.game[move-1]=1;
		this.numberFreeSpaces-=1;
	}
	
	public void makeMoveComputer() {
		Random r = new Random();
		int position = r.nextInt(9);
		boolean foundMove = false;	
		while (!foundMove){
			if((this.game[position]==1)||(this.game[position]==2)) {
				position = r.nextInt(9);
			}else {
				this.game[position]=2;
				foundMove = true;
			}
		}
		this.numberFreeSpaces-=1;
	}
	
	public boolean checkForWinners() {
		if ((this.game[0]==1&&this.game[1]==1&&this.game[2]==1)||(this.game[0]==1&&this.game[3]==1&&this.game[6]==1)||
				(this.game[0]==1&&this.game[4]==1&&this.game[8]==1)||(this.game[3]==1&&this.game[4]==1&&this.game[5]==1)||
				(this.game[2]==1&&this.game[4]==1&&this.game[6]==1)||(this.game[6]==1&&this.game[7]==1&&this.game[8]==1)||
				(this.game[2]==1&&this.game[5]==1&&this.game[8]==1)||(this.game[1]==1&&this.game[4]==1&&this.game[7]==1)) {
			System.out.println("Parabéns, você gahnou!");
			return true;
		}else if ((this.game[0]==2&&this.game[1]==2&&this.game[2]==2)||(this.game[0]==2&&this.game[3]==2&&this.game[6]==2)||
				(this.game[0]==2&&this.game[4]==2&&this.game[8]==2)||(this.game[3]==2&&this.game[4]==2&&this.game[5]==2)||
				(this.game[2]==2&&this.game[4]==2&&this.game[6]==2)||(this.game[6]==2&&this.game[7]==2&&this.game[8]==2)||
				(this.game[2]==2&&this.game[5]==2&&this.game[8]==2)||(this.game[1]==2&&this.game[4]==2&&this.game[7]==2)){
			System.out.println("Oooops, você perdeu!");
			return true;
		}else {
			return false;
		}
	}
	
	public void tableExample() {
		String horizontalLine = " -----------";
		String verticalLine = "";
		int aux = 0; 
		for(int i = 0; i<3; i++) {
			verticalLine = "";
			System.out.println(horizontalLine);
			aux+=3;
			for(int j = i*3; j<aux; j++) {
				verticalLine += ("| "+ (j+1) +" ");
			}
			verticalLine+= "|";
			System.out.println(verticalLine);
		}
		System.out.println(horizontalLine);
	}
	public void jogar() {
		Scanner scn = new Scanner(System.in);
		System.out.print("Bem-vindo ao jogo da velha! \nVocê vai jogar contra o computador! \n");
		System.out.print("Escolha um numero de 1 a 9 que corresponde às posições do jogo, como nesse exemplo: \n");
		tableExample();
		int posicao = 0;
		while (checkFreeSpaces()&&!checkForWinners()) {
			System.out.println("Escolha uma posição:");
			posicao = scn.nextInt();
			makeMoveUser(posicao);
			if (checkForWinners()) 
				break;
			makeMoveComputer();
			if (checkForWinners()) 
				break;
			System.out.println("Confira como jogou o computador:");
			showCurrentTable();			
		}
		showCurrentTable();
		if(!checkFreeSpaces()&&!checkForWinners())
			System.out.println("Game over! Empate!");
		scn.close();
	}	
}
	

