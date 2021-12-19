package com.secret.santa.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.secret.santa.model.SantaMappingObject;

@Mapper
public interface TeammateMapper {
    @Insert("INSERT INTO team_mate (name) VALUES (#{name})")
    public int createTeammate(@Param("name") String name);
    
    @Update("UPDATE team_mate SET current_santa = #{santaName} WHERE name = #{receiverName}")
    public int updateCurrentSantaName(@Param("receiverName") String receiverName, @Param("santaName") String santaName);
    
    @Select("SELECT name FROM team_mate")
    public List<String> getTeammates();
    
    @Select("SELECT\n"
            + "    receiner_table.name AS receiver,\n"
            + "    santa_table.name AS santa\n"
            + "FROM\n"
            + "    team_mate AS receiner_table\n"
            + "INNER JOIN team_mate AS santa_table\n"
            + "WHERE\n"
            + "    receiner_table.current_santa = santa_table.name")
    public List<SantaMappingObject> getSantasCurrentYear();
    
    @Select("SELECT\n"
            + "    receiner_table.name AS receiver,\n"
            + "    santa_table.name AS santa\n"
            + "FROM\n"
            + "    team_mate AS receiner_table\n"
            + "INNER JOIN team_mate AS santa_table\n"
            + "WHERE\n"
            + "    receiner_table.one_year_back_santa = santa_table.name")
    public List<SantaMappingObject> getSantasOneYearBack();
    
    @Select("SELECT\n"
            + "    receiner_table.name AS receiver,\n"
            + "    santa_table.name AS santa\n"
            + "FROM\n"
            + "    team_mate AS receiner_table\n"
            + "INNER JOIN team_mate AS santa_table\n"
            + "WHERE\n"
            + "    receiner_table.two_years_back_santa = santa_table.name")
    public List<SantaMappingObject> getSantasTwoYearBack();
    
    @Select("SELECT\n"
            + "    receiver_table.name,\n"
            + "    one_year_back_santa_table.name AS one_year_back_santa,\n"
            + "    two_years_back_santa_table.name AS two_years_back_santa\n"
            + "FROM\n"
            + "    team_mate AS receiver_table\n"
            + "INNER JOIN team_mate AS one_year_back_santa_table\n"
            + "INNER JOIN team_mate AS two_years_back_santa_table\n"
            + "WHERE\n"
            + "    receiver_table.one_year_back_santa = one_year_back_santa_table.name\n"
            + "    AND receiver_table.name = two_years_back_santa_table.name")
    public List<List<String>> getPastSantaMappings();
}
