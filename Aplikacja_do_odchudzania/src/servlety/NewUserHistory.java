package servlety;

import Fabryka.FabrykaDAO;
import Fabryka.UserHistoryDAO;
import beans.UserHistory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet("/NewUserHistory")
public class NewUserHistory extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String weight = request.getParameter("weight");
        String descriptions = request.getParameter("description");
        Object login = request.getSession().getAttribute("username");
        FabrykaDAO fabrykaDAO = FabrykaDAO.getFaktoryDAO(FabrykaDAO.anInt);
        UserHistoryDAO userHistoryDAO = fabrykaDAO.getUserHistoryDAO();
        UserHistory userHistory = new UserHistory(login.toString(), descriptions, LocalDate.now(), weight);
        boolean results = userHistoryDAO.create(userHistory);
        if(results) {
            request.getRequestDispatcher("main.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("cos.jsp").forward(request, response);

        }

//        PrintWriter out = response.getWriter();
//        out.println(descriptions);
//        out.println(weight);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
