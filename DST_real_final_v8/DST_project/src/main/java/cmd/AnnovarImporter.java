package cmd;

import dbutils.DBUtils;
import service.impl.AnnovarServiceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnnovarImporter {

    public static void main(String[] args) {
        DBUtils.getConnection();
        AnnovarImporter annovarImporter = new AnnovarImporter();
        List<List<String>> drugGenes = annovarImporter.geneToDrug();
        System.out.println(drugGenes);
        annovarImporter.saveDrugGenes(drugGenes);
    }

    public List<List<String>> geneToDrug () {
        String sql = "select name,drug_id from dosing_guideline";
        List<List<String>> drugGenes = new ArrayList<>();
        DBUtils.execSQL(connection -> {
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String dosing_guideName = resultSet.getString(1);
                    String drug_id =  resultSet.getString(2);
                    String[] line = dosing_guideName.split("and ");
                    String[] genes = line[line.length-1].split(",");
                    List<String> temp = new ArrayList<>();
                    temp.add(drug_id);
                    for (int i=0; i<genes.length; i++) {
                        temp.add(genes[i]);
                    }
                    //System.out.println(temp);
                    drugGenes.add(temp);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        return drugGenes;
    }

    public void saveDrugGenes (List<List<String>> drugGenes) {
        AnnovarServiceImpl annovarService = new AnnovarServiceImpl();
        DBUtils.execSQL(connection -> {
            try {
                String sql = "insert into druggene (drugid, druggene) values (?,?)";
                //connection.setAutoCommit(false);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                for (int i = 0; i < drugGenes.size(); i++) {
                    String drugID = drugGenes.get(i).get(0);
                    System.out.println(drugID);
                    for (int j=1; j < drugGenes.get(i).size(); j++)
                    {
                        String drugGene = drugGenes.get(i).get(j);
                        System.out.println(drugGene);
                        if (!annovarService.exists(drugID, drugGene)) {
                            preparedStatement.setString(1, drugID);
                            //System.out.println("setString 1 success");
                            preparedStatement.setString(2, drugGene);
                            //System.out.println("setString 2 success");
                            preparedStatement.execute();
                        }
                    }
                    //preparedStatement.addBatch();
                    //preparedStatement.executeBatch();
                    //System.out.println("Do insert!");
                    //connection.commit();
                }
                //connection.commit();
            } catch (Throwable e) {
                e.printStackTrace();
                }

        });
    }

}
