package web.servlet;

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

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User user = new User(username,password,email);
        IUserService userService = new UserServiceImpl();
        boolean username1 = userService.findUsername(user);
        if (email!=null && username!=null && password!=null && username1 != true ) {
            userService.saveUserInfo(user);
            HttpSession session = request.getSession();
            session.setAttribute(UserFilter.EMAIL, email);
            session.setAttribute(UserFilter.ROLE_VIEW_DOSING_GUIDELINE, 1);
            session.setAttribute(UserFilter.USERNAME, user.getUser_name());
            response.sendRedirect(request.getContextPath()+"/jsp/success.jsp");
        }else {
            request.setAttribute("error", "The username is already taken");
            request.getRequestDispatcher("/jsp/signup.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/signup.jsp").forward(request, response);
    }
}
