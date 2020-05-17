package web.servlet;

import domain.UserHistory;
import service.IUserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserService userService = new UserServiceImpl();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        List<UserHistory> history = userService.findhistory(username);
        request.setAttribute("history",history);
        Integer counthistory = userService.counthistory(username);
        request.setAttribute("counthistory",counthistory);
        request.getRequestDispatcher("/jsp/history.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
