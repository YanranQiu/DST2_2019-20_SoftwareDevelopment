package service;

import java.util.List;

public interface IAnnovarService {
    public void save(String filename, String content);
    public List<String> getSymbol(String filename);
    public List<String> findDrug (String gene);
    public boolean exists(String drugID, String drugGene);
}
