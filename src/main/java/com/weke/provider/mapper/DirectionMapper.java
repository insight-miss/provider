package com.weke.provider.mapper;

import com.weke.provider.domain.Direction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface DirectionMapper {

    /**
     * 得到整个表的信息
     * @return
     */
    @Select("select * from direction")
    public List<Direction> getAll();

    /**
     * 获取所有方向名称
     * @return
     */
    @Select("select distinct(direction_name) from direction")
    public List<String> getDirectionName();

    @Select("select * from direction where direction_name = #{directionName}")
    public List<Direction> getDirectionByDirection(String directionName);

    /**
     * 方向详情页面查询
     * @param directionName
     * @param catalogName
     * @return
     */
    @SelectProvider(type = DirectionBuilder.class , method = "getDirections")
    public List<Direction> getDetailsDirection(@Param("directionName") String directionName,
                                               @Param("catalogName") String catalogName);

    class DirectionBuilder{
        public String getDirections(@Param("directionName") final String directionName,
                                    @Param("catalogName") final String catalogName) {
            String sql = new SQL() {{
                SELECT("D.direction_id, D.direction_name, D.catalog_name");
                FROM("direction D");
                if (!directionName.equals("all")) {
                    WHERE("D.direction_name = #{directionName}");
                }
                if (!catalogName.equals("all")) {
                    WHERE("D.catalog_name = #{catalogName}");
                }
            }}.toString();
            return sql;
        }
    }

}
