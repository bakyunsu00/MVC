package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.ControllerV2;
import hello.servlet.web.frontcontroller.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "FrontControllerV2", urlPatterns ="/front-controller-v2/members/*")
public class FrontControllerV2 extends HttpServlet {



    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, ControllerV2> map = new HashMap<>();
        map.put("/front-controller-v2/members/new-form",new MemberFormControllerV2());
        map.put("/front-controller-v2/members/save",new MemberSaveControllerV2());
        map.put("/front-controller-v2/members/",new MemberListControllerV2());

        ControllerV2 controllerV2 = map.get(request.getRequestURI());

        if(controllerV2 == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyView myView = controllerV2.process(request,response);
        myView.render(request,response);








    }
}
