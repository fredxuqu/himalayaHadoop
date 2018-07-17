package com.himalaya.repository;

import com.himalaya.entity.CheckTask;
import com.himalaya.entity.CheckTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckTaskDAO {
    long countByExample(CheckTaskExample example);

    int deleteByExample(CheckTaskExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CheckTask record);

    int insertSelective(CheckTask record);

    List<CheckTask> selectByExampleWithBLOBs(CheckTaskExample example);

    List<CheckTask> selectByExample(CheckTaskExample example);

    CheckTask selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CheckTask record, @Param("example") CheckTaskExample example);

    int updateByExampleWithBLOBs(@Param("record") CheckTask record, @Param("example") CheckTaskExample example);

    int updateByExample(@Param("record") CheckTask record, @Param("example") CheckTaskExample example);

    int updateByPrimaryKeySelective(CheckTask record);

    int updateByPrimaryKeyWithBLOBs(CheckTask record);

    int updateByPrimaryKey(CheckTask record);
}