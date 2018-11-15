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
import java.util.List;

@WebServlet( "/MyProfil")
public class MyProfil extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Object login = request.getSession().getAttribute("username");
        FabrykaDAO fabrykaDAO = FabrykaDAO.getFaktoryDAO(FabrykaDAO.anInt);
        UserHistoryDAO userHistoryDAO = fabrykaDAO.getUserHistoryDAO();
        List<UserHistory> userHistoryDAOList = userHistoryDAO.readAll(login.toString());

        request.setAttribute("userHistory", userHistoryDAOList);
        request.getRequestDispatcher("MyProfile.jsp").forward(request,
                response);
    }
}
