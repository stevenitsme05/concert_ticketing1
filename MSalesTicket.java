import java.util.Scanner;
import java.awt.*;
import java.lang.*;
import java.io.*;

public class MSalesTicket extends MainAppGragg{
		// ticket info
		int ticketID = 0;
		String ticketConcertEventName = null;
		String ticketConcertGuest = null;
		String ticketConcertDate = null;
		String ticketType = null;
		int ticketQuantity = 0;
		String ticketEntrance = null;
		String ticketSeatID = null;

		//sales info
		int saleCtr = 0;
		double saleTotal = 0;

		

		public void setTicketInfo(int ticketID, String ticketConcertEventName, String ticketConcertGuest, String ticketConcertDate, String ticketType, int ticketQuantity,String ticketEntrance, String ticketSeatID, double ticketPrice){
			this.ticketID = ticketID;
			this.ticketConcertEventName = ticketConcertEventName;
			this.ticketConcertGuest = ticketConcertGuest;
			this.ticketConcertDate = ticketConcertDate; 
			this.ticketType = ticketType;
			this.ticketQuantity = ticketQuantity;
			this.ticketEntrance = ticketEntrance;
			this.ticketSeatID = ticketSeatID;
			this.saleCtr+=ticketQuantity;
			this.saleTotal += ticketPrice;
			System.out.println("\t\t**Transaction Completed!**\n");
		}


		public int getTicketID(){
			return this.ticketID;
		}

		public String getConcertEventName(){
			return this.ticketConcertEventName;
		}

		public String getConcertGuestName(){
			return this.ticketConcertGuest;
		}

		public String getConcertDate(){
			return this.ticketConcertDate;
		}

		public String getTicketType(){
			return this.ticketType;
		}

		public int getTicketQuantity(){
			return this.ticketQuantity;
		}

		public String getEntrance(){
			return this.ticketEntrance;
		}

		public String getSeatID(){
			return this.ticketSeatID;
		}

		public int getSalesCtr(){
			return this.saleCtr;
		}

		public double getSalesTotal(){
			return this.saleTotal;
		}

		



}