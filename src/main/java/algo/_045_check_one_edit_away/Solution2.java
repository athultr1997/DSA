package algo._045_check_one_edit_away;

public class Solution2 {

  public boolean checkIfOneEditAway(String str1, String str2) {
    int n1 = str1.length();
    int n2 = str2.length();

    int i = 0, j = 0;
    boolean editPerformed = false;

    while (i < n1 && j < n2) {
      if (str1.charAt(i) == str2.charAt(j)) {
        ++i;
        ++j;
      } else {
        if (editPerformed == true) {
          return false;
        }
        editPerformed = true;
        // replace
        if (n1 == n2) {
          ++i;
          ++j;
        }
        // delete
        else if (n1 > n2) {
          ++i;
        }
        // insert
        else if (n1 < n2) {
          ++j;
        }
      }
    }

    if (editPerformed == true && (i < n1 || j < n2)) {
      return false;
    }
    return true;
  }
}
