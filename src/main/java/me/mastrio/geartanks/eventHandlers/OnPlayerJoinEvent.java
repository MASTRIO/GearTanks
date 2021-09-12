package me.mastrio.geartanks.eventHandlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoinEvent implements Listener {

  // Variables
  String packUrl = "https://download.mc-packs.net/pack/4702390493287181a36b80ddb5fc5555c2c6e6b0.zip";
  String packHash = "4702390493287181a36b80ddb5fc5555c2c6e6b0";

  // Join event
  @EventHandler
  public void onPlayerJoinEvent(PlayerJoinEvent event) {
    //event.getPlayer().setResourcePack(packUrl, packHash);
  }

}
