//package operations;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class NewCity 
//{
//
//	public static void main(String[] args) throws Exception 
//	{
//		Operate o1 = new Operate(0, 0, 0);
//		//o1.print(1, 2);
//		//o1.print(4);
//		
//		Jugad j1 = new Jugad();
//		//MinHeap m1 = new MinHeap();
//		
//		
//		int global_timer = 0;
//		File file = new File("input.txt");
//		BufferedReader br = new BufferedReader(new FileReader(file));
//		
//		String st, line;
//		
//		line = br.readLine();
//		int timer = 0;// = Integer.parseInt(line.split(":")[0]);
//		
//		//global_timer = split_first_line_timer;
//		
//		while((st = br.readLine()) != null)
//		{
//			
//			
//			String[] split_st = st.split(":");
//			if(Integer.parseInt(split_st[0]) == timer)
//			{
//				//System.out.println("hello\n" + split_st[0]);
//				if(split_st[1].contains("Insert"))
//				{
//					int arg1, arg2;
//					arg1 = Integer.parseInt(split_st[1].split("\\(")[1].split(",")[0]);
//					arg2 = Integer.parseInt(split_st[1].split("\\(")[1].split(",")[1].split("\\)")[0]);
//					
//					m1.min_heap_insert(arg1, arg2);
//				}
//				
//				else if(split_st[1].contains("Print") && split_st[1].contains(","))
//				{
//					
//				}
//				
//				else
//				{
//					
//				}
//				
//				global_timer++;
//			}
//			else
//			{
//				m1.just_continue();
//			}
//			
//			
//		}
//
//	}
//}
