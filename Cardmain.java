import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Cardmain {
    private static Map<String, Card> cartas = new HashMap<>();
    private static Map<String, Card> coleccionUsuario = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        leerDocumento();
        while (true) {
            menu();
            int estructura = scanner.nextInt();
            scanner.nextLine();
            switch (estructura) {
                case 1:
                    menu2();
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            agregarCarta();
                            break;
                        case 2:
                            buscarCarta();
                            break;
                        case 3:
                            mostrarColeccionUsuario();
                            break;
                        case 4:
                            mostrarColeccionOrdenadaPorTipo();
                            break;
                        case 5:
                            // Implementar la opción de mostrar todas las cartas
                            break;
                        case 6:
                            // Implementar la opción de mostrar todas las cartas ordenadas por tipo
                            break;
                        default:
                            System.out.println("Error, ingrese una opcion valida");
                            break;
                    }
                    break;
                case 2:
                    // Implementar opciones para TreeMap
                    break;
                case 3:
                    // Implementar opciones para LinkedHashMap
                    break;
                default:
                    System.out.println("Error, ingrese una opcion valida");
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("====MENU====");
        System.out.println("Elija la estructura que desea usar");
        System.out.println("1.HashMap");
        System.out.println("2.TreeMap");
        System.out.println("3.LinkedHashMap");
    }

    public static void menu2() {
        System.out.println("====MENU====");
        System.out.println("¿Qué desea hacer?");
        System.out.println("1.Agregar carta a colección");
        System.out.println("2.Buscar tipo de una carta ");
        System.out.println("3.Ver colección del usuario");
        System.out.println("4.Ver colección ordenada por tipo ");
        System.out.println("5.Mostrar todas las cartas ");
        System.out.println("6.Mostrar todas las cartas ordenadas por tipo");
    }

    public static void leerDocumento() {
        try (BufferedReader br = new BufferedReader(new FileReader("cards_desc.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");
                if (datos.length == 2) {
                    String nombreCarta = datos[0].trim();
                    String tipoCarta = datos[1].trim();
                    if (!cartas.containsKey(nombreCarta)) {
                        cartas.put(nombreCarta, new Card(tipoCarta, 0));
                    }
                } else {
                    System.out.println("Error: línea no válida - " + linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void agregarCarta() {
        System.out.println("Ingrese el nombre de la carta que quiere agregar a su colección");
        String nombreCarta = scanner.nextLine();
        if (cartas.containsKey(nombreCarta.trim())) {
            Card card = cartas.get(nombreCarta.trim());
            card.setCantidad(card.getCantidad() + 1);
            
            // Agregar la carta al mapa de la colección del usuario
            if (!coleccionUsuario.containsKey(nombreCarta.trim())) {
                coleccionUsuario.put(nombreCarta.trim(), card);
            }
            
            System.out.println("Carta agregada a tu colección ");
        } else {
            System.out.println("El nombre de la carta ingresada no existe");
        }
    }

    public static void buscarCarta() {
        System.out.println("Ingrese el nombre de la carta");
        String nombreCarta = scanner.nextLine();
        if (cartas.containsKey(nombreCarta.trim())) {
            Card card = cartas.get(nombreCarta.trim());
            System.out.println("La carta " + nombreCarta + " es de tipo " + card.getTipo());
        } else {
            System.out.println("La carta " + nombreCarta + " no está en la colección.");
        }
    }

    public static void mostrarColeccionUsuario() {
        System.out.println("=== Colección del Usuario ===");
        for (Map.Entry<String, Card> entry : coleccionUsuario.entrySet()) {
            String nombreCarta = entry.getKey();
            Card card = entry.getValue();
            System.out.println("Nombre: " + nombreCarta + " | Tipo: " + card.getTipo() + " | Cantidad: " + card.getCantidad());
        }
    }

    public static void mostrarColeccionOrdenadaPorTipo() {
        // Crear un mapa para almacenar las cartas agrupadas por tipo
        Map<String, List<Card>> cartasPorTipo = new HashMap<>();
        // Iterar sobre la colección del usuario y agrupar las cartas por tipo
        for (Map.Entry<String, Card> entry : coleccionUsuario.entrySet()) {
            Card card = entry.getValue();
            String tipoCarta = card.getTipo();
            // Verificar si el mapa ya contiene una lista para el tipo actual
            if (!cartasPorTipo.containsKey(tipoCarta)) {
                cartasPorTipo.put(tipoCarta, new ArrayList<>());
            }
            // Agregar la carta a la lista correspondiente al tipo
            cartasPorTipo.get(tipoCarta).add(card);
        }
        // Iterar sobre las entradas del mapa y mostrar las cartas agrupadas por tipo
        for (Map.Entry<String, List<Card>> entry : cartasPorTipo.entrySet()) {
            String tipoCarta = entry.getKey();
            List<Card> cartasTipo = entry.getValue();

            System.out.println("=== Colección del Usuario ===");
            System.out.println("Tipo " + tipoCarta);
            for (Card card : cartasTipo) {
                System.out.println("Nombre: " + entry.getKey() + " | Tipo: " + tipoCarta + " | Cantidad: " + card.getCantidad());
            }
        }
    }
    
    
    
}









