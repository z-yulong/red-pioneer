package cn.edu.imau.redpioneer.dao;

import cn.edu.imau.redpioneer.dto.ActivistInfoDto;
import cn.edu.imau.redpioneer.dto.GradeNumDto;
import cn.edu.imau.redpioneer.dto.NationNumDto;
import cn.edu.imau.redpioneer.dto.SexNumDto;
import cn.edu.imau.redpioneer.entity.Activist;
import cn.edu.imau.redpioneer.general.GeneralDAO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

public interface ActivistMapper extends GeneralDAO<Activist> {

    //通过id获取用户角色
    String selectRoleById(Integer id);

    //批量插入用户
    void batchInsert(List<Activist> activists);

    //通过姓名更新用户状态
    void updateStateCode(Integer stateCode,Integer id);

    //通过姓名查询邮箱
    String selectEmailByName(Integer id);

    ActivistInfoDto selectActivistInfo(Integer id);

    Activist selectActivistByText(String text);

    List<NationNumDto> selectBranchNationNum(Integer id);

    List<SexNumDto> selectBranchSexNum(Integer id);

    List<GradeNumDto> selectBranchGradeNum(Integer id);

    List<NationNumDto> selectGroupNationNum(Integer id);

    List<SexNumDto> selectGroupSexNum(Integer id);

    List<GradeNumDto> selectGroupGradeNum(Integer id);
}