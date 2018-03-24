package fr.istic.m2;

import com.googlecode.objectify.ObjectifyService;

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
    static {
        ObjectifyService.register(Advertisement.class);
    }
    @Override
    public void init(ServletConfig conf) throws ServletException {
        super.init(conf);
        ArrayList<Advertisement> ads = new ArrayList<>();
        conf.getServletContext().setAttribute("pendingAds", ads);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Advertisement> pendingAds =
                (List<Advertisement>) this
                        .getServletConfig()
                        .getServletContext()
                        .getAttribute("pendingAds");

        String title = (String) req.getParameter("ad-title");
        int price = Integer.parseInt(req.getParameter("ad-price"));
        String contents = (String) req.getParameter("ad-contents");
        Date today = new Date();

        if(title != null && contents != null) {
            System.out.println(title + ": " + contents);
            Advertisement ad = new Advertisement(title, price, contents, today);
            pendingAds.add(ad);
            this.getServletConfig().getServletContext().setAttribute("pendingAds", pendingAds);

            List<Advertisement> ads = ObjectifyService.ofy().load().type(Advertisement.class).list();
            req.setAttribute("ads", ads);

            this.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Advertisement> ads = ObjectifyService.ofy().load().type(Advertisement.class).list();
        req.setAttribute("ads", ads);

        this.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}