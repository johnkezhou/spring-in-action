package chapter5.service.impl;

import chapter5.bean.City;
import chapter5.mapper.CityMapper;
import chapter5.service.ICityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by daoya <daoya@2dfire.com> on 2016/12/12.
 */
@Service
public class CityServiceImpl implements ICityService {

    @Resource
    private CityMapper cityMapper;

    public City queryByID(int id) {
        City city = cityMapper.selectByID(id);
        return city;
    }

    public List<City> listCity(){
        List<City> cities = null;
        return cities;
    }
}
