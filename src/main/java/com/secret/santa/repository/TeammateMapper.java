package com.secret.santa.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.secret.santa.model.SantaMappingObject;

@Mapper
public interface TeammateMapper {
    @Insert("INSERT INTO team_mate (name) VALUES (#{name})")
    int createTeammate(@Param("name") String name);
    
    @Select("SELECT\n"
            + "    receiner_table.name AS receiver,\n"
            + "    santa_table.name AS santa\n"
            + "FROM\n"
            + "    team_mate AS receiner_table\n"
            + "INNER JOIN team_mate AS santa_table\n"
            + "WHERE\n"
            + "    receiner_table.current_santa = santa_table.name;")
    List<SantaMappingObject> getSantasCurrentYear();
}
