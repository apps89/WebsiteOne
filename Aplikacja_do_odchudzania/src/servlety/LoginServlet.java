package servlety;

import Fabryka.FabrykaDAO;
import Fabryka.UserDAO;
import beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("Username");
        String pass = request.getParameter("Password");
        FabrykaDAO fabrykaDAO = FabrykaDAO.getFaktoryDAO(FabrykaDAO.anInt);
        UserDAO userDAO = fabrykaDAO.getUserDAO();
        User user = null;
        user = userDAO.read(login);
        if( user.getPass().equals(pass)){
        //    getServletContext().setAttribute("username", user.getLogin());
            request.getSession().setAttribute("username", user.getLogin());
            request.getRequestDispatcher("main.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("TryAgain.jsp").forward(request, response);

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
