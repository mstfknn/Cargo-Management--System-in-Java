package Package;

import enigma.core.Enigma;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;


public class Management {
	public static enigma.console.Console cn = Enigma.getConsole("");
	public static Stuff[] Stuffs = new Stuff[100];
	public static Container[] containerIzmir  = new Container[100];
	public static Container[] containerAnkara  = new Container[100];
	public static int[] containerVolumeIzmir = new int[100];
	public static int[] containerVolumeAnkara = new int[100];
	static int[] containerVolume = new int[100];
	public static String[] words = null;
	public static int[] cargoIzmýr = new int[1000];
	public static int[] cargoAnkara = new int[1000];
	public static int counter=0;
	public static int counterIzmir=0;
	public static int counterAnkara=0;
	public static Cargo[] sentCargoes=new Cargo[1000];
	public static int numberofCargoesIzmir=0;
	public static int numberofCargoesAnkara=0;
	public static int numberofContainerIzmir=0;
	public static int numberofContainerAnkara=0;
	public static int dayIzmir = 1;
	public static int dayAnkara = 1;
	public static int sumOfOldCargoesVolumeIzmir=0;
	public static int sumOfOldCargoesVolumeAnkara=0;
	public static int Ankaracounter=2;
	public static int Izmircounter=2;
	public static int CityHolder = 0;
	public static int[] controlVolumeIzmir = new int[100];//yollanacak kontainer dolu mu
	public static int[] controlVolumeAnkara = new int[100];
	public static int controlVolumeNo=0;
	static Cargo cargo = new Cargo();
	static Stuff stuff = new Stuff();

	public static void Screen()
	{
		System.out.println("Commands Lists");
		System.out.println("Stuff add office city Name Surname		  | Cargo add from to volume Weight");
		System.out.println("Stuff add driver startcity Name Surname	 | Cargo List");
		System.out.println("Stuff List								  | Cargo List from to date1 date2");
		System.out.println("Stuff Del ID						        |");
		System.out.println("										    |");
		System.out.println("Container add startcity volume licence_plate| Load Filename");
		System.out.println("Container list							  |");
		System.out.println("Container del ID							| Next Day");
	}

	public static void Command() throws IOException{

		Scanner scn = new Scanner(System.in);
		String input = scn.nextLine();
		input = input.toLowerCase();

		words = input.split(" ");
		Stuff stuff = new Stuff();
		Cargo cargo = new Cargo();
		Container container = new Container();

		if(words[0].equals("stuff"))
		{
			if(words[1].equals("add"))
			{
				for(int i = 5 ; i<words.length;i++)
				{ 
					words[4] +=" "+words[i];
				}
				addStuff(new Stuff(Stuff.getID(),words[2], words[3], words[4]));
			}
			else if(words[1].equals("del"))
			{				
				int del = Integer.parseInt(words[2]);
				delStuff(del);
			}
			else if(words[1].equals("list"))
			{
				for(int i = 0 ; i<Stuff.numberOfStuffs; i++)
				{
					if(Stuff.Stuffs[i]!=null)
					{
						System.out.println(Management.displayStuff(i));
					}
				}
			}
		}

		else if(words[0].equals("cargo"))
		{

			if(words[1].equals("add"))
			{ 	  
				addCargo(new Cargo(words[2],words[3],Double.parseDouble(words[4]),Double.parseDouble(words[5]),cargo.ID+1));			  
			}
			else if(words[1].equals("list"))
			{
				for(int i = 0 ; i<Cargo.numberofCargoes; i++)
				{
					displayCargo(i);
				}
			}
		}
		else if (words[0].equals("container"))
		{
			if(words[1].equals("add"))
			{
				if(words[2].equals("izmir"))
				{
					System.out.println();
					addContainer(new Container(words[2],Integer.parseInt(words[3]),words[4], (Container.IDIzmir),false));
					}
				else if(words[2].equals("ankara"))
				{
					System.out.println();
					addContainer(new Container(words[2],Integer.parseInt(words[3]),words[4], (Container.IDAnkara),false));
					}
			}
			else if(words[1].equals("list"))
			{
				for(int i = 0 ; i<container.numberofContainer/4;i++)
				{
						displayContainer();
					
				}
				
			}
		}
		/*else if(words[1].equals("del"))
			{
				int del = Integer.parseInt(words[2]);
				delContainer(del);
			}*/



		else if (words[0].equals("read"))
		{
			if(words[1].equals("cng1"))
				Fileop(words[1]);
		}
		else if (words[0].equals("read"))
		{
			if(words[1].equals("cng2"))
				Fileop1(words[1]);
		}
		else if(words[0].equals("load"))
		{
			if(words[1].equals("cng1"))
			{
				LoadCng1();
			}
			/*else if(words[1].equals("cng2"))
			{
				LoadCng2();
			}*/
		}
		else if (words[0].equals("next"))
		{
			controlVolumeNo=0;
			if(dayIzmir==2)
			{
				for(int i =0; i<Izmircounter;i=i)
				{
					if(sumOfOldCargoesVolumeIzmir>20 && containerIzmir[i]!=null && containerIzmir[i].getVolume()==40 && controlVolumeIzmir[controlVolumeNo]>=containerIzmir[i].getVolume()/2){
						addContainer(new Container("ankara",containerIzmir[i].getVolume(),containerIzmir[i].getLicenceplate(), containerIzmir[i].getContainerID(),false));
						deleteContainerIzmir(i);
						Ankaracounter++;
						Izmircounter--;
						controlVolumeNo++;
					}
					else if(((sumOfOldCargoesVolumeIzmir!=0 && sumOfOldCargoesVolumeIzmir<=20) || sumOfOldCargoesVolumeIzmir>40) && containerIzmir[i].getVolume()==20 && containerIzmir[i]!=null&& controlVolumeIzmir[controlVolumeNo]>0)
					{
						addContainer(new Container("ankara",containerIzmir[i].getVolume(),containerIzmir[i].getLicenceplate(), containerIzmir[i].getContainerID(),false));
						deleteContainerIzmir(i);
						Ankaracounter++;
						Izmircounter--;
						controlVolumeNo++;
					}
					else
					{
						i++;
						controlVolumeNo++;
					}
				}
				for (int i = 0; i < counterIzmir; i=i) {
					if(containerIzmir[i]!=null){
						deleteContainerIzmir(i);
						counterIzmir--;
					}
				}
				dayIzmir=1;
			}
			sumOfOldCargoesVolumeIzmir=0;
			for (int i = 0; i < numberofCargoesIzmir; i++) {
				sumOfOldCargoesVolumeIzmir += cargoIzmýr[i];
			}
			counter=counterIzmir;
			CityHolder = Izmircounter;
			NextDay.Bestfit(cargoIzmýr, containerVolumeIzmir);
			counterIzmir = counter;
			for (int i = 0; i < counter + CityHolder; i++) {
				for (int j2 = 0; j2 < Cargo.numberofCargoes; j2++) {
					if(NextDay.container[i][j2]!=0)
						controlVolumeIzmir[i]+=NextDay.container[i][j2];
				}
			}
			for (int i = 0; i < counter; i++) {
				addContainer(new Container("izmir",containerVolumeIzmir[i+Izmircounter],"35DEU"+i, (Container.IDIzmir),true));			
			}

			dayIzmir++;

			counter=counterAnkara;
			controlVolumeNo=0;
			if(dayAnkara==2)
			{
				for(int i =0; i<Ankaracounter;i=i)
				{

					if(sumOfOldCargoesVolumeAnkara>20 && containerAnkara[i]!=null && containerAnkara[i].getVolume()==40 && controlVolumeAnkara[controlVolumeNo]>=containerAnkara[i].getVolume()/2)
					{
						addContainer(new Container("izmir",containerAnkara[i].getVolume(),containerAnkara[i].getLicenceplate(), containerAnkara[i].getContainerID(),false));
						deleteContainerAnkara(i);
						Ankaracounter--;
						Izmircounter++;
						controlVolumeNo++;
					}
					else if((((sumOfOldCargoesVolumeAnkara!=0 && sumOfOldCargoesVolumeAnkara<=20) || sumOfOldCargoesVolumeAnkara>40) && containerAnkara[i].getVolume()==20) && containerAnkara[i]!=null && controlVolumeAnkara[controlVolumeNo]>0)
					{
						addContainer(new Container("izmir",containerAnkara[i].getVolume(),containerAnkara[i].getLicenceplate(), containerAnkara[i].getContainerID(),false));
						deleteContainerAnkara(i);
						Ankaracounter--;
						Izmircounter++;
						controlVolumeNo++;
					}
					else
						i++;
				}

				for (int i = 0; i < counterAnkara; i=i) {
					if(containerAnkara[i]!=null)
						deleteContainerAnkara(i);
					counterAnkara--;
				}
				dayAnkara=1;
			}

			System.out.println();

			sumOfOldCargoesVolumeAnkara=0;
			for (int i = 0; i < numberofCargoesAnkara; i++) {
				sumOfOldCargoesVolumeAnkara += cargoAnkara[i];
			}
			counter=counterAnkara;
			CityHolder = Ankaracounter;
			NextDay.Bestfit(cargoAnkara, containerVolumeAnkara);
			counterAnkara = counter;
			for (int i = 0; i < counter + CityHolder; i++) {
				for (int j2 = 0; j2 < Cargo.numberofCargoes; j2++) {
					if(NextDay.container[i][j2]!=0)
						controlVolumeAnkara[i]+=NextDay.container[i][j2];
				}
			}
			for (int i = 0; i < counter; i++) {
				addContainer(new Container("ankara",containerVolumeAnkara[i+Ankaracounter],"06DEU"+i, (container.IDAnkara),true));	
			}

			dayAnkara++;
		}
	}
	static void LoadCng1()
	{
		addContainer(new Container("izmir",40,"35ab24", (Container.IDIzmir),false));
		addContainer(new Container("izmir",20,"35ka17", (Container.IDIzmir),false));
		addContainer(new Container("ankara",40,"06ce65", (Container.IDIzmir),true));
		addContainer(new Container("ankara",20,"06yz49", (Container.IDIzmir),true));
		addStuff(new Stuff(stuff.getStuffID(),"office","izmir","veli yazar"));
		addStuff(new Stuff(stuff.getStuffID(),"driver","izmir","ahmet kaçar"));
		addStuff(new Stuff(stuff.getStuffID(),"driver","izmir","ozan kaçar"));
		addStuff(new Stuff(stuff.getStuffID(),"office","ankara","sami çizer"));
		addStuff(new Stuff(stuff.getStuffID(),"driver","ankara","mert samimi"));
		addStuff(new Stuff(stuff.getStuffID(),"driver","ankara","osman has"));
	}
	/*static void LoadCng2()
	{
		addCargo(new Cargo("izmir","ankara",11.0,7.0,cargo.getCargoID()));
		addCargo(new Cargo("izmir","ankara",16.0,3.0,cargo.getCargoID()));
		addCargo(new Cargo("izmir","ankara",6.0,12.0,cargo.getCargoID()));
		addCargo(new Cargo("izmir","ankara",19.0,20.0,cargo.getCargoID()));
		addCargo(new Cargo("ankara","izmir",11.0,7.0,cargo.getCargoID()));
		addCargo(new Cargo("izmir","ankara",6.0,17.0,cargo.getCargoID()));
		addCargo(new Cargo("izmir","ankara",15.0,8.0,cargo.getCargoID()));
		addCargo(new Cargo("ankara","izmir",4.0,7.0,cargo.getCargoID()));
		addCargo(new Cargo("ankara","izmir",14.0,12.0,cargo.getCargoID()));
		addCargo(new Cargo("ankara","izmir",5.0,13.0,cargo.getCargoID()));
	}*/
	static void displayCargo(int i)
	{
		Cargo car = Cargo.Cargoes[i];
		System.out.println(car.getCargoID()+".) "+ car.getCity() +" "+ car.getToCity()+" " + car.getVolume()+" "+car.getWeight());
	}

	static void addCargo(Cargo newCargo)
	{
		Cargo.Cargoes[Cargo.numberofCargoes] = newCargo;
		if(words[2].toString().equals("izmir") && words[3].toString().equals("ankara")){
			cargoIzmýr[numberofCargoesIzmir] = Integer.parseInt(words[4]);
			numberofCargoesIzmir++;
		}
		else if(words[2].toString().equals("ankara") && words[3].toString().equals("izmir")){
			cargoAnkara[numberofCargoesAnkara] = Integer.parseInt(words[4]);
			numberofCargoesAnkara++;
		}
		Cargo.numberofCargoes++;
		Cargo.ID++;
	}

	public static void displayContainer()
	{
		for (int j = 0; j < numberofContainerIzmir ; j++) {
			Container conIzmir = containerIzmir[j];
			System.out.println(conIzmir.getContainerID()+".) "+conIzmir.getCity()+" "+conIzmir.getVolume()+" "+conIzmir.getLicenceplate());
		}
		for (int j = 0; j < numberofContainerAnkara ; j++) {
			Container conAnkara = containerAnkara[j];
			System.out.println(conAnkara.getContainerID()+".) "+conAnkara.getCity()+" "+conAnkara.getVolume()+" "+conAnkara.getLicenceplate());
		}
	}


	static void addContainer(Container container)
	{
		if( container.getCity().equals("izmir")){
			containerIzmir[numberofContainerIzmir]=container;
			containerVolumeIzmir[numberofContainerIzmir] = container.getVolume();
			numberofContainerIzmir++;
			container.IDIzmir++; 
		}
		else if(container.getCity().equals("ankara")){
			containerAnkara[numberofContainerAnkara]=container;
			containerVolumeAnkara[numberofContainerAnkara] = container.getVolume();
			numberofContainerAnkara++;
			container.IDAnkara++; 
		}


		Container.numberofContainer++;

	}



	static void deleteContainerIzmir(int i)
	{    if(i==-1)
	{System.out.println("Invalid ID");}
	else {	
		for( i = i;i< numberofContainerIzmir;i++ )
		{ 
			containerIzmir[i] = containerIzmir[i+1];
		}
		numberofContainerIzmir--;
	}
	}

	static void deleteContainerAnkara(int i)
	{    if(i==-1)
	{System.out.println("Invalid ID");}
	else {	
		for( i = i;i<numberofContainerAnkara;i++)
		{ 
			containerAnkara[i] = containerAnkara[i+1];
		}
		numberofContainerAnkara--;
	}
	}

	static String displayStuff(int i)
	{ 
		Stuff s = Stuff.Stuffs[i];

		return s.getStuffID()+".) "+s.getJob()+" "+s.getCity()+" "
		+ s.getName()+" "; 

	}

	public static void addStuff(Stuff newStuff)
	{
		Stuff.Stuffs[Stuff.getNumberOfStuffs()] = newStuff;
		Stuff.numberOfStuffs++;
		Stuff.ID++;
	}

	public static void delStuff(int id)
	{
		try{
			Stuff.Stuffs[id-1] = null;
		}
		catch(Exception e)
		{
			System.out.println("Invalid ID");
		}			
	}

	public static void Fileop(String a)throws IOException {

		File cng =new File(a+".txt"); 
		try{
			FileReader fr = new FileReader(cng);
			char reading[] = new char [(int)cng.length()];
			fr.read(reading);
			System.out.println(reading);


		}
		catch(Exception e){
			System.out.println("File Not Found..");
		}
	}

	public static void Fileop1(String a)throws IOException {
		File cng1 =new File("cng2.txt");
		try{
			FileReader fr1 = new FileReader(cng1);
			char reading1[] = new char [(int)cng1.length()];
			fr1.read(reading1);
			System.out.println(reading1);
		}

		catch(Exception e){
			System.out.println("File Not Found..");
		}
	}



	public static void Fileopw(String x )throws IOException {

		FileWriter fw = new FileWriter(new File("data.txt"));
		fw.write(x);
		fw.close();

	}


}
