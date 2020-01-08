package com.fh.mall.tiny.mbg;


import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.config.xml.MyBatisGeneratorConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于生产MBG的代码
 */
public class Generator {
    public static void main(String[] args) throws Exception{
        //MBG执行中的警告信息
        List<String> warnings = new ArrayList<String>();
        //当生成的代码重复时，覆盖源代码
        boolean overwrite = true;
        //读取我们的MBG配置文件
        InputStream inputStream = Generator.class.getResourceAsStream("generatorConfig.xml");
        ConfigurationParser configurationParser = new ConfigurationParser(warnings);
        Configuration configuration = configurationParser.parseConfiguration(inputStream);
        inputStream.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        //创建MBG
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration,callback,warnings);
        //执行生成代码
        myBatisGenerator.generate(null);
        //输出警告信息
        for (String warning : warnings){

            System.out.println(warning);
        }
    }
}
