package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Modalidades;
import model.Olimpiadas;
import model.Pais;
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
	public ArrayList<Pais> oPais ;
	public ArrayList<Modalidades> oModalidades;
	

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
		String oTipo =request.getParameter("Tipo");
		
	    
	    Olimpiadas o= new Olimpiadas();
	    
	    o.setAno(oAno);
	    o.setTipo(oTipo);
		o.setModalidade(oModalidades);
	    o.setPais(oPais);
	    
	    OlimpiadasService os = new OlimpiadasService();
	    
	    os.criar(o);
	    
	    os.carregar(o);
	    
	    request.setAttribute("Olimp",o);
	    
	    PrintWriter out = response.getWriter();
		out.println("<html><head><title>Olimpiadas</title></head><body>");
		out.println( "ano: "+o.getAno()+"<br>");
		out.println( "tipo: "+o.getTipo()+"<br>");
		out.println( "pais: "+o.getPais()+"<br>");
		out.println( "modalidade: "+o.getModalidade()+"<br>");
		out.println("</body></html>");
	    		
	}

}
