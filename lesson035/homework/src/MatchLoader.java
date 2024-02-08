import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface MatchLoader {
List<Match> load() throws IOException;
}
