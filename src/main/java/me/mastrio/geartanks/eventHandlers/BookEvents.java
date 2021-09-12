package me.mastrio.geartanks.eventHandlers;

import me.mastrio.geartanks.ChatLog;
import me.mastrio.geartanks.CompiledGarbage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.persistence.PersistentDataType;

public class BookEvents implements Listener {

  @EventHandler
  public void editBookEvent(PlayerEditBookEvent event) {
    // Get custom item
    NamespacedKey key = new NamespacedKey("geartanks", "item_identifier");
    String customItem = event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.STRING);

    // if the custom item is a gear tank
    assert customItem != null;
    if (customItem.equals("GearTank")) {
      // if the 'book' is being signed
      if (event.isSigning()) {
        event.setCancelled(true);
        ItemStack compiledGear = new ItemStack(Material.WRITTEN_BOOK, 1);
        BookMeta compiledGearMeta = (BookMeta) compiledGear.getItemMeta();
        //compiledGearMeta.setDisplayName(event.getNewBookMeta().getTitle() + );
        compiledGearMeta.setTitle(event.getNewBookMeta().getTitle().toLowerCase().replaceAll(" ", "_") + ".gear");
        compiledGearMeta.setAuthor(event.getPlayer().getName() + " | GearTank");
        compiledGearMeta.addPages(CompiledGarbage.generate(256));
        compiledGearMeta.setCustomModelData(63472);
        compiledGearMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "Gear");
        NamespacedKey gearDataKey = new NamespacedKey("geartanks", "gear_data");
        compiledGearMeta.getPersistentDataContainer().set(gearDataKey, PersistentDataType.STRING, event.getNewBookMeta().getPage(1));
        compiledGear.setItemMeta(compiledGearMeta);
        event.getPlayer().getInventory().addItem(compiledGear);
      }

      // Testing get data
      System.out.println(event.getNewBookMeta().getPage(1));
      event.getPlayer().sendMessage(ChatLog.message(event.getNewBookMeta().getPage(1)));
    }
  }

}
