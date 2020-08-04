package ru.geekbrains;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;


@WebServlet(name = "FirstHttpServlet/cart", urlPatterns = "/first-http-servlet/cart")
public class HTTPServletCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        resp.getWriter().println("<h1>Заголовок Корзина</h1>");
        resp.getWriter().println("<p>contextPath = " + req.getContextPath() + "</p>");
        resp.getWriter().println("<p>servletPath = " + req.getServletPath() + "</p>");
        resp.getWriter().println("<p>pathInfo = " + req.getPathInfo() + "</p>");
        resp.getWriter().println("<p>queryString = " + req.getQueryString() + "</p>");


        resp.getWriter().println("<h2>Ссылки: </h2");
        resp.getWriter().println("<p><a href='http://localhost:8080/first-web-app/first-http-servlet/main'>Основная страница</a></p");
        resp.getWriter().println("<p><a href='http://localhost:8080/first-web-app/first-http-servlet/catalog'>Каталог/Товары</a></p");
        resp.getWriter().println("<p><a href='http://localhost:8080/first-web-app/first-http-servlet/product'>Товар</a></p");
        resp.getWriter().println("<p><a href='http://localhost:8080/first-web-app/first-http-servlet/cart'>Корзина</a></p");
        resp.getWriter().println("<p><a href='http://localhost:8080/first-web-app/first-http-servlet/order'>Заказ</a></p");



        resp.getWriter().println("<h3>Parameters</h3>");
        req.getParameterMap().forEach(
                (param, value) -> {
                    try {
                        resp.getWriter().println("<p>" + param + " = " + Arrays.toString(value) + "</p>");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );

        req.setAttribute("attr","value");

//        getServletContext().getRequestDispatcher("/first-servlet").forward(req, resp);
        getServletContext().getRequestDispatcher("/first-servlet").include(req, resp);

    }
}
