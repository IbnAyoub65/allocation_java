package com.allocation;

import java.util.List;

import com.allocation.model.Chambre;
import com.allocation.model.EtatChambre;
import com.allocation.model.Pavillon;
import com.allocation.model.TypeChambre;
import com.allocation.services.ChambreService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ChambreService chambreService = new ChambreService();
        Chambre chambre = new Chambre();
        chambre.setNumero(102);
        chambre.setNumeroEtage(20);
        chambre.setEtatChambre(EtatChambre.OCCUPE);
        chambre.setTypeChambre(TypeChambre.COLLECTIVE);
        Pavillon pavillon = new Pavillon();
        pavillon.setId(1L);
        chambre.setPavillon(pavillon);

        chambreService.addChambre(chambre);
        List<Chambre> chambres = chambreService.getAllChambre();
        for(Chambre ch : chambres) {
            System.out.println("################ ID : " + ch.getId() + " ###########");
            System.out.println("Numero : " + ch.getNumero());
            System.out.println("Numero Etage : " + ch.getNumeroEtage());
            System.out.println("Etat Chambre : " + ch.getEtatChambre().name());
            System.out.println("Type Chambre : " + ch.getTypeChambre().name());
        }
    }
}
