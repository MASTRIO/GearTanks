package me.mastrio.geartanks;

import org.bukkit.ChatColor;

public class ChatLog {

  // Variables
  private static final String messageIdentifier = "GearTanks >>> ";
  private static final String consoleMessageIdentifier = "GearTanks::Console >>> ";

  // Message
  public static String message(String message) {
    return ChatColor.DARK_BLUE + messageIdentifier + ChatColor.WHITE + message;
  }

  // Console
  public static String console(String message) {
    return ChatColor.DARK_BLUE + consoleMessageIdentifier + ChatColor.WHITE + message;
  }

  // Error
  public static String error(String message) {
    return ChatColor.RED + messageIdentifier + ChatColor.WHITE + message;
  }

}
