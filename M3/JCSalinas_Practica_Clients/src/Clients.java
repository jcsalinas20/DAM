import java.util.*;

public class Clients {
	static Scanner lector = new Scanner(System.in);
	static int maxClients = 100;
	static boolean validacio = false;

	public static void main(String[] args) {
		Clients programa = new Clients();
		programa.inici();
	}

	public void inici() {
		dadesClients();
	}

	public void dadesClients() {
//		CREACIO DE VARIABLES 
		int numCodi = 1;// ASIGNA EL NUMERO DE CODI AL CLIENT
		int opcio = 0;// INDICA LA OPCIO ESCOLLIDA DEL MENU
		boolean fiPrograma = false;// INDICA QUAN EL PROGRAMA HA ACABAT
		validacio = false;
		String[] dadesOpcions = { "Esborrat: ", "Codi: ", "NIF: ", "Nom: ", "Cognoms: ", "Telefon: " };
//		  GUARDA LES DADES DELS CLIENTS ACTUALS
		String[][] dadesIntroduides = new String[maxClients][6];
//		  GUARDA LES DADES DEL CLIENTS QUE NO ESTAN DE ALTA
		String[][] recuperacioDadesClients = new String[maxClients][6];
//		  ARRAYS PER LA REDIMENSIO DE maxClients
		String[][] dadesAnteriorsClients = new String[dadesIntroduides.length][6];
		String[][] dadesAnteriorsRecuperacio = new String[dadesIntroduides.length][6];

		System.out.println("Introduccio de Dades del Client.\n");

//		 CREACIO DE TOTS ELS CODIS Y DE CLIENTS ESBORRATS PER EL ARRAY dadesIntroduides
		for (int i = 0; i < dadesIntroduides.length; i++) {
			for (int j = 0; j < 1; j++) {
				dadesIntroduides[i][j] = "No";
			}
			for (int j = 1; j < 2; j++) {
				String numCodi1 = String.valueOf(numCodi++);
				dadesIntroduides[i][j] = numCodi1;
			}
		}
//		 CREACIO DE TOTS ELS CODIS Y DE CLIENTS ESBORRATS PER EL ARRAY recuperacioDadesClients
		numCodi = 1;
		for (int i = 0; i < dadesIntroduides.length; i++) {
			for (int j = 0; j < 1; j++) {
				recuperacioDadesClients[i][j] = "Si";
			}
			for (int j = 1; j < 2; j++) {
				String numCodi1 = String.valueOf(numCodi++);
				recuperacioDadesClients[i][j] = numCodi1;
			}
		}

//		INTRODUCIO DE DADES DEL CLIENT
		for (int i = 0; i < dadesIntroduides.length; i++) {
//			MOSTRAR SI EL CLIENT ESTA ESBORRAT O NO
			for (int Esborrat = 0; Esborrat < 1; Esborrat++) {
				System.out.print(dadesOpcions[Esborrat]);
				System.out.println(dadesIntroduides[i][Esborrat]);
			}
//			MOSTRAR EL CODI DEL CLIENT
			for (int Codi = 1; Codi < 2; Codi++) {
				System.out.print(dadesOpcions[Codi]);
				System.out.println(dadesIntroduides[i][Codi]);
			}
//			INTRODUCCIO DEL DNI
			for (int NIF = 2; NIF < 3; NIF++) {
				validacio = false;
				System.out.print(dadesOpcions[NIF]);
				do {
					if (lector.hasNextInt()) {
						int dni = lector.nextInt();
						if (dni >= 10000000 && dni < 99999999) {// 8 DIGITS
							validacio = true;
							dadesIntroduides[i][NIF] = calculoDeLetraDni(dni);// CALCUL DE LA LLETRA DEL DNI
						} else {
							System.out.println("Introduiex 8 digits.");
							lector.nextLine();
						}
					} else {
						System.out.println("No fa falta possar la lletra.");
						lector.nextLine();
					}
				} while (validacio != true);
			}
			// El siguiente nextLine lo he puesto porque si no el Nom se lo salta no se
			// porque.
			lector.nextLine();
//			INTRODUCCIO DEL NOM Y COGNOMS
			for (int nomCognom = 3; nomCognom < 5; nomCognom++) {
				System.out.print(dadesOpcions[nomCognom]);
				dadesIntroduides[i][nomCognom] = lector.nextLine();
			}
//			INTRODUCCIO DEL TELEFON QUE COMENSAN PER 6 y 7 o 9.
			for (int Telefon = 5; Telefon < 6; Telefon++) {
				validacio = false;
				System.out.print(dadesOpcions[Telefon]);
				do {
					if (lector.hasNextInt()) {
						int tel = lector.nextInt();
						if ((tel >= 600000000 && tel < 800000000) || (tel >= 900000000 && tel <= 999999999)) {// 9
																												// DIGITS
							validacio = true;
							dadesIntroduides[i][Telefon] = String.valueOf(tel);
						} else {
							System.out.println(
									"El numeros tene que comensar per 6 o 7 si es un mobil o per 9 si es un telefon fixe y te que tindre 9 digits.");
							lector.nextLine();
						}
					} else {
						System.out.println("Tens que introduir un numero.");
						lector.next();
					}
				} while (validacio != true);
				lector.nextLine();
			}
//			ELECCIO SI VOLS SEGUIR INTRODUINT CLIENTS O NO
			if (i != dadesIntroduides.length - 1) {
				System.out.println();
				System.out.print("Vols deixar de donar d'alta clients? ");
				String sortir = lector.nextLine();
				if (sortir.equalsIgnoreCase("Si")) {
					break;
				}
			}
			System.out.println();
		}

		while (fiPrograma != true) {

//			ACTUALIZACION DEL LOS ARRAYS TODO EL RATO POR SI SE HAN REDIMENSIONADO
			if (dadesIntroduides.length < maxClients) {
				dadesIntroduides = new String[maxClients][6];
				for (int i = 0; i < dadesAnteriorsClients.length; i++) {
					dadesIntroduides[i] = dadesAnteriorsClients[i];
				}
			}
			dadesAnteriorsClients = new String[dadesIntroduides.length][6];
			if (recuperacioDadesClients.length < maxClients) {
				recuperacioDadesClients = new String[maxClients][6];
				for (int i = 0; i < dadesAnteriorsRecuperacio.length; i++) {
					recuperacioDadesClients[i] = dadesAnteriorsRecuperacio[i];
				}
			}
			dadesAnteriorsRecuperacio = new String[recuperacioDadesClients.length][6];

			validacio = false;

//			REGISTRAR CLIENTS QUE NO HO ESTAN
			for (int i = 0; i < dadesIntroduides.length; i++) {
				for (int j = 0; j < 1; j++) {
					if (dadesIntroduides[i][3] == null) {
						dadesIntroduides[i][3] = "No Registrat";
					}
				}
			}
			for (int i = 0; i < recuperacioDadesClients.length; i++) {
				for (int j = 0; j < recuperacioDadesClients.length; j++) {
					if (recuperacioDadesClients[i][3] == null) {
						recuperacioDadesClients[i][3] = "No Registrat";
					}
				}
			}

			menu();// MOSTRAR EL MENU PER PANTALLA

			System.out.print("\nTria una opcio: ");// ESCOLLIR OPCIO DEL MENU
			do {
				if (lector.hasNextInt()) {
					opcio = lector.nextInt();
					if (opcio > 0 && opcio < 8) {
						validacio = true;
					} else {
						System.out.println("Introduiex un numero que estigui en el rang de 1-7.");
						lector.nextLine();
					}
				} else {
					System.out.println("Introduiex un numero.");
					lector.nextLine();
				}
			} while (validacio != true);

//			ELECCIO DE LA OPCIO DEL MENU
			switch (opcio) {
			case 1:
				System.out.println("Has triat la opcio Alta de un client");
				altaClient(dadesIntroduides, dadesOpcions, dadesAnteriorsClients, dadesAnteriorsRecuperacio,
						recuperacioDadesClients);
				break;

			case 2:
				System.out.println("Has triat la opcio Visualitzacio de clients");
				visualitzacioClients(dadesIntroduides, dadesOpcions, recuperacioDadesClients);
				break;

			case 3:
				System.out.println("Has triat la opcio Baixa de un client");
				baixaClient(dadesIntroduides, recuperacioDadesClients, dadesAnteriorsRecuperacio);
				break;

			case 4:
				System.out.println("Has triat la opcio Recuperacio de dades de client");
				recuperacioDades(dadesIntroduides, recuperacioDadesClients);
				break;

			case 5:
				System.out.println("Has triat la opcio Ordenar els clients");
				ordenar(dadesIntroduides);
				break;

			case 6:
				System.out.println("Has triat la opcio Recerca de un client");
				recercaClient(dadesIntroduides, dadesOpcions);
				break;

			case 7:
				System.out.println("Has triat la opcio Sortir");
				fiPrograma = true;
				break;
			}

		}

	}

//	MOSTRAR MENU PER PANTALLA
	public void menu() {
		System.out.println("\n\n1. Alta de un client\n" + "2. Visualitzacio de clients\n" + "3. Baixa de un client\n"
				+ "4. Recuperacio de dades de client\n" + "5. Ordenar els clients\n" + "6. Recerca de un client\n"
				+ "7. Sortir ");
	}

//	CALCUL DE LA LLETRA DEL DNI
	public static String calculoDeLetraDni(int dni) {
		String[] tabla = { "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V",
				"H", "L", "C", "K", "E" };

		int letra = dni % 23;
		String dniCompleto = String.valueOf(dni + tabla[letra]);
		return dniCompleto;
	}

//OPCIO 1 altaClient
	public void altaClient(String[][] dadesIntroduides, String[] dadesOpcions, String[][] dadesAnteriorsClients,
			String[][] dadesAnteriorsRecuperacio, String[][] recuperacioDadesClients) {

//		COMPROBACIO SI ES NECESITA REDIMENSIONAR
		int contador1 = 0;
		int contador2 = 0;
		int valor = 10;// SUMA DE 10 POSISIONS PER EL REDIMENSIONAMENT.
		for (int i = 0; i < dadesIntroduides.length; i++) {
//			COMPROBACIO SI HI HA LLOCS PER SEGUIR INTRODUINT CLIENTS
			if (dadesIntroduides[i][3] != "No Registrat") {
				contador1++;
			}
			if (recuperacioDadesClients[i][3] != "No Registrat") {
				contador2++;
			}
//			SI NO HI HA LLOCS...
			if (contador1 == dadesIntroduides.length || contador2 == recuperacioDadesClients.length) {
//				GUARDA TOTS EL CLIENTS DELS 2 ARRAYS PER QUE NO ES PERDI LA INFORMACIO
				for (int j = 0; j < dadesAnteriorsClients.length; j++) {
					dadesAnteriorsClients[j] = dadesIntroduides[j];
				}
				for (int j = 0; j < dadesAnteriorsRecuperacio.length; j++) {
					dadesAnteriorsRecuperacio[j] = recuperacioDadesClients[j];
				}
				maxClients = maxClients + valor;// SUMA DE 10 POSICIONS
				System.out.println("\nSe han afegit " + valor + " espais mes. Intenta-ho un altre cop.");
				lector.nextLine();
				System.out.println("\n\nPressioneu Enter...");
				lector.nextLine();
			}
		}

//		 CREACIO DE TOTS ELS CODIS Y DE CLIENTS ESBORRATS PER EL ARRAY dadesIntroduides
		int numCodidadesIntroduides = 1;
		for (int i = 0; i < dadesIntroduides.length; i++) {
			for (int j = 0; j < 1; j++) {
				dadesIntroduides[i][j] = "No";
			}
			for (int j = 1; j < 2; j++) {
				if (dadesIntroduides[i][j] == null) {
					String numCodi1 = String.valueOf(numCodidadesIntroduides++);
					dadesIntroduides[i][j] = numCodi1;
				} else {
					numCodidadesIntroduides++;
				}
			}
		}
//		 CREACIO DE TOTS ELS CODIS Y DE CLIENTS ESBORRATS PER EL ARRAY recuperacioDadesClients
		numCodidadesIntroduides = 1;
		for (int i = 0; i < recuperacioDadesClients.length; i++) {
			for (int j = 0; j < 1; j++) {
				recuperacioDadesClients[i][j] = "Si";
			}
			for (int j = 1; j < 2; j++) {
				if (recuperacioDadesClients[i][j] == null) {
					String numCodi1 = String.valueOf(numCodidadesIntroduides++);
					recuperacioDadesClients[i][j] = numCodi1;
				} else {
					numCodidadesIntroduides++;
				}
			}
		}

//		REGISTRAR CLIENTS QUE NO HO ESTAN
		for (int i = 0; i < dadesIntroduides.length; i++) {
			for (int j = 0; j < 1; j++) {
				if (dadesIntroduides[i][3] == null) {
					dadesIntroduides[i][3] = "No Registrat";
				}
			}
		}
		for (int i = 0; i < recuperacioDadesClients.length; i++) {
			for (int j = 3; j < 4; j++) {
				if (recuperacioDadesClients[i][j] == null) {
					recuperacioDadesClients[i][j] = "No Registrat";
				}
			}
		}

		for (int i = 0; i < dadesIntroduides.length; i++) {
			if (dadesIntroduides[i][3] == "No Registrat") {
//			MOSTRAR SI EL CLIENT ESTA ESBORRAT O NO
				for (int Esborrat = 0; Esborrat < 1; Esborrat++) {
					System.out.print(dadesOpcions[Esborrat]);
					System.out.println(dadesIntroduides[i][Esborrat]);
				}
//			MOSTRAR EL CODI DEL CLIENT
				for (int Codi = 1; Codi < 2; Codi++) {
					System.out.print(dadesOpcions[Codi]);
					System.out.println(dadesIntroduides[i][Codi]);
				}
//			INTRODUCCIO DEL DNI
				for (int NIF = 2; NIF < 3; NIF++) {
					validacio = false;
					System.out.print(dadesOpcions[NIF]);
					do {
						if (lector.hasNextInt()) {
							int dni = lector.nextInt();
							if (dni >= 10000000 && dni < 99999999) {// 8 DIGITS
								validacio = true;
								dadesIntroduides[i][NIF] = calculoDeLetraDni(dni);// CALCUL DE LA LLETRA DEL DNI
							} else {
								System.out.println("Introduiex 8 digits.");
								lector.nextLine();
							}
						} else {
							System.out.println("No fa falta possar la lletra.");
							lector.nextLine();
						}
					} while (validacio != true);
				}
				// El siguiente nextLine lo he puesto porque si no el Nom se lo salta no se
				// porque.
				lector.nextLine();
//			INTRODUCCIO DEL NOM Y COGNOMS
				for (int nomCognom = 3; nomCognom < 5; nomCognom++) {
					System.out.print(dadesOpcions[nomCognom]);
					dadesIntroduides[i][nomCognom] = lector.nextLine();
				}
//			INTRODUCCIO DEL TELEFON QUE COMENSAN PER 6 y 7 o 9.
				for (int Telefon = 5; Telefon < 6; Telefon++) {
					validacio = false;
					System.out.print(dadesOpcions[Telefon]);
					do {
						if (lector.hasNextInt()) {
							int tel = lector.nextInt();
							if ((tel >= 600000000 && tel < 800000000) || (tel >= 900000000 && tel <= 999999999)) {// 9
																													// DIGITS
								validacio = true;
								dadesIntroduides[i][Telefon] = String.valueOf(tel);
							} else {
								System.out.println(
										"El numeros tene que comensar per 6 o 7 si es un mobil o per 9 si es un telefon fixe y te que tindre 9 digits.");
								lector.nextLine();
							}
						} else {
							System.out.println("Tens que introduir un numero.");
							lector.next();
						}
					} while (validacio != true);
					lector.nextLine();
				}
//			ELECCIO SI VOLS SEGUIR INTRODUINT CLIENTS O NO
				if (i != dadesIntroduides.length - 1) {
					System.out.println();
					System.out.print("Vols deixar de donar d'alta clients? ");
					String sortir = lector.nextLine();
					if (sortir.equalsIgnoreCase("Si")) {
						break;
					}
				}
				System.out.println();
			}
		}
	}

//OPCIO 2 visualitzacioClients
	public void visualitzacioClients(String[][] dadesIntroduides, String[] dadesOpcions,
			String[][] recuperacioDadesClients) {
		validacio = false;
		lector.nextLine();
		do {
//			ESCOLLIR ENTRE ELS CLIENTS actuals O esborrats
			System.out.print("Mostrar clients actuals o esborrats? ");
			String opcio = lector.nextLine();
			if (opcio.equalsIgnoreCase("actuals")) {
				for (int i = 0; i < 1; i++) {
					System.out.print(dadesOpcions[0] + "\t");// ESBORRAT
					System.out.print(dadesOpcions[1] + "\t");// CODI
					System.out.print(dadesOpcions[2] + "\t\t");// DNI
					System.out.print(dadesOpcions[3] + "\t\t");// NOM
					System.out.print(dadesOpcions[4] + "\t\t");// COGNOMS
					System.out.print(dadesOpcions[5]);// TELEFON
				}
				System.out.println();
				for (int i = 0; i < dadesIntroduides.length; i++) {
					if (dadesIntroduides[i][3] != "No Registrat") {
						System.out.print(dadesIntroduides[i][0] + "\t\t");// ESBORRAT
						System.out.print(dadesIntroduides[i][1] + "\t");// CODI
						System.out.print(dadesIntroduides[i][2] + "\t");// DNI
						System.out.print(dadesIntroduides[i][3] + "\t\t");// NOM
						System.out.print(dadesIntroduides[i][4] + "\t\t\t");// COGNOMS
						System.out.print(dadesIntroduides[i][5]);// TELEFON
						System.out.println();
					}
				}
				validacio = true;
			} else if (opcio.equalsIgnoreCase("esborrats")) {
				for (int i = 0; i < 1; i++) {
					System.out.print(dadesOpcions[0] + "\t");// ESBORRAT
					System.out.print(dadesOpcions[1] + "\t");// CODI
					System.out.print(dadesOpcions[2] + "\t\t");// DNI
					System.out.print(dadesOpcions[3] + "\t\t");// NOM
					System.out.print(dadesOpcions[4] + "\t\t");// COGNOMS
					System.out.print(dadesOpcions[5]);// TELEFON
				}
				System.out.println();
				for (int i = 0; i < recuperacioDadesClients.length; i++) {
					if (recuperacioDadesClients[i][3] != "No Registrat") {
						System.out.print(recuperacioDadesClients[i][0] + "\t\t");// ESBORRAT
						System.out.print(recuperacioDadesClients[i][1] + "\t");// CODI
						System.out.print(recuperacioDadesClients[i][2] + "\t");// DNI
						System.out.print(recuperacioDadesClients[i][3] + "\t\t");// NOM
						System.out.print(recuperacioDadesClients[i][4] + "\t\t\t");// COGNOMS
						System.out.print(recuperacioDadesClients[i][5]);// TELEFON
						System.out.println();
					}
				}
				validacio = true;
			}
		} while (validacio != true);
		System.out.println("\n\nPressioneu Enter...");
		lector.nextLine();
	}

//OPCIO 3 baixaClient
	public void baixaClient(String[][] dadesIntroduides, String[][] recuperacioDadesClients,
			String[][] dadesAnteriorsRecuperacio) {
		validacio = false;
		boolean trobat = false;
		int valor = 0;

		do {// INTRODUCCIO DEL DNI
			System.out.print("Introdueix el numero del NIF (8 Digits sense lletra): ");
			if (lector.hasNextInt()) {
				valor = lector.nextInt();
				if (valor >= 10000000 && valor < 99999999) {// 8 DIGITS
					validacio = true;
				} else {
					lector.nextLine();
				}
			} else {
				lector.nextLine();
			}
		} while (validacio != true);

		for (int i = 0; i < dadesIntroduides.length; i++) {
			for (int j = 0; j < 1; j++) {
				if (dadesIntroduides[i][2] != null) {
					String nif = dadesIntroduides[i][2].substring(0, 8);// AGAFAR EL DNI SENSE LA LLETRA
					int nifClient = Integer.parseInt(nif);
//					COMPROBACIO SI ES TROBA EL DNI O NO
					if (nifClient == valor && dadesIntroduides[i][3] != "No Registrat") {
						trobat = true;
						int contador = 0;
						for (int k = 0; k < recuperacioDadesClients.length; k++) {
//							COMPROBACIO SI HI HA LLOC PER INTRODUIR EL CLIENT ESBORRAT
							if (recuperacioDadesClients[k][3] == "No Registrat") {
								for (int l = 2; l < recuperacioDadesClients[k].length; l++) {
//									INTERCANVI DE DADES DEL CLIENT 
									recuperacioDadesClients[k][l] = dadesIntroduides[i][l];
//									ELIMINACIO DEL CLIENT ANTERIOR
									if (l == 3) {
										dadesIntroduides[i][l] = "No Registrat";
									} else {
										dadesIntroduides[i][l] = null;
									}
								}
							} else {// SI NO HI HA LLOC SUMA EL CONTADOR PER REDIMENSIONAR
								contador++;
							}
						}
//						COMPROBACIO SI ES NECESITA REDIMENSIONAR
						valor = 10;
						for (int k = 0; k < dadesIntroduides.length; k++) {
							if (contador == recuperacioDadesClients.length) {
//								COPIA DEL ARRAY PER GUARDAR ELS CLIENTS
								for (int l = 0; l < dadesAnteriorsRecuperacio.length; l++) {
									dadesAnteriorsRecuperacio[l] = recuperacioDadesClients[l];
								}
								maxClients = maxClients + valor;// SUMA PER REDIMENSIONAR
								System.out
										.println("\nSe han afegit " + valor + " espais mes. Intenta-ho un altre cop.");
								lector.nextLine();
								System.out.println("\n\nPressioneu Enter...");
								lector.nextLine();
								break;
							}
						}
					}
				}
			}
		}

//		 CREACIO DE TOTS ELS CODIS Y DE CLIENTS ESBORRATS PER EL ARRAY recuperacioDadesClients
		int numCodi = 1;
		for (int i = 0; i < recuperacioDadesClients.length; i++) {
			for (int j = 0; j < 1; j++) {
				recuperacioDadesClients[i][j] = "Si";
			}
			for (int j = 1; j < 2; j++) {
				if (recuperacioDadesClients[i][j] == null) {
					String numCodi1 = String.valueOf(numCodi++);
					recuperacioDadesClients[i][j] = numCodi1;
				} else {
					numCodi++;
				}
			}
		}

		if (!trobat) {// SI NO ES TROBA...
			System.out.println("No se ha trobat");
		}

		lector.nextLine();
		System.out.println("\n\nPressioneu Enter...");
		lector.nextLine();
	}

//OPCIO 4 recuperacioDades
	public void recuperacioDades(String[][] dadesIntroduides, String[][] recuperacioDadesClients) {
		validacio = false;
		boolean trobat = false;
		
		int valor = 0;// VALOR DEL DNI
		do {
			System.out.print("Introdueix el numero del NIF (8 Digits sense lletra): ");
			if (lector.hasNextInt()) {
				valor = lector.nextInt();
				if (valor >= 10000000 && valor < 99999999) {// 8 DIGITS
					validacio = true;
				} else {
					lector.nextLine();
				}
			} else {
				lector.nextLine();
			}
		} while (validacio != true);

		for (int i = 0; i < dadesIntroduides.length; i++) {
			for (int j = 0; j < 1; j++) {
				if (recuperacioDadesClients[i][2] != null) {
					String nif = recuperacioDadesClients[i][2].substring(0, 8);// AGAFAR EL DNI SENSE LLETRA
					int nifClient = Integer.parseInt(nif);
//					COMPROBACIO SI ES TROBA EL DNI O NO
					if (nifClient == valor && recuperacioDadesClients[i][3] != "No Registrat") {
						trobat = true;
						for (int k = 0; k < dadesIntroduides.length; k++) {
							if (dadesIntroduides[k][3] == "No Registrat") {
								for (int l = 2; l < dadesIntroduides.length; l++) {
//									INTERCANVI DE DADES DEL CLIENT 
									dadesIntroduides[k][l] = recuperacioDadesClients[i][l];
//									ELIMINACIO DEL CLIENT ANTERIOR
									if (l == 3) {
										recuperacioDadesClients[i][l] = "No Registrat";
									} else {
										recuperacioDadesClients[i][l] = null;
									}
								}
							}
						}
					}
				}
			}
		}

		if (!trobat) {// SI NO ES TROBA...
			System.out.println("No se ha trobat");
		}
		lector.nextLine();
		System.out.println("\n\nPressioneu Enter...");
		lector.nextLine();
	}

//OPCIO 5 ordenar
	public void ordenar(String[][] dadesIntroduides) {
		System.out.println("Els clients se han ordenat per ordre alfabetic per el NOM.");
		ordenacioNom(dadesIntroduides);
	}

//	ORDENACIO ALFABETICA
	public void ordenacioNom(String[][] dadesIntroduides) {
		validacio = false;
		String[] auxiliar = new String[maxClients];

//		ORDENACIO DE NOMS
		for (int k = 1; k < dadesIntroduides.length; k++) {
			for (int i = 0; i < dadesIntroduides.length - k; i++) {
				for (int j = 0; j < 1; j++) {
					if (dadesIntroduides[i][3].compareTo(dadesIntroduides[i + 1][3]) > 0) {
						auxiliar = dadesIntroduides[i];
						dadesIntroduides[i] = dadesIntroduides[i + 1];
						dadesIntroduides[i + 1] = auxiliar;
					}
				}
			}
		}
		lector.nextLine();
		System.out.println("\n\nPressioneu Enter...");
		lector.nextLine();
	}

//OPCIO 6 recercaClient
	public void recercaClient(String[][] dadesIntroduides, String[] dadesOpcions) {
		validacio = false;
//		ELECCIO DE RECERCA ENTRE CODI Y NIF
		System.out.print("Com vols recercar el Client per CODI o NIF? ");
		do {
			String opcio = lector.nextLine();
			if (opcio.equalsIgnoreCase("Codi")) {
				recercaPerCodi(dadesIntroduides, dadesOpcions);// RECERCA PER CODI
				validacio = true;
			} else if (opcio.equalsIgnoreCase("NIF")) {
				recercaPerNif(dadesIntroduides, dadesOpcions);// RECERCA PER NIF
				validacio = true;
			}
		} while (validacio != true);

		lector.nextLine();
		System.out.println("\n\nPressioneu Enter...");
		lector.nextLine();
	}

//	RECERCA PER CODI
	public void recercaPerCodi(String[][] dadesIntroduides, String[] dadesOpcions) {
		validacio = false;
		boolean trobat = false;
		int valor = 0;

		do {
			System.out.print("Introdueix el numero del CODI (1-100): ");
			if (lector.hasNextInt()) {
				valor = lector.nextInt();
				if (valor > 0 && valor <= maxClients) {
					validacio = true;
				} else {
					System.out.println("Introdueix un numero entre 1-100.");
					lector.nextLine();
				}
			} else {
				System.out.println("Introdueix un numero.");
				lector.nextLine();
			}
		} while (validacio != true);

		for (int i = 0; i < dadesIntroduides.length; i++) {
			for (int j = 0; j < 1; j++) {
				int codiClient = Integer.parseInt(dadesIntroduides[i][1]);// PASSAR DE STRING A INT
				if (codiClient == valor && dadesIntroduides[i][3] != "No Registrat") {
					trobat = true;
					for (int l = 0; l < dadesOpcions.length; l++) {
						System.out.println(dadesOpcions[l] + dadesIntroduides[i][l]);// MOSTRAR DADES DEL CLIENT
					}
				}
			}
		}

		if (!trobat) {
			System.out.println("No se ha trobat");
		}
	}

//	 RECERCA PER NIF
	public void recercaPerNif(String[][] dadesIntroduides, String[] dadesOpcions) {
		validacio = false;
		boolean trobat = false;
		int valor = 0;

		do {
			System.out.print("Introdueix el numero del NIF (8 Digits sense lletra): ");
			if (lector.hasNextInt()) {
				valor = lector.nextInt();
				if (valor >= 10000000 && valor < 99999999) {// 8 DIGITS
					validacio = true;
				} else {
					lector.nextLine();
				}
			} else {
				lector.nextLine();
			}
		} while (validacio != true);

		for (int i = 0; i < dadesIntroduides.length; i++) {
			for (int j = 0; j < 1; j++) {
				if (dadesIntroduides[i][2] != null) {
					String nif = dadesIntroduides[i][2].substring(0, 8);// AGAFAR EL DNI SENSE LLETRA 
					int nifClient = Integer.parseInt(nif);// PASSAR DE STRING A INT
					if (nifClient == valor && dadesIntroduides[i][3] != "No Registrat") {
						trobat = true;
						for (int l = 0; l < dadesOpcions.length; l++) {
							System.out.println(dadesOpcions[l] + dadesIntroduides[i][l]);// MOSTRAR DADEA DEL CLIENT
						}
					}
				}
			}
		}

		if (!trobat) {
			System.out.println("No se ha trobat");
		}
	}

}
