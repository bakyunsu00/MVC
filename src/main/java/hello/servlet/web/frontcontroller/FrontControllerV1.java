package hello.servlet.web.frontcontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet(name = "frontControllerV1", urlPatterns = "/front-controller/members/*")
public class FrontControllerV1 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String,ControllerV1> stringMap= new HashMap<>();

        stringMap.put("/front-controller/members/new-form",new MemberFormControllerV1());
        stringMap.put("/front-controller/members/",new MemberListControllerV1());
        stringMap.put("/front-controller/members/save",new MemberSaveControllerV1());

        String getString = request.getRequestURI();

        ControllerV1 controllerV1 = stringMap.get(getString);

        if (controllerV1 == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controllerV1.process(request, response);




    }
}
