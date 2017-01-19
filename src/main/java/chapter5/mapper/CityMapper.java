package chapter5.mapper;

import chapter5.bean.City;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by daoya <daoya@2dfire.com> on 2016/12/12.
 */
public interface CityMapper {

    City selectByID(int id);

    List<City> selectCityList();

}
