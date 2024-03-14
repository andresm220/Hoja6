import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Cardmain {
    private static Map<String, Card> cartas = new HashMap<>();
    private static Map<String, Card> coleccionUsuario = new HashMap<>();
    private static TreeMap<String, Card> cartasTree = new TreeMap<>();
    private static TreeMap<String, Card> coleccionUsuarioTree = new TreeMap<>();
    private static LinkedHashMap<String, Card> cartasLinked = new LinkedHashMap<>();
    private static LinkedHashMap<String, Card> coleccionLinked = new LinkedHashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    


    public static void main(String[] args) {
        boolean seguir = true;
        leerDocumento();
        while (seguir) {
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
                            agregarCartaHash();
                            break;
                        case 2:
                            buscarCartaHash();
                            break;
                        case 3:
                            mostrarColeccionUsuarioHash();
                            break;
                        case 4:
                            mostrarColeccionUsuarioHashMapOrdenadaTipo();
                            break;
                        case 5:
                            mostrarColeccionGeneralHash();
                            break;
                        case 6:
                            mostrarColeccionGeneralHashMapOrdenadaTipo();
                            break;
                        case 7:
                            seguir= false;
                            System.out.println("Hasta la proxima ");
                            break;
                        default:
                            System.out.println("Error, ingrese una opcion valida");
                            break;
                    }
                    break;
                case 2:
                menu2();
                int choice2 = scanner.nextInt();
                scanner.nextLine();
                switch (choice2) {
                    case 1:
                        agregarCartaTreeMap();
                        break;
                    case 2:
                        buscarCartaTreeMap();
                        break;
                    case 3:
                        mostrarColeccionUsuarioTreeMap();
                        break;
                    case 4:
                        mostrarColeccionUsuarioTreeMapOrdenadaTipo();
                        break;
                    case 5:
                        mostrarColeccionGeneralTreeMap();
                        break;
                    case 6:
                        mostrarColeccionGeneralTreeMapOrdenadaTipo();
                        break;
                    case 7:
                            seguir= false;
                            System.out.println("Hasta la proxima ");
                    break;
                    default: 
                    System.out.println("Error, ingrese una opcion valida");
                    break;
                }
                    break;
                
                case 3:
                    menu2();
                    int elec = scanner.nextInt();
                    scanner.nextLine();
                    switch (elec) {
                        case 1:
                            agregarCartaLinked();
                            break;
                        case 2:
                            buscarCartaLinked();
                            break;
                        case 3:
                            mostrarColeccionUsuarioLinked();
                            break;
                        case 4:
                            mostrarColeccionUsuarioLinkedOrdenadaTipo();
                            break;
                        case 5:
                            mostrarColeccionGeneralLinked();
                            break;
                        case 6:
                            mostrarColeccionGeneralLinkedHashMapOrdenadaTipo();
                            break;
                            case 7:
                            seguir= false;
                            System.out.println("Hasta la proxima ");

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
        System.out.println("7.Salir ");
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
                        cartasLinked.put(nombreCarta, new Card(tipoCarta, 0));
                        cartasTree.put(nombreCarta, new Card(tipoCarta, 0));
                    }
                } else {
                    System.out.println("Error: línea no válida - " + linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Implementacion HashMap

    public static void agregarCartaHash() {
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

    public static void buscarCartaHash() {
        System.out.println("Ingrese el nombre de la carta");
        String nombreCarta = scanner.nextLine();
        if (cartas.containsKey(nombreCarta.trim())) {
            Card card = cartas.get(nombreCarta.trim());
            System.out.println("La carta " + nombreCarta + " es de tipo " + card.getTipo());
        } else {
            System.out.println("La carta " + nombreCarta + " no está en la colección.");
        }
    }

    public static void mostrarColeccionUsuarioHash() {
        System.out.println("=== Colección del Usuario ===");
        for (Map.Entry<String, Card> entry : coleccionUsuario.entrySet()) {
            String nombreCarta = entry.getKey();
            Card card = entry.getValue();
            System.out.println(
                    "Nombre: " + nombreCarta + " | Tipo: " + card.getTipo() + " | Cantidad: " + card.getCantidad());
        }
        if(coleccionUsuario.isEmpty()){
            System.out.println("No hay cartas en la colección del usuario");
        }
    }

    public static void mostrarColeccionUsuarioHashMapOrdenadaTipo() {
    System.out.println("=== Colección del Usuario (Ordenada por Tipo) ===");
    Map<String, Map<String, Card>> cartasPorTipo = new HashMap<>();

    // Agrupar las cartas del usuario por tipo
    for (Map.Entry<String, Card> entry : coleccionUsuario.entrySet()) {
        String nombreCarta = entry.getKey();
        Card card = entry.getValue();
        String tipo = card.getTipo();

        // Obtener el mapa de cartas por tipo, creándolo si no existe
        Map<String, Card> cartasEnTipo = cartasPorTipo.computeIfAbsent(tipo, k -> new HashMap<>());

        // Agregar la carta al mapa de cartas por tipo
        cartasEnTipo.put(nombreCarta, card);
    }

    // Mostrar las cartas del usuario agrupadas por tipo y ordenadas por nombre de carta
    for (Map.Entry<String, Map<String, Card>> tipoEntry : cartasPorTipo.entrySet()) {
        String tipo = tipoEntry.getKey();
        Map<String, Card> cartasPorNombre = tipoEntry.getValue();

        System.out.println("Tipo: " + tipo);
        // Ordenar las cartas por nombre de carta
        List<String> nombresCartasOrdenados = new ArrayList<>(cartasPorNombre.keySet());
        Collections.sort(nombresCartasOrdenados);

        for (String nombreCarta : nombresCartasOrdenados) {
            Card card = cartasPorNombre.get(nombreCarta);
            System.out.println("Nombre: " + nombreCarta + " | Tipo: " + card.getTipo());
        }
    }

    if (coleccionUsuario.isEmpty()) {
        System.out.println("No hay cartas en la colección del usuario.");
    }
}

    public static void mostrarColeccionGeneralHash() {
        System.out.println("=== Colección General ===");
        for (Map.Entry<String, Card> entry : cartas.entrySet()) {
            String nombreCarta = entry.getKey();
            Card card = entry.getValue();
            System.out.println("Nombre: " + nombreCarta + " | Tipo: " + card.getTipo());
        }
    }

    public static void mostrarColeccionGeneralHashMapOrdenadaTipo() {
        System.out.println("=== Colección General ===");
        Map<String, Map<String, Card>> cartasPorTipo = new HashMap<>();
    
        // Agrupar las cartas por tipo
        for (Map.Entry<String, Card> entry : cartas.entrySet()) {
            String nombreCarta = entry.getKey();
            Card card = entry.getValue();
            String tipo = card.getTipo();
    
            // Obtener el mapa de cartas por tipo, creándolo si no existe
            Map<String, Card> cartasEnTipo = cartasPorTipo.computeIfAbsent(tipo, k -> new HashMap<>());
    
            // Agregar la carta al mapa de cartas por tipo
            cartasEnTipo.put(nombreCarta, card);
        }
    
        // Mostrar las cartas agrupadas por tipo y ordenadas por nombre de carta
        for (Map.Entry<String, Map<String, Card>> tipoEntry : cartasPorTipo.entrySet()) {
            String tipo = tipoEntry.getKey();
            Map<String, Card> cartasPorNombre = tipoEntry.getValue();
    
            System.out.println("Tipo: " + tipo);
            // Ordenar las cartas por nombre de carta
            List<String> nombresCartasOrdenados = new ArrayList<>(cartasPorNombre.keySet());
            Collections.sort(nombresCartasOrdenados);
    
            for (String nombreCarta : nombresCartasOrdenados) {
                Card card = cartasPorNombre.get(nombreCarta);
                System.out.println("Nombre: " + nombreCarta + " | Tipo: " + card.getTipo());
            }
        }
    
        if (cartas.isEmpty()) {
            System.out.println("No hay cartas en la colección de momento.");
        }
    }
    

   


    //-----------------------------------------------------------
    // Implementacion Linked HashMap
    public static void agregarCartaLinked() {
        System.out.println("Ingrese el nombre de la carta que quiere agregar a su colección");
        String nombreCarta = scanner.nextLine();
        if (cartas.containsKey(nombreCarta.trim())) {
            Card card = cartasLinked.get(nombreCarta.trim());
            card.setCantidad(card.getCantidad() + 1);

            // Agregar la carta al mapa de la colección del usuario
            if (!coleccionLinked.containsKey(nombreCarta.trim())) {
                coleccionLinked.put(nombreCarta.trim(), card);
            }

            System.out.println("Carta agregada a tu colección ");
        } else {
            System.out.println("El nombre de la carta ingresada no existe");
        }
    }

    public static void buscarCartaLinked() {
        System.out.println("Ingrese el nombre de la carta");
        String nombreCarta = scanner.nextLine();
        if (cartasLinked.containsKey(nombreCarta.trim())) {
            Card card = cartasLinked.get(nombreCarta.trim());
            System.out.println("La carta " + nombreCarta + " es de tipo " + card.getTipo());
        } else {
            System.out.println("La carta " + nombreCarta + " no está en la colección.");
        }
    }

    public static void mostrarColeccionUsuarioLinked() {
        System.out.println("=== Colección del Usuario ===");
        for (Map.Entry<String, Card> entry : coleccionLinked.entrySet()) {
            String nombreCarta = entry.getKey();
            Card card = entry.getValue();
            System.out.println(
                    "Nombre: " + nombreCarta + " | Tipo: " + card.getTipo() + " | Cantidad: " + card.getCantidad());
        }
        if(coleccionLinked.isEmpty()){
            System.out.println("No hay cartas en la coleccion de momento");
        }
    }


    public static void mostrarColeccionUsuarioLinkedOrdenadaTipo() {
        System.out.println("=== Colección del Usuario (Ordenada por Tipo) ===");
        Map<String, Map<String, Card>> cartasPorTipo = new LinkedHashMap<>();
    
        // Agrupar las cartas del usuario por tipo
        for (Map.Entry<String, Card> entry : coleccionLinked.entrySet()) {
            String nombreCarta = entry.getKey();
            Card card = entry.getValue();
            String tipo = card.getTipo();
    
            // Obtener el mapa de cartas por tipo, creándolo si no existe
            Map<String, Card> cartasEnTipo = cartasPorTipo.computeIfAbsent(tipo, k -> new LinkedHashMap<>());
    
            // Agregar la carta al mapa de cartas por tipo
            cartasEnTipo.put(nombreCarta, card);
        }
    
        // Mostrar las cartas del usuario agrupadas por tipo y ordenadas por nombre de carta
        for (Map.Entry<String, Map<String, Card>> tipoEntry : cartasPorTipo.entrySet()) {
            String tipo = tipoEntry.getKey();
            Map<String, Card> cartasPorNombre = tipoEntry.getValue();
    
            System.out.println("Tipo: " + tipo);
            // Ordenar las cartas por nombre de carta
            List<String> nombresCartasOrdenados = new ArrayList<>(cartasPorNombre.keySet());
            Collections.sort(nombresCartasOrdenados);
    
            for (String nombreCarta : nombresCartasOrdenados) {
                Card card = cartasPorNombre.get(nombreCarta);
                System.out.println("Nombre: " + nombreCarta + " | Tipo: " + card.getTipo());
            }
        }
    
        if (coleccionLinked.isEmpty()) {
            System.out.println("No hay cartas en la colección del usuario.");
        }
    }

    public static void mostrarColeccionGeneralLinked() {
        System.out.println("=== Colección General ===");
        for (Map.Entry<String, Card> entry : cartasLinked.entrySet()) {
            String nombreCarta = entry.getKey();
            Card card = entry.getValue();
            System.out.println("Nombre: " + nombreCarta + " | Tipo: " + card.getTipo());
        }
    }

    

    public static void mostrarColeccionGeneralLinkedHashMapOrdenadaTipo() {
        System.out.println("=== Colección General ===");
        Map<String, Map<String, Card>> cartasPorTipo = new LinkedHashMap<>();
    
        // Agrupar las cartas por tipo
        for (Map.Entry<String, Card> entry : cartasLinked.entrySet()) {
            String nombreCarta = entry.getKey();
            Card card = entry.getValue();
            String tipo = card.getTipo();
    
            // Obtener el mapa de cartas por tipo, creándolo si no existe
            Map<String, Card> cartasEnTipo = cartasPorTipo.computeIfAbsent(tipo, k -> new LinkedHashMap<>());
    
            // Agregar la carta al mapa de cartas por tipo
            cartasEnTipo.put(nombreCarta, card);
        }
    
        // Mostrar las cartas agrupadas por tipo y ordenadas por nombre de carta
        for (Map.Entry<String, Map<String, Card>> tipoEntry : cartasPorTipo.entrySet()) {
            String tipo = tipoEntry.getKey();
            Map<String, Card> cartasPorNombre = tipoEntry.getValue();
    
            System.out.println("Tipo: " + tipo);
            for (Map.Entry<String, Card> entry : cartasPorNombre.entrySet()) {
                String nombreCarta = entry.getKey();
                Card card = entry.getValue();
                System.out.println("Nombre: " + nombreCarta + " | Tipo: " + card.getTipo());
            }
        }
    
        if (cartasLinked.isEmpty()) {
            System.out.println("No hay cartas en la colección de momento.");
        }
    }

    //------------------------------------------------------
    //Treemap

    // Agregar carta a colección usando TreeMap
    public static void agregarCartaTreeMap() {
        System.out.println("Ingrese el nombre de la carta que quiere agregar a su colección");
        String nombreCarta = scanner.nextLine();
        if (cartas.containsKey(nombreCarta.trim())) {
            Card card = cartas.get(nombreCarta.trim());
            card.setCantidad(card.getCantidad() + 1);

            // Agregar la carta al mapa de la colección del usuario
            if (!coleccionUsuarioTree.containsKey(nombreCarta.trim())) {
                coleccionUsuarioTree.put(nombreCarta.trim(), card);
            }

            System.out.println("Carta agregada a tu colección ");
        } else {
            System.out.println("El nombre de la carta ingresada no existe");
        }
    }

    // Buscar carta usando TreeMap
    public static void buscarCartaTreeMap() {
        System.out.println("Ingrese el nombre de la carta");
        String nombreCarta = scanner.nextLine();
        if (cartasTree.containsKey(nombreCarta.trim())) {
            Card card = cartasTree.get(nombreCarta.trim());
            System.out.println("La carta " + nombreCarta + " es de tipo " + card.getTipo());
        } else {
            System.out.println("La carta " + nombreCarta + " no está en la colección.");
        }
    }

    // Mostrar colección del usuario usando TreeMap
    public static void mostrarColeccionUsuarioTreeMap() {
        System.out.println("=== Colección del Usuario ===");
        for (Map.Entry<String, Card> entry : coleccionUsuarioTree.entrySet()) {
            String nombreCarta = entry.getKey();
            Card card = entry.getValue();
            System.out.println(
                    "Nombre: " + nombreCarta + " | Tipo: " + card.getTipo() + " | Cantidad: " + card.getCantidad());


        }
        if(coleccionUsuarioTree.isEmpty()){
            System.out.println("No hay cartas en la coleccion de momento ");
        }
    }

    public static void mostrarColeccionUsuarioTreeMapOrdenadaTipo() {
        System.out.println("=== Colección del Usuario (Ordenada por Tipo) ===");
        Map<String, TreeMap<String, Card>> cartasPorTipo = new TreeMap<>();

        // Agrupar las cartas del usuario por tipo
        for (Map.Entry<String, Card> entry : coleccionUsuarioTree.entrySet()) {
            String nombreCarta = entry.getKey();
            Card card = entry.getValue();
            cartasPorTipo
                .computeIfAbsent(card.getTipo(), k -> new TreeMap<>())
                .put(nombreCarta, card);
        }

        // Mostrar las cartas del usuario agrupadas por tipo y ordenadas por nombre de carta
        for (Map.Entry<String, TreeMap<String, Card>> tipoEntry : cartasPorTipo.entrySet()) {
            String tipo = tipoEntry.getKey();
            TreeMap<String, Card> cartasPorNombre = tipoEntry.getValue();

            System.out.println("Tipo: " + tipo);
            for (Map.Entry<String, Card> entry : cartasPorNombre.entrySet()) {
                String nombreCarta = entry.getKey();
                Card card = entry.getValue();
                System.out.println("Nombre: " + nombreCarta + " | Tipo: " + card.getTipo());
            }
        }

        if (coleccionUsuarioTree.isEmpty()) {
            System.out.println("No hay cartas en la colección del usuario.");
        }
    }


    // Mostrar colección general usando TreeMap
    public static void mostrarColeccionGeneralTreeMap() {
        System.out.println("=== Colección General");
        for (Map.Entry<String, Card> entry : cartasTree.entrySet()) {
            String nombreCarta = entry.getKey();
            Card card = entry.getValue();
            System.out.println("Nombre: " + nombreCarta + " | Tipo: " + card.getTipo());
        }
    }

    public static void mostrarColeccionGeneralTreeMapOrdenadaTipo() {
        System.out.println("=== Colección General===");
        Map<String, TreeMap<String, Card>> cartasPorTipo = new TreeMap<>();

        // Agrupar las cartas por tipo
        for (Map.Entry<String, Card> entry : cartasTree.entrySet()) {
            String nombreCarta = entry.getKey();
            Card card = entry.getValue();
            cartasPorTipo
                .computeIfAbsent(card.getTipo(), k -> new TreeMap<>())
                .put(nombreCarta, card);
        }

        // Mostrar las cartas agrupadas por tipo y ordenadas por nombre de carta
        for (Map.Entry<String, TreeMap<String, Card>> tipoEntry : cartasPorTipo.entrySet()) {
            String tipo = tipoEntry.getKey();
            TreeMap<String, Card> cartasPorNombre = tipoEntry.getValue();

            System.out.println("Tipo: " + tipo);
            for (Map.Entry<String, Card> entry : cartasPorNombre.entrySet()) {
                String nombreCarta = entry.getKey();
                Card card = entry.getValue();
                System.out.println("Nombre: " + nombreCarta + " | Tipo: " + card.getTipo());
            }
        }

        if (cartasTree.isEmpty()) {
            System.out.println("No hay cartas en la colección de momento.");
        }
    }


}
