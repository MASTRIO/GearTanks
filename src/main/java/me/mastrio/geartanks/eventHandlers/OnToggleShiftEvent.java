package me.mastrio.geartanks.eventHandlers;

import me.mastrio.geartanks.ChatLog;
import me.mastrio.geartanks.interpreter.GearInterpreter;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.persistence.PersistentDataType;

public class OnToggleShiftEvent implements Listener {

  @EventHandler
  public void onToggleShift(PlayerToggleSneakEvent event) {
    // If the player is sneaking
    if (event.getPlayer().isSneaking()) {
      // If the player has something in their hand
      if (event.getPlayer().getInventory().getItemInMainHand() != null || event.getPlayer().getInventory().getItemInMainHand().getType() != Material.AIR) {
        // Get special data of item
        NamespacedKey key = new NamespacedKey("geartanks", "item_identifier");
        String customItem = event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.STRING);

        assert customItem != null;

        // If gear
        if (customItem.equals("Gear")) {
          NamespacedKey gearDataKey = new NamespacedKey("geartanks", "gear_data");
          String instructions = event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(gearDataKey, PersistentDataType.STRING);
          GearInterpreter.run(instructions, event.getPlayer());
        }
      }
    }
  }

}
