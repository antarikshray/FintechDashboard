package com.higradius;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class addInvoiceServlet
 */
@WebServlet("/addInvoiceServlet")
public class addInvoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addInvoiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		AddInvoiceService addInvoiceService = new AddInvoiceService();
		
		String bub = convertStreamToString(request.getInputStream());
		System.out.println(bub);
//		String result = addInvoiceService.addOneInvoice();
	}

}
