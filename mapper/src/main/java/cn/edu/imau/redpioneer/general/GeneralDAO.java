package cn.edu.imau.redpioneer.general;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface GeneralDAO<T> extends Mapper<T>, MySqlMapper<T> {
}
