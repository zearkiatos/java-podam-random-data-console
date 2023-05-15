package com.example.podam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	//Inicializaci�n manual. *SUSCEPTIBLE A ERRORES* 
	//Por casos como este es necesario realizar pruebas
	private static Vendedor[] vendedores = {
			new Vendedor("Confecciones Norma Saenz", "nsaenz@email.com", "3213223234"),
			new Vendedor("Mi tia Tere", "mitiatere@email.com", "3122333444"),
			new Vendedor("Confecciones Montaraz", "montaraz@email.com", "3201030401"),
			new Vendedor("La monta�a", "lamontana@email.com", "3141513121"),
			new Vendedor("Ropa deportiva de Bogot�", "depobta@email.com", "3101112134"),
			};
	
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
    public static void main( String[] args )
    { 	
    	//Inicializaci�n manual. *SUSCEPTIBLE A ERRORES* 
    	//Por casos como este es necesario realizar pruebas
    	vendedores[0].ofrecer(new ArticuloUnitario("Saco en lana formal", "Saco formal para usar sobre camisas formales. Color gris", "Sacos", 50000));
    	vendedores[0].ofrecer(new ArticuloUnitario("Camisa tipo polo blanca", "Camisa blanca de tipo polo para hombre. Talla M", "Camisas", 23000));
    	
    	vendedores[1].ofrecer(new ArticuloUnitario("Gorro tejido", "Gorro tejido en Crochet de color vinotinto", "Accesorios", 10000));
    	vendedores[1].ofrecer(new ArticuloUnitario("Pasamontañas niños", "Pasamonta�as para ni�os con personajes de disney", "Accesorios", 6000));
    	vendedores[1].ofrecer(new ArticuloUnitario("Bufanda gruesa", "Bufanda gruesa de color negro, hecha a mano con lana", "Accesorios", 10000));
    	
    	vendedores[2].ofrecer(new ArticuloUnitario("Correa de cuero", "Cinturon en cuero de color negro y hebilla personalizable", "Accesorios", 20000));
    	vendedores[2].ofrecer(new ArticuloUnitario("Camisas de le�ador", "Camisa roja con dise�os de cuadros en color negro", "Camisas", 35000));

    	vendedores[3].ofrecer(new ArticuloUnitario("Maleta 30L", "Maleta para viajes con capacidad de 30L. Color negro uniforme", "Morrales", 80000));
    	vendedores[3].ofrecer(new ArticuloUnitario("Canguro militar", "Canguro con dise�o militar mediano", "Morrales", 25000));
    	vendedores[3].ofrecer(new ArticuloUnitario("Morral peque�o", "Morral lateral peque�o de tela azul resistente", "Morrales", 33000));
    	vendedores[3].ofrecer(new ArticuloUnitario("Billetera de tela", "Billetera de color negro hecha en tela con m�ltiples compartimientos", "Accesorios", 20000));
    	
    	vendedores[4].ofrecer(new ArticuloUnitario("Pantalon sudadera", "Pantalon negro para sudaderas. Ideal para ejercitarse", "Pantalones", 30000));
    	vendedores[4].ofrecer(new ArticuloUnitario("Medias de futbol", "Medias largas de color blanco para jugar f�tbol", "Accesorios", 8000));


    	Scanner sc = new Scanner(System.in);
    	boolean running = true;
    	
    	System.out.println("Bienvenido/a a la tienda virtual de confeccionistas independientes");
		System.out.println("Ingreso de clientes");
		System.out.println("¿Cuál es su nombre?");
		String nombre = sc.next();
		System.out.println("¿Cuál es su correo?");
		String correo = sc.next();
		System.out.println("¿Cuál es su número telefónico?");
		String tel = sc.next();
		Cliente cliente = new Cliente(nombre, correo, tel);
		clientes.add(cliente);
		System.out.println("¿Creación exitosa!");
		
    	while(running) {
    		
    		
    		System.out.println("-------------------------------------------------------------------");
    		System.out.println("¿Qué quiere hacer?\nIndique el número de la opción que quiere elegir");
    		System.out.println("1. Ver los productos de los vendedores");
    		System.out.println("2. Ver mis compras realizadas");
    		System.out.println("3. Salir");
    		try {
        		int opcion = sc.nextInt();	
        		switch(opcion) {
        			case 1:
        				imprimirVendedores();
        				int vendedor = sc.nextInt();
        				vendedores[vendedor].imprimirDisponibles();
        				int seleccion = sc.nextInt();
        				if(seleccion == 0) {
        					continue;
        				}
        				else {
        					cliente.comprar(vendedores[vendedor].getDisponibles().get(seleccion-1));
        					vendedores[vendedor].vender(seleccion-1);
        					System.out.println("Su compra ha sido exitosa");
        				}
        				break;
        			case 2:
        				verCompras(cliente);
        				break;
        			default:
        				System.out.println("Saliendo del sistema");
            			System.exit(0);
        				break;
        		}
    		}catch(Exception e) {
    			e.printStackTrace();
    			System.out.println("Entrada inválida. Saliendo del sistema");
    			System.exit(0);
    		}
    		
    	}
    }
    
    private static void verCompras(Cliente c) {
    	System.out.println("----------------------------------------------------------");
		ArrayList<Compra> compras = c.getCompras();
    	if(compras.size()==0) {
    		System.out.println("Usted no ha realizado compras en el sistema");
    	}
    	else {
    		for(int i=0;i<compras.size();i++) {
    			System.out.println("-" + compras.get(i).toString());
    		}
    	}
    }
    
    private static void imprimirVendedores() {
    	System.out.println("----------------------------------------------------------");
    	System.out.println("Indique el numero del vendedor del que quiere ver detalles");
    	for(int i=0;i<vendedores.length;i++) {
    		System.out.println((i+1) + ". " + vendedores[i].toString());
    	}
    }
}
