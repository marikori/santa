package com.secret.santa.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.secret.santa.model.SantaMappingObject;
import com.secret.santa.model.TeammateObjectAllOfResponse;

@Mapper
public interface TeammateMapper {
    @Insert("INSERT INTO team_mate (name) VALUES (#{name})")
    int createTeammate(@Param("name") String name);
    
    @Select("SELECT name FROM team_mate")
    List<TeammateObjectAllOfResponse> getTeammates();
    
    @Select("SELECT\n"
            + "    receiner_table.name AS receiver,\n"
            + "    santa_table.name AS santa\n"
            + "FROM\n"
            + "    team_mate AS receiner_table\n"
            + "INNER JOIN team_mate AS santa_table\n"
            + "WHERE\n"
            + "    receiner_table.current_santa = santa_table.name;")
    List<SantaMappingObject> getSantasCurrentYear();
    
    @Select("SELECT\n"
            + "    receiner_table.name AS receiver,\n"
            + "    santa_table.name AS santa\n"
            + "FROM\n"
            + "    team_mate AS receiner_table\n"
            + "INNER JOIN team_mate AS santa_table\n"
            + "WHERE\n"
            + "    receiner_table.one_year_back_santa = santa_table.name;")
    List<SantaMappingObject> getSantasOneYearBack();
    
    @Select("SELECT\n"
            + "    receiner_table.name AS receiver,\n"
            + "    santa_table.name AS santa\n"
            + "FROM\n"
            + "    team_mate AS receiner_table\n"
            + "INNER JOIN team_mate AS santa_table\n"
            + "WHERE\n"
            + "    receiner_table.two_years_back_santa = santa_table.name;")
    List<SantaMappingObject> getSantasTwoYearBack();
    
    @Select("SELECT\n"
            + "    receiner_table.name AS receiver,\n"
            + "    santa_table.name AS santa\n"
            + "FROM\n"
            + "    team_mate AS receiner_table\n"
            + "INNER JOIN team_mate AS santa_table\n"
            + "WHERE\n"
            + "    receiner_table.three_years_back_santa = santa_table.name;")
    List<SantaMappingObject> getSantasThreeYearBack();
}
