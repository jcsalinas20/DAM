package Ejercicio1;

public interface Vehicles {

	static void mostrar(ListaVehiculos lv) {
		for (int i = 0; i < lv.vehiculo.size(); i++) {
			System.out.println(lv.vehiculo.get(i).getNumeroRodes());
			System.out.println(lv.vehiculo.get(i).getNumeroPlaces());
			System.out.println(lv.vehiculo.get(i).getVelocidadActual());
			System.out.println(lv.vehiculo.get(i).getMatricula());
			System.out.println(lv.vehiculo.get(i).getVelocidadMaxima());
			System.out.println(lv.vehiculo.get(i).getConsum());
		}
	}

}
