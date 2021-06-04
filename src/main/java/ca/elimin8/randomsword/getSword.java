package ca.elimin8.randomsword;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class getSword implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("§4You don't have an inventory.");
            return false;
        }
        Player p = (Player) sender;
        if (p.hasPermission("randomsword.get"))
        if (p.getInventory().firstEmpty() == -1) {
            Location loc = p.getLocation();
            World world = p.getWorld();
            world.dropItemNaturally(loc, sword());
            p.sendMessage("§aThe random sword has been dropped near you.");
            return true;
        }
        p.getInventory().addItem(sword());
        p.sendMessage("§aYou have been given the random sword.");
        return false;
    }
    public ItemStack sword() {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§7(Right Click) §2§oNew Enchantment");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        meta.setDisplayName("§9§lRandom Sword");
        item.setItemMeta(meta);
        return item;
    }
}
