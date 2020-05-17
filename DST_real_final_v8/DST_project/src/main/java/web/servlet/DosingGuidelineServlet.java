package web.servlet;

import domain.DosingGuideline;
import domain.DrugLabel;
import service.IDosingGuidelineService;
import service.IDruglabelService;
import service.impl.DosingGuidelineServiceImpl;
import service.impl.DrugLabelServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dosingGuideline")
public class DosingGuidelineServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IDosingGuidelineService dosingGuidelineService = new DosingGuidelineServiceImpl();
        List<DosingGuideline> dosingGuidelines = dosingGuidelineService.findAll();
        request.setAttribute("dosingGuidelines", dosingGuidelines);
        request.getRequestDispatcher("/jsp/dosing_guideline.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
