package com.himalaya.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.himalaya.domain.TaskDO;
import com.himalaya.domain.TaskDOExample;

public interface TaskMapper {
    int countByExample(TaskDOExample example);

    int deleteByExample(TaskDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TaskDO record);

    int insertSelective(TaskDO record);

    List<TaskDO> selectByExampleWithBLOBs(TaskDOExample example);

    List<TaskDO> selectByExample(TaskDOExample example);

    TaskDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TaskDO record, @Param("example") TaskDOExample example);

    int updateByExampleWithBLOBs(@Param("record") TaskDO record, @Param("example") TaskDOExample example);

    int updateByExample(@Param("record") TaskDO record, @Param("example") TaskDOExample example);

    int updateByPrimaryKeySelective(TaskDO record);

    int updateByPrimaryKeyWithBLOBs(TaskDO record);

    int updateByPrimaryKey(TaskDO record);
}