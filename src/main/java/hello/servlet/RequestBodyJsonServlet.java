package hello.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-json-body")
public class RequestBodyJsonServlet extends HttpServlet {
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ServletInputStream inputStream = request.getInputStream();
        String jsonBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        User user = objectMapper.readValue(jsonBody,User.class);
        System.out.println(user.getUserName());
        System.out.println(user.getAge());





    }
}
