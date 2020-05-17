package dao.impl;

import dao.IUserdao;
import domain.DrugInfo;
import domain.User;
import dao.Basedao.BaseDao;
import dbutils.DBUtils;
import domain.UserHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class UserdaoImpl extends BaseDao implements IUserdao {
    private static final Logger log = LoggerFactory.getLogger(UserdaoImpl.class);

    public boolean existsById(String user_name) {
        return super.existsById(user_name, "user_info");
    }
    public void saveUserInfo(User user) {
        DBUtils.execSQL(connection -> {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into user_info (user_name, password, email) values (?,?,?)");
                System.out.println("prepare Statement");
                preparedStatement.setString(1, user.getUser_name());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getEmail());

                preparedStatement.execute();
            } catch (SQLException e) {
                log.info("", e);
            }
        });

    }
    public boolean findPassword(User user) {
        //List<User> users = new ArrayList<>();
        //AtomicReference<Boolean> ans = new AtomicReference<>(false);
        AtomicBoolean match = new AtomicBoolean(false);
        DBUtils.execSQL(connection -> {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select password from user_info where user_name= ?");
                preparedStatement.setString(1,user.getUser_name());
                //preparedStatement.executeQuery();
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    //String user_name = resultSet.getString("user_name");
                    String password = resultSet.getString("password");
                    //String email = resultSet.getString("email");

                    if (password.equals(user.getPassword()))
                        match.set(true);

                }
            } catch (SQLException e) {
                log.info("", e);
            }
        });
        return match.get();
    }
    public boolean findUsername(User user) {
        //List<User> users = new ArrayList<>();
        //AtomicReference<Boolean> ans = new AtomicReference<>(false);
        AtomicBoolean match = new AtomicBoolean(false);
        DBUtils.execSQL(connection -> {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select user_name from user_info where user_name= ?");
                preparedStatement.setString(1,user.getUser_name());
                //preparedStatement.executeQuery();
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    //String user_name = resultSet.getString("user_name");
                    String username = resultSet.getString("user_name");
                    //String email = resultSet.getString("email");

                    if (username.equals(user.getUser_name()))
                        match.set(true);

                }
            } catch (SQLException e) {
                log.info("", e);
            }
        });
        return match.get();
    }
    public void saveUserHistory(UserHistory userHistory) {
        DBUtils.execSQL(connection -> {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into user_history (user_name, id, drug_id, drug_name, summary, prescribing) values (?,?,?,?,?,?)");
                System.out.println("prepare Statement");
                preparedStatement.setString(1, userHistory.getUser_name());
                preparedStatement.setString(2, userHistory.getId());
                preparedStatement.setString(3, userHistory.getId());
                preparedStatement.setString(4, userHistory.getDrug_name());
                preparedStatement.setString(5, userHistory.getSummary());
                preparedStatement.setString(6, userHistory.getPrescribing());

                preparedStatement.execute();
            } catch (SQLException e) {
                log.info("", e);
            }
        });

    }

    public List<UserHistory> findhistory(String user_name) {
        List<UserHistory> history = new ArrayList<>();
        DBUtils.execSQL(connection -> {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from user_history where user_name=?");
                preparedStatement.setString(1, user_name);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String username = resultSet.getString(1);
                    String id = resultSet.getString(2);
                    String drug_id = resultSet.getString(3);
                    String drug_name = resultSet.getString(4);
                    String summary = resultSet.getString(5);
                    String prescribing = resultSet.getString(6);

                    UserHistory userHistory = new UserHistory(username, id, drug_id, drug_name, summary, prescribing);
                    history.add(userHistory);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        return history;
    }

    public Integer counthistory(String user_name) {
        AtomicInteger count = new AtomicInteger(0);
        DBUtils.execSQL(connection -> {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select count(user_name) from user_history where user_name=?");
                preparedStatement.setString(1, user_name);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    count.set(resultSet.getInt(1));
                    if (count.get()>50){
                        //String user_name = user.getUser_name();
                        deletehistory(user_name);
                        count.set(0);
                    }

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        return count.get();
    }

    public void deletehistory(String user_name) {
        DBUtils.execSQL(connection -> {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("delete from user_history where user_name=?");
                preparedStatement.setString(1, user_name);

                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public List<DrugInfo> drugsearch(String query) {
        List<DrugInfo> drugs = new ArrayList<>();
        DBUtils.execSQL(connection -> {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select dosing_guideline.id, drug.id, drug.name,dosing_guideline.name, dosing_guideline.recommendation,\n" +
                        "       drug.biomarker, drug_label.alternate_drug_available, dosing_guideline.source, drug_label.source,\n" +
                        "       drug_label.prescribing_markdown, dosing_guideline.summary_markdown from dosing_guideline, drug, drug_label \n" +
                        "       where (dosing_guideline.id=? and dosing_guideline.drug_id=drug.id and drug.id=drug_label.drug_id) \n" +
                        "       or (drug.id=? and dosing_guideline.drug_id=drug.id and drug.id=drug_label.drug_id);" );
                preparedStatement.setString(1, query);
                preparedStatement.setString(2, query);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String id = resultSet.getString("dosing_guideline.id");
                    String drug_id = resultSet.getString("drug.id");
                    String drug_name = resultSet.getString("drug.name");
                    String dosing_guideline_name = resultSet.getString("dosing_guideline.name");
                    Boolean recommendation = resultSet.getBoolean("dosing_guideline.recommendation");
                    Boolean biomarker = resultSet.getBoolean("drug.biomarker") ;
                    Boolean alternate_drug_available = resultSet.getBoolean("drug_label.alternate_drug_available");
                    String dosing_guideline_source = resultSet.getString("dosing_guideline.source");
                    String drug_label_source = resultSet.getString("drug_label.source");
                    String prescribing_markdown = resultSet.getString("drug_label.prescribing_markdown");
                    String summary_markdown = resultSet.getString("dosing_guideline.summary_markdown");

                    DrugInfo drugInfo = new DrugInfo(id, drug_id, drug_name, dosing_guideline_name, recommendation, biomarker,
                            alternate_drug_available, dosing_guideline_source, drug_label_source, prescribing_markdown, summary_markdown);
                    drugs.add(drugInfo);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        return drugs;
    }
}