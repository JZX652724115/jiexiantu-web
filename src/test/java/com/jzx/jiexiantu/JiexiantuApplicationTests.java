package com.jzx.jiexiantu;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.jzx.jiexiantu.controller.CoordLinesController;
import com.jzx.jiexiantu.dto.CoordLinesDto;
import com.jzx.jiexiantu.mapper.CoordLinesMapper;
import com.jzx.jiexiantu.mapper.CoordsMapper;
import com.jzx.jiexiantu.mapper.PlantsMapper;
import com.jzx.jiexiantu.pojo.CoordLines;
import com.jzx.jiexiantu.pojo.Coords;
import com.jzx.jiexiantu.pojo.Plants;
import com.jzx.jiexiantu.service.PlantsService;
import com.jzx.jiexiantu.service.impl.PlantsServiceImpl;
import com.jzx.jiexiantu.utils.Snowflake;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class JiexiantuApplicationTests {

    @Autowired
    private PlantsMapper plantsMapper;
    @Autowired
    private CoordLinesMapper linesMapper;
    @Autowired
    private CoordsMapper coordsMapper;
    @Autowired
    private PlantsService plantsService;

    @Autowired
    private CoordLinesController controller;

    private static final long workerId = 5L;
    private static final long datacenterId = 5L;
    String filePath = "C:\\Users\\hemia\\Desktop\\baseData.json";
    /**
     * 数据源配置
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://localhost:3306/pld", "root", "123456");
    @Test
    void contextLoads() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder jsonString = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null){
                jsonString.append(line);
            }
            JSONObject jsonObject = new JSONObject(jsonString.toString());
            JSONArray plants = jsonObject.getJSONArray("plants");
            //System.out.println(plants);
            for (int i = 0; i < plants.length(); i++) {
                String value = String.valueOf(plants.getJSONObject(i).get("value"));
                value = value.replaceAll("[\\[\\]]","");
                String[] split = value.split(",");
                Plants plants1 = new Plants();
                plants1.setId(String.valueOf(plants.getJSONObject(i).get("id")));
                plants1.setLabel(String.valueOf(plants.getJSONObject(i).get("label")));
                plants1.setRegion(String.valueOf(plants.getJSONObject(i).get("region")));
                plants1.setLevel(Integer.parseInt(plants.getJSONObject(i).get("level").toString()));
                plants1.setName(String.valueOf(plants.getJSONObject(i).get("name")));
                plants1.setValue1(split[0]);
                plants1.setValue2(split[1]);
                plants1.setValue3(split[2]);
                plantsMapper.insert(plants1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void linesSetData(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder jsonString = new StringBuilder();
            String lines;
            while((lines = reader.readLine()) != null){
                jsonString.append(lines);
            }
            JSONObject jsonObject = new JSONObject(jsonString.toString());
            JSONArray line = jsonObject.getJSONArray("lines");
            for (int i = 0; i < line.length(); i++) {
                CoordLines lines1 = new CoordLines();
                lines1.setLineId(String.valueOf(line.getJSONObject(i).get("id")));
                lines1.setSLabel(String.valueOf(line.getJSONObject(i).get("sLabel")));
                lines1.setELabel(String.valueOf(line.getJSONObject(i).get("eLabel")));
                Snowflake snowflake = new Snowflake(workerId, datacenterId);
                long id = snowflake.nextId();
                lines1.setCoordId(id);
                linesMapper.insert(lines1);
                String value = String.valueOf(line.getJSONObject(i).get("coords"));
                value = value.replaceAll("[\\[\\]]","");
                String[] split = value.split(",");
                for (int j = 0; j < split.length; j += 2) {
                    Coords coords = new Coords();
                    coords.setCoordId(id);
                    coords.setValue1(Double.parseDouble(split[j]));
                    coords.setValue2(Double.parseDouble(split[j + 1]));
                    coordsMapper.insert(coords);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public static void main(String[] args) {
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                // 全局配置
                .globalConfig(builder -> {
                    builder.author("jzx") // 设置作者
                            .enableSwagger() // 开启swagger模式
                            .outputDir(System.getProperty("user.dir") + "/src/main/java") // 指定输出目录
                            .disableOpenDir(); // 禁止打开输出目录
                })
                // 包配置
                .packageConfig(builder -> {
                    builder.parent("com.jzx") // 设置父包名
                            .moduleName("jiexiantu") // 设置父包模块名
                            .entity("pojo") // 设置实体类包名
                            .serviceImpl("service.impl") // 自定义包名impl
                            .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                // 策略配置
                .strategyConfig(builder -> {
                    builder
                            .addInclude("coord_lines") // 设置需要生成的表名
                            .serviceBuilder() // service策略配置
                            .formatServiceFileName("%sService") // service类名，%s适配，根据表名替换
                            .formatServiceImplFileName("%sServiceImpl") // serviceImpl类名
                            .entityBuilder() // 实体类策略配置
                            .enableLombok() //使用lombok
                            .addTableFills(
                                    new Column("create_time", FieldFill.INSERT),
                                    new Column("update_time", FieldFill.INSERT_UPDATE)
                            ) // 添加表字段填充，"create_time"字段自动填充为插入时间，"update_time"字段自动填充为插入修改时间
                            .logicDeleteColumnName("deleted") // 逻辑删除字段名(数据库)
                            .logicDeletePropertyName("deleted") // 逻辑删除属性名(实体)
                            .versionColumnName("version") // 乐观锁数据库名
                            .versionPropertyName("version") // 乐观锁实体名
                            .enableTableFieldAnnotation() // 属性加上注解
                            .controllerBuilder() // controller策略配置
                            .formatFileName("%sController") // controller类名
                            .enableRestStyle() // 开启RestController
                            .mapperBuilder() // mapper策略配置
                            .formatMapperFileName("%sMapper") // mapper类名
                            .formatXmlFileName("%sMapper"); // mapper.xml类名


                }).templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

    @Test
    public void test1(){
        List<Plants> all = plantsService.getAll();
        for (int i = 0; i < all.size(); i++) {
            System.out.println(all.get(i));
        }
    }
}
