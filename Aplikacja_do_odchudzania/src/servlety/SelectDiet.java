package servlety;

import Fabryka.*;
import beans.Breakfast;
import beans.Dinner;
import beans.Supper;
import beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@WebServlet("/SelectDiet")
public class SelectDiet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object login = request.getSession().getAttribute("username");
        FabrykaDAO fabrykaDAO = FabrykaDAO.getFaktoryDAO(FabrykaDAO.anInt);
        UserDAO userDAO = fabrykaDAO.getUserDAO();
        User user = null;
        user = userDAO.read(login.toString());
        int category = user.getCategory();

    //    PrintWriter out = response.getWriter();
    //    out.println(descriptions);


        BreakfastDAO breakfastDAO = fabrykaDAO.getBreakfastDAO();
        List<Breakfast> breakfasts = breakfastDAO.readAll(category);

        PrintWriter out = response.getWriter();

        DinnerDAO dinnerDAO = fabrykaDAO.getDinnerDAO();
        List<Dinner> dinners = dinnerDAO.readAll(category);

        SupperDAO supperDAO = fabrykaDAO.getSupperDAO();
        List<Supper> suppers = supperDAO.readAll(category);

        List<Breakfast> breakfastList = new ArrayList<>();
        List<Dinner> dinnerList = new ArrayList<>();
        List<Supper> supperList = new ArrayList<>();

        Breakfast breakfast = null;
        Dinner dinner = null;
        Supper supper = null;
        int a;
        int b;
        int c;
        Random generator = new Random();

        for(int i=0; i<7; i++){
            a = generator.nextInt(breakfasts.size() );
            b = generator.nextInt(dinners.size() );
            c = generator.nextInt(suppers.size() );

            breakfast = breakfasts.get(a);
            dinner = dinners.get(b);
            supper = suppers.get(c);


            breakfastList.add(breakfast);
            dinnerList.add(dinner);
            supperList.add(supper);

            breakfasts.remove(a);
            dinners.remove(b);
            suppers.remove(c);
        }
        int price  = breakfastList.stream().collect(Collectors.summingInt(e -> e.getCost())) +
                dinnerList.stream().collect(Collectors.summingInt(e -> e.getCost())) +
                supperList.stream().collect(Collectors.summingInt(e -> e.getCost()));

        int calories =  breakfastList.stream().collect(Collectors.summingInt(e -> e.getCalory())) +
                dinnerList.stream().collect(Collectors.summingInt(e -> e.getCalory())) +
                supperList.stream().collect(Collectors.summingInt(e -> e.getCalory()));

        calories /= 7;

        request.setAttribute("breakfast", breakfastList);
        request.setAttribute("dinner", dinnerList);
        request.setAttribute("supper", supperList);
        request.setAttribute("price", price);
        request.setAttribute("kalorie", calories);

        request.getRequestDispatcher("MyDiet.jsp").forward(request,
                response);



    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
