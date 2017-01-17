package servlet;


import entity.User;
import exception.UserDaoException;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet{

 /*   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("registration.jsp");
        rd.forward(req, resp);*/
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("registration.jsp").forward(req, resp);}

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("name");
        String password = req.getParameter("password");
        User user = new User();
        user.setName(username);
        user.setPassword(password.getBytes());
        user.setRole("User");

        UserService service = new UserServiceImpl();
        try {
            service.create(user);
        } catch (UserDaoException e) {
            e.printStackTrace();
        }

        resp.setStatus(200);
    }
}
