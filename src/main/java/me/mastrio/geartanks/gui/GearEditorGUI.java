package me.mastrio.geartanks.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class GearEditorGUI {

  // Variables
  public static Inventory gearEditorGUI;

  // Constructor
  public GearEditorGUI() {
    // Creates the gooey
    gearEditorGUI = Bukkit.createInventory(null, 54, "Campfire");

    // Put the items into the gui
    initializeItems();
  }

  // Put stuff in de gui
  void initializeItems() {
    gearEditorGUI.addItem(GearEditorItems.BLANK.asItem());
    gearEditorGUI.addItem(GearEditorItems.PRINT_FUNCTION.asItem());
    gearEditorGUI.addItem(GearEditorItems.BLANK.asItem());
    gearEditorGUI.addItem(GearEditorItems.PRINT_FUNCTION.asItem());
    gearEditorGUI.addItem(GearEditorItems.BLANK.asItem());
    gearEditorGUI.addItem(GearEditorItems.PRINT_FUNCTION.asItem());
  }

}
