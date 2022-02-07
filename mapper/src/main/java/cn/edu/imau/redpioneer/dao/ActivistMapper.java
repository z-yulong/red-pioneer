package cn.edu.imau.redpioneer.dao;

import cn.edu.imau.redpioneer.entity.Activist;
import cn.edu.imau.redpioneer.general.GeneralDAO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ActivistMapper extends GeneralDAO<Activist> {

    int updateInfoByPrimaryKey(Activist activist);

    void batchInsert(List<Activist> activists);

    void updateAvatarByPrimaryKey(@Param(value = "id") Integer id, @Param(value ="path")String path);

    void updateStateCode(Integer stateCode,String name);

    String selectEmailByName(String name);
}