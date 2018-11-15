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

@WebServlet("/RegistredServlet")
public class RegistredServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String login = request.getParameter("username");
        String pass = request.getParameter("password");
        String height = request.getParameter("height");
        String weight = request.getParameter("weight");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        FabrykaDAO fabrykaDAO = FabrykaDAO.getFaktoryDAO(FabrykaDAO.anInt);
        UserDAO userDAO = fabrykaDAO.getUserDAO();
        User user = new User(login, pass,email, age, height, weight, sex);
        boolean results = false;
        results = userDAO.create(user);

        if(user != null && results) {
          //  getServletContext().setAttribute("username", user.getLogin());
            request.getSession().setAttribute("username", user.getLogin());
            request.getRequestDispatcher("main.jsp").forward(request, response);


        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
