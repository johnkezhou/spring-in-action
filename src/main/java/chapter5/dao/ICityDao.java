package chapter5.dao;

import chapter5.bean.City;

import java.util.List;

/**
 * Created by daoya <daoya@2dfire.com> on 2017/1/18.
 */
public interface ICityDao {

    City queryByID(int id);

    List<City> listCity();
}
