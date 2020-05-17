package service.impl;

import dao.IDosingGuidelinedao;
import dao.impl.DosingGuidelinedaoImpl;
import domain.DosingGuideline;
import service.IDosingGuidelineService;

import java.util.List;

public class DosingGuidelineServiceImpl implements IDosingGuidelineService {

    private IDosingGuidelinedao dao = new DosingGuidelinedaoImpl();

    public void saveDosingGuideline(DosingGuideline dosingGuideline) {
        dao.saveDosingGuideline(dosingGuideline);
    }
    public List<DosingGuideline> findAll(){
        return dao.findAll();
    }
    public boolean existsById(String id) {
        return dao.existsById(id);
    }
}
