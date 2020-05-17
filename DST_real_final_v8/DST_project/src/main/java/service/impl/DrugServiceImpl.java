package service.impl;

import dao.IDrugdao;
import dao.impl.DrugdaoImpl;
import domain.Drug;
import service.IDrugService;
import web.servlet.DrugServlet;

import java.util.List;

public class DrugServiceImpl implements IDrugService {
    private IDrugdao dao = new DrugdaoImpl();
    public void saveDrug(Drug drug) {
        dao.saveDrug(drug);
    }
    public List<Drug> findAll(){
        return dao.findAll();
    }
    public boolean existsById(String id) {
        return dao.existsById(id);
    }
}
