package web.servlet;
import dao.IUserdao;
import dao.impl.UserdaoImpl;
import domain.User;
import filter.UserFilter;
import service.IUserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username,password,"email");
        IUserService userService = new UserServiceImpl();
        boolean password1 = userService.findPassword(user);
        if (password1) {
            HttpSession session = request.getSession();
            session.setAttribute(UserFilter.ROLE_VIEW_DOSING_GUIDELINE, 1);
            session.setAttribute(UserFilter.USERNAME, user.getUser_name());
            session.setAttribute(username, user.getUser_name());
            response.sendRedirect(request.getContextPath()+"/jsp/index.jsp");
        } else {
            request.setAttribute("error", "username or password error");
            request.getRequestDispatcher("/jsp/signin.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/signin.jsp").forward(request, response);
    }
}
