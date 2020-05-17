package web.servlet;

import dao.IDrugLabeldao;
import domain.Drug;
import service.IDrugService;
import service.impl.DrugServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/drug")
public class DrugServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IDrugService drugService = new DrugServiceImpl();
        List<Drug> drugs = drugService.findAll();
        request.setAttribute("drugs",drugs);
        request.getRequestDispatcher("/jsp/drugs.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
