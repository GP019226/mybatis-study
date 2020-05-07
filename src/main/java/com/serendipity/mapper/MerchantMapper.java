package com.serendipity.mapper;

import com.serendipity.entity.Merchant;

public interface MerchantMapper {
    int deleteByPrimaryKey(Integer mid);

    int insert(Merchant record);

    int insertSelective(Merchant record);

    Merchant selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Merchant record);

    int updateByPrimaryKey(Merchant record);
}