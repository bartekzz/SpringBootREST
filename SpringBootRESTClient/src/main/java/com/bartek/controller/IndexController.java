/**
 * Created by Bartek 2017-12-07
 */
package com.bartek.controller;

import com.bartek.model.User;
import com.bartek.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * This class is controller that interact with the gui
 */
@Controller
public class IndexController {

    @Autowired
    RestService restService;

    /**
     * This method display the view (index.html)
     */
    @RequestMapping("/")
    public String standard() {

        return "index";
    }

}
