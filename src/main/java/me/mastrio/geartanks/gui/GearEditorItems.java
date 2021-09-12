package me.mastrio.geartanks.gui;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public enum GearEditorItems {

  // Buttons, etc.
  BLANK(Material.LIGHT_GRAY_STAINED_GLASS_PANE, " ", " "),

  // Instructions
  PRINT_FUNCTION(Material.PAPER, "Print function", "Prints out stuff to your console");

  // Variables
  private final Material icon;
  private final String name;
  private final List<String> lore;

  // Constructor
  GearEditorItems(Material icon, String name, String... lore) {
    this.icon = icon;
    this.name = name;
    this.lore = Arrays.asList(lore);
  }

  // Get instruction as item method
  public ItemStack asItem() {
    final ItemStack item = new ItemStack(this.icon, 1);
    final ItemMeta meta = item.getItemMeta();

    meta.setDisplayName(this.name);
    meta.setLore(this.lore);
    item.setItemMeta(meta);

    return item;
  }

}
