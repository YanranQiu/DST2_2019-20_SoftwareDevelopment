package filter;

import domain.Drug;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/dosingGuideline")
public class UserFilter implements Filter {

    public static final String ROLE_VIEW_DOSING_GUIDELINE = "role_view_drug_guideline";
    public static final String USERNAME = "username";
    public static final String EMAIL = "email";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession();
        Object username = session.getAttribute(USERNAME);
        Object email = session.getAttribute(EMAIL);
        String user= null;
        if (username != null | email != null) {

            Object roleViewDosingGuideline = session.getAttribute(ROLE_VIEW_DOSING_GUIDELINE);
            if (roleViewDosingGuideline != null && ((Integer) roleViewDosingGuideline) == 1) {
                chain.doFilter(request, response);
            }
            else {
                user= "";
                request.setAttribute("user",user);
                request.getRequestDispatcher("/jsp/index.jsp").forward(request,response);
                /*response.getWriter().write("You are not allowed to view dosing guideline, please <a href='signin'>sign in</a> first.");
*/            }
        } else {
            user= "";
            request.setAttribute("user", user);
            request.getRequestDispatcher("/jsp/index.jsp").forward(request,response);
            /*response.getWriter().write("You are not allowed to view dosing guideline, please <a href='signin'>sign in</a> first.");
*/        }
    }

    @Override
    public void destroy() {

    }
}