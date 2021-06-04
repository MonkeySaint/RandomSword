package ca.elimin8.randomsword;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EventonClick implements Listener {
    private Map<String, Long> cooldown = new HashMap<String, Long>();
    private Enchantment enchantment[] = {
           Enchantment.DAMAGE_ARTHROPODS,
           Enchantment.VANISHING_CURSE,
           Enchantment.FIRE_ASPECT,
           Enchantment.KNOCKBACK,
           Enchantment.LOOT_BONUS_MOBS,
           Enchantment.MENDING,
           Enchantment.DAMAGE_ALL,
            Enchantment.DAMAGE_UNDEAD,
            Enchantment.SWEEPING_EDGE,
            Enchantment.DURABILITY
    };
    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p =(Player) e.getPlayer();
        if (p.getInventory().getItemInMainHand().getType().equals(Material.DIAMOND_SWORD))
            if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§9§lRandom Sword"))
                if (p.getInventory().getItemInMainHand().getItemMeta().hasLore()){
                    if (e.getAction() == Action.RIGHT_CLICK_AIR){
                        if (cooldown.containsKey(p.getName()))
                            if (cooldown.get(p.getName()) > System.currentTimeMillis()) {
                                long timeleft = (cooldown.get(p.getName()) - System.currentTimeMillis()) /1000 + 1;
                                p.sendMessage("§6You can change enchant again in "+timeleft+" second(s)");
                                return;
                            }
                        Random r = new Random();
                        int ench = (r.nextInt(9)+1);
                        for (Enchantment sench : enchantment){
                            if (p.getInventory().getItemInMainHand().getItemMeta().hasEnchants())
                                p.getInventory().getItemInMainHand().removeEnchantment(sench);
                        }
                        cooldown.put(p.getName(), System.currentTimeMillis() + (30000));
                        p.sendMessage("§2Sword has been randomized.");
                        switch (ench){
                            case 1:
                                p.getInventory().getItemInMainHand().addUnsafeEnchantment(enchantment[0], r.nextInt(9)+1);
                                break;
                            case 2:
                                p.getInventory().getItemInMainHand().addUnsafeEnchantment(enchantment[1], r.nextInt(9)+1);
                                break;
                            case 3:
                                p.getInventory().getItemInMainHand().addUnsafeEnchantment(enchantment[2], r.nextInt(9)+1);
                                break;
                            case 4:
                                p.getInventory().getItemInMainHand().addUnsafeEnchantment(enchantment[3], r.nextInt(9)+1);
                                break;
                            case 5:
                                p.getInventory().getItemInMainHand().addUnsafeEnchantment(enchantment[4], r.nextInt(9)+1);
                                break;
                            case 6:
                                p.getInventory().getItemInMainHand().addUnsafeEnchantment(enchantment[5], r.nextInt(9)+1);
                                break;
                            case 7:
                                p.getInventory().getItemInMainHand().addUnsafeEnchantment(enchantment[6], r.nextInt(9)+1);
                                break;
                            case 8:
                                p.getInventory().getItemInMainHand().addUnsafeEnchantment(enchantment[7], r.nextInt(9)+1);
                                break;
                            case 9:
                                p.getInventory().getItemInMainHand().addUnsafeEnchantment(enchantment[8], r.nextInt(9)+1);
                                break;
                            case 10:
                                p.getInventory().getItemInMainHand().addUnsafeEnchantment(enchantment[9], r.nextInt(9)+1);
                                break;
                        }
                    }
                }
    }
}
