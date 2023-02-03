package com.allocation.services;

import java.util.List;

import com.allocation.dao.ChambreDaoImp;
import com.allocation.dao.IChambreDao;
import com.allocation.model.Chambre;

public class ChambreService {
    private final String SUCCESS_MSG = "Operation effectue avec succes";
    private final String FAILED_MSG = "Echec de l'operation";
    private IChambreDao iChambreDao;

    public ChambreService() {
        iChambreDao = new ChambreDaoImp();
    }

    public void addChambre(Chambre chambre) {
        Integer result = iChambreDao.save(chambre);
        System.out.println(result == 1 ? SUCCESS_MSG : FAILED_MSG);
    }

    public List<Chambre> getAllChambre() {
        return iChambreDao.findAll();
    }
}
