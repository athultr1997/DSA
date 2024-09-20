package problems._045_check_one_edit_away;

public class Solution1 {
  public boolean checkIfOneEditAway(String str1, String str2) {
    int n1 = str1.length();
    int n2 = str2.length();

    int i = 0, j = 0;
    boolean editPerformed = false;
    while (i < n1 && j < n2) {
      if (str1.charAt(i) == str2.charAt(j)) {
        i++;
        j++;
      } else {
        if (editPerformed == true) {
          return false;
        }
        editPerformed = true;
        if (i + 1 < n1 && (str1.charAt(i + 1) == str2.charAt(j))) {
          i++;
        } else if ((i + 1 < n1) && (j + 1 < n2) && (str1.charAt(i + 1) == str2.charAt(j + 1))) {
          ++i;
          ++j;
        } else if ((j + 1 < n2) && (str1.charAt(i) == str2.charAt(j + 1))) {
          ++j;
        }
        else if (i == n1 -1 && j == n2 - 1) {
          ++i;
          ++j;
        }
      }
    }
    if (editPerformed == true && ((n2 - j > 0) || (n1 - i > 0))) {
      return false;
    }
    return true;
  }
}
