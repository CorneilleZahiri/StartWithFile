import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        creerEtEcrireDansUnFichier();
        LireUnFichier();
    }

    static void creerEtEcrireDansUnFichier() {
        Scanner scanner = new Scanner(System.in);

        try {
            Path path = Paths.get("notes.txt");
            if (Files.exists(path)) {
                Files.delete(path);
                System.out.println("Fichier existant supprimé avec succès");
            }

            Files.createFile(path);

            System.out.print("*******************************" +
                    "\nEntrez 3 phrases dans le fichiers.\n1- ");
            String phrase1 = scanner.nextLine();
            System.out.print("2- ");
            String phrase2 = scanner.nextLine();
            System.out.print("3- ");
            String phrase3 = scanner.nextLine();

            //AJOUTER LES PHRASES DANS LE FICHIER
            Files.write(path, List.of(phrase1, phrase2, phrase3));

            System.out.println("Fichier notes.txt crée avec succès");

        } catch (IOException e) {
            System.err.println("Erreur lors de la création du fichier");
            e.printStackTrace();
        }
    }

    static void LireUnFichier() {
        Path path = Paths.get("notes.txt");
        try {
            List<String> contenuFichier = Files.readAllLines(path);
            
            System.out.println("*********** DEBUT DE LECTURE **************");
            for (String ligne : contenuFichier) {
                System.out.println(ligne);
            }
            System.out.println("*********** FIN DE LECTURE **************");

        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier");
            e.printStackTrace();
        }
    }
}