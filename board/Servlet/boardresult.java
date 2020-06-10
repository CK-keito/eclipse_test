package Servlet;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Bean.BoardBean;
import Dao.BoardDao;
/**
 * Servlet implementation class boardresult
 */
@WebServlet("/boardresult")
@MultipartConfig(maxFileSize=1048576)
public class boardresult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	final File uploadDir = new File("C:\\pleiades\\workspace\\keiziban\\WebContent\\upload");  // ファイル保存先

	public void init() throws ServletException {
	    uploadDir.mkdir();
	  }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardresult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	request.setCharacterEncoding("UTF-8");


        Part fPart = request.getPart("file");

        String fname = this.getFileName(fPart);


        if(!(fname.equals(""))){

        	fPart.write("C:\\pleiades\\workspace\\keiziban\\WebContent\\upload\\" + fname);
        }



    	String name = request.getParameter("name");
    	String mail = request.getParameter("mail");
    	String content = request.getParameter("content");


		LocalDateTime date = LocalDateTime.now();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年/MM月/dd日 HH時mm分ss秒 E曜日");

		String time_contribute = dtf.format(date);



		if(name.contains("<")){
			name = name.replace("<", "&lt");
		}
		if(name.contains(">")){
			name = name.replace("<", "&gt");
		}

		if(mail.contains("<")){
			mail = mail.replace("<", "&lt");
		}
		if(mail.contains(">")){
			mail = mail.replace("<", "&gt");
		}

		if(content.contains("<")){
			content = content.replace("<", "&lt");
		}
		if(content.contains(">")){
			content = content.replace("<", "&gt");
		}


		BoardBean bb = new BoardBean(name,mail,time_contribute,content,fname);

		BoardDao.insertboard(bb);





		String view = "http://localhost:8080/keiziban/boardtop";
		response.sendRedirect(view);
	}

    private String getFileName(Part part) {
        String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }

        return name;
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
