package Servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.BoardBean;
import Dao.BoardDao;

/**
 * Servlet implementation class boarddelete
 */
@WebServlet("/boarddelete")
public class boarddelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public boarddelete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("delete");
		int int_id = Integer.parseInt(id);

		BoardBean bb = BoardDao.board_search(int_id);
		File newdir = new File("C:\\pleiades\\workspace\\keiziban\\WebContent\\upload\\"+bb.getApp_file());
		newdir.delete();

		BoardDao.delete_board(int_id);




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
