package web.servlet;

import domain.DrugLabel;
import service.IDruglabelService;
import service.impl.DrugLabelServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/druglabel")
public class DrugLabelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IDruglabelService drugLabelService = new DrugLabelServiceImpl();
        List<DrugLabel> drugLabels = drugLabelService.findAll();
        request.setAttribute("drugLabels",drugLabels);
        request.getRequestDispatcher("/jsp/druglabels.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
