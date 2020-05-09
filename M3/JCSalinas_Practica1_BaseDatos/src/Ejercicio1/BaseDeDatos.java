package Ejercicio1;

public class BaseDeDatos {

	protected String idUser;
	protected int wins;
	protected int top3;
	protected int kills;
	protected int deaths;

	public BaseDeDatos() {
		super();
	}

	public BaseDeDatos(String idUser, int wins, int top3, int kills, int deaths) {
		super();
		this.idUser = idUser;
		this.wins = wins;
		this.top3 = top3;
		this.kills = kills;
		this.deaths = deaths;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getTop3() {
		return top3;
	}

	public void setTop3(int top3) {
		this.top3 = top3;
	}

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	@Override
	public String toString() {
		return "idUser = " + idUser + ", wins = " + wins + ", top3 = " + top3 + ", kills = " + kills + ", deaths = "
				+ deaths;
	}
}
