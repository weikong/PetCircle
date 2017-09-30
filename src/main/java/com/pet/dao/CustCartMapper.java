package com.pet.dao;

import java.util.List;
import java.util.Map;

/**
 * 购物车接口
 */
public interface CustCartMapper {

    List<Map> selectCartItems(int accountId);

    void deleteCartItem(Map map);
}
