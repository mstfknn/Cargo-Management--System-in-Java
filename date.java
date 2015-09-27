package Package;

public class date {
	int[] MonthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public static int day=1;
	public static int month=1;
	public static int year=2015;

	date(){
		
		System.out.println("-----------------------------------"+day+"/"+month+"/"+year+"-----------------------------------");
		
		if(month==1)
		{
			if(day==MonthArray[0])
			{
				day=1;
				month++;
			}
			else
			{
				day++;
			}
		}
		else if(month==2)
		{
			if(day==MonthArray[1])
			{
				day=1;
				month++;
			}
			else
			{
				day++;
			}
		}
		else if(month==3)
		{
			if(day==MonthArray[2])
			{
				day=1;
				month++;
			}
			else
			{
				day++;
			}
		}
		else if(month==4)
		{
			if(day==MonthArray[3])
			{
				day=1;
				month++;
			}
			else
			{
				day++;
			}
		}
		else if(month==5)
		{
			if(day==MonthArray[4])
			{
				day=1;
				month++;
			}
			else
			{
				day++;
			}
		}
		else if(month==6)
		{
			if(day==MonthArray[5])
			{
				day=1;
				month++;
			}
			else
			{
				day++;
			}
		}
		else if(month==7)
		{
			if(day==MonthArray[6])
			{
				day=1;
				month++;
			}
			else
			{
				day++;
			}
		}
		else if(month==8)
		{
			if(day==MonthArray[7])
			{
				day=1;
				month++;
			}
			else
			{
				day++;
			}
		}
		else if(month==9)
		{
			if(day==MonthArray[8])
			{
				day=1;
				month++;
			}
			else
			{
				day++;
			}
		}
		else if(month==10)
		{
			if(day==MonthArray[9])
			{
				day=1;
				month++;
			}
			else
			{
				day++;
			}
		}
		else if(month==11)
		{
			if(day==MonthArray[10])
			{
				day=1;
				month++;
			}
			else
			{
				day++;
			}
		}
		else if(month==12)
		{
			if(day==MonthArray[11])
			{
				day=1;
				month=1;
				year++;
			}
			else
			{
				day++;
			}
		}


	}
}

