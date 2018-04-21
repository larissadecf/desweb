package Controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Olimpiadas;
import service.OlimpiadasService;
/**
 * Servlet implementation class ManterOlimpiadasController
 */
@WebServlet("/ManterOlimpiadas.do")
public class ManterOlimpiadasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int oAno = Integer.parseInt(request.getParameter("ano")); 
		String oTipo =request.getParameter("tipo");
		
	    
	    Olimpiadas olimpiadas= new Olimpiadas();
	    
	    olimpiadas.setAno(oAno);
	    olimpiadas.setTipo(oTipo);
		
	    OlimpiadasService os = new OlimpiadasService();
	    
	    os.criar(olimpiadas);
	    
	    olimpiadas = os.carregar(olimpiadas.getAno());
	    
	    request.setAttribute("Olimp",olimpiadas);
	    

		RequestDispatcher view = request.getRequestDispatcher("ManterOlimpiadas.jsp");
		view.forward(request, response);
	    		
	}

}