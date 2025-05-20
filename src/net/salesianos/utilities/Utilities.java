package net.salesianos.utilities;
import javax.swing.JOptionPane;

public class Utilities {

    public static String promptString(String message) {
        String input;
        do {
            input = JOptionPane.showInputDialog(null, message);
        } while (input == null || input.trim().isEmpty());
        return input.trim();
    }

    public static int promptInt(String message) {
        boolean isValid = false;
        int num = 0;

        while (!isValid) {
            String input = javax.swing.JOptionPane.showInputDialog(null, message);

            if (input == null || input.trim().isEmpty()) {
                System.out.println("La entrada no puede estar vacía.");
                continue; // O_o Como puedes ver me lie un fisco y le pedí ayuda a una amiga ajena...
            }

            boolean esNumero = true;
            for (int i = 0; i < input.length(); i++) {
                if (!Character.isDigit(input.charAt(i)) && !(i == 0 && input.charAt(i) == '-')) {
                    esNumero = false;
                    break;
                }
            }

            if (esNumero) {
                num = Integer.parseInt(input);
                isValid = true;
            } else {
                System.out.println("Eso no es un número válido. Inténtalo otra vez.");
            }
        }

        return num;
    }

}
