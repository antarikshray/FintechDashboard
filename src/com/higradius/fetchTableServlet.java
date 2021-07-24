package com.higradius;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.higradius.fetchTableService;
import com.google.gson.Gson;
import com.higradius.PredictedTable;

/**
 * Servlet implementation class fetchTableServlet
 */
@WebServlet("/fetchTableServlet")
public class fetchTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fetchTableServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fetchTableService fetchedTable = new fetchTableService();
		List<PredictedTable> restable = null;
		restable = fetchedTable.getAllTables();
		
		Gson gson = new Gson();
		String FetchedJson = gson.toJson(restable);
		PrintWriter printWriter = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		printWriter.write(FetchedJson);
		printWriter.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
}
