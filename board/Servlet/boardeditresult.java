package Servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.BoardBean;
import Dao.BoardDao;

/**
 * Servlet implementation class boardeditresult
 */
@WebServlet("/boardeditresult")
public class boardeditresult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardeditresult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String content = request.getParameter("content");
		String app_file = request.getParameter("app_file");

		HttpSession session = request.getSession();
		BoardBean bb = (BoardBean)session.getAttribute("edit_board");


		LocalDateTime date = LocalDateTime.now();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年/MM月/dd日 HH時mm分ss秒 E曜日");

		String time_edit = dtf.format(date);


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



		BoardDao.set_board(bb.getId(),name,mail,time_edit,content,app_file);


		String view = "/keiziban/managementtop";
		response.sendRedirect(view);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
