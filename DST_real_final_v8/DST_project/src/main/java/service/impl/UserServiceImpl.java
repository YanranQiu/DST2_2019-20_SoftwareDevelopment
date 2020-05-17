package service.impl;

import dao.IUserdao;
import dao.impl.UserdaoImpl;
import domain.DrugInfo;
import domain.User;
import domain.UserHistory;
import service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
    private IUserdao dao = new UserdaoImpl();
    public boolean existsById(String user_name){
        return dao.existsById(user_name);
    };
    public void saveUserInfo(User user){
        dao.saveUserInfo(user);
    };
    public boolean findPassword(User user){
        return dao.findPassword(user);
    };
    public boolean findUsername(User user){return dao.findUsername(user);};
    public void saveUserHistory(UserHistory userHistory){dao.saveUserHistory(userHistory);};
    public List<UserHistory> findhistory(String user_name){return dao.findhistory(user_name);};
    public Integer counthistory(String user_name){return dao.counthistory(user_name);};
    public List<DrugInfo> drugsearch(String query){return dao.drugsearch(query);};
    public void deletehistory(String user_name){dao.deletehistory(user_name);};
}
