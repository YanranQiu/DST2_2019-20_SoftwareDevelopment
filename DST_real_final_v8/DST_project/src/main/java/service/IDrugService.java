package service;

import domain.Drug;
import domain.DrugLabel;

import java.util.List;

public interface IDrugService {
    public void saveDrug(Drug drug);
    public List<Drug> findAll();
    public boolean existsById(String id);
}
