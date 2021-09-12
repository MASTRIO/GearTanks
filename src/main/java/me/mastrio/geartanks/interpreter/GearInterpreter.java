package me.mastrio.geartanks.interpreter;

import me.mastrio.geartanks.ChatLog;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class GearInterpreter {

  // Data variables
  static String printQueue = "";
  HashMap<String, String> gearVariables = new HashMap<>();

  // Runs the interpreter
  public static void run(String instructions, Player daPlayer) {
    // Tell the console that a gear is being ran (for debugging purposes)
    System.out.println("A gear is being run by " + daPlayer.getName());
    // Run the gear
    String[] args = instructions.split("- ");
    for (int currentInstruction = 1; currentInstruction <= args.length; currentInstruction++) {
      executeInstruction(args[currentInstruction], daPlayer, currentInstruction);
    }
  }

  // Executes an instruction
  private static void executeInstruction(String instruction, Player thePlayerWhoRanTheGear, int instructionNum) {
    GearInterpreter gearInterpreter = new GearInterpreter();
    // Execute Gear code
    String[] args;
    instruction.replaceAll("\n", "");
    if (instruction.contains(", ")) {
      args = instruction.split(", ");
    } else {
      args = new String[] {
        instruction
      };
    }
    switch (args[0].toLowerCase()) {
      // Add data to print queue
      case ("print-add"):
        if (args[1].startsWith(":")) {
          args[1].replaceFirst(":", "");
          printQueue = printQueue + gearInterpreter.gearVariables.get(args[1]);
        } else {
          printQueue = printQueue + args[1];
        }
        break;
      // Print
      case ("print"):
        thePlayerWhoRanTheGear.sendMessage(ChatLog.console(printQueue));
        printQueue = "";
        break;
      // Variable
      case ("variable"):
        switch (args[1].toLowerCase()) {
          // Create Variable
          case ("create"):
            gearInterpreter.gearVariables.put(args[2], "null");
            break;
          // Set the variable
          case ("set"):
            gearInterpreter.gearVariables.put(args[2], args[3]);
          // Delete Variable
          case ("delete"):
            gearInterpreter.gearVariables.remove(args[2]);
            break;
          // Increase
          case ("add"):
            int addValue = Integer.parseInt(gearInterpreter.gearVariables.get(args[2]));
            addValue = addValue + Integer.parseInt(args[3]);
            gearInterpreter.gearVariables.put(args[2], String.valueOf(addValue));
            break;
          // Decrease
          case ("subtract"):
            int subtractValue = Integer.parseInt(gearInterpreter.gearVariables.get(args[2]));
            subtractValue = subtractValue - Integer.parseInt(args[3]);
            gearInterpreter.gearVariables.put(args[2], String.valueOf(subtractValue));
            break;
          default:
            badInstruction(thePlayerWhoRanTheGear, args[1], instructionNum);
            break;
        }
        break;
      default:
        badInstruction(thePlayerWhoRanTheGear, args[0], instructionNum);
        break;
    }
  }

  private static void badInstruction(Player player, String arg, int lineNumber) {
    player.sendMessage(ChatLog.error("Couldn't recognise instruction '" + arg + "' at line " + lineNumber));
  }

}
