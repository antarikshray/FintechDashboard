package com.higradius;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;



/**
 * Servlet implementation class fetchInvoiceServlet
 */
@WebServlet("/fetchInvoiceServlet")
public final class fetchInvoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fetchInvoiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        String res = s.hasNext() ? s.next() : "";
        s.close();
        return res;
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bub = convertStreamToString(request.getInputStream());
		
		fetchTableService fetchedTable = new fetchTableService();
		List<PredictedTable> restable = null;
		restable = fetchedTable.getonInvoiceID(Double.parseDouble(bub));
		
		Gson gson = new Gson();
		String FetchedJson = gson.toJson(restable);
		PrintWriter printWriter = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		printWriter.write(FetchedJson);
		printWriter.close();
	}

}
