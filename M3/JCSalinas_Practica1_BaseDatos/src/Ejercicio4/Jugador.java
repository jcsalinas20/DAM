package Ejercicio4;

public class Jugador implements Comparable<Jugador>{
	String name;
	int idLegend;
	int kills;
	protected int totalDamage;
	protected int top3;
	protected int totalWins;
	
	@Override
	public int compareTo(Jugador o) {
		return o.kills - this.kills;
	}

	@Override
	public String toString() {
		return "Jugador [name=" + name + ", idLegend=" + idLegend + ", kills=" + kills + ", totalDamage=" + totalDamage
				+ ", top3=" + top3 + ", totalWins=" + totalWins + "]";
	}

	public Jugador() {
		super();
	}

	public Jugador(String name, int idLegend, int kills, int totalDamage, int top3, int totalWins) {
		super();
		this.name = name;
		this.idLegend = idLegend;
		this.kills = kills;
		this.totalDamage = totalDamage;
		this.top3 = top3;
		this.totalWins = totalWins;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdLegend() {
		return idLegend;
	}

	public void setIdLegend(int idLegend) {
		this.idLegend = idLegend;
	}

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public int getTotalDamage() {
		return totalDamage;
	}

	public void setTotalDamage(int totalDamage) {
		this.totalDamage = totalDamage;
	}

	public int getTop3() {
		return top3;
	}

	public void setTop3(int top3) {
		this.top3 = top3;
	}

	public int getTotalWins() {
		return totalWins;
	}

	public void setTotalWins(int totalWins) {
		this.totalWins = totalWins;
	}

}
