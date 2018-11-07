package com.itzixi.mapper;

import com.itzixi.pojo.Spend;
import com.itzixi.pojo.SpendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpendMapper {
    int countByExample(SpendExample example);

    int deleteByExample(SpendExample example);

    int deleteByPrimaryKey(String id);

    int insert(Spend record);

    int insertSelective(Spend record);

    List<Spend> selectByExample(SpendExample example);

    Spend selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Spend record, @Param("example") SpendExample example);

    int updateByExample(@Param("record") Spend record, @Param("example") SpendExample example);

    int updateByPrimaryKeySelective(Spend record);

    int updateByPrimaryKey(Spend record);
}