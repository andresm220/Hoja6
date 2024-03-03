import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Cardmain {
    public static void main(String [] args ){

        ArrayList<Card> coleccion = new ArrayList<>();
        Map<String, String> cartas = new HashMap<>();

          //Leemos el txt

    try (BufferedReader reader = new BufferedReader(new FileReader("cards_desc.txt") )){
        String linea;
        while((linea= reader.readLine()) != null){
            String[] datos = linea.split("|");
            String tipo_carta = datos[1];


            switch(tipo_carta){
                case "Monstruo":
                cartas.put(datos[0],"Monstruo");
                break;
                case "Trampa":
                cartas.put(datos[0],"Trampa");

                break;
                case "Hechizo":
                cartas.put(datos[0], "Hechizo");
                
                break;
                default:
                System.out.print("Tipo de carta desconocido: " + tipo_carta );
                break;
            }


        }



    }catch(IOException e){
        e.printStackTrace();
    }





    }



    

}


    

  






