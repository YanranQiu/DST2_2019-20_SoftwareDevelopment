package service;

import domain.Drug;
import domain.DrugLabel;

import java.util.List;

public interface IDruglabelService {
    public void saveDrugLabel(DrugLabel drugLabel);
    public List<DrugLabel> findAll();
    public boolean existsById(String id);
}
