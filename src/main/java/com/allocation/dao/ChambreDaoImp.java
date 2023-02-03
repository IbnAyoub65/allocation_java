package com.allocation.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.allocation.model.Chambre;
import com.allocation.model.EtatChambre;
import com.allocation.model.TypeChambre;

public class ChambreDaoImp implements IChambreDao {

    @Override
    public Integer save(Chambre t) {
        boolean checkPavillon = t.getPavillon() != null && t.getPavillon().getId() != null;
        String sql = checkPavillon ? "INSERT INTO chambre(numero, numeroEtage, etat, type, id_pavillon) VALUES(?,?,?,?,?)" :
        "INSERT INTO chambre(numero, numeroEtage, etat, type) VALUES(?,?,?,?)";
        try {
            PreparedStatement statement = DB.getConnection().prepareStatement(sql);
            statement.setInt(1, t.getNumero());
            statement.setInt(2, t.getNumeroEtage());
            statement.setString(3, t.getEtatChambre().name());
            statement.setString(4, t.getTypeChambre().name());
            if (checkPavillon) {
                statement.setLong(5, t.getPavillon().getId());
            }

            statement.execute();
            return 1;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return 0;
    }

    @Override
    public List<Chambre> findAll() {
        String sql = "SELECT * FROM chambre";
        try {
            Statement statement = DB.getConnection().createStatement();
            // statement.execute(sql);
            ResultSet rs = statement.executeQuery(sql);

            List<Chambre> chambres = new ArrayList<>();
            while(rs.next()) {
                Chambre chambre = new Chambre();
                chambre.setId(rs.getLong("id"));
                chambre.setNumero(rs.getInt("numero"));
                chambre.setNumeroEtage(rs.getInt("numeroEtage"));
                for(EtatChambre etat : EtatChambre.values()) {
                    if (etat.name().equals(rs.getString("etat"))) {
                        chambre.setEtatChambre(etat);
                    }
                }

                for(TypeChambre type : TypeChambre.values()) {
                    if (type.name().equals(rs.getString("type"))) {
                        chambre.setTypeChambre(type);
                    }
                }
                chambres.add(chambre);
            }

            return chambres;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public Chambre getById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer delete(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer update(Chambre t) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
