package service.impl;

import dao.IAnnovardao;
import dao.IDrugdao;
import dao.impl.AnnovardaoImpl;
import dao.impl.DrugdaoImpl;
import service.IAnnovarService;

import java.util.List;

public class AnnovarServiceImpl implements IAnnovarService {
    private IAnnovardao dao = new AnnovardaoImpl();
    public void save(String filename, String content){
        dao.save(filename,content);
    };
    public List<String> getSymbol(String filename){ return dao.getSymbol(filename); };
    public List<String> findDrug (String gene) {return dao.findDrug(gene); };
    public boolean exists(String drugID, String drugGene) {return dao.exists(drugID,drugGene); };
}
