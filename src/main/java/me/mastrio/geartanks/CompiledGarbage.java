package me.mastrio.geartanks;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

public class CompiledGarbage {

  // Generate compiled garbage
  public static Component generate(int amount) {
    StringBuilder returnValue = new StringBuilder("gear.");
    int timesToLoop = amount;
    while (timesToLoop >= 1) {
      int randomNumber = (int) ((Math.random() * ((3 - 1) + 1)) + 1);

      if (randomNumber == 1) {
        randomNumber = (int) ((Math.random() * ((5 - 1) + 1)) + 1);
        if (randomNumber == 1) {
          returnValue.append(pickCase("a", "A"));
        } else if (randomNumber == 2) {
          returnValue.append(pickCase("b", "B"));
        } else if (randomNumber == 3) {
          returnValue.append(pickCase("c", "C"));
        } else if (randomNumber == 4) {
          returnValue.append(pickCase("d", "D"));
        } else if (randomNumber == 5) {
          returnValue.append(pickCase("e", "E"));

        }
      } else if (randomNumber == 2 || randomNumber == 3) {
        randomNumber = (int) ((Math.random() * ((9 - 0) + 1)) + 0);
        returnValue.append(randomNumber);
      }

      timesToLoop--;
    }

    return Component.text(returnValue.toString());
  }

  // Generate either lower or upper case
  private static String pickCase(String lower, String upper) {
    int randomNumber = (int) ((Math.random() * ((2 - 1) + 1)) + 1);
    if (randomNumber == 1) {
      return lower;
    } else if (randomNumber == 2) {
      return upper;
    }

    return lower;
  }

}
