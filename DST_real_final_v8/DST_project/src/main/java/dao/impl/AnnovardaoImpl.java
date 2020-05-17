package dao.impl;

import dao.Basedao.BaseDao;
import dao.IAnnovardao;
import dbutils.DBUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicBoolean;
//Uploaded_variation	Location	Allele	Consequence	IMPACT	SYMBOL	Gene	Feature_type	Feature	BIOTYPE	EXON	INTRON	HGVSc	HGVSp	cDNA_position	CDS_position	Protein_position	Amino_acids	Codons	Existing_variation	DISTANCE	STRAND	FLAGS	SYMBOL_SOURCE	HGNC_ID	MANE	TSL	APPRIS	SIFT	PolyPhen	AF	CLIN_SIG	SOMATIC	PHENO	PUBMED	MOTIF_NAME	MOTIF_POS	HIGH_INF_POS	MOTIF_SCORE_CHANGE

public class AnnovardaoImpl extends BaseDao implements IAnnovardao {
    public void save(String filename, String content) {
        String[] lines = content.split("\\n|\\r");
        DBUtils.execSQL(connection -> {
            String sql = "INSERT INTO annovar (filename,Uploaded_variation,Location,Allele,Consequence,IMPACT,SYMBOL,Gene,Feature_type,Feature,BIOTYPE,EXON,INTRON,HGVSc,HGVSp,cDNA_position,CDS_position,Protein_position,Amino_acids,Codons,Existing_variation,DISTANCE,STRAND,FLAGS,SYMBOL_SOURCE,HGNC_ID,MANE,TSL,APPRI,tSIFT,PolyPhen,AF,CLIN_SIG,SOMATIC,PHENO,PUBMED,MOTIF_NAME,MOTIF_POS,HIGH_INF_POS,MOTIF_SCORE_CHANGE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try {
                //set the transaction to be manually committed
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                for (int i = 2; i < lines.length; i++) {
                    String[] split = lines[i].split("\t|,");
                    preparedStatement.setString(1,filename);
                    for (int j = 1; j < 40; j++) {
                        preparedStatement.setString(j + 1, split[j-1]);
                    }
                    preparedStatement.execute();
                }
            } catch (SQLException e) {
                System.out.println("error");
            }
        });
    }



    public List<String> getSymbol(String filename) {
        String sql = "select distinct SYMBOL from annovar where filename = ?";
        List<String> genes = new ArrayList<>();
        DBUtils.execSQL(connection -> {
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, filename);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String symbol = resultSet.getString(1);
                    genes.add(symbol);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        return genes;
    }


    public List<String> findDrug (String gene) {
        String sql = "select drugid from druggene where druggene=?";
        List<String> drugIDs = new ArrayList<>();
        DBUtils.execSQL(connection -> {
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, gene);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String drugId = resultSet.getString(1);
                    drugIDs.add(drugId);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        return drugIDs;
    }

    public boolean exists(String drugID, String drugGene) {
        String sql = "select * from druggene where drugid=? and druggene=?";
        AtomicBoolean exists = new AtomicBoolean(false);
        DBUtils.execSQL(connection -> {
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, drugID);
                preparedStatement.setString(2, drugGene);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    exists.set(true);
                    System.out.println("exists done! true");
                } else
                    System.out.println("exists done! false");
            } catch (SQLException e) {
                System.out.println("Error!!!!!!");
                e.printStackTrace();
            }
        });
        return exists.get();
    }
}