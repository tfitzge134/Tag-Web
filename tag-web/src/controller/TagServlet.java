package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TagServlet
 */
@WebServlet("/")
public class TagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<Tag> tags = new ArrayList<Tag>();
     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TagServlet() {
        super();
        // TODO Auto-generated constructor stub
        Tag t = new Tag();
        t.setIsbn_13("4444444444444");
        t.setTags_name("Comedy");
        tags.add(t);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("tags",  tags);
		request.getRequestDispatcher("ViewTag.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn_13 = request.getParameter("isbn_13");
		String tags_name = request.getParameter("tags_name");
		
		Tag tag = new Tag();
		tag.setIsbn_13(isbn_13);
		tag.setTags_name(tags_name);
	tags.add(tag);
		
		
		request.setAttribute("tags", tags);
		request.getRequestDispatcher("ViewTag.jsp").forward(request, response);
	}

}
