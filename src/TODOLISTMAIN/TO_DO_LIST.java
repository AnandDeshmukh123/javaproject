package TODOLISTMAIN;

import java.io.IOException;
import java.util.Scanner;
import ToDoListManagement.ToDoListManagement;
import UserManagement.UserManagement;

public class TO_DO_LIST {
	
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		boolean CanIKeepRunningTheProgram = true;
		
		System.out.println("##### WELCOME TO TO DO LIST MANAGEMENT #####");
		System.out.println("\n");
		System.out.println("Enter LoginName :");
		String Name1 = sc.nextLine();
		System.out.println("Enter Password :");
		String ID1 = sc.nextLine();
		
		if(!ToDoListManagement.ValidationData(Name1,ID1)) {
			System.out.println("!!!! LOGIN FAILED. CLOSE THE APPLICATION !!!!!!");
			return;
		}else {
			System.out.println("@@@@Login Successful@@@@");
		}
		while(CanIKeepRunningTheProgram == true) {
			System.out.println("@@@@@ WELCOME TO TO DO LIST MANAGEMENT @@@@");
			System.out.println("\n");
			
			System.out.println("WHAT WOULD YOU LIKE TO DO");
			System.out.println("1. User Management");
			System.out.println("2. To Do List Management");
			System.out.println("6. Quit");
			
			int OptionSelectedByUser = sc.nextInt();
			
			if(OptionSelectedByUser == 1) {
				UserManagement.UserManagement();
			}
			else if(OptionSelectedByUser == 2) {
				ToDoListManagement.taskmanagement(Name1, ID1, Name1, ID1);
			}
			else if(OptionSelectedByUser == 6) {
				break;
			}	
		}	
	}
}
			
