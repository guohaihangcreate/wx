package com.create.core.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SalaryQueryServlet
 */
@WebServlet("/salaryQuery")
public class SalaryQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalaryQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String openid =request.getParameter("openid");
		String year_month = request.getParameter("year_month"); 
		year_month = new String(year_month .getBytes("iso8859-1"),"utf-8");
		String year = year_month.split(" ")[0].split("年")[0];
		String month = year_month.split(" ")[1].split("月")[0];
		String ino =request.getParameter("ino");
		request.setAttribute("title", year_month);
		request.setAttribute("salary", "salary");
		//根据身份证id，年份，月份获取相应的薪资发放信息
		request.getRequestDispatcher("/xzcx_month.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
