package fr.istic.m2;

import com.googlecode.objectify.ObjectifyService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Persist", value = "/persist")
public class PersistServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Advertisement> ads =
                (List<Advertisement>) this
                        .getServletConfig()
                        .getServletContext()
                        .getAttribute("ads");

        ObjectifyService.ofy().save().entities(ads).now();
        this.getServletConfig().getServletContext().setAttribute("ads", new ArrayList<Advertisement>());

        response.sendRedirect("/index.jsp");
    }
}
