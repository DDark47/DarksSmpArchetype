package com.mc3699.smparch.archetype.voltage;

import com.mc3699.smparch.SMPArch;
import net.mc3699.provenance.ProvenanceDataHandler;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.thebrokenscript.api.entity.BaseCircuitEntity;
import net.thebrokenscript.api.entity.BaseFeverEntity;
import net.thebrokenscript.api.entity.BaseSiluetEntity;
import net.thebrokenscript.brokencore.impl.registry.BCSoundCategories;
import net.thebrokenscript.entity.tbe.TheBrokenEndAmbushEntity;
import net.thebrokenscript.entity.tbe.TheBrokenEndCuriousEntity;
import net.thebrokenscript.entity.tbe.TheBrokenEndEntity;
import net.thebrokenscript.entity.tbe.TheBrokenEndStalkEntity;
import net.thebrokenscript.registry.TBSSounds;

@EventBusSubscriber(modid = SMPArch.MODID)
public class EventHandlers {
    @SubscribeEvent
    public static void endChase(LivingDeathEvent event) {
        if (!(event.getSource().getDirectEntity() instanceof ServerPlayer player)
            || ProvenanceDataHandler.getAbilities(player).stream().noneMatch(ability -> ability instanceof VoltageChaseAbility)
            || VoltageChaseAbility.CHASED_PLAYERS.isEmpty()) return;
        
        ServerLevel level = player.serverLevel();
        
        level.playSound(null, player.blockPosition(), TBSSounds.THE_END_IS_NEAR.invoke(), BCSoundCategories.BC_CHASE, 1000F, 0.6F);

        VoltageChaseAbility.INSTANCE.chaseEnd();
        player.setGameMode(GameType.SPECTATOR);
    }
    
    @SubscribeEvent
    public static void dropVoidTendrils(LivingDeathEvent event) {
        if (!ModList.get().isLoaded("thebrokenlegacy")
            || !(event.getEntity() instanceof ServerPlayer player)
            || ProvenanceDataHandler.getAmbientAbilities(player).stream().noneMatch(ability -> ability instanceof VoltageAmbient)) return;
        
        ItemStack item = new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("thebrokenlegacy", "void_tendrils")), player.getRandom().nextInt(1,5));
        player.spawnAtLocation(item);
    }
    
    @SubscribeEvent
    public static void onCircuitTarget(LivingChangeTargetEvent event) {
        if (event.getEntity() instanceof BaseCircuitEntity || event.getEntity() instanceof TheBrokenEndEntity || event.getEntity() instanceof TheBrokenEndStalkEntity || event.getEntity() instanceof TheBrokenEndCuriousEntity || event.getEntity() instanceof TheBrokenEndAmbushEntity || event.getEntity() instanceof BaseSiluetEntity || event.getEntity() instanceof BaseFeverEntity) {
            if (!(event.getNewAboutToBeSetTarget() instanceof Player player)) return;
            if (IsChillWithEntities.isChillWithEntities(player)) {
                event.setCanceled(true);
            }
        }
    }
    
}
