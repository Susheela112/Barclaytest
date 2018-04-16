package barclay;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SeatArranger {

	public static void main(String[] args) {
		ArrayList<Position> seats = new ArrayList<Position>();
		Boolean seatsParsed = false;
		List<Position> availablePostions = new LinkedList<Position>();
		int counter = 0;
		int rowCount=0;
		int totalSeats = 0;
		System.out.println("Enter input: ");
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(sc.hasNextLine()){
			String nextLine = sc.nextLine();
			if(nextLine.trim().equals("") ){
				 seatsParsed = true;
				 nextLine = sc.nextLine();
			}
			//Get all Clients and their seats requirements
		    if( seatsParsed == true){		 
				String seatsNeeded = nextLine;
				String arr[] = seatsNeeded.split(" ");
				String name = arr[0];
				String seatsReq = arr[1];
				Boolean isPositionFound = false;
				if(Integer.parseInt(seatsReq) > totalSeats){
					System.out.println(name + " Sorry, we can't handle your party.");
					isPositionFound = true;
				}
				Position foundSeats = null;
				for(int i=0; i<availablePostions.size(); i++){
					Position pos = availablePostions.get(i);
					if(pos.getValue() >= Integer.parseInt(seatsReq)){
						isPositionFound = true;
						foundSeats = pos;
						System.out.println(name + " Row " + pos.getRow() + " Column " + pos.getColumn());
						break;
					}
	    		}
				if(isPositionFound){
					availablePostions.remove(foundSeats);
				}
				if(!isPositionFound){
					for (int t = counter; t < seats.size(); t++) {
						Position pos = seats.get(t);
						counter++;
						if (pos.getValue() >= Integer.parseInt(seatsReq)) {
							isPositionFound = true;
							System.out.println(name + " Row " + pos.getRow() + " Column " + pos.getColumn());
							break;
						} else {
							availablePostions.add( pos);
					    }
						
					}
					if(!isPositionFound){
						System.out.println(name + " Call to split party.");
					}
				}
			}else if(seatsParsed == false){
				// Parse all seats available (row and column positions) and save it in a list
				String seatsInLine = nextLine;
				String arr[] = seatsInLine.split(" ");
				rowCount++;
				for(int i=0;i<arr.length;i++){
					Position pos = new Position();
					totalSeats = totalSeats +Integer.parseInt(arr[i]);
					pos.setValue(Integer.parseInt(arr[i]));
					pos.setRow(rowCount);
					pos.setColumn(i);
					seats.add(pos);
				}
			}
			
		}
	}

}
class Position{
	int row;
	int column;
	int value;
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}
