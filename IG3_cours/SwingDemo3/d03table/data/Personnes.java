/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d03table.data;

import java.util.Arrays;
import java.util.List;

/**
 * Repertoire de personnes.
 * @author rosmord
 */
public class Personnes {
    public static List<Personne> getList() {
        return Arrays.asList(
                new Personne[] {
                    new Personne(26, "Turing", "Alan"),
                    new Personne(33, "Lovelace", "Ada"),
                    new Personne(62, "Babbage", "Charles")
                }
        );
    }
}
