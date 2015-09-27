package Package;


public class Container {
	private  int Volume;
	private  String City;
	private  String Licenceplate;
	static int IDIzmir = 1;
	static int IDAnkara = 1;
	private int containerID;
	static int numberofContainer=0;
	private boolean hire; 
	static Container[] Containers = new Container[100];
	Container(String City, int Volume,  String Licenceplate,int containerID,boolean hire)
	{
		this.Volume = Volume;
		this.City = City;
		this.Licenceplate = Licenceplate;
		this.containerID = containerID;
		this.hire=hire;
	}

	Container(String City, int Volume,  String Licenceplate,int containerID,boolean hire,Cargo[] Cargoes)
	{
		this.Volume = Volume;
		this.City = City;
		this.Licenceplate = Licenceplate;
		this.containerID = containerID;
		Management.sentCargoes=Cargoes;
		this.hire=hire;
	}

	public Container(){
		
	}
	public int getVolume() {
		return Volume;
	}
	public void setVolume(int volume) {
		Volume = volume;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getLicenceplate() {
		return Licenceplate;
	}
	public void setLicenceplate(String licenceplate) {
		Licenceplate = licenceplate;
	}
	
	public static int getIDIzmir() {
		return IDIzmir;
	}

	public static void setIDIzmir(int iDIzmir) {
		IDIzmir = iDIzmir;
	}

	public static int getIDAnkara() {
		return IDAnkara;
	}

	public static void setIDAnkara(int iDAnkara) {
		IDAnkara = iDAnkara;
	}

	public int getContainerID() {
		return containerID;
	}
	public void setContainerID(int containerID) {
		this.containerID = containerID;
	}
	public static Container[] getContainers() {
		return Containers;
	}
	public static void setContainers(Container[] containers) {
		Containers = containers;
	}
	public static int getNumberofContainer() {
		return numberofContainer;
	}
	public static void setNumberofContainer(int numberofContainer) {
		Container.numberofContainer = numberofContainer;
	}




	
}
