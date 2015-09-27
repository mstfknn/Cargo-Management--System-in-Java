package Package;

public class Price {
	public static int Price(double volume, double weight){

		int fee = 0;
		if(volume >= 1 && volume <= 5)
		{
			if(weight >= 1 && weight <= 5)
				fee = 5;
			else if (weight >= 6 && weight <= 10)
				fee = 6;
			else if (weight >= 11 && weight <= 15)
				fee = 7;
			else if (weight >= 16 && weight <= 20)
				fee = 8;
		}

		else if(volume >= 6 && volume <= 10)
		{
			if(weight >= 1 && weight <= 5)
				fee = 10;
			else if (weight >= 6 && weight <= 10)
				fee = 11;
			else if (weight >= 11 && weight <= 15)
				fee = 12;
			else if (weight >= 16 && weight <= 20)
				fee = 13;
		}

		else if(volume >= 11 && volume <= 15)
		{
			if(weight >= 1 && weight <= 5)
				fee = 15;
			else if (weight >= 6 && weight <= 10)
				fee = 16;
			else if (weight >= 11 && weight <= 15)
				fee = 17;
			else if (weight >= 16 && weight <= 20)
				fee = 18;
		}

		else if(volume >= 16 && volume <= 20)
		{
			if(weight >= 1 && weight <= 5)
				fee = 20;
			else if (weight >= 6 && weight <= 10)
				fee = 21;
			else if (weight >= 11 && weight <= 15)
				fee = 22;
			else if (weight >= 16 && weight <= 20)
				fee = 23;
		}
		return fee;
	}
}
