package chapter5.controller;

import chapter5.bean.City;
import chapter5.service.ICityService;
import chapter5.util.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by daoya <daoya@2dfire.com> on 2016/12/12.
 */
@Controller
@RequestMapping("/city")
public class CityController {

    @Resource
    private ICityService cityService;


    @RequestMapping(value = "/list_city_info", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView listCityInfo(){
        City city = cityService.queryByID(1);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cities", city);
        modelAndView.setViewName("city/cities");
        return modelAndView;
    }

    @RequestMapping(value = "/get_city_by_id", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultMap getCityByID(Model model, @RequestParam Integer id){
        City city = cityService.queryByID(id);
        model.addAttribute("city", city);
        return new ResultMap(city);
    }
}