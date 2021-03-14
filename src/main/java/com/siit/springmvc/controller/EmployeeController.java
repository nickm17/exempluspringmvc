package com.siit.springmvc.controller;

import com.siit.springmvc.model.dto.EmployeeCreationRequest;
import com.siit.springmvc.model.dto.EmployeeUpdateRequest;
import com.siit.springmvc.model.entity.EmployeeEntity;
import com.siit.springmvc.service.EmployeeService;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import javax.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

//    @Autowired
    private final EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET, path = {"/", "/showEmployees"})
    public String showEmployeesPage(Model model){
        // Model ->
        // ModelMap -> e o clasa concreta care implementeaza si Map
        // ModelAndView ->
        List<EmployeeEntity> employeeEntityList = employeeService.getAllEmployees();

        model.addAttribute("employeeList", employeeEntityList);
        EmployeeCreationRequest attributeValue = new EmployeeCreationRequest();

        model.addAttribute("employeeToAdd", attributeValue);

        Object employeeTrimisDinHtml = model.getAttribute("employeeTrimisDinHtml");
        //@ModelAttribute EmployeeEntity entity
        return "employees";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/add")
    public String showAddPage(ModelMap model){

        EmployeeCreationRequest attributeValue = new EmployeeCreationRequest();

        model.addAttribute("employeeToAdd", attributeValue);

        return "addEmployee";
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String add(@ModelAttribute(name = "employeeToAdd") @Valid EmployeeCreationRequest request, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "addEmployee";
        }

        employeeService.createEmployee(request);

        return showEmployeesPage(model);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add-all")
    @ResponseStatus(HttpStatus.CREATED)
    public String add(@ModelAttribute(name = "employeesToAdd") @Valid List<EmployeeCreationRequest> requestList,
                      Model model) {

        requestList.forEach(request -> employeeService.createEmployee(request));

        return showEmployeesPage(model);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{employeeId}/edit")
    public String showEditPage(@PathVariable(name = "employeeId") String id,
                               ModelMap model) {

        EmployeeEntity employee = employeeService.getEmployeeById(Integer.parseInt(id));
        model.addAttribute("employeeToEdit", employee);

        return "editEmployee";
    }

//    @RequestMapping(method = RequestMethod.POST, path = "/{employeeId}/edit")
    @PostMapping("/{employeeId}/edit")
    public String editEmployee(@PathVariable int employeeId,
                               @ModelAttribute(name = "employeeToEdit") @Valid EmployeeUpdateRequest request,
                               BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "editEmployee";
        }

        request.setId(employeeId);
        employeeService.updateEmployee(request);

        return showEmployeesPage(model);
    }

    @PostMapping("/{employeeId}/delete")
    public String deleteEmployee(@PathVariable int employeeId,
                                 Model model) {

        employeeService.deleteEmployeeById(employeeId);

        return showEmployeesPage(model);
    }

//    @RequestMapping(method = RequestMethod.GET, path = "/showDeparments")
//    public ModelAndView showDepartmentsPage(){
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("departments");
//        modelAndView.addObject("departmentsAttribute", new DepartmentEntity());
//
//        return modelAndView;
//    }

//    @ExceptionHandler(ValidationException.class)
//    public void badRequest(HttpServletResponse response, Exception e) throws IOException {
//        response.sendError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
//    }
}
