package me.giodev.spleefarena.listeners;

import com.cryptomorin.xseries.XMaterial;
import me.giodev.spleefarena.commands.spleefarenacommand.subcommands.SetPlayAreaSubCommand;
import me.giodev.spleefarena.data.items.Snowballs;
import me.giodev.spleefarena.utils.WorldGuardUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

  @EventHandler
  public void onBlockBreak(BlockBreakEvent event) {
    if(!WorldGuardUtil.isLocationInRegion(event.getBlock().getLocation(), SetPlayAreaSubCommand.AREA_KEY)) return;

    event.setCancelled(true);
    event.getBlock().setType(XMaterial.AIR.parseMaterial());

    event.getPlayer().getInventory().addItem(Snowballs.getSnowball(1));

  }

}