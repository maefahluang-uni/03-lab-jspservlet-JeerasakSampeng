package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet(urlPatterns = "/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        int weight = Integer.parseInt(request.getParameter("weight"));
        Double height = Double.parseDouble(request.getParameter("height"));
        
        //TODO: calculate bmi
        Double BMI = weight/(height*height);
        Math.round(BMI);

        //TODO: determine the built from BMI
        String builtType;
        if(BMI < 18.5){
            builtType = "underweight";
        }else if(BMI >= 18.5 && BMI <25){
            builtType = "normal";
        }else if(BMI >= 25 && BMI < 30){
            builtType = "overweight";
        }else if(BMI >= 30 && BMI < 35){
            builtType = "obese";
        }else{
            builtType = "extremely obese";
        }
            
             
      
        //TODO: add bmi and built to the request's attribute
        request.setAttribute("BMI", BMI);
        request.setAttribute("builtType", builtType);

        //TODO: forward to jsp
        request.getRequestDispatcher("bmi_result.jsp").forward(request, response);
           
    }
    
}