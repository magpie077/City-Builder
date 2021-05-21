package operations;

class Operate 
{
	private int buildingNum;
	private int executedTime;
	private int totalTime;
	
	Operate(int buildingNum, int executedTime, int totalTime)
	{
		this.buildingNum = buildingNum;
		this.executedTime = executedTime;
		this.totalTime = totalTime;
			
	}
	
	public void print(int buildingNum3)
	{
		/*buildingNum = buildingNum;*/
		System.out.println(this.buildingNum + ", " + this.executedTime + ", " + this.totalTime);
	}
	
	public void print(int buildingNum1, int buildingNum2)
	{
		buildingNum1 = 12;
		buildingNum2 = 13;
		System.out.println(buildingNum1 + " " + buildingNum2);
	}
	
}	

