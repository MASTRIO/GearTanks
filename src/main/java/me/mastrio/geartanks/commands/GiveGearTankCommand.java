package me.mastrio.geartanks.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GiveGearTankCommand implements CommandExecutor {

  @Override
  public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
    if (sender instanceof Player) {
      Player player = (Player) sender;
      NamespacedKey key = new NamespacedKey("geartanks", "item_identifier");
      // Make itemstack pog
      ItemStack copperGearTank = new ItemStack(Material.WRITABLE_BOOK);
      ItemMeta tankMeta = copperGearTank.getItemMeta();
      tankMeta.setDisplayName(ChatColor.stripColor("Copper Gear Tank"));
      tankMeta.setCustomModelData(63471);

      // give it LORE
      List<String> tankLore = new ArrayList<String>();
      tankLore.add(ChatColor.WHITE + ChatColor.stripColor("Allows you to write instructions to be executed"));
      tankLore.add("");
      tankLore.add(ChatColor.BLUE + "" + ChatColor.ITALIC + ChatColor.stripColor("GearTanks"));
      tankMeta.setLore(tankLore);

      // Now give it to the damn player already sheesh
      tankMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
      tankMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "GearTank");
      copperGearTank.setItemMeta(tankMeta);
      player.getInventory().addItem(copperGearTank);
      return true;
    }

    return true;
  }

}
