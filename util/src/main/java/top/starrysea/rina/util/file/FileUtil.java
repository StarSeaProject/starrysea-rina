package top.starrysea.rina.util.file;

import org.yaml.snakeyaml.Yaml;
import top.starrysea.rina.util.exception.RinaFileException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtil {

    public static <T> T readYamlFile(String path, Class<T> clazz) {
        Yaml yaml = new Yaml();
        return yaml.loadAs(FileUtil.class.getClassLoader().getResourceAsStream(path), clazz);
    }

    public static List<String> readFileAllLines(String path) {
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            throw new RinaFileException(e.getMessage(), e);
        }
    }
}
