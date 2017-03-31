package org.abc.star.dubbo.service;

import org.abc.star.dubbo.domain.City;

/**
 * Created by whs on 2017/3/28.
 */
public interface CityService {
    City findCityByName(String cityName);
}
