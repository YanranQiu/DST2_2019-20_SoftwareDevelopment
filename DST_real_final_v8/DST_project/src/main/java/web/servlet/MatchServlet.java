package web.servlet;
import dao.IUserdao;
import domain.*;
import filter.UserFilter;
import service.IDosingGuidelineService;
import service.IDrugService;
import service.IDruglabelService;
import service.IUserService;
import service.impl.DosingGuidelineServiceImpl;
import service.impl.DrugLabelServiceImpl;
import service.impl.DrugServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ClientInfoStatus;
import java.util.List;

@WebServlet("/match")
public class MatchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserService userService = new UserServiceImpl();
        String query = request.getParameter("query");
        List<DrugInfo> drugsearch = userService.drugsearch(query);
        request.setAttribute("drugsearch",drugsearch);
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
           if (null != drugsearch && drugsearch.size() >=1) {
               String string1 = String.valueOf(drugsearch.get(0).getDosing_guideline_id());
               String string2 = String.valueOf(drugsearch.get(0).getDrug_id());
               String string3 = String.valueOf(drugsearch.get(0).getDrug_name());
               String string4 = String.valueOf(drugsearch.get(0).getDosing_guideline_summary_markdown());
               String string5 = String.valueOf(drugsearch.get(0).getDrug_label_prescribing_markdown());
               UserHistory userHistory = new UserHistory(username,string1,string2,string3,string4,string5);
               userService.saveUserHistory(userHistory);
            request.getRequestDispatcher("/jsp/match.jsp").forward(request,response);
        } else {
            String nomatch = "nomatch";
            request.setAttribute("nomatch", nomatch);
            request.getRequestDispatcher("/").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
