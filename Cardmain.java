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

        try (BufferedReader reader = new BufferedReader(new FileReader("cards_desc.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                // Dividir la línea en dos partes usando el carácter '|'
                String[] datos = linea.split("\\|");
                
                    String nombreCarta = datos[0];  
                    String tipoCarta = datos[1];
 
        
                    // Agregar la carta 
                    cartas.put(nombreCarta, tipoCarta);
                    treeMap.put(nombreCarta, tipoCarta);
                    linkedHashMap.put(nombreCarta, tipoCarta);
               
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    //Menu para elegir la estructura 
    menu();


 
    int estructura = scanner.nextInt();
    switch(estructura){
        case  1 :
        //Menu para elegir opciones del programa 
        menu2();
        int choice= scanner.nextInt();
        switch (choice) {
            case 1:
            System.out.println("Ingrese el nombre de la carta que quiere agregar a su colección");
            String carta = scanner.next();
            if(cartas.containsKey(carta)){
                Card card =new Card(carta,cartas.get(carta));
                coleccion.add(card);
            }else{
                System.out.println("El nombre de la carta ingresada no existe");
            }
           
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


    

  






