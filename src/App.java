import javax.swing.JOptionPane;
import net.salesianos.brawler.Brawler;
import net.salesianos.brawler.BrawlerManager;
import net.salesianos.utilities.Utilities;

public class App {
    public static void main(String[] args) {

        // Te añado par de brawlers ya de por si para que tengas donde ver como funciona y demás... 
        Brawler brawler1 = new Brawler("Shelly", "Especial", 3600, 300, 200, 720, 3);
        Brawler brawler2 = new Brawler("Colt", "Super Especial", 2800, 500, 150, 720, 4);
        Brawler brawler3 = new Brawler("Bull", "Épico", 5200, 400, 300, 720, 2);
        Brawler brawler4 = new Brawler("Jessie", "Mítico", 3200, 400, 250, 720, 5);
        Brawler brawler5 = new Brawler("Bro", "Legendario", 3400, 600, 100, 820, 1);

        BrawlerManager.addBrawler(brawler1);
        BrawlerManager.addBrawler(brawler2);
        BrawlerManager.addBrawler(brawler3);
        BrawlerManager.addBrawler(brawler4);
        BrawlerManager.addBrawler(brawler5);
        
        while (true) {
            try {
                String option = JOptionPane.showInputDialog(null,
                        "1. Añadir brawler\n2. Editar brawler\n3. Mostrar brawlers\n4. Eliminar brawler\nQ. Salir",
                        "Menú", JOptionPane.QUESTION_MESSAGE);

                if (option == null || option.equals("Q") || option.equals("q")) break;

                switch (option) {
                    case "1" :
                        addBrawler();
                        break;
                    case "2" :
                        editBrawler();
                        break;
                    case "3" :
                        showBrawlers();
                        break;
                    case "4" :
                        deleteBrawler();
                        break;
                    default :
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }

    private static void addBrawler() {
        String name = Utilities.promptString("Nombre:");
        String rarity = Utilities.promptString("Rareza (Especial, Super Especial, Épico, Mítico, Legendario):");
        int health = Utilities.promptInt("Salud:");
        int attack = Utilities.promptInt("Ataque:");
        int defense = Utilities.promptInt("Defensa:");
        int speed = Utilities.promptInt("Velocidad:");
        int rank = Utilities.promptInt("Valoración en estrellas (todo valor por encima de 5 se considerará 5):");
        if (rank < 1 ) {
            rank = 1;
        } else if (rank > 5) {
            rank = 5;
        }

        Brawler nuevo = new Brawler(name, rarity, health, attack, defense, speed, rank);
        BrawlerManager.addBrawler(nuevo);
    }

    private static void editBrawler() {
        showBrawlers();
        int index = Utilities.promptInt("Índice del brawler a editar:");
        if (index < 0 || index >= BrawlerManager.size()) throw new IndexOutOfBoundsException("Índice no válido");

        String name = Utilities.promptString("Nuevo nombre:");
        String rarity = Utilities.promptString("Nueva rareza:");
        int health = Utilities.promptInt("Nueva salud:");
        int attack = Utilities.promptInt("Nuevo ataque:");
        int defense = Utilities.promptInt("Nueva defensa:");
        int speed = Utilities.promptInt("Nueva velocidad:");
        int rank = Utilities.promptInt("Rank:");

        Brawler updated = new Brawler(name, rarity, health, attack, defense, speed, rank);
        BrawlerManager.updateBrawler(index, updated);
    }

    private static void showBrawlers() {
        String input = "";
        int i = 0;
        for (Brawler b : BrawlerManager.getBrawlers()) {
            input += "[" + i++ + "] " + b + "\n";
        }
        JOptionPane.showMessageDialog(null, input);
    }


    private static void deleteBrawler() {
        showBrawlers();
        int index = Utilities.promptInt("Índice del brawler a eliminar:");
        BrawlerManager.deleteBrawler(index);
    }
}
