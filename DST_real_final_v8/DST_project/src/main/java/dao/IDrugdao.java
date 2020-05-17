package dao;

import domain.Drug;
import domain.DrugLabel;

import java.util.List;

public interface IDrugdao {
    public void saveDrug(Drug drug);
    public List<Drug> findAll();
    public boolean existsById(String id);
}
