package eredua.bean;

public class ErabiltzailearenMota {
	public String erabMota;
	public int kodea;
	public ErabiltzailearenMota(String erabMota, int kodea) {
		super();
		this.erabMota = erabMota;
		this.kodea = kodea;
	}
	public String getErabMota() {
		return erabMota;
	}
	public void setErabMota(String erabMota) {
		this.erabMota = erabMota;
	}
	public int getKodea() {
		return kodea;
	}
	public void setKodea(int kodea) {
		this.kodea = kodea;
	}
	public String toString() {
		return erabMota;
	}

}
