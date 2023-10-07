package ToDoListManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import TODOLISTMAIN.TO_DO_LIST;
import product_management.Product;

public class ToDoListManagement {

		static ArrayList<ToDoList> al = new ArrayList<>();

		public static Object ToDoListManagement;
		
		static {
			try {
				ReadDataFromTextFileIntoArrayList();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		public static void taskmanagement(String et, String st, String mtad, String dt) throws IOException {
			
			Scanner sc = new Scanner(System.in);
			
			boolean CanIKeepRunningTheProgram = true;
			
			while(CanIKeepRunningTheProgram == true) {
				System.out.println("@@@@@@ WELCOME TO DO LIST APPLICATION @@@@@@@");
				System.out.println("which Task would you like to do?");
				System.out.println("1. Add Task");
				System.out.println("2. Edit Task");
				System.out.println("3. Search Task");
				System.out.println("4. Mark Task As Done");
				System.out.println("5. Delete Task");
				System.out.println("6. Quit");
				
				int OptionSelectedByUser = sc.nextInt();
				
				if(OptionSelectedByUser == T_Option.QUIT) {
					WriteDataTOTextFile();
					System.out.println("!!PROGRAM CLOSED!!");
					CanIKeepRunningTheProgram = false;
				}
				else if(OptionSelectedByUser == T_Option.ADD_TASK) {
					add_task();
					System.out.println();
				}
				else if(OptionSelectedByUser == T_Option.EDIT_TASK) {
					System.out.print("Enter Task which you want to Edit:");
					sc.nextLine();
					String e = sc.nextLine();
					Edit_Task(et);
					System.out.println("\n");
				}
				else if(OptionSelectedByUser == T_Option.SEARCH_TASK) {
					System.out.print("Enter Task which you want to Search:");
					sc.nextLine();
					String sp = sc.nextLine();
					Search_Task(st);
					System.out.println("\n");
				}
				else if(OptionSelectedByUser == T_Option.MARK_TASK_AS_DONE) {
					System.out.print("Enter Task which you want to Mark as Done:");
					sc.nextLine();
					String sp = sc.nextLine();
				//	Mark_Task_As_Done(mtad);
					System.out.println("\n");	
				}
				else if(OptionSelectedByUser == T_Option.DELETE_TASK) {
					System.out.print("Enter Task which you want to Delete:");
					sc.nextLine();
					String da = sc.nextLine();
					Delete_Task(dt);
					System.out.println("\n");
				}	
			}
		}

		public static void WriteDataTOTextFile() throws IOException {
			File file = new File("C:\\Users\\ANAND DESHMUKH\\eclipse-workspace\\TO DO LIST\\src\\ToDoListManagement\\ToDoList.csv");
			
			FileWriter fw = new FileWriter(file,false);
			
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(ToDoList TDL :al) {
				bw.write(TDL.TaskName+",");
				bw.write(TDL.TaskID+",");
				bw.write(TDL.Time+",");
				bw.write(TDL.Work+",");
				bw.newLine();
			}
			bw.close();
			fw.close();
			file = null;
		}
		public static void ReadDataFromTextFileIntoArrayList() throws IOException {
			File file = new File("C:\\Users\\ANAND DESHMUKH\\eclipse-workspace\\TO DO LIST\\src\\ToDoListManagement\\ToDoList.csv");
			
			FileReader fr = new FileReader(file);
			
			BufferedReader br = new BufferedReader(fr);
			
			String data = br.readLine();
			
			while(data != null) {
				String[] ArrayOfData = data.split(",");
				
				ToDoList td = new ToDoList();
				td.TaskName = ArrayOfData[0];
				td.TaskID = ArrayOfData[1];
				td.Time = ArrayOfData[2];
				td.Work = ArrayOfData[3];
				
				al.add(td);
				data = br.readLine();
				
			}
			br.close();
			fr.close();
		}

		
		public static void add_task() {
			Scanner sc = new Scanner(System.in);
			ToDoList t = new ToDoList();
			
			System.out.print("Enter Task_Name :");
			t.TaskName = sc.nextLine();
			
			System.out.print("Enter Task_ID :");
			t.TaskID = sc.nextLine();
			
			System.out.print("Enter Time :");
			t.Time = sc.nextLine();
			
			System.out.print("Enter Work :");
			t.Work = sc.nextLine();
			
			
			System.out.println("\n");
			System.out.println("Task_Name is :"+t.TaskName);
			System.out.println("Task_ID is :"+t.TaskID);
			System.out.println("Time is : "+t.Time);
			System.out.println("Work is :"+t.Work);
			
			al.add(t);
		}
		public static void Edit_Task(String TaskName) {
			for(ToDoList t:al) {
				if(t.TaskName.equalsIgnoreCase(TaskName)) {
					Scanner sc = new Scanner(System.in);
					
					System.out.println("Enter Edit Task Name:"+t.Name);
					
					System.out.print("New Task Name is :");
					t.TaskName = sc.nextLine();
					
					System.out.print("New Task ID is :");
					t.TaskID = sc.nextLine();
					
					System.out.print("New time :");
					t.Time = sc.nextLine();
					
					System.out.print("New Works :");
					t.Work = sc.nextLine();
					
					System.out.println("Task Information Updated");
					return;
				}
			}
			System.out.println("!!!!Task NOT FOUND!!!!!");
			
		}
		public static void Search_Task(String TaskName) {
			for(ToDoList t:al) {
				if(t.TaskName.equalsIgnoreCase(TaskName)) {
					System.out.println("Task_Name is :"+t.TaskName);
					System.out.println("Task ID is :"+t.TaskID);
					System.out.println("Time is : "+t.Work);
					System.out.println("Work is :"+t.Time);
					return;
				}
			}
			System.out.println("!!!! Task NOT FOUND !!!!");
		}
		public static void Delete_Task(String TaskName) {
			Iterator<ToDoList> itr = al.iterator();
			while(itr.hasNext()) {
				ToDoList pic = itr.next();
				if(pic.TaskName.equalsIgnoreCase(TaskName)) {
					itr.remove();
					System.out.println("Task "+pic.TaskName+" has been deleted");
					break;
				}
			}
		}
		public static boolean ValidationData(String TaskName ,String Taskid){
			Iterator<ToDoList> itr = al.iterator();
			
			while(itr.hasNext()) {
				ToDoList  tds = itr.next();
				if(tds.TaskName.equalsIgnoreCase(TaskName) && tds.TaskID.equalsIgnoreCase(Taskid)) {
					return true;
				}
			}
			return false;
		}
	
	}



