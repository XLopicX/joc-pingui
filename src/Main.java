import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static BigInteger generarSemilla(ArrayList<String> llista, int tamanyTaulell) {
        String semilla = "";
        for (int i = 0; i < tamanyTaulell; i++) {

            Random rand = new Random();
            semilla += rand.nextInt(llista.size());
            if (i == 0) {
                while (semilla.equals("0")) { // Si el primer fos 0 biginteger plora una mica (Sel salta)
                    semilla = String.valueOf(rand.nextInt(llista.size()));
                }
            }

        }
        System.out.println("Semilla generada: " + semilla);

        return new BigInteger(semilla);
    }

    public static void codificarSemilla(BigInteger semilla, int tamanyTaulell) { // todo: acabar de pensar com fer aixo
        BigInteger resultat = BigInteger.ZERO;

        BigInteger divisible = BigInteger.ZERO;
        for (int e = 0; e < tamanyTaulell; e++) {
            for (BigInteger i = BigInteger.TWO; i.compareTo(semilla) < 0; i = i.add(BigInteger.ONE)) {
                if (semilla.mod(i).equals(BigInteger.ZERO)) {
                    divisible = i;
                    break;
                }
            }
            semilla = semilla.divide(divisible);
            System.out.println(semilla);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> caselles = new ArrayList<>(Arrays.asList("Oso", "Trineo", "Agujero", "Evento", "SueloQuebradizo", "Normal"));
        System.out.println(generarSemilla(caselles, 50));
    }
}