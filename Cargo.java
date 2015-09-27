package Package;

public class Cargo {
	private double Weight;
	private double Volume;
    private String City;
    private String toCity;
    static Cargo[] Cargoes = new Cargo[100];
    private int cargoID; 
	public static int ID = 1;
	static int numberofCargoes = 0;
	Cargo(String City, String  toCity, double Volume, double Weight, int cargoID)
    {
    	this.Weight = Weight;
    	this.Volume = Volume;
    	this.City = City;
    	this.toCity = toCity;
    	this.cargoID = cargoID;
    }

    public Cargo()
    {
   	 
    }
	public double getWeight() {
		return Weight;
	}
	public void setWeight(double weight) {
		Weight = weight;
	}
	public double getVolume() {
		return Volume;
	}
	public void setVolume(double volume) {
		Volume = volume;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public static Cargo[] getCargoes() {
		return Cargoes;
	}
	public static void setCargoes(Cargo[] cargoes) {
		Cargoes = cargoes;
	}
	public int getCargoID() {
		return cargoID;
	}
	public void setCargoID(int cargoID) {
		this.cargoID = cargoID;
	}
	public static int getID() {
		return ID;
	}
	public static void setID(int iD) {
		ID = iD;
	}
	public static int getNumberofCargoes() {
		return numberofCargoes;
	}
	public static void setNumberofCargoes(int numberofCargoes) {
		Cargo.numberofCargoes = numberofCargoes;
	}
	
	
	
	
}
