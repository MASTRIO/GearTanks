package me.mastrio.geartanks;

import me.mastrio.geartanks.commands.GiveGearTankCommand;
import me.mastrio.geartanks.eventHandlers.BookEvents;
import me.mastrio.geartanks.eventHandlers.OnPlayerJoinEvent;
import me.mastrio.geartanks.eventHandlers.OnToggleShiftEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class GearTanks extends JavaPlugin {

  // Runs on server start
  @Override
  public void onEnable() {
    // Initialize commands
    this.getCommand("gearTank").setExecutor(new GiveGearTankCommand());

    // Register events
    this.getServer().getPluginManager().registerEvents(new OnToggleShiftEvent(), this);
    this.getServer().getPluginManager().registerEvents(new BookEvents(), this);
    this.getServer().getPluginManager().registerEvents(new OnPlayerJoinEvent(), this);
  }

  // Runs on server close
  @Override
  public void onDisable() {

  }

}
