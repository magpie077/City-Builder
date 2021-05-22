import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class risingCity {

	
	static int gt = 0, flag=0;
	static int node[][] = new int[2000][3];
	//Building numbers (bn) = node[i][0]
	//Executed time (et) = node[i][1]
	//Total time (tt) = node[i][2]
	static int cur = 1;
	private static int maxsize = 2000;
	static String line;
	static String next;

	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		File file = new File(args[0]);
		BufferedReader br = new BufferedReader(new FileReader(file));
		BufferedWriter wr = new BufferedWriter(new FileWriter("‎⁨⁨output_file.txt"));

		line = br.readLine();		
		
		//initializing all building numbers to 0

		for(int i=0;i<2000;i++)
			node[i][0] = 0;
		


		node[0][0] = Integer.parseInt(line.split(":")[1].split("\\(")[1].split(",")[0]);
		node[0][1] = 0;
		node[0][2] = Integer.parseInt(line.split(":")[1].split("\\(")[1].split(",")[1].split("\\)")[0]);
		

		next = br.readLine();
		int i=0;

		//condition for while: till the min heap does not become empty, i.e, node[0][0]!=0
		while(node[0][0] != 0)
		{

			if(node[0][2] - node[0][1] > 5)   // tt - et > 5
			{
				gt += 5;
				node[0][1] += 5;
				
			}
			else
			{
				gt += node[0][2] - node[0][1];
				node[0][1] += node[0][2] - node[0][1];
				
				print(node[0][0], wr);
				flag =1;
			}
			
			//while the counter for nextline is less than the global counter
			while(next != null && Integer.parseInt(next.split(":")[0]) <= gt)
			{
				if(next.contains("Print"))
				{
					if(next.contains(","))
					{
						int arg1 = Integer.parseInt(next.split(":")[1].split("\\(")[1].split(",")[0]);//.split("\\)")[0]);
						int arg2 = Integer.parseInt(next.split(":")[1].split("\\(")[1].split(",")[1].split("\\)")[0]);
						int temp = Integer.parseInt(next.split(":")[0]);
						
						print2(arg1, arg2, temp, wr);
					}
					else
					{
						//pass the building number for printing
						print1(Integer.parseInt(next.split(":")[1].split("\\(")[1].split(",")[0].split("\\)")[0]), Integer.parseInt(next.split(":")[0]), wr);
					}
					
					next = br.readLine();
				}
				else if(next.contains("Insert"))
				{
					insert_mh();
					
					next = br.readLine();
				}
			}
			if(flag == 1)
			{
				remove();
				flag=0;
			}
			heapify(0);
			i++;
		}
	
		wr.close();

		
	}
	

//==================== Function for Print(x,y) ======================
	public static void print2(int arg1, int arg2, int counter, BufferedWriter wr) throws IOException
	{
		for(int o=0;o<=cur;o++)
		{
			if(node[o][0]>=arg1 && node[o][0]<=arg2)
			{
				if(node[o][0] == node[0][0])
				{
					int temp = node[0][1] - gt + counter;
					if(temp>0)
					{
						//System.out.println("(" + node[0][0] + ", " + temp + ", " + node[0][2] + ") ");
						wr.write("(" + node[0][0] + ", " + temp + ", " + node[0][2] + ") ");
					}
					else
					{
						//System.out.println("(" + node[0][0] + " " + 0 + " " + node[0][2] + ") ");
						wr.write("(" + node[0][0] + ", " + 0 + ", " + node[0][2] + ") ");

					}
				}
				else
				{
					//System.out.println(node[o][0] + " " + node[o][1] + " " + node[o][2]);
					wr.write("(" + node[o][0] + ", " + node[o][1] + ", " + node[o][2] + ") ");
				}
			}
		}
		wr.newLine();
	}
	
	
//===================== Function for Print(x) =======================
	public static void print1(int x, int counter, BufferedWriter wr) throws IOException
	{
		if(x != node[0][0])
		{
			for(int o=0;o<=cur;o++)
			{
				if(node[o][0] == x)
				{
					//System.out.println(node[o][0] + " " + node[o][1] + " " + node[o][2]);
					wr.write("(" + node[o][0] + ", " + node[o][1] + ", " + node[o][2] + ") ");
					wr.newLine();
				}
			}
		}
		else
		{
			int temp = node[0][1] - gt + counter;
			if(temp>0)
			{
				//System.out.println(node[0][0] + " " + temp + " " + node[0][2]);
				wr.write("(" + node[0][0] + ", " + temp + ", " + node[0][2] + ") ");
				wr.newLine();
			}
			else
			{
				//System.out.println(node[0][0] + " " + 0 + " " + node[0][2]);
				wr.write("(" + node[0][0] + ", " + 0 + ", " + node[0][2] + ") ");
				wr.newLine();
			}
		}
	}
	
//=============== Function to print when the city is finished ===============
	public static int[] print(int x, BufferedWriter wr) throws IOException 
	{
		int result[] = new int[4];
		for(int o=0;o<=cur;o++)
		{
			if(node[o][0] == x)
			{
				System.out.println(node[o][0] + " " + gt);
				wr.write("(" + node[o][0] + ", " + gt + ") ");
				wr.newLine();
				result[0] = node[o][0];
				result[1] = node[o][1];
				result[2] = node[o][2];
				result[3] = gt;
			}
		}
		return result;
		
	}

//===================================== FUNCTIONS FOR MIN-HEAP =====================================


	//returns left child of a node
	private static int leftChild(int pos) 
    { 
        return (2 * pos) + 1; 
    } 
  
 	//returns right child of a node
    private static int rightChild(int pos) 
    { 
        return (2 * pos) + 2; 
    } 
  
    //checks is the node is a leaf node 
    private static boolean isLeaf(int pos) 
    { 
        if (node[pos * 2 + 1][0] == 0) { 
            return true; 
        } 
        return false; 
    } 
    

    //swaps 2 nodes
    private static void swap(int fpos, int spos) 
    { 
        int temp0, temp1, temp2;
        
        temp0 = node[fpos][0]; 
        node[fpos][0] = node[spos][0]; 
        node[spos][0] = temp0;
        
        temp1 = node[fpos][1]; 
        node[fpos][1] = node[spos][1]; 
        node[spos][1] = temp1;
        
        temp2 = node[fpos][2]; 
        node[fpos][2] = node[spos][2]; 
        node[spos][2] = temp2;
    } 
    
    //min-heapifies the full tree
	public static void heapify(int pos) 
	{
		if (!isLeaf(pos)) 
		{
			
			if(node[2*pos + 2][0] != 0)
			{
	            if (node[pos][1] > node[leftChild(pos)][1] 
	                || node[pos][1] > node[rightChild(pos)][1]) 
	            { 
	            		
	                if (node[leftChild(pos)][1] < node[rightChild(pos)][1]) 
	                { 
	                    swap(pos, leftChild(pos)); 
	                    heapify(leftChild(pos)); 
	                } 
	  
	                else if(node[leftChild(pos)][1] > node[rightChild(pos)][1])
	                { 
	                    swap(pos, rightChild(pos)); 
	                    heapify(rightChild(pos)); 
	                }
	                else
	                {
	                	if(node[leftChild(pos)][0] < node[rightChild(pos)][0])
	                	{
	                		swap(pos, leftChild(pos)); 
		                    heapify(leftChild(pos));
	                	}
	                	else
	                	{
	                		swap(pos, rightChild(pos)); 
		                    heapify(rightChild(pos));
	                	}
	                }
	            }
	            else if(node[pos][1] == node[leftChild(pos)][1] || node[pos][1] == node[rightChild(pos)][1])
	            {
	            	
	            	if(node[pos][1] == node[leftChild(pos)][1] && node[pos][1] != node[rightChild(pos)][1])
	            	{
	            		if(node[pos][0] > node[leftChild(pos)][0])
		            	{
		            		swap(pos, leftChild(pos)); 
		                    heapify(leftChild(pos));
		            	}
	            	}
	            	else if(node[pos][1] != node[leftChild(pos)][1] && node[pos][1] == node[rightChild(pos)][1])
	            	{
	            		if(node[pos][0] > node[rightChild(pos)][0])
		            	{
		            		swap(pos, rightChild(pos)); 
		                    heapify(rightChild(pos));
		            	}
	            	}
	            	else if(node[pos][1] == node[leftChild(pos)][1] && node[pos][1] == node[rightChild(pos)][1])
	            	{
	            		int x = Math.min(node[pos][0], Math.min(node[leftChild(pos)][0], node[rightChild(pos)][0]));
		            	if(x == node[leftChild(pos)][0])
		            	{
		            		swap(pos, leftChild(pos)); 
		                    heapify(leftChild(pos));
		            	}
		            	else if(x == node[rightChild(pos)][0])
		            	{
		            		swap(pos, rightChild(pos)); 
		                    heapify(rightChild(pos));
		            	}
	            	}
	            	
	            }
			}
	            	        
			
			else
			{
				if(node[pos][1] > node[leftChild(pos)][1])
					swap(pos, leftChild(pos));
				else if(node[pos][1] == node[leftChild(pos)][1])
				{
					if(node[pos][0] > node[leftChild(pos)][0])
						swap(pos, leftChild(pos));
				}
			}
        } 	
	}

	//returns the parent of a node
	private static int parent(int pos) 
    { 
        return pos / 2; 
    }
	

	//inserts into the min heap
	public static void insert_mh() 
	{
		
		if (cur >= maxsize) { 
            return; 
        } 
		node[cur][0] = Integer.parseInt(next.split(":")[1].split("\\(")[1].split(",")[0]);
        node[cur][1] = 0; 
        node[cur][2] = Integer.parseInt(next.split(":")[1].split("\\(")[1].split(",")[1].split("\\)")[0]);
        int current = cur; 
  
        while (node[current][1] < node[parent(current)][1]) 
        {
        	if(node[current][1] == node[parent(current)][1])
        	{
        		swap(current, parent(current)); 
                current = parent(current); 
        	}
            swap(current, parent(current)); 
            current = parent(current); 
        }
		
		cur++;
	}
	

	//removes from the min heap
	public static void remove() 
    { 
		if(cur>0)
		{
			node[0][0] = node[cur-1][0];
	        node[0][1] = node[cur-1][1];
	        node[0][2] = node[cur-1][2];
	        node[cur-1][0] = 0;
	        node[cur-1][1] = 0;
	        node[cur-1][2] = 0;
	        cur--;
	        heapify(0);
		}
		else
		{
			System.out.println(node[0][0] + " " + node[0][1] + " " + node[0][2]);
			node[0][0] = 0;
		}
    }


//=============================== MIN-HEAP FUNCTIONS OVER ==================================	

}
