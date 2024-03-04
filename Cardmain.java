import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Cardmain {
    public static void main(String [] args ){
        //Declaracion de estructuras de datos a utilizar y scanner 

        ArrayList<Card> coleccion = new ArrayList<>();
        Map<String, String> cartas = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, String> treeMap = new TreeMap<>();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        boolean seguir =true;

        //Leemos el txt
        while(seguir){
            try (BufferedReader br = new BufferedReader(new FileReader("cards_desc.txt"))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    // Dividir la línea en dos partes usando el carácter '|'
                    String[] datos = linea.split("\\|");
                    if (datos.length == 2) { // Verificar que la línea tiene exactamente dos elementos
                        String nombreCarta = datos[0].trim();  // Eliminar espacios en blanco alrededor del nombre de la carta
                        String tipoCarta = datos[1].trim();    // Eliminar espacios en blanco alrededor del tipo de carta
    
                        // Agregar la carta al HashMap
                        cartas.put(nombreCarta, tipoCarta);
                    } else {
                        System.out.println("Error: línea no válida - " + linea);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    
        //Menu para elegir la estructura 
        menu();
     
        int estructura = scanner.nextInt();
        scanner.nextLine();
        switch(estructura){

            case  1 :
            //Menu para elegir opciones del programa 
            menu2();
            int choice= scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                //Implementacion HashMap
                case 1:
                //Agregar a la coleccion
                System.out.println("Ingrese el nombre de la carta que quiere agregar a su colección");
                String carta = scanner.nextLine();
    
              
                if(cartas.containsKey(carta.trim())){
                    Card card =new Card(carta,cartas.get(carta));
                    coleccion.add(card);
                    System.out.println("Carta agregada a tu coleccion ");
                }else{
                    System.out.println("El nombre de la carta ingresada no existe");
                }
               
                break;
                    
    
                case 2:
                //Buscar tipo de una carta 
                System.out.println("Ingrese el nombre de la carta");
                String tipo = scanner.nextLine();

                if(cartas.containsKey(tipo)){
                    System.out.println("La carta " + tipo + " es de tipo  " + cartas.get(tipo.trim()));

                    
                }else{
                    System.out.println("El nombre de la carta ingresada no existe");
                }
               

    
                break;
    
                case 3:
    
                break;
                case 4:
    
                break;
                case 5:
    
                break;
                case 6:
    
                break;
            
                default:
                System.out.println("Error, ingrese una opcion valida");
    
                break;
            }
            break;
            case 2:
            menu2();
            int choice2= scanner.nextInt();
            switch (choice2) {
                case 1:
                    
                break;
                case 2:
    
                break;
    
                case 3:
    
                break;
                case 4:
    
                break;
                case 5:
    
                break;
                case 6:
    
                break;
            
                default:
                System.out.println("Error, ingrese una opcion valida");
                
                break;
            }
    
            break;
            case 3:
            menu2();
            int choice3=scanner.nextInt();
            switch (choice3) {
                case 1:
               
                    
                break;
                case 2:
    
                break;
    
                case 3:
    
                break;
                case 4:
    
                break;
                case 5:
    
                break;
                case 6:
    
                break;
            
                default:
                System.out.println("Error, ingrese una opcion valida");
                
                break;
            }
            break;
            default:
            System.out.println("Error, ingrese una opcion valida");
            break;
        }
    






        }

        




    }



    public static  void menu(){
        System.out.println("====MENU====");
        System.out.println("Elija la estructura que desea usar");
        System.out.println("1.HashMap");
        System.out.println("2.TreeMap");
        System.out.println("3.LinkedHashMap");
        
    }

    public static void menu2(){
        System.out.println("====MENU====");
        System.out.println("¿Qué desea hacer?");
        System.out.println("1.Agregar carta a colección");
        System.out.println("2.Buscar tipo de una carta ");
        System.out.println("3.Ver coleccion");
        System.out.println("4.Ver coleccion ordenada por tipo ");
        System.out.println("5.Mostrar todas las cartas ");
        System.out.println("6.Mostrar todas las cartas ordenadas por tipo");
        
        
    }



    

}


    

  






