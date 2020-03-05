
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huy on 2017/8/21.
 */
public class SimpleTest {

    public static void main(String[] args) throws Exception {
        InputStream configFile = SimpleTest.class.getResourceAsStream("/mybatis-generatorConfig.xml");
        List<String> warnings = new ArrayList<String>();
//        boolean overwrite = true;
//        ConfigurationParser cp = new ConfigurationParser(warnings);
//        Configuration config = cp.parseConfiguration(configFile);
//        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
//        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
//        myBatisGenerator.generate(null);
    }
}
