package hello.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "responseBodyJson",  urlPatterns = "/response-json")
public class ResponseBodyJson extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        User user = new User();
        user.setUserName("park");
        user.setAge(29);


        ObjectMapper objectMapper = new ObjectMapper();
        String jsons = objectMapper.writeValueAsString(user);
        response.getWriter().write(jsons);

    }
}



