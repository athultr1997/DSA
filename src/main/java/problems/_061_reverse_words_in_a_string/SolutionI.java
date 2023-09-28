package problems._061_reverse_words_in_a_string;

public class SolutionI {

  public String reverseWords(String s) {
    char[] wordChars = s.toCharArray();
    int n = wordChars.length;

    reverseString(wordChars, 0, n - 1);
    reverseWords(wordChars);
    return clearSpaces(wordChars);
  }

  private void reverseString(char[] string, int start, int end) {
    char tmp;
    for (int i = 0; i < (end - start + 1) / 2; ++i) {
      tmp = string[start + i];
      string[start + i] = string[end - i];
      string[end - i] = tmp;
    }
  }

  private void reverseWords(char[] string) {
    int n = string.length;
    int i = 0;
    int j = 0;
    while (i < n) {
      while (i < n && string[i] == ' ') {
        i++;
      }
      j = i;
      while (j < n && string[j] != ' ') {
        j++;
      }
      reverseString(string, i, j - 1);
      i = j;
    }
  }

  private String clearSpaces(char[] string) {
    int i = 0;
    int j = 0;
    int n = string.length;
    while (j < n) {
      while (j < n && string[j] == ' ') {
        ++j;
      }
      while (j < n && string[j] != ' ') {
        string[i] = string[j];
        ++j;
        ++i;
      }
      while (j < n && string[j] == ' ') {
        ++j;
      }
      if (j < n) {
        string[i] = ' ';
        ++i;
      }
    }
    return new String(string).substring(0, i);
  }

}
