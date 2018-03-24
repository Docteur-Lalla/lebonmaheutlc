package fr.istic.m2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Adboard", value = "/")
public class AdboardServlet extends HttpServlet {
    @Override
    public void init(ServletConfig conf) throws ServletException {
        super.init(conf);
        ArrayList<Advertisement> ads = new ArrayList<>();
        conf.getServletContext().setAttribute("ads", ads);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Advertisement> ads =
                (List<Advertisement>) this
                        .getServletConfig()
                        .getServletContext()
                        .getAttribute("ads");

        String title = (String) req.getParameter("ad-title");
        int price = Integer.parseInt(req.getParameter("ad-price"));
        String contents = (String) req.getParameter("ad-contents");
        Date today = new Date();

        if(title != null && contents != null) {
            System.out.println(title + ": " + contents);
            Advertisement ad = new Advertisement(title, price, contents, today);
            ads.add(ad);

            resp.sendRedirect("/index.jsp");
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/index.jsp");
    }
}