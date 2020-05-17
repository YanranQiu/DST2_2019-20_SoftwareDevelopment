package web.servlet;

import dao.IAnnovardao;
import domain.DrugInfo;
import filter.UserFilter;
import service.IAnnovarService;
import service.IUserService;
import service.impl.AnnovarServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@WebServlet("/annovarresult")
public class AnnovarResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IAnnovarService annovarservice = new AnnovarServiceImpl();
        HttpSession session = request.getSession();
        String content = (String) session.getAttribute("content");
        String filename = (String) session.getAttribute("filename");
        if (content != null){
            annovarservice.save(filename,content);
            List<String> symbols = annovarservice.getSymbol(filename);
            IUserService userService = new UserServiceImpl();
            List<List<String>> drugIDlist = new ArrayList<>();
            for (int i=0; i<symbols.size(); i++) {
                List<String> drugIDs = annovarservice.findDrug(symbols.get(i));
               /* List<String> drugIDs = annovarservice.findDrug("TPMT");*/
                drugIDlist.add(drugIDs);
                }
            ArrayList<Object> allinfo = new ArrayList<>();
            for (int n=0;n<drugIDlist.size();n++){
                for (int h=0;h<drugIDlist.get(n).size();h++) {
                    List<String> info = new ArrayList<>();
                    info.add(symbols.get(n));
                    info.add(drugIDlist.get(n).get(h));
                    List<DrugInfo> drugInfos = userService.drugsearch(drugIDlist.get(n).get(h));
                    if (drugInfos.size()!= 0) {
                        info.add(String.valueOf(drugInfos.get(0).getDrug_name()));
                        info.add(String.valueOf(drugInfos.get(0).getDosing_guideline_summary_markdown()));
                    }else{
                        info.add(null);
                        info.add(null);
                    }
                    info.add(filename);
                    allinfo.add(info);
                }
            }
            request.setAttribute("allinfo",allinfo);
            String annovar = null;
            if (drugIDlist!=null&& allinfo.size()>0) {
                annovar = "success";
                session.setAttribute("annovar", annovar);
            } else {
                session.setAttribute("annovar", null);
            }
            request.getRequestDispatcher("jsp/result.jsp").forward(request,response);
        }else {
            System.out.println("error");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
