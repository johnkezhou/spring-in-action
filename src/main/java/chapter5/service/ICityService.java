package chapter5.service;

import chapter5.bean.City;

import java.util.List;

/**
 * Created by daoya <daoya@2dfire.com> on 2016/12/12.
 */
public interface ICityService {

    City queryByID(int id);

    List<City> listCity();
}
