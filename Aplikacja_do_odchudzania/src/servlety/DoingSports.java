package servlety;

import Fabryka.FabrykaDAO;
import Fabryka.SportDAO;
import Fabryka.UserDAO;
import beans.Sport;
import beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.Random;

@WebServlet("/DoingSports")
public class DoingSports extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object login = request.getSession().getAttribute("username");
        FabrykaDAO fabrykaDAO = FabrykaDAO.getFaktoryDAO(FabrykaDAO.anInt);
        UserDAO userDAO = fabrykaDAO.getUserDAO();
        User user = null;
        user = userDAO.read(login.toString());
        int category = user.getCategory();
        SportDAO sportDAO = fabrykaDAO.getSportDAO();
        List<Sport> sportList =  sportDAO.readAll(category);
        Random generator = new Random();
        Sport sport = sportList.get(generator.nextInt(sportList.size() ));

        PrintWriter out = response.getWriter();
        out.println(sport.getDescribe());

        request.setAttribute("sport", sport);
        request.getRequestDispatcher("MyActivity.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
