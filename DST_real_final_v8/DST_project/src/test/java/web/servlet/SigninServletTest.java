package web.servlet;

import domain.User;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.IUserService;
import service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import static org.easymock.EasyMock.*;

public class SigninServletTest {
    private HttpServletRequest request;
    private SigninServlet servlet;
    private RequestDispatcher dispatcher;
    private UserServiceImpl userService;

    @Before
    public void setUp() throws Exception {
    request= EasyMock.createMock(HttpServletRequest.class);
    dispatcher=EasyMock.createMock(RequestDispatcher.class);
    userService=EasyMock.createMock(UserServiceImpl.class);
    servlet=new SigninServlet();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void Signinfalied() throws Exception{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username,password,"email");
        IUserService userService = new UserServiceImpl();
        boolean password1 = userService.findPassword(user);
        expect(password1).andReturn(false);

        replay(userService);
        verify(userService);

        servlet.doPost(request,null);

    }

    @Test
    public void Signinsuccess() throws Exception{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username,password,"email");
        IUserService userService = new UserServiceImpl();
        boolean password1 = userService.findPassword(user);
        expect(password1).andReturn(true);

        replay(userService);
        replay(request);
        replay(dispatcher);
        verify(userService);

        servlet.doPost(request,null);

    }

}