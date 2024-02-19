package com.example.web4;

import com.example.web4.Model.Employee;
import com.example.web4.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class HomeController {
    @Autowired
    private EmployeeService service;


    @RequestMapping("/")
    public String home(ModelMap model)
    {
        System.out.println("HOME PAGE IS CALLED");

//        return "employeereport";
        return "index";
    }


    @RequestMapping("/GenerateEmployee")
    public String GenerateEmployee(Employee employee, Model model)
    {
        System.out.println("IAMD BAHNU"+employee);
        service.addEmployee(employee);
//        service.viewAllEmployee();
        if(service.checkingData(employee))
        {

            model.addAttribute("allEmployee",service.viewAllEmployee());
            return "viewEmployees";
        }
        else{
            System.out.println("generate element");
            String res="Please enter all details";
            model.addAttribute("res",res);
            return "updateResult";
        }


    }
    @RequestMapping("/Singleemployee")
    public String Singleemployee()
    {
        System.out.println("Bhanuprakash");
        return "SearchEmployee";
    }
    @RequestMapping("/employeereport")
    public String employeereport()
    {
        return "employeereport";
    }
    @RequestMapping("/SearchEmployee")
    public String SearchEmployee( String eid,Model model)
    {
        System.out.println("METHOD CALLED");
        System.out.println(eid);
        Employee e2=service.Search(eid);
        System.out.println(e2.getEname());
        model.addAttribute("employee",e2);
        return "singleEmployee";
    }
    @RequestMapping("/viewEmployees")
    public String viewEmployees(Model model)
    {
        model.addAttribute("allEmployee",service.viewAllEmployee());
        System.out.println("all employee method is called");
        ArrayList<Employee> a=service.viewAllEmployee();
        System.out.println(a.get(0).getEname());
//        return "removeResult";
        return "viewEmployees";
    }

    //removeing element

    @RequestMapping("/removeemployee1")
    public String removeemployee1()
    {
        return "removeemployee";
    }
    @RequestMapping("/removeemployee")
    public String removeemployee( String eid,Model model)
    {
        System.out.println("remove layer is called CALLED");
        System.out.println(eid);
        String res=service.Remove(eid);
        System.out.println(res);
        model.addAttribute("result",res);
        return "removeResult";
    }

    @RequestMapping("/SearchUpdateEmployee")
    public String SearchUpdateEmployee()
    {
        System.out.println("search method is called");
        return "SearchUpdateEmployee";
    }
    @RequestMapping("/updateEmployee")
    public String updateEmployee(String eid,Model model)
    {


        System.out.println("update method is called");
        if(service.checkingForEmployee(eid))
        {
            model.addAttribute("singleEmployee",service.viewSingleEmployee(eid));
            return "updateEmployee";

        }
        else{
            String res="Employee not found";
            model.addAttribute("res",res);
            return "updateResult";
        }


    }
    @RequestMapping("/SuccesfullUpdate")
    public String SuccesfullUpdate(Employee employee,Model model)
    {
        String res=service.updateEmployee(employee);
        model.addAttribute("res",res);
        return "updateResult";

    }



}
