package net.salesianos.brawler;

import java.util.ArrayList;
import java.util.Comparator; //Esta util es cortesia de IA, bastante util, no la conocia.
import java.util.List;

public class BrawlerManager {
    private static List<Brawler> brawlers = new ArrayList<>();

    public static void addBrawler(Brawler b) {
        brawlers.add(b);
    }

    public static List<Brawler> getBrawlers() {
        brawlers.sort(Comparator.comparingInt(Brawler::getRank).reversed()); // el .reversed es para que se ordene de mayor a menor.
        return brawlers;
        // Realmente util este java.util, antes de tenerlo asi tenia dos bucles for uno dentro de otro iterando sobre una copia
        // del arraylist de brawlers y ordenando brawlers uno por uno si el rank era menor que el del siguiente.
    }

    public static Brawler getBrawler(int index) {
        if (index >= 0 && index < brawlers.size()) {
            return brawlers.get(index);
        }
        return null;
    }

    public static void updateBrawler(int index, Brawler updated) {
        if (index >= 0 && index < brawlers.size()) {
            brawlers.set(index, updated);
        }
    }

    public static void deleteBrawler(int index) {
        if (index >= 0 && index < brawlers.size()) {
            brawlers.remove(index);
        }
    }

    public static int size() {
        return brawlers.size();
    }
}
