import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
    private static Scanner scanner = new Scanner(System.in);
    private static LinkedHashMap<String, Card> linkedHashMap = new LinkedHashMap<>();

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
                            agregarCartaHash();
                            break;
                        case 2:
                            buscarCartaHash();
                            break;
                        case 3:
                            mostrarColeccionUsuarioHash();
                            break;
                        case 4:
                            // Implementar opcion mostrar cartas tipo del usuario
                            break;
                        case 5:
                            mostrarColeccionGeneralHash();
                            break;
                        case 6:

                            // Implementar la opción de mostrar todas las cartas ordenadas por tipo
                            System.out.println("¿Qué tipo de carta deseas ver?");
                            System.out.println("1.Monstruo");
                            System.out.println("2.Trampa");
                            System.out.println("3.Hechizo");
                            int lee = scanner.nextInt();
                            switch (lee) {
                                case 1:
                                    mostrarColeccionGeneralMonstruoHash();

                                    break;
                                case 2:
                                    mostrarColeccionGeneralTrampaHash();
                                    break;
                                case 3:
                                    mostrarColeccionGeneralHechizoHash();
                                    break;

                                default:
                                    System.out.println("No existe ese tipo de carta ");
                                    break;
                            }

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
                        // Implementar opcion mostrar cartas tipo del usuario
                        break;
                    case 5:
                        mostrarColeccionGeneralTreeMap();
                        break;
                    case 6:
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
                            // Implementar opcion mostrar cartas tipo del usuario
                            break;
                        case 5:
                            mostrarColeccionGeneralLinked();
                            break;
                        case 6:

                            // Implementar la opción de mostrar todas las cartas ordenadas por tipo
                            System.out.println("¿Qué tipo de carta deseas ver?");
                            System.out.println("1.Monstruo");
                            System.out.println("2.Trampa");
                            System.out.println("3.Hechizo");
                            int lee = scanner.nextInt();
                            switch (lee) {
                                case 1:
                                    mostrarColeccionGeneralMonstruoLinked();

                                    break;
                                case 2:
                                    mostrarColeccionGeneralTrampaLinked();
                                    break;
                                case 3:
                                    mostrarColeccionGeneralHechizoLinked();
                                    break;

                                default:
                                    System.out.println("No existe ese tipo de carta ");
                                    break;
                            }

                            break;
                        default:
                            System.out.println("Error, ingrese una opcion valida");
                            break;
                    }

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
                        linkedHashMap.put(nombreCarta, new Card(tipoCarta, 0));
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
    }

    public static void mostrarColeccionGeneralHash() {
        System.out.println("=== Colección General ===");
        for (Map.Entry<String, Card> entry : cartas.entrySet()) {
            String nombreCarta = entry.getKey();
            Card card = entry.getValue();
            System.out.println("Nombre: " + nombreCarta + " | Tipo: " + card.getTipo());
        }
    }

    public static void mostrarColeccionGeneralMonstruoHash() {
        // Códigos de escape ANSI para cambiar el color del texto en la consola

        for (Map.Entry<String, Card> entry : cartas.entrySet()) {
            Card card = entry.getValue();
            if ("Monstruo".equals(card.getTipo().trim())) {
                System.out.println(entry.getKey());
            }

        }

    }

    public static void mostrarColeccionGeneralTrampaHash() {

        for (Map.Entry<String, Card> entry : cartas.entrySet()) {
            Card card = entry.getValue();
            if ("Trampa".equals(card.getTipo().trim())) {
                System.out.println(entry.getKey());
            }
        }

    }

    public static void mostrarColeccionGeneralHechizoHash() {

        for (Map.Entry<String, Card> entry : cartas.entrySet()) {
            Card card = entry.getValue();
            if ("Hechizo".equals(card.getTipo().trim())) {
                System.out.println(entry.getKey());

            }
        }
    }

    // Implementacion Linked HashMap
    public static void agregarCartaLinked() {
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

    public static void buscarCartaLinked() {
        System.out.println("Ingrese el nombre de la carta");
        String nombreCarta = scanner.nextLine();
        if (cartas.containsKey(nombreCarta.trim())) {
            Card card = cartas.get(nombreCarta.trim());
            System.out.println("La carta " + nombreCarta + " es de tipo " + card.getTipo());
        } else {
            System.out.println("La carta " + nombreCarta + " no está en la colección.");
        }
    }

    public static void mostrarColeccionUsuarioLinked() {
        System.out.println("=== Colección del Usuario ===");
        for (Map.Entry<String, Card> entry : coleccionUsuario.entrySet()) {
            String nombreCarta = entry.getKey();
            Card card = entry.getValue();
            System.out.println(
                    "Nombre: " + nombreCarta + " | Tipo: " + card.getTipo() + " | Cantidad: " + card.getCantidad());
        }
    }

    public static void mostrarColeccionGeneralLinked() {
        System.out.println("=== Colección General ===");
        for (Map.Entry<String, Card> entry : cartas.entrySet()) {
            String nombreCarta = entry.getKey();
            Card card = entry.getValue();
            System.out.println("Nombre: " + nombreCarta + " | Tipo: " + card.getTipo());
        }
    }

    public static void mostrarColeccionGeneralMonstruoLinked() {
        System.out.println("=== Colección General de Monstruos ===");
        for (Map.Entry<String, Card> entry : cartas.entrySet()) {
            Card card = entry.getValue();
            if ("Monstruo".equals(card.getTipo().trim())) {
                System.out.println(entry.getKey());
            }
        }
    }

    public static void mostrarColeccionGeneralTrampaLinked() {
        System.out.println("=== Colección General de Trampas ===");
        for (Map.Entry<String, Card> entry : cartas.entrySet()) {
            Card card = entry.getValue();
            if ("Trampa".equals(card.getTipo().trim())) {
                System.out.println(entry.getKey());
            }
        }
    }

    public static void mostrarColeccionGeneralHechizoLinked() {
        System.out.println("=== Colección General de Hechizos ===");
        for (Map.Entry<String, Card> entry : cartas.entrySet()) {
            Card card = entry.getValue();
            if ("Hechizo".equals(card.getTipo().trim())) {
                System.out.println(entry.getKey());
            }
        }
    }

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

    // Mostrar colección general usando TreeMap
    public static void mostrarColeccionGeneralTreeMap() {
        System.out.println("=== Colección General (Ordenada por Nombre) ===");
        for (Map.Entry<String, Card> entry : cartasTree.entrySet()) {
            String nombreCarta = entry.getKey();
            Card card = entry.getValue();
            System.out.println("Nombre: " + nombreCarta + " | Tipo: " + card.getTipo());
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
    }

}
