package service;

import domain.DrugInfo;
import domain.User;
import domain.UserHistory;

import java.util.List;

public interface IUserService {
    public boolean existsById(String user_name);
    public void saveUserInfo(User user);
    public boolean findPassword(User user);
    public boolean findUsername(User user);
    public void saveUserHistory(UserHistory userHistory);
    public List<UserHistory> findhistory(String user_name);
    public Integer counthistory(String user_name);
    public List<DrugInfo> drugsearch(String query);
    public void deletehistory(String user_name);
}
