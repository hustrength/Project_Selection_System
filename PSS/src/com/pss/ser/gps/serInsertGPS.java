package com.pss.ser.gps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pss.dao.DaoPro;
import com.pss.dao.DaoGPS;
import com.pss.dao.DaoStu;
import com.pss.user.Student;
import com.pss.user.Project;
import com.pss.user.GPS;

public class serInsertGPS extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");	
		HttpSession session = request.getSession(); 
		PrintWriter out = response.getWriter();
		int rs;
		DaoGPS insert = new DaoGPS();
		GPS gps=null;
		String act=request.getParameter("action");
		if("create".equals(act)){
			//创建队伍
			String gname = request.getParameter("Gname");
			System.out.println(gname);
			int pno = Integer.parseInt(request.getParameter("PNo"));
			DaoPro querybypno=new DaoPro();
			Project pro=querybypno.querybypno(pno);
			String pname = pro.getPname();
			//Student stu = (Student)session.getAttribute("student");
			Student stu=new Student("U1", "学生1号", "0","男", "CS1705", "","",0);
			int gsnum = Integer.parseInt(request.getParameter("Gsnum"));
			gps=new GPS(pno,gname,pname,stu,gsnum);
			rs=insert.insertGPS(gps);
			if(rs==0){
				response.getWriter().print("fail");
			}
			else{
				response.getWriter().print("success");
			}
		}
	}

	

}
