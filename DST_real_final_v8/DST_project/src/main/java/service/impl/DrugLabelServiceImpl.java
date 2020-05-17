package service.impl;

import dao.IDrugLabeldao;

import dao.impl.DrugLabeldaoImpl;

import domain.DrugLabel;
import service.IDruglabelService;

import java.util.List;
public class DrugLabelServiceImpl implements IDruglabelService {
   IDrugLabeldao dao=new DrugLabeldaoImpl();

    public void saveDrugLabel(DrugLabel drugLabel) {
        dao.saveDrugLabel(drugLabel);
    }

    public List<DrugLabel> findAll(){
        return dao.findAll();
    }
    public boolean existsById(String id) {
        return dao.existsById(id);
    }
}
