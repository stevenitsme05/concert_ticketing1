import java.util.Scanner;
import java.awt.*;
import java.lang.*;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom; 

//Stack
public class MTicket extends MainAppGragg { 
	int concertEventMax;
	int top;
	String eventLocation[];
	String eventName[];
	String eventDateTime[];
	String eventGuest1[];
	double eventTicketVIPPrice[];
	double eventTicketUpperBoxPrice[];
	double eventTicketLowerBoxPrice[];
	double eventTicketGenAdPrice[];
	int eventMaxSeatsOverAll[];
	int eventSeatNumVIP[];
	int eventSeatNumUpB[];
	int eventSeatNumLwB[];
	int eventSeatNumGenAd[];
	MSalesTicket mst = new MSalesTicket();
	MainAppGragg mg = new MainAppGragg();

	public MTicket(){

		concertEventMax = 10;
		eventLocation = new String[concertEventMax];
		eventName = new String[concertEventMax];
		eventDateTime = new String[concertEventMax];
		eventGuest1 = new String[concertEventMax];
		eventTicketVIPPrice = new double[concertEventMax];
		eventTicketUpperBoxPrice = new double[concertEventMax];
		eventTicketLowerBoxPrice = new double[concertEventMax];
		eventTicketGenAdPrice = new double[concertEventMax];
		eventMaxSeatsOverAll = new int[concertEventMax];
		eventSeatNumVIP = new int[concertEventMax];
		eventSeatNumUpB = new int[concertEventMax];
		eventSeatNumLwB = new int[concertEventMax];
		eventSeatNumGenAd = new int[concertEventMax];
		top = 0;
	}


	
    public boolean empty(){
    	if(top == 0){
    		return true;
    	}else{
    		return false;
    	}
    }
    
	public void push(String eventLocation,String eventName,String eventDateTime,String eventGuest1,double eventTicketVIPPrice,double eventTicketUpperBoxPrice,double eventTicketLowerBoxPrice,double eventTicketGenAdPrice,int eventMaxSeatsOverAll,int eventSeatNumVIP,int eventSeatNumUpB,int eventSeatNumLwB,int eventSeatNumGenAd){
		if(top < concertEventMax){
			this.eventLocation[top] = eventLocation;
			this.eventName[top] = eventName;
			this.eventDateTime[top] = eventDateTime;
			this.eventGuest1[top] = eventGuest1;
			this.eventTicketVIPPrice[top] = eventTicketVIPPrice;
			this.eventTicketUpperBoxPrice[top] = eventTicketUpperBoxPrice;
			this.eventTicketLowerBoxPrice[top] = eventTicketLowerBoxPrice;
			this.eventTicketGenAdPrice[top] = eventTicketGenAdPrice;
			this.eventMaxSeatsOverAll[top] = eventMaxSeatsOverAll;
			this.eventSeatNumVIP[top] = eventSeatNumVIP;
			this.eventSeatNumUpB[top] = eventSeatNumUpB;
			this.eventSeatNumLwB[top] = eventSeatNumLwB;
			this.eventSeatNumGenAd[top] = eventSeatNumGenAd;
			top++;
			System.out.println("\t\t** GOOD ** \n");
		}else{
			System.out.println("\t\t** ERROR! MAXIMUM EVENT REACHED! ** \n");
		}
	}

	public void pop(){
		if(!this.empty()){
			this.eventLocation[top - 1] = null;
			this.eventName[top - 1] = null;
			this.eventDateTime[top - 1] = null;
			this.eventGuest1[top - 1] = null;
			this.eventTicketVIPPrice[top - 1] = 0;
			this.eventTicketUpperBoxPrice[top - 1] = 0;
			this.eventTicketLowerBoxPrice[top - 1] = 0;
			this.eventTicketGenAdPrice[top - 1] = 0;
			this.eventMaxSeatsOverAll[top - 1] = 0;
			this.eventSeatNumVIP[top - 1] = 0;
			this.eventSeatNumUpB[top - 1] = 0;
			this.eventSeatNumLwB[top - 1] = 0;
			this.eventSeatNumGenAd[top - 1] = 0;
			top--;
		}else{
			System.out.println("\t\t** ERROR! THERE IS NO EXISTING EVENT ADDED. ** \n");
		}
	}

	public void saleOnVIP(int i,int j){
		if(!this.empty()){
			
			this.eventSeatNumVIP[i] -= j;
		}else{
			System.out.println("\t\t** ERROR! THERE IS NO EXISTING EVENT ADDED. ** \n");
		}
	}

	public void saleOnUPB(int i, int j){
		if(!this.empty()){
			
			this.eventSeatNumUpB[i] -= j;
		}else{
			System.out.println("\t\t** ERROR! THERE IS NO EXISTING EVENT ADDED. ** \n");
		}
	}

	public void saleOnLWB(int i, int j){
		if(!this.empty()){
			
			this.eventSeatNumLwB[i] -= j;
		}else{
			System.out.println("\t\t** ERROR! THERE IS NO EXISTING EVENT ADDED. ** \n");
		}
	}

	public void saleOnGA(int i, int j){
		if(!this.empty()){
			
			this.eventSeatNumGenAd[i] -= j;
		}else{
			System.out.println("\t\t** ERROR! THERE IS NO EXISTING EVENT ADDED. ** \n");
		}
	}



	
	public void addEventProc(){
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		String digit = "[\\d]{3,8}";
		String digitdec = "([0-9]{3,5}).([0-9]{1,2})";
		String letters = "[a-zA-Z\\.\\-\\s\\,]+";
		String guestPattern = "[a-zA-Z\\s\\,]+";
		String datePattern = "([1-9]{1,2})/([1-9]{1,2})/([0-9]{4})-([0-9]{1,2}):([0-9]{1,2})";
		boolean flag = true;
		String location = null;
		String eventName = null;
		String eventDate = null;
		String guest = null;
		String vipprice = null;
		String upbprice = null;
		String lowbprice = null;
		String genadprice = null;
		int maxoverall = 0;
		String vipseatnum = null;
		String upbseatnum = null;
		String lwbseatnum = null;
		String genadseatnum = null;
		double vipprice2 = 0.0;
		double upbprice2 = 0.0;
		double lowbprice2 = 0.0;
		double genadprice2 = 0.0;
		int vipseatnum2 = 0;
		int upbseatnum2 = 0;
		int lwbseatnum2 = 0;
		int genadseatnum2 = 0;



		System.out.println("\t\t** ADD CONCERT EVENT **");
		
        
		//event name
        do {

            System.out.print("\n\t*ENTER EVENT NAME(can  only contain [,] [.] [space] [-] [letters]): \t");
            try{
            	eventName = sc1.nextLine();
            	flag = eventName.matches(letters);
            	if (!flag || eventName.isEmpty()){
            		System.out.println("\t\t**Error! Event Name can only contain  [,] [.] [space] [-] [letters] **\n");
        		}         	
            }catch(Exception e){
            	System.out.println("Error! An exception occurred: "+e);
            	flag = false;
            }            
            
        } while (!flag);
        //location
		do {

            System.out.print("\n\t*ENTER LOCATION(can contain [,] [.] [space] [-] [letters]): \t");
            try{
            	location = sc1.nextLine();
            	flag = location.matches(letters);
            	if (!flag || location.isEmpty()){
            		System.out.println("\t\t**Error! Address can contain  [,] [.] [space] [-] [letters] **\n");
        		}
            }catch(Exception e){
            	System.out.println("Error! An exception occurred: "+e);
            	flag = false;
            }           
            
        } while (!flag);
        //event date and time
        do {

            System.out.print("\n\t*ENTER EVENT DATE and TIME(format[mm/DD/YYYY-hh:mm]): \t");
            try{
            	eventDate = sc1.nextLine();
            	flag = eventDate.matches(datePattern);
            	if (!flag || eventDate.isEmpty()){
            		System.out.println("\t\t**Error! EVENT DATE and TIME is [ mm/DD/YYYY-hh:mm(24-hr format)] w/ no leading zeros **\n");
        		}
            }catch(Exception e){
            	System.out.println("Error! An exception occurred: "+e);
            	flag = false;
            }        
            
        } while (!flag);
        // event guests
        do {

            System.out.print("\n\t*ENTER GUEST FOR THE CONCERT(can be many but separated with [,]): \t");
            try{
            	guest = sc1.nextLine();
            	flag = guest.matches(guestPattern);
            	if (!flag || guest.isEmpty()){
            		System.out.println("\t\t**Error! GUEST NAME(s) must be separated by [,]**\n");
        		}
            }catch(Exception e){
            	System.out.println("Error! An exception occurred: "+e);
            	flag = false;
            }            
        } while (!flag);

        // vip ticket price
        do{
        	flag = true;
			System.out.print("\n\t*ENTER VIP Ticket Price: \t");
			try{
			vipprice = sc1.nextLine();
			flag = vipprice.matches(digitdec);
			if (!flag || vipprice.isEmpty()){
            		System.out.println("\t\t**Error! Value must be digit with decimal  and minimum of 100.00 maximum of 5 digits.**\n"); 
        		}

			}catch(Exception e){
			System.out.println("Error! An exception occurred: "+e);
			flag = false;
			}
        }while(!flag);

        //vip seat number
        do{
			System.out.print("\n\t*Maximum Seat number of VIP: \t");
			try{
			vipseatnum = sc1.nextLine();
			flag = vipseatnum.matches(digit);
				if (!flag || vipseatnum.isEmpty()){
            		System.out.println("\t\t**Error! Value must be digit and minimum of 100 and maximum of 8 digits.**\n");
        		}
			}catch(Exception e){
			System.out.println("Error! An exception occurred: "+e);
			flag = false;
			}
        }while(!flag);
        // upper box ticket price
        do{
			System.out.print("\n\t*ENTER Upper Box Ticket Price: \t");
			try{
			upbprice = sc1.nextLine();
			flag = upbprice.matches(digitdec);
				if (!flag || upbprice.isEmpty()){
            		System.out.println("\t\t**Error! Value must be digit with decimal  and minimum of 100.00 maximum of 5 digits.**\n");
        		}
			}catch(Exception e){
				System.out.println("Error! An exception occurred: "+e);
				flag = false;
			}
        }while(!flag);

        // upper box seat number
        do{
			System.out.print("\n\t*Maximum Seat number of Upper Box: \t");
			try{
			upbseatnum = sc1.nextLine();
			flag = upbseatnum.matches(digit);
				if (!flag || upbseatnum.isEmpty()){
            		System.out.println("\t\t**Error! Value must be digit and minimum of 100 and maximum of 8 digits.**\n");
        		}

			}catch(Exception e){
				System.out.println("Error! An exception occurred: "+e);
				flag = false;
			}
        }while(!flag);
        // lower box ticket price
		do{
			System.out.print("\n\t*ENTER Lower Box Ticket Price: \t");
			try{
			lowbprice = sc1.nextLine();
			flag = lowbprice.matches(digitdec);
				if (!flag || lowbprice.isEmpty()){
            		System.out.println("\t\t**Error! Value must be digit with decimal and minimum of 100.00 maximum of 5 digits.**\n");
        		}

			}catch(Exception e){
			System.out.println("Error! An exception occurred: "+e);
			flag = false;
			}
        }while(!flag);

        // upper box seat number
        do{
			System.out.print("\n\t*Maximum Seat number of Lower Box: \t");
			try{
			lwbseatnum = sc1.nextLine();
			flag = lwbseatnum.matches(digit);
				if (!flag || lwbseatnum.isEmpty()){
            		System.out.println("\t\t**Error! Value must be digit and minimum of 100 and maximum of 8 digits.**\n");
        		}
			}catch(Exception e){
			System.out.println("Error! An exception occurred: "+e);
			flag = false;
			}
        }while(!flag);
        // gen ad ticket price
		do{
			System.out.print("\n\t*ENTER General Admission Ticket Price: \t");
			try{
			genadprice = sc1.nextLine();
			flag = genadprice.matches(digitdec);
				if (!flag || genadprice.isEmpty()){
            		System.out.println("\t\t**Error! Value must be digit with decimal and minimum of 100.00 maximum of 5 digits.**\n");
        		}
			
			}catch(Exception e){
			System.out.println("Error! An exception occurred: "+e);
			flag = false;
			}
        }while(!flag);
        // gen ad seat number
        do{
			System.out.print("\n\t*Maximum Seat number of General Admission: \t");
			try{
			genadseatnum = sc1.nextLine();
			flag = genadseatnum.matches(digit);
				if (!flag || genadseatnum.isEmpty()){
            		System.out.println("\t\t**Error! Value must be digit and minimum of 100 and maximum of 8 digits.**\n");
        		}
			}catch(Exception e){
			System.out.println("Error! An exception occurred: "+e);
			flag = false;
			}
        }while(!flag);

        vipprice2 = Double.parseDouble(vipprice);
        upbprice2 = Double.parseDouble(upbprice);
        lowbprice2 = Double.parseDouble(lowbprice);
        genadprice2 = Double.parseDouble(genadprice);
        vipseatnum2 = Integer.parseInt(vipseatnum);
        upbseatnum2 = Integer.parseInt(upbseatnum);
        lwbseatnum2 = Integer.parseInt(lwbseatnum);
        genadseatnum2 = Integer.parseInt(genadseatnum);
        maxoverall = vipseatnum2 + upbseatnum2 + lwbseatnum2 + genadseatnum2;
        this.push(location,eventName,eventDate,guest,vipprice2,upbprice2,lowbprice2,genadprice2,maxoverall,vipseatnum2,upbseatnum2,lwbseatnum2,genadseatnum2);
 

	}

	public void viewEventsProc(){
		int i = 0;
		if(this.empty()){
			System.out.println("\n\t\t***** CONCERT EVENT IS EMPTY, PLEASE ADD FIRST. *****\n");
		}else{
		for(i = 0; i <= this.top-1; i++){
			System.out.printf("\t\t***** EVENT[%d] *****\n",i+1);
			
			System.out.println("Concert Name: "+this.eventName[i]);
			System.out.println("Location: "+this.eventLocation[i]);
			System.out.println("Date and Time: "+this.eventDateTime[i]);
			System.out.println("Guest(s): "+this.eventGuest1[i]);
			
			System.out.println("\t************** <<>> **************");
		}
		}
		

	}

	public void viewEventsProc2(){
		int i = 0;
		if(this.empty()){
			System.out.println("\n\t\t***** CONCERT EVENT IS EMPTY, PLEASE ADD FIRST. *****\n");
		}else{
		for(i = 0; i <= this.top-1; i++){
			System.out.printf("\t\t***** EVENT[%d] *****\n",i+1);
			
			System.out.println("Concert Name: "+this.eventName[i]);
			System.out.println("Location: "+this.eventLocation[i]);
			System.out.println("Date and Time: "+this.eventDateTime[i]);
			System.out.println("Guest(s): "+this.eventGuest1[i]);
			System.out.println("VIP Ticket Price: "+this.eventTicketVIPPrice[i]);
			System.out.println("Upper Box Ticket Price: "+this.eventTicketUpperBoxPrice[i]);
			System.out.println("Lower Box Ticket Price: "+this.eventTicketLowerBoxPrice[i]);
			System.out.println("General Admission Ticket Price: "+this.eventTicketGenAdPrice[i]);
			
			System.out.println("Remaining VIP Slots: "+this.eventSeatNumVIP[i]);
			System.out.println("Remaining Upper Box Slots: "+this.eventSeatNumUpB[i]);
			System.out.println("Remaining Lower Box Slots: "+this.eventSeatNumLwB[i]);
			System.out.println("Remaining Gen Ad Slots: "+this.eventSeatNumGenAd[i]);

			System.out.println("Over All: "+this.eventMaxSeatsOverAll[i]);

			System.out.println("\t************** <<>> **************");
		}
		}
		

	}

	public void showTicketSales(){
		int saleCtr = mst.getSalesCtr();
		double salesTotal = mst.getSalesTotal();
		System.out.println("\n\t-------------------------------------------------------------");
		System.out.printf("\n\t|Number of Tickets Sold: %d                              |",saleCtr);
		System.out.printf("\n\t|Number of Tickets Sold: %.2f                        |",salesTotal);
		System.out.println("\n\t-------------------------------------------------------------");

	}

	public void showTicket( int quantity, int ticketType2){
		int anotherTicketID = 0;
		String ticketTypeName = null;
		int ticketID = mst.getTicketID();
		String ticketConcertEventName = mst.getConcertEventName();
		String ticketConcertGuest = mst.getConcertGuestName();
		String ticketDateTime = mst.getConcertDate();
		String ticketType = mst.getTicketType();
		String ticketEntrance = mst.getEntrance();
		String ticketSeatNum = mst.getSeatID();
		if(quantity > 1){
			anotherTicketID = ThreadLocalRandom.current().nextInt();
			if(ticketType2 == 1){
				ticketTypeName = "VIP" + anotherTicketID;
			}else if(ticketType2 == 2){
				ticketTypeName = "UPB" + anotherTicketID;
			}else if( ticketType2 == 3){
				ticketTypeName = "LWB" + anotherTicketID;
			}else{
				ticketTypeName = "GA" + anotherTicketID;
			}

			System.out.println("\n\t-------------------------------------------------------------");
		System.out.printf("\n\t|Ticket ID: %d",anotherTicketID);
		System.out.println("\n\t-------------------------------------------------------------");
		System.out.printf("\n\t|     *       |       ((%s))",ticketConcertEventName.toUpperCase());
		System.out.printf("\n\t|    * *      |  with ((%s))",ticketConcertGuest.toUpperCase());
		System.out.printf("\n\t|  *******    |--------------------------------------------");
		System.out.printf("\n\t|    * *      |-------When: %s",ticketDateTime);
		System.out.printf("\n\t|     *       |-------[%s]",ticketType);
		System.out.println("\n\t-------------------------------------------------------------");
		System.out.printf("\n\t|ENTRANCE: %s",ticketEntrance);
		System.out.printf("\n\t|SEAT NUMBER: %s",ticketTypeName);
		System.out.println("\n\t-------------------------------------------------------------");
		}
		
		System.out.println("\n\t-------------------------------------------------------------");
		System.out.printf("\n\t|Ticket ID: %d",ticketID);
		System.out.println("\n\t-------------------------------------------------------------");
		System.out.printf("\n\t|     *       |       ((%s))",ticketConcertEventName.toUpperCase());
		System.out.printf("\n\t|    * *      |  with ((%s))",ticketConcertGuest.toUpperCase());
		System.out.printf("\n\t|  *******    |--------------------------------------------");
		System.out.printf("\n\t|    * *      |-------When: %s",ticketDateTime);
		System.out.printf("\n\t|     *       |-------[%s]",ticketType);
		System.out.println("\n\t-------------------------------------------------------------");
		System.out.printf("\n\t|ENTRANCE: %s",ticketEntrance);
		System.out.printf("\n\t|SEAT NUMBER: %s",ticketSeatNum);
		System.out.println("\n\t-------------------------------------------------------------");

	}

	public void buyTicket(){
		// ticket info
		Scanner sc4 = new Scanner(System.in);
		boolean flag2 = true;
		boolean flag3 = true;
		String digit = "([1-9]{1,5})";
		String digit1 = "([1-9]{1})";
		//String letters = "[a-zA-Z\\.\\-\\s\\,]+";
		int ticketID = 0;
		String ticketConcertEventName = null;
		String concertEventNum = null;
		int concertEventNum2 = 0;
		String concertGuest = null;
		String eventDateTime = null;
		String ticketType = null;
		String ticketTypeNum = null;
		int ticketTypeNum2 = 0;
		String ticketQuantity = null;
		int ticketQuantity2 = 0;
		String ticketEntrance = null;
		String ticketSeatID = null;


		double ticketSales = 0.0;
		double ticketPickedPrice = 0.0;

		//ticket ID
		int rand_int1 = ThreadLocalRandom.current().nextInt(); 
		ticketID = rand_int1;
		//choosing which concert
		do{
		do{
			System.out.print("\n\t*Enter the number of Concert: \t");
			try{
			concertEventNum = sc4.nextLine();
			flag2 = concertEventNum.matches(digit);
				if (!flag2 || concertEventNum.isEmpty()){
            		System.out.println("\t\t**Error! Value must be digit and up to 5 digits only.**\n");
        		}
			}catch(Exception e){
			System.out.println("\t\tError! An exception occurred: "+e);
			flag2 = false;
			}
        }while(!flag2);

        concertEventNum2 = Integer.parseInt(concertEventNum);

        if(concertEventNum2 > this.top || concertEventNum2 < 0){
        	System.out.println("\t\t**Error! Value entered was not in the choices.**\n");
        	flag2=false;
        }
    	}while(!flag2);

    	//concert name 
    	ticketConcertEventName = this.eventName[concertEventNum2-1];
    	//guest
    	concertGuest = this.eventGuest1[concertEventNum2-1];
    	//date and time
    	eventDateTime = this.eventDateTime[concertEventNum2-1];
    	//quantity
    	do{
		do{
			System.out.print("\n\t*How many ticket?(Minimum of 2 per transaction): \t");
			try{
			ticketQuantity = sc4.nextLine();
			flag2 = ticketQuantity.matches(digit1);
				if (!flag2 || ticketQuantity.isEmpty()){
            		System.out.println("\t\t**Error! Value must be digit and maximum of 2 tickets per transaction and value must not be zero.**\n");
        		}
			}catch(Exception e){
			System.out.println("\t\tError! An exception occurred: "+e);
			flag2 = false;
			}
        }while(!flag2);

        ticketQuantity2 = Integer.parseInt(ticketQuantity);

        if(ticketQuantity2 > 2 || ticketQuantity2 <= 0){
        	System.out.println("\t\t**Error! Value entered was not in the choices.**\n");
        	flag2=false;
        }
    	}while(!flag2);
    	//ticket type
    	do{
		do{
			System.out.printf("\n\t* Press [1] - VIP Ticket (PHP %.2f)",this.eventTicketVIPPrice[concertEventNum2-1]);
			System.out.printf("\n\t* Press [2] - Upper Box Ticket(PHP %.2f)",this.eventTicketUpperBoxPrice[concertEventNum2-1]);
			System.out.printf("\n\t* Press [3] - Lower Box Ticket(PHP %.2f)",this.eventTicketLowerBoxPrice[concertEventNum2-1]);
			System.out.printf("\n\t* Press [4] - Gen Ad Ticket(PHP %.2f)",this.eventTicketGenAdPrice[concertEventNum2-1]);
			System.out.printf("\n\t*Enter the number of Ticket Type: \t");
			try{
			ticketTypeNum = sc4.nextLine();
			flag2 = ticketTypeNum.matches(digit1);
				if (!flag2 || ticketTypeNum.isEmpty()){
            		System.out.println("\t\t**Error! Value must be digit and up to 1 digit only.**\n");
        		}
			}catch(Exception e){
			System.out.println("\t\tError! An exception occurred: "+e);
			flag2 = false;
			}
        }while(!flag2);

        ticketTypeNum2 = Integer.parseInt(ticketTypeNum);

        if(ticketTypeNum2 == 1){
        	ticketType = "VIP Ticket";
        	ticketEntrance = "VIP MAIN ENTRANCE";
        	ticketSeatID = "VIP"+ticketID;
        	ticketPickedPrice = this.eventTicketVIPPrice[concertEventNum2-1];
        	this.saleOnVIP(concertEventNum2-1,ticketQuantity2*1);
        }else if(ticketTypeNum2 == 2){
        	ticketType = "Upper Box Ticket";
        	ticketEntrance = "ENTRANCE 1A";
        	ticketSeatID = "UPB"+ticketID;
        	ticketPickedPrice = this.eventTicketUpperBoxPrice[concertEventNum2-1];
        	this.saleOnUPB(concertEventNum2-1,ticketQuantity2*1);
        }else if(ticketTypeNum2 == 3){
        	ticketType = "Lower Box Ticket";
        	ticketEntrance = "ENTRANCE 2A";
        	ticketSeatID = "LWB"+ticketID;
        	ticketPickedPrice = this.eventTicketLowerBoxPrice[concertEventNum2-1];
        	this.saleOnLWB(concertEventNum2-1,ticketQuantity2*1);
        }else if(ticketTypeNum2 == 4){
        	ticketType = "General Admission Ticket";
        	ticketEntrance = "ENTRANCE 3A and 3B";
        	ticketSeatID = "GA"+ticketID;
        	ticketPickedPrice = this.eventTicketGenAdPrice[concertEventNum2-1];
        	this.saleOnGA(concertEventNum2-1,ticketQuantity2*1);
        }else{
        	System.out.println("\t\t**Error! Value entered was not in the choices.**\n");
        	flag2=false;
        }
    	}while(!flag2);

    	

    	ticketSales = ticketPickedPrice * ticketQuantity2;
    	mst.setTicketInfo(ticketID,ticketConcertEventName,concertGuest,eventDateTime,ticketType,ticketQuantity2,ticketEntrance,ticketSeatID,ticketSales);
    	mg.clrscr();

    	this.showTicket(ticketQuantity2,ticketTypeNum2);

	}





}