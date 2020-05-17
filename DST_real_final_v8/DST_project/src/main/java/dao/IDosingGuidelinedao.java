package dao;

import domain.DosingGuideline;
import domain.DrugLabel;

import java.util.List;

public interface IDosingGuidelinedao {
    public void saveDosingGuideline(DosingGuideline dosingGuideline);
    public List<DosingGuideline> findAll();
    public boolean existsById(String id);
}
