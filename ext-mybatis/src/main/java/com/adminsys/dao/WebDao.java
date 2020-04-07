package com.adminsys.dao;

import com.adminsys.entity.WebEntity;
import org.apache.ibatis.annotations.Param;

public interface WebDao {

    WebEntity selectAll(@Param("id") String id);
}
