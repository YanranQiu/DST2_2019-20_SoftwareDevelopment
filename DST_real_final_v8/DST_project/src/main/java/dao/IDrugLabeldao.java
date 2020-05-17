package dao;

import domain.DrugLabel;

import java.util.List;

public interface IDrugLabeldao {
    public void saveDrugLabel(DrugLabel drugLabel);
    public List<DrugLabel> findAll();
    public boolean existsById(String id);
}
