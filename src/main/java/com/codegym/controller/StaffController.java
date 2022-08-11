package com.codegym.controller;

import com.codegym.model.Branch;
import com.codegym.model.Staff;
import com.codegym.service.BranchService;
import com.codegym.service.StaffService;
import com.codegym.validate.ValidateEditStaff;
import com.codegym.validate.ValidateStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class StaffController {
    @Autowired
    StaffService staffService;

    @Autowired
    BranchService branchService;

    @Autowired
    ValidateStaff validateStaff;

    @Autowired
    ValidateEditStaff validateEditStaff;

    @ModelAttribute(name = "staff")
    public Staff staff(){
        return new Staff();
    }

    @ModelAttribute(name = "branchList")
    public List<Branch> branch(){
        return branchService.getAll();
    }

    @GetMapping("/staff")
    public ModelAndView show(@RequestParam(defaultValue = "") String message) {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("staffs", staffService.getAll());
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(@RequestParam String search) {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("staffs", staffService.getAllByName(search));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("staff", new Staff());
//        modelAndView.addObject("branchList", branchService.getAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute("staff") Staff staff, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        validateStaff.validate(staff,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("create");
            return modelAndView;
        }
        staffService.save(staff);
        ModelAndView modelAndView = new ModelAndView("redirect:/staff");
        redirectAttributes.addAttribute("message", "Create successfully!");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        Optional<Staff> staff = staffService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("staff", staff);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@Valid @ModelAttribute("staff") Staff staff, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        validateEditStaff.validate(staff,bindingResult);
        if (bindingResult.hasFieldErrors()) {

            ModelAndView modelAndView = new ModelAndView("edit");

            return modelAndView;
        }
        staffService.save(staff);
        ModelAndView modelAndView = new ModelAndView("redirect:/staff");
        redirectAttributes.addAttribute("message", "Edit successfully!");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("staff", staffService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id,RedirectAttributes redirectAttributes) {
        staffService.delete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/staff");
        redirectAttributes.addAttribute("message","Delete successfully!");
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView showDetails(@PathVariable int id) {
        Optional<Staff> staff = staffService.findById(id);
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("staff", staff);
        return modelAndView;
    }

}
