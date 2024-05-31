package test;


import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;
import java.util.Collections;
import java.util.Scanner;




public class CodeGenerator {
    public static void main(String[] args) {
        //
        final String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        final String moduleName = scanner("payment2");
        final String tableName = scanner("payment");
        AutoGenerator mpg = new AutoGenerator()
                .setGlobalConfig(
                        // 全局配置
                        new GlobalConfig()
                                .setOutputDir(projectPath + "/cloud-provider-payment8001/src/main/java") //项目路径
                                .setFileOverride(true)
                                .setAuthor("bxl")
                                .setOpen(false)
                                .setBaseResultMap(true)
                                .setBaseColumnList(true)
                ).setDataSource(
                        // 数据源配置
                        new DataSourceConfig()
                                .setUrl("jdbc:mysql://localhost:3306/db2019?useUnicode=true&" +
                                        "characterEncoding=utf8&" +
                                        "zeroDateTimeBehavior=convertToNull&" +
                                        "useSSL=true&" +
                                        "serverTimezone=GMT%2B8&" +
                                        "allowMultiQueries=true")
                                .setDriverName("com.mysql.cj.jdbc.Driver")
                                .setUsername("root")
                                .setPassword("123456"))
                .setPackageInfo(
                        // 包配置
                        new PackageConfig()
                                .setParent("com.atguigu.cloud")
                                .setEntity("domain." + moduleName)
                                .setMapper("mapper." + moduleName)
                                .setService("service." + moduleName)
                                .setServiceImpl("service." + moduleName + ".impl")
                                .setController("controller." + moduleName)
                ).setStrategy(
                        // 策略配置
                        new StrategyConfig()
                                .setNaming(NamingStrategy.underline_to_camel)
                                .setColumnNaming(NamingStrategy.underline_to_camel)
                                .setSuperEntityColumns(new String[]{"create_at", "update_at"})
                                .setEntityLombokModel(true)
                                .setEntityBooleanColumnRemoveIsPrefix(true)
                                .setEntityTableFieldAnnotationEnable(true)
                                .setInclude(StringUtils.split(tableName, ","))
                                .setRestControllerStyle(true)
                                .setControllerMappingHyphenStyle(true)
                                .setTablePrefix("t")
                ).setCfg(
                        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
                        new InjectionConfig() {
                            @Override
                            public void initMap() {
                            }
                        }.setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig("/templates/mapper.xml.vm") {
                            // 自定义输出文件目录
                            @Override
                            public String outputFile(TableInfo tableInfo) {
                                return projectPath + "/cloud-provider-payment8001/src/main/resources/mappers/" + moduleName + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                            }
                        }))
                ).setTemplate(new TemplateConfig()
                        .setXml(null));

        mpg.execute();
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(final String tip) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                if (StringUtils.equals(ipt, "?")) {
                    return "";
                }
                return ipt;
            }
        }
        return "";
    }


}


