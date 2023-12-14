package utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;


public interface ConfigProvider {
    Config config = readConf();

    static Config readConf() {
        return ConfigFactory.load("applicattion.conf");
    }

    String LOGIN = readConf().getString("login");
    String PASSWORD = readConf().getString("password");
}
