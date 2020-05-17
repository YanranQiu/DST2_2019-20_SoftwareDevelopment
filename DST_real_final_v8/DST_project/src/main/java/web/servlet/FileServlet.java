package web.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.file.attribute.FileTime;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@WebServlet("/file")
public class FileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!ServletFileUpload.isMultipartContent(request)) {
            throw new RuntimeException("error");
        }
        try {
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            String temppath = this.getServletContext().getRealPath("/temp");
            File temp = new File(temppath);
            diskFileItemFactory.setRepository(temp);
            ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
            List<FileItem> fileItems = upload.parseRequest(request);
            for (FileItem item : fileItems) {
                if (item.isFormField()) {
                    String fieldName = item.getFieldName();
                    String filevalue = item.getString();
                    System.out.println(fieldName + "=" + filevalue);
                } else {
                    String name = item.getName();
                    InputStream inputStream = item.getInputStream();
                    String savepath = this.getServletContext().getRealPath("/annovar");
                    File outFile = new File(savepath, name);
                    OutputStream outputStream = new FileOutputStream(outFile);
                    int len = -1;
                    byte[] buf = new byte[1024];
                    while ((len = inputStream.read(buf)) != -1) {
                        outputStream.write(buf, 0, len);
                    }
                    BufferedReader br = new BufferedReader(new FileReader(outFile));
                    String str = null;
                    String string = "";
                    while ((str = br.readLine()) != null) {
                        string = string + "\n" + str;
                    }
                    HttpSession session = request.getSession();
                    session.setAttribute("filename", name);
                    session.setAttribute("content", string);
                    outputStream.close();
                    inputStream.close();
                    //delete temp file
                    item.delete();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        String filename = (String) session.getAttribute("filename");
        String filter = null;
        if (Pattern.matches(".*?csv",filename)| Pattern.matches(".*?tsv",filename)|Pattern.matches(".*?txt",filename)) {
             filter = "success";
            session.setAttribute("filter", filter);
        } else {
            filter = null;
            session.setAttribute("filter", null);
        }
        request.getRequestDispatcher("/jsp/viewannovar.jsp").forward(request,response);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
