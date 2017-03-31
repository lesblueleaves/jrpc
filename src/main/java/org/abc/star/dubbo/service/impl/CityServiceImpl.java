package org.abc.star.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.abc.star.dubbo.domain.City;
import org.abc.star.dubbo.service.CityService;
/**
 * Created by whs on 2017/3/28.
 */
@Service(version = "1.0.0")
public class CityServiceImpl implements CityService {
    @Override
    public City findCityByName(String cityName) {
        return new City(1L,2L,"温岭","是我的故乡");
    }
}
