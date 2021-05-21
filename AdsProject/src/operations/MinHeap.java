//package operations;
//import java.io.IOException;
//import java.util.Arrays;
//
//
//public class MinHeap 
//{ 
//	
//	static int gt = 0;
//	static int node[][] = new int[2000][3];
//	static int cur = 1;
//	private static int maxsize = 2000;
//	static String line;
//	static String next;
//	
//	public int[] print(int x) throws IOException 
//	{
//		//wr.write("Yash");
//		int result[] = new int[4];
//		for(int o=0;o<=cur;o++)
//		{
//			if(node[o][0] == x)
//			{
//				System.out.println(node[o][0] + " " + node[o][1] + " " + node[o][2] + " " + gt);
//				result[0] = node[o][0];
//				result[1] = node[o][1];
//				result[2] = node[o][2];
//				result[3] = gt;
//			}
//		}
//		return result;
//		
//	}
//
//
//	private static int leftChild(int pos) 
//    { 
//        return (2 * pos) + 1; 
//    } 
//  
// 
//    private static int rightChild(int pos) 
//    { 
//        return (2 * pos) + 2; 
//    } 
//  
//     
//    private static boolean isLeaf(int pos) 
//    { 
//        if (node[pos * 2 + 1][0] == 0) { 
//            return true; 
//        } 
//        return false; 
//    } 
//    
//    private static void swap(int fpos, int spos) 
//    { 
//        int temp0, temp1, temp2;
//        
//        temp0 = node[fpos][0]; 
//        node[fpos][0] = node[spos][0]; 
//        node[spos][0] = temp0;
//        
//        temp1 = node[fpos][1]; 
//        node[fpos][1] = node[spos][1]; 
//        node[spos][1] = temp1;
//        
//        temp2 = node[fpos][2]; 
//        node[fpos][2] = node[spos][2]; 
//        node[spos][2] = temp2;
//    } 
//    
//
//	public void heapify(int pos) 
//	{
//		if (!isLeaf(pos)) 
//		{
//			
//			if(node[2*pos + 2][0] != 0)
//			{
//	            if (node[pos][1] > node[leftChild(pos)][1] 
//	                || node[pos][1] > node[rightChild(pos)][1]) 
//	            { 
//	            		
//	                if (node[leftChild(pos)][1] < node[rightChild(pos)][1]) 
//	                { 
//	                    swap(pos, leftChild(pos)); 
//	                    heapify(leftChild(pos)); 
//	                } 
//	  
//	                else if(node[leftChild(pos)][1] > node[rightChild(pos)][1])
//	                { 
//	                    swap(pos, rightChild(pos)); 
//	                    heapify(rightChild(pos)); 
//	                }
//	                else
//	                {
//	                	if(node[leftChild(pos)][0] < node[rightChild(pos)][0])
//	                	{
//	                		swap(pos, leftChild(pos)); 
//		                    heapify(leftChild(pos));
//	                	}
//	                	else
//	                	{
//	                		swap(pos, rightChild(pos)); 
//		                    heapify(rightChild(pos));
//	                	}
//	                }
//	            }
//	            else if(node[pos][1] == node[leftChild(pos)][1] || node[pos][1] == node[rightChild(pos)][1])
//	            {
//	            	
//	            	if(node[pos][1] == node[leftChild(pos)][1] && node[pos][1] != node[rightChild(pos)][1])
//	            	{
//	            		if(node[pos][0] > node[leftChild(pos)][0])
//		            	{
//		            		swap(pos, leftChild(pos)); 
//		                    heapify(leftChild(pos));
//		            	}
//	            	}
//	            	else if(node[pos][1] != node[leftChild(pos)][1] && node[pos][1] == node[rightChild(pos)][1])
//	            	{
//	            		if(node[pos][0] > node[rightChild(pos)][0])
//		            	{
//		            		swap(pos, rightChild(pos)); 
//		                    heapify(rightChild(pos));
//		            	}
//	            	}
//	            	else if(node[pos][1] == node[leftChild(pos)][1] && node[pos][1] == node[rightChild(pos)][1])
//	            	{
//	            		int x = Math.min(node[pos][0], Math.min(node[leftChild(pos)][0], node[rightChild(pos)][0]));
//		            	if(x == node[leftChild(pos)][0])
//		            	{
//		            		swap(pos, leftChild(pos)); 
//		                    heapify(leftChild(pos));
//		            	}
//		            	else if(x == node[rightChild(pos)][0])
//		            	{
//		            		swap(pos, rightChild(pos)); 
//		                    heapify(rightChild(pos));
//		            	}
//	            	}
//	            	
//	            	
//	            	
//	            	
//	            	//System.out.println("When node is equal to children.." + node[0][0] + " " + node[0][1] + " " + node[0][2] + " " + gt);
//	            	
//	            	
//	            }
//			}
//	            	        
//			
//			else
//			{
//				if(node[pos][1] > node[leftChild(pos)][1])
//					swap(pos, leftChild(pos));
//				else if(node[pos][1] == node[leftChild(pos)][1])
//				{
//					if(node[pos][0] > node[leftChild(pos)][0])
//						swap(pos, leftChild(pos));
//				}
//			}
//        } 
//		
//		//System.out.println("Heapify - " + node[0][0] + " " + node[0][1] + " " + node[0][2] + " " + gt);
//	}
//
//
//	private static int parent(int pos) 
//    { 
//        return pos / 2; 
//    }
//	
//	public void insert_mh() 
//	{
//		
//		if (cur >= maxsize) { 
//            return; 
//        } 
//		node[cur][0] = Integer.parseInt(next.split(":")[1].split("\\(")[1].split(",")[0]);
//        node[cur][1] = 0; 
//        node[cur][2] = Integer.parseInt(next.split(":")[1].split("\\(")[1].split(",")[1].split("\\)")[0]);
//        int current = cur; 
//  
//        while (node[current][1] < node[parent(current)][1]) 
//        {
//        	if(node[current][1] == node[parent(current)][1])
//        	{
//        		swap(current, parent(current)); 
//                current = parent(current); 
//        	}
//            swap(current, parent(current)); 
//            current = parent(current); 
//        }
//		
//		
////		node[cur][0] = Integer.parseInt(next.split(":")[1].split("\\(")[1].split(",")[0]);
////		node[cur][1] = 0;
////		node[cur][2] = Integer.parseInt(next.split(":")[1].split("\\(")[1].split(",")[1].split("\\)")[0]);
//		//System.out.println(node[cur][0] + " " + node[cur][2]);
//		cur++;
//		//System.out.println("Cur = " + cur);
//	}
//	
//	public void remove() 
//    { 
//        //int popped = node[0][1];
//		if(cur>0)
//		{
//			node[0][0] = node[cur-1][0];
//	        node[0][1] = node[cur-1][1];
//	        node[0][2] = node[cur-1][2];
//	        node[cur-1][0] = 0;
//	        node[cur-1][1] = 0;
//	        node[cur-1][2] = 0;
//	        cur--;
//	        //System.out.println("Curi = " + cur);
//	        heapify(0);
//		}
//		else
//		{
//			System.out.println(node[0][0] + " " + node[0][1] + " " + node[0][2]);
//			node[0][0] = 0;
//		}
//        //return popped; 
//    }
//	
//    
//    
//  
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
///*
//package operations;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class Jugad {
//
//	
//	static int gt = 0;
//	
//
//	static int node[][] = new int[2000][3];
//	
//	static int cur = 1;
//	private static int maxsize = 2000;
//	static String line;
//	static String next;
//
//	public static void main(String[] args) throws NumberFormatException, IOException 
//	{
//		File file = new File("input.txt");
//		BufferedReader br = new BufferedReader(new FileReader(file));
//		
//		line = br.readLine();
//		
//		for(int i=0;i<2000;i++)
//			node[i][0] = 0;
//		
//		node[0][0] = Integer.parseInt(line.split(":")[1].split("\\(")[1].split(",")[0]);
//		node[0][1] = 0;
//		node[0][2] = Integer.parseInt(line.split(":")[1].split("\\(")[1].split(",")[1].split("\\)")[0]);
//		
//		//System.out.println(node[0][0] + " " + node[0][2]);
//		next = br.readLine();
//		int i=0;
//		while(node[0][0] != 0 && next!=null)
//		{
//			if(node[0][2] - node[0][1] > 5)
//			{
//				gt += 5;
//				node[0][1] += 5;
//				
//			}
//			else
//			{
//				gt += node[0][2] - node[0][1];
//				node[0][1] += node[0][2] - node[0][1];
//				
//				print(node[0][0]);
//				remove();
//			}
//			//System.out.println(i);
//			//next = br.readLine();
//			while(next != null && Integer.parseInt(next.split(":")[0]) <= gt)
//			{
//				if(next.contains("Print"))
//				{
//					if(next.contains(","))
//					{
//						
//					}
//					else
//					{
//						//pass the building number for printing
//						print(Integer.parseInt(next.split(":")[1].split("\\(")[1].split(",")[0].split("\\)")[0]));
//					}
//					
//					next = br.readLine();
//				}
//				else if(next.contains("Insert"))
//				{
//					//System.out.println("In Insert " + i);
//					insert_mh();
//					//System.out.println("inserted " + node[cur-1][0]);
//					insert_rb();
//					//heapify();
//					next = br.readLine();
//				}
//			}
//			//System.out.println("hhh " + node[0][0] + " " + node[0][1] + " " + node[0][2]);
//			heapify(0);
//			i++;
//		}
//		
//		
//	}
//	
//	
//	private static void print(int x) 
//	{
//		for(int o=0;o<=cur;o++)
//		{
//			if(node[o][0] == x)
//				System.out.println(node[o][0] + " " + node[o][1] + " " + node[o][2] + " " + gt);
//		}
//			
//	}
//
//
//	private static int leftChild(int pos) 
//    { 
//        return (2 * pos); 
//    } 
//  
// 
//    private static int rightChild(int pos) 
//    { 
//        return (2 * pos) + 1; 
//    } 
//  
//     
//    private static boolean isLeaf(int pos) 
//    { 
//        if (pos >= (cur-1 / 2) && pos <= cur-1) { 
//            return true; 
//        } 
//        return false; 
//    } 
//    
//    private static void swap(int fpos, int spos) 
//    { 
//        int temp0, temp1, temp2;
//        
//        temp0 = node[fpos][0]; 
//        node[fpos][0] = node[spos][0]; 
//        node[spos][0] = temp0;
//        
//        temp1 = node[fpos][1]; 
//        node[fpos][1] = node[spos][1]; 
//        node[spos][1] = temp1;
//        
//        temp2 = node[fpos][2]; 
//        node[fpos][2] = node[spos][2]; 
//        node[spos][2] = temp2;
//    } 
//    
//
//	public static void heapify(int pos) 
//	{
//		if (!isLeaf(pos)) 
//		{
//			
//			if(degree(pos) == 2)
//			{
//	            if (node[pos][1] > node[leftChild(pos)][1] 
//	                || node[pos][1] > node[rightChild(pos)][1]) 
//	            { 
//	            		
//	                if (node[leftChild(pos)][1] < node[rightChild(pos)][1]) 
//	                { 
//	                    swap(pos, leftChild(pos)); 
//	                    heapify(leftChild(pos)); 
//	                } 
//	  
//	                else //if(node[leftChild(pos)][1] > node[rightChild(pos)][1])
//	                { 
//	                    swap(pos, rightChild(pos)); 
//	                    heapify(rightChild(pos)); 
//	                }
////	                else if(node[leftChild(pos)][1] == node[rightChild(pos)][1])
////	                {
////	                	if(node[leftChild(pos)][0] < node[rightChild(pos)][0])
////	                	{
////	                		swap(pos, leftChild(pos)); 
////		                    heapify(leftChild(pos));
////	                	}
////	                	else
////	                	{
////	                		swap(pos, rightChild(pos)); 
////		                    heapify(rightChild(pos));
////	                	}
////	                }
//	            }
//			}
//			else
//			{
//				swap(pos, leftChild(pos)); 
//			}
//		}
//		
//		
//		/*if (!isLeaf(pos)) 
//		{
//			
//			if(degree(pos) == 2)
//			{
//	            if (node[pos][1] > node[leftChild(pos)][1] 
//	                || node[pos][1] > node[rightChild(pos)][1]) 
//	            { 
//	            		
//	                if (node[leftChild(pos)][1] < node[rightChild(pos)][1]) 
//	                { 
//	                    swap(pos, leftChild(pos)); 
//	                    heapify(leftChild(pos)); 
//	                } 
//	  
//	                else if(node[leftChild(pos)][1] > node[rightChild(pos)][1])
//	                { 
//	                    swap(pos, rightChild(pos)); 
//	                    heapify(rightChild(pos)); 
//	                }
//	                else
//	                {
//	                	if(node[leftChild(pos)][0] < node[rightChild(pos)][0])
//	                	{
//	                		swap(pos, leftChild(pos)); 
//		                    heapify(leftChild(pos));
//	                	}
//	                	else
//	                	{
//	                		swap(pos, rightChild(pos)); 
//		                    heapify(rightChild(pos));
//	                	}
//	                }
//	            }
//	            else if(node[pos][1] == node[leftChild(pos)][1] && node[pos][1] == node[rightChild(pos)][1])
//	            {
//	            	int x = Math.min(node[pos][0], Math.min(node[leftChild(pos)][0], node[rightChild(pos)][0]));
//	            	if(x == node[leftChild(pos)][0])
//	            	{
//	            		swap(pos, leftChild(pos)); 
//	                    heapify(leftChild(pos));
//	            	}
//	            	else if(x == node[rightChild(pos)][0])
//	            	{
//	            		swap(pos, rightChild(pos)); 
//	                    heapify(rightChild(pos));
//	            	}
//	            	
//	            }
//			}
//	            	    
//			
//			else
//			{
//				swap(pos, leftChild(pos)); 
//			}
//        } */
//		
//		
////		int i, j;  
////	    for (i = 0; i < cur-1; i++)      
////	    { 
////		    // Last i elements are already in place  
////		    for (j = 0; j < cur-i-1; j++)  
////		    {
////		    	if (node[j][1] > node[j+1][1])  
////		            swap(j, j+1);
////		    	else if(node[j][1] == node[j+1][1])
////		    	{
////		    		if(node[j][0] > node[j+1][0])
////		    			swap(j, j+1);
////		    	}
////		    }
////		    
////	    }
///*		
//	}
//
//	private static int degree(int pos) 
//	{
//		if(node[pos][0]*2 + 2 == 0)
//			return 1;
//		else
//			return 0;
//		
//	}
//
//
//	private static int parent(int pos) 
//    { 
//        return pos / 2; 
//    }
//	
//	public static void insert_mh() 
//	{
//		
//		if (cur >= maxsize) { 
//            return; 
//        } 
//		node[cur][0] = Integer.parseInt(next.split(":")[1].split("\\(")[1].split(",")[0]);
//        node[cur][1] = 0; 
//        node[cur][2] = Integer.parseInt(next.split(":")[1].split("\\(")[1].split(",")[1].split("\\)")[0]);
//        int current = cur; 
//  
//        while (node[current][1] < node[parent(current)][1]) 
//        {
//        	if(node[current][1] == node[parent(current)][1])
//        	{
//        		swap(current, parent(current)); 
//                current = parent(current); 
//        	}
//            swap(current, parent(current)); 
//            current = parent(current); 
//        }
//		
//		
////		node[cur][0] = Integer.parseInt(next.split(":")[1].split("\\(")[1].split(",")[0]);
////		node[cur][1] = 0;
////		node[cur][2] = Integer.parseInt(next.split(":")[1].split("\\(")[1].split(",")[1].split("\\)")[0]);
//		//System.out.println(node[cur][0] + " " + node[cur][2]);
//		cur++;
//		//System.out.println("Cur = " + cur);
//	}
//	
//	public static void remove() 
//    { 
//        //int popped = node[0][1];
//		if(cur>0)
//		{
//			node[0][0] = node[cur-1][0];
//	        node[0][1] = node[cur-1][1];
//	        node[0][2] = node[cur-1][2];
//	        cur--;
//	        //System.out.println("Curi = " + cur);
//	        heapify(0);
//		}
//		else
//		{
//			System.out.println(node[0][0] + " " + node[0][1] + " " + node[0][2]);
//			node[0][0] = 0;
//		}
//        //return popped; 
//    }
//	
//	public static void insert_rb()
//	{
//		
//	}
//
//}
//*/