package hello.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.http.HttpRequest;

@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamSevlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //단일 조회
        System.out.println("username = "+ request.getParameter("username"));
        System.out.println("age = "+ request.getParameter("age"));
        //복수 조회
        String[] usernames = request.getParameterValues("username");
        for(String username: usernames){
            System.out.println("username = "+username);
        }

        if(request.getParameter("username").equals("Park")){
            response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
            response.setHeader("Location","http://localhost:8080");
            System.out.println("wow");

        }

    }
}


