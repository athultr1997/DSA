package problems._048_check_string_rotation;

public class Solution1 {

  public boolean checkRotation(String str1, String str2) {
    String concatenatedString = str2 + str2;
    return concatenatedString.indexOf(str1) != -1;
  }

}
