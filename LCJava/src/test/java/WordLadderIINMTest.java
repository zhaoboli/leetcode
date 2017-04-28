import org.junit.Test;
import sun.reflect.annotation.ExceptionProxy;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by zhaobo on 4/22/17.
 */
public class WordLadderIINMTest {
    WordLadderIINM wlNMObj = new WordLadderIINM();

    public WordLadderIINMTest() {

        this.wlNMObj = new WordLadderIINM();
    }
    @Test
    public void findLadders() throws Exception {
        String start = "hot";
        String end = "dog";

        Set<String> input = new LinkedHashSet<String>(Arrays.asList("hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot"));
        /*input.add("hot");
        input.add("cog");
        input.add("dog");
        input.add("tot");
        input.add("hog");
        input.add("hop");
        input.add("pot");
        input.add("dot"); */
        this.wlNMObj.findLadders(start, end, input) ;
    }

    @Test
    public void findLaddersSimple() throws Exception {
        String start = "hit";
        String end = "cog";
        Set<String> input = new LinkedHashSet<String>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        this.wlNMObj.findLadders(start, end, input);
    }

    @Test
    public void findLaddersOverTime() throws Exception {
        Set<String> input = new LinkedHashSet<>(Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm",
                "le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or",
                "rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no",
                "bi","di","hi","qa","pi","os","uh","wm","an",
                "me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"));
        String start = "qa";
        String end = "sq";
        wlNMObj.findLadders(start, end, input);
        System.out.printf("end");
    }
}