import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Exercises {

  public int findMe(int[] list, int target) {
    if (list == null || list.length == 0) {
          return -1;
      }
      for (int i = 0; i < list.length; i++) {
          if (list[i] == target) {
              return i;
          }
      }
      return -1;
  }

  public int findMe(ArrayList<String> list, String target) {
    if (list == null || list.size() == 0 || target == null) {
          return -1;
      }

      for (int i = 0; i < list.size(); i++) {
          if (list.get(i) == target) {
              return i;
          }
      }
      return -1;
  }

  public int findMeFaster(ArrayList<Integer> list, int target) {
      int start = 0;
      int middle = 0;
      int end = list.size() - 1;

      if (list == null || list.size() == 0) {
            return -1;
      }

      while (start <= end) {
          middle = (start + end) / 2;
          if (list.get(middle) < target) {
              start = middle + 1;
          } else if (list.get(middle) > target) {
              end = middle - 1;
          } else if (list.get(middle) == target) {
              return middle;
          }
      }
      return -1;
  }

  public int findMeFaster(String[] list, String target) {
    int start = 0;
    int middle = 0;
    int end = list.length - 1;

    if (list == null || list.length == 0 || target.equals(null)) {
          return -1;
    }

    while (start <= end) {
      middle = (start + end) / 2;
      if (list[middle].compareTo(target) < 0) {
        start = middle + 1;
      } else if (list[middle].compareTo(target) > 0) {
        end = middle - 1;
      } else if (list[middle].compareTo(target) == 0) {
        return middle;
      }
    }
    return -1;
  }

  public int[] bubble(int[] list, boolean ascending) {
    if (list == null || list.length == 0) {
      return null;
    }

    if (ascending) {
      for (int i = 0; i < list.length - 1; i++) {
        for (int j = 0; j < list.length - 1 - i; j++) {
          if (list[j] > list[j + 1]) {
            int temp = list[j];
            list[j] = list[j + 1];
            list[j+1] = temp;
          }
        }
      }
    } else if (!ascending) {
        for (int i = list.length; i > 1; i--) {
          for (int j = list.length-1; j > 0; j--) {
            if (list[j] > list[j - 1]) {
              int temp = list[j];
              list[j] = list[j - 1];
              list[j - 1] = temp;
            }
          }
        }
      }
    return list;
  }

  public ArrayList<String> bubble(ArrayList<String> list, boolean ascending) {
    if (list == null || list.size() == 0) {
      return null;
    }

    if (ascending) {
      for (int i = 0; i < list.size() - 1; i++) {
        for (int j = 0; j < list.size() - 1 - i; j++) {
          if (list.get(j).compareTo(list.get(j + 1)) > 0) {
            String temp = list.get(j);
            list.set(j, list.get(j + 1));
            list.set(j + 1, temp);
          }
        }
      }
    } else if (!ascending) {
      for (int i = list.size(); i > 1; i--) {
        for (int j = list.size() - 1; j > 0; j--) {
          if (list.get(j).compareTo(list.get(j - 1)) > 0) {
            String temp = list.get(j);
            list.set(j, list.get(j - 1));
            list.set(j - 1, temp);
          }
        }
      }
    }
    return list;
  }

  public ArrayList<Integer> insertion(ArrayList<Integer> list, boolean ascending) {
    if (list == null || list.size() == 0) {
      return null;
    }

    if (ascending) {
      for (int i = 1; i < list.size(); i++) {
        int key = list.get(i);
        for (int j = i - 1; j >= 0; j--) {
          if (key < list.get(j)) {
            list.set(j + 1,list.get(j));
            if (j == 0) {
              list.set(0, key);
            }
          } else {
            list.set(j + 1, key);
            break;
          }
        }
      }
    } else if (!ascending) {
      for (int i = 1; i < list.size(); i++) {
        int key = list.get(i);
        for (int j = i - 1; j >= 0; j--) {
          if (key > list.get(j)) {
            list.set(j + 1,list.get(j));
            if (j == 0) {
              list.set(0, key);
            }
          } else {
            list.set(j + 1, key);
            break;
          }
        }
      }
    }
    return list;
  }

  public String[] insertion(String[] list, boolean ascending) {
    if (list == null || list.length == 0) {
      return null;
    }

    String temp;

    if (ascending) {
      for (int i = 1; i < list.length; i++) {
        temp = list[i];
        int j = 0;
        for (j = i; j > 0; j--)
          if (temp.compareTo(list[j - 1]) < 0) {
            list[j] = list[j - 1];
          } else {
            break;
          }
        list[j] = temp;
      }
    } else if (!ascending) {
      for (int i = 1; i < list.length; i++) {
        temp = list[i];
        int j = 0;
        for (j = i; j > 0; j--)
          if (temp.compareTo(list[j - 1]) > 0) {
            list[j] = list[j - 1];
          } else {
            break;
          }
        list[j] = temp;
      }
    }
    return list;
  }

  public int[] selection(int[] list, boolean ascending) {
    if (list.contains(null) || list == null) {
          return null;
      }

      ArrayList <Integer> left = new ArrayList < Integer > ();
      ArrayList <Integer> right = new ArrayList < Integer > ();
      int center;

      if (list.size() == 1) {
          return list;
      } else {
          center = list.size() / 2;
          for (int i = 0; i < center; i++) {
              left.add(list.get(i));
          }

          for (int i = center; i < list.size(); i++) {
              right.add(list.get(i));
          }

          left = merge(left, true);
          right = merge(right, true);
          combineHalves(left, right, list);
      }
      if (!ascending) {
          Collections.reverse(list);
      }
      return list;
  }

  public ArrayList<String> selection(ArrayList<String> list, boolean ascending) {
    return null;
  }

  public ArrayList<Integer> merge(ArrayList<Integer> list, boolean ascending) {
    return null;
  }

  public String[] merge(String[] list, boolean ascending) {
    return null;
  }
}
