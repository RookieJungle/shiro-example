package com.rookie.mapper;

import com.rookie.pojo.SysRoleAcl;
import com.rookie.pojo.SysRoleAclExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleAclMapper {
    long countByExample(SysRoleAclExample example);

    int deleteByExample(SysRoleAclExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleAcl record);

    int insertSelective(SysRoleAcl record);

    List<SysRoleAcl> selectByExample(SysRoleAclExample example);

    SysRoleAcl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysRoleAcl record, @Param("example") SysRoleAclExample example);

    int updateByExample(@Param("record") SysRoleAcl record, @Param("example") SysRoleAclExample example);

    int updateByPrimaryKeySelective(SysRoleAcl record);

    int updateByPrimaryKey(SysRoleAcl record);
}