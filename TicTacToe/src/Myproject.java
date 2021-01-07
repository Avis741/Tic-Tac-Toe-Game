import java.util.Random;
import java.util.Scanner;
import java.util.*;

public class Myproject {
	static ArrayList<Integer> playerPosition= new ArrayList<Integer>();
	static ArrayList<Integer> cpuPosition =new ArrayList<Integer>();
	 

	public static void main(String[] args) {
		
		
		
		// TODO Auto-generated method stub
		char gameboard[][]= {{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '}};
		
		printgameBoard(gameboard);
		
		while(true) {
			
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the board position (1-9) :");
		int playerpos=sc.nextInt();
		
		while(playerPosition.contains(playerpos)|| cpuPosition.contains(playerpos)) {
			System.out.println("player positon taken ,try another position");
			playerpos=sc.nextInt();
		
		}
		playerPieces(gameboard,playerpos,"player");
		String result=checkwinner();
		if(result.length()>0) {
			System.out.println(result);
			break;
		}
		
		Random rand =new Random();
		int cpupos=rand.nextInt(9)+1;
		while(playerPosition.contains(cpupos)||cpuPosition.contains(cpupos)) {
			
		 cpupos=rand.nextInt(9)+1;
		}
		playerPieces(gameboard,cpupos,"cpu");
		
		
		printgameBoard(gameboard);
		result=checkwinner();
		if(result.length()>0) {
		System.out.println(result);
		break;
		}
		}
		
	}
	
	public static void printgameBoard(char[][] gameboard) {
		for(char x[]:gameboard) {
			for(char y:x) {
				System.out.print(y);
			}
			System.out.println();
		}

		
	}
	public static void playerPieces(char [][] gameboard,int pos,String user) {
		char symbol=' ';
		if(user.equals("player")) {
			symbol='X';	
			playerPosition.add(pos);
		}
		else if(user.equals("cpu")) {
			symbol='O';
			cpuPosition.add(pos);
		}
			
		
		switch(pos){
		
			case 1:gameboard[0][0]=symbol;
				break;
			case 2:gameboard[0][2]=symbol;
				break;
			case 3:gameboard[0][4]=symbol;
				break;
			case 4:gameboard[2][0]=symbol;
				break;
			case 5:gameboard[2][2]=symbol;
				break;
			case 6:gameboard[2][4]=symbol;
				break;
			case 7:gameboard[4][0]=symbol;
				break;
			case 8:gameboard[4][2]=symbol;
				break;
			case 9:gameboard[4][4]=symbol;
				break; 
			default:
				break;
	}
	
	}
	static String checkwinner() {
		
		List toprow =Arrays.asList(1,2,3);
		List midrow =Arrays.asList(4,5,6);
		List botrow =Arrays.asList(7,8,9);
		List leftcol =Arrays.asList(1,4,7);
		List midcol =Arrays.asList(2,5,8);
		List rightcol =Arrays.asList(3,6,9);
		List cross1=Arrays.asList(1,5,9);
		List cross2 =Arrays.asList(3,5,7);
		
		List <List> winner= new ArrayList<>();
		winner.add(toprow);
		winner.add(midrow);
		winner.add(botrow);
		winner.add(leftcol);
		winner.add(midcol);
		winner.add(rightcol);
		winner.add(cross1);
		winner.add(cross2);
		
		for(List l:winner) {
			if(playerPosition.containsAll(l)) {
				
				System.out.println("congratuation your won");
				break;
			}
			else if(cpuPosition.containsAll(l)) {
				System.out.println("CPU WINS");
				break;
			}
			else if((playerPosition.size()+cpuPosition.size())== 9 ) {
				System.out.println("Draw");
				break;
			}
			
			
		}
	
		
		return "";
	}
}

		

 

