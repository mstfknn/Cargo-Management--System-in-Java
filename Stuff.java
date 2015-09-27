package Package;

public class Stuff {
	private  String name;
	private  String city;
	private  String job;
	static Stuff[] Stuffs = new Stuff[100];
	static int numberOfStuffs=0;
	static int ID = 1 ;
	private int stuffID;
	
	public Stuff(int stuffID,String job, String city, String name ) {

		this.name = name;
		this.city = city;
		this.job = job;
		this.stuffID = stuffID;
	}

	public Stuff() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public static Stuff[] getStuffs() {
		return Stuffs;
	}

	public static void setStuffs(Stuff[] stuffs) {
		Stuffs = stuffs;
	}

	public static int getNumberOfStuffs() {
		return numberOfStuffs;
	}

	public static void setNumberOfStuffs(int numberOfStuffs) {
		Stuff.numberOfStuffs = numberOfStuffs;
	}

	public static int getID() {
		return ID;
	}

	public static void setID(int iD) {
		ID = iD;
	}

	public int getStuffID() {
		return stuffID;
	}

	public void setStuffID(int stuffID) {
		this.stuffID = stuffID;
	}

	
	
}