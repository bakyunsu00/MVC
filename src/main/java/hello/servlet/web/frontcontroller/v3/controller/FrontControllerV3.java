package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.web.frontcontroller.ControllerV3;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "FrontControllerV3", urlPatterns ="/front-controller-v3/members/*")
public class FrontControllerV3 extends HttpServlet {

    private Map<String, ControllerV3> map = new HashMap<>();

    public FrontControllerV3() {
        map.put("/front-controller-v3/members/new-form",new MemberFormControllerV3());
        map.put("/front-controller-v3/members/save",new MemberSaveControllerV3());
        map.put("/front-controller-v3/members/",new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
        ControllerV3 controllerV3 = map.get(request.getRequestURI());

        if(controllerV3 == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request);

        ModelView modelView = controllerV3.process(paramMap);

        MyView view = viewResolver(modelView);

        view.render(modelView.getModel(),request,response);








    }

    private static MyView viewResolver(ModelView modelView) {
        String viewName = modelView.getViewName();
        MyView view = new MyView("/WEP-INF/views/"+viewName+".jsp");
        return view;
    }

    private static Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)) );
        return paramMap;
    }
}
