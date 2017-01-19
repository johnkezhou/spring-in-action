package chapter5.dao.impl;

import chapter5.bean.City;
import chapter5.dao.ICityDao;
import chapter5.mapper.CityMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by daoya <daoya@2dfire.com> on 2017/1/18.
 */
@Service
public class CityDao implements ICityDao {

    @Resource
    private CityMapper cityMapper;

    public List<City> listCity() {
        List<City> cities = cityMapper.selectCityList();
        return cities;
    }

    public City queryByID(int id) {
        City city = cityMapper.selectByID(id);
        return city;
    }

}
