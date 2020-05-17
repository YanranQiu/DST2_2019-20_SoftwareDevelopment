package dao;

import java.util.List;

public interface IAnnovardao {
    public void save(String filename, String content);
    public List<String> getSymbol(String filename);
    public List<String> findDrug (String gene);
    public boolean exists(String drugID, String drugGene);
}