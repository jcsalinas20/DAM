
public class Practica1 {
	public static final double CONVERSIO_EURO_A_DOLAR = 1.3656;
	
	public static void main(String[] args) {
		
		//EXERCICI 1 
				/* int _a;
				 int 3c;//INCORRECTO: en la variable int no se pueden empezar por numeros
				 double $real;
				 float final;//INCORRECTO: el 'final' va al principio
				 float Diners;
				 char #x;//INCORRECTO: el char no puede tener caracteres que no sean alfanumericos.
				 char y#;//INCORRECTO: el char no puede tener caracteres que no sean alfanumericos. 
				 char "edad"; //INCORRECTO: falta la variable y no se puede poner mas de un caracter en el 'char' si no seria un 'string', tambien el resultado de la variable tiene que tener la apostrof ''
			*/
		
		//EXERCICI 2 
			//a)
				/* 
				 int x;
				 int y;
				 //inici de bloc
				 {
				 int x;//el problema es que el bloc esta por de bajo del int y va por encima.
				 } 
				 */
		
			//b)
				/*
				//inici de bloc 1
				 {
				 int x=5;
				 System.out.println("Variable x bloc 1 "+ x);
				 }
				 //inici de bloc 2
				 {
				 int x=10;
				 int y=3;
				 System.out.println("Variable x bloc 2 "+ x);

				 }
				 int x=20;
				 System.out.println("Variable x bloc main "+ x);
				 System.out.println("Variable x bloc main "+ y);//la variable 'y' esta creada pero como esta dentro del bloc 2 es como si no estuviera ya que se borra, se tendia que poner la variable depues del bloc 2.
				*/
		
		//EXERCICI 3 
			//a)
				/*
				int operand1=5;
				int operand2=10;
				int resultat;
				*/
		
			//b)
				/*
				//bloc division 1
				{
					float a=17f;
					int b=3;
					a/=b;
					System.out.println("Resultat división 1: "+ a);
				}
				//bloc division 2
				{
					float a=9f;
					int b=3;
					a/=b;
					System.out.println("Resultat división 2: "+ a);
				}
				float a=21f;
				int b=4;
				a/=b;
				System.out.println("Resultat división 3: "+ a);
				*/
		
			//c)
				/*
				//bloc division 1
				{
					int a=17;
					int b=3;
					a%=b;
					System.out.println("Resultado modulo 1: "+ a);
				}
				//bloc division 2
				{
					int a=9;
					int b=3;
					a%=b;
					System.out.println("Resultado modulo 2: "+ a);
				}
				int a=21;
				int b=4;
				a%=b;
				System.out.println("Resultado modulo 3: "+ a);
				*/
		
			//d)
				/*
				//bloc division 1
				{
					double a=17;
					int b=3;
					a/=b;
					System.out.println("Resultat division 1: "+ a);
				}
				//bloc division 2
				{
					double a=9;
					int b=3;
					a/=b;
					System.out.println("Resultat division 2: "+ a);
				}
				double a=21;
				int b=4;
				a/=b;
				System.out.println("Resultat division 3: "+ a);
				*/
		
		//EXERCICI 4 
			//a)
				/*
				 int a=9;
				 int b=9;
				 System.out.println(a++);//lo que estas haciendo es esta linea es hacer que puestre por pantalla.
				 System.out.println(++b);//lo que haces en esta es primero sumar +1 y seguidamente lo muestras por pantalla
				 */
		
			//b)
				/*
				System.out.println(4 == 4);//TRUE
				System.out.println(5 > 6);//FALSE
				System.out.println(7 < 10);//TRUE
				*/
		
			//c)
				/*
				System.out.println(8.5 + 3.2);//en todos los resultados vemos que estan con el tipo de datos 'double'
				System.out.println(5.66 - 3.1);
				System.out.println(3.1 * 8.4);
				System.out.println(17.0 / 4.0); 
				*/
		
		//EXERCICI 5 
			//a)
				/*
				double valor = 12.0;
				 System.out.println(valor*1.3656);
				 valor = 300.0;
				 System.out.println(valor*1.3756);//lo que falla es que no hay una variable y al escribirlo a mano se ha escrito mal
				 valor = 189.0;
				 System.out.println(valor*1.3656);
				 */
		
			//b)
				/*
				 double valor = 12.0;
				  System.out.println(valor*CONVERSIO_EURO_A_DOLAR);
				 valor = 300.0;
				  System.out.println(valor*CONVERSIO_EURO_A_DOLAR);//lo que falla es que el nombre de la variale esta mal escrito.
				 valor = 189.0;
				  System.out.println(valor*CONVERSIO_EURO_A_DOLAR); 
				 */
		
		//EXERCICI 6 
			//a)
				
			//b)
				

	}

}
