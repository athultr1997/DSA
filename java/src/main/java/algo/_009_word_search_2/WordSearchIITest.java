package algo._009_word_search_2;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordSearchIITest {

  @Test
  public void test() {
    WordSearchII wordSearchII = new WordSearchII();
    char[][] board = {{'a', 's', 'd'}, {'a', 's', 'd'}, {'a', 's', 'd'}};
    String[] words = {"asd"};
    List<String> result = wordSearchII.search(board, words);
    Assertions.assertEquals(3, result.size());
    Assertions.assertEquals(result.get(0), "asd");
    Assertions.assertEquals(result.get(1), "asd");
    Assertions.assertEquals(result.get(2), "asd");
  }


}