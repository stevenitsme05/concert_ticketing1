import java.util.Scanner;
import java.awt.*;
import java.lang.*;
import java.io.*;
import jline.*;




public class MainAppGragg{

	 static int _MENU_1 = 1;
	 static int _MENU_2 = 2;
	 static int _MENU_3 = 3;
	 static int _MENU_4 = 4;
	 static MTicket mt = new MTicket();

	public static void clrscr(){
    //Clears Screen in java
    try{
        if (System.getProperty("os.name").contains("Windows")){
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}else{
		Runtime.getRuntime().exec("clear");}
    }catch (IOException | InterruptedException ex) {}
	}

	public static void loginMain() throws IOException{
		//Scanner sc1 = new Scanner(System.in);
		String userNameHold;
		String passwordHold;
		int result;
		ConsoleReader reader = new ConsoleReader();
        Character mask = '*';

		System.out.println("\n\t\tSign In - Staff or Admin \n\t\tNote: Please enter your credentials.");
		do{

		
		userNameHold = reader.readLine("\n\t\tUser name:\t");
        passwordHold = reader.readLine("\n\t\tPassword:\t", mask);

		 MLogin ml = new MLogin();
		result = ml.loginProc(userNameHold,passwordHold);

		if(result == 0){
			System.out.println("\t\tLog in failed! Please try again.");
		}
		}while(result == 0);
	}

	

	public static void loginMainAdmin() throws IOException{
		//Scanner sc1 = new Scanner(System.in);
		String userNameHold1;
		String passwordHold1;
		int result1;
		ConsoleReader reader1 = new ConsoleReader();
        Character mask1 = '*';

		System.out.println("\n\t\tSign In - ADMINISTRATOR \n\t\tNote: Please enter your credentials.");
		do{

		
		userNameHold1 = reader1.readLine("\n\t\tUser name:\t");
        passwordHold1 = reader1.readLine("\n\t\tPassword:\t", mask1);

		 MLogin ml1 = new MLogin();
		result1 = ml1.loginProcAdmin(userNameHold1,passwordHold1);

		if(result1 == 0){
			System.out.println("\t\tLog in failed! Please try again.");
		}
		}while(result1 == 0);
	}
//admin
	public static void acceptAdminChoice() {
		Scanner sc3 = new Scanner(System.in);
		int userChoice3;
		System.out.println("\n\t*********ADMINISTRATOR**********");
		System.out.println("\n\t************************");
		System.out.println("\tPress [1] ADD CONCERT EVENT");
		System.out.println("\tPress [2] VIEW EVENTS");
		System.out.println("\tPress [3] VIEW SALES");
		System.out.println("\tPress [4] SIGN OUT");
		System.out.println("\t**************************");

		System.out.print("\n\t>>>\t");
		try{
			userChoice3 = sc3.nextInt();
		}catch(Exception e){
			System.out.println("Exception occured, please enter digit only - "+e);
			userChoice3 = 0; // define wrong choice
		}
		
		if(userChoice3 == _MENU_1){
			// -- add concert event -- //
						
			Scanner sc1 = new Scanner(System.in);
			String userChoice2 = null;
	
			
			do{
				mt.addEventProc();
				mt.viewEventsProc();

				System.out.print("\n\tAdd Concert Event again? (Y-Yes/N-No): \t");
				userChoice2 = sc1.nextLine();
			}while(userChoice2.equalsIgnoreCase("Yes") || userChoice2.equalsIgnoreCase("Y"));
			acceptAdminChoice();
		}else if(userChoice3 == _MENU_2){
			// -- view events -- //
			clrscr();
			mt.viewEventsProc2();
			acceptAdminChoice();
		}else if(userChoice3 == _MENU_3){
			// -- view sales -- //
			clrscr();
			mt.showTicketSales();
			acceptAdminChoice();
		}else if(userChoice3 == _MENU_4){
			String inputAdmin = null;
			boolean boolCheck;
			Scanner in = new Scanner(System.in);
			do{
				boolCheck = true;
				System.out.println("\n\t Are you sure you want to Log out?"); 
				System.out.print("\t (Yes/Y|No/N) =>\t\t");
				inputAdmin = in.nextLine();
				if(inputAdmin.equalsIgnoreCase("Yes") || inputAdmin.equalsIgnoreCase("Y")){
					System.out.println("sign out...\n\n"); 
					clrscr();
					acceptUserChoice();
				}else if(inputAdmin.equalsIgnoreCase("No") || inputAdmin.equalsIgnoreCase("N")){
					System.out.println("\n\tLog out Canceled..\n"); 
					acceptAdminChoice();

				}else{
					System.out.println("\n\tInput Error! Please try again.\n"); 
					boolCheck = false;
				}
			}while(!boolCheck);
			
		}else{
			System.out.println("\n\tError! Please Try again.");
			acceptAdminChoice();
		}
	}
//home
	public static void acceptUserChoice(){
		Scanner sc = new Scanner(System.in);
		int userChoice;
		boolean check;
		System.out.println("\n\t*********HOME**********");
		System.out.println("\n\t************************");
		System.out.println("\tPress [1] BUY TICKET");
		System.out.println("\tPress [2] VIEW EVENTS");
		System.out.println("\tPress [3] ADMIN CONFIGURATION - SIGN IN");
		System.out.println("\tPress [4] EXIT");
		System.out.println("\t**************************");
		

		System.out.print("\n\t>>>\t");
		try{
			userChoice = sc.nextInt();
		}catch(Exception e){
			System.out.println("Exception occured, please enter digit only - "+e);
			userChoice = 0; // define wrong choice
		}
		
		if(userChoice == _MENU_1){
			// -- buy ticket -- //
			
			check = mt.empty();
			if(check){
				clrscr();

				System.out.println("\n\t\t***** CONCERT EVENT IS EMPTY, PLEASE ADD FIRST. *****\n");
			}else{
				clrscr();
				mt.viewEventsProc();
				mt.buyTicket();
			}
			
			acceptUserChoice();
			//acceptUserChoice();
		}else if(userChoice == _MENU_2){
			// -- view events -- //
			clrscr();
			mt.viewEventsProc();
			acceptUserChoice();
		}else if(userChoice == _MENU_3){
			// -- admin configuration -- //
			try{
				loginMainAdmin();
			}catch(IOException e){
				System.out.print("\n\t** ERROR! INPUT and OUTPUT Exception occured.** \t\n");

			}
			
			clrscr();
			acceptAdminChoice();
		}else if(userChoice == _MENU_4){
			String input = null;
			boolean boolCheck;
			Scanner in2 = new Scanner(System.in);
			do{
				boolCheck = true;
				System.out.println("\n\t Are you sure you want to Exit this program? By doing so, You might lose unsaved changes."); 
				System.out.print("\t (Yes/Y|No/N) =>\t\t");
				input = in2.nextLine();
				if(input.equalsIgnoreCase("Yes") || input.equalsIgnoreCase("Y")){
					 System.out.println("exit...\n\n"); 
  
                // Terminate Program
                System.exit(0); 
				}else if(input.equalsIgnoreCase("No") || input.equalsIgnoreCase("N")){
					System.out.println("\n\tExit Canceled..\n"); 
					acceptUserChoice();

				}else{
					System.out.println("\n\tInput Error! Please try again.\n"); 
					boolCheck = false;
				}
			}while(!boolCheck);

               

		}else{
			System.out.println("\n\tError! Please Try again.");
			acceptUserChoice();
		}

	}



	
	public static void main(String []args) throws IOException{
		//System.out.println("");

		// -- MAIN PROGRAM ENTRY POINT OF THE SYSTEM -- //

		System.out.println("\t\t\nWELCOME TO CONCERT TICKETING SYSTEM");
		loginMain();
		clrscr();
		acceptUserChoice();
	}
}
